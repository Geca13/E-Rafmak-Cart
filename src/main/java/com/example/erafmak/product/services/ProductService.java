package com.example.erafmak.product.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.erafmak.enums.Dimension;
import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Nozzle;
import com.example.erafmak.enums.Size;
import com.example.erafmak.enums.Weigth;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SubCategoryService subService;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	EnumClassesService enumService;
	
	
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

	public void createNewProduct(Long id, Product product, MultipartFile multiPartFile, Weigth weight, Dimension dimension) throws IOException {
		product.setSubCategory(subService.subById(id));
		product.setId(116L);
		imageService.uploadImage(product, multiPartFile);
		product.setIsAvailable(true);
		productRepository.save(product);
		
		if(weight != null) {
			enumService.newProductWeight(weight, product);
		}
		
		if(dimension != null) {
			enumService.newProductDimension(dimension, product);
		}
		
       
	}
}
