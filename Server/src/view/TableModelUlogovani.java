/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ServerController;
import domain.Cvecar;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import thread.ThreadServer;

/**
 *
 * @author Saki
 */
public class TableModelUlogovani extends AbstractTableModel {

    private String[] kolone = {"Korisnicko ime", "Ime", "Prezime"};
    private ArrayList<Cvecar> cvecari;

    public TableModelUlogovani() {
        try {
            ArrayList<Cvecar> lista = ServerController.getInstance().ucitajCvecareIzBaze();
            ArrayList<Cvecar> ulogovani=new ArrayList<Cvecar>();
            int i=0;
            for(Cvecar c: lista){
                if(ThreadServer.getAktivniKorisnici().contains(c.getKorisnickoIme())){
                    ulogovani.add(c);
                }
                i++;
            }
            this.cvecari = ulogovani;
        } catch (Exception ex) {
            Logger.getLogger(TableModelUlogovani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public int getRowCount() {
        return cvecari.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cvecar c = cvecari.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getKorisnickoIme();
            case 1:
                return c.getIme();
            case 2:
                return c.getPrezime();

            default:
                return "n/a";
        }
    }

    public Cvecar getMenadzerNa(int i) {
        return this.cvecari.get(i);
    }

    public void obrisiMenadzera(int i) {
        this.cvecari.remove(i);
    }

}
