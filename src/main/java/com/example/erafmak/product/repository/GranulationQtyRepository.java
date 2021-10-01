package com.example.erafmak.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.erafmak.enums.Granulation;
import com.example.erafmak.product.entity.GranulationQty;



@Repository
public interface GranulationQtyRepository extends JpaRepository<GranulationQty, Long> {

	List<GranulationQty> findByProductId(Long id);

	boolean existsByProductId(Long id);

	boolean existsByProductIdAndGranulation(Long id, Granulation granulation);

}
