package com.example.erafmak.product.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.erafmak.enums.Dimension;
import com.example.erafmak.enums.Granulation;
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
	public String updateProductDimension(@PathVariable("id")Long id, @Param(value = "weigth")Weigth weigth ) {
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
	public String getProductSizesForm(@PathVariable("id")Long id , Model model) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("sizes", enumService.getAllRemainingSizes(id));
		return "sizes";
	}
	
	@PostMapping("/addNewProductSizes/{id}")
	public String addNewSizesToProduct(@PathVariable("id")Long id, @Param("allSizes")List<Size>allSizes) {
		enumService.addNewSizesToProduct(id , allSizes);
		return REDIRECT + id;
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
	
	@PostMapping("/deleteProductNozzle/{id}/{sid}")
	public String deleteProductNozzle(@PathVariable("id")Long id,@PathVariable("sid")Long sid) {
		enumService.deleteNozzleQty(enumService.findNozzleById(sid));
		return REDIRECT + id;
	}
	
	@GetMapping("/addNewProductNozzles/{id}")
	public String getProductNozzlesForm(@PathVariable("id")Long id , Model model) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("nozzles", enumService.getAllRemainingNozzles(id));
		return "nozzles";
	}
	
	@PostMapping("/addNewProductNozzles/{id}")
	public String addNewNozzlesToProduct(@PathVariable("id")Long id, @Param("allNozzles")List<Nozzle>allNozzles) {
		enumService.addNewNozzlesToProduct(id , allNozzles);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductGranulationAvailability/{id}/{sid}")
	public String updateProductGranulationAvailability(@PathVariable("id")Long id,@PathVariable("sid")Long sid) {
		enumService.updateGranulationAvailability(sid);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductGranulationPrice/{id}/{sid}")
	public String updateGranulationPrice(@PathVariable(value = "id")Long id ,@PathVariable(value = "sid")Long sid , @Param(value = "price") Double price) {
		enumService.updateGranulationPrice(sid , price);
		return REDIRECT + id;
	}
	
	@PostMapping("/updateProductGranulationStock/{id}/{sid}")
	public String updateGranulationStock(@PathVariable(value = "id")Long id ,@PathVariable(value = "sid")Long sid , @Param(value = "stock") Integer stock) {
		enumService.updateGranulationStock(sid , stock);
		return REDIRECT + id;
	}
	
	@GetMapping("/addNewProductGranulations/{id}")
	public String getProductGranulationsForm(@PathVariable("id")Long id , Model model) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("granulations", enumService.getAllRemainingGranulations(id));
		return "granulations";
	}
	
	@PostMapping("/addNewProductGranulations/{id}")
	public String addNewGranulationsToProduct(@PathVariable("id")Long id, @Param("allGranulations")List<Granulation>allGranulations) {
		enumService.addNewGranulationsToProduct(id , allGranulations);
		return REDIRECT + id;
	}
	
}
