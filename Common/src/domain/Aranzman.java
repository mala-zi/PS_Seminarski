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
public class Aranzman extends OpstiDomenskiObjekat {

    private int id;
    private String naziv;
    private String opis;
    private PoreskaStopa poreskaStopa;
    private double cenaBezPDV;
    private double cenaSaPDV;
    public double popust;

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

    public Aranzman(String naziv, String opis, PoreskaStopa poreskaStopa, double cenaBezPDV, double cenaSaPDV, double popust) {

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

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
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

    @Override
    public String toString() {
        return naziv;
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
        return "aranzman";
    }

    @Override
    public String alijas() {
        return "a";
    }

    @Override
    public String join() {
        return "JOIN poreskastopa ps ON a.poreskaStopa = ps.id";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            PoreskaStopa ps = new PoreskaStopa(rs.getInt("id"), rs.getDouble("vrednost"));
            Aranzman a = new Aranzman(
                    rs.getInt("id"),
                    rs.getString("naziv"),
                    rs.getString("opis"),
                    ps,
                    rs.getDouble("cenaBezPDV"),
                    rs.getDouble("cenaSaPDV"),
                    rs.getDouble("popust")
            );
            lista.add(a);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(naziv, opis, poreskaStopa, cenaBezPDV, cenaSaPDV, popust)";
    }

    @Override
    public String vrednostiZaInsert() {
        return id + ", '" + naziv + "', '" + opis + "', " + poreskaStopa.getId() + ", "
                + cenaBezPDV + ", " + cenaSaPDV+", "+popust;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "naziv = '" + naziv + "', opis = '" + opis + "', poreskaStopa = " + poreskaStopa.getId()
                + ", cenaBezPDV = " + cenaBezPDV + ", cenaSaPDV = " + cenaSaPDV+", "+popust;
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
