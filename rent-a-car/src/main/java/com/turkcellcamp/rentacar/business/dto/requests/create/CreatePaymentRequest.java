package com.turkcellcamp.rentacar.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import com.turkcellcamp.rentacar.business.dto.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest extends PaymentRequest {
    @Min(value = 1)
    private double balance;
}
