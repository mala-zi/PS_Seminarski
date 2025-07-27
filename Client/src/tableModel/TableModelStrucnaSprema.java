/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import controller.Controller;
import domain.StrucnaSprema;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saki
 */
public class TableModelStrucnaSprema extends AbstractTableModel {

    private ArrayList<StrucnaSprema> listaSs;
    private int i = 1;
    private final String[] kolone = {"Naziv", "Nivo", "Sertifikat"};

    public TableModelStrucnaSprema() {
        try {
            listaSs= Controller.getInstance().ucitajStrucneSpremeIzBaze();
        } catch (Exception ex) {
            Logger.getLogger(TableModelStrucnaSprema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return listaSs.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StrucnaSprema ss = listaSs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ss.getNaziv();
            case 1:
                return ss.getNivo();
            case 2:
                boolean sert = ss.isSertifikat();
                if (sert==true) {
                    return "DA";
                } else {
                   return "NE";
                }

            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    public StrucnaSprema getStrucnaSprema(int row) {
        return listaSs.get(row);
    }
     public void refresh()  {
        try {
            listaSs=Controller.getInstance().ucitajStrucneSpremeIzBaze();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelOtpremnica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
