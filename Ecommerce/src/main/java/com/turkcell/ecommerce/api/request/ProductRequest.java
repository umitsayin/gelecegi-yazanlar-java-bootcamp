package com.turkcell.ecommerce.api.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class ProductRequest {
    private List<Integer> categoryIds;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Min(1)
    private int quantity;


    @Min(1)
    private double unitPrice;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 150)
    private String description;
}
