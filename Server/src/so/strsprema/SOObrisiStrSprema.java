/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.strsprema;

import dbb.DatabaseBroker;
import domain.OpstiDomenskiObjekat;
import domain.StrucnaSprema;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOObrisiStrSprema extends OpstaSistemskaOperacija {
     @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
         if(!(odo instanceof StrucnaSprema))
            throw new Exception("Prosledjeni objekat nije instanca klase StrucnaSprema!");

    }
    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DatabaseBroker.getInstance().delete(odo);
    }
    
}
