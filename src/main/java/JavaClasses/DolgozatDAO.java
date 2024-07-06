/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClasses;

/**
 *
 * @author misim
 */


import JavaClasses.Dolgozat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DolgozatDAO {
    private final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private final String user = "root";
    private final String password = "xR26.BDezso";

    // Konstruktor, amelyben inicializáljuk a JDBC kapcsolatot
    public DolgozatDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Metódus a Dolgozat objektum beszúrására az adatbázisba
    public void saveDolgozat(Dolgozat dolgozat) {
        String sql = "INSERT INTO dolgozat (cim, kategoria, kivonat, vezetoTanarok, jegy) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Adatok beállítása a prepared statement segítségével
            stmt.setString(1, dolgozat.getCim());
            stmt.setString(2, dolgozat.getKategoria());
            stmt.setString(3, dolgozat.getKivonat());
            stmt.setString(4, dolgozat.getVezetoTanarok());
            stmt.setLong(5, dolgozat.getJegy());

            // Beszúrás végrehajtása
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public List<Dolgozat> getAllDolgozat() {
        List<Dolgozat> dolgozatList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM Dolgozat";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Dolgozat dolgozat = new Dolgozat(
                        resultSet.getInt("Dolgozat_Id"),
                        resultSet.getString("cim"),
                        resultSet.getString("kategoria"),
                        resultSet.getString("kivonat"),
                        resultSet.getString("vezetoTanarok"),
                        resultSet.getBlob("dolgozatFile"),
                        resultSet.getBoolean("elfogadva"),
                        resultSet.getLong("jegy")
                    );
                    dolgozatList.add(dolgozat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dolgozatList;
    }

    public List<Dolgozat> getDolgozatByDiakId(int diakId) {
        List<Dolgozat> dolgozatList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT d.* FROM Dolgozat d JOIN DolgozatDiak dd ON d.Dolgozat_Id = dd.Dolgozat_Id WHERE dd.Diak_Id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, diakId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Dolgozat dolgozat = new Dolgozat(
                        resultSet.getInt("Dolgozat_Id"),
                        resultSet.getString("cim"),
                        resultSet.getString("kategoria"),
                        resultSet.getString("kivonat"),
                        resultSet.getString("vezetoTanarok"),
                        resultSet.getBlob("dolgozatFile"),
                        resultSet.getBoolean("elfogadva"),
                        resultSet.getLong("jegy")
                    );
                    dolgozatList.add(dolgozat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dolgozatList;
    }
    // Metódus a Dolgozat objektum lekérdezésére azonosító alapján
    public Dolgozat getDolgozatById(int dolgozatId) {
        Dolgozat dolgozat = null;
        String sql = "SELECT * FROM dolgozat WHERE DolgozatId = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dolgozatId);
            ResultSet resultSet = stmt.executeQuery();

            // Ha van találat, létrehozunk egy Dolgozat objektumot és beállítjuk az attribútumokat
            if (resultSet.next()) {
                dolgozat = new Dolgozat();
                dolgozat.setDolgozatId(resultSet.getInt("DolgozatId"));
                dolgozat.setCim(resultSet.getString("cim"));
                dolgozat.setKategoria(resultSet.getString("kategoria"));
                dolgozat.setKivonat(resultSet.getString("kivonat"));
                dolgozat.setVezetoTanarok(resultSet.getString("vezetoTanarok"));
                dolgozat.setJegy(resultSet.getLong("jegy"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dolgozat;
    }
 // Metódus a Dolgozat objektum frissítésére az adatbázisban azonosító alapján
    public void updateDolgozat(Dolgozat dolgozat) {
        String sql = "UPDATE dolgozat SET cim = ?, kategoria = ?, kivonat = ?, vezetoTanarok = ?, jegy = ? WHERE DolgozatId = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Adatok beállítása a prepared statement segítségével
            stmt.setString(1, dolgozat.getCim());
            stmt.setString(2, dolgozat.getKategoria());
            stmt.setString(3, dolgozat.getKivonat());
            stmt.setString(4, dolgozat.getVezetoTanarok());
            stmt.setLong(5, dolgozat.getJegy());
            stmt.setInt(6, dolgozat.getDolgozatId());

            // Frissítés végrehajtása
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metódus a Dolgozat objektum törlésére az adatbázisban azonosító alapján
    public void deleteDolgozat(int dolgozatId) {
        String sql = "DELETE FROM dolgozat WHERE DolgozatId = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dolgozatId);

            // Törlés végrehajtása
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private List<Diak> getSzerzokByDolgozatId(int dolgozatId) {
        List<Diak> szerzok = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT d.* FROM Diak d JOIN DolgozatDiak dd ON d.Diak_Id = dd.Diak_Id WHERE dd.Dolgozat_Id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, dolgozatId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Diak diak = new Diak( 
                        resultSet.getString("nev"),
                        resultSet.getString("jelszo"),
                        resultSet.getString("email"),
                        resultSet.getString("szak"),
                        resultSet.getString("kar"),
                        resultSet.getString("Egyetem"),
                        resultSet.getInt("evfolyam")
                    );
                    szerzok.add(diak);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return szerzok;
    }
}
