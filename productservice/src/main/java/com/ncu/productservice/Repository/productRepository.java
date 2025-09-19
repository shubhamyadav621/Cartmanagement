package com.ncu.productservice.Repository;

import com.ncu.productservice.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Product> rowMapper = ( @NonNull ResultSet rs, int rowNum ) -> {
    Product product = new Product();
    product.setId(rs.getLong("id"));
    product.setName(rs.getString("name"));
    product.setPrice(rs.getDouble("price"));
    product.setQuantity(rs.getInt("quantity"));
    return product;
};

    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM Product", rowMapper);
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



/*
GET http://localhost:8080/products
GET http://localhost:8080/products/1
POST http://localhost:8080/products
DELETE http://localhost:8080/products/1


{
  "name": "Smartphone Pro",
  "description": "Android phone with 12GB RAM",
  "price": 32000,
  "quantity": 40
}
*/ 
