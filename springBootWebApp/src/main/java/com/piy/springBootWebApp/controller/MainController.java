package com.piy.springBootWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/")
	String mainController() {
		return "Das Boot reporting for duty!";
	}
}
