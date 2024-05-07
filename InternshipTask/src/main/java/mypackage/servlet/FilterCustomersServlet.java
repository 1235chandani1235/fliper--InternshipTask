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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/FilterCustomersServlet")
public class FilterCustomersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");

        DatabaseClass db = null;
        Connection conn = null;
        try {
            db = new DatabaseClass();
            conn = db.getConnection();

            String query = "SELECT * FROM customers WHERE city = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, city);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set and display customers in customer.jsp
            // You can store the resultSet in request attribute and forward to customer.jsp for display
            // Example: request.setAttribute("customers", resultSet);
            // Then forward to customer.jsp: request.getRequestDispatcher("customer.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle or log the exception
            response.sendRedirect("customer.jsp?error=database_error");
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
