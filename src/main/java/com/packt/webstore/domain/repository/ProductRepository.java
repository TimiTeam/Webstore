package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Product;


//Repository Layer
public interface ProductRepository {

	List<Product> getAllProducts();
	
	void updateStock(String productId, long noOfUnits);

}
