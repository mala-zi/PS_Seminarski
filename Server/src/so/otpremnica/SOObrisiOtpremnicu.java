/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.otpremnica;

import dbb.DatabaseBroker;
import domain.OpstiDomenskiObjekat;
import domain.Otpremnica;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOObrisiOtpremnicu extends OpstaSistemskaOperacija{
     @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Otpremnica))
            throw new Exception("Prosleđeni objekat nije instanca klase Otpremnica!");

    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
          DatabaseBroker.getInstance().delete(odo);
    }
    
}
