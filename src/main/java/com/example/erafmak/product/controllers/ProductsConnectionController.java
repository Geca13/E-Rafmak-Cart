package com.example.erafmak.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.services.ProductService;
import com.example.erafmak.product.services.SubCategoryService;

@Controller
public class ProductsConnectionController {

	@Autowired
	ProductService productService;
	
	@Autowired
	SubCategoryService subService;
	
	@GetMapping("/connectProductToList/{id}")
	public String connectProductWithProductList(Model model ,@PathVariable("id") Long id) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("products", subService.findProductsBySubCategory(id));
		return "productList";
	}
	
	@PostMapping("/connectProductToList/{id}")
	public String completeConnection(@PathVariable("id") Long id, @RequestParam("allProducts")List<Product> allProducts ) {
		subService.connectProductToProductList(id , allProducts);
		return "redirect:/product/"+id;
	}
	
	@PostMapping("/disconnectProductFromProductList/{id}/{pid}")
	public String disconnectProduct(@PathVariable("id")Long id,@PathVariable("pid")Long pid) {
		subService.disconnectProductFromList(id , pid);
		return "redirect:/product/"+id;
	}
}
