/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import controller.Controller;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class TableModelOtpremnica extends AbstractTableModel {

    private ArrayList<Otpremnica> lista;
    private ArrayList<StavkaOtpremnice> listaStavki = new ArrayList<>();
    private final String[] kolone = {"ID", "Datum izdavanja", "Iznos bez PDV-a(RSD)", "Iznos sa PDV-om(RSD)", "Ukupan popust(RSD)", "Cvećar", "Kupac"};

    public TableModelOtpremnica() {
        try {
            lista = Controller.getInstance().ucitajOtpremniceIzBaze();
            //prodji kroz stavke otp o:lista
            for (Otpremnica o : lista) {
                if (o.getStavkeOtpremnice() != null) {
                    for (StavkaOtpremnice so : o.getStavkeOtpremnice()) {
                        listaStavki.add(so);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TableModelOtpremnica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
                return o.getId();
            case 1:
                return o.getDatumIzdavanja();
            case 2:
                return o.getUkupanIznosBezPDv();
            case 3:
                return o.getUkupanIznosSaPDV();
            case 4:
                return o.getUkupanPopust();
            case 5:
                return o.getCvecar().getIme() + " " + o.getCvecar().getPrezime();
            case 6:
                if (o.getKupac().getNaziv().isEmpty()) {
                    return o.getKupac().getIme() + " " + o.getKupac().getPrezime();
                } else {
                    return o.getKupac().getNaziv();
                }
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Otpremnica getOtpremnica(int row) {
        return lista.get(row);
    }

    public void refresh() {
        try {
            lista = Controller.getInstance().ucitajOtpremniceIzBaze();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelOtpremnica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
