package mypackage.servlet;

import mypackage.classes.Shipping_details;
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

@WebServlet("/ShippingDetailsServlet")
public class ShippingDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shipping_details> shippingDetails = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DatabaseClass db = new DatabaseClass();
            conn = db.getConnection();

            String query = "SELECT * FROM shipping_details";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            // Process the result set and populate the shippingDetails list
            while (resultSet.next()) {
                Shipping_details shipping = new Shipping_details(
                        resultSet.getInt("shipping_id"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("pincode"),
                        resultSet.getInt("purchase_order_id"),
                        resultSet.getInt("customer_id")
                );
                shippingDetails.add(shipping);
            }

            // Set the shippingDetails list as a request attribute
            request.setAttribute("shippingDetails", shippingDetails);

            // Forward the request to shipping_details.jsp
            request.getRequestDispatcher("shipping_details.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle or log the exception
            response.sendRedirect("shipping_details.jsp?error=database_error");
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
