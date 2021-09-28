package com.example.erafmak.administration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erafmak.product.entity.Manufacturer;
import com.example.erafmak.product.repository.ManufacturerRepository;

@Service
public class ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	
	public List<Manufacturer> allManufacturers(){
	  return manufacturerRepository.findAll();
	}
}
