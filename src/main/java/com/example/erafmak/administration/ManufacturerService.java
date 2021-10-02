package com.example.erafmak.administration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.erafmak.product.entity.Manufacturer;
import com.example.erafmak.product.entity.Origin;
import com.example.erafmak.product.repository.ManufacturerRepository;
import com.example.erafmak.product.repository.OriginRepository;

@Service
public class ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	
	@Autowired
	OriginRepository originRepository;
	
	public List<String> getCountriesList(){
		List<String> countries = new ArrayList<>();
		String[] isoCountries = Locale.getISOCountries();
		
		for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
           String name = locale.getDisplayCountry();
           countries.add(name);
		}
		
		return countries;
	}
	
	public List<Manufacturer> allManufacturers(){
		return manufacturerRepository.findAll();
	}
	
	public Manufacturer findById(Long id) {
		return manufacturerRepository.findById(id).get();
	}
	
	public Manufacturer findByName(String name) {
		return manufacturerRepository.findByName(name);
	}
	
	public Manufacturer createNewManufacturer(Manufacturer manufacturer) {
		
		setOriginToManufacturer(manufacturer);
		
		return manufacturerRepository.save(manufacturer);
	}

	private Origin setOriginToManufacturer(Manufacturer manufacturer) {
		Origin origin = new Origin();
		
		if(originRepository.existsByName(manufacturer.getOrigin().getName())) {
			manufacturer.setOrigin(originRepository.findByName(manufacturer.getOrigin().getName()));
		} else {
			
			origin.setName(manufacturer.getOrigin().getName());
			originRepository.save(origin);
			manufacturer.setOrigin(origin);
			manufacturerRepository.save(manufacturer);
		}
		return origin;
	}
	
	public List<Origin> origins() {
		return originRepository.findAll();
	}

	public Manufacturer updateManufacturer(Long id, Manufacturer manufacturer) {
		Manufacturer forUpdate = findById(id);
		forUpdate.setEmail(manufacturer.getEmail());
		forUpdate.setName(manufacturer.getName());
		
		if(originRepository.existsByName(manufacturer.getOrigin().getName())) {
			forUpdate.setOrigin(originRepository.findByName(manufacturer.getOrigin().getName()));
			return manufacturerRepository.save(forUpdate);
		}
		forUpdate.setOrigin(setOriginToManufacturer(manufacturer));
		return manufacturerRepository.save(forUpdate);
	}
}
