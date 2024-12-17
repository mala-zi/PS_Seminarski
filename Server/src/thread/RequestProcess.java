/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Cvecar;
import controller.Controller;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saki
 */
public class RequestProcess extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;

    public RequestProcess(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case prijaviCvecara:
                            Cvecar cvecarLogin=(Cvecar) request.getArgument();
                            System.out.println(cvecarLogin);
                            response.setResult(Controller.getInstance().prijaviCvecara(cvecarLogin));
                            break;
                        case dodajCvecara:
                            Cvecar cvecarAdd=(Cvecar) request.getArgument();
                            System.out.println(cvecarAdd);
                            Controller.getInstance().dodajCvecara(cvecarAdd);
                            break;
                        case promeniCvecara:
                            Cvecar cvecarChange=(Cvecar) request.getArgument();
                            System.out.println(cvecarChange);
                            Controller.getInstance().promeniCvecara(cvecarChange);
                            break;
                        case vratiListuSviCvecar:
                            response.setResult(Controller.getInstance().ucitajCvecareIzBaze());
                            break;
                        case obrisiCvecara:
                            Cvecar cvecarDelete=(Cvecar) request.getArgument();
                            System.out.println(cvecarDelete);
                            Controller.getInstance().obrisiCvecara(cvecarDelete);
                            break;
                        case vratiListuSviKupci:
                            response.setResult(Controller.getInstance().ucitajKupceIzBaze());
                            break;
                        case vratiListuSviAranzmani:
                            response.setResult(Controller.getInstance().ucitajAranzmaneIzBaze());
                            break;
                        case kreirajOtpremnicu:
                            Otpremnica otp=(Otpremnica) request.getArgument();
                            System.out.println(otp);
                            response.setResult(Controller.getInstance().kreirajOtpremnicu(otp));
                            break;
                        case dodajStavkuOtpremnice:
                            StavkaOtpremnice so=(StavkaOtpremnice) request.getArgument();
                            System.out.println(so);
                            Controller.getInstance().dodajStavkuOtpremnice(so);
                            break;
                        case promeniLozinkuCvecara:
                            Cvecar cvecarLozinkaPromena= (Cvecar) request.getArgument();
                            System.out.println(cvecarLozinkaPromena);
                            Controller.getInstance().promeniLozinkuCvecara(cvecarLozinkaPromena);
                            break;

                            
                            
                    }
                } catch (Exception e) {
                    e.printStackTrace();//try unutra
                    response.setException(e);
                }

                sender.send(response);//izmedju dve try
            } catch (IOException e) {
                System.out.println("Klijent se iskljucio.");
                break; //prvi try
            } catch (Exception ex) {
                Logger.getLogger(RequestProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
}
