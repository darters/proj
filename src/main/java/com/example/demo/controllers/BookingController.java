package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingResponse;
import com.example.demo.entities.Booking;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.services.BookingService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/bookings")
@Tag(name = "Booking Controller", description = "Endpoints for managing Bookings")
public class BookingController {
    private final BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
        //   @RequestParam(required = false) Long userId,
        // @RequestParam(required = false) Long unitId,
        // @RequestParam(required = false) LocalDate startDate,
        // @RequestParam(required = false) LocalDate endDate,
        // @RequestParam(defaultValue = "0") int page,
        // @RequestParam(defaultValue = "10") int size
    @GetMapping("/get-all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    
    @PostMapping("/add")
    public Booking addBooking(@RequestParam Long clientId, @RequestParam Long unitId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        Booking newBooking = bookingService.bookUnit(null, null, null, null);
        return newBooking;
    }
    
}
