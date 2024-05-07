<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase Order Management</title>
</head>
<body>
	<h2>Purchase Order Management</h2>

	<form action="CreatePurchaseOrderServlet" method="post">
		Product Name: <input type="text" name="productName"><br>
		Quantity: <input type="number" name="quantity"><br>
		Pricing: <input type="text" name="pricing"><br> MRP: <input
			type="text" name="mrp"><br> Customer ID: <input
			type="number" name="customerId"><br> <input
			type="submit" value="Create Purchase Order">
	</form>

	<h3>Existing Purchase Orders</h3>
	<table border="1">
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
</body>
</html>
