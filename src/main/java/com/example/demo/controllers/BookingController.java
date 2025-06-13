package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingResponse;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.services.BookingService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;

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
    
    @GetMapping("/get-all")
    public Page<BookingResponse> getAllBookings(
        @RequestParam(required = false) Long userId,
        @RequestParam(required = false) Long unitId,
        @RequestParam(required = false) LocalDate startDate,
        @RequestParam(required = false) LocalDate endDate,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return bookingService.getAllBookings(userId, unitId, startDate, endDate, PageRequest.of(page, size));
    }
    
}
