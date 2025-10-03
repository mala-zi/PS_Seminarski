/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import controller.Controller;
import javax.swing.table.AbstractTableModel;
import domain.Kupac;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class TableModelKupac extends AbstractTableModel {

    private ArrayList<Kupac> listaKupaca;
    private String[] kolone = {"ID", "Ime","Prezime","Naziv", "PIB", "Telefon", "Email", "Mesto"};

    public TableModelKupac() {
        try {
            listaKupaca = Controller.getInstance().ucitajKupceIzBaze();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKupac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TableModelKupac(ArrayList<Kupac> lista) {
        this.listaKupaca = lista;
    }

    @Override
    public int getRowCount() {
        return listaKupaca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac k = listaKupaca.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getId();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getNaziv();
            case 4:
                return k.getPib();
            case 5:
                return k.getTelefon();
            case 6:
                return k.getEmail();
            case 7:
                return k.getMesto().getGrad()+", "+k.getMesto().getUlica();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Kupac getKupac(int row) {
        return listaKupaca.get(row);
    }

    
    public void refresh() {
        try {
            listaKupaca = Controller.getInstance().ucitajKupceIzBaze();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKupac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
