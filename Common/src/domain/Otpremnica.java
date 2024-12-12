/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Saki
 */
public class Otpremnica implements Serializable{
    private int id;
    private double ukupanIznosBezPDv;
    private double ukupanIznosSaPDV;
    private double ukupanPopust;
    private Date datumIzdavanja;
    private double ukupnaCena;
    private Cvecar cvecar;
    private Kupac kupac;

    public Otpremnica() {
    }

    public Otpremnica( double ukupanIznosBezPDv, double ukupanIznosSaPDV, double ukupanPopust, Date datumIzdavanja, double ukupnaCena, Cvecar cvecar, Kupac kupac) {
        
        this.ukupanIznosBezPDv = ukupanIznosBezPDv;
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
        this.ukupanPopust = ukupanPopust;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupnaCena = ukupnaCena;
        this.cvecar = cvecar;
        this.kupac = kupac;
    }
    public Otpremnica(int id, double ukupanIznosBezPDv, double ukupanIznosSaPDV, double ukupanPopust, Date datumIzdavanja, double ukupnaCena, Cvecar cvecar, Kupac kupac) {
        this.id = id;
        this.ukupanIznosBezPDv = ukupanIznosBezPDv;
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
        this.ukupanPopust = ukupanPopust;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupnaCena = ukupnaCena;
        this.cvecar = cvecar;
        this.kupac = kupac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUkupanIznosBezPDv() {
        return ukupanIznosBezPDv;
    }

    public void setUkupanIznosBezPDv(double ukupanIznosBezPDv) {
        this.ukupanIznosBezPDv = ukupanIznosBezPDv;
    }

    public double getUkupanIznosSaPDV() {
        return ukupanIznosSaPDV;
    }

    public void setUkupanIznosSaPDV(double ukupanIznosSaPDV) {
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
    }

    public double getUkupanPopust() {
        return ukupanPopust;
    }

    public void setUkupanPopust(double ukupanPopust) {
        this.ukupanPopust = ukupanPopust;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Cvecar getCvecar() {
        return cvecar;
    }

    public void setCvecar(Cvecar cvecar) {
        this.cvecar = cvecar;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    @Override
    public String toString() {
        return "Otpremnica{" + "id=" + id + ", ukupanIznosBezPDv=" + ukupanIznosBezPDv + ", ukupanIznosSaPDV=" + ukupanIznosSaPDV + ", ukupanPopust=" + ukupanPopust + ", datumIzdavanja=" + datumIzdavanja + ", ukupnaCena=" + ukupnaCena + ", cvecar=" + cvecar + ", kupac=" + kupac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Otpremnica other = (Otpremnica) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cvecar, other.cvecar)) {
            return false;
        }
        return Objects.equals(this.kupac, other.kupac);
    }
    

   
}
