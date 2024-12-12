/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Saki
 */
public class Kupac implements Serializable{
    private int id;
    private int pib;
    private String telefon;
    private String email;
    private Mesto mesto;
    private String naziv;

    public Kupac() {
    }

    public Kupac(int id, int pib, String telefon, String email, Mesto mesto,String naziv) {
        this.id = id;
        this.pib= pib;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
        this.naziv=naziv;
    }
     public Kupac( int pib, String telefon, String email, Mesto mesto,String naziv) {
        
        this.pib = pib;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
        this.naziv=naziv;
    }


    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPib() {
        return pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPib (int pib) {
        this.pib = pib;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return naziv;
    }

   
}
