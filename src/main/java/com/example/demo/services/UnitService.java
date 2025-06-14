package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Unit;
import com.example.demo.repositories.UnitRepository;

@Service
public class UnitService {
    private final UnitRepository unitRepository;
    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public Unit addUnit(Unit unit) {
        return unitRepository.save(unit);
    }
    public void deleteUnit(Unit unit) {
        unitRepository.delete(unit);
    }
}
