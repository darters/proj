package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingRequest {
    private Long userId;
    private Long unitId;
    private LocalDate startDate;
    private LocalDate endDate;
}
