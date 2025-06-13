package com.example.demo.entities;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@Schema(description = "Booking record representing a reservation of a Unit")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate createdAt;
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;
}
