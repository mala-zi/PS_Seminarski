/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class Kupac extends OpstiDomenskiObjekat {

  
    private int id;
    private int pib;
    private String telefon;
    private String email;
    private Mesto mesto;
    private String naziv;
    private String ime;
    private String prezime;
    private TipKupca tip;

    public Kupac() {
    }

    public Kupac(int id, int pib, String telefon, String email, Mesto mesto, String naziv, String ime, String prezime, TipKupca tip) {
        this.id = id;
        this.pib = pib;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
        this.naziv = naziv;
        this.ime = ime;
        this.prezime = prezime;
        this.tip = tip;
    }

    public Kupac(int pib, String telefon, String email, Mesto mesto, String naziv, String ime, String prezime, TipKupca tip) {
        this.pib = pib;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
        this.naziv = naziv;
        this.ime = ime;
        this.prezime = prezime;
        this.tip = tip;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public TipKupca getTip() {
        return tip;
    }

    public void setTip(TipKupca tip) {
        this.tip = tip;
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

    public void setPib(int pib) {
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
        if (tip == TipKupca.FIZICKO_LICE) {
            return ime + " " + prezime;
        } else {
            return naziv;
        }
    }

    @Override
    public String nazivTabele() {
        return "kupac";
    }

    @Override
    public String alijas() {
        return "k";
    }

    @Override
    public String join() {
        return "JOIN mesto m ON k.idMesto = m.id";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Mesto m = new Mesto(
                    rs.getInt("m.id"),
                    rs.getString("m.grad"),
                    rs.getInt("m.postanskiBroj"),
                    rs.getString("m.ulica")
            );
            String tipStr = rs.getString("k.tip");
            TipKupca tipKupca = TipKupca.valueOf(tipStr);
            Kupac k = new Kupac(
                    rs.getInt("k.id"),
                    rs.getInt("k.pib"),
                    rs.getString("k.telefon"),
                    rs.getString("k.email"),
                    m,
                    rs.getString("k.naziv"),
                    rs.getString("k.ime"),
                    rs.getString("k.prezime"),
                    tipKupca
            );
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(pib, telefon, email, idMesto, naziv,ime,prezime,tip)";
    }

    @Override
    public String vrednostiZaInsert() {
        return pib + ", '" + telefon + "', '" + email + "', "
                + mesto.getId() + ", '" + naziv + "', '"
                + ime + "', '" + prezime + "', '" + tip.name() + "'";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id = " + id;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "pib = " + pib
                + ", telefon = '" + telefon + "'"
                + ", email = '" + email + "'"
                + ", idMesto = " + mesto.getId()
                + ", naziv = '" + naziv + "'"
                + ", ime = '" + ime + "'"
                + ", prezime = '" + prezime + "'"
                + ", tip = '" + tip.name() + "'";
    }

    @Override
    public String uslov() {
        ArrayList<String> uslovi = new ArrayList<>();

        if (mesto != null && mesto.getId() > 0) {
            uslovi.add("k.idMesto = " + mesto.getId());
        }
        if (this != null && this.getNaziv() != null) {
            uslovi.add("k.naziv = '" + this.getNaziv() + "'");
        }

        if (uslovi.isEmpty()) {
            return "";
        }
        return "WHERE " + String.join(" AND ", uslovi);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Kupac other = (Kupac) obj;      
        if (this.tip == TipKupca.PRAVNO_LICE && other.tip == TipKupca.PRAVNO_LICE) {
            if(this.pib == other.pib){
                return true;
            }else{
                return this.email != null && this.email.equalsIgnoreCase(other.email);
            }          
        }
        return this.email != null && this.email.equalsIgnoreCase(other.email);      
    }
}
