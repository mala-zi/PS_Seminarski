/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import domain.Cvecar;
import domain.OpstiDomenskiObjekat;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class DatabaseBroker {

    private static DatabaseBroker instance;
    private Connection connection;

    private DatabaseBroker() throws SQLException {
        try {
            connect();
            updatePasswordsToHashed();
            String url = "jdbc://localhost/3306/proba1_baza";
            connection = DriverManager.getConnection(url, "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
        }
    }

    public static DatabaseBroker getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseBroker();

        }
        return instance;
    }

    public void updatePasswordsToHashed() throws SQLException {
        String query = "SELECT id, lozinka FROM cvecar";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String plainPassword = rs.getString("lozinka");
            if (plainPassword.length() == 64) {
                break;
            }
            String hashedPassword = PasswordHash.hashPassword(plainPassword);

            String updateQuery = "UPDATE cvecar SET lozinka=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(updateQuery);
            ps.setString(1, hashedPassword);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        connection.commit();
        rs.close();
        stmt.close();
    }

    public void updateNewPasswordToHash(Cvecar cvecarChange) throws SQLException {
        String query = "SELECT lozinka FROM cvecar WHERE id=" + cvecarChange.getId();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("usaooo");
        while (rs.next()) {
            String currentPass = rs.getString("lozinka");
            System.out.println("current u bazi:" + currentPass);
            System.out.println("sad kod cvecara:" + cvecarChange.getLozinka());
            if (currentPass.length() == 64 && currentPass.length() == cvecarChange.getLozinka().length()) {
                break;
            }
            System.out.println("usaooo22");
            String hashedPassword = PasswordHash.hashPassword(cvecarChange.getLozinka());
            System.out.println("nova hesirana:" + hashedPassword);
            cvecarChange.setLozinka(hashedPassword);
            String updateQuery = "UPDATE cvecar SET lozinka=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(updateQuery);
            ps.setString(1, hashedPassword);
            ps.setInt(2, cvecarChange.getId());
            ps.executeUpdate();
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
            System.out.println("Konekcija sa bazom podataka uspesno uspostavljena!");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Greska! Konekcija sa bazom nije uspesno uspostavljena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void disconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Konekcija sa bazom uspesno raskinuta!");
            }
        } catch (SQLException ex) {
            System.out.println("Greska! Konekcija sa bazom nije uspesno raskinuta!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void commit() throws SQLException {
        try {
            connection.commit();
            System.out.println("Transakcija uspesno potvrdjena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije potvrdjena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void rollback() throws SQLException {
        try {
            connection.rollback();
            System.out.println("Transakcija uspesno ponistena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije ponistena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<OpstiDomenskiObjekat> select(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.nazivTabele() + " " + odo.alijas()
                + " " + odo.join() + " "+ odo.uslov();
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
