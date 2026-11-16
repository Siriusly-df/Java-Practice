package com.store.threads;

import com.store.processing.model.Product;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderThreadManager {

    public void processOrders(List<? extends Product> products) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        products.forEach(product ->
                executor.submit(new OrderTask(product))
        );

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
