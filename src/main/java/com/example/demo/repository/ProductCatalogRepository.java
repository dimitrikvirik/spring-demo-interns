package com.example.demo.repository;

import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Integer> {
}
