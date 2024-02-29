package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BusModel;

public interface BusRepository extends JpaRepository<BusModel,Integer> {

    
}
