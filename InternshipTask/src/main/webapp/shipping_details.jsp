<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shipping Details Management</title>
</head>
<body>
    <h2>Shipping Details Management</h2>
    <!-- Form to add shipping details -->
    <form action="AddShippingDetailsServlet" method="post">
        Address: <input type="text" name="address"><br>
        City: <input type="text" name="city"><br>
        Pincode: <input type="text" name="pincode"><br>
        Purchase Order ID: <input type="number" name="purchaseOrderId"><br>
        Customer ID: <input type="number" name="customerId"><br>
        <input type="submit" value="Add Shipping Details">
    </form>
    
    
    <!-- Table to display existing shipping details -->
    <h3>Existing Shipping Details</h3>
    <table border="1">
        <tr>
            <th>Shipping ID</th>
            <th>Address</th>
            <th>City</th>
            <th>Pincode</th>
            <th>Purchase Order ID</th>
            <th>Customer ID</th>
        </tr>
        <!-- Use JSP or JSTL to loop through shipping details data from the servlet and display -->
         <c:forEach var="shipping" items="${shippingDetails}">
         
            <tr>
                <td>${shipping.shippingId}</td>
                <td>${shipping.address}</td>
                <td>${shipping.city}</td>
                <td>${shipping.pincode}</td>
                <td>${shipping.purchaseOrderId}</td>
                <td>${shipping.customerId}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
