/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Saki
 */
public class Otpremnica extends OpstiDomenskiObjekat {

    private int id;
    private double ukupanIznosBezPDv;
    private double ukupanIznosSaPDV;
    private double ukupanPopust;
    private Date datumIzdavanja;
    private double ukupnaCena;
    private Cvecar cvecar;
    private Kupac kupac;
    private ArrayList<StavkaOtpremnice> stavkeOtpremnice;

    public Otpremnica() {
    }

    public Otpremnica(double ukupanIznosBezPDv, double ukupanIznosSaPDV, double ukupanPopust, Date datumIzdavanja, double ukupnaCena, Cvecar cvecar, Kupac kupac) {

        this.ukupanIznosBezPDv = ukupanIznosBezPDv;
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
        this.ukupanPopust = ukupanPopust;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupnaCena = ukupnaCena;
        this.cvecar = cvecar;
        this.kupac = kupac;
    }

    public Otpremnica(int id, double ukupanIznosBezPDv, double ukupanIznosSaPDV, double ukupanPopust, Date datumIzdavanja, double ukupnaCena, Cvecar cvecar, Kupac kupac, ArrayList<StavkaOtpremnice> stavkeOtpremnice) {
        this.id = id;
        this.ukupanIznosBezPDv = ukupanIznosBezPDv;
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
        this.ukupanPopust = ukupanPopust;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupnaCena = ukupnaCena;
        this.cvecar = cvecar;
        this.kupac = kupac;
        this.stavkeOtpremnice = stavkeOtpremnice;
    }

    public ArrayList<StavkaOtpremnice> getStavkeOtpremnice() {
        return stavkeOtpremnice;
    }

    public void setStavkeOtpremnice(ArrayList<StavkaOtpremnice> stavkeOtpremnice) {
        this.stavkeOtpremnice = stavkeOtpremnice;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUkupanIznosBezPDv() {
        return ukupanIznosBezPDv;
    }

    public void setUkupanIznosBezPDv(double ukupanIznosBezPDv) {
        this.ukupanIznosBezPDv = ukupanIznosBezPDv;
    }

    public double getUkupanIznosSaPDV() {
        return ukupanIznosSaPDV;
    }

    public void setUkupanIznosSaPDV(double ukupanIznosSaPDV) {
        this.ukupanIznosSaPDV = ukupanIznosSaPDV;
    }

    public double getUkupanPopust() {
        return ukupanPopust;
    }

    public void setUkupanPopust(double ukupanPopust) {
        this.ukupanPopust = ukupanPopust;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Cvecar getCvecar() {
        return cvecar;
    }

    public void setCvecar(Cvecar cvecar) {
        this.cvecar = cvecar;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    @Override
    public String toString() {
        return "Otpremnica{" + "id=" + id + ", ukupanIznosBezPDv=" + ukupanIznosBezPDv + ", ukupanIznosSaPDV=" + ukupanIznosSaPDV + ", ukupanPopust=" + ukupanPopust + ", datumIzdavanja=" + datumIzdavanja + ", ukupnaCena=" + ukupnaCena + ", cvecar=" + cvecar + ", kupac=" + kupac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Otpremnica other = (Otpremnica) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cvecar, other.cvecar)) {
            return false;
        }
        return Objects.equals(this.kupac, other.kupac);
    }

    @Override
    public String nazivTabele() {
        return "otpremnica";
    }

    @Override
    public String alijas() {
        return "o";
    }

    @Override
    public String join() {
        return " JOIN cvecar c ON (c.id = o.idCvecar) "
                + "JOIN kupac k ON (k.id = o.idKupac)";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Mesto m = new Mesto(
                    rs.getInt("m.id"),
                    rs.getString("m.grad"),
                    rs.getInt("m.postanskiBroj"),
                    rs.getString("m.ulica"));
            Kupac kupac = new Kupac(
                    rs.getInt("k.id"),
                    rs.getInt("k.pib"),
                    rs.getString("k.telefon"),
                    rs.getString("k.email"),
                    m,
                    rs.getString("k.naziv")
            );

            Cvecar cvecar = new Cvecar(
                    rs.getInt("c.id"),
                    rs.getString("c.ime"),
                    rs.getString("c.prezime"),
                    rs.getString("c.korisnickoIme"),
                    rs.getString("c.lozinka")
            );

            Otpremnica o = new Otpremnica(
                    rs.getInt("o.id"),
                    rs.getDouble("o.ukupanIznosBezPDv"),
                    rs.getDouble("o.ukupanIznosSaPDV"),
                    rs.getDouble("o.ukupanPopust"),
                    rs.getDate("o.datumIzdavanja"),
                    rs.getDouble("o.ukupnaCena"),
                    cvecar,
                    kupac,null
            );

            lista.add(o);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(ukupanIznosBezPDv, ukupanIznosSaPDV, ukupanPopust, datumIzdavanja, ukupnaCena, idCvecar, idKupac)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id = " + id;
    }

    @Override
    public String vrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datumStr = (datumIzdavanja != null) ? "'" + sdf.format(datumIzdavanja) + "'" : "NULL";

        return ukupanIznosBezPDv + ", " + ukupanIznosSaPDV + ", " + ukupanPopust + ", "
                + datumStr + ", " + ukupnaCena + ", " + cvecar.getId() + ", " + kupac.getId();
    }

    @Override
    public String vrednostiZaUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datumStr = (datumIzdavanja != null) ? "'" + sdf.format(datumIzdavanja) + "'" : "NULL";

        return "ukupanIznosBezPDv = " + ukupanIznosBezPDv
                + ", ukupanIznosSaPDV = " + ukupanIznosSaPDV
                + ", ukupanPopust = " + ukupanPopust
                + ", datumIzdavanja = " + datumStr
                + ", ukupnaCena = " + ukupnaCena
                + ", idCvecar = " + cvecar.getId()
                + ", idKupac = " + kupac.getId();
    }

    @Override
    public String uslov() {
        return "";
    }

}
