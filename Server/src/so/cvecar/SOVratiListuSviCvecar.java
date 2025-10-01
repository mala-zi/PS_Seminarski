/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.cvecar;

import dbb.DatabaseBroker;
import domain.Cvecar;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOVratiListuSviCvecar extends OpstaSistemskaOperacija{
private ArrayList<Cvecar> list;
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
       if(!(odo instanceof Cvecar)) 
            throw new Exception("Prosleđeni objekat nije instanca klase Cvecar!");
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        list= (ArrayList<Cvecar>) (ArrayList<?>)DatabaseBroker.getInstance().select(odo);
    }
     public ArrayList<Cvecar> getList() {
        return list;
    }
}
