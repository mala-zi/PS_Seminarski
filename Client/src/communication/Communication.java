/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Cvecar;
import java.net.Socket;
import java.util.List;

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
    
    public Cvecar prijaviCvecara(String username, String password) throws Exception {
        Cvecar  cvecar=new Cvecar ();
        cvecar.setKorisnickoIme(username);
        cvecar.setLozinka(password);
        Request request=new Request(Operation.prijaviCvecara, cvecar);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()==null){
            return (Cvecar )response.getResult();
        }else{
            throw response.getException();
        }
    }

    public void dodajCvecara(Cvecar cvecar) throws Exception {
        Request request=new Request(Operation.dodajCvecara, cvecar);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()!=null){
            throw response.getException();
        }
            
        
    }

    public void promeniCvecara(Cvecar cvecar) throws Exception {
        Request request=new Request(Operation.promeniCvecara, cvecar);
        sender.send(request);
        Response response=(Response)receiver.receive();
        if(response.getException()!=null){
            throw response.getException();
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
