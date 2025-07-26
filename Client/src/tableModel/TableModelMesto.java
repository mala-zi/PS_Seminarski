/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import javax.swing.table.AbstractTableModel;
import domain.Mesto;
import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class TableModelMesto  extends AbstractTableModel{
    private ArrayList<Mesto> listaMesta;
    private String[] kolone={"Grad","Postanski Broj","Ulica"};

    public TableModelMesto(ArrayList<Mesto> listaKupaca) {
        this.listaMesta = listaKupaca;
    }

    
    @Override
    public int getRowCount() {
        return listaMesta.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mesto m=listaMesta.get(rowIndex);
        switch(columnIndex){
            case 0:
                return m.getGrad();
            case 1:
                return m.getPostanskiBroj();
            case 2:
                return m.getUlica();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
