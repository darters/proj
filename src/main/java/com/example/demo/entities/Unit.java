package com.example.demo.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@Schema(description = "Unit that can be booked, such as a home, flat, or apartment")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfRooms;
    @Enumerated(EnumType.STRING)
    private AccommodationType accommodationType;
    private int floor;
    private String description;
    private float basePrice;
    private float priceWithMarkup;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Client owner;
}
