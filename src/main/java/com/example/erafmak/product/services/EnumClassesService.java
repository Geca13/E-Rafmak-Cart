package com.example.erafmak.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Weigth;
import com.example.erafmak.product.entity.GranulationQty;
import com.example.erafmak.product.entity.NozzleQty;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.entity.ProductWeight;
import com.example.erafmak.product.entity.SizeQty;
import com.example.erafmak.product.repository.GranulationQtyRepository;
import com.example.erafmak.product.repository.NozzleQtyRepository;
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
	
	public ProductWeight findWeightByProductId(Long id) {
		if(weightRepository.existsByProducts_Id(id)) {
			return weightRepository.findByProducts_Id(id);
		}
		return null;
	}
	
	public ProductWeight createNewProductWeight(Weigth weigth , Product product) {
		ProductWeight newWeight = new ProductWeight();
		newWeight.setWeigth(weigth);
		newWeight.setProduct(product);
		return weightRepository.save(newWeight);
	}
	
	public List<SizeQty> findSizeByProductId(Long id) {
		if(sizeRepository.existsByProductId(id)) {
			return sizeRepository.findByProductId(id);
		}
		return null;
	}
	
	

}
