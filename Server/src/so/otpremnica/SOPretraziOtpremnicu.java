/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.otpremnica;

import dbb.DatabaseBroker;
import domain.OpstiDomenskiObjekat;
import domain.Otpremnica;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOPretraziOtpremnicu extends OpstaSistemskaOperacija{
     private ArrayList<Otpremnica> lista;
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Otpremnica)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Otpremnica!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        lista = (ArrayList<Otpremnica>) (ArrayList<?>) DatabaseBroker.getInstance().select(odo);
    }

    public ArrayList<Otpremnica> getLista() {
        return lista;
    }
}
