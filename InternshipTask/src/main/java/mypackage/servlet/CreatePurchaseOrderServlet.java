package mypackage.servlet;

import mypackage.DatabaseClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/CreatePurchaseOrderServlet")
public class CreatePurchaseOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double pricing = Double.parseDouble(request.getParameter("pricing"));
        double mrp = Double.parseDouble(request.getParameter("mrp"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String city = request.getParameter("city"); // Get the city parameter

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseClass db = new DatabaseClass();
            conn = db.getConnection();

            String query = "INSERT INTO purchase_orders (product_name, quantity, pricing, mrp, customer_id, city) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setDouble(3, pricing);
            preparedStatement.setDouble(4, mrp);
            preparedStatement.setInt(5, customerId);
            preparedStatement.setString(6, city); // Set the city parameter

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new purchase order was inserted successfully!");
                // Redirect back to purchase order management page
                response.sendRedirect("index.jsp");
                return; // Return to avoid further execution
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception
        } finally {
            // Close PreparedStatement and Connection in finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception
            }
        }
        // If the code reaches here, it means an error occurred
        response.sendRedirect("purchase_order.jsp?error=database_error");
    }
}
