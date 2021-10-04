package com.example.erafmak.cart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	
	@Id
	private Long id;
	
	private Long pid;
	
	private String description;
	
	private Double price;
	
	private Double subTotal;
	
	private Integer qty;

}
