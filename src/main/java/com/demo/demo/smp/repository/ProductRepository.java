package com.demo.demo.smp.repository;

import com.demo.demo.smp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
