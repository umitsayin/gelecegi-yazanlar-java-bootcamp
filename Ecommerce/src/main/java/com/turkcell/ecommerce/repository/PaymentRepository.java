package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByCardNumber(String cardNumber);
    boolean existsByCardNumber(String cardNumber);
    boolean existsByCardNumberAndCardHolderAndCardCvvAndCardExpirationMonthAndCardExpirationYear(String cardNumber,
                                                                                                  String cardHolder,
                                                                                                  String cardCvv,
                                                                                                  int cardExpirationMonth,
                                                                                                  int cardExpirationYear);
}
