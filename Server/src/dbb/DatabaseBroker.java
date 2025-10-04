/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import validator.PasswordHash;
import domain.Cvecar;
import domain.OpstiDomenskiObjekat;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Saki
 */
public class DatabaseBroker {

    private static DatabaseBroker instance;
    private Connection connection;

    private DatabaseBroker() throws SQLException, Exception {
        try {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("dbconfiguration.properties"));
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Konekcija sa bazom podataka uspesno uspostavljena!");
                connection.setAutoCommit(false);
            } catch (Exception ex) {
                throw new Exception("Greška! Konekcija sa bazom nije uspešno uspostavljena!");
            }
            updatePasswordsToHashed();
        } catch (SQLException ex) {
        }
    }

    public static DatabaseBroker getInstance() throws SQLException, Exception {
        if (instance == null) {
            instance = new DatabaseBroker();
        }
        return instance;
    }

    public void updatePasswordsToHashed() throws SQLException {
        String query = "SELECT id, lozinka FROM cvecar";
        System.out.println(query);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String plainPassword = rs.getString("lozinka");
            if (plainPassword.length() != 64) {
                String hashedPassword = PasswordHash.hashPassword(plainPassword);
                String updateQuery = "UPDATE cvecar SET lozinka=? WHERE id=?";
                System.out.println(updateQuery);
                PreparedStatement ps = connection.prepareStatement(updateQuery);
                ps.setString(1, hashedPassword);
                ps.setInt(2, id);
                ps.executeUpdate();
            }
        }
        connection.commit();
        rs.close();
        stmt.close();
    }

    public void connect() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/proba1_baza";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Konekcija sa bazom podataka uspešno uspostavljena!");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Greška! Konekcija sa bazom nije uspešno uspostavljena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void disconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Konekcija sa bazom uspešno raskinuta!");
            }
        } catch (SQLException ex) {
            System.out.println("Greška! Konekcija sa bazom nije uspešno raskinuta!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void commit() throws SQLException {
        try {
            connection.commit();
            System.out.println("Transakcija uspešno potvrđena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije potvrđena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void rollback() throws SQLException {
        try {
            connection.rollback();
            System.out.println("Transakcija uspešno poništena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije poništena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<OpstiDomenskiObjekat> select(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.nazivTabele() + " " + odo.alijas()
                + " " + odo.join() + " " + odo.uslov();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.vratiListu(rs);
    }

    public PreparedStatement insert(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.nazivTabele() + " "
                + odo.koloneZaInsert() + " VALUES(" + odo.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();      
        return ps;
    }

    public void update(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "UPDATE " + odo.nazivTabele() + " SET "
                + odo.vrednostiZaUpdate() + " WHERE " + odo.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM " + odo.nazivTabele() + " WHERE " + odo.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
}
