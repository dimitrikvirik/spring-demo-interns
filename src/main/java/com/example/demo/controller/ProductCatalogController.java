package com.example.demo.controller;

import com.example.demo.facade.ProductCatalogFacade;
import com.example.demo.model.dto.ProductCatalogDTO;
import com.example.demo.model.param.ProductCatalogParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-catalogs")
@RequiredArgsConstructor
public class ProductCatalogController {

    private final ProductCatalogFacade productCatalogFacade;


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCatalogById(@PathVariable("id") Integer id) {
        productCatalogFacade.deleteProductCatalogById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductCatalogDTO>> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(productCatalogFacade.findAll(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductCatalogDTO> getProductCatalogById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productCatalogFacade.getProductCatalogById(id));
    }

    @PostMapping
    public ResponseEntity<ProductCatalogDTO> saveProductCatalog(@RequestBody ProductCatalogParam productCatalogParam) {
        return ResponseEntity.ok(productCatalogFacade.saveProductCatalog(productCatalogParam));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCatalogDTO> updateProductCatalog(@PathVariable("id") Integer id, @RequestBody  ProductCatalogParam productCatalogParam) {
        return ResponseEntity.ok(productCatalogFacade.updateProductCatalog(id, productCatalogParam));
    }
}
