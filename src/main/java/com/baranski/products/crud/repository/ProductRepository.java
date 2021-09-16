package com.baranski.products.crud.repository;

import com.baranski.products.crud.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
