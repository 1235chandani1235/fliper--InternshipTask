package mypackage.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.DatabaseClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");
        String city = request.getParameter("city");

        DatabaseClass db = null;
        Connection conn = null;
        try {
            db = new DatabaseClass();
            conn = db.getConnection();

            String query = "INSERT INTO customers (customer_name, email, mobile_number, city) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, mobileNumber);
            preparedStatement.setString(4, city);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new customer was inserted successfully!");
            }

            // Redirect back to customer management page
            response.sendRedirect("dashboard.jsp");
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
