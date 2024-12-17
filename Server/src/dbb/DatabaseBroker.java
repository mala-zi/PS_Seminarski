/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbb;

import domain.Aranzman;
import domain.Cvecar;
import domain.Kupac;
import domain.Mesto;
import domain.Otpremnica;
import domain.PoreskaStopa;
import domain.StavkaOtpremnice;
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
            System.out.println("current u bazi:"+currentPass);
            System.out.println("sad kod cvecara:"+cvecarChange.getLozinka());
            if(currentPass.length()==64 && currentPass.length()==cvecarChange.getLozinka().length()){
                break;
            }
            System.out.println("usaooo22");
            String hashedPassword = PasswordHash.hashPassword(cvecarChange.getLozinka());
            System.out.println("nova hesirana:"+hashedPassword);
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
            String upit = "UPDATE cvecar SET ime=?,prezime=?, korisnickoIme=? WHERE id=" +c.getId();
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setString(1, c.getIme());
            ps.setString(2, c.getPrezime());
            ps.setString(3, c.getKorisnickoIme());

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

    public List<Kupac> ucitajKupceIzBaze() throws SQLException {
        List<Kupac> kupci=new ArrayList<>();
        try {
            String upit="SELECT * FROM  kupac k JOIN "
                    + "mesto m ON k.idMesto=m.id";
            Statement s=connection.createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                int idK=rs.getInt("k.id");
                int pibK=rs.getInt("k.pib");
                String tel=rs.getString("k.telefon");
                String email=rs.getString("k.email");
                String naziv=rs.getString("k.naziv");
                
                int idM=rs.getInt("m.id");
                String grad=rs.getString("m.grad");
                int pB=rs.getInt("m.postanskiBroj");
                String ulica=rs.getString("m.ulica");
                
                Mesto mesto=new Mesto(idM, grad, pB, ulica);
                Kupac k=new Kupac(idK, pibK, tel, email, mesto,naziv);
                kupci.add(k);
            }
            s.close();
            rs.close();
            System.out.println("Kupci uspesno ucitani!");
        } catch (SQLException ex) {
            System.out.println("Kupci nisu uspesno ucitani!");
            ex.printStackTrace();
            throw ex;
        }
        return kupci;
    }

    public List<Aranzman> ucitajAranzmaneIzBaze() throws SQLException {
        List<Aranzman> aranzmani=new ArrayList<>();
        try {
            String upit="SELECT * FROM  aranzman a JOIN "
                    + "poreskaStopa ps ON a.poreskaStopa=ps.id";
            Statement s=connection.createStatement();
            ResultSet rs=s.executeQuery(upit);
            while(rs.next()){
                int idA=rs.getInt("a.id");
                String naziv=rs.getString("a.naziv");
                String opis=rs.getString("a.opis");
                double popust=rs.getDouble("a.popust");
                double cenaBez=rs.getDouble("a.cenaBezPDV");
                double cenaSa=rs.getDouble("a.cenaSaPDV");
                
                int idp=rs.getInt("ps.id");
                double vrednost=rs.getDouble("ps.vrednost");
                
                PoreskaStopa ps=new PoreskaStopa(idp, vrednost);
                Aranzman a=new Aranzman(idA, naziv, opis, ps, cenaBez, cenaSa, popust);
                aranzmani.add(a);
            }
            s.close();
            rs.close();
            System.out.println("Aranzmani uspesno ucitani!");
        } catch (SQLException ex) {
            System.out.println("Aranzmani nisu uspesno ucitani!");
            ex.printStackTrace();
            throw ex;
        }
        return aranzmani;
    }

    public Otpremnica kreirajOtpremnicu(Otpremnica otp) throws SQLException {
        try {
            String upit="INSERT INTO otpremnica (datumIzdavanja,ukupanIznosBezPDV,ukupanIznosSaPDV,ukupanPopust,idCvecar,idKupac)"
                    + " VALUES (?,?,?,?,?,?) ";
            PreparedStatement ps=connection.prepareStatement(upit);
            java.sql.Date sqlDate=new java.sql.Date(otp.getDatumIzdavanja().getTime());
            ps.setDate(1, sqlDate);
            ps.setDouble(2, otp.getUkupanIznosBezPDv());
            ps.setDouble(3, otp.getUkupanIznosSaPDV());
            ps.setDouble(4, otp.getUkupanPopust());
            ps.setInt(5, otp.getCvecar().getId());
            ps.setInt(6, otp.getKupac().getId());
            ps.executeUpdate();
            connection.commit();
            
            String upit2="SELECT * FROM otpremnica WHERE datumIzdavanja=? AND ukupanIznosBezPDV=? AND ukupanIznosSaPDV=? AND ukupanPopust=? AND idCvecar=? AND idKupac=?";
            PreparedStatement ps2=connection.prepareStatement(upit2);
            
            ps2.setDate(1, sqlDate);
            ps2.setDouble(2, otp.getUkupanIznosBezPDv());
            ps2.setDouble(3, otp.getUkupanIznosSaPDV());
            ps2.setDouble(4, otp.getUkupanPopust());
            ps2.setInt(5, otp.getCvecar().getId());
            ps2.setInt(6, otp.getKupac().getId());
            ResultSet rs=ps2.executeQuery();
            if(rs.next()){
                int id=rs.getInt("otpremnica.id");
                otp.setId(id);
            }
            connection.commit();
            
            ps.close();
            rs.close();
            ps2.close();
            System.out.println("Otpremnica uspesno kreirana!");
            
        } catch (SQLException ex) {
            System.out.println("Otpremnica neuspesno kreirana!");
            ex.printStackTrace();
            throw ex;
        }
        return otp;
    }

    public void dodajStavkuOtpremnice(StavkaOtpremnice so) throws SQLException {
        try {
            String upit = "INSERT INTO stavkaotpremnice (idOtpremnica,kolicina,napomena,iznosBezPDV,iznosSaPDV,cenaBezPDV,cenaSaPDV,idAranzman)"
                    + " VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1, so.getOtpremnica().getId());
            ps.setInt(2, so.getKolicina());
            ps.setString(3, so.getNapomena());
            ps.setDouble(4, so.getIznosBezPDV());
            ps.setDouble(5, so.getIznosSaPDV());
            ps.setDouble(6, so.getCenaBezPDV());
            ps.setDouble(7, so.getCenaSaPdDV());
            ps.setInt(8, so.getAranzman().getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("Uspesno dodavanje stavke u bazu!");
        } catch (SQLException ex) {
            System.out.println("Stavka nije uspesno dodata u bazu!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public void promeniLozinkuCvecara(Cvecar cvecarLozinkaPromena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
