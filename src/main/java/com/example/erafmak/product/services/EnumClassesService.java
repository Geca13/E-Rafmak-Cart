package com.example.erafmak.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.enums.Dimension;
import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Nozzle;
import com.example.erafmak.enums.Size;
import com.example.erafmak.enums.Weigth;
import com.example.erafmak.product.entity.GranulationQty;
import com.example.erafmak.product.entity.NozzleQty;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.entity.ProductDimension;
import com.example.erafmak.product.entity.ProductWeight;
import com.example.erafmak.product.entity.SizeQty;
import com.example.erafmak.product.repository.GranulationQtyRepository;
import com.example.erafmak.product.repository.NozzleQtyRepository;
import com.example.erafmak.product.repository.ProductDimensionRepository;
import com.example.erafmak.product.repository.ProductWeightRepository;
import com.example.erafmak.product.repository.SizeQtyRepository;

@Service
public class EnumClassesService {
	
	@Autowired
	GranulationQtyRepository granRepository;
	
	@Autowired
	NozzleQtyRepository nozzleRepository;
	
	@Autowired
	ProductWeightRepository weightRepository;
	
	@Autowired
	SizeQtyRepository sizeRepository;
	
	@Autowired
	ProductDimensionRepository dimensionRepository;
	
	public List<GranulationQty> findGranulationByProductId(Long id) {
		if(granRepository.existsByProductId(id)) {
			return granRepository.findByProductId(id);
		}
		return null;
	}
	
	public GranulationQty newGranulationQty(Granulation granulation ,Product newProduct) {
		GranulationQty granulationQty = new GranulationQty();
		granulationQty.setProduct(newProduct);
		granulationQty.setGranulation(granulation);
		granulationQty.setDiscountedPrice(null);
		granulationQty.setIsAvailable(false);
		granulationQty.setPrice(0.00);
		granulationQty.setStock(0);
		return granRepository.save(granulationQty);
	}
	
	public void deleteGranulationQty(GranulationQty granulationQty) {
		granulationQty.setProduct(null);
		granRepository.delete(granulationQty);
	}
	
	public List<NozzleQty> findNozzleByProductId(Long id) {
		if(nozzleRepository.existsByProductId(id)) {
			return nozzleRepository.findByProductId(id);
		}
		return null;
	}
	
	public NozzleQty newNozzleQty(Nozzle nozzle, Product newProduct) {
		NozzleQty newNq = new NozzleQty();
		newNq.setIsAvailable(false);
		newNq.setNozzle(nozzle);
		newNq.setProduct(newProduct);
		newNq.setStock(0);
		return nozzleRepository.save(newNq);
	}
	
	public void deleteNozzleQty(NozzleQty nozzleQty) {
		nozzleQty.setProduct(null);
		nozzleRepository.delete(nozzleQty);
	}
	
	public ProductDimension findDimensionByProductId(Long id) {
		if(dimensionRepository.existsByProductId(id)) {
			return dimensionRepository.findByProductId(id);
		}
		return null;
	}
	
	public ProductDimension newProductDimension(Dimension dimension, Product newProduct) {
		ProductDimension newPd = new ProductDimension();
		newPd.setDimension(dimension);
		newPd.setProduct(newProduct);
		return dimensionRepository.save(newPd);
	}
	

	public void deleteProductDimension(ProductDimension dimension) {
		dimensionRepository.delete(dimension);
	}
	
	public ProductWeight findWeightByProductId(Long id) {
		if(weightRepository.existsByProductId(id)) {
			return weightRepository.findByProductId(id);
		}
		return null;
	}
	
	public ProductWeight newProductWeight(Weigth weight, Product newProduct) {
		ProductWeight newPw = new ProductWeight();
		newPw.setProduct(newProduct);
		newPw.setWeigth(weight);
		return weightRepository.save(newPw);
	}

	public void deleteProductWeight(ProductWeight weight) {
		weightRepository.delete(weight);
	}
	
	public List<SizeQty> findSizeByProductId(Long id) {
		if(sizeRepository.existsByProductId(id)) {
			return sizeRepository.findByProductId(id);
		}
		return null;
	}
	
	public SizeQty newSizeQty(Size size, Product newProduct) {
		SizeQty newSq = new SizeQty();
		newSq.setIsAvailable(false);
		newSq.setProduct(newProduct);
		newSq.setSize(size);
		newSq.setStock(0);
		return sizeRepository.save(newSq);
	}

	public void deleteSizeQty(SizeQty sizeQty) {
		sizeQty.setProduct(null);
		sizeRepository.delete(sizeQty);
	}



	

	
}

	

