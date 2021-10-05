package com.example.erafmak.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.erafmak.user.service.UsersDetails;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/cart")
	public String getCartPage(Model model, @AuthenticationPrincipal UsersDetails user) {
		model.addAttribute("products", cartService.productsInCart());
		return "cartPage";
	}
	
	@GetMapping("/addProductToCart/{id}")
    public String addProductToCart(@PathVariable("id")Long id) {
		cartService.addProductToCart(id);
		return "redirect:/product/"+id;
	}
	
	@GetMapping("/removeProductFromCart/{id}")
    public String removeProductFromCart(@PathVariable("id")Long id) {
		cartService.removeProductToCart(id);
		return "redirect:/cart";
	}
}
