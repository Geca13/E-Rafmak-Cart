package com.example.erafmak.administration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.erafmak.enums.Dimension;
import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Nozzle;
import com.example.erafmak.enums.Size;
import com.example.erafmak.enums.Weigth;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.services.ProductService;
import com.example.erafmak.product.services.SubCategoryService;

@Controller
@RequestMapping("/administration")
public class CreateProductsController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	SubCategoryService subRepository;
	
	@Autowired
	ManufacturerService manufacturerService;
	
	@GetMapping("/newProduct/{id}")
	public String getNewProductPage(Model model , @PathVariable("id") Long id) {
		model.addAttribute("product", new Product());
		model.addAttribute("subCategory", subRepository.subById(id));
		model.addAttribute("manufacturers", manufacturerService.allManufacturers());
        return "newProductPage";
		
	}

	@PostMapping("/newProduct/{id}")
	public String createNewProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product,@RequestParam("fileImage") MultipartFile multiPartFile ) {
		Product newProduct = new Product();
		try {
			productService.createNewProduct(id , newProduct, product , multiPartFile );
        } catch (Exception e) {
			
		}
		return "redirect:/product/" + newProduct.getId() ;
	}
	
	
}
