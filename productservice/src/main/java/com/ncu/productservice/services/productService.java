package com.ncu.productservice.services;

import com.ncu.productservice.models.product;
import com.ncu.productservice.Repository.productRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {

    private final productRepository Repository;

    public productService(productRepository Repository) {
        this.Repository = Repository;
    }

    public List<product> getAllProducts() {
        return Repository.findAll();
    }

    public product getProductById(Long id) {
        return Repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public product createProduct(product product) {
        return Repository.save(product);
    }

    public product updateProduct(Long id, product product) {
        product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        return Repository.save(existing);
    }

    public void deleteProduct(Long id) {
        Repository.deleteById(id);
    }
}
