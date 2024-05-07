package mypackage.servlet;

import mypackage.classes.Purchase_order;
import mypackage.DatabaseClass;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PurchaseOrderServlet")
public class PurchaseOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Purchase_order> purchaseOrders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DatabaseClass db = new DatabaseClass();
            conn = db.getConnection();
            System.out.println("connect successfully");

            String query = "SELECT * FROM purchase_orders";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            System.out.println("query execute successfully");

            // Process the result set and populate the purchaseOrders list
            while (resultSet.next()) {
                Purchase_order purchaseOrder = new Purchase_order(
                        resultSet.getInt("order_id"),
                        resultSet.getString("product_name"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("pricing"),
                        resultSet.getDouble("mrp"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("city")
                        
                );
                purchaseOrders.add(purchaseOrder);
                
            }

            // Set the purchaseOrders list as a request attribute
            request.setAttribute("purchaseOrders", purchaseOrders);

            // Forward the request to purchase_order.jsp
            request.getRequestDispatcher("purchase_order.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle or log the exception
            response.sendRedirect("purchase_order.jsp?error=database_error");
        } finally {
            // Close resources in finally block
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception
            }
        }
    }
}
