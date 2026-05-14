package com.codtech.AIRecommendationSystem;

import java.util.HashMap;
import java.util.Map;

public class ProductStore {

    public static Map<Long, Product> getProducts() {

        Map<Long, Product> products = new HashMap<>();
        products.put(101L, new Product(101, "Laptop", 55000));
        products.put(102L, new Product(102, "Smartphone", 25000));
        products.put(103L, new Product(103, "Headphones", 3000));
        products.put(104L, new Product(104, "Smart Watch", 7000));
        products.put(105L, new Product(105, "Gaming Mouse", 1500));
        products.put(106L, new Product(106, "Keyboard", 2000));
        products.put(107L, new Product(107, "Bluetooth Speaker", 3500));
        products.put(108L, new Product(108, "Tablet", 18000));
        products.put(109L, new Product(109, "Monitor", 12000));
        products.put(110L, new Product(110, "Printer", 8000));
        products.put(111L, new Product(111, "External Hard Disk", 5000));
        products.put(112L, new Product(112, "Webcam", 2500));
        return products;
    }
}
