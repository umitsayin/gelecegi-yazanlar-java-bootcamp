package com.turkcell.ecommerce.service.impl;

import com.turkcell.ecommerce.api.request.CreateSalePaymentRequest;
import com.turkcell.ecommerce.api.request.PaymentRequest;
import com.turkcell.ecommerce.api.response.PaymentResponse;
import com.turkcell.ecommerce.entities.Payment;
import com.turkcell.ecommerce.repository.PaymentRepository;
import com.turkcell.ecommerce.service.PaymentService;
import com.turkcell.ecommerce.service.PosService;
import com.turkcell.ecommerce.service.rules.PaymentServiceRules;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final ModelMapper modelMapper;
    private final PaymentRepository repository;
    private final PaymentServiceRules rules;
    private final PosService posService;

    @Override
    public List<PaymentResponse> getAll() {
        List<PaymentResponse> response = repository.findAll().stream()
                .map(payment -> modelMapper.map(payment, PaymentResponse.class))
                .toList();

        return response;
    }

    @Override
    public PaymentResponse getById(int id) {
        rules.checkIfPaymentExistsById(id);

        PaymentResponse response = modelMapper.map(repository.findById(id),PaymentResponse.class);

        return response;
    }

    @Override
    public PaymentResponse add(PaymentRequest request) {
        rules.checkIfPaymentExistsByCardNumber(request.getCardNumber());

        Payment payment = modelMapper.map(request, Payment.class);
        payment.setId(0);
        repository.save(payment);

        PaymentResponse response = modelMapper.map(payment, PaymentResponse.class);

        return response;
    }

    @Override
    public PaymentResponse updateByID(int id, PaymentRequest request) {
        rules.checkIfPaymentExistsById(id);

        Payment payment = modelMapper.map(request, Payment.class);
        payment.setId(id);
        repository.save(payment);

        PaymentResponse response = modelMapper.map(payment, PaymentResponse.class);

        return response;
    }

    @Override
    public void deleteById(int id) {
        rules.checkIfPaymentExistsById(id);
        repository.deleteById(id);
    }

    @Override
    public void processSalePayment(CreateSalePaymentRequest request) {
        rules.checkIfPaymentRequestValid(request);

        Payment payment = repository.findByCardNumber(request.getCardNumber());
        rules.checkIfPaymentBalance(request.getPrice(),request.getCardNumber());

        payment.setBalance(payment.getBalance() - request.getPrice());
        repository.save(payment);

        posService.pay();
    }
}
