package com.order.cartm.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.order.cartm.models.Order;
import com.order.cartm.repository.OrderDAO;

@Service
public class OrderService {

    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
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
}
