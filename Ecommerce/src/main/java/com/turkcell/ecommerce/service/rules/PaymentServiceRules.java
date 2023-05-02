package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.api.request.CreateSalePaymentRequest;
import com.turkcell.ecommerce.constant.ExceptionConstant;
import com.turkcell.ecommerce.exception.BusinessException;
import com.turkcell.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceRules {
    private final PaymentRepository repository;


    public void checkIfPaymentExistsById(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(ExceptionConstant.PAYMENT_NOT_FOUND);
        }
    }

    public void checkIfPaymentExistsByCardNumber(String cardNumber){
        if(repository.existsByCardNumber(cardNumber)){
            throw new BusinessException(ExceptionConstant.PAYMENT_ALREADY_EXISTS);
        }
    }

    public void checkIfPaymentRequestValid(CreateSalePaymentRequest request){
        if(!repository.existsByCardNumberAndCardHolderAndCardCvvAndCardExpirationMonthAndCardExpirationYear(request.getCardNumber(),
                request.getCardHolder(),
                request.getCardCvv(),
                request.getCardExpirationMonth(),
                request.getCardExpirationYear())){
            throw new BusinessException(ExceptionConstant.PAYMENT_IS_NOT_VALID);
        }
    }

    public void checkIfPaymentBalance(double totalPrice, String cardNumber){
        if(repository.findByCardNumber(cardNumber).getBalance() < totalPrice){
            throw new BusinessException(ExceptionConstant.BALANCE_INSUFFICIENT);
        }
    }
}
