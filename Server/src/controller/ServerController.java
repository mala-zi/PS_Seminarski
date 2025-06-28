/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbb.PasswordHash;
import dbb.TransactionManager;
import domain.Aranzman;
import domain.Cvecar;
import domain.Kupac;
import domain.OpstiDomenskiObjekat;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import domain.StrucnaSprema;
import java.sql.SQLException;
import java.util.List;
import so.OpstaSistemskaOperacija;
import so.cvecar.SOPrijaviCvecara;
import validator.Validator;

/**
 *
 * @author Saki
 */
public class ServerController {
    private static ServerController instance;
   // private TransactionManager transactionManager;

    public static ServerController getInstance() throws Exception {
        if (instance == null) instance = new ServerController();
        return instance;
    }

    private ServerController() throws SQLException {
       // transactionManager = TransactionManager.getInstance();
    }

    public Object prijaviCvecara(OpstiDomenskiObjekat odo) throws SQLException, Exception {
        try {
            Validator.validateCvecarSign((Cvecar) odo);
           // String hashedPassword = PasswordHash.hashPassword(cvecar.getLozinka());
           // cvecar.setLozinka(hashedPassword);
            OpstaSistemskaOperacija oso=new SOPrijaviCvecara();
            //System.out.println((Cvecar)odo);
            oso.izvrsi(odo);
            return ((SOPrijaviCvecara)oso).getPrijavljenCvecar();
        } catch (IllegalArgumentException e) {
            System.out.println("Greška u validaciji: " + e.getMessage());
            throw new SQLException("Validacija nije prošla: " + e.getMessage());

        } catch (Exception e) {
           // transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public void dodajCvecara(Cvecar cvecarAdd) throws SQLException {
        try {
            Validator.validateCvecarAdd(cvecarAdd);
            String hashedPassword = PasswordHash.hashPassword(cvecarAdd.getLozinka());
            cvecarAdd.setLozinka(hashedPassword);
            //transactionManager.getDatabaseBroker().dodajCvecara(cvecarAdd);
           // transactionManager.commitTransaction();
        } catch (IllegalArgumentException e) {
            System.out.println("Greška u validaciji: " + e.getMessage());
            throw new SQLException("Validacija nije prošla: " + e.getMessage());

        } catch (Exception e) {
          //  transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public void promeniCvecara(Cvecar cvecarChange) throws SQLException {
        try {
            Validator.validateCvecarChange(cvecarChange);
           // transactionManager.getDatabaseBroker().promeniCvecara(cvecarChange);
           // transactionManager.commitTransaction();
    } catch (IllegalArgumentException e) {
            System.out.println("Greška u validaciji: " + e.getMessage());
            throw new SQLException("Validacija nije prošla: " + e.getMessage());

        } catch (Exception e) {
           // transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public List<Cvecar> ucitajCvecareIzBaze() throws SQLException {
        try {
            //return transactionManager.getDatabaseBroker().ucitajCvecareIzBaze();
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public void obrisiCvecara(Cvecar cvecarDelete) throws SQLException {
        try {
          //  transactionManager.getDatabaseBroker().obrisiCvecara(cvecarDelete);
          //  transactionManager.commitTransaction();
        } catch (Exception e) {
          //  transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public List<Kupac> ucitajKupceIzBaze() throws Exception {
        try {
           // return transactionManager.getDatabaseBroker().ucitajKupceIzBaze();
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List<Aranzman> ucitajAranzmaneIzBaze() throws Exception {
        try {
         //   return transactionManager.getDatabaseBroker().ucitajAranzmaneIzBaze();
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public Otpremnica kreirajOtpremnicu(Otpremnica otp) throws SQLException {
         try {
           // Otpremnica result = transactionManager.getDatabaseBroker().kreirajOtpremnicu(otp);
         //   transactionManager.commitTransaction();
          //  return result;
        } catch (Exception e) {
          //  transactionManager.rollbackTransaction();
            throw e;
        }
         return null;
    }

    public void dodajStavkuOtpremnice(StavkaOtpremnice so) throws SQLException {
        try {
          //  transactionManager.getDatabaseBroker().dodajStavkuOtpremnice(so);
         //   transactionManager.commitTransaction();
        } catch (Exception e) {
           // transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public void promeniLozinkuCvecara(Cvecar cvecarLozinkaPromena) throws SQLException {
        try {
        //transactionManager.getDatabaseBroker().updateNewPasswordToHash(cvecarLozinkaPromena);
       // transactionManager.commitTransaction();
        } catch (Exception e) {
          //  transactionManager.rollbackTransaction();
            throw e;
        }
        
    }

    public void ubaciStrSpremu(StrucnaSprema strucnaSprema) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void obrisiKupca(Kupac kupac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void pretraziOtpremnicu(Otpremnica otpremnica) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object ucitajSveCvecareIzBaze() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void obrisiStavkuOtpremnice(Otpremnica otpremnica) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void promeniKupca(Kupac kupac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
