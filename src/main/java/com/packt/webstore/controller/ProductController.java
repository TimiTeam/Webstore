package com.packt.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("market")
public class ProductController {
	
	
	@Autowired
	private ProductService service;

	
	@RequestMapping("/products")
	public String list(Model model) {
		
		model.addAttribute("products", service.getAllProducts());
		
		return "products";
	}
	
	
	@RequestMapping("/update/stock")
	public String updateSock(Model model) {
		
		service.updateAllStock();
		
		return "redirect:market/products";
	}
	
//Request path (example) http://localhost:8080/webstore/market/products/Smartphone 
	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model,
			@PathVariable("category") String productCategory) {
		
		model.addAttribute("products",service.getProductsByCategory(productCategory));
		
		return "products";
	}
	
	
	
//Request path http://localhost:8080/webstore/market/products/filter/params;brands=Apple,Dell;categories=Laptop,Smartphone	
	@RequestMapping("products/filter/{params}")
	public String getProductsByFilter(Model model, 
			@MatrixVariable(pathVar="params")Map<String,List<String>> filterParam) {
		
		model.addAttribute("products",service.getProductByFilter(filterParam));
		
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(Model model,
			@RequestParam("id")String ptoductId) {
		
		model.addAttribute("product",service.getProductById(ptoductId));
		
		return"product";
	}
	
	@RequestMapping("/products/{category}/{params}")
	public String getByMultipleCriteria(Model model, @PathVariable("category")String category,
			@MatrixVariable(pathVar="params")Map<String,List<String>> param,@RequestParam("brand")String brand) {
		
		model.addAttribute("products",service.getProductByMultipleCriteria(category, param, brand));
		
		return"products";
	}
	
	
}
