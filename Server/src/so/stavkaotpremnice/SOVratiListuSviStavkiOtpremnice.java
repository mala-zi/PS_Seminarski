/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkaotpremnice;

import dbb.DatabaseBroker;
import domain.OpstiDomenskiObjekat;
import domain.StavkaOtpremnice;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOVratiListuSviStavkiOtpremnice extends OpstaSistemskaOperacija {

    private ArrayList<StavkaOtpremnice> lista;

    public ArrayList<StavkaOtpremnice> getLista() {
        return lista;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof StavkaOtpremnice)) {
            throw new Exception("Prosleđeni objekat nije instanca klase StavkaOtpremnice!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        lista = (ArrayList<StavkaOtpremnice>) (ArrayList<?>) DatabaseBroker.getInstance().select(odo);

    }

}
