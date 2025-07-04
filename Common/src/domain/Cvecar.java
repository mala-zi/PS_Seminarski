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
public class Cvecar extends OpstiDomenskiObjekat{

    private int id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Cvecar() {
    }

    public Cvecar(int idCvecar, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.id = idCvecar;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Cvecar(String ime, String prezime, String korisnickoIme, String lozinka) {

        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Cvecar(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "Cvecar{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + '}';
    }

    @Override
    public String nazivTabele() {
        return "cvecar";
    }

    @Override
    public String alijas() {
        return "c";
    }

    @Override
    public String join() {
        return ""; 
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Cvecar c = new Cvecar(
                    rs.getInt("id"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("korisnickoIme"),
                    rs.getString("lozinka")
            );
            lista.add(c);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(ime, prezime, korisnickoIme, lozinka)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " id = " + id;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" + korisnickoIme + "', '" + lozinka + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "ime = '" + ime + "', prezime = '" + prezime + "', korisnickoIme = '" + korisnickoIme + "', lozinka = '" + lozinka + "'";
    }

    @Override
    public String uslov() {
        return "korisnickoIme = '" + korisnickoIme + "' AND lozinka = '" + lozinka + "'";
    }

}
