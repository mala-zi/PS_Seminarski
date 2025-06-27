/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;


import java.util.Date;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Saki
 */
public class CvSS extends OpstiDomenskiObjekat{
    private Cvecar cvecar;
    private StrucnaSprema strucnaSprema;
    private Date datumObuke;

    public CvSS() {
    }

    public CvSS(Cvecar cvecar, StrucnaSprema strucnaSprema, Date datumObuke) {
        this.cvecar = cvecar;
        this.strucnaSprema = strucnaSprema;
        this.datumObuke = datumObuke;
    }

    public Cvecar getCvecar() {
        return cvecar;
    }

    public void setCvecar(Cvecar cvecar) {
        this.cvecar = cvecar;
    }

    public StrucnaSprema getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    public Date getDatumObuke() {
        return datumObuke;
    }

    public void setDatumObuke(Date datumObuke) {
        this.datumObuke = datumObuke;
    }

    @Override
    public String toString() {
        return "CvSS{" + "cvecar=" + cvecar + ", strucnaSprema=" + strucnaSprema + ", datumObuke=" + datumObuke + '}';
    }
     @Override
    public String nazivTabele() {
        return "CvSS";
    }

    @Override
    public String alijas() {
        return "cvss";
    }

    @Override
    public String join() {
        return "JOIN Cvecar c ON cvss.CvecarID = c.CvecarID "
             + "JOIN StrucnaSprema ss ON cvss.StrucnaSpremaID = ss.StrucnaSpremaID";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Cvecar cvecar = new Cvecar();
            cvecar.setId(rs.getInt("CvecarID"));
            // Populate more fields if necessary

            StrucnaSprema ss = new StrucnaSprema();
            ss.setId(rs.getInt("StrucnaSpremaID"));
            ss.setNaziv(rs.getString("Naziv"));
            ss.setNivo(rs.getString("Nivo"));
            ss.setSertifikat(rs.getBoolean("Sertifikat"));

            CvSS cvss = new CvSS(cvecar, ss, rs.getDate("DatumObuke"));

            lista.add(cvss);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(CvecarID, StrucnaSpremaID, DatumObuke)";
    }

    @Override
    public String vrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return cvecar.getId() + ", " + strucnaSprema.getId() + ", '" + sdf.format(datumObuke) + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "DatumObuke = '" + sdf.format(datumObuke) + "'";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "CvecarID = " + cvecar.getId() + " AND StrucnaSpremaID = " + strucnaSprema.getId();
    }

    @Override
    public String uslov() {
        return " WHERE " + vrednostZaPrimarniKljuc();
    }
}
