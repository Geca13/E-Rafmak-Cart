package com.example.erafmak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.erafmak.user.entity.User;
import com.example.erafmak.user.entity.UserRepository;
import com.example.erafmak.user.service.UsersDetails;

@Controller
public class MainEntryController {
	
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String getIndexPage(Model model,@AuthenticationPrincipal UsersDetails user) {
	/*	
		model.addAttribute("coats", coats.coats());
		model.addAttribute("thinners", thinners.thinners());
		model.addAttribute("primers", primers.primers());
		model.addAttribute("hardeners", hardeners.hardeners());
		model.addAttribute("putties", putties.putties());
		
		model.addAttribute("sanders", sanders.sanders());
		model.addAttribute("discs", sanders.discs());
		model.addAttribute("wets", sanders.wets());
		model.addAttribute("softs", sanders.softs());
		model.addAttribute("blocks", sanders.blocks());
		model.addAttribute("rolls", sanders.rolls());
		
		model.addAttribute("pads", pads.pads());
		model.addAttribute("polishes", polishes.polishes());
		
		
		model.addAttribute("safeties", safeties.safeties());
		model.addAttribute("extrass", extras.extrass());
		
		model.addAttribute("helpers", helpers.helpers());
		model.addAttribute("nozzles", nozzles.nozzles());
		model.addAttribute("guns", guns.guns());
		model.addAttribute("tools", tools.tools());
		*/
		String userEmail = user.getUsername();
        User user1 = userRepository.findByEmail(userEmail);
           model.addAttribute("user", user1);
		
		return "index";
	}
	
	@GetMapping("/login")
	public String getloginPage(Model model) {
		/*
		model.addAttribute("coats", coats.coats());
		model.addAttribute("thinners", thinners.thinners());
		model.addAttribute("primers", primers.primers());
		model.addAttribute("hardeners", hardeners.hardeners());
		model.addAttribute("putties", putties.putties());
		
		model.addAttribute("sanders", sanders.sanders());
		model.addAttribute("discs", sanders.discs());
		model.addAttribute("wets", sanders.wets());
		model.addAttribute("softs", sanders.softs());
		model.addAttribute("blocks", sanders.blocks());
		model.addAttribute("rolls", sanders.rolls());
		
		model.addAttribute("pads", pads.pads());
		model.addAttribute("polishes", polishes.polishes());
		
		
		model.addAttribute("safeties", safeties.safeties());
		model.addAttribute("extrass", extras.extrass());
		
		model.addAttribute("helpers", helpers.helpers());
		model.addAttribute("nozzles", nozzles.nozzles());
		model.addAttribute("guns", guns.guns());
		model.addAttribute("tools", tools.tools());
		*/
		
		return "login";
	}
	
	@GetMapping("/logoutSuccess")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/admin")
	public String administration(Model model) {
		
		return "administration";
	}
}
