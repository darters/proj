package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Unit;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.UnitRepository;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;
    private final UnitRepository unitRepository;
    public BookingService(BookingRepository bookingRepository, ClientRepository clientRepository, UnitRepository unitRepository) {
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
        this.unitRepository = unitRepository;
    }

    public boolean book(Unit unit) {
        Booking newBooking;
        return false;
    }
}
