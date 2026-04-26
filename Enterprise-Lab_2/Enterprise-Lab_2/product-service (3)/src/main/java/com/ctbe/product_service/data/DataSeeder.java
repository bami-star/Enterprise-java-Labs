package com.ctbe.product_service.data;

import com.ctbe.product_service.model.Product;
import com.ctbe.product_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Lab 2: Check if database is empty before seeding
        if (productRepository.count() == 0) {
            
            // We are adding Name, Price, Stock Quantity, and Category
            productRepository.save(new Product("Laptop", 1200.00, 10, "Electronics"));
            productRepository.save(new Product("Smartphone", 800.00, 25, "Electronics"));
            productRepository.save(new Product("Headphones", 150.00, 50, "Accessories"));
            productRepository.save(new Product("Desk Chair", 200.00, 15, "Furniture"));
            
            System.out.println("--------------------------------os");
            System.out.println("LAB 2: Data Seeding Complete!");
            System.out.println("Added products with Category and Stock levels.");
            System.out.println("--------------------------------");
        }
    }
}