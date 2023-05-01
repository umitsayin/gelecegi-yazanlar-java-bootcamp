package com.turkcellcamp.rentacar.repository;

import com.turkcellcamp.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsBrandByNameIgnoreCase(String name);
}
