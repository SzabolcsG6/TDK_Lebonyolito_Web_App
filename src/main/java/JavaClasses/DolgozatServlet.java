/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package JavaClasses;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.PrintWriter;

@WebServlet(name = "DolgozatServlet", urlPatterns = {"/DolgozatServlet"})
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class DolgozatServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int diakId = getLoggedInDiakId(request);

        DolgozatDiakDAO dolgozatDiakDAO = new DolgozatDiakDAO();
        List<Integer> dolgozatIds = dolgozatDiakDAO.getDolgozatIdsByDiakId(diakId);

        DolgozatDAO dolgozatDAO = new DolgozatDAO();
        List<Dolgozat> dolgozatList = new ArrayList<>();

        for (int dolgozatId : dolgozatIds) {
            Dolgozat dolgozat = dolgozatDAO.getDolgozatById(dolgozatId);
            if (dolgozat != null) {
                dolgozatList.add(dolgozat);
            }
        }

        request.setAttribute("dolgozatList", dolgozatList);
        request.setAttribute("diakId", diakId);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cim = request.getParameter("cim");
        String kategoria = request.getParameter("kategoria");
        String kivonat = request.getParameter("kivonat");
        String vezetoTanarok = request.getParameter("vezetoTanarok");
        Long jegy = 1L;

        // Fájl alapértelmezett értékének beállítása
        Blob dolgozatFile = null;

        Part filePart = request.getPart("file");
        if (filePart != null && filePart.getSize() > 0) {
            try (InputStream inputStream = filePart.getInputStream()) {
                dolgozatFile = new javax.sql.rowset.serial.SerialBlob(inputStream.readAllBytes());
            } catch (SQLException e) {
                throw new ServletException("Fájl feldolgozási hiba", e);
            }
        }

        Dolgozat dolgozat = new Dolgozat();
        dolgozat.setCim(cim);
        dolgozat.setKategoria(kategoria);
        dolgozat.setKivonat(kivonat);
        dolgozat.setVezetoTanarok(vezetoTanarok);
        dolgozat.setDolgozatFile(dolgozatFile);
        dolgozat.setJegy(jegy);
        DolgozatDAO dolgozatDAO = new DolgozatDAO();
        int diakId = getLoggedInDiakId(request);
            DolgozatDiakDAO dolgozatDiakDAO = new DolgozatDiakDAO();
             int dolgozatId = dolgozatDAO.saveDolgozat(dolgozat);
                response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<script type=\"text/javascript\">");
    out.println("alert('Dolgozat ID: " + dolgozatId + ", Diák ID: " + diakId + "');");
    out.println("</script>");
            dolgozatDiakDAO.addDolgozatDiak(dolgozatId,diakId);
        doGet(request, response); // Visszairányítás a doGet metódushoz, hogy frissítse a dolgozatokat
    }

    private int getLoggedInDiakId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object diakIdObj = session.getAttribute("diak_id");
        if (diakIdObj != null) {
            return (Integer) diakIdObj; // Biztonságos típuskonverzió
        } else {
            return 0; // Vagy egyéb alapérték, ha nincs bejelentkezve diák
        }
    }
}
