/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClasses;

/**
 *
 * @author misim
 */

import JavaClasses.Diak;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiakDAO {
    private final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private final String user = "root";
    private final String password = "xR26.BDezso";

    public DiakDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveDiak(Diak diak) {
        String sql = "INSERT INTO diak (nev, jelszo, email, szak, kar, egyetem, evfolyam) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, diak.getNev());
            stmt.setString(2, diak.getJelszo());
            stmt.setString(3, diak.getEmail());
            stmt.setString(4, diak.getSzak());
            stmt.setString(5, diak.getKar());
            stmt.setString(6, diak.getEgyetem());
            stmt.setInt(7, diak.getEvfolyam());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean isEmailExists(String email) {
    String sql = "SELECT COUNT(*) FROM diak WHERE email = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, email);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}

  public Diak getDiakByEmail(String email) {
        Diak diak = null;
        String sql = "SELECT * FROM diak WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                diak = new Diak(
                        resultSet.getString("nev"),
                        resultSet.getString("jelszo"),
                        resultSet.getString("email"),
                        resultSet.getString("szak"),
                        resultSet.getString("kar"),
                        resultSet.getString("egyetem"),
                        resultSet.getInt("evfolyam")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diak;
    }
    public Diak getDiakByEmailAndPassword(String email, String password) {
        Diak diak = null;
        String sql = "SELECT * FROM diak WHERE email = ? AND jelszo = ?";

        try (Connection conn = DriverManager.getConnection(url, user, this.password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                diak = new Diak(
                        resultSet.getString("nev"),
                        resultSet.getString("jelszo"),
                        resultSet.getString("email"),
                        resultSet.getString("szak"),
                        resultSet.getString("kar"),
                        resultSet.getString("egyetem"),
                        resultSet.getInt("evfolyam")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diak;
    }

    public void updateDiak(Diak diak) {
        String sql = "UPDATE diak SET nev = ?, jelszo = ?, email = ?, szak = ?, kar = ?, egyetem = ?, evfolyam = ? WHERE diak_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, diak.getNev());
            stmt.setString(2, diak.getJelszo());
            stmt.setString(3, diak.getEmail());
            stmt.setString(4, diak.getSzak());
            stmt.setString(5, diak.getKar());
            stmt.setString(6, diak.getEgyetem());
            stmt.setInt(7, diak.getEvfolyam());
            stmt.setInt(8, diak.getDiak_id());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDiak(int id) {
        String sql = "DELETE FROM diak WHERE diak_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
