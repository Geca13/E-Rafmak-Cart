package com.example.erafmak.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.erafmak.product.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/products/{id}")
	public String getProductsBySubCategoryId(Model model , @PathVariable Long id) {
		model.addAttribute("products", service.productsBySubCategoryId(id));
		return "products";
	}
}
