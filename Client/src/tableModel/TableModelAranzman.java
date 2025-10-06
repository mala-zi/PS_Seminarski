/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import controller.Controller;
import domain.Aranzman;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saki
 */
public class TableModelAranzman extends AbstractTableModel {

    private ArrayList<Aranzman> listaAranzmana;
    private String[] kolone = {"ID","Naziv", "Poreska Stopa(%)", "Cena bez PDV-a(RSD)", "Cena sa PDV-om(RSD)", "Opis"};

    public TableModelAranzman() {
        try {
            listaAranzmana = Controller.getInstance().ucitajAranzmaneIzBaze();
        } catch (Exception ex) {
            Logger.getLogger(TableModelAranzman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return listaAranzmana.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aranzman a = listaAranzmana.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getId();
            case 1:
                return a.getNaziv();
            case 2:
                return a.getPoreskaStopa().getVrednost();
            case 3:
                return a.getCenaBezPDV();
            case 4:
                return a.getCenaSaPDV();
            case 5:
                return a.getOpis();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Aranzman getAranzman(int row) {
        return listaAranzmana.get(row);
    }

    public void refresh() {
        try {
            listaAranzmana = Controller.getInstance().ucitajAranzmaneIzBaze();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelAranzman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
