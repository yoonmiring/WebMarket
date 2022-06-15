package com.survivalcoding.data.dao;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.survivalcoding.domain.model.Product;

public class MySqlProductDaoImpl implements ProductDao {

	public MySqlProductDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}
		
	}
	@Override
	public List<Product> getAll() {
		
		List<Product> results = new ArrayList();
		
		String sql = "SELECT * FROM product";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.101:33061/kopoctc", "root", "koposw36");
			Statement stmt = conn.createStatement()){
			try (ResultSet rs = stmt.executeQuery(sql)){
				
				while(rs.next()) {
					String id = rs.getString("p_id");
					String name = rs.getString("p_name");
					int unitPrice = rs.getInt("p_unitPrice");
					String description = rs.getString("p_description");
					String category = rs.getString("p_category");
					String manufacturer = rs.getString("p_manufacturer");
					long unitsInStock = rs.getLong("p_unitsInStock");
					String condition = rs.getString("p_condition");
					
					Product product = new Product(id, name, unitPrice);
					product.setDescription(description);
					product.setCategory(category);
					product.setManufacturer(manufacturer);
					product.setUnitsInStock(unitsInStock);
					product.setCondition(condition);
					
					results.add(product);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException("db연결 실패");
		}
		return results;
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

}
