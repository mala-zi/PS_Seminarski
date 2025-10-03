/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.otpremnica;

import dbb.DatabaseBroker;
import domain.OpstiDomenskiObjekat;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOPromeniOtpremnicu extends OpstaSistemskaOperacija {

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Otpremnica)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Otpremnica !");
        }

        Otpremnica otpremnica = (Otpremnica) odo;

      /*  if (otpremnica.getStavkeOtpremnice().isEmpty()) {
            throw new Exception("Otpremnica mora imati stavke!");
        }*/
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DatabaseBroker.getInstance().update(odo);
        Otpremnica otpremnica = (Otpremnica) odo;
        DatabaseBroker.getInstance().delete(otpremnica.getStavkeOtpremnice().get(0));

        for (StavkaOtpremnice stavkaOtpremnice : otpremnica.getStavkeOtpremnice()) {
            DatabaseBroker.getInstance().insert(stavkaOtpremnice);
        }
    }

}
