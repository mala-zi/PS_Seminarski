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
            throw  new Exception("Prosledjeni objekat nije instanca klase Cvecar!");
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        Cvecar c= (Cvecar) ado;
        ArrayList<Cvecar> listaSankera= (ArrayList<Cvecar>) (ArrayList<?>)
                DatabaseBroker.getInstance().select(ado);
        for (Cvecar cvecar : listaSankera) {
            if(cvecar.getKorisnickoIme().equals(c.getKorisnickoIme()) &&
                    cvecar.getLozinka().equals(c.getLozinka())){
                prijavljenCvecar=cvecar;
                return;
            } 
        }
        
        throw new Exception("Pogresni kredencijali!");
    }

    public Cvecar getPrijavljenCvecar() {
        return prijavljenCvecar;
    }

    
    
}
