package com.turkcell.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale extends BaseEntity{
    private String description;
    private double totalPrice;

    @OneToOne
    private Invoice invoice;

    @OneToMany
    private List<Product> products = new ArrayList<>();
}
