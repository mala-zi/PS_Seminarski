/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.cvecar;

import dbb.DatabaseBroker;
import domain.Cvecar;
import domain.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Saki
 */
public class SOPrijaviCvecara extends OpstaSistemskaOperacija{
    private Cvecar prijavljenCvecar;
    public Cvecar getPrijavljenCvecar() {
        return prijavljenCvecar;
    }

    public void setPrijavljenCvecar(Cvecar prijavljenCvecar) {
        this.prijavljenCvecar = prijavljenCvecar;
    }

    
    
    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        OpstiDomenskiObjekat odo1=DatabaseBroker.getInstance().prijaviCvecara(odo);
        prijavljenCvecar=(Cvecar) odo1;
    }
    
}
