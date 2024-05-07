<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Management</title>
</head>
<body>
    <h2>Customer Management</h2>
    <!-- Form to add customer details -->
    <form action="AddCustomerServlet" method="post">
        Customer Name: <input type="text" name="customerName"><br>
        Email: <input type="email" name="email"><br>
        Mobile Number: <input type="text" name="mobileNumber"><br>
        City: <input type="text" name="city"><br>
        <input type="submit" value="Add Customer">
    </form>
    
    <!-- Table to display existing customers -->
    <h3>Existing Customers</h3>
    <table border="1">
        <tr>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Email</th>
            <th>Mobile Number</th>
            <th>City</th>
        </tr>
       
        <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.customerName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.mobileNumber}</td>
                    <td>${customer.city}</td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
