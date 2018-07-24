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

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;


//Repository Layer
@Repository
public class InMemoryProductRepository implements ProductRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParam) {
		
		String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY IN ( :categories) "
				+ "AND MANUFACTURER IN ( :brands)";
		
		return jdbcTemplate.query(SQL, filterParam, new ProductMapper());
	}
	

	public List<Product> getProductsByCategory(String category) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("category", category);
		
		List<Product> list = jdbcTemplate.query("SELECT * FROM PRODUCTS WHERE CATEGORY "
				+ "=:category", param, new ProductMapper());
		
		return list;
	}

	public void updateStock(String productId, long noOfUnits) {
		String SQL = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock WHERE ID = :id";
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("unitsInStock", noOfUnits);
		param.put("id", productId);
		
		jdbcTemplate.update(SQL, param);
		
	}

	public List<Product> getAllProducts() {
		Map<String, Object> params = new HashMap<String, Object>();
		
		List<Product> list = jdbcTemplate.query("SELECT * FROM products",params ,new ProductMapper());
		
		return list;
	}
	
	private static final class ProductMapper implements
	RowMapper<Product> {

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Product product = new Product();
			
			product.setProductId(rs.getString("ID"));
			product.setName(rs.getString("NAME"));
			product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setManufacturer(rs.getString("MANUFACTURER"));
			product.setCategory(rs.getString("CATEGORY"));
			product.setCondition(rs.getString("CONDITION"));
			product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
			product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
			product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
			
			return product;
		}
		
		
	}

}
