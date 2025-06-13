package com.example.demo.entities;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enum representing the status of a booking")
public enum Status {
    BOOKED, AVAILABLE, CANCELLED
}
