package com.order.cartm.repository;

import com.order.cartm.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }

    public Order findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        List<Order> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), id);
        return result.isEmpty() ? null : result.get(0);
    }

    public int save(Order o) {
        String sql = "INSERT INTO orders (id, name, quantity) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, o.getId(), o.getName(), o.getQuantity());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
