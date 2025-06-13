package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingResponse {
    private Long bookingId;
    private Long userId;
    private Long unitId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean paid;
    private boolean cancelled;
}
