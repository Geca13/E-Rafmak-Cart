package com.example.erafmak.product.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.erafmak.enums.Granulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GranulationQty {
	
	@Id
	private Long id;
	
	private Boolean isAvailable;
	
	private Double price;
	
	private Double discountedPrice;
	
	private Integer stock;
	
	@Enumerated(EnumType.STRING)
	private Granulation granulation;

}
