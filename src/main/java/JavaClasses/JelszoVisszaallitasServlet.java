/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package JavaClasses;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Properties;
import java.util.Random;


import jakarta.mail.*;
import jakarta.mail.internet.*;


@WebServlet("/JelszoVisszaallitasServlet")
public class JelszoVisszaallitasServlet extends HttpServlet {

    private DiakDAO diakDAO = new DiakDAO(); // Assuming DiakDAO is your data access object

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("mail_passw_res");
            Diak diak = diakDAO.getDiakByEmail(email);

            if (diak != null) {
         
                String newPassword = generateRandomPassword();
                
              
                diak.setJelszo(newPassword);
                
              
                diakDAO.updateDiak(diak);
                
                sendPasswordResetEmail(diak.getEmail(), newPassword);
                
                out.println("Jelszó visszaállítása sikeres! Ellenőrizze e-mail fiókját.");
                response.sendRedirect("JelszoVisszaallitas.jsp"); // Redirect to a success page or back to the form
            } else {
                out.println("Nem található felhasználó ezzel az e-mail címmel!");
            }
        }
    }

    private String generateRandomPassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_+-=";
        String allCharacters = upper + lower + numbers + symbols;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(allCharacters.length());
            sb.append(allCharacters.charAt(index));
        }
        return sb.toString();
    }

    private void sendPasswordResetEmail(String email, String newPassword) {
    // SMTP server information
    String from = "szabolcs.g38@gmail.com";
    String host = "mail.smtp2go.com"; // Replace with your SMTP server host
    final String username = "g_szabolcs@fastmail.com"; // SMTP username
    final String password = "JGaOfOiG9RahFWqg"; // SMTP password

    // Set up the SMTP properties
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "587"); // SMTP port (TLS)

    // Create a session with the specified properties and authenticator
    Session session = Session.getInstance(properties, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });

    try {
        // Create a default MimeMessage object
        MimeMessage message = new MimeMessage(session);

        // Set the From, To, Subject, and Body fields
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Jelszo Visszaallitas");
        message.setText("Az uj jelszava: " + newPassword);

        // Send the message
        Transport.send(message);
        System.out.println("Sikeres jelszovisszaallitas!");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }
}
}
