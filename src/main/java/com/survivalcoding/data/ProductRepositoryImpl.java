package com.survivalcoding.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.survivalcoding.domain.model.Product;
import com.survivalcoding.domain.respository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
	private List<Product> products = new ArrayList<>(); 
	
	//싱글턴 패턴
	//1.static 인스턴스 준비
	//2.static 메서드로 인스턴스 리턴(getInstance() 이름을 주로 씀)
	//3.생성자 막기 (private)
	private static ProductRepositoryImpl instance = new ProductRepositoryImpl();
	
	public static ProductRepositoryImpl getInstance() {
		return instance;
	}
	
	private ProductRepositoryImpl() {
		Product phone = new Product("P1234","iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Retina HD display");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("NEW");
		
		Product notebook = new Product("P1235","LG PC 그램", 1500000);
		notebook.setDescription("!4.7-inch, 1334x750 Retina HD display");
		notebook.setCategory("!Smart Phone");
		notebook.setManufacturer("!Apple");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refubished");
		
		Product tablet = new Product("P1236","Galaxt Tab S", 800000);
		tablet.setDescription("?4.7-inch, 1334x750 Retina HD display");
		tablet.setCategory("?Smart Phone");
		tablet.setManufacturer("?Apple");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");
		
		products.add(phone);
		products.add(notebook);
		products.add(tablet);
	}
	
	public List<Product> getAllProducts() {
		return products;
	}
	public Product getProductById(String id) {
		// List -> Stream(데이터의 흐름)
		return products.stream()
				.filter((product) -> product.getId().equals(id))
				.findFirst()
				.get();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
}
