package com.turkcell.ecommerce.api.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest {
    @NotNull
    @Size(min = 5, max = 100)
    private String name;

    @NotNull
    @Size(min = 5, max = 100)
    private String description;

    @Min(1)
    private double totalPrice;
}
