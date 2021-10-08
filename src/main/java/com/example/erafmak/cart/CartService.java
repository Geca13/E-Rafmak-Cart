package com.example.erafmak.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Size;
import com.example.erafmak.product.entity.GranulationQty;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.entity.SizeQty;
import com.example.erafmak.product.services.EnumClassesService;
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
	EnumClassesService enumService;
	
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
		product.setQty(1);
		if(cart.containsKey(user1)) {
			cart.get(user1).add(product);
		}else {
			cart.put(user1, productsInCart());
			cart.get(user1).add(product);
		}
	}
	
	public void addProductWithGranulationToCart(Long id, @AuthenticationPrincipal UsersDetails user) {
		
		GranulationQty gran = enumService.findGranulationById(id);
        Product product = gran.getProduct();
		product.setPrice(gran.getPrice());
		List<Granulation> grans = new ArrayList<>();
		grans.add(gran.getGranulation());
		product.setGranulations(grans);
		addProductToCart(product.getId(), user);
	}

    public void addProductWithSizeToCart(Long sid, UsersDetails user) {
		
	    SizeQty size = enumService.findSizeById(sid);
	    Product product = size.getProduct();
	    List<Size> sizes = new ArrayList<>();
	    sizes.add(size.getSize());
	    product.setSizes(sizes);
        addProductToCart(product.getId(), user);
	}

    public void removeProductToCart(Long id ,@AuthenticationPrincipal UsersDetails user) {
	String user1 = loggedInUser(user);
	Product product = productService.findProductById(id);
	
			
		}
		
	}


