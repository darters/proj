package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Unit;
import com.example.demo.services.UnitService;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/units")
public class UnitController {
    private final UnitService unitService;
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/get/{id}")    
    public Unit getUnit(@PathVariable Long id) {
        Optional<Unit> unit = unitService.getUnitById(id);
        return unit.get();
    }
    @PostMapping("/add")
    public Unit addUnit(@RequestBody Unit unit) {
        Unit newUnit = unitService.addUnit(unit);        
        return newUnit;
    }
}
