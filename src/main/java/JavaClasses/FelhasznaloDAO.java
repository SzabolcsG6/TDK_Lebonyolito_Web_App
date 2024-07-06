package JavaClasses;

import JavaClasses.Felhasznalo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FelhasznaloDAO {
    private final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private final String user = "root";
    private final String password = "xR26.BDezso";

    // Konstruktor, amelyben inicializáljuk a JDBC kapcsolatot
    public FelhasznaloDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Metódus a felhasználó objektum beszúrására az adatbázisba
    public void saveFelhasznalo(Felhasznalo felhasznalo) {
        String sql = "INSERT INTO felhasznalo (nev, jelszo, email, szak, kar, egyetem) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, felhasznalo.getNev());
            stmt.setString(2, felhasznalo.getJelszo());
            stmt.setString(3, felhasznalo.getEmail());
            stmt.setString(4, felhasznalo.getSzak());
            stmt.setString(5, felhasznalo.getKar());
            stmt.setString(6, felhasznalo.getEgyetem());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public Felhasznalo getFelhasznaloByEmailAndPassword(String email, String password) {
        Felhasznalo felhasznalo = null;
        String sql = "SELECT * FROM felhasznalo WHERE email = ? AND jelszo = ?";

        ResultSet resultSet = null;
        try (Connection conn = DriverManager.getConnection(url, user, this.password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                felhasznalo = new Felhasznalo(
                        resultSet.getString("nev"),
                        resultSet.getString("jelszo"),
                        resultSet.getString("email"),
                        resultSet.getString("szak"),
                        resultSet.getString("kar"),
                        resultSet.getString("egyetem")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return felhasznalo;
    }

    // Metódus a felhasználó objektum lekérdezésére azonosító alapján
    public Felhasznalo getFelhasznaloById(int felhasznaloId) {
        Felhasznalo felhasznalo = null;
        String sql = "SELECT * FROM felhasznalo WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, felhasznaloId);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                felhasznalo = new Felhasznalo(
                        resultSet.getString("nev"),
                        resultSet.getString("jelszo"),
                        resultSet.getString("email"),
                        resultSet.getString("szak"),
                        resultSet.getString("kar"),
                        resultSet.getString("egyetem")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return felhasznalo;
    }
// Metódus a felhasználó objektum törlésére az adatbázisban azonosító alapján
public void deleteFelhasznalo(int felhasznaloId) {
    String sql = "DELETE FROM felhasznalo WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, felhasznaloId);
        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Metódus a felhasználó objektum frissítésére az adatbázisban azonosító alapján
public void updateFelhasznalo(Felhasznalo felhasznalo) {
    String sql = "UPDATE felhasznalo SET nev = ?, jelszo = ?, email = ?, szak = ?, kar = ?, egyetem = ? WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, felhasznalo.getNev());
        stmt.setString(2, felhasznalo.getJelszo());
        stmt.setString(3, felhasznalo.getEmail());
        stmt.setString(4, felhasznalo.getSzak());
        stmt.setString(5, felhasznalo.getKar());
        stmt.setString(6, felhasznalo.getEgyetem());
        stmt.setInt(7, felhasznalo.getId());

        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
