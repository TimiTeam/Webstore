package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.service.CustomerService;

@Controller
public class CustomerController {
	
	
	@Autowired
	private CustomerService service;
	
	
	@RequestMapping("/cutomers")
	public String customers(Model model) {
		
		model.addAttribute("customers",service.getAllCustomer());
		
		return "customers";
	}
	
	

}
