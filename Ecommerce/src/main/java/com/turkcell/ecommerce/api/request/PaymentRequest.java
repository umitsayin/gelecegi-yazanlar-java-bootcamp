package com.turkcell.ecommerce.api.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    @NotNull
    @Size(min = 16,max = 16)
    private String cardNumber;

    @NotNull
    @Size(min = 5, max = 20)
    private String cardHolder;

    @Min(2023)
    private int cardExpirationYear;

    @Min(1)
    private int cardExpirationMonth;

    @Size(min = 3, max = 3)
    private String cardCvv;

    @Min(1)
    private double balance;
}
