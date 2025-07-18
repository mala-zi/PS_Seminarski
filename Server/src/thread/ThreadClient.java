/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import domain.Cvecar;
import domain.Kupac;
import domain.Otpremnica;
import domain.StrucnaSprema;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
        } catch (Exception ex) {
            ex.printStackTrace();
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
                case Operation.VRATI_LISTU_CVECAR:
                    response.setData(ServerController.getInstance().ucitajCvecareIzBaze());
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
