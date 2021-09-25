package com.example.erafmak.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.product.entity.Category;
import com.example.erafmak.product.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

}
