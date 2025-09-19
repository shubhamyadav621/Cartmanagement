package com.ncu.productservice.services;

import com.ncu.productservice.models.Product;
import com.ncu.productservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id);
    }

    public void addProduct(Product product) {
        repository.save(product);
    }

    public void updateProduct(Product product) {
        repository.update(product);
    }

    public void deleteProduct(Long id) {
        repository.delete(id);
    }
}
