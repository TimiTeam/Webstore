package com.packt.webstore.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;


//Service Layer
@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepository repository;
	
	public void updateAllStock() {
		List<Product> products = repository.getAllProducts();
		
		for(Product p: products) {
			if(p.getUnitsInStock()<=500) {
			repository.updateStock(p.getProductId(), p.getUnitsInStock()+1000);
			
			}
		}
	}

	public List<Product> getAllProducts() {
		return repository.getAllProducts();
	}

	public List<Product> getProductsByCategory(String category) {
		
		return repository.getProductsByCategory(category);
	}

	public List<Product> getProductByFilter(Map<String, List<String>> filterParam) {
		
		return repository.getProductsByFilter(filterParam);
	}

	public Product getProductById(String productId) {
		
		return repository.getProductById(productId);
	}

	public List<Product> getProductByMultipleCriteria(String category, Map<String, List<String>> priceLowAndHigh,
			String brand) {
		
		return repository.getProductByMultipleCriteria(category, priceLowAndHigh, brand);
	}
	
	
	
	
	
	
}
