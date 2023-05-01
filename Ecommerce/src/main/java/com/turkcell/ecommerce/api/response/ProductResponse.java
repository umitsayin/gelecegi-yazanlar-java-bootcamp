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
public class ProductResponse {
    private int id;
    private List<CategoryResponse> categories;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private LocalDateTime createdAt;
}
