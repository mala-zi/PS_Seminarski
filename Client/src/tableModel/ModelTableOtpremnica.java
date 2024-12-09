/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domain.Otpremnica;
import domain.StavkaOtpremnice;

/**
 *
 * @author Saki
 */
public class ModelTableOtpremnica extends AbstractTableModel{

    private List<StavkaOtpremnice> listaStavki;
    private final String[] kolone={"RB","Kolicina","Aranzman","Cena Bez PDV",
        "Cena Sa PDV", "Iznos Bez PDV","Iznos Sa PDV","Napomena"};

    public ModelTableOtpremnica(List<StavkaOtpremnice> listaStavki) {
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
        StavkaOtpremnice st=listaStavki.get(rowIndex);
        switch(columnIndex){
            case 0:
                return st.getRb();
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
        return kolone[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
