package com.turkcell.ecommerce.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponse {
    private int id;
    private String description;
    private double totalPrice;
    List<ProductResponse> products;
    private LocalDateTime createdAt;
}
