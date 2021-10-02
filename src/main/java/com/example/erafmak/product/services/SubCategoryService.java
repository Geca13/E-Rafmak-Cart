package com.example.erafmak.product.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.erafmak.product.entity.Category;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.entity.SubCategory;
import com.example.erafmak.product.repository.CategoryRepository;
import com.example.erafmak.product.repository.SubCategoryRepository;

@Service
public class SubCategoryService {
	
	@Autowired
	SubCategoryRepository subRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductService productService;
	

	public SubCategory subById(Long id) {
		return subRepository.findById(id).get();
	}
	
	public List<SubCategory> subCategoriesByCategoryId(Long id){
		Category category = categoryRepository.findById(id).get();
		return category.getSubs();
	}
	
	public List<SubCategory> allSubCategories() {
		return subRepository.findAll();
		
	}

	public List<Product> findProductsBySubCategory(Long id) {
		Product product = productService.findProductById(id);
		if(product.getSubCategory().getId() == 1L || product.getSubCategory().getId() == 2L || product.getSubCategory().getId() == 3L || product.getSubCategory().getId() == 4L || product.getSubCategory().getId() == 5L) {
		return productService.productsBySubCategoryId(13L);
		    }
		
		if(product.getSubCategory().getId() == 12L) {
			return productService.productsBySubCategoryId(11L);
			}
		
		if(product.getSubCategory().getId() == 17L) {
			return productService.productsBySubCategoryId(16L);
			}
		if(product.getSubCategory().getId() == 9L) {
			List<Product> products = new ArrayList<>();
			
			List<Product> coats = productService.productsBySubCategoryId(6L);
			for (Product product1 : coats) {
				products.add(product1);
			}
			List<Product> primers = productService.productsBySubCategoryId(7L);
			for (Product product2 : primers) {
				products.add(product2);
			}
			return products;
			}
		
		return null;
	}

	public void connectProductToProductList(Long id, List<Product> allProducts) {
		Product toConnect = productService.findProductById(id);
		for (Product product : allProducts) {
			product.getProducts().add(toConnect);
			productService.saveProduct(product);
		}
		
	}

	public void disconnectProductFromList(Long id, Long pid) {
		Product product = productService.findProductById(id);
		product.getProducts().remove(productService.findProductById(pid));
		productService.saveProduct(product);
	}
	
	
}
