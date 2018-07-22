package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Product;

//Service Layer
public interface ProductService {

	void updateAllStock();
	
	List<Product> getAllProducts();
}
