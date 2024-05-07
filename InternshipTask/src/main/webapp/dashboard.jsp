<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
    <h2>Dashboard</h2>
    
     <form action="AddCustomerServlet" method="post">
     <h3>Add Customer:</h3>
        Customer Name: <input type="text" name="customerName"><br>
        Email: <input type="email" name="email"><br>
        Mobile Number: <input type="text" name="mobileNumber"><br>
        City: <input type="text" name="city"><br>
        <input type="submit" value="Add Customer">
    </form>
    
    
    <form action="CreatePurchaseOrderServlet" method="post">
    <h3>Create Purchase Order: </h3>
        Product Name: <input type="text" name="productName"><br>
        Quantity: <input type="number" name="quantity"><br>
        Pricing: <input type="text" name="pricing"><br>
        MRP: <input type="text" name="mrp"><br>
        Customer ID: <input type="number" name="customerId"><br>
        <input type="submit" value="Create Purchase Order">
    </form>
    
     <form action="AddShippingDetailsServlet" method="post">
     <h3>Add shipping details:</h3>
        Address: <input type="text" name="address"><br>
        City: <input type="text" name="city"><br>
        Pincode: <input type="text" name="pincode"><br>
        Purchase Order ID: <input type="number" name="purchaseOrderId"><br>
        Customer ID: <input type="number" name="customerId"><br>
        <input type="submit" value="Add Shipping Details">
    </form>
    
    
    
    <!-- Filter data by city form -->
    <form action="FilterDataByCityServlet" method="post">
      <h3>  Filter Purchase Orders by City:</h3> <input type="text" name="city"><br>
        <input type="submit" value="Filter">
    </form>
    
    <!-- Display all entered details including customer information, purchase orders, and shipping details -->
    <h3>Customer Information</h3>
    <table border="1">
        <!-- Display customer data -->
        <tr>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Email</th>
            <th>Mobile Number</th>
            <th>City</th>
        </tr>
        
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.customerName}</td>
                <td>${customer.email}</td>
                <td>${customer.mobileNumber}</td>
                <td>${customer.city}</td>
            </tr>
        </c:forEach>
        
        
    </table>
    
    <h3>Purchase Orders</h3>
    <table border="1">
        <!-- Display purchase order data -->
        <tr>
            <th>Order ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Pricing</th>
            <th>MRP</th>
            <th>Customer ID</th>
            <th>City</th>
        </tr>
        
         <c:forEach var="purchaseOrder" items="${purchaseOrders}">
            <tr>
                <td>${purchaseOrder.orderId}</td>
                <td>${purchaseOrder.productName}</td>
                <td>${purchaseOrder.quantity}</td>
                <td>${purchaseOrder.pricing}</td>
                <td>${purchaseOrder.mrp}</td>
                <td>${purchaseOrder.customerId}</td>
                 <td>${purchaseOrder.city}</td>
            </tr>
        </c:forEach>
    </table>
    
    <h3>Shipping Details</h3>
    <table border="1">
        <!-- Display shipping details data -->
        
        <tr>
            <th>Shipping ID</th>
            <th>Address</th>
            <th>City</th>
            <th>Pincode</th>
            <th>Purchase Order ID</th>
            <th>Customer ID</th>
        </tr>
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
    
    <!-- Tab/filter to show the history of customer order details -->
    <h3>Customer Order History</h3>
    <form action="CustomerOrderHistoryServlet" method="post">
        Customer ID: <input type="text" name="customerId"><br>
        <input type="submit" value="Show Order History">
    </form>
</body>
</html>
