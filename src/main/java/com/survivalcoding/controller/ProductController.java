package com.survivalcoding.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survivalcoding.domain.model.Product;
import com.survivalcoding.domain.respository.ProductRepository;

@WebServlet(name = "ProductController" , urlPatterns = {"/product.do","/addProduct.do"})
public class ProductController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청주소
		String command = req.getRequestURI().substring(req.getContextPath().length());
		
		ProductRepository repository = ProductRepository.getInstance();
		
		if(command.equals("/products.do")) {
			
            List<Product> products = repository.getAllProducts();
            req.getSession().setAttribute("products", products);
		}else if(command.equals("/addProduct.do")) {
             
		}
		System.out.println("통!!!!!!!!!!!!!!!!!!!!!과!!!!!!!!!!!!!!!!!!!");
		
		//products.jsp로 이동
		req.getRequestDispatcher("products.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
