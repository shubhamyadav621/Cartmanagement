package com.order.cartm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {

    /*
     * http://localhost:8080/orders/allorders
     */
    @GetMapping("/allorders")
    public String getAllOrders() {
        System.out.println("Hello from order controller!");
        return "All Orders: Order1, Order2, Order3";
    }
// http://localhost:8080/orders/byId/101
@GetMapping("/byId/{orderId}")
public String getOrderById(@PathVariable int orderId) {
    return "Order details for ID: " + orderId;
}

// http://localhost:8080/orders/byRequest?orderId=202
@GetMapping("/byRequest")
public String getOrderByIdFromRequest(@RequestParam int orderId) {
    return "Order details for ID: " + orderId;
}
}