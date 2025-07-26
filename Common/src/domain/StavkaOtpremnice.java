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

    public StavkaOtpremnice(int kolicina, String napomena, double iznosBezPDV, double iznosSaPDV, double cenaBezPDV, double cenaSaPdDV, Aranzman aranzman) {

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
                + "JOIN otpremnica o ON (so.idOtpremnica = o.id)";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            PoreskaStopa ps = new PoreskaStopa(
                    rs.getInt("id"),
                    rs.getDouble("vrednost")
            );

            // Aranzman
            Aranzman aranzman = new Aranzman(
                    rs.getInt("id"),
                    rs.getString("naziv"),
                    rs.getString("opis"),
                    ps,
                    rs.getDouble("cenaBezPDV"),
                    rs.getDouble("cenaSaPDV"),
                    rs.getDouble("popust")
            );
            Cvecar cvecar = new Cvecar(
                    rs.getInt("id"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("korisnickoIme"),
                    rs.getString("lozinka")
            );
            Mesto mesto = new Mesto(
                    rs.getInt("id"),
                    rs.getString("grad"),
                    rs.getInt("postanskiBroj"),
                    rs.getString("ulica")
            );

            Kupac kupac = new Kupac(
                    rs.getInt("id"),
                    rs.getInt("pib"),
                    rs.getString("telefon"),
                    rs.getString("email"),
                    mesto,
                    rs.getString("naziv")
            );

            Otpremnica otpremnica = new Otpremnica(
                    rs.getInt("id"),
                    rs.getDouble("ukupanIznosBezPDV"),
                    rs.getDouble("ukupanIznosSaPDV"),
                    rs.getDouble("ukupanPopust"),
                    rs.getDate("datumIzdavanja"),
                    rs.getDouble("ukupnaCena"),
                    
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
                + cenaBezPDV + ", " + cenaSaPdDV + ", " + aranzman.getId() + " ";
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
        return " WHERE o.idOtpremnica = " + otpremnica.getId();
    }

}
