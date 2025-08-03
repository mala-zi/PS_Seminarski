/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import controller.Controller;
import domain.Aranzman;
import domain.Otpremnica;
import javax.swing.table.AbstractTableModel;
import domain.StavkaOtpremnice;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saki
 */
public class TableModelStavkaOtpremnice extends AbstractTableModel {

    private ArrayList<StavkaOtpremnice> listaStavki;
    private int i = 1;
    private int rbrStavke = 0;
    private final String[] kolone = {"RB", "Kolicina", "Aranzman", "Cena Bez PDV",
        "Cena Sa PDV", "Iznos Bez PDV", "Iznos Sa PDV", "Napomena"};

    public TableModelStavkaOtpremnice() {
        listaStavki = new ArrayList<>();
    }

    public TableModelStavkaOtpremnice(Otpremnica otpremnica) {
        try {
            listaStavki = Controller.getInstance().ucitajStavkeOtpremniceIzBaze(otpremnica);
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkaOtpremnice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<StavkaOtpremnice> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(ArrayList<StavkaOtpremnice> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaOtpremnice st = listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i++;
            case 1:
                return st.getKolicina();
            case 2:
                return st.getAranzman().getNaziv();
            case 3:
                return st.getCenaBezPDV();
            case 4:
                return st.getCenaSaPdDV();
            case 5:
                return st.getIznosBezPDV();
            case 6:
                return st.getIznosSaPDV();
            case 7:
                return st.getNapomena();
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

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        StavkaOtpremnice st = listaStavki.get(rowIndex);

        if (columnIndex == 1) {
            st.setKolicina(Integer.parseInt((String) value));

        }
    }

    public boolean unetAranzman(Aranzman aranzman) {
        for (StavkaOtpremnice stavkaOtpremnice : listaStavki) {
            if (stavkaOtpremnice.getAranzman().getId() == aranzman.getId()) {
                return true;
            }
        }
        return false;
    }

    public void dodajStavkuOtpremnice(StavkaOtpremnice so) {
        rbrStavke = listaStavki.size();
        so.setRb(++rbrStavke);
        so.setIznosBezPDV(izracunajIznos(so.getKolicina(), so.getCenaBezPDV()));
        so.setIznosSaPDV(izracunajIznos(so.getKolicina(), so.getCenaSaPdDV()));
        listaStavki.add(so);
        fireTableDataChanged();
    }

    private double izracunajIznos(double kolicina, double cena) {
        return kolicina * cena;
    }

    public void obrisiStavkuOtpremnice(int selected) {
        rbrStavke = 0;
        listaStavki.remove(selected);
        for (StavkaOtpremnice stavkaOtpremnice : listaStavki) {
            stavkaOtpremnice.setRb(++rbrStavke);
        }
        fireTableDataChanged();
    }

    public double getUkupnaCenaSaPDV() {
        double ukupnaCenaSa = 0;
        for (StavkaOtpremnice stavkaOtpremnice : listaStavki) {
            ukupnaCenaSa += stavkaOtpremnice.getIznosSaPDV();
        }
        return ukupnaCenaSa;
    }

    public double getUkupnaCenaBezPDV() {
        double ukupnaCenaBez = 0;
        for (StavkaOtpremnice stavkaOtpremnice : listaStavki) {
            ukupnaCenaBez += stavkaOtpremnice.getIznosBezPDV();
        }
        return ukupnaCenaBez;
    }

    public double getUkupanPopust() {
        double ukupanPopust = 0;
        for (StavkaOtpremnice stavkaOtpremnice : listaStavki) {
             ukupanPopust += (stavkaOtpremnice.getKolicina()*(stavkaOtpremnice.getAranzman().getCenaSaPDV()-stavkaOtpremnice.getCenaSaPdDV()));
        }
        return  ukupanPopust;
    }
}
