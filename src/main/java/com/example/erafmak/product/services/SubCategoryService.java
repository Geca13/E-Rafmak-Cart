package com.example.erafmak.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.product.entity.SubCategory;
import com.example.erafmak.product.repository.SubCategoryRepository;

@Service
public class SubCategoryService {
	
	@Autowired
	SubCategoryRepository subRepository;
	

	public SubCategory subById(Long id) {
		return subRepository.findById(id).get();
	}
}
