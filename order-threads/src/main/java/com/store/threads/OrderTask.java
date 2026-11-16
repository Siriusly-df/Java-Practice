package com.store.threads;

import com.store.processing.model.Product;

class OrderTask implements Runnable {

    private final Product product;

    public OrderTask(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        System.out.println(
                "Processing order: " + product.getName()
        );

        product.displayInfo();

        System.out.println(
                "Order processed by: " +
                        Thread.currentThread().getName()
        );
    }
}
