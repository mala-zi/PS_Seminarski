/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Aranzman;
import java.io.IOException;
import domain.Cvecar;
import domain.Kupac;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
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

    public void dodajCvecara(Cvecar c) throws Exception {
        sendRequest(Operation.DODAJ_CVECARA, c);
    }

    public void promeniCvecara(Cvecar cvecar) throws Exception {
        sendRequest(Operation.PROMENI_CVECARA, cvecar);
    }

    public List<Cvecar> ucitajCvecareIzBaze() throws Exception {
        return (ArrayList<Cvecar>) sendRequest(Operation.VRATI_LISTU_SVI_CVECAR, null);
    }

    public void obrisiCvecara(Cvecar cvecarDelete) throws Exception {
        sendRequest(Operation.OBRISI_CVECARA, cvecarDelete);
    }

    public void dodajOtpremnicu(Otpremnica otpremnica) throws Exception {
        sendRequest(Operation.KREIRAJ_OTPREMNICU, otpremnica);
    }

    public void dodajStavkuOtpremnice(StavkaOtpremnice so) throws Exception {
        sendRequest(Operation.DODAJ_STAVKU_OTPREMNICE, so);
    }

    public List<Kupac> popuniKupceIzBaze() throws Exception {
        return (ArrayList<Kupac>) sendRequest(Operation.VRATI_LISTU_SVI_KUPCI, null);

    }

    public List<Aranzman> popuniAranzmaneIzBaze() throws Exception {
        return (ArrayList<Aranzman>) sendRequest(Operation.VRATI_LISTU_SVI_ARANZMANI, null);
    }

    public void promeniLozinkuCvecara(Cvecar cvecar) throws Exception {
        sendRequest(Operation.PROMENI_LOZINKU_CVECARA, cvecar);
    }
}
