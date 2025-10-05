/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.cvecar;

import dbb.DatabaseBroker;
import domain.Cvecar;
import domain.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOKreirajCvecar extends OpstaSistemskaOperacija{

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
   if(!(odo instanceof Cvecar))
            throw  new Exception("Prosleđeni objekat nije instanca klase Cvećar!");
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DatabaseBroker.getInstance().insert(odo);
    }
    
}
