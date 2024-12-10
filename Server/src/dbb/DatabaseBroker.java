/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbb;

import domain.Cvecar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cartman
 */
public class DatabaseBroker {

    private Connection connection;

    public DatabaseBroker() throws SQLException {
        connect();
    }

    
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

    public Cvecar prijaviCvecara(Cvecar cvecar) throws SQLException {
        try {
            String query= "SELECT * FROM cvecar "
                    + "WHERE korisnickoIme=? AND BINARY lozinka=?";
            System.out.println("Upit: " + query);

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cvecar.getKorisnickoIme());
            ps.setString(2, cvecar.getLozinka());
            
            ResultSet rs = ps.executeQuery();

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
            ps.close();
            System.out.println("Uspesno ucitavanje cvecara iz baze!");
            return cvecar;
        } catch (SQLException ex) {
            System.out.println("Cvecar nije uspesno ucitan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public void dodajCvecara(Cvecar c) throws SQLException {
      
        try {
            String upit="INSERT INTO cvecar (ime,prezime,korisnickoIme,lozinka) VALUES(?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(upit);
            ps.setString(1,c.getIme());
            ps.setString(2,c.getPrezime());
            ps.setString(3, c.getKorisnickoIme());
            ps.setString(4, c.getLozinka());
            ps.executeUpdate();
            connection.commit();
            ps.close();
            System.out.println("Uspesno dodavanje cvecara u bazu!");
        } catch (SQLException ex) {
            System.out.println("Cvecar nije uspesno dodat u bazu!");
            ex.printStackTrace();
            throw ex;
        }
            
        
    }

    public void promeniCvecara(Cvecar c) throws SQLException {
        try {
            String upit = "UPDATE cvecar SET ime=?,prezime=?, korisnickoIme=?,lozinka=? WHERE id=" +c.getId();
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setString(1, c.getIme());
            ps.setString(2, c.getPrezime());
            ps.setString(3, c.getKorisnickoIme());
            ps.setString(4, c.getLozinka());

            ps.executeUpdate();
            connection.commit();
            ps.close();
            System.out.println("Uspesna promena cvecara!");
        } catch (SQLException ex) {
            System.out.println("Cvecar nije uspesno promenjen!");
            ex.printStackTrace();
            throw ex;
        }

    }

    public List<Cvecar> ucitajCvecareIzBaze() throws SQLException {
        List<Cvecar> cvecari=new ArrayList<>();
        try {
            String upit="SELECT * FROM cvecar";
            Statement s=connection.createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                int id=rs.getInt("id");
                String ime=rs.getString("ime");
                String prezime=rs.getString("prezime");
                String kor=rs.getString("korisnickoIme");
                String lozinka=rs.getString("lozinka");
                
                Cvecar c=new Cvecar(id, ime, prezime, kor, lozinka);
                
              cvecari.add(c);
            }
            s.close();
            rs.close();
            System.out.println("Cvecari uspesno ucitani!");
        } catch (SQLException ex) {
            System.out.println("Cvecari nisu uspesno ucitani!");
            ex.printStackTrace();
            throw ex;
        }
        return cvecari;
    }

    public void obrisiCvecara(Cvecar c) throws SQLException {
        try {
            String upit="DELETE FROM cvecar WHERE id="+c.getId();
            Statement s=connection.createStatement();
            s.executeUpdate(upit);
            connection.commit();
            s.close();
            System.out.println("Cvecar uspesno obrisan!");
        } catch (SQLException ex) {
            System.out.println("Cvecar nije uspesno obrisan!");
            ex.printStackTrace();
            throw ex;
        }
    }

}
