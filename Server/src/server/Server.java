/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.RequestProcess;

/**
 *
 * @author Dules
 */
public class Server {

    public Server() throws SQLException {
    }
    
    
    public void startServer(){
        try {
            //kreiraj server socket
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Server je pokrenut. cekam klijenta!");
            Socket socket =  serverSocket.accept();
            System.out.println("Server: Klijent se povezao sa serverom");
            handle(socket);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void handle(Socket socket) {
      RequestProcess rp=new RequestProcess(socket);
      rp.start();
    }
}
