package com.example.erafmak.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.erafmak.product.entity.ProductWeight;

@Repository
public interface ProductWeightRepository extends JpaRepository<ProductWeight, Long> {

	ProductWeight findByProducts_Id(Long id);

	boolean existsByProducts_Id(Long id);

}
