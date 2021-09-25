package com.example.erafmak.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.product.entity.Category;
import com.example.erafmak.product.entity.SubCategory;
import com.example.erafmak.product.repository.CategoryRepository;
import com.example.erafmak.product.repository.SubCategoryRepository;

@Service
public class SubCategoryService {
	
	@Autowired
	SubCategoryRepository subRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	public SubCategory subById(Long id) {
		return subRepository.findById(id).get();
	}
	
	public List<SubCategory> subCategoriesByCategoryId(Long id){
		Category category = categoryRepository.findById(id).get();
		return category.getSubs();
	}
}
