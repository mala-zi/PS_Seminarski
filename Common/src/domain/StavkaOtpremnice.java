/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Saki
 */
public class StavkaOtpremnice extends OpstiDomenskiObjekat {
    private int rb;
    private int kolicina;
    private String napomena;
    private double iznosBezPDV;
    private double iznosSaPDV;
    private double cenaBezPDV;
    private double cenaSaPDV;
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
        this.cenaSaPDV = cenaSaPdDV;
        this.aranzman = aranzman;
        this.otpremnica = otpremnica;
    }
    public StavkaOtpremnice(int kolicina, String napomena, double iznosBezPDV, double iznosSaPDV, double cenaBezPDV, double cenaSaPdDV, Aranzman aranzman, Otpremnica otpremnica) {

        this.kolicina = kolicina;
        this.napomena = napomena;
        this.iznosBezPDV = iznosBezPDV;
        this.iznosSaPDV = iznosSaPDV;
        this.cenaBezPDV = cenaBezPDV;
        this.cenaSaPDV = cenaSaPdDV;
        this.aranzman = aranzman;
        this.otpremnica = otpremnica;
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

    public double getCenaSaPDV() {
        return cenaSaPDV;
    }

    public void setCenaSaPDV(double cenaSaPdDV) {
        this.cenaSaPDV = cenaSaPdDV;
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
        return "StavkaOtpremnice{" + "rb=" + rb + ", kolicina=" + kolicina + ", napomena=" + napomena + ", iznosBezPDV=" + iznosBezPDV + ", iznosSaPDV=" + iznosSaPDV + ", cenaBezPDV=" + cenaBezPDV + ", cenaSaPdDV=" + cenaSaPDV + ", aranzman=" + aranzman + ", otpremnica=" + otpremnica + '}';
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

    @Override
    public String nazivTabele() {
        return "stavkaotpremnice";
    }

    @Override
    public String alijas() {
        return "so";
    }

    @Override
    public String join() {
        return "JOIN aranzman a ON (so.idAranzman = a.id) "
                + "JOIN otpremnica o ON (so.idOtpremnica = o.id)"
                +"JOIN poreskastopa ps ON(a.poreskaStopa = ps.id)"
                +"JOIN cvecar c ON(c.id = o.idCvecar)"
                +"JOIN kupac k ON (k.id = o.idKupac)"
                +"JOIN mesto m ON (m.id = k.idMesto)";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            PoreskaStopa ps = new PoreskaStopa(
                    rs.getInt("ps.id"),
                    rs.getDouble("ps.vrednost")
            );

            // Aranzman
            Aranzman aranzman = new Aranzman(
                    rs.getInt("a.id"),
                    rs.getString("a.naziv"),
                    rs.getString("a.opis"),
                    ps,
                    rs.getDouble("a.cenaBezPDV"),
                    rs.getDouble("a.cenaSaPDV"),
                    rs.getDouble("a.popust")
            );
            Cvecar cvecar = new Cvecar(
                    rs.getInt("c.id"),
                    rs.getString("c.ime"),
                    rs.getString("c.prezime"),
                    rs.getString("c.korisnickoIme"),
                    rs.getString("c.lozinka")
            );
            Mesto mesto = new Mesto(
                    rs.getInt("m.id"),
                    rs.getString("m.grad"),
                    rs.getInt("m.postanskiBroj"),
                    rs.getString("m.ulica")
            );

            Kupac kupac = new Kupac(
                    rs.getInt("k.id"),
                    rs.getInt("k.pib"),
                    rs.getString("k.telefon"),
                    rs.getString("k.email"),
                    mesto,
                    rs.getString("k.naziv")
            );

            Otpremnica otpremnica = new Otpremnica(
                    rs.getInt("o.id"),
                    rs.getDouble("o.ukupanIznosBezPDV"),
                    rs.getDouble("o.ukupanIznosSaPDV"),
                    rs.getDouble("o.ukupanPopust"),
                    rs.getDate("o.datumIzdavanja"),                   
                    cvecar,
                    kupac,null
            );

            StavkaOtpremnice so = new StavkaOtpremnice(
                    rs.getInt("rb"),
                    rs.getInt("kolicina"),
                    rs.getString("napomena"),
                    rs.getDouble("iznosBezPDV"),
                    rs.getDouble("iznosSaPDV"),
                    rs.getDouble("cenaBezPDV"),
                    rs.getDouble("cenaSaPDV"),
                    aranzman,
                    otpremnica
            );

            lista.add(so);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (idOtpremnica, rb, kolicina, napomena, iznosBezPDV, iznosSaPDV, cenaBezPDV, cenaSaPDV, idAranzman) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + otpremnica.getId() + ", " + rb + ", " + kolicina + ", '"
                + napomena + "', " + iznosBezPDV + ", " + iznosSaPDV + ", "
                + cenaBezPDV + ", " + cenaSaPDV + ", " + aranzman.getId() + " ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " idOtpremnica = " + otpremnica.getId();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE o.id = " + otpremnica.getId();
    }

}
