package com.turkcell.ecommerce.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {
    private int id;
    private String description;
    private String categoryName;
    private String productName;
    private String totalPrice;
    private SaleResponse sale;
    private LocalDateTime createdAt;
}
