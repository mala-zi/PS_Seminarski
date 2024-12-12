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
public class StrucnaSprema implements Serializable{
    private int id;
    private String naziv;
    private String nivo;
    private boolean sertifikat;

    public StrucnaSprema() {
    }

    public StrucnaSprema(int id, String naziv, String nivo, boolean sertifikat) {
        this.id = id;
        this.naziv= naziv;
        this.nivo= nivo;
        this.sertifikat = sertifikat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazi() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNivo() {
        return nivo;
    }

    public void setNivo(String nivo) {
        this.nivo = nivo;
    }

    public boolean isSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(boolean sertifikat) {
        this.sertifikat = sertifikat;
    }

    @Override
    public String toString() {
        return naziv ;
    }

    
}
