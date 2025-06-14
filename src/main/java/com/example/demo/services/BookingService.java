package com.example.demo.services;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Client;
import com.example.demo.entities.Unit;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.UnitRepository;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;
    private final UnitRepository unitRepository;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public BookingService(BookingRepository bookingRepository, ClientRepository clientRepository, UnitRepository unitRepository) {
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
        this.unitRepository = unitRepository;
    }

    public Booking bookUnit(Long clientId, Long unitId, LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate) || startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date range");
        }
        Unit unit = unitRepository.findById(unitId).get();
        boolean isAvailable = bookingRepository.findActiveBookingsByUnitAndDateRange(unitId, startDate, endDate, List.of(com.example.demo.entities.Status.BOOKED, com.example.demo.entities.Status.PAID)).isEmpty();

        if (!isAvailable) {
            throw new RuntimeException("Unit is already booked for the selected dates");
        }

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setUnit(unit);
        booking.setClient(client);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setStatus(com.example.demo.entities.Status.BOOKED);
        booking.setCreatedAt(LocalDateTime.now());

        Booking saved = bookingRepository.save(booking);
        scheduler.schedule(() -> autoCancelIfNotPaid(saved.getId()), 15, TimeUnit.MINUTES);

        return saved;
    }
    private void autoCancelIfNotPaid(Long bookingId) {
        bookingRepository.findById(bookingId).ifPresent(booking -> {
            if (booking.getStatus() == com.example.demo.entities.Status.BOOKED &&
                booking.getCreatedAt().plusMinutes(15).isBefore(LocalDateTime.now())) {
                booking.setStatus(com.example.demo.entities.Status.CANCELLED);
                bookingRepository.save(booking);
            }
        });
    }
    
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
