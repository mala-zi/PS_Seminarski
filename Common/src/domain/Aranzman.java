/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Saki
 */
public class Aranzman implements Serializable{
    private int id;
    private String naziv;
    private String opis;
    private PoreskaStopa poreskaStopa;
    private double cenaBezPDV;
    private double cenaSaPDV;
    private double popust;

    public Aranzman() {
    }

    public Aranzman(int id, String naziv, String opis, PoreskaStopa poreskaStopa, double cenaBezPDV, double cenaSaPDV, double popust) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.poreskaStopa = poreskaStopa;
        this.cenaBezPDV = cenaBezPDV;
        this.cenaSaPDV = cenaSaPDV;
        this.popust = popust;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public PoreskaStopa getPoreskaStopa() {
        return poreskaStopa;
    }

    public void setPoreskaStopa(PoreskaStopa poreskaStopa) {
        this.poreskaStopa = poreskaStopa;
    }

    

    public double getCenaBezPDV() {
        return cenaBezPDV;
    }

    public void setCenaBezPDV(double cenaBezPDV) {
        this.cenaBezPDV = cenaBezPDV;
    }

    public double getCenaSaPDV() {
        return cenaSaPDV;
    }

    public void setCenaSaPDV(double cenaSaPDV) {
        this.cenaSaPDV = cenaSaPDV;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

   

    @Override
    public String toString() {
        return naziv ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Aranzman other = (Aranzman) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    
    
}
