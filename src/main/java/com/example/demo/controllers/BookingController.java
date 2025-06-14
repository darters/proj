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
    
}
