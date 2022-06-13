<%@page import="com.survivalcoding.domain.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <jsp:useBean id="repository" class="com.survivalcoding.data.ProductRepository" scope="session"></jsp:useBean>
  <html>

  <head>
    <meta charset="UTF-8">
   <tittle>상품 목록 </tittle>
  </head>

  <body>
  <jsp:include page="menu.jsp"></jsp:include>
  <div class="container">
      <div class="row" align="center">
        <%
        List<Product> products = repository.getAllProducts(); 
        for (int i =0 ;i<products.size();i++){
            Product product = products.get(i);
        %>
            <div class="col-md-4">
                <h3><%= product.getName() %>></h3>
                <p><%= product.getDescription() %></p>
                <p><%= product.getUnitPrice() %></p>
            </div>
          <%
            }
          %>
        </div>
      </div>
  </div>
   
	<jsp:include page="footer.jsp"></jsp:include>
  </body>

  </html>