/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kupac;

import dbb.DatabaseBroker;
import domain.Kupac;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOPretraziKupca extends OpstaSistemskaOperacija{
    private ArrayList<Kupac> lista;
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Kupac)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Kupac!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        lista = (ArrayList<Kupac>) (ArrayList<?>) DatabaseBroker.getInstance().select(odo);
    }

    public ArrayList<Kupac> getLista() {
        return lista;
    }
}
