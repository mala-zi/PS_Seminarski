/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Aranzman;
import domain.Cvecar;
import domain.Kupac;
import domain.Mesto;
import domain.Otpremnica;
import domain.StrucnaSprema;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;
import so.aranzman.SOKreirajAranzman;
import so.aranzman.SOObrisiAranzman;
import so.aranzman.SOPromeniAranzman;
import so.aranzman.SOVratiListuSviAranzman;
import so.cvecar.SOKreirajCvecar;
import so.cvecar.SOObrisiCvecar;
import so.cvecar.SOPrijaviCvecara;
import so.cvecar.SOPromeniCvecar;
import so.cvecar.SOVratiListuSviCvecar;
import so.kupac.SOObrisiKupac;
import so.kupac.SOPromeniKupca;
import so.kupac.SOVratiListuSviKupac;
import so.kupac.SOKreirajKupca;
import so.mesto.SOKreirajMesto;
import so.mesto.SOObrisiMesto;
import so.mesto.SOPromeniMesto;
import so.mesto.SOVratiListuSviMesto;
import so.otpremnica.SOKreirajOtpremnicu;
import so.otpremnica.SOPromeniOtpremnicu;
import so.otpremnica.SOVratiListuSviOtpremnica;
import so.strsprema.SOPromeniStrSprema;
import so.strsprema.SOUbaciStrSprema;

/**
 *
 * @author Saki
 */
public class ServerController {

    private static ServerController instance;
    // private TransactionManager transactionManager;

    public static ServerController getInstance() throws Exception {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    private ServerController() throws SQLException {

    }

    public Cvecar prijaviCvecara(Cvecar cvecar) throws SQLException, Exception {
        SOPrijaviCvecara soPrijavi = new SOPrijaviCvecara();
        soPrijavi.templateExecute(cvecar);
        return soPrijavi.getPrijavljenCvecar();

    }

    public void dodajCvecara(Cvecar cvecarAdd) throws Exception {
        (new SOKreirajCvecar()).templateExecute(cvecarAdd);

    }

    public void promeniCvecara(Cvecar cvecarChange) throws Exception {
        (new SOPromeniCvecar()).templateExecute(cvecarChange);
    }

    public ArrayList<Cvecar> ucitajCvecareIzBaze() throws Exception {
        SOVratiListuSviCvecar so = new SOVratiListuSviCvecar();
        so.templateExecute(new Cvecar());
        return so.getList();
    }

    public void obrisiCvecara(Cvecar cvecarDelete) throws Exception {
        (new SOObrisiCvecar()).templateExecute(cvecarDelete);
    }

    public ArrayList<Kupac> ucitajKupceIzBaze() throws Exception {
        SOVratiListuSviKupac so = new SOVratiListuSviKupac();
        so.templateExecute(new Kupac());
        return so.getList();
    }

    public void promeniKupca(Kupac kupacChange) throws Exception {
        (new SOPromeniKupca()).templateExecute(kupacChange);
    }

    public void obrisiKupca(Kupac kupacDelete) throws Exception {
        (new SOObrisiKupac()).templateExecute(kupacDelete);
    }

    public void dodajKupca(Kupac kupacAdd) throws Exception {
        (new SOKreirajKupca()).templateExecute(kupacAdd);
    }

    public ArrayList<Aranzman> ucitajAranzmaneIzBaze() throws Exception {
        SOVratiListuSviAranzman so = new SOVratiListuSviAranzman();
        so.templateExecute(new Aranzman());
        return so.getList();
    }

    public void promeniAranzman(Aranzman aranzmanChange) throws Exception {
        (new SOPromeniAranzman()).templateExecute(aranzmanChange);
    }

    public void obrisiAranzman(Aranzman aranzmanDelete) throws Exception {
        (new SOObrisiAranzman()).templateExecute(aranzmanDelete);
    }

    public void dodajAranzman(Aranzman aranzmanAdd) throws Exception {
        (new SOKreirajAranzman()).templateExecute(aranzmanAdd);
    }

    public ArrayList<Mesto> ucitajMestaIzBaze() throws Exception {
        SOVratiListuSviMesto so = new SOVratiListuSviMesto();
        so.templateExecute(new Mesto());
        return so.getList();
    }

    public void promeniMesto(Mesto mestoChange) throws Exception {
        (new SOPromeniMesto()).templateExecute(mestoChange);
    }

    public void obrisiMesto(Mesto mestoDelete) throws Exception {
        (new SOObrisiMesto()).templateExecute(mestoDelete);
    }

    public void dodajMesto(Mesto mestoAdd) throws Exception {
        (new SOKreirajMesto()).templateExecute(mestoAdd);
    }

    public void kreirajOtpremnicu(Otpremnica otpAdd) throws Exception {
       (new SOKreirajOtpremnicu()).templateExecute(otpAdd);
    }

    public ArrayList<Otpremnica> ucitajOtpremniceIzBaze() throws Exception {
        SOVratiListuSviOtpremnica so = new SOVratiListuSviOtpremnica();
        so.templateExecute(new Otpremnica());
        return so.getList();
    }
    public void promeniOtpremnicu(Otpremnica otpremnicaChange) throws Exception {
       (new SOPromeniOtpremnicu()).templateExecute(otpremnicaChange);
    }

    public void ubaciStrSpremu(StrucnaSprema strucnaSpremaAdd) throws Exception {
        (new SOUbaciStrSprema()).templateExecute(strucnaSpremaAdd);
    }

    public void promeniStrSpremu(StrucnaSprema strucnaSpremaChange) throws Exception {
        (new SOPromeniStrSprema()).templateExecute(strucnaSpremaChange);
    }

    

}
