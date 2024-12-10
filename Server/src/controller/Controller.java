/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbb.DatabaseBroker;
import domain.Cvecar;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saki
 */
public class Controller {
    private static Controller instance;
   private DatabaseBroker dbb;
    
    public static Controller getInstance() throws Exception {
        if (instance == null) instance = new Controller();
        return instance;
    }
    private Controller() throws Exception {
        dbb=new DatabaseBroker();
    }

    public Cvecar prijaviCvecara(Cvecar cvecar) throws SQLException {
        return dbb.prijaviCvecara(cvecar);
    }

    public void dodajCvecara(Cvecar cvecarAdd) throws SQLException {
        dbb.dodajCvecara(cvecarAdd);
    }

    public void promeniCvecara(Cvecar cvecarChange) throws SQLException {
        dbb.promeniCvecara(cvecarChange);
    }

    public List<Cvecar> ucitajCvecareIzBaze() throws SQLException {
        return dbb.ucitajCvecareIzBaze();
    }

    public void obrisiCvecara(Cvecar cvecarDelete) {
        dbb.obrisiCvecara(cvecarDelete);
    }

    
    
}
