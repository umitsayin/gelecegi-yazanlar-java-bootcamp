package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    boolean existsByCardNumber(String cardNumber);
}
