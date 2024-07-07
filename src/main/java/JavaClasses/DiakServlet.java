package JavaClasses;

import JavaClasses.Diak;
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
import jakarta.servlet.http.HttpSession;
import java.util.HashSet;

@WebServlet("/DiakServlet")
public class DiakServlet extends HttpServlet {
    private DiakDAO diakDAO = new DiakDAO();
    private FelhasznaloDAO felhasznaloDAO = new FelhasznaloDAO();

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
            // Try to login as Diak
            Diak diak = diakDAO.getDiakByEmailAndPassword(email, password);
            if (diak != null) {
                HttpSession session = request.getSession();
                session.setAttribute("logged_in_user", diak);
               out.println("<script type=\"text/javascript\">");
            out.println("alert('Diák sikeres bejelentkezés!');");
            out.println("window.location.href = 'Dolgozatok.jsp';");
            out.println("</script>");
                return;
            }

          
            Felhasznalo felhasznalo = felhasznaloDAO.getFelhasznaloByEmailAndPassword(email, password);
            if (felhasznalo != null) {
                HttpSession session = request.getSession();
                session.setAttribute("logged_in_felhasznalo", felhasznalo);
                out.println("<script type=\"text/javascript\">");
            out.println("alert('Zsűri tag sikeres bejelentkezés!');");
            out.println("window.location.href = 'Biralatok.jsp';");
            out.println("</script>");
                return; 
            }

             out.println("<script type=\"text/javascript\">");
            out.println("alert('Helytelen e-mail/jelszó!');");
             out.println("window.location.href = 'Jelentkezes.jsp';");
            out.println("</script>");
        } else {
              out.println("<script type=\"text/javascript\">");
            out.println("alert('Mindkét információ szükséges bejelentkezéshez!');");
             out.println("window.location.href = 'Jelentkezes.jsp';");
            out.println("</script>");
        }
        response.sendRedirect("Jelentkezes.jsp");
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

        
        if (diakDAO.isEmailExists(email)) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Az e-mail cím már használatban van!');");
        out.println("window.location.href = 'Jelentkezes.jsp';");
        out.println("</script>");}
       
        else if (password.equals(password2)) {
            Diak diak = new Diak(name, password, email, profile, department, university, Integer.parseInt(year));
            diakDAO.saveDiak(diak);
              out.println("<script type=\"text/javascript\">");
              out.println("alert('Diák sikeres regisztráció!');");
            out.println("window.location.href = 'Jelentkezes.jsp';");
              out.println("</script>");
            
        } else {
              out.println("<script type=\"text/javascript\">");         
            out.println("alert('Nem egyeznek a jelszavak!');");
                out.println("window.location.href = 'Jelentkezes.jsp';");
               out.println("</script>");
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
        return "Servlet Diák regisztrálás és belépésre";
    }
}
