package com.ctbe.product_service.service;

import com.ctbe.product_service.dto.ProductRequest;
import com.ctbe.product_service.dto.ProductResponse;
import com.ctbe.product_service.exception.ResourceNotFoundException;
import com.ctbe.product_service.model.Product;
import com.ctbe.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) { 
        this.repo = repo; 
    }

    public List<ProductResponse> findAll() {
        return repo.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ProductResponse findById(Long id) {
        return repo.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ProductResponse create(ProductRequest req) {
        Product p = new Product(req.getName(), req.getPrice(), req.getStockQty(), req.getCategory());
        return mapToResponse(repo.save(p));
    }

    public ProductResponse update(Long id, ProductRequest req) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        existing.setName(req.getName());
        existing.setPrice(req.getPrice());
        existing.setStockQty(req.getStockQty());
        existing.setCategory(req.getCategory());

        return mapToResponse(repo.save(existing));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repo.deleteById(id);
    }

    private ProductResponse mapToResponse(Product p) {
        return new ProductResponse(p.getId(), p.getName(), p.getPrice(), p.getStockQty(), p.getCategory());
    }
}