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
                            
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }

                sender.send(response);
            } catch (Exception ex) {
                Logger.getLogger(RequestProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
