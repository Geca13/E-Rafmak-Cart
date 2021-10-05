package com.example.erafmak.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<User, List<Product>> cart(@AuthenticationPrincipal UsersDetails user){
	   Map<User, List<Product>> products = new HashMap<>();
	   String userEmail = user.getUsername();
       User user1 = userRepository.findByEmail(userEmail);
	   
	   return products;
	}
	
	public List<Product> productsInCart(){
		List<Product> products = new ArrayList<>();
		return products;
	}

	public void addProductToCart(Long id) {
		Product product = productService.findProductById(id);
		product.setQty(1);
		productsInCart().add(product);
	}

	public void removeProductToCart(Long id) {
		Product product = productService.findProductById(id);
		productsInCart().remove(product);
	}

}
