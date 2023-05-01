package com.turkcellcamp.rentacar.repository;

import com.turkcellcamp.rentacar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsByNameIgnoreCase(String name);
}
