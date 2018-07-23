package com.packt.webstore.service.imp;

import java.util.List;

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
	
	
	
	
}
