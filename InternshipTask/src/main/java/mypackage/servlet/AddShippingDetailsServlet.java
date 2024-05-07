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

@WebServlet("/AddShippingDetailsServlet")
public class AddShippingDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");
        int purchaseOrderId = Integer.parseInt(request.getParameter("purchaseOrderId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            DatabaseClass db = new DatabaseClass();
            conn = db.getConnection();

            String query = "INSERT INTO shipping_details (address, city, pincode, purchase_order_id, customer_id) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, address);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, pincode);
            preparedStatement.setInt(4, purchaseOrderId);
            preparedStatement.setInt(5, customerId);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Shipping details inserted successfully!");
            }

            // Redirect back to the page where you want to display a success message or perform further actions
            response.sendRedirect("dashboard.jsp");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception
            response.sendRedirect("dashboard.jsp?error=database_error");
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
    }
}
