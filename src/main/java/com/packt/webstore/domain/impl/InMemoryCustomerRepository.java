package com.packt.webstore.domain.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;


@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	public List<Customer> listAll() {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		return jdbcTemplate.query("SELECT * FROM customer", param, new CustomerMapper());
	}
	
	private static final class CustomerMapper implements RowMapper<Customer>{

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("ID"));
			customer.setName(rs.getString("NAME"));
			customer.setAddress(rs.getString("ADDRESS"));
			customer.setNoOfOrdersMade(rs.getLong("NO_OF_ORDERS_MADE"));
			
			return customer;
		}
		
	}
	

}
