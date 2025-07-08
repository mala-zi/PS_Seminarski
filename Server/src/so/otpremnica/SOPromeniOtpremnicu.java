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
        System.out.println("Usao u validate");

        if (!(odo instanceof Otpremnica)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Otpremnica !");
        }
        System.out.println("Jeste klase otpremnica");

        Otpremnica otpremnica = (Otpremnica) odo;

        if (otpremnica.getStavkeOtpremnice().isEmpty()) {
            throw new Exception("Otpremnica mora imati stavke!");
        }
        System.out.println("Izasao iz validate");

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
