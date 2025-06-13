package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {

}
