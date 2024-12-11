/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import java.io.IOException;
import domain.Cvecar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Saki
 */
public class Controller {
    private static Controller instance; //jedna, jedina instanca controllera u mojoj aplikaciji
    
    
    public static Controller getInstance() throws IOException {
        if (instance == null) instance = new Controller();
        return instance;
    }
    private Controller() throws IOException {
        
    }
    
    public Cvecar prijaviCvecara(Cvecar cvecar) throws Exception {
        return (Cvecar)Communication.getInstance().prijaviCvecara(cvecar.getKorisnickoIme(), cvecar.getLozinka());
        
    }

    public void dodajCvecara(Cvecar c) throws Exception {
        Communication.getInstance().dodajCvecara(c);
    }

    public void promeniCvecara(Cvecar cvecar, JTextField txt) throws Exception {
        Communication.getInstance().promeniCvecara(cvecar,txt);
    }

    public List<Cvecar> ucitajCvecareIzBaze() throws Exception {
      return Communication.getInstance().ucitajCvecareIzBaze();
    }

    public void obrisiCvecara(Cvecar cvecarDelete) throws Exception {
        Communication.getInstance().obrisiCvecara(cvecarDelete);
    }
}