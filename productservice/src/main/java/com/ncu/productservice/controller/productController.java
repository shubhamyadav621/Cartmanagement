package com.ncu.productservice.controller;

import com.ncu.productservice.models.product;
import com.ncu.productservice.services.productService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {

    private final productService service;

    public productController(productService service) {
        this.service = service;
    }

    @GetMapping
    public List<product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public product getProductById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PostMapping
    public product createProduct(@RequestBody product product) {
        return service.createProduct(product);
    }

    @PutMapping("/{id}")
    public product updateProduct(@PathVariable Long id, @RequestBody product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}
