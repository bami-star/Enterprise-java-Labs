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
        // This code runs automatically when the app starts
        if (productRepository.count() == 0) {
            // We removed the "name:" and "price:" labels because Java doesn't allow them in the code
            productRepository.save(new Product("Laptop", 1200.00));
            productRepository.save(new Product("Smartphone", 800.00));
            productRepository.save(new Product("Headphones", 150.00));
            
            System.out.println("Data Seeding Complete: 3 products added.");
        }
    }
}