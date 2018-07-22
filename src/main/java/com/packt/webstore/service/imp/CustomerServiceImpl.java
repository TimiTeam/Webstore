package com.packt.webstore.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> getAllCustomer() {
		return repository.listAll();
	}
	
	

}
