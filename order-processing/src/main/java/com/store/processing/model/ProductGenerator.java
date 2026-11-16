package com.store.processing.model;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class ProductGenerator {

    private static final Faker faker = new Faker(new Locale("en"));
    private static final Random random = new Random();

    public static Electronics generateElectronics() {
        return Electronics.builder()
                .name(faker.commerce().productName())
                .price(100 + random.nextInt(50000))
                .brand(faker.company().name())
                .warrantyMonths(12 + random.nextInt(25))
                .build();
    }

    public static Clothing generateClothing() {
        return Clothing.builder()
                .name(faker.commerce().productName())
                .price(100 + random.nextInt(5000))
                .size(faker.options().option("S", "M", "L", "XL"))
                .material(faker.options().option(
                        "Cotton", "Wool", "Polyester"
                ))
                .build();
    }
}
