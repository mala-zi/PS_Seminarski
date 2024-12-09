/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbb;

import domain.Cvecar;
import java.sql.*;

/**
 *
 * @author Cartman
 */
public class DatabaseBroker {

    private Connection connection;

    public void connect() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/proba1_baza";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Konekcija sa bazom podataka uspesno uspostavljena!");

            //iskljucujemo automatsko potvrdjivanje transakcije nakon svakog upita
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

    public Cvecar getUser(Cvecar cvecar) throws SQLException {
        try {
            String query= "SELECT * FROM cvecar "
                    + "WHERE korisnickoIme=? AND BINARY lozinka=?";
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cvecar.getKorisnickoIme());
            statement.setString(2, cvecar.getLozinka());
            //izvsi upit
            ResultSet rs = statement.executeQuery();

            //pristup rezultatima upita
            if (rs.next()) {
                cvecar.setId(rs.getInt("id"));
                cvecar.setIme(rs.getString("ime"));
                cvecar.setPrezime(rs.getString("prezime"));             
            }else{
                throw  new SQLException("Korisnik ne postoji!!!");
            }
            //oslobadjanje resursa
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekta User iz baze!");
            return cvecar;
        } catch (SQLException ex) {
            System.out.println("Objekat User nije uspesno ucitan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

}
