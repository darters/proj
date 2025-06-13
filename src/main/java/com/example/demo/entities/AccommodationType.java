package com.example.demo.entities;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enum defining available types of accommodation")
public enum AccommodationType {
    HOME, FLAT, APARTMENTS
}
