package com.example.erafmak.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.services.ProductService;
import com.example.erafmak.user.entity.User;
import com.example.erafmak.user.entity.UserRepository;
import com.example.erafmak.user.service.UsersDetails;

@Service
public class CartService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartItemRepository ciRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	
	private Map<String, List<Product>> cart = new HashMap<>();
	
	
	public Entry<String, List<Product>> findLoggedInUserMap(@AuthenticationPrincipal UsersDetails user) {
		
		for (Map.Entry<String, List<Product>>map : cart.entrySet()) {
			if(map.getKey().equals(user.getUsername())) {
				return map;
			}
		}
		return null;
	}

	

	public String loggedInUser(@AuthenticationPrincipal UsersDetails user){
	   String userEmail = user.getUsername();
       User user1 = userRepository.findByEmail(userEmail);
	return user1.getEmail();
	  
	}
	
	public List<Product> productsInCart(){
		List<Product> products = new ArrayList<>();
		return products;
	}

	public void addProductToCart(Long id, @AuthenticationPrincipal UsersDetails user) {
		String user1 = loggedInUser(user);
		Product product = productService.findProductById(id);
		product.setQty(2);
		if(cart.containsKey(user1)) {
			cart.get(user1).add(product);
		}else {
			cart.put(user1, productsInCart());
			cart.get(user1).add(product);
		}
	}

	public void removeProductToCart(Long id ,@AuthenticationPrincipal UsersDetails user) {
		String user1 = loggedInUser(user);
		Product product = productService.findProductById(id);
		if(cart.containsKey(user1)) {
			cart.values().remove(product);
		}
	}

}
