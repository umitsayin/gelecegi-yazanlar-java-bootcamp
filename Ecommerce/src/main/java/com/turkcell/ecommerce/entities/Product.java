package com.turkcell.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;

    @ManyToMany
    private Set<Category> categories = new HashSet<>();
}
