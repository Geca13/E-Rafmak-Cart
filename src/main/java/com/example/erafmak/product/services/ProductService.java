package com.example.erafmak.product.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.erafmak.administration.ManufacturerService;
import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Nozzle;
import com.example.erafmak.enums.Size;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.entity.SubCategory;
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
	
	@Autowired
	ManufacturerService manService;
	
	
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
	
	public Product findProductById(Long id) {
		return productRepository.findById(id).get();
	}
	
	public void deleteProduct(Long id) {
		
		Product product = productRepository.findById(id).get();
		deleteImage(product);
		product.setManufacturer(null);
		product.setProducts(null);
		
		productRepository.delete(product);
	}

	private void deleteImage(Product product) {
		String storedImage = product.getImageUrl().substring(product.getImageUrl().lastIndexOf("/"));
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		
		String uploadDir = absolutePath + "/src/main/resources/static/img/coats/";
		
            File file = new File(uploadDir + storedImage);
            if(file.exists()) {
            	file.delete();
            }    
	}
	
	public List<Product> coats() {
		return productRepository.findAll();
	}
	
	/*
	public List<Coat> reducedCoats(Long id) {
		
		List<Coat> reduced = new ArrayList<>();
		List<Coat> coats = coats();
		for (Coat coat : coats) {
			if(!productRepository.existsByNameAndHardeners_Id(coat.getName(),id)) {
				reduced.add(coat);
			}
		}
		return reduced;
	}
	*/
	
	public Product updatePrice(Long id, Double price) {
		Product product = findProductById(id);
		product.setPrice(price);
		return productRepository.save(product);
	}

	public Product updateProductName(Long id, String name) {
	
		Product product = findProductById(id);
		product.setName(name);
		return productRepository.save(product);
	}
	
	public Product updateProductDescription(Long id, String description) {
	
		Product product = findProductById(id);
		product.setDescription(description);
		return productRepository.save(product);
	}
    
	public Product updateManufacturer(Long id, String manufacturer) {
	
		Product product = findProductById(id);
		product.setManufacturer(manService.findByName(manufacturer));
		return productRepository.save(product);
	}

	public Product updateProductAvailability(Long id) {
	
		Product product = findProductById(id);
		product.setIsAvailable(!product.getIsAvailable());
		return productRepository.save(product);
	}

	public Product updateProductImage(Long id, MultipartFile multiPartFile) throws IOException {
		
		Product product = findProductById(id);
		deleteImage(product);
		
		try {
			imageService.uploadImage(product, multiPartFile);
		} catch (IOException e) {
			throw new IOException("Something went wrong during image upload, please try again");
		}
		return productRepository.save(product);
	}

	

	public void disconectProductFromProductList(Long id, Long hid) {
	
		Product product = findProductById(id);
		product.getProducts().remove(findProductById(hid));
		productRepository.save(product);
	}
}
