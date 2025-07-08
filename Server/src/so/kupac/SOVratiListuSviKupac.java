/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kupac;

import dbb.DatabaseBroker;
import domain.Kupac;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOVratiListuSviKupac extends OpstaSistemskaOperacija{
private ArrayList<Kupac> list;
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
       if(!(odo instanceof Kupac)) 
            throw new Exception("Prosledjeni objekat nije instanca klase Kupac!");
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        list= (ArrayList<Kupac>) (ArrayList<?>)DatabaseBroker.getInstance().select(odo);
    }
     public ArrayList<Kupac> getList() {
        return list;
    }
}
