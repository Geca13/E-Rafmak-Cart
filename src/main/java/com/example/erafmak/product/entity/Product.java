package com.example.erafmak.product.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.erafmak.enums.Dimension;
import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Nozzle;
import com.example.erafmak.enums.Size;
import com.example.erafmak.enums.Weigth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
    private Double price;
    
    private Double discountedPrice;
    
    private Integer stock;
	
	private Boolean isAvailable;
	
	private String imageUrl;
	
	@ManyToMany
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Manufacturer manufacturer;

	@ManyToOne
	private SubCategory subCategory;
	
	@Transient
	private Weigth weigth;
	
	@Transient
	private Dimension dimension;
	
	@Transient
	private List<Granulation> granulations;
	
	@Transient
	private List<Nozzle> nozzles;
	
	@Transient
	private List<Size> sizes;

	public Product(Long id, String name, String description, Double price, Double discountedPrice, Integer stock,
			Boolean isAvailable, String imageUrl, List<Product> products, Manufacturer manufacturer,
			SubCategory subCategory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.stock = stock;
		this.isAvailable = isAvailable;
		this.imageUrl = imageUrl;
		this.products = products;
		this.manufacturer = manufacturer;
		this.subCategory = subCategory;
	}
	
	
}
