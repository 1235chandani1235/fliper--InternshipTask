package mypackage.servlet;

import mypackage.classes.Customer;
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

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            DatabaseClass db = new DatabaseClass();
            conn = db.getConnection();

            String query = "SELECT * FROM customers";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            // Process the result set and populate the customers list
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("customer_name"),
                        resultSet.getString("email"),
                        resultSet.getString("mobile_number"),
                        resultSet.getString("city")
                );
                customers.add(customer);
            }

            // Set the customers list as a request attribute
            request.setAttribute("customers", customers);

            // Forward the request to customer.jsp
            request.getRequestDispatcher("customer.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle or log the exception
            response.sendRedirect("customer.jsp?error=database_error");
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
