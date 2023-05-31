package com.example.demo.service;

import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductCatalog;
import com.example.demo.repository.ProductCatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCatalogService {

    private final ProductCatalogRepository productCatalogRepository;


    public void deleteProductCatalogById(Integer id) {
        productCatalogRepository.deleteById(id);
    }

    public ProductCatalog saveProductCatalog(ProductCatalog productCatalog) {
        return productCatalogRepository.save(productCatalog);
    }

    public ProductCatalog getProductCatalogById(Integer id) {
        return productCatalogRepository.findById(id).orElse(null);
    }

    public Page<ProductCatalog> findAll(Pageable pageable) {
        return productCatalogRepository.findAll(pageable);
    }

}
