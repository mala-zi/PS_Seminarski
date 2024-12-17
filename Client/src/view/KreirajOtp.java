/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import tableModel.ModelTableOtpremnica;
import controller.Controller;
import domain.Aranzman;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import domain.Cvecar;
import domain.Kupac;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import validator.Validator;

/**
 *
 * @author Saki
 */
public class KreirajOtp extends javax.swing.JDialog {

    private GlavnaForma mf;
    private Otpremnica otpremnica;
    private List<StavkaOtpremnice> listaStavki=new ArrayList<>();
    private double ukupnaSa=0;
    private double ukupnaBez=0;
    private double ukupanPopust=0;

    /**
     * Creates new form KreirajOtp
     */
    public KreirajOtp(java.awt.Frame parent, boolean modal) throws Exception {

        super(parent, modal);
        this.mf = (GlavnaForma) parent;
        initComponents();
        setTitle("Kreiraj otpremnicu");
        setResizable(false);
        setLocationRelativeTo(null);
        popuniCvecareIzBaze();
        popuniKupceIzBaze();
        popuniAranzmaneIzBaze();
        tableStavke.setModel(new ModelTableOtpremnica(listaStavki));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDatumIzdavanja = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxCvecar = new javax.swing.JComboBox<>();
        comboBoxKupac = new javax.swing.JComboBox<>();
        btnOdustani = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStavke = new javax.swing.JTable();
        btnDodajStavku = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUkupnoBez = new javax.swing.JTextField();
        txtUkupnoSaPDV = new javax.swing.JTextField();
        txtUkupanPopust = new javax.swing.JTextField();
        comboAranzmani = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtCenaBezPDVPopust = new javax.swing.JTextField();
        txtCenaSaPDVPopust = new javax.swing.JTextField();
        txtKolicina = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNapomena = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        btnUkloniStavku = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPopust = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCenaBezPDVBezPopusta = new javax.swing.JTextField();
        txtCenaSaPDVBezPopusta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum izdavanja:");

        jLabel3.setText("Cvecar");

        jLabel4.setText("Kupac");

        comboBoxCvecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCvecarActionPerformed(evt);
            }
        });

        btnOdustani.setText("odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnKreiraj.setText("kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        tableStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableStavke);

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        jLabel5.setText("Ukupan iznos bez PDV-a");

        jLabel6.setText("Ukupan iznos sa PDV-om");

        jLabel7.setText("Ukupan popust");

        comboAranzmani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAranzmaniActionPerformed(evt);
            }
        });

        jLabel8.setText("Aranzman");

        jLabel9.setText("Cena bez PDV-a");

        jLabel10.setText("Cena sa PDV-om");

        jLabel11.setText("Kolicina");

        jLabel12.setText("Napomena");

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        jScrollPane2.setViewportView(txtNapomena);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Stavke otpremnice");

        btnUkloniStavku.setText("Ukloni stavku");
        btnUkloniStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniStavkuActionPerformed(evt);
            }
        });

        jLabel2.setText("Popust aranzmana");

        jLabel14.setText("Cena bez PDV-a");

        jLabel15.setText("Cena sa PDV-om");

        jLabel16.setText("sa popustom");

        jLabel17.setText("sa popustom");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUkupnoBez, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(243, 243, 243)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUkupnoSaPDV, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUkupanPopust, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboAranzmani, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel16)
                                        .addGap(8, 8, 8))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCenaBezPDVPopust, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCenaBezPDVBezPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCenaSaPDVBezPopusta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCenaSaPDVPopust, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(20, 20, 20)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel12)
                                .addGap(125, 125, 125)
                                .addComponent(btnDodajStavku))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUkloniStavku)))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumIzdavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel1)))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxCvecar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addComponent(btnOdustani)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(comboBoxCvecar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboBoxKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDatumIzdavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel8)
                                                .addGap(8, 8, 8))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel15))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtCenaBezPDVBezPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboAranzmani, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCenaSaPDVBezPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel16)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtCenaBezPDVPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtCenaSaPDVPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnUkloniStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)))
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtUkupanPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtUkupnoSaPDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtUkupnoBez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        
        try {
            otpremnica.setUkupanPopust(ukupanPopust);
            otpremnica.setUkupanIznosSaPDV(ukupnaSa);
            otpremnica.setUkupanIznosBezPDv(ukupnaBez);
            
            Otpremnica o=Controller.getInstance().dodajOtpremnicu(otpremnica);
            for (StavkaOtpremnice so : listaStavki) {
                so.setOtpremnica(o);
                Controller.getInstance().dodajStavkuOtpremnice(so);
            }
            
            JOptionPane.showMessageDialog(this, "Otpremnica je dodata", "obavestenje", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(KreirajOtp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        // TODO add your handling code here:
        Date datumIzdavanja = new Date();
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (txtDatumIzdavanja.getText().isEmpty() || txtCenaBezPDVPopust.getText().isEmpty() || txtCenaSaPDVPopust.getText().isEmpty() || txtKolicina.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nisu sva polja popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!Validator.isValidDate(txtDatumIzdavanja.getText())) {
                throw new ParseException("", ERROR);
            }datumIzdavanja = dateFormat.parse(txtDatumIzdavanja.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Pogresan format datuma!\nDatum treba da bude u formatu YYYY-MM-DD", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Cvecar c = (Cvecar) comboBoxCvecar.getSelectedItem();
        Kupac k = (Kupac) comboBoxKupac.getSelectedItem();
        Aranzman a = (Aranzman) comboAranzmani.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        if (!Validator.isValidNumber(txtCenaBezPDVPopust.getText()) || !Validator.isValidNumber(txtCenaSaPDVPopust.getText())) {
            JOptionPane.showMessageDialog(this, "Pogresan format cene!", "Greska", JOptionPane.ERROR_MESSAGE);

        }
        double cenaBez=Double.parseDouble(txtCenaBezPDVPopust.getText());
        double cenaSa = Double.parseDouble(txtCenaSaPDVPopust.getText());
        String napomena = txtNapomena.getText();
        double iznosBez = kolicina * cenaBez;
        double iznosSa = kolicina * cenaSa;
        Otpremnica o = new Otpremnica();
        o.setDatumIzdavanja(datumIzdavanja);
        o.setCvecar(c);
        o.setKupac(k);
        otpremnica=o;
        StavkaOtpremnice s1 = new StavkaOtpremnice(kolicina, napomena, iznosBez, iznosSa, cenaBez, cenaSa, a);
        if(listaStavki.contains(s1)){
            JOptionPane.showMessageDialog(this, "Stavka je vec dodata u otpremnicu!","Obavestenje",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        listaStavki.add(s1);
        resetPodataka();
        tableStavke.setModel(new ModelTableOtpremnica(listaStavki));

        ukupnaSa = ukupnaSa + s1.getIznosSaPDV();
        ukupnaBez = ukupnaBez + s1.getIznosBezPDV();
        ukupanPopust = ukupanPopust + (s1.getKolicina() * a.getCenaBezPDV()) - s1.getIznosBezPDV();

        txtUkupnoSaPDV.setText(ukupnaSa + "");
        txtUkupnoBez.setText(ukupnaBez + "");
        txtUkupanPopust.setText(ukupanPopust + "");
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void comboAranzmaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAranzmaniActionPerformed
        // TODO add your handling code here:
        Aranzman a=(Aranzman) comboAranzmani.getSelectedItem();
        double cenaBez=a.getCenaBezPDV()*(1-a.getPopust()/100);
        double cenaSa=(a.getCenaBezPDV()*(1-a.getPopust()/100))*(1+(a.getPoreskaStopa().getVrednost())/100);
        txtCenaBezPDVPopust.setText(cenaBez+"");
        txtCenaBezPDVBezPopusta.setText(a.getCenaBezPDV()+"");
        txtCenaSaPDVBezPopusta.setText(a.getCenaSaPDV()+"");
        txtPopust.setText(a.getPopust()+"");
        txtCenaSaPDVPopust.setText(cenaSa+"");
        
    }//GEN-LAST:event_comboAranzmaniActionPerformed

    private void btnUkloniStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniStavkuActionPerformed
        // TODO add your handling code here:
        int selected=tableStavke.getSelectedRow();
        if(selected==-1){
            JOptionPane.showMessageDialog(this, "Nista nije selektovano iz tabele","Greska",JOptionPane.ERROR_MESSAGE);
            return;
        }
        StavkaOtpremnice so=listaStavki.get(selected);
        listaStavki.remove(so);
         tableStavke.setModel(new ModelTableOtpremnica(listaStavki));
        
    }//GEN-LAST:event_btnUkloniStavkuActionPerformed

    private void comboBoxCvecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCvecarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCvecarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDodajStavku;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnUkloniStavku;
    private javax.swing.JComboBox<Aranzman> comboAranzmani;
    private javax.swing.JComboBox<Cvecar> comboBoxCvecar;
    private javax.swing.JComboBox<Kupac> comboBoxKupac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableStavke;
    private javax.swing.JTextField txtCenaBezPDVBezPopusta;
    private javax.swing.JTextField txtCenaBezPDVPopust;
    private javax.swing.JTextField txtCenaSaPDVBezPopusta;
    private javax.swing.JTextField txtCenaSaPDVPopust;
    private javax.swing.JTextField txtDatumIzdavanja;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextArea txtNapomena;
    private javax.swing.JTextField txtPopust;
    private javax.swing.JTextField txtUkupanPopust;
    private javax.swing.JTextField txtUkupnoBez;
    private javax.swing.JTextField txtUkupnoSaPDV;
    // End of variables declaration//GEN-END:variables

    private void popuniCvecareIzBaze() throws Exception {
        txtCenaBezPDVPopust.setEnabled(false);
        txtCenaSaPDVPopust.setEnabled(false);
        txtPopust.setEnabled(false);
        txtCenaBezPDVBezPopusta.setEnabled(false);
        txtCenaSaPDVBezPopusta.setEnabled(false);
        txtUkupnoBez.setEnabled(false);
        txtUkupnoSaPDV.setEnabled(false);
        txtUkupanPopust.setEnabled(false);
        comboBoxKupac.removeAllItems();
        List<Cvecar> cvecari=Controller.getInstance().ucitajCvecareIzBaze();
        for(Cvecar c: cvecari){
            comboBoxCvecar.addItem(c);
        }
    }

    private void popuniKupceIzBaze() throws Exception {
        comboBoxKupac.removeAllItems();
        List<Kupac> kupci=Controller.getInstance().popuniKupceIzBaze();
        for(Kupac k: kupci){
            comboBoxKupac.addItem(k);
        }
    }

    private void popuniAranzmaneIzBaze() throws Exception {
        comboAranzmani.removeAllItems();
        List<Aranzman> aranzmani = Controller.getInstance().popuniAranzmaneIzBaze();
        for (Aranzman a : aranzmani) {
            comboAranzmani.addItem(a);
        }
    }

    private void resetPodataka() {
        txtDatumIzdavanja.setEnabled(false);
        comboBoxCvecar.setEnabled(false);
        comboBoxKupac.setEnabled(false);
        txtCenaBezPDVPopust.setText("");
        txtCenaSaPDVPopust.setText("");
        txtPopust.setText("");
        txtCenaBezPDVBezPopusta.setText("");
        txtCenaSaPDVBezPopusta.setText("");
        txtKolicina.setText("");
        txtNapomena.setText("");
    }
}
