package com.order.cartm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.cartm.dto.Product;
import com.order.cartm.models.Order;
import com.order.cartm.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping("/add")
    public String addOrder(@RequestBody Order o) {
        boolean success = service.saveOrder(o);
        return success ? "Order added successfully!" : "Failed to add order!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        boolean success = service.deleteOrder(id);
        return success ? "Order deleted successfully!" : "Order not found!";
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProductsFromProductService();
    }


    //GET /orders/nextpage?page=0&size=5
    @GetMapping("/nextpage")
public Map<String, Object> getPaginatedOrders(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
    return service.getPaginatedOrders(page, size);
}

}
