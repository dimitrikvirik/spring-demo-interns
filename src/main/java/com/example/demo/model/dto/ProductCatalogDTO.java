package com.example.demo.model.dto;

import lombok.Builder;

@Builder
public record ProductCatalogDTO(Integer id, String name) {
}
