/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.aranzman;

import dbb.DatabaseBroker;
import domain.Aranzman;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOVratiListuSviAranzman extends OpstaSistemskaOperacija {

    private ArrayList<Aranzman> list;

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Aranzman)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Aranzman!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        list = (ArrayList<Aranzman>) (ArrayList<?>) DatabaseBroker.getInstance().select(odo);
    }

    public ArrayList<Aranzman> getList() {
        return list;
    }
}
