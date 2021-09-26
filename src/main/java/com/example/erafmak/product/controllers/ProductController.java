package com.example.erafmak.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.erafmak.product.services.CategoryService;
import com.example.erafmak.product.services.EnumClassesService;
import com.example.erafmak.product.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	EnumClassesService enumService;
	
	@GetMapping("/products/{id}")
	public String getProductsBySubCategoryId(Model model , @PathVariable("id") Long id) {
		model.addAttribute("categories", categoryService.allCategories());
		model.addAttribute("products", service.productsBySubCategoryId(id));
		return "products";
	}
	
	@GetMapping("/product/{id}")
	public String getSingleProductPage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("categories", categoryService.allCategories());
		model.addAttribute("product", service.getSinglePage(id));
		model.addAttribute("granulations", enumService.findGranulationByProductId(id));
		model.addAttribute("sizes", enumService.findSizeByProductId(id));
		model.addAttribute("weight", enumService.findWeightByProductId(id));
		model.addAttribute("nozzles", enumService.findNozzleByProductId(id));
		return "singleProductPage";
	}
	
	
}
