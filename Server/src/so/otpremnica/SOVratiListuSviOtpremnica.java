/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.otpremnica;

import dbb.DatabaseBroker;
import domain.OpstiDomenskiObjekat;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOVratiListuSviOtpremnica extends OpstaSistemskaOperacija {

    private ArrayList<Otpremnica> list;

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Otpremnica)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Otpremnica !");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        list = (ArrayList<Otpremnica>) (ArrayList<?>) DatabaseBroker.getInstance().select(odo);
        for (Otpremnica o : list) {
            StavkaOtpremnice s = new StavkaOtpremnice();
            s.setOtpremnica(o);
            o.setStavkeOtpremnice(
                    (ArrayList<StavkaOtpremnice>) (ArrayList<?>) DatabaseBroker.getInstance().select(s));
        }
    }

    public ArrayList<Otpremnica> getList() {
        return list;
    }

}
