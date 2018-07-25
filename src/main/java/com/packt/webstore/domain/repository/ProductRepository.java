package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Product;


//Repository Layer
public interface ProductRepository {

	List<Product> getAllProducts();
	
	void updateStock(String productId, long noOfUnits);
	
	List<Product> getProductsByCategory(String category);
	
	List<Product> getProductsByFilter(Map<String,List<String>> filterParam);
	
	Product getProductById(String productId);
	
	List<Product> getProductByMultipleCriteria(String category,Map<String,List<String>> priceLowAndHigh, String brand);

}
