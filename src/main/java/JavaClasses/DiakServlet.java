package JavaClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DiakServlet")
public class DiakServlet extends HttpServlet {

    private final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private final String user = "root";
    private final String password = "xR26.BDezso";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action == null) {
                action = "login";
            }

            switch (action) {
                case "register":
                    handleRegister(request, response, out);
                    break;
                case "login":
                default:
                    handleLogin(request, response, out);
                    break;
            }
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException {
        String email = request.getParameter("mail");
        String password = request.getParameter("passw");

        if (email != null && password != null) {
            try (Connection conn = DriverManager.getConnection(url, user, this.password);
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM diak WHERE email = ? AND jelszo = ?")) {

                stmt.setString(1, email);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        out.println("Login successful!");
                    } else {
                        out.println("Invalid email or password.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("Database error: " + e.getMessage());
            }
        } else {
            out.println("Please fill in all fields.");
        }
    }

    private void handleRegister(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("mail");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String university = request.getParameter("univers");
        String department = request.getParameter("department");
        String profile = request.getParameter("profile");
        String year = request.getParameter("year");

        if (password.equals(password2)) {
            try (Connection conn = DriverManager.getConnection(url, user, this.password);
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO diak (nev, jelszo, email, szak, kar, egyetem, evfolyam) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

                stmt.setString(1, name);
                stmt.setString(2, password);
                stmt.setString(3, email);
                stmt.setString(4, profile);
                stmt.setString(5, department);
                stmt.setString(6, university);
                stmt.setInt(7, Integer.parseInt(year));

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    out.println("Registration successful!");
                } else {
                    out.println("Registration failed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("Database error: " + e.getMessage());
            }
        } else {
            out.println("Passwords do not match.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for student registration and login";
    }
}
