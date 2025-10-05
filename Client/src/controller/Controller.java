/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Aranzman;
import java.io.IOException;
import domain.Cvecar;
import domain.Kupac;
import domain.Mesto;
import domain.Otpremnica;
import domain.PoreskaStopa;
import domain.StrucnaSprema;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Saki
 */
public class Controller {

    private static Controller instance; //jedna, jedina instanca controllera u mojoj aplikaciji

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() throws IOException {

    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }

    public Cvecar prijaviCvecara(Cvecar cvecar) throws Exception {
        return (Cvecar) sendRequest(Operation.PRIJAVI_CVECARA, cvecar);

    }

    public void kreirajCvecar(Cvecar c) throws Exception {
        sendRequest(Operation.KREIRAJ_CVECARA, c);
    }

    public void promeniCvecara(Cvecar cvecar) throws Exception {
        sendRequest(Operation.PROMENI_CVECARA, cvecar);
    }

    public ArrayList<Cvecar> ucitajCvecareIzBaze() throws Exception {
        return (ArrayList<Cvecar>) sendRequest(Operation.VRATI_LISTU_SVI_CVECAR, null);
    }

    public void obrisiCvecara(Cvecar cvecarDelete) throws Exception {
        sendRequest(Operation.OBRISI_CVECARA, cvecarDelete);
    }

    public void obrisiStrSprema(StrucnaSprema strSpremaDelete) throws Exception {
        sendRequest(Operation.OBRISI_STRUCNASPREMA, strSpremaDelete);
    }

    public void kreirajOtpremnicu(Otpremnica otpremnica) throws Exception {
        sendRequest(Operation.KREIRAJ_OTPREMNICU, otpremnica);
    }

    public ArrayList<Kupac> ucitajKupceIzBaze() throws Exception {
        return (ArrayList<Kupac>) sendRequest(Operation.VRATI_LISTU_SVI_KUPCI, null);

    }

    public ArrayList<Aranzman> ucitajAranzmaneIzBaze() throws Exception {
        return (ArrayList<Aranzman>) sendRequest(Operation.VRATI_LISTU_SVI_ARANZMANI, null);
    }

    public void odjaviCvecara(String korisnickoIme) throws Exception {
        sendRequest(Operation.ODJAVA_CVECARA, korisnickoIme);
    }

    public void kreirajStrSprema(StrucnaSprema strs) throws Exception {
        sendRequest(Operation.UBACI_STR_SPREMA, strs);
    }

    public void promeniStrSpremu(StrucnaSprema ss) throws Exception {
        sendRequest(Operation.PROMENI_STRUCNASPREMA, ss);
    }

    public ArrayList<StrucnaSprema> ucitajStrucneSpremeIzBaze() throws Exception {
        return (ArrayList<StrucnaSprema>) sendRequest(Operation.VRATI_LISTU_SVI_STRUCNASPREMA, null);
    }

    public void kreirajKupca(Kupac k) throws Exception {
        sendRequest(Operation.KREIRAJ_KUPCA, k);
    }

    public void promeniKupca(Kupac k) throws Exception {
        sendRequest(Operation.PROMENI_KUPCA, k);
    }

    public ArrayList<Mesto> ucitajMestaIzBaze() throws Exception {
        return (ArrayList<Mesto>) sendRequest(Operation.VRATI_LISTU_SVI_MESTO, null);
    }

    public void kreirajMesto(Mesto m) throws Exception {
        sendRequest(Operation.KREIRAJ_MESTO, m);
    }

    public void obrisiMesto(Mesto mestoDelete) throws Exception {
        sendRequest(Operation.OBRISI_MESTO, mestoDelete);

    }

    public void promeniMesto(Mesto mestoChange) throws Exception {
        sendRequest(Operation.PROMENI_MESTO, mestoChange);
    }

    public void obrisiKupca(Kupac kupacDelete) throws Exception {
        sendRequest(Operation.OBRISI_KUPCA, kupacDelete);
    }

    public void kreirajAranzman(Aranzman aranzmanAdd) throws Exception {
        sendRequest(Operation.KREIRAJ_ARANZMAN, aranzmanAdd);
    }

    public void promeniAranzman(Aranzman aranzmanChange) throws Exception {
        sendRequest(Operation.PROMENI_ARANZMAN, aranzmanChange);

    }

    public void obrisiAranzman(Aranzman aranzmanDelete) throws Exception {
        sendRequest(Operation.OBRISI_ARANZMAN, aranzmanDelete);
    }

    public ArrayList<Otpremnica> ucitajOtpremniceIzBaze() throws Exception {
        return (ArrayList<Otpremnica>) sendRequest(Operation.VRATI_LISTU_SVI_OTPREMNICA, null);
    }

    public void obrisiOtpremnicu(Otpremnica otpremnicaDelete) throws Exception {
        sendRequest(Operation.OBRISI_OTPREMNICU, otpremnicaDelete);

    }

    public ArrayList<Otpremnica> pretraziOtpremnice(Otpremnica kriterijum) throws Exception {
        return (ArrayList<Otpremnica>) sendRequest(Operation.PRETRAZI_OTPREMNICU, kriterijum);
    }

    public void promeniOtpremnicu(Otpremnica otpremnicaChange) throws Exception {
        sendRequest(Operation.PROMENI_OTPREMNICU, otpremnicaChange);

    }

    public ArrayList<PoreskaStopa> ucitajPoreskeStopeIzBaze() throws Exception {
        return (ArrayList<PoreskaStopa>) sendRequest(Operation.VRATI_LISTU_PORESKA_STOPA, null);
    }

    public ArrayList<Kupac> pretraziKupce(Kupac filter) throws Exception {
        return (ArrayList<Kupac>) sendRequest(Operation.PRETRAZI_KUPCA, filter);
    }

    public void posaljiOtpremnicuNaMejl(Otpremnica otpremnica) throws Exception {
        sendRequest(Operation.POSALJI_OTPREMNICU_NA_MEJL, otpremnica);
    }

}
