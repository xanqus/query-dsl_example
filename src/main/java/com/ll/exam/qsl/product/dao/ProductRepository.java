package com.ll.exam.qsl.product.dao;

import com.ll.exam.qsl.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
