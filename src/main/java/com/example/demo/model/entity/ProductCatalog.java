package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "product_catalog")
@Getter
@Setter
@NoArgsConstructor
public class ProductCatalog {

        @Id
        @GeneratedValue
        @Column(name = "id", nullable = false)
        private Integer id;

        @Column(name = "name", nullable = false)
        private String name;

        @OneToMany(mappedBy = "productCatalog")
        private List<Product> products;


}
