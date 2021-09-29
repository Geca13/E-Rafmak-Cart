package com.example.erafmak.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.erafmak.product.entity.Origin;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Long> {

	boolean existsByName(String name);

	Origin findByName(String name);

}
