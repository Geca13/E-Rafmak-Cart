package com.example.erafmak.cart;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.erafmak.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@Id
	private Long id;
	
	@ManyToMany
	private List<CartItem> items;
	
	private Double total;
	
	@ManyToOne
	private User user;

}
