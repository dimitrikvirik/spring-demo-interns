package com.example.demo.facade;

import com.example.demo.model.dto.ProductCatalogDTO;
import com.example.demo.model.entity.ProductCatalog;
import com.example.demo.model.param.ProductCatalogParam;
import com.example.demo.service.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCatalogFacade {


    private final ProductCatalogService productCatalogService;

    public void deleteProductCatalogById(Integer id) {
        productCatalogService.deleteProductCatalogById(id);
    }


    public ProductCatalogDTO saveProductCatalog(ProductCatalogParam productCatalogParam) {

        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setName(productCatalogParam.getName());

        ProductCatalog savedProductCatalog = productCatalogService.saveProductCatalog(productCatalog);
        return ProductCatalogDTO.builder()
                .id(savedProductCatalog.getId())
                .name(savedProductCatalog.getName())
                .build();
    }

    public ProductCatalogDTO getProductCatalogById(Integer id) {
        ProductCatalog productCatalog = productCatalogService.getProductCatalogById(id);
        return ProductCatalogDTO.builder()
                .id(productCatalog.getId())
                .name(productCatalog.getName())
                .build();
    }

    public Page<ProductCatalogDTO> findAll(Pageable pageable) {
        return productCatalogService.findAll(pageable)
                .map(productCatalog -> ProductCatalogDTO.builder()
                        .id(productCatalog.getId())
                        .name(productCatalog.getName())
                        .build());
    }

    public ProductCatalogDTO updateProductCatalog(Integer id, ProductCatalogParam productCatalogParam) {
        ProductCatalog productCatalog = productCatalogService.getProductCatalogById(id);
        productCatalog.setName(productCatalogParam.getName());
        ProductCatalog savedProductCatalog = productCatalogService.saveProductCatalog(productCatalog);
        return ProductCatalogDTO.builder()
                .id(savedProductCatalog.getId())
                .name(savedProductCatalog.getName())
                .build();
    }




}
