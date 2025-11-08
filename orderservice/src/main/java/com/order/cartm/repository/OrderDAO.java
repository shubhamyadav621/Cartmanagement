package com.order.cartm.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.order.cartm.models.Order;

@Repository
public class OrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> findAll() {
        return jdbcTemplate.query("SELECT * FROM orders", new BeanPropertyRowMapper<>(Order.class));
    }

    public Order findById(Long id) {
        List<Order> result = jdbcTemplate.query("SELECT * FROM orders WHERE id = ?", new BeanPropertyRowMapper<>(Order.class), id);
        return result.isEmpty() ? null : result.get(0);
    }

    public int save(Order o) {
        return jdbcTemplate.update("INSERT INTO orders (id, name, quantity) VALUES (?, ?, ?)", o.getId(), o.getName(), o.getQuantity());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM orders WHERE id = ?", id);
    }
    public List<Order> findPaginated(int page, int size) {
    int offset = page * size;
    String sql = "SELECT * FROM orders LIMIT ? OFFSET ?";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), size, offset);
}

public int countTotalOrders() {
    String sql = "SELECT COUNT(*) FROM orders";
    return jdbcTemplate.queryForObject(sql, Integer.class);
}

}
