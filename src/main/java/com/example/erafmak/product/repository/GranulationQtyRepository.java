package com.example.erafmak.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.erafmak.product.entity.GranulationQty;



@Repository
public interface GranulationQtyRepository extends JpaRepository<GranulationQty, Long> {

}
