package com.turkcell.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends BaseEntity{
    private String description;
    private String totalPrice;

    @OneToOne(mappedBy = "invoice")
    private Sale sale;
}
