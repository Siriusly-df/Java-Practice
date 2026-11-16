package com.store.processing.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Clothing extends Product {

    private final String size;
    private final String material;

    @Builder
    public Clothing(
            String name,
            double price,
            String size,
            String material
    ) {
        super(name, price);
        this.size = size;
        this.material = material;
    }
}
