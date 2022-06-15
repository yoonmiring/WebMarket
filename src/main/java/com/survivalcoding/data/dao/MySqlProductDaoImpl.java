package com.survivalcoding.data.dao;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.101:3306/kopoctc", "root",
				"koposw36"); Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) {
					String id = rs.getString("COLUMN_ID");
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
			throw new IllegalStateException("db연결 실패" + e.getMessage());
		}
		return results;
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		//PreparedStatement 동적 쿼리 생성 : INSERT, UPDATE, DELETE 여러번 할 때 고속
		String sql = "INSERT INTO product VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.101:3306/kopoctc", "root", "koposw36"); 
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("INSERT 실패"+e.getMessage());
		}
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE ? SET p_name=?, p_unitPrice=?, p_description=?, p_category=?, p_manufacturer=?, p_unitsInStock=?, p_condition=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.101:3306/kopoctc", "root", "koposw36"); 
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, TABLE_NAME);
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("UPDATE 실패"+e.getMessage());
		}
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM ? WHERE p_id = ?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.101:3306/kopoctc", "root", "koposw36"); 
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, TABLE_NAME);
			stmt.setString(2, product.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("DELETE 실패"+e.getMessage());
		}
	}

}
