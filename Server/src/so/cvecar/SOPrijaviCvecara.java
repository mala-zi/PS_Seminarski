/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.cvecar;

import dbb.DatabaseBroker;
import domain.Cvecar;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOPrijaviCvecara extends OpstaSistemskaOperacija{
    private Cvecar prijavljenCvecar;

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Cvecar))
            throw  new Exception("Prosleđeni objekat nije instanca klase Cvećar!");
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        Cvecar c= (Cvecar) odo;
        ArrayList<Cvecar> listaCvecara= (ArrayList<Cvecar>) (ArrayList<?>)
                DatabaseBroker.getInstance().select(odo);
        for (Cvecar cvecar : listaCvecara) {
            if(cvecar.getKorisnickoIme().equals(c.getKorisnickoIme()) &&
                    cvecar.getLozinka().equals(c.getLozinka())){
                prijavljenCvecar=cvecar;
                return;
            } 
        }
        
        throw new Exception("Korisničko ime ili lozinka nisu ispravni!");
    }

    public Cvecar getPrijavljenCvecar() {
        return prijavljenCvecar;
    }

    
    
}
