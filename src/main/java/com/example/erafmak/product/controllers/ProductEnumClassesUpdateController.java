package com.example.erafmak.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.erafmak.enums.Dimension;
import com.example.erafmak.enums.Nozzle;
import com.example.erafmak.enums.Size;
import com.example.erafmak.enums.Weigth;
import com.example.erafmak.product.services.EnumClassesService;
import com.example.erafmak.product.services.ProductService;

@Controller
public class ProductEnumClassesUpdateController {
	
	@Autowired
	EnumClassesService enumService;
	
	@Autowired
	ProductService productService;
	
	private final String REDIRECT = "redirect:/product/";

	@PostMapping("/updateProductDimension/{id}")
	public String updateProductDimension(@PathVariable("id")Long id,@Param(value = "dimension") Dimension dimension ) {
		enumService.updateProductDimension(id , dimension);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductWeigth/{id}")
	public String updateProductDimension(@PathVariable("id")Long id, @Param(value = "dimension")Weigth weigth ) {
		enumService.updateProductWeigth(id , weigth);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductSize/{id}/{sid}")
	public String updateProductSize(@PathVariable("id")Long id,@PathVariable("sid")Long sid, @Param(value = "size")Size size) {
		enumService.updateProductSize(id ,sid, size);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductSizeAvailability/{id}/{sid}")
	public String updateProductSizeAvailability(@PathVariable("id")Long id,@PathVariable("sid")Long sid) {
		enumService.updateProductSizeAvailability(id ,sid);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductSizeStock/{id}/{sid}")
	public String updateProductSizeStock(@PathVariable("id")Long id,@PathVariable("sid")Long sid , @Param(value = "stock")Integer stock) {
		enumService.updateProductSizeStock(id ,sid , stock);
		return REDIRECT + id;
	}
	
	@PostMapping("/deleteProductSize/{id}/{sid}")
	public String deleteProductSize(@PathVariable("id")Long id,@PathVariable("sid")Long sid) {
		enumService.deleteSizeQty(enumService.findSizeById(sid));
		return REDIRECT + id;
	}
	
	@GetMapping("/addNewProductSizes/{id}")
	public String addNewProductSizes(@PathVariable("id")Long id , Model model) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("sizes", enumService.getAllRemainingSizes(id));
		return "sizes";
		
	}
	
	@PostMapping("/updateProductNozzle/{id}/{sid}")
	public String updateProductNozzle(@PathVariable("id")Long id,@PathVariable("sid")Long sid, @Param(value = "nozzle")Nozzle nozzle) {
		enumService.updateProductNozzle(id ,sid, nozzle);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductNozzleAvailability/{id}/{sid}")
	public String updateProductNozzleAvailability(@PathVariable("id")Long id,@PathVariable("sid")Long sid) {
		enumService.updateProductNozzleAvailability(id ,sid);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductNozzleStock/{id}/{sid}")
	public String updateProductNozzleStock(@PathVariable("id")Long id,@PathVariable("sid")Long sid , @Param(value = "stock")Integer stock) {
		enumService.updateProductNozzleStock(id ,sid , stock);
		return REDIRECT + id;
	}
}
