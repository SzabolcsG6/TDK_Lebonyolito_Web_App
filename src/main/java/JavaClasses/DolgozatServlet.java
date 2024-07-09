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

@WebServlet(name = "DolgozatServlet", urlPatterns = {"/DolgozatServlet"})
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class DolgozatServlet extends HttpServlet {

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


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cim = request.getParameter("cim");
        String kategoria = request.getParameter("kategoria");
        String kivonat = request.getParameter("kivonat");
        String vezetoTanarok = request.getParameter("vezetoTanarok");
        Long jegy = Long.parseLong(request.getParameter("jegy"));

        InputStream inputStream = null;

        Part filePart = request.getPart("file");
        if (filePart != null && filePart.getSize() > 0) {
            inputStream = filePart.getInputStream();
        }

        try {
            Blob dolgozatFile = null;
            if (inputStream != null) {
                dolgozatFile = new javax.sql.rowset.serial.SerialBlob(inputStream.readAllBytes());
            }

            Dolgozat dolgozat = new Dolgozat();
            dolgozat.setCim(cim);
            dolgozat.setKategoria(kategoria);
            dolgozat.setKivonat(kivonat);
            dolgozat.setVezetoTanarok(vezetoTanarok);
            dolgozat.setDolgozatFile(dolgozatFile);
            dolgozat.setJegy(jegy);

            DolgozatDAO dolgozatDAO = new DolgozatDAO();
            dolgozatDAO.saveDolgozat(dolgozat);

            doGet(request, response); // Visszairányítás a doGet metódushoz, hogy frissítse a dolgozatokat
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private int getLoggedInDiakId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object diakIdObj = session.getAttribute("diak_Id");
        if (diakIdObj != null) {
            return (Integer) diakIdObj; // Biztonságos típuskonverzió
        } else {
            return 0; // Vagy egyéb alapérték, ha nincs bejelentkezve diák
        }
    }
}
