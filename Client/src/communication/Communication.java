/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Cvecar;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import validator.Validator;
import static validator.Validator.isValidPassword;
import view.KreirajCvecaraForma;

/**
 *
 * @author Saki
 */
public class Communication {
    private static Communication instance; 
    private final Socket socket;
    private final Sender sender;
    private final Receiver receiver;
    
    private Communication() throws Exception{
        socket=new Socket("127.0.0.1", 9000);
        sender=new Sender(socket);
        receiver=new Receiver(socket);
    }
    public static Communication getInstance() throws Exception{
        if(instance==null){
            instance=new Communication();
        }
        return instance;
    }
    
       public void closeConnection(){
           try{
               if(socket!=null && !socket.isClosed()){
                   socket.close();
               }
           }catch(IOException e){
               e.printStackTrace();
           }
       }
    
    public Cvecar prijaviCvecara(String username, String password) throws Exception {
        Response response = new Response();
        try {
            Cvecar cvecar = new Cvecar();
            cvecar.setKorisnickoIme(username);
            cvecar.setLozinka(password);
            Validator.validateCvecarSign(cvecar);
            Request request = new Request(Operation.prijaviCvecara, cvecar);
            sender.send(request);
            response = (Response) receiver.receive();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Greška u validaciji: " + e.getMessage());
        }
        if (response.getException() == null) {
            return (Cvecar) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void dodajCvecara(Cvecar cvecar) throws Exception {
        try {
            Validator.validateCvecarAdd(cvecar);

            Request request = new Request(Operation.dodajCvecara, cvecar);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Greška u validaciji: " + e.getMessage());
        }

    }

    public void promeniCvecara(Cvecar cvecar,JTextField txt) throws Exception {
        
        try {
            Validator.validateCvecarChange(cvecar);
            if (!txt.getText().isEmpty() && !isValidPassword(cvecar.getLozinka())) {
                JOptionPane.showMessageDialog(null, "Lozinka mora imati minimum 8 karaktera: ", "Greska", JOptionPane.ERROR_MESSAGE);
                

            } else {
                Request request = new Request(Operation.promeniCvecara, cvecar);
                sender.send(request);
                Response response = (Response) receiver.receive();
                if (response.getException() != null) {
                    throw response.getException();
                }
                JOptionPane.showMessageDialog(null, "Cvecar uspesno izmenjen","Obavestenje",JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Greška u validaciji: " + e.getMessage());
        }

    }

    public List<Cvecar> ucitajCvecareIzBaze() throws Exception {

        Request request=new Request(Operation.vratiListuSviCvecar,  null);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (List<Cvecar> )response.getResult();
        }else{
            throw response.getException();
        }
    }
    public void obrisiCvecara(Cvecar cvecarDelete) throws Exception {
        Request request=new Request(Operation.obrisiCvecara, cvecarDelete);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()!=null){
            throw response.getException();
        }
    }
}
