/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import controller.Controller;
import javax.swing.table.AbstractTableModel;
import domain.Cvecar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class TableModelCvecar extends AbstractTableModel {
    private ArrayList<Cvecar> listaCvecara;
    private String[] kolone={"ID","Ime","Prezime","Korisničko ime"};

    public TableModelCvecar() {
        try {
            listaCvecara = Controller.getInstance().ucitajCvecareIzBaze();
        } catch (Exception ex) {
            Logger.getLogger(TableModelCvecar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return listaCvecara.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cvecar c=listaCvecara.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getId();
            case 1:
                return c.getIme();
            case 2:
                return c.getPrezime();
            case 3:
                return c.getKorisnickoIme();
            default:
                return null;
                        
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    public Cvecar getCvecar(int row) {
        return listaCvecara.get(row);
    }

    public void refresh() {
        try {
            listaCvecara = Controller.getInstance().ucitajCvecareIzBaze();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelCvecar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
