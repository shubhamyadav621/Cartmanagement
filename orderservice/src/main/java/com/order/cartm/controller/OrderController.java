package com.order.cartm.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
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
}
