package com.store.processing.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Electronics extends Product {

    private String brand;
    private int warrantyMonths;

    @Builder
    public Electronics(
            String name,
            double price,
            String brand,
            int warrantyMonths
    ) {
        super(name, price);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }
}
