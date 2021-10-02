package com.example.erafmak.product.services;


import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.erafmak.administration.ManufacturerService;
import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Nozzle;
import com.example.erafmak.enums.Size;
import com.example.erafmak.product.entity.GranulationQty;
import com.example.erafmak.product.entity.NozzleQty;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.entity.ProductDimension;
import com.example.erafmak.product.entity.ProductWeight;
import com.example.erafmak.product.entity.SizeQty;
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
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
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
		
		saveProduct(newProduct);
		
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
		imageService.deleteImage(product);
		product.setManufacturer(null);
		product.setProducts(null);
	    deleteGranulations(id);
		deleteSizes(id);
		deleteNozzles(id);
		deleteProductWeight(id);
		deleteProductDimension(id);
		productRepository.delete(product);
	}

	private void deleteProductDimension(Long id) {
		ProductDimension dimension = enumService.findDimensionByProductId(id);
		if(dimension != null) {
			enumService.deleteProductDimension(dimension);
		}
		
	}

	private void deleteProductWeight(Long id) {
		ProductWeight weight = enumService.findWeightByProductId(id);
		if(weight !=null) {
			enumService.deleteProductWeight(weight);
		}
		
	}

	private void deleteNozzles(Long id) {
		List<NozzleQty> nozzles = enumService.findNozzleByProductId(id);
		if(nozzles != null) {
		for (NozzleQty nozzleQty : nozzles) {
			enumService.deleteNozzleQty(nozzleQty);
		   }
	    }
		
	}

	private void deleteSizes(Long id) {
		List<SizeQty> sizes = enumService.findSizeByProductId(id);
		if(sizes != null) {
			for (SizeQty sizeQty : sizes) {
				enumService.deleteSizeQty(sizeQty);
			}
		}
		
	}

	private void deleteGranulations(Long id) {
		List<GranulationQty> gran = enumService.findGranulationByProductId(id);
		if(gran != null) {
			for (GranulationQty granulationQty : gran) {
				enumService.deleteGranulationQty(granulationQty);
			}
		}
	}


	
	public List<Product> products() {
		return productRepository.findAll();
	}
	
	
	public Product updatePrice(Long id, Double price) {
		Product product = findProductById(id);
		product.setPrice(price);
		return saveProduct(product);
	}

	public Product updateProductName(Long id, String name) {
	
		Product product = findProductById(id);
		product.setName(name);
		return saveProduct(product);
	}
	
	public Product updateProductDescription(Long id, String description) {
	
		Product product = findProductById(id);
		product.setDescription(description);
		return saveProduct(product);
	}
    
	public Product updateManufacturer(Long id, String manufacturer) {
	
		Product product = findProductById(id);
		product.setManufacturer(manService.findByName(manufacturer));
		return saveProduct(product);
	}

	public Product updateProductAvailability(Long id) {
	
		Product product = findProductById(id);
		product.setIsAvailable(!product.getIsAvailable());
		return saveProduct(product);
	}

	public Product updateProductImage(Long id, MultipartFile multiPartFile) throws IOException {
		
		Product product = findProductById(id);
		imageService.deleteImage(product);
		String fileName = StringUtils.cleanPath(multiPartFile.getOriginalFilename());
		product.setImageUrl("/images/" + fileName);
		try {
			imageService.uploadImage( multiPartFile);
		} catch (IOException e) {
			throw new IOException("Something went wrong during image upload, please try again");
		}
		return saveProduct(product);
	}

	public void disconectProductFromProductList(Long id, Long hid) {
	
		Product product = findProductById(id);
		product.getProducts().remove(findProductById(hid));
		saveProduct(product);
	}
}
