package com.web.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	@GetMapping("/home")
	public String index() {
		return "index";
	}

}
