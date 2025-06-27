/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Saki
 */
public class Aranzman extends OpstiDomenskiObjekat{
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

     @Override
    public String nazivTabele() {
        return "Aranzman";
    }

    @Override
    public String alijas() {
        return "a";
    }

    @Override
    public String join() {
        return "JOIN PoreskaStopa ps ON a.PoreskaStopaID = ps.PoreskaStopaID";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            PoreskaStopa ps = new PoreskaStopa(rs.getInt("PoreskaStopaID"), rs.getDouble("Stopa"));
            Aranzman a = new Aranzman(
                rs.getInt("AranzmanID"),
                rs.getString("Naziv"),
                rs.getString("Opis"),
                ps,
                rs.getDouble("CenaBezPDV"),
                rs.getDouble("CenaSaPDV"),
                rs.getDouble("Popust")
            );
            lista.add(a);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(AranzmanID, Naziv, Opis, PoreskaStopaID, CenaBezPDV, CenaSaPDV, Popust)";
    }

    @Override
    public String vrednostiZaInsert() {
        return id + ", '" + naziv + "', '" + opis + "', " + poreskaStopa.getId() + ", " +
               cenaBezPDV + ", " + cenaSaPDV + ", " + popust;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "Naziv = '" + naziv + "', Opis = '" + opis + "', PoreskaStopaID = " + poreskaStopa.getId() +
               ", CenaBezPDV = " + cenaBezPDV + ", CenaSaPDV = " + cenaSaPDV + ", Popust = " + popust;
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "AranzmanID = " + id;
    }

    @Override
    public String uslov() {
        return " WHERE AranzmanID = " + id;
    }
    
}
