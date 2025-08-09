/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import domain.Aranzman;
import domain.Cvecar;
import domain.Kupac;
import domain.Mesto;
import domain.Otpremnica;
import domain.StrucnaSprema;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Saki
 */
public class ThreadClient extends Thread {

    private Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (SocketException e) {
            System.out.println("Klijent se odvezao: " + e.getMessage());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Greska prilikom obrade klijentskog zahteva: " + e.getMessage());
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.PRIJAVI_CVECARA:
                    response.setData(ServerController.getInstance().prijaviCvecara((Cvecar) request.getData()));
                    break;
                case Operation.DODAJ_CVECARA:
                    ServerController.getInstance().dodajCvecara((Cvecar) request.getData());
                    break;
                case Operation.KREIRAJ_OTPREMNICU:
                    ServerController.getInstance().kreirajOtpremnicu((Otpremnica) request.getData());
                    break;
                case Operation.UBACI_STR_SPREMU:
                    ServerController.getInstance().ubaciStrSpremu((StrucnaSprema) request.getData());
                    break;
                case Operation.PROMENI_KUPCA:
                    ServerController.getInstance().promeniKupca((Kupac) request.getData());
                    break;
                case Operation.OBRISI_KUPCA:
                    ServerController.getInstance().obrisiKupca((Kupac) request.getData());
                    break;
                case Operation.PROMENI_CVECARA:
                    ServerController.getInstance().promeniCvecara((Cvecar) request.getData());
                    break;
                case Operation.OBRISI_CVECARA:
                    ServerController.getInstance().obrisiCvecara((Cvecar) request.getData());
                    break;
                case Operation.VRATI_LISTU_SVI_KUPCI:
                    response.setData(ServerController.getInstance().ucitajKupceIzBaze());
                    break;
                case Operation.VRATI_LISTU_SVI_ARANZMANI:
                    response.setData(ServerController.getInstance().ucitajAranzmaneIzBaze());
                    break;
                case Operation.VRATI_LISTU_SVI_CVECAR:
                    response.setData(ServerController.getInstance().ucitajCvecareIzBaze());
                    break;
                case Operation.KREIRAJ_KUPCA:
                    ServerController.getInstance().dodajKupca((Kupac) request.getData());
                    break;
                case Operation.KREIRAJ_ARANZMAN:
                    ServerController.getInstance().dodajAranzman((Aranzman) request.getData());
                    break;
                case Operation.OBRISI_ARANZMAN:
                    ServerController.getInstance().obrisiAranzman((Aranzman) request.getData());
                    break;
                case Operation.PROMENI_ARANZMAN:
                    ServerController.getInstance().promeniAranzman((Aranzman) request.getData());
                    break;
                case Operation.KREIRAJ_MESTO:
                    ServerController.getInstance().dodajMesto((Mesto) request.getData());
                    break;
                case Operation.PROMENI_MESTO:
                    ServerController.getInstance().promeniMesto((Mesto) request.getData());
                    break;
                case Operation.OBRISI_MESTO:
                    ServerController.getInstance().obrisiMesto((Mesto) request.getData());
                    break;
                case Operation.VRATI_LISTU_SVI_MESTO:
                    response.setData(ServerController.getInstance().ucitajMestaIzBaze());
                    break;
                case Operation.PROMENI_OTPREMNICU:
                    ServerController.getInstance().promeniOtpremnicu((Otpremnica) request.getData());
                    break;
                case Operation.OBRISI_OTPREMNICU:
                    ServerController.getInstance().obrisiOtpremnicu((Otpremnica) request.getData());
                    break;
                case Operation.VRATI_LISTU_SVI_OTPREMNICA:
                    response.setData(ServerController.getInstance().ucitajOtpremniceIzBaze());
                    break;
                case Operation.PRETRAZI_OTPREMNICU:
                    response.setData(ServerController.getInstance().pretraziOtpremnicu((Otpremnica) request.getData()));
                    break;
                case Operation.VRATI_LISTU_STAVKI_OTPREMNICE:
                    response.setData(ServerController.getInstance().ucitajStavkeOtpremniceIzBaze((Otpremnica) request.getData()));
                    break;
                case Operation.PROMENI_STRUCNASPREMA:
                    ServerController.getInstance().promeniStrSpremu((StrucnaSprema) request.getData());
                    break;
                case Operation.OBRISI_STRUCNASPREMA:
                    ServerController.getInstance().obrisiStrSprema((StrucnaSprema) request.getData());
                    break;
                case Operation.VRATI_LISTU_SVI_STRUCNASPREMA:
                    response.setData(ServerController.getInstance().ucitajStrucneSpremeIzBaze());
                    break;
                case Operation.VRATI_LISTU_PORESKA_STOPA:
                    response.setData(ServerController.getInstance().ucitajPoreskaStopeIzBaze());
                    break;
                case Operation.DODAJ_STRUCNASPREMA:
                    ServerController.getInstance().dodajStrSprema((StrucnaSprema) request.getData());
                    break;
                case Operation.PRETRAZI_KUPCA:
                    response.setData(ServerController.getInstance().pretraziKupca((Kupac) request.getData()));
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setException(e);
            response.setResponseStatus(ResponseStatus.Error);
        }
        return response;
    }
}
