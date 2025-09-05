package com.ncu.productservice.Repository;

import com.ncu.productservice.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Product> rowMapper = new RowMapper<>() {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setQuantity(rs.getInt("quantity"));
            return product;
        }
    };

    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM product", rowMapper);
    }

    public Product findById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM product WHERE id = ?",
            rowMapper, id
        );
    }

    public int save(Product product) {
        return jdbcTemplate.update(
            "INSERT INTO product (name, description, price, quantity) VALUES (?, ?, ?, ?)",
            product.getName(), product.getDescription(), product.getPrice(), product.getQuantity()
        );
    }

    public int update(Product product) {
        return jdbcTemplate.update(
            "UPDATE product SET name = ?, description = ?, price = ?, quantity = ? WHERE id = ?",
            product.getName(), product.getDescription(), product.getPrice(), product.getQuantity(), product.getId()
        );
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }
}
