package com.turkcell.ecommerce.service;

import com.turkcell.ecommerce.api.request.CreateSalePaymentRequest;
import com.turkcell.ecommerce.api.request.PaymentRequest;
import com.turkcell.ecommerce.api.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    List<PaymentResponse> getAll();
    PaymentResponse getById(int id);
    PaymentResponse add(PaymentRequest request);
    PaymentResponse updateByID(int id, PaymentRequest request);
    void deleteById(int id);
    void processSalePayment(CreateSalePaymentRequest request);
}
