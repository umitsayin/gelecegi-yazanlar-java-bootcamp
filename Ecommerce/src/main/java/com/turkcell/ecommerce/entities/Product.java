package com.turkcell.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
}
