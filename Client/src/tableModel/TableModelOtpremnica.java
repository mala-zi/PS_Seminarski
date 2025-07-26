/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import domain.Otpremnica;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class TableModelOtpremnica extends AbstractTableModel {

    private ArrayList<Otpremnica> lista;
    private int i = 1;
    private final String[] kolone = {"ID", "Datum izdavanja", "Iznos Sa PDV-om", "Iznos Bez PDV-a", "Cvecar", "Kupac"};

    public TableModelOtpremnica(ArrayList<Otpremnica> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Otpremnica o = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i++;
            case 1:
                return o.getDatumIzdavanja();
            case 2:
                return o.getUkupanIznosSaPDV();
            case 3:
                return o.getUkupanIznosBezPDv();
            case 4:
                return o.getCvecar().getIme() + " " + o.getCvecar().getPrezime();
            case 5:
                return o.getKupac().getNaziv();

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

    public Otpremnica getOtpremnica(int row) {
        return lista.get(row);
    }
}
