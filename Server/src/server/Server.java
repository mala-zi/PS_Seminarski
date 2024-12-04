/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Cvecar;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dbb.DatabaseBroker;

/**
 *
 * @author Dules
 */
public class Server {
    private DatabaseBroker broker;
    private Sender sender ;
    private Receiver receiver;

    public Server() throws SQLException {
      broker = new DatabaseBroker();
      broker.connect();
    }
    
    
    public void startServer(){
        try {
            //kreiraj server socket
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Server je pokrenut. cekam klijenta!");
            Socket socket =  serverSocket.accept();
            System.out.println("Server: Klijent se povezao sa serverom...");
            
            sender = new Sender(socket);
            receiver = new Receiver(socket);
            
            while(true){
                try {
                    //citaj zahtev
                    Request request =  (Request) receiver.receive();
                    Response response = new Response();
                    
                    Operation operation = request.getOperation();
                    if(Operation.LOGIN == operation){
                        Cvecar cvecar = (Cvecar) request.getArgument();
                        try{
                            cvecar = broker.getUser(cvecar);
                            response.setResult(cvecar);
                        }catch(SQLException sqle){
                            response.setException(sqle);
                        }
                    }
                    
                    //posalji odgovor nazad
                    sender.send(response);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
