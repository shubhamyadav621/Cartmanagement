package com.ncu.productservice.Repository;

import com.ncu.productservice.models.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product, Long> {
}
