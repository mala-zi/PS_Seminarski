/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.aranzman;

import dbb.DatabaseBroker;
import domain.Aranzman;
import domain.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOKreirajAranzman extends OpstaSistemskaOperacija {

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null) {
            throw new Exception("Aranžman ne sme biti null!");
        }
        if (!(odo instanceof Aranzman)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Aranžman!");
        }

    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DatabaseBroker.getInstance().insert(odo);
    }

}
