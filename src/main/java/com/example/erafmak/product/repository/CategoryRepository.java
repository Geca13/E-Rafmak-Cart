package com.example.erafmak.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.erafmak.product.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
