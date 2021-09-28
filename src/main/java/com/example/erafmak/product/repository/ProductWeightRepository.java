package com.example.erafmak.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.erafmak.product.entity.ProductWeight;

@Repository
public interface ProductWeightRepository extends JpaRepository<ProductWeight, Long> {

	ProductWeight findByProductId(Long id);

	boolean existsByProductId(Long id);

}
