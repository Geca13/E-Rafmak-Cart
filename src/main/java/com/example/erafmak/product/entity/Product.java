package com.example.erafmak.product.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.erafmak.enums.Dimension;
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
	
	@Enumerated(EnumType.STRING)
	private Weigth weigth;
	
	@Enumerated(EnumType.STRING)
	private Dimension dimension;
	
	private Boolean isAvailable;
	
	private String imageUrl;
	
	@ManyToMany
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Manufacturer manufacturer;

}
