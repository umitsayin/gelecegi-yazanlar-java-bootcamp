package com.turkcell.ecommerce.service.impl;

import com.turkcell.ecommerce.api.request.CreateSalePaymentRequest;
import com.turkcell.ecommerce.api.request.PaymentRequest;
import com.turkcell.ecommerce.api.response.PaymentResponse;
import com.turkcell.ecommerce.repository.PaymentRepository;
import com.turkcell.ecommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final ModelMapper modelMapper;
    private final PaymentRepository repository;

    @Override
    public List<PaymentResponse> getAll() {
        return null;
    }

    @Override
    public PaymentResponse getById(int id) {
        return null;
    }

    @Override
    public PaymentResponse add(PaymentRequest request) {
        return null;
    }

    @Override
    public PaymentResponse updateByID(int id, PaymentRequest request) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void processSalePayment(CreateSalePaymentRequest request) {

    }
}
