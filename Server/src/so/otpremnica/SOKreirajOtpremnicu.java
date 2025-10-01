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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Saki
 */
public class SOKreirajOtpremnicu extends OpstaSistemskaOperacija {

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Otpremnica)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Otpremnica!");
        }

        Otpremnica otpremnica = (Otpremnica) odo;

        //if (otpremnica.getStavkeOtpremnice().isEmpty()) {
        //    throw new Exception("Otpremnica mora imati stavke!");
        // }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        try {
            Otpremnica otpremnica = (Otpremnica) odo;
            PreparedStatement ps = DatabaseBroker.getInstance().insert(odo);
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            int pID = keys.getInt(1);
            System.out.println("kljuc otpremnice: " + pID);
            otpremnica.setId(pID);

            for (StavkaOtpremnice stavkaOtpremnice : otpremnica.getStavkeOtpremnice()) {
                stavkaOtpremnice.setOtpremnica(otpremnica);
                DatabaseBroker.getInstance().insert(stavkaOtpremnice);
            }
        } catch (Exception e) {
            System.err.println("GRESKA U INSERT Otpremnica: " + e.getMessage());
            throw e;
        }

    }
}
