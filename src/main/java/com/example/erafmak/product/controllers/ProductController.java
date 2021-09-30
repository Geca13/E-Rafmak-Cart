package com.example.erafmak.product.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.erafmak.administration.ManufacturerService;
import com.example.erafmak.product.services.CategoryService;
import com.example.erafmak.product.services.EnumClassesService;
import com.example.erafmak.product.services.ProductService;


@Controller
public class ProductController {
	
	private final String REDIRECT = "redirect:/product/";

	@Autowired
	ProductService service;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	EnumClassesService enumService;
	
	@Autowired
	ManufacturerService manService;
	
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
		model.addAttribute("dimension", enumService.findDimensionByProductId(id));
		model.addAttribute("nozzles", enumService.findNozzleByProductId(id));
		model.addAttribute("manufacturers", manService.allManufacturers());
		return "singleProductPage";
	}
	
	@PostMapping("/updateProductPrice/{id}")
	public String updateCoatPrice(@PathVariable(value = "id")Long id , @Param(value = "price") Double price) {
		service.updatePrice(id , price);
		return REDIRECT + id+"?price";
	}
	
	@PostMapping("/updateProductName/{id}")
	public String updateProductName(@PathVariable(value = "id")Long id , @Param(value = "name") String name) {
		service.updateProductName(id , name);
		return REDIRECT + id+"?name";
	}
	
	@PostMapping("/updateProductDescription/{id}")
	public String updateProductDescription(@PathVariable(value = "id")Long id , @Param(value = "description") String description) {
		service.updateProductDescription(id , description);
		return REDIRECT + id+"?description";
	}
	/*
	@PostMapping("/updateProductWeight/{id}")
	public String updateProductWeight(@PathVariable("id")Long id, @Param(value = "weigth")Weigth weigth) {
		service.updateProductWeight(id, weigth);
		return REDIRECT + id+"?weight";
	}
	*/
	@PostMapping("/updateProductManufacturer/{id}")
	public String updateProductManufactorer(@PathVariable(value = "id")Long id , @Param(value = "manufacturer")String manufacturer) {
		service.updateManufacturer(id , manufacturer);
		return REDIRECT + id+"?manufacturer";
	}
	
	
	@PostMapping("/setAvailabilityToProduct/{id}")
	public String updateAvailabilityToCoat(@PathVariable(value = "id")Long id ) {
		service.updateProductAvailability(id);
		return REDIRECT + id+"?available";
	}
	
	@PostMapping("/updateProductImage/{id}")
	public String updateImageToCoat(Model model , @PathVariable(value = "id")Long id, @RequestParam("fileImage") MultipartFile multiPartFile) throws IOException {
		try {
			service.updateProductImage(id , multiPartFile);
		} catch (IOException e) {
			model.addAttribute("product", service.findProductById(id)) ;
			model.addAttribute("manufacturers", manService.allManufacturers()) ;
			model.addAttribute("error", e.getMessage());
			return "singleProductPage";
		}
		return REDIRECT + id+"?image";
	}
	
	@PostMapping("/disconectHarterFromProductList/{id}/{hid}")
	public String disconnectHardener(@PathVariable("id")Long id,@PathVariable ("hid") Long hid) {
		service.disconectProductFromProductList(id, hid);
		return REDIRECT + id+"?disconnect";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id")Long id) {
		service.deleteProduct(id);
		return REDIRECT + id+"?delete";
	}
}
