package mypackage.servlet;

import mypackage.classes.Purchase_order;
import mypackage.DatabaseClass;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/FilterDataByCityServlet")
public class FilterDataByCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");

        DatabaseClass db = null;
        Connection conn = null;
        try {
            db = new DatabaseClass();
            conn = db.getConnection();

            // Query to retrieve purchase orders by city
            String query = "SELECT * FROM purchase_orders WHERE city = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, city);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to store filtered purchase orders
            List<Purchase_order> filteredPurchaseOrders = new ArrayList<>();

            // Process the result set and add filtered purchase orders to the list
            while (resultSet.next()) {
                Purchase_order purchaseOrder = new Purchase_order(
                        resultSet.getInt("id"),
                        resultSet.getString("product_name"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("pricing"),
                        resultSet.getDouble("mrp"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("city") // Include city in Purchase_order constructor
                );
                filteredPurchaseOrders.add(purchaseOrder);
            }

            // Store the filtered purchase orders in request attribute
            request.setAttribute("filteredPurchaseOrders", filteredPurchaseOrders);

            // Forward the request to dashboard.jsp
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle or log the exception
            response.sendRedirect("dashboard.jsp?error=database_error");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception
            }
        }
    }
}
