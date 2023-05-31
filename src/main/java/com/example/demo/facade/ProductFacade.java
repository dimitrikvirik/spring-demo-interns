package com.example.demo.facade;

import com.example.demo.model.dto.ProductDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductCatalog;
import com.example.demo.model.param.ProductParam;
import com.example.demo.service.ProductCatalogService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductService productService;

    private final ProductCatalogService productCatalogService;



    public ProductDTO getProductById(Integer id) {
        Product product = productService.getProductById(id);
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .productCatalogName(product.getProductCatalog().getName())
                .build();
    }

    public ProductDTO saveProduct(ProductParam productParam) {

        Product product = new Product();
        product.setName(productParam.getName());
        product.setPrice(productParam.getPrice());

        ProductCatalog productCatalog = productCatalogService.getProductCatalogById(productParam.getProductCatalogId());
        product.setProductCatalog(productCatalog);

        Product savedProduct = productService.saveProduct(product);
        return ProductDTO.builder()
                .id(savedProduct.getId())
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .productCatalogName(savedProduct.getProductCatalog().getName())
                .build();
    }

    public void deleteProductById(Integer id) {
        productService.deleteProductById(id);
    }

    public ProductDTO updateProduct(Integer id, ProductParam productParam) {
        Product product = productService.getProductById(id);
        product.setName(productParam.getName());
        product.setPrice(productParam.getPrice());
        Product savedProduct = productService.saveProduct(product);

        ProductCatalog productCatalog = productCatalogService.getProductCatalogById(productParam.getProductCatalogId());
        product.setProductCatalog(productCatalog);

        return ProductDTO.builder()
                .id(savedProduct.getId())
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .productCatalogName(savedProduct.getProductCatalog().getName())
                .build();
    }

    public Page<ProductDTO> findAll(Pageable pageable) {
        return productService.findAll(pageable).map(product -> ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .productCatalogName(product.getProductCatalog().getName())
                .build());
    }

}
