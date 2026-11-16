package com.store.threads;

import com.store.processing.model.Product;
import com.store.processing.model.ProductGenerator;
import com.store.processing.service.OrderProcessor;
import com.store.processing.service.OrderProcessingException;
import com.store.storage.OrderStorage;

public class Main {

    public static void main(String[] args) {

        Product clothing1 = ProductGenerator.generateClothing();
        Product clothing2 = ProductGenerator.generateClothing();

        Product electronics1 = ProductGenerator.generateElectronics();
        Product electronics2 = ProductGenerator.generateElectronics();

        OrderProcessor<Product> processor = new OrderProcessor<>();

        try {
            processor.addProduct(clothing1);
            processor.addProduct(clothing2);
            processor.addProduct(electronics1);
            processor.addProduct(electronics2);
        } catch (OrderProcessingException e) {
            System.err.println("Could not add order: " + e.getMessage());
        }

        System.out.println("=== ORDER PROCESSOR ===");
        processor.processOrders();

        OrderStorage<Product> storage = new OrderStorage<>();

        processor.getProducts().forEach(storage::saveOrder);

        System.out.println("=== ORDER STORAGE ===");
        storage.displayOrders();

        System.out.println("=== MULTITHREADING ===");

        OrderThreadManager manager = new OrderThreadManager();
        manager.processOrders(storage.getAllOrders());

        System.out.println("All orders completed!");
    }
}
