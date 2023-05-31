package com.example.demo.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductParam {

    private String name;

    private Double price;

    private Integer productCatalogId;
}
