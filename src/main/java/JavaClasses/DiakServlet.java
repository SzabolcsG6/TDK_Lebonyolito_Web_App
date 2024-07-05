package JavaClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DiakServlet")
public class DiakServlet extends HttpServlet {
    private DiakDAO diakDAO = new DiakDAO();

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
            Diak diak = diakDAO.getDiakByEmailAndPassword(email, password);
            if (diak != null) {
                out.println("Login successful!");
            } else {
                out.println("Invalid email or password.");
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
            Diak diak = new Diak(name, password, email, profile, department, university, Integer.parseInt(year));
            diakDAO.saveDiak(diak);
            out.println("Registration successful!");
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
