package com.example.demo.model.dto;

import lombok.Builder;

@Builder
public record ProductDTO(Integer id, String name, Double price, String productCatalogName) {
}
