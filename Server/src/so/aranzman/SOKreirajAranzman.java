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
            throw new Exception("Aranzman ne sme biti null!");
        }
        if (!(odo instanceof Aranzman)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Aranzman!");
        }

        Aranzman a = (Aranzman) odo;

        if (a.getNaziv() == null || a.getNaziv().trim().isEmpty()) {
            throw new Exception("Naziv aranzmana ne sme biti prazan!");
        }
        if (a.getPoreskaStopa() == null) {
            throw new Exception("Poreska stopa mora biti uneta!");
        }
        if (a.getCenaBezPDV() <= 0 || a.getCenaSaPDV() <= 0) {
            throw new Exception("Cena mora biti veca od nule!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DatabaseBroker.getInstance().insert(odo);
    }

}
