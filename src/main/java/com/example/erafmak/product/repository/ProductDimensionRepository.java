package com.example.erafmak.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erafmak.product.entity.ProductDimension;

public interface ProductDimensionRepository extends JpaRepository<ProductDimension, Long> {

}
