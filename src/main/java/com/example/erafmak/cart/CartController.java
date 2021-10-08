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
		model.addAttribute("products", cartService.findLoggedInUserMap(user));
		return "cartPage";
	}
	
	@GetMapping("/addProductToCart/{id}")
    public String addProductToCart(@PathVariable("id")Long id, @AuthenticationPrincipal UsersDetails user ) {
		
		cartService.addProductToCart(id, user);
		return "redirect:/product/"+id;
	}
	
	@GetMapping("/addProductWGToCart/{id}/{gid}")
    public String addProductWithGranulationToCart(@PathVariable("id")Long id,@PathVariable("gid")Long gid, @AuthenticationPrincipal UsersDetails user ) {
		cartService.addProductWithGranulationToCart(gid, user);
		return "redirect:/product/"+id;
	}
	
	@GetMapping("/addProductWSToCart/{id}/{sid}")
    public String addProductWithSizeToCart(@PathVariable("id")Long id,@PathVariable("sid")Long sid, @AuthenticationPrincipal UsersDetails user ) {
		cartService.addProductWithSizeToCart(sid, user);
		return "redirect:/product/"+id;
	}
	
	
	@GetMapping("/removeProductFromCart/{id}")
    public String removeProductFromCart(@PathVariable("id")Long id , @AuthenticationPrincipal UsersDetails user) {
		cartService.removeProductToCart(id,user);
		return "redirect:/cart";
	}
}
