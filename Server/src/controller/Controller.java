/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbb.PasswordHash;
import dbb.TransactionManager;
import domain.Cvecar;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import validator.Validator;

/**
 *
 * @author Saki
 */
public class Controller {
    private static Controller instance;
    private TransactionManager transactionManager;

    public static Controller getInstance() throws Exception {
        if (instance == null) instance = new Controller();
        return instance;
    }

    private Controller() throws SQLException {
        transactionManager = TransactionManager.getInstance();
    }

    public Cvecar prijaviCvecara(Cvecar cvecar) throws SQLException {
        try {
            Validator.validateCvecarSign(cvecar);
           // String hashedPassword = PasswordHash.hashPassword(cvecar.getLozinka());
           // cvecar.setLozinka(hashedPassword);
            Cvecar result = transactionManager.getDatabaseBroker().prijaviCvecara(cvecar);
            transactionManager.commitTransaction();
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Greška u validaciji: " + e.getMessage());
            throw new SQLException("Validacija nije prošla: " + e.getMessage());

        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public void dodajCvecara(Cvecar cvecarAdd) throws SQLException {
        try {
            Validator.validateCvecarAdd(cvecarAdd);
            String hashedPassword = PasswordHash.hashPassword(cvecarAdd.getLozinka());
            cvecarAdd.setLozinka(hashedPassword);
            transactionManager.getDatabaseBroker().dodajCvecara(cvecarAdd);
            transactionManager.commitTransaction();
        } catch (IllegalArgumentException e) {
            System.out.println("Greška u validaciji: " + e.getMessage());
            throw new SQLException("Validacija nije prošla: " + e.getMessage());

        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public void promeniCvecara(Cvecar cvecarChange) throws SQLException {
        try {
            Validator.validateCvecarChange(cvecarChange);
            transactionManager.getDatabaseBroker().updateNewPasswordToHash(cvecarChange);
            transactionManager.getDatabaseBroker().promeniCvecara(cvecarChange);
            transactionManager.commitTransaction();
    } catch (IllegalArgumentException e) {
            System.out.println("Greška u validaciji: " + e.getMessage());
            throw new SQLException("Validacija nije prošla: " + e.getMessage());

        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public List<Cvecar> ucitajCvecareIzBaze() throws SQLException {
        try {
            return transactionManager.getDatabaseBroker().ucitajCvecareIzBaze();
        } catch (Exception e) {
            throw e;
        }
    }

    public void obrisiCvecara(Cvecar cvecarDelete) throws SQLException {
        try {
            transactionManager.getDatabaseBroker().obrisiCvecara(cvecarDelete);
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            throw e;
        }
    }
}

