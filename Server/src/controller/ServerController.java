/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validator.PasswordHash;
import domain.Aranzman;
import domain.Cvecar;
import domain.Kupac;
import domain.Mesto;
import domain.Otpremnica;
import domain.PoreskaStopa;
import domain.StavkaOtpremnice;
import domain.StrucnaSprema;
import java.sql.SQLException;
import java.util.ArrayList;
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
import so.otpremnica.SOObrisiOtpremnicu;
import so.otpremnica.SOPretraziOtpremnicu;
import so.otpremnica.SOPromeniOtpremnicu;
import so.otpremnica.SOVratiListuSviOtpremnica;
import so.poreskastopa.SOVratiListuSviPoreskaStopa;
import so.stavkaotpremnice.SOVratiListuSviStavkiOtpremnice;
import so.strsprema.SOObrisiStrSprema;
import so.strsprema.SOPromeniStrSprema;
import so.strsprema.SOUbaciStrSprema;
import so.strsprema.SOVratiListuSviStrSprema;

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
        String hash = PasswordHash.hashPassword(cvecar.getLozinka());
        cvecar.setLozinka(hash);
        soPrijavi.templateExecute(cvecar);
        return soPrijavi.getPrijavljenCvecar();

    }

    public void dodajCvecara(Cvecar cvecarAdd) throws Exception {
        String hash = PasswordHash.hashPassword(cvecarAdd.getLozinka());
        cvecarAdd.setLozinka(hash);
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

    public ArrayList<StrucnaSprema> ucitajStrucneSpremeIzBaze() throws Exception {
        SOVratiListuSviStrSprema so = new SOVratiListuSviStrSprema();
        so.templateExecute(new StrucnaSprema());
        return so.getList();
    }

    public void obrisiStrSprema(StrucnaSprema strSpremaDelete) throws Exception {
        (new SOObrisiStrSprema()).templateExecute(strSpremaDelete);
    }

    public void obrisiOtpremnicu(Otpremnica otpremnicaDelete) throws Exception {
        (new SOObrisiOtpremnicu()).templateExecute(otpremnicaDelete);
    }

    public Object ucitajStavkeOtpremniceIzBaze(Otpremnica otpremnica) throws Exception {//mozda promenim na Arraylist posle
        SOVratiListuSviStavkiOtpremnice so = new SOVratiListuSviStavkiOtpremnice();
        StavkaOtpremnice s = new StavkaOtpremnice();
        s.setOtpremnica(otpremnica);
        so.templateExecute(s);
        return so.getLista();

    }

    public ArrayList<Otpremnica> pretraziOtpremnicu(Otpremnica kriterijum) throws Exception {
        SOPretraziOtpremnicu so = new SOPretraziOtpremnicu();
        so.templateExecute(kriterijum);
        return so.getLista();
    }

    public Object ucitajPoreskaStopeIzBaze() throws Exception {
        SOVratiListuSviPoreskaStopa so = new SOVratiListuSviPoreskaStopa();
        so.templateExecute(new PoreskaStopa());
        return so.getList();
    }

    public void dodajStrSprema(StrucnaSprema strucnaSprema) throws Exception {
        (new SOUbaciStrSprema()).templateExecute(strucnaSprema);
    }

}
