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

	public void createNewProduct(Long id,Product newProduct, Product product,  MultipartFile multiPartFile) throws IOException {
		
		SubCategory sub = subService.subById(id);
		newProduct.setManufacturer(product.getManufacturer());
		newProduct.setDescription(product.getDescription());
		newProduct.setSubCategory(sub);
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		newProduct.setName(product.getName());
		newProduct.setImageUrl("/images/" + fileName);
		imageService.uploadImage(multiPartFile);
		newProduct.setIsAvailable(true);
		if(product.getPrice() !=null) {
		newProduct.setPrice(product.getPrice());
		}
		
		productRepository.save(newProduct);
		
		if(product.getWeigth()!= null) {
			enumService.newProductWeight(product.getWeigth(), newProduct);
		}
		
		if(product.getDimension() != null) {
			enumService.newProductDimension(product.getDimension(), newProduct);
		}
		
        if(product.getGranulations() != null) {
			for (Granulation granulation : product.getGranulations()) {
				enumService.newGranulationQty(granulation,newProduct);
			}
			
		}

        if(product.getNozzles() != null) {
	        for (Nozzle nozzle : product.getNozzles()) {
	        	enumService.newNozzleQty(nozzle,newProduct);
			}
        }
		
        if(product.getSizes() != null) {
			for (Size size : product.getSizes() ) {
				enumService.newSizeQty(size,newProduct);
			}
		}
        
	}
}
