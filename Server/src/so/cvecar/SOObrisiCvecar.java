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
public class SOObrisiCvecar extends OpstaSistemskaOperacija{

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Cvecar))
            throw new Exception("Prosledjeni objekat nije instanca klase Cvecar!");

    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
          DatabaseBroker.getInstance().delete(odo);
    }
    
}
