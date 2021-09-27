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
	
	@GetMapping("/newProduct/{id}")
	public String getNewProductPage(Model model , @PathVariable("id") Long id) {
		model.addAttribute("product", new Product());
		model.addAttribute("subCategory", subRepository.subById(id));
		return "newProductPage";
		
	}

	@PostMapping("/newProduct/{id}")
	public String createNewProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product,@RequestParam("fileImage") MultipartFile multiPartFile,
			@RequestParam("weight") Weigth weight ,@RequestParam("granulations") List<Granulation> granulations ,
			@RequestParam("nozzles")List<Nozzle>nozzles,@RequestParam("sizes")List<Size> sizes) {
		try {
			productService.createNewProduct(id , product , multiPartFile, weight , granulations , nozzles , sizes );
        } catch (Exception e) {
			
		}
		return "redirect:product/"+id;
	}
}
