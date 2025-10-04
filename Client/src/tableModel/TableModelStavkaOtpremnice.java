/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import domain.Aranzman;
import domain.Otpremnica;
import javax.swing.table.AbstractTableModel;
import domain.StavkaOtpremnice;
import java.util.ArrayList;
import view.KreirajOtpremnicuForma;

/**
 *
 * @author Saki
 */
public class TableModelStavkaOtpremnice extends AbstractTableModel {

    private ArrayList<StavkaOtpremnice> listaStavki;
    private KreirajOtpremnicuForma kof;
    private int rbrStavke = 0;
    private final String[] kolone = {"RB", "Količina", "Aranžman", "Cena bez PDV-a",
        "Cena sa PDV-om", "Iznos bez PDV-a", "Iznos Ss PDV-om", "Napomena"};

    public TableModelStavkaOtpremnice() {
        listaStavki = new ArrayList<>();
    }

    public TableModelStavkaOtpremnice(Otpremnica otpremnica) {
        /*try {
            listaStavki = Controller.getInstance().ucitajStavkeOtpremniceIzBaze(otpremnica);
           
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkaOtpremnice.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        if (otpremnica.getStavkeOtpremnice() != null) {
            listaStavki = otpremnica.getStavkeOtpremnice();
        } else {
            listaStavki = new ArrayList<>();
        }
    }

    public KreirajOtpremnicuForma getKof() {
        return kof;
    }

    public void setKof(KreirajOtpremnicuForma kof) {
        this.kof = kof;
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
                return rowIndex + 1;
            case 1:
                return st.getKolicina();
            case 2:
                return st.getAranzman().getNaziv();
            case 3:
                return st.getCenaBezPDV();
            case 4:
                return st.getCenaSaPDV();
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
            st.setCenaBezPDV(Math.floor(st.getAranzman().getCenaBezPDV() * (1 - st.getAranzman().getPopust() / 100) * 100.0) / 100.0);
            st.setCenaSaPDV(Math.floor((st.getAranzman().getCenaBezPDV() * (1 - st.getAranzman().getPopust() / 100)) * (1 + st.getAranzman().getPoreskaStopa().getVrednost() / 100) * 100.0) / 100.0);
            st.setIznosBezPDV(izracunajIznos(st.getKolicina(), st.getCenaBezPDV()));
            st.setIznosSaPDV(izracunajIznos(st.getKolicina(), st.getCenaSaPDV()));
            kof.setUkupnaSa(getUkupnaCenaSaPDV());
            kof.setUkupnaBez(getUkupnaCenaBezPDV());
            kof.setUkupanPopust(getUkupanPopust());
            kof.getTxtUkupanPopust().setText(getUkupanPopust() + "");
            kof.getTxtUkupnoBez().setText(getUkupnaCenaBezPDV() + "");
            kof.getTxtUkupnoSaPDV().setText(getUkupnaCenaSaPDV() + "");
            fireTableRowsUpdated(rowIndex, rowIndex);
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
        so.setIznosSaPDV(izracunajIznos(so.getKolicina(), so.getCenaSaPDV()));
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
        return Math.round(ukupnaCenaSa * 100.0) / 100.0;
    }

    public double getUkupnaCenaBezPDV() {
        double ukupnaCenaBez = 0;
        for (StavkaOtpremnice stavkaOtpremnice : listaStavki) {
            ukupnaCenaBez += stavkaOtpremnice.getIznosBezPDV();
        }
        return Math.round(ukupnaCenaBez * 100.0) / 100.0;
    }

    public double getUkupanPopust() {
        double ukupanPopust = 0;
        for (StavkaOtpremnice stavkaOtpremnice : listaStavki) {
            ukupanPopust += (stavkaOtpremnice.getKolicina() * (stavkaOtpremnice.getAranzman().getCenaSaPDV() - stavkaOtpremnice.getCenaSaPDV()));
        }
        return Math.round(ukupanPopust * 100.0) / 100.0;
    }
}
