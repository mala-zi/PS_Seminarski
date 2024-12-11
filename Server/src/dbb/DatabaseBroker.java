/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbb;

import domain.Cvecar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cartman
 */
public class DatabaseBroker {

    private Connection connection;

    public DatabaseBroker() throws SQLException {
        connect();
        updatePasswordsToHashed();
    }

    public void updatePasswordsToHashed() throws SQLException {
        String query = "SELECT id, lozinka FROM cvecar";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String plainPassword = rs.getString("lozinka");
            if(plainPassword.length()==64){
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
        String query = "SELECT lozinka FROM cvecar WHERE id="+cvecarChange.getId();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("usaooo");
        while (rs.next()) {
            String currentPass = rs.getString("lozinka");
            System.out.println(currentPass);
            System.out.println(cvecarChange.getLozinka());
            if(currentPass.length()==64 && currentPass.length()==cvecarChange.getLozinka().length()){
                break;
            }
            System.out.println("usaooo22");
            String hashedPassword = PasswordHash.hashPassword(cvecarChange.getLozinka());
            System.out.println(hashedPassword);
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

    public Cvecar prijaviCvecara(Cvecar cvecar) throws SQLException {
        
        try {
            String query = "SELECT * FROM cvecar WHERE korisnickoIme=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cvecar.getKorisnickoIme());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("lozinka");

                String inputHashedPassword = PasswordHash.hashPassword(cvecar.getLozinka());
               // System.out.println(inputHashedPassword);
               // System.out.println(storedHashedPassword);
                if (storedHashedPassword.equals(inputHashedPassword)) {
                    cvecar.setId(rs.getInt("id"));
                    cvecar.setIme(rs.getString("ime"));
                    cvecar.setPrezime(rs.getString("prezime"));
                } else {
                    throw new SQLException("Pogrešna lozinka!");
                }
            } else {
                throw new SQLException("Korisnik ne postoji!");
            }

            rs.close();
            ps.close();

            return cvecar;
        } catch (SQLException ex) {
            System.out.println("Greška pri prijavi korisnika: " + ex.getMessage());
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
            s.close();
            System.out.println("Cvecar uspesno obrisan!");
        } catch (SQLException ex) {
            System.out.println("Cvecar nije uspesno obrisan!");
            ex.printStackTrace();
            throw ex;
        }
    }

}
