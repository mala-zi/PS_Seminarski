/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import javax.swing.table.AbstractTableModel;
import domain.Cvecar;
import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class TableModelCvecar extends AbstractTableModel {
    private ArrayList<Cvecar> listaCvecara;
    private String[] kolone={"Ime","Prezime"};

    public TableModelCvecar(ArrayList<Cvecar> listaCvecara) {
        this.listaCvecara = listaCvecara;
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
                return c.getIme();
            case 1:
                return c.getPrezime();
            default:
                return null;
                        
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
