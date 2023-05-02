package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
