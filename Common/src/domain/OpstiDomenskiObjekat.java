/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 38169
 */
public abstract class OpstiDomenskiObjekat implements Serializable {

    public abstract String nazivTabele();

    public abstract String alijas();

    public abstract String join();

    public abstract ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException;

    public abstract String koloneZaInsert();

    public abstract String vrednostZaPrimarniKljuc();

    public abstract String vrednostiZaInsert();

    public abstract String vrednostiZaUpdate();

    public abstract String uslov();

   /* public abstract String vratiNazivTabele();

    public abstract int vratiOdredjenID();

    public abstract String vratiIme();

    public abstract String vratiPrezime();

    public abstract String vratiVrednostiZaInsert();

    public abstract String vratiVrednostiZaOperacijuUpdate();

    public abstract String vratiUslovZaOperacijuUpdate();

    public abstract List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;

    public abstract String vratiUslovZaPretragu();

    public abstract String vratiUslovZaBrisanje();

    public abstract String vratiUslovZaID();

    public abstract int vratiID(ResultSet rs);

    public abstract String vratiIme(ResultSet rs);

    public abstract String vratiPrezime(ResultSet rs);

    public abstract String vratiKorisnickoIme();

    public abstract int vratiSlobodanID(ResultSet rs);

    public abstract String vratiJoinTabelu();

    public abstract String vratiUslovZaJoin();

    public abstract String uzmiID();

    public abstract String vratiJoinTabelu2();

    public abstract String vratiUslovZaJoin2();

    public abstract String vratiKolone();
}*/

}
