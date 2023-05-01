package com.turkcellcamp.rentacar.repository;

import com.turkcellcamp.rentacar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
