package com.store.processing.service;

import com.store.processing.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor<T extends Product> {

    private final List<T> products = new ArrayList<>();

    public void addProduct(T product) throws OrderProcessingException {
        if (product == null) {
            throw new OrderProcessingException("Cannot add a null order");
        }
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }

    public void processOrders() {
        for (T product : products) {
            product.displayInfo();
            System.out.println("----------------");
        }
    }
}
