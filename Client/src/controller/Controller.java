/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import java.io.IOException;
import java.net.Socket;
import domain.Cvecar;

/**
 *
 * @author Saki
 */
public class Controller {
    private static Controller instance; //jedna, jedina instanca controllera u mojoj aplikaciji
    private final Socket socket;
    private final Sender sender;
    private final Receiver receiver;
    
    public static Controller getInstance() throws IOException {
        if (instance == null) instance = new Controller();
        return instance;
    }
    private Controller() throws IOException {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
     public Object sendObjectReceiveResponse(Object arg, Operation operation) throws Exception {
        //posalji zahtev serveru da proveri da li korisnik postoji u sistemu
        Request request = new Request(operation, arg);
        sender.send(request);
        
        //prihvati zahtev
        Response response =  (Response) receiver.receive();
        if (response.getException() == null){
            return (Cvecar) response.getResult();
        }else{
            throw response.getException();
        }
        
    }
      
    public Cvecar login(Cvecar cvecar) throws Exception {
        return (Cvecar) sendObjectReceiveResponse(cvecar, Operation.LOGIN);
        
    }
}