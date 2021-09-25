package com.example.erafmak.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.erafmak.product.entity.SizeQty;

@Repository
public interface SizeQtyRepository extends JpaRepository<SizeQty, Long> {

	List<SizeQty> findByProductId(Long id);

	boolean existsByProductId(Long id);

}
