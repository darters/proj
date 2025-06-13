package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.repositories.UnitRepository;

@Service
public class UnitService {
    private final UnitRepository unitRepository;
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
    
}
