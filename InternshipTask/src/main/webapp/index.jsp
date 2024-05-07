<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
</head>
<body>

<%-- Login Form --%>
<div id="loginForm">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username" placeholder="Username" required><br>
        Password: <input type="password" name="password" placeholder="Password" required><br>
        <button type="submit">Login</button>
    </form>
</div>

<%-- Signup Form --%>
<div id="signupForm">
    <h2>Sign Up</h2>
    <form action="SignupServlet" method="post">
        Username: <input type="text" name="username" placeholder="Username" required><br>
        Password: <input type="password" name="password"><br>
        Confirm Password: <input type="password" name="confirmPassword"><br>
        Email: <input type="email" name="email" placeholder="Email" required><br>
        Mobile Number: <input type="text" name="mobileNumber" placeholder="Mobile Number" required><br>
        City: <input type="text" name="city" placeholder="City" required><br>
        
        <button type="submit">Sign Up</button>
    </form>
</div>





<%-- Dashboard --%>
<div id="dashboard" style="display: none;">
    <h2>Welcome, Admin!</h2>
    <h3>Customer Management</h3>
    <form action="AddCustomerServlet" method="post">
        Customer Name: <input type="text" name="customerName" required><br>
        Email: <input type="email" name="email" required><br>
        Mobile Number: <input type="text" name="mobileNumber" required><br>
        City: <input type="text" name="city" required><br>
        <button type="submit">Add Customer</button>
    </form>

    <h3>Purchase Order Management</h3>
    <form action="CreatePurchaseOrderServlet" method="post">
        Product Name: <input type="text" name="productName" required><br>
        Quantity: <input type="number" name="quantity" required><br>
        Pricing: <input type="text" name="pricing" required><br>
        MRP: <input type="text" name="mrp" required><br>
        Customer ID: <input type="number" name="customerId" required><br>
        <button type="submit">Create Purchase Order</button>
    </form>

    <h3>Shipping Details Management</h3>
    <form action="AddShippingDetailsServlet" method="post">
        Address: <input type="text" name="address" required><br>
        City: <input type="text" name="city" required><br>
        Pincode: <input type="text" name="pincode" required><br>
        Purchase Order ID: <input type="number" name="purchaseOrderId" required><br>
        Customer ID: <input type="number" name="customerId" required><br>
        <button type="submit">Add Shipping Details</button>
    </form>

    <!-- Table to display existing data -->
    <h3>Existing Data</h3>
    <table border="1">
        <!-- Display existing data here -->
    </table>
</div>

<script>
    // Show dashboard after successful login
    function showDashboard() {
        document.getElementById("loginForm").style.display = "none";
        document.getElementById("signupForm").style.display = "none";
        document.getElementById("dashboard").style.display = "block";
    }
</script>

</body>
</html>
