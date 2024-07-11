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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DolgozatDiakDAO {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "xR26.BDezso";

    // Konstruktor, amelyben inicializáljuk a JDBC kapcsolatot
    public DolgozatDiakDAO() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    // Metódus a diák dolgozatok beszúrására az adatbázisba
    public void addDolgozatDiak(int dolgozatId, int diakId) {
    String sql = "INSERT INTO DolgozatDiak (Dolgozat_Id, Diak_Id) VALUES (?, ?)";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, dolgozatId);
        stmt.setInt(2, diakId);
        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Metódus a diák dolgozatok lekérdezésére az adatbázisból
      public static List<Integer> getDolgozatIdsByDiakId(int diakId) {
    List<Integer> dolgozatIds = new ArrayList<>();
    String sql = "SELECT Dolgozat_Id FROM DolgozatDiak WHERE Diak_Id = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, diakId);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            int dolgozatId = resultSet.getInt("Dolgozat_Id");
           
            dolgozatIds.add(dolgozatId);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dolgozatIds;
}
  public static List<Integer> getDolgozatIdsByFelhasznaloId(int Id) {
    List<Integer> dolgozatIds = new ArrayList<>();
    String sql = "SELECT Dolgozat_Id FROM DolgozatZsuri WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, Id);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            int dolgozatId = resultSet.getInt("Dolgozat_Id");
            //System.out.println("Found DolgozatId: " + dolgozatId); // Debugging line
            dolgozatIds.add(dolgozatId);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dolgozatIds;
}
public static Dolgozat getDolgozatById(int dolgozatId) {
    Dolgozat dolgozat = null;
    String sql = "SELECT * FROM dolgozat WHERE Dolgozat_Id = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, dolgozatId);
        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            dolgozat = new Dolgozat();
            dolgozat.setDolgozatId(resultSet.getInt("Dolgozat_Id"));
            dolgozat.setCim(resultSet.getString("cim"));
            dolgozat.setKategoria(resultSet.getString("kategoria"));
            dolgozat.setVezetoTanarok(resultSet.getString("vezetoTanarok"));
            dolgozat.setElfogadva(resultSet.getBoolean("elfogadva"));
            dolgozat.setJegy(resultSet.getLong("jegy"));
            
           
            System.out.println("Megkapott dolgozat: " + dolgozat);
        } else {
            System.out.println("Nincs dolgozat ilyen Id-vel: " + dolgozatId); 
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dolgozat;
}

}