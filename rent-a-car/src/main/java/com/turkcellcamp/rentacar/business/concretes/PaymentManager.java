package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.PaymentService;
import com.turkcellcamp.rentacar.business.abstracts.PosService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreatePaymentRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreatePaymentResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllPaymentsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetPaymentResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import com.turkcellcamp.rentacar.business.rules.PaymentManagerRules;
import com.turkcellcamp.rentacar.common.dto.CreateRentalPaymentRequest;
import com.turkcellcamp.rentacar.entities.Payment;
import com.turkcellcamp.rentacar.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapper mapper;
    private final PosService posService;
    private final PaymentManagerRules rules;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments = repository.findAll();
        List<GetAllPaymentsResponse> response = payments
                .stream()
                .map(payment -> mapper.map(payment, GetAllPaymentsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetPaymentResponse getById(int id) {
        rules.checkIfPaymentExists(id);

        Payment payment = repository.findById(id).orElseThrow();
        GetPaymentResponse response = mapper.map(payment, GetPaymentResponse.class);

        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        rules.checkIfCardExists(request);

        Payment payment = mapper.map(request, Payment.class);
        payment.setId(0);
        repository.save(payment);

        CreatePaymentResponse response = mapper.map(payment, CreatePaymentResponse.class);

        return response;
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        rules.checkIfPaymentExists(id);

        Payment payment = mapper.map(request, Payment.class);
        payment.setId(id);
        repository.save(payment);

        UpdatePaymentResponse response = mapper.map(payment, UpdatePaymentResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfPaymentExists(id);
        repository.deleteById(id);
    }

    @Override
    public void processRentalPayment(CreateRentalPaymentRequest request) {
        rules.checkIfPaymentIsValid(request);

        Payment payment = repository.findByCardNumber(request.getCardNumber());

        rules.checkIfBalanceIsEnough(request.getPrice(), payment.getBalance());
        posService.pay();

        payment.setBalance(payment.getBalance() - request.getPrice());
        repository.save(payment);
    }
}
