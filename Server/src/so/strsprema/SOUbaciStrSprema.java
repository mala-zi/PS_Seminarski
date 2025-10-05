/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.strsprema;

import dbb.DatabaseBroker;
import domain.StrucnaSprema;
import domain.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOUbaciStrSprema extends OpstaSistemskaOperacija{

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
   if(!(odo instanceof StrucnaSprema))
            throw  new Exception("Prosleđeni objekat nije instanca klase Stručna sprema!");
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DatabaseBroker.getInstance().insert(odo);
    }
    
}
