/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Cartman
 */
public class Receiver {
    private Socket socket;
    private ObjectInputStream in;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive() throws Exception{
        try {
             in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object!\n"+ex.getMessage());
        }
    }
    public void close() {
        try {
            if (in != null) in.close();
            if (socket != null) socket.close();
        } catch (IOException ex) {
            System.err.println("Error closing receiver resources: " + ex.getMessage());
        }
    }
}
