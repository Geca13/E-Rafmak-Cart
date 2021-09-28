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
	
	public GranulationQty newGranulationQty(Granulation granulation ,Product product) {
		GranulationQty granulationQty = new GranulationQty();
		granulationQty.setProduct(product);
		granulationQty.setGranulation(granulation);
		granulationQty.setDiscountedPrice(null);
		granulationQty.setIsAvailable(false);
		granulationQty.setPrice(0.00);
		granulationQty.setStock(0);
		return granRepository.save(granulationQty);
	}
	
	public List<NozzleQty> findNozzleByProductId(Long id) {
		if(nozzleRepository.existsByProductId(id)) {
			return nozzleRepository.findByProductId(id);
		}
		return null;
	}
	
	public NozzleQty newNozzleQty(Nozzle nozzle, Product product) {
		NozzleQty newNq = new NozzleQty();
		newNq.setIsAvailable(false);
		newNq.setNozzle(nozzle);
		newNq.setProduct(product);
		newNq.setStock(0);
		return nozzleRepository.save(newNq);
		
	}
	
	public ProductDimension findDimensionByProductId(Long id) {
		if(dimensionRepository.existsByProductId(id)) {
			return dimensionRepository.findByProductId(id);
		}
		return null;
	}
	
	public ProductDimension newProductDimension(Dimension dimension, Product product) {
		ProductDimension newPd = new ProductDimension();
		newPd.setDimension(dimension);
		newPd.setProduct(product);
		return dimensionRepository.save(newPd);
	}
	
	public ProductWeight findWeightByProductId(Long id) {
		if(weightRepository.existsByProductId(id)) {
			return weightRepository.findByProductId(id);
		}
		return null;
	}
	
	public ProductWeight newProductWeight(Weigth weight, Product product) {
		ProductWeight newPw = new ProductWeight();
		newPw.setProduct(product);
		newPw.setWeigth(weight);
		return weightRepository.save(newPw);
	}
	
	public List<SizeQty> findSizeByProductId(Long id) {
		if(sizeRepository.existsByProductId(id)) {
			return sizeRepository.findByProductId(id);
		}
		return null;
	}
	
	public void newSizeQty(Size size, Product product) {
		SizeQty newSq = new SizeQty();
		newSq.setIsAvailable(false);
		newSq.setProduct(product);
		newSq.setSize(size);
		newSq.setStock(0);
	}

	
}
