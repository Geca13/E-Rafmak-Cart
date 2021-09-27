package com.example.erafmak.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.erafmak.product.services.CategoryService;
import com.example.erafmak.user.entity.User;
import com.example.erafmak.user.entity.UserRepository;
import com.example.erafmak.user.service.UsersDetails;

@Controller
public class MainEntryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	
	@GetMapping("/home")
	public String loginPage(Model model) {
		model.addAttribute("categories", categoryService.allCategories());
		return "home";
	}
	
	@GetMapping("/")
	public String getIndexPage(Model model , @AuthenticationPrincipal UsersDetails user) {
		
		model.addAttribute("categories", categoryService.allCategories());
		
		String userEmail = user.getUsername();
        User user1 = userRepository.findByEmail(userEmail);
           model.addAttribute("user", user1);
		
		return "index";
	}
	
	
	
	@GetMapping("/logoutSuccess")
	public String logout() {
		return "login";
	}
	
}
