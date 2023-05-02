package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
