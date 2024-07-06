package JavaClasses;

import JavaClasses.Felhasznalo; // Assuming you have a Felhasznalo class
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FelhasznaloServlet")
public class FelhasznaloServlet extends HttpServlet {
    private FelhasznaloDAO felhasznaloDAO = new FelhasznaloDAO(); // Assuming you have a FelhasznaloDAO class

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action == null) {
                action = "login";
            }

            switch (action) {
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
            Felhasznalo felhasznalo = felhasznaloDAO.getFelhasznaloByEmailAndPassword(email, password);
            if (felhasznalo != null) {
                HttpSession session = request.getSession();
                session.setAttribute("logged_in_user", felhasznalo);
                
                out.println("Sikeres bejelentkezés!");
                response.sendRedirect("Dolgozatok.jsp");
            } else {
                out.println("Helytelen e-mail/jelszó!");
            }
        } else {
            out.println("Mindkét információ szükséges bejelentkezéshez!");
            response.sendRedirect("Jelentkezes.jsp");
        }
    }
//Ez nem feltétlenűl használva lesz, a zsűritagok nem regisztrálnak, hanem a web alkalmazást intéző illető szerepe azt lebonyolítani
    
// private void handleRegister(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
//        throws ServletException, IOException {
//    String name = request.getParameter("name");
//    String email = request.getParameter("mail");
//    String password = request.getParameter("password");
//    String password2 = request.getParameter("password2");
//    String university = request.getParameter("univers");
//    String department = request.getParameter("department");
//    String profile = request.getParameter("profile");
//
//    if (password.equals(password2)) {
//        Felhasznalo felhasznalo = new Felhasznalo(name, password, email, profile, department, university);
//        felhasznaloDAO.saveFelhasznalo(felhasznalo);
//        out.println("Sikeres regisztráció!");
//        response.sendRedirect("Jelentkezes.jsp");
//        
//    } else {
//        out.println("Nem egyeznek a jelszavak!");
//    }
//}


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
        return "Servlet Felhasználó regisztrálás és belépésre";
    }
}
