/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClasses;

/**
 *
 * @author misim
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdatbazisKezelo {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String FELHASZNALO = "root";
    private static final String JELSZO = "xR26.BDezso";

    public static boolean felhasznaloHozzaadas(String nev, String email, String jelszo, String egyetem, String kar, String szak, String evfolyam) {
        Connection kapcsolat = null;
        PreparedStatement elokeszitettLekerdezes = null;
        boolean sikeres = false;

        try {
            kapcsolat = DriverManager.getConnection(URL, FELHASZNALO, JELSZO);
            String lekerdezes = "INSERT INTO felhasznalok (nev, email, jelszo, egyetem, kar, szak, evfolyam) VALUES (?, ?, ?, ?, ?, ?, ?)";
            elokeszitettLekerdezes = kapcsolat.prepareStatement(lekerdezes);
            elokeszitettLekerdezes.setString(1, nev);
            elokeszitettLekerdezes.setString(2, email);
            elokeszitettLekerdezes.setString(3, jelszo);
            elokeszitettLekerdezes.setString(4, egyetem);
            elokeszitettLekerdezes.setString(5, kar);
            elokeszitettLekerdezes.setString(6, szak);
            elokeszitettLekerdezes.setString(7, evfolyam);

            elokeszitettLekerdezes.executeUpdate();
            sikeres = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (elokeszitettLekerdezes != null) {
                try {
                    elokeszitettLekerdezes.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (kapcsolat != null) {
                try {
                    kapcsolat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return sikeres;
    }
}