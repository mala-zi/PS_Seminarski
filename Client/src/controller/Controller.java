/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Communication;
import domain.Aranzman;
import java.io.IOException;
import domain.Cvecar;
import domain.Kupac;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.util.List;

/**
 *
 * @author Saki
 */
public class Controller {
    private static Controller instance; //jedna, jedina instanca controllera u mojoj aplikaciji
    
    
    public static Controller getInstance() throws Exception {
        if (instance == null) instance = new Controller();
        return instance;
    }
    private Controller() throws IOException {
        
    }
    
    public Cvecar prijaviCvecara(Cvecar cvecar) throws Exception {
        return (Cvecar)Communication.getInstance().prijaviCvecara(cvecar);
        
    }

    public void dodajCvecara(Cvecar c) throws Exception {
        Communication.getInstance().dodajCvecara(c);
    }

    public void promeniCvecara(Cvecar cvecar) throws Exception {
        Communication.getInstance().promeniCvecara(cvecar);
    }

    public List<Cvecar> ucitajCvecareIzBaze() throws Exception {
      return Communication.getInstance().ucitajCvecareIzBaze();
    }

    public void obrisiCvecara(Cvecar cvecarDelete) throws Exception {
        Communication.getInstance().obrisiCvecara(cvecarDelete);
    }

    public Otpremnica dodajOtpremnicu(Otpremnica otpremnica) throws Exception {
        return Communication.getInstance().kreirajOtpremnicu(otpremnica);
    }

    public void dodajStavkuOtpremnice(StavkaOtpremnice so) throws Exception {
        Communication.getInstance().dodajStavkuOtpremnice(so);
    }

    public List<Kupac> popuniKupceIzBaze() throws Exception {
        return Communication.getInstance().vratiListuSviKupci();
                
    }

    public List<Aranzman> popuniAranzmaneIzBaze() throws Exception {
        return Communication.getInstance().vratiListuSviAranzmani();
    }

   /* public boolean proveriLozinkuCvecara(Cvecar cvecar) throws Exception {
        return Communication.getInstance().proveriLozinkuCvecara(cvecar);
    }*/

    public void promeniLozinkuCvecara(Cvecar cvecar) throws Exception {
        Communication.getInstance().promeniLozinkuCvecara(cvecar);
    }
}
