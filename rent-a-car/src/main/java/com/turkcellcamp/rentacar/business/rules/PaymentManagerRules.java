package com.turkcellcamp.rentacar.business.rules;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreatePaymentRequest;
import com.turkcellcamp.rentacar.common.dto.CreateRentalPaymentRequest;
import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.core.exceptions.BusinessException;
import com.turkcellcamp.rentacar.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentManagerRules {
    private final PaymentRepository repository;

    public void checkIfPaymentExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Payment.PAYMENT_NOT_FOUND);
        }
    }

    public void checkIfBalanceIsEnough(double price, double balance) {
        if (balance < price) {
            throw new BusinessException(Messages.Payment.INSUFFICIENT_BALANCE);
        }
    }

    public void checkIfCardExists(CreatePaymentRequest request) {
        if (repository.existsByCardNumber(request.getCardNumber())) {
            throw new BusinessException(Messages.Payment.CARD_NUMBER_ALREADY_EXISTS);
        }
    }

    public void checkIfPaymentIsValid(CreateRentalPaymentRequest request) {
        if (!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        )) {
            throw new BusinessException(Messages.Payment.CARD_INFORMATION_INCORRECT);
        }
    }
}
