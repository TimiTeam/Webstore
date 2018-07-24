package com.packt.webstore.service;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Product;

//Service Layer
public interface ProductService {

	void updateAllStock();
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(String category);
	
	List<Product> getProductByFilter(Map<String, List<String>> filterParam);
}
