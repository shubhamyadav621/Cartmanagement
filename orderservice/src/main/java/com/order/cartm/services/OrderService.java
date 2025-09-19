package com.order.cartm.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.cartm.dto.Product;
import com.order.cartm.models.Order;
import com.order.cartm.repository.OrderDAO;

@Service
public class OrderService {

    private final OrderDAO orderDAO;
    private final RestTemplate restTemplate;

    public OrderService(OrderDAO orderDAO, RestTemplate restTemplate) {
        this.orderDAO = orderDAO;
        this.restTemplate = restTemplate;
    }

    public List<Order> getAllOrders() {
        return orderDAO.findAll();
    }

    public Order getOrderById(Long id) {
        return orderDAO.findById(id);
    }

    public boolean saveOrder(Order o) {
        return orderDAO.save(o) > 0;
    }

    public boolean deleteOrder(Long id) {
        return orderDAO.deleteById(id) > 0;
    }

   
    public List<Product> getAllProductsFromProductService() {
        ResponseEntity<List<Product>> response = restTemplate.exchange(
            "http://PRODUCT-SERVICE/products",  
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Product>>() {}
        );
        return response.getBody();
    }
}
