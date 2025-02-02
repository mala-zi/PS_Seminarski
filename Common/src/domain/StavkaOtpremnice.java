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
public class StavkaOtpremnice implements Serializable{
    private int rb;
    private int kolicina;
    private String napomena;
    private double iznosBezPDV;
    private double iznosSaPDV;
    private double cenaBezPDV;
    private double cenaSaPdDV;
    private Aranzman aranzman;
    private Otpremnica otpremnica;

    public StavkaOtpremnice() {
    }
    public StavkaOtpremnice(int rb, int kolicina, String napomena, double iznosBezPDV, double iznosSaPDV, double cenaBezPDV, double cenaSaPdDV, Aranzman aranzman, Otpremnica otpremnica) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.napomena = napomena;
        this.iznosBezPDV = iznosBezPDV;
        this.iznosSaPDV = iznosSaPDV;
        this.cenaBezPDV = cenaBezPDV;
        this.cenaSaPdDV = cenaSaPdDV;
        this.aranzman = aranzman;
        this.otpremnica = otpremnica;
    }

    public StavkaOtpremnice( int kolicina, String napomena, double iznosBezPDV, double iznosSaPDV, double cenaBezPDV, double cenaSaPdDV, Aranzman aranzman) {
        
        this.kolicina = kolicina;
        this.napomena = napomena;
        this.iznosBezPDV = iznosBezPDV;
        this.iznosSaPDV = iznosSaPDV;
        this.cenaBezPDV = cenaBezPDV;
        this.cenaSaPdDV = cenaSaPdDV;
        this.aranzman = aranzman;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public double getIznosBezPDV() {
        return iznosBezPDV;
    }

    public void setIznosBezPDV(double iznosBezPDV) {
        this.iznosBezPDV = iznosBezPDV;
    }

    public double getIznosSaPDV() {
        return iznosSaPDV;
    }

    public void setIznosSaPDV(double iznosSaPDV) {
        this.iznosSaPDV = iznosSaPDV;
    }

    public double getCenaBezPDV() {
        return cenaBezPDV;
    }

    public void setCenaBezPDV(double cenaBezPDV) {
        this.cenaBezPDV = cenaBezPDV;
    }

    public double getCenaSaPdDV() {
        return cenaSaPdDV;
    }

    public void setCenaSaPdDV(double cenaSaPdDV) {
        this.cenaSaPdDV = cenaSaPdDV;
    }

    public Aranzman getAranzman() {
        return aranzman;
    }

    public void setAranzman(Aranzman aranzman) {
        this.aranzman = aranzman;
    }

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }

    public void setOtpremnica(Otpremnica otpremnica) {
        this.otpremnica = otpremnica;
    }

    @Override
    public String toString() {
        return "StavkaOtpremnice{" + "rb=" + rb + ", kolicina=" + kolicina + ", napomena=" + napomena + ", iznosBezPDV=" + iznosBezPDV + ", iznosSaPDV=" + iznosSaPDV + ", cenaBezPDV=" + cenaBezPDV + ", cenaSaPdDV=" + cenaSaPdDV + ", aranzman=" + aranzman + ", otpremnica=" + otpremnica + '}';
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
        final StavkaOtpremnice other = (StavkaOtpremnice) obj;
        if (this.rb != other.rb) {
            return false;
        }
        if (!Objects.equals(this.aranzman, other.aranzman)) {
            return false;
        }
        return Objects.equals(this.otpremnica, other.otpremnica);
    }

    
    
    
    
}
