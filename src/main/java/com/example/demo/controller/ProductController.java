package com.example.demo.controller;


import com.example.demo.facade.ProductFacade;
import com.example.demo.model.dto.ProductDTO;
import com.example.demo.model.param.ProductParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productFacade.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(productFacade.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductParam productParam) {
        return ResponseEntity.ok(productFacade.updateProduct(id, productParam));
    }


    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductParam productParam) {
        return new ResponseEntity<>(productFacade.saveProduct(productParam), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") Integer id) {
        productFacade.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }





}
