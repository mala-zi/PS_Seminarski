/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import dbb.DatabaseBroker;
import domain.OpstiDomenskiObjekat;

/**
 *
 * @author Saki
 */
public abstract class OpstaSistemskaOperacija {


    public void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        try {

            proveriPreduslov(odo);
            izvrsiKonkretnuOperaciju(odo);
            potvrdi();
        } catch (Exception ex) {
            ponisti();
            throw new Exception("Greska kod izvrsenja SO: " + ex.getMessage());
        }
    }

    protected abstract void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception;

    protected abstract void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception;

    private void potvrdi() throws Exception {
        dbb.DatabaseBroker.getInstance().commit();
    }

    private void ponisti() throws Exception {
        dbb.DatabaseBroker.getInstance().rollback();
    }

}
