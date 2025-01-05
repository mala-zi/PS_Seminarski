/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Saki
 */
public interface OpstiDomenskiObjekat  extends Serializable{
    public String vratiNazivTabele();
    
    public int vratiOdredjenID();
    
    public String vratiIme();
    
    public String vratiPrezime();

    public String vratiVrednostiZaInsert();

    public String vratiVrednostiZaOperacijuUpdate();

    public String vratiUslovZaOperacijuUpdate();
    
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;
    
    public String vratiUslovZaPretragu();
    
    public String vratiUslovZaBrisanje();
    
    public  String vratiUslovZaID();
    
    public int vratiID(ResultSet rs);

    public String vratiIme(ResultSet rs);

    public String vratiPrezime(ResultSet rs);
    
    public String vratiKorisnickoIme();

    public int vratiSlobodanID(ResultSet rs);

    public String vratiJoinTabelu();

    public String vratiUslovZaJoin();

    public String uzmiID();

    public String vratiJoinTabelu2();

    public String vratiUslovZaJoin2();

    public String vratiKolone();
    
}
