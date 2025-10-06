/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import domain.Cvecar;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Saki
 */
public class Session {

    private static Session instance;
    private Socket socket;
    private Cvecar ulogovani;

    private Session() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            throw new RuntimeException("Server nije dostupan. Pokrenite server i pokušajte ponovo.");
        }
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(Cvecar ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Cvecar getUlogovani() {
        return ulogovani;
    }

   
}
