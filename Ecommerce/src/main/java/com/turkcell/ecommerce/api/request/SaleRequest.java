package com.turkcell.ecommerce.api.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest {
    @NotNull
    @Size(min = 5,max = 50)
    private String description;

    @Min(1)
    private double totalPrice;
    List<Integer> productIds;
    CreateSalePaymentRequest payment;
}
