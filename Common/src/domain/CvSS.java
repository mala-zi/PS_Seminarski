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
        return "cvss";
    }

    @Override
    public String alijas() {
        return "cvss";
    }

    @Override
    public String join() {
        return "JOIN cvecar c ON cvss.idCvecar = c.id "
             + "JOIN strucnasprema ss ON cvss.idStrucnaSprema = ss.id";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Cvecar cvecar = new Cvecar();
            cvecar.setId(rs.getInt("id"));
            // Populate more fields if necessary

            StrucnaSprema ss = new StrucnaSprema();
            ss.setId(rs.getInt("id"));
            ss.setNaziv(rs.getString("naziv"));
            ss.setNivo(rs.getString("nivo"));
            ss.setSertifikat(rs.getBoolean("sertifikat"));

            CvSS cvss = new CvSS(cvecar, ss, rs.getDate("DatumObuke"));

            lista.add(cvss);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(idCvecar, idStrucnaSprema, datumObuke)";
    }

    @Override
    public String vrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return cvecar.getId() + ", " + strucnaSprema.getId() + ", '" + sdf.format(datumObuke) + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "datumObuke = '" + sdf.format(datumObuke) + "'";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "idCvecar = " + cvecar.getId() + " AND idStrucnaSprema = " + strucnaSprema.getId();
    }

    @Override
    public String uslov() {
        return " WHERE " + vrednostZaPrimarniKljuc();
    }
}
