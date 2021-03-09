<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Product Management System</title>
</head>
<body>
 
  <h1>Add Products</h1>
        <h2>
         <a href="new">Add New Products</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Products</a>
         
        </h2>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption>List of Users</caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Department</th>
            </tr>
            <c:forEach var="user" items="${listProduct}">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td><c:out value="${user.department}" /></td>
        
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>