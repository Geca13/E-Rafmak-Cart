package com.example.erafmak.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SubCategoryService subService;
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}
	
	public List<Product> productsBySubCategoryId(Long id){
		
		return productRepository.findBySubCategoryId(id);
		
	}

	public Product getSinglePage(Long id) {
		Product product = getProductById(id);
		return product;
	}
}
