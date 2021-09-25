package com.example.erafmak.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.erafmak.product.services.CategoryService;
import com.example.erafmak.product.services.SubCategoryService;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryService service;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/subCategories/{id}")
	public String getSubCategoriesFromCategory(Model model ,@PathVariable("id") Long id) {
		model.addAttribute("categories", categoryService.allCategories());
		model.addAttribute("subCategories", service.subCategoriesByCategoryId(id));
		return "subCategoriesPage";
	}

}
