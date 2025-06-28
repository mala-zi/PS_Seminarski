/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Saki
 */
public class StrucnaSprema extends OpstiDomenskiObjekat {
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

     @Override
    public String nazivTabele() {
        return "strucnasprema";
    }

    @Override
    public String alijas() {
        return "ss";
    }

    @Override
    public String join() {
        return ""; 
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            StrucnaSprema ss = new StrucnaSprema(
                rs.getInt("id"),
                rs.getString("naziv"),
                rs.getString("nivo"),
                rs.getBoolean("sertifikat")
            );
            lista.add(ss);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(id, naziv, nivo, sertifikat)";
    }

    @Override
    public String vrednostiZaInsert() {
        return id + ", '" + naziv + "', '" + nivo + "', " + (sertifikat ? 1 : 0);
    }

    @Override
    public String vrednostiZaUpdate() {
        return "naziv = '" + naziv + "', nivo = '" + nivo + "', sertifikat = " + (sertifikat ? 1 : 0);
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id = " + id;
    }

    @Override
    public String uslov() {
        return " WHERE id = " + id;
    }
}
