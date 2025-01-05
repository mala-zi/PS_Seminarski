/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Cartman
 */
public class Sender {
    private Socket socket;
    private ObjectOutputStream out;

    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    public void send(Object object) throws Exception{
        try {
            out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object!\n"+ex.getMessage());
        }
    }
    public void close() {
        try {
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException ex) {
            System.err.println("Error closing sender resources: " + ex.getMessage());
        }
    }
}
