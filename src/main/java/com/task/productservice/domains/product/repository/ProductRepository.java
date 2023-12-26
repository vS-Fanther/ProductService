package com.task.productservice.domains.product.repository;

import com.task.productservice.domains.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
