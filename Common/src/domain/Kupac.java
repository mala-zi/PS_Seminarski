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
public class Kupac extends OpstiDomenskiObjekat{
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
            rs.getInt("id"),
            rs.getString("grad"),
            rs.getInt("postanskiBroj"),
            rs.getString("ulica")
        );
            Kupac k = new Kupac(
                    rs.getInt("id"),
                    rs.getInt("pib"),
                    rs.getString("telefon"),
                    rs.getString("email"),
                    m,
                    rs.getString("naziv")
            );
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(pib, telefon, email, idMesto, naziv)";
    }

    @Override
    public String vrednostiZaInsert() {
        return pib + ", '" + telefon + "', '" + email + "', " + mesto.getId() + ", '" + naziv + "'";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id = " + id;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "pib = " + pib + ", telefon = '" + telefon + "', email = '" + email + "', idMesto = " + mesto.getId() + ", naziv = '" + naziv + "'";
    }

    @Override
    public String uslov() {
        return "WHERE id = " + id;
    }

}
