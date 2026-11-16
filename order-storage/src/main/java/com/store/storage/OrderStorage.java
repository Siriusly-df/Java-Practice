package com.store.storage;

import com.store.processing.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage<T extends Product> {

    private final List<T> orders = new ArrayList<>();

    public void saveOrder(T product) {
        orders.add(product);
    }

    public List<T> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public void displayOrders() {
        for (T product : orders) {
            product.displayInfo();
            System.out.println("----------------");
        }
    }
}