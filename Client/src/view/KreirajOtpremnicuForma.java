/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.Controller;
import domain.Aranzman;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import domain.Cvecar;
import domain.Kupac;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import domain.TipKupca;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import tableModel.TableModelOtpremnica;
import tableModel.TableModelStavkaOtpremnice;
import validator.Validator;

/**
 *
 * @author Saki
 */
public class KreirajOtpremnicuForma extends javax.swing.JFrame {

    private UpravljajOtpremnicamaForma uof;
    private Otpremnica otpremnicaCreate;
    private Otpremnica otpremnicaChange;
    private double ukupnaSa = 0;
    private double ukupnaBez = 0;
    private double ukupanPopust = 0;

    public double getUkupnaSa() {
        return ukupnaSa;
    }

    public void setUkupnaSa(double ukupnaSa) {
        this.ukupnaSa = ukupnaSa;
    }

    public double getUkupnaBez() {
        return ukupnaBez;
    }

    public void setUkupnaBez(double ukupnaBez) {
        this.ukupnaBez = ukupnaBez;
    }

    public double getUkupanPopust() {
        return ukupanPopust;
    }

    public void setUkupanPopust(double ukupanPopust) {
        this.ukupanPopust = ukupanPopust;
    }

    public JTextField getTxtUkupanPopust() {
        return txtUkupanPopust;
    }

    public void setTxtUkupanPopust(JTextField txtUkupanPopust) {
        this.txtUkupanPopust = txtUkupanPopust;
    }

    public JTextField getTxtUkupnoBez() {
        return txtUkupnoBez;
    }

    public void setTxtUkupnoBez(JTextField txtUkupnoBez) {
        this.txtUkupnoBez = txtUkupnoBez;
    }

    public JTextField getTxtUkupnoSaPDV() {
        return txtUkupnoSaPDV;
    }

    public void setTxtUkupnoSaPDV(JTextField txtUkupnoSaPDV) {
        this.txtUkupnoSaPDV = txtUkupnoSaPDV;
    }

    /**
     * Creates new form KreirajOtp
     */
    public KreirajOtpremnicuForma() throws Exception {
        try {
            initComponents();
            radioPravno.addActionListener(e -> {
                try {
                    popuniKupceIzBaze();
                } catch (Exception ex) {
                    Logger.getLogger(KreirajOtpremnicuForma.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            radioFizicko.addActionListener(e -> {
                try {
                    popuniKupceIzBaze();
                } catch (Exception ex) {
                    Logger.getLogger(KreirajOtpremnicuForma.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            this.otpremnicaChange = null;
            setTitle("Kreiraj otpremnicu");
            setResizable(false);
            setLocationRelativeTo(null);
            popuniCvecareIzBaze();
            popuniKupceIzBaze();
            popuniAranzmaneIzBaze();
            btnSendEmail.setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            TableModelStavkaOtpremnice tmodel = new TableModelStavkaOtpremnice();
            tmodel.setKof(this);
            tableStavke.setModel(tmodel);
            Cvecar c = (Cvecar) comboBoxCvecar.getSelectedItem();
            Kupac k = (Kupac) comboBoxKupac.getSelectedItem();
            otpremnicaCreate = new Otpremnica(-1, 0, 0, 0, new Date(), c, k, new ArrayList<StavkaOtpremnice>());
            Controller.getInstance().kreirajOtpremnicu(otpremnicaCreate);
            JOptionPane.showMessageDialog(this, "Sistem je kreirao otpremnicu", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(KreirajOtpremnicuForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public KreirajOtpremnicuForma(UpravljajOtpremnicamaForma parent, Otpremnica otpremnica) throws Exception {

        this.uof = (UpravljajOtpremnicamaForma) parent;
        this.otpremnicaChange = otpremnica;
        initComponents();
        radioPravno.addActionListener(e -> {
            try {
                popuniKupceIzBaze();
            } catch (Exception ex) {
                Logger.getLogger(KreirajOtpremnicuForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        radioFizicko.addActionListener(e -> {
            try {
                popuniKupceIzBaze();
            } catch (Exception ex) {
                Logger.getLogger(KreirajOtpremnicuForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        setTitle("Promeni otpremnicu");
        setResizable(false);
        btnSendEmail.setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popuniCvecareIzBaze();
        popuniKupceIzBaze();
        popuniAranzmaneIzBaze();
        popuniPromena(otpremnica);
        TableModelStavkaOtpremnice tmodel = new TableModelStavkaOtpremnice(otpremnica);
        tmodel.setKof(this);
        tableStavke.setModel(tmodel);
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
        btnSave = new javax.swing.JButton();
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
        jLabel18 = new javax.swing.JLabel();
        btnSendEmail = new javax.swing.JButton();
        radioPravno = new javax.swing.JRadioButton();
        radioFizicko = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Datum izdavanja:");

        txtDatumIzdavanja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Cvećar");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Kupac");

        comboBoxCvecar.setBackground(new java.awt.Color(153, 255, 204));
        comboBoxCvecar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxCvecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCvecarActionPerformed(evt);
            }
        });

        comboBoxKupac.setBackground(new java.awt.Color(153, 255, 204));
        comboBoxKupac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnOdustani.setBackground(new java.awt.Color(153, 255, 204));
        btnOdustani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOdustani.setText("Otkaži");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(153, 255, 204));
        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Sačuvaj");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tableStavke.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        btnDodajStavku.setBackground(new java.awt.Color(153, 255, 204));
        btnDodajStavku.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ukupan iznos bez PDV-a (RSD)");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ukupan iznos sa PDV-om (RSD)");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ukupan popust (RSD)");

        txtUkupnoBez.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUkupnoBez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUkupnoBezActionPerformed(evt);
            }
        });

        txtUkupnoSaPDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUkupnoSaPDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUkupnoSaPDVActionPerformed(evt);
            }
        });

        txtUkupanPopust.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        comboAranzmani.setBackground(new java.awt.Color(153, 255, 204));
        comboAranzmani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboAranzmani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAranzmaniActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Aranžman");

        txtCenaBezPDVPopust.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCenaSaPDVPopust.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtKolicina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtKolicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKolicinaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Cena bez PDV-a");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Cena sa PDV-om");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Količina");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Napomena");

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        jScrollPane2.setViewportView(txtNapomena);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setText("Stavke otpremnice");

        btnUkloniStavku.setBackground(new java.awt.Color(153, 255, 204));
        btnUkloniStavku.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUkloniStavku.setText("Ukloni stavku");
        btnUkloniStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniStavkuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Popust aranžmana (%)");

        txtPopust.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPopust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPopustActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Cena bez PDV-a (RSD)");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Cena sa PDV-om (RSD)");

        txtCenaBezPDVBezPopusta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCenaSaPDVBezPopusta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("sa popustom (RSD)");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("sa popustom (RSD)");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel18.setText("Otpremnica");

        btnSendEmail.setBackground(new java.awt.Color(153, 255, 204));
        btnSendEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSendEmail.setText("Pošalji PDF");
        btnSendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendEmailActionPerformed(evt);
            }
        });

        radioPravno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioPravno.setText("Pravno lice");

        radioFizicko.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioFizicko.setText("Fizičko lice");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUkupnoBez))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUkupnoSaPDV, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(txtUkupanPopust, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel7)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtPopust))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel2))
                                        .addComponent(comboAranzmani, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(43, 43, 43))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtCenaBezPDVPopust)
                                                    .addComponent(txtCenaBezPDVBezPopusta))
                                                .addGap(26, 26, 26)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtCenaSaPDVPopust, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(txtCenaSaPDVBezPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(22, 22, 22)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel17))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel15)))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUkloniStavku)
                                    .addComponent(btnDodajStavku)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(247, 247, 247)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(radioPravno, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radioFizicko, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(txtDatumIzdavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboBoxCvecar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(comboBoxKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(jLabel1)
                                        .addGap(179, 179, 179)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(109, 109, 109))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumIzdavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBoxKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxCvecar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPravno)
                    .addComponent(radioFizicko))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnUkloniStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCenaBezPDVBezPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboAranzmani, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCenaSaPDVBezPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCenaBezPDVPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCenaSaPDVPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUkupnoBez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUkupnoSaPDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUkupanPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        // TODO add your handling code here:
        if (otpremnicaCreate != null && otpremnicaChange == null) {
            try {
                Controller.getInstance().obrisiOtpremnicu(otpremnicaCreate);
            } catch (Exception ex) {
                Logger.getLogger(KreirajOtpremnicuForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        Date datumIzdavanja = new Date();
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (txtDatumIzdavanja.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Datum nije popunjen!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!Validator.isValidDate(txtDatumIzdavanja.getText())) {
                JOptionPane.showMessageDialog(this, "Uneti datum nije validan! Proveriti da li je format datuma YYYY-MM-DD", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            datumIzdavanja = dateFormat.parse(txtDatumIzdavanja.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Pogrešan format datuma!\nDatum treba da bude u formatu YYYY-MM-DD", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Cvecar c = (Cvecar) comboBoxCvecar.getSelectedItem();
        Kupac k = (Kupac) comboBoxKupac.getSelectedItem();
        if (otpremnicaChange == null && otpremnicaCreate != null) {
            try {
                //throw new RuntimeException("Simulacija greške");
                TableModelStavkaOtpremnice tmodel = (TableModelStavkaOtpremnice) tableStavke.getModel();
                tmodel.setKof(this);
                ArrayList<StavkaOtpremnice> stavke = tmodel.getListaStavki();
                otpremnicaCreate.setUkupanPopust(ukupanPopust);
                otpremnicaCreate.setUkupanIznosBezPDv(ukupnaBez);
                otpremnicaCreate.setUkupanIznosSaPDV(ukupnaSa);
                otpremnicaCreate.setDatumIzdavanja(datumIzdavanja);
                otpremnicaCreate.setCvecar(c);
                otpremnicaCreate.setKupac(k);
                otpremnicaCreate.setStavkeOtpremnice(stavke);
                Controller.getInstance().promeniOtpremnicu(otpremnicaCreate);
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio otpremnicu", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem nije uspeo da zapamti otpremnicu!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            try {
                //throw new RuntimeException("Simulacija greške");
                TableModelStavkaOtpremnice tmodel = (TableModelStavkaOtpremnice) tableStavke.getModel();
                tmodel.setKof(this);
                ArrayList<StavkaOtpremnice> stavke = tmodel.getListaStavki();
                otpremnicaChange.setCvecar(c);
                otpremnicaChange.setDatumIzdavanja(datumIzdavanja);
                otpremnicaChange.setKupac(k);
                otpremnicaChange.setUkupanIznosBezPDv(ukupnaBez);
                otpremnicaChange.setUkupanIznosSaPDV(ukupnaSa);
                otpremnicaChange.setUkupanPopust(ukupanPopust);
                otpremnicaChange.setStavkeOtpremnice(stavke);
                Controller.getInstance().promeniOtpremnicu(otpremnicaChange);
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio otpremnicu", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                uof.getTblOtp().setModel(new TableModelOtpremnica());
                TableColumn idColumn = uof.getTblOtp().getColumnModel().getColumn(0);
                idColumn.setPreferredWidth(30);
                idColumn.setMinWidth(20);
                idColumn.setMaxWidth(40);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem nije uspeo da zapamti otpremnicu!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        // TODO add your handling code here:
        if (txtKolicina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nisu sva polja popunjena za aranžman!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Aranzman a = (Aranzman) comboAranzmani.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        if (kolicina <= 0) {
            JOptionPane.showMessageDialog(this, "Količina mora biti veća od 0!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Validator.isValidNumber(txtCenaBezPDVPopust.getText()) || !Validator.isValidNumber(txtCenaSaPDVPopust.getText())) {
            JOptionPane.showMessageDialog(this, "Pogrešan format cene!", "Greška", JOptionPane.ERROR_MESSAGE);

        }
        double cenaBez = Math.floor(Double.parseDouble(txtCenaBezPDVPopust.getText()) * 100.0) / 100.0;
        double cenaSa = Math.floor(Double.parseDouble(txtCenaSaPDVPopust.getText()) * 100.0) / 100.0;
        String napomena = txtNapomena.getText();
        TableModelStavkaOtpremnice tmodel = (TableModelStavkaOtpremnice) tableStavke.getModel();
        StavkaOtpremnice s1;
        if (otpremnicaChange == null) {
            s1 = new StavkaOtpremnice(-1, kolicina, napomena, 0, 0, cenaBez, cenaSa, a, otpremnicaCreate);
        } else {
            s1 = new StavkaOtpremnice(-1, kolicina, napomena, 0, 0, cenaBez, cenaSa, a, otpremnicaChange);
        }
        if (tmodel.unetAranzman(a)) {
            JOptionPane.showMessageDialog(this, "Aranžman je već dodat u otpremnicu!", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        tmodel.dodajStavkuOtpremnice(s1);
        tableStavke.setModel(tmodel);
        resetPodataka();
        ukupnaSa = tmodel.getUkupnaCenaSaPDV();
        ukupnaBez = tmodel.getUkupnaCenaBezPDV();
        ukupanPopust = tmodel.getUkupanPopust();

        txtUkupnoBez.setText(ukupnaBez + "");
        txtUkupnoSaPDV.setText(ukupnaSa + "");
        txtUkupanPopust.setText(ukupanPopust + "");
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void comboAranzmaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAranzmaniActionPerformed
        // TODO add your handling code here:
        Aranzman a = (Aranzman) comboAranzmani.getSelectedItem();
        double cenaBez = Math.floor(a.getCenaBezPDV() * (1 - a.getPopust() / 100) * 100.0) / 100.0;
        double cenaSa = Math.floor((a.getCenaBezPDV() * (1 - a.getPopust() / 100)) * (1 + (a.getPoreskaStopa().getVrednost()) / 100) * 100) / 100.0;
        txtCenaBezPDVPopust.setText(cenaBez + "");
        txtCenaBezPDVBezPopusta.setText(a.getCenaBezPDV() + "");
        txtCenaSaPDVBezPopusta.setText(a.getCenaSaPDV() + "");
        txtCenaSaPDVPopust.setText(cenaSa + "");
        txtPopust.setText(a.getPopust() + "");
    }//GEN-LAST:event_comboAranzmaniActionPerformed

    private void btnUkloniStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniStavkuActionPerformed
        // TODO add your handling code here:
        int selected = tableStavke.getSelectedRow();
        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "Ništa nije označeno iz tabele", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        TableModelStavkaOtpremnice tmodel = (TableModelStavkaOtpremnice) tableStavke.getModel();
        tmodel.obrisiStavkuOtpremnice(selected);
        tableStavke.setModel(tmodel);
        ukupnaSa = tmodel.getUkupnaCenaSaPDV();
        ukupnaBez = tmodel.getUkupnaCenaBezPDV();
        ukupanPopust = tmodel.getUkupanPopust();
        txtUkupnoBez.setText(tmodel.getUkupnaCenaBezPDV() + "");
        txtUkupnoSaPDV.setText(tmodel.getUkupnaCenaSaPDV() + "");
        txtUkupanPopust.setText(tmodel.getUkupanPopust() + "");

    }//GEN-LAST:event_btnUkloniStavkuActionPerformed

    private void comboBoxCvecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCvecarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCvecarActionPerformed

    private void txtUkupnoBezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUkupnoBezActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUkupnoBezActionPerformed

    private void txtUkupnoSaPDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUkupnoSaPDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUkupnoSaPDVActionPerformed

    private void txtPopustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPopustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPopustActionPerformed

    private void txtKolicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKolicinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKolicinaActionPerformed

    private void btnSendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendEmailActionPerformed
        try {
            // TODO add your handling code here:
            Otpremnica proveraPolja = new Otpremnica();
            Date datumIzdavanja = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            datumIzdavanja = dateFormat.parse(txtDatumIzdavanja.getText());
            Cvecar c = (Cvecar) comboBoxCvecar.getSelectedItem();
            Kupac k = (Kupac) comboBoxKupac.getSelectedItem();
            TableModelStavkaOtpremnice tmodel = (TableModelStavkaOtpremnice) tableStavke.getModel();
            tmodel.setKof(this);
            ArrayList<StavkaOtpremnice> stavke = tmodel.getListaStavki();
            proveraPolja.setId(otpremnicaChange.getId());
            proveraPolja.setCvecar(c);
            proveraPolja.setDatumIzdavanja(datumIzdavanja);
            proveraPolja.setKupac(k);
            proveraPolja.setUkupanIznosBezPDv(ukupnaBez);
            proveraPolja.setUkupanIznosSaPDV(ukupnaSa);
            proveraPolja.setUkupanPopust(ukupanPopust);
            proveraPolja.setStavkeOtpremnice(stavke);
            if (!otpremnicaChange.equals(proveraPolja)) {
                JOptionPane.showMessageDialog(this, "Imate nesačuvane izmene! Sačuvajte otpremnicu i pokušajte ponovo.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                int odgovor = JOptionPane.showConfirmDialog(this,
                        "Da li ste sigurni da želite da se pošaljete PDF otpremnice na " + k.getEmail() + "?",
                        "Potvrda",
                        JOptionPane.YES_NO_OPTION);

                if (odgovor == JOptionPane.NO_OPTION) {
                    return;
                } else if (odgovor == JOptionPane.YES_OPTION) {
                    // System.out.println("otp1:" + otpremnicaChange.toString());
                    System.out.println("len1:" + otpremnicaChange.getStavkeOtpremnice().size());

                    Controller.getInstance().posaljiOtpremnicuNaMejl(otpremnicaChange);
                    JOptionPane.showMessageDialog(this, "Otpremnica je poslata na mejl!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Greška pri slanju mejla: " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ParseException ex) {
            Logger.getLogger(KreirajOtpremnicuForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDodajStavku;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSendEmail;
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
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JRadioButton radioFizicko;
    private javax.swing.JRadioButton radioPravno;
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
        txtCenaBezPDVBezPopusta.setEnabled(false);
        txtCenaSaPDVBezPopusta.setEnabled(false);
        txtUkupanPopust.setEnabled(false);
        txtUkupnoBez.setEnabled(false);
        txtUkupnoSaPDV.setEnabled(false);
        txtPopust.setEnabled(false);
        comboBoxKupac.removeAllItems();
        ArrayList<Cvecar> cvecari = Controller.getInstance().ucitajCvecareIzBaze();
        for (Cvecar c : cvecari) {
            comboBoxCvecar.addItem(c);
        }
    }

    private void popuniKupceIzBaze() throws Exception {
        ButtonGroup group = new ButtonGroup();
        group.add(radioPravno);
        group.add(radioFizicko);
        comboBoxKupac.removeAllItems();
        ArrayList<Kupac> kupci = Controller.getInstance().ucitajKupceIzBaze();
        for (Kupac k : kupci) {
            if (radioPravno.isSelected() && k.getTip() == TipKupca.PRAVNO_LICE) {
                comboBoxKupac.addItem(k);
            } else if (radioFizicko.isSelected() && k.getTip() == TipKupca.FIZICKO_LICE) {
                comboBoxKupac.addItem(k);
            } else if (!radioPravno.isSelected() && !radioFizicko.isSelected()) {
                comboBoxKupac.addItem(k);
            }
        }
    }

    private void popuniAranzmaneIzBaze() throws Exception {
        comboAranzmani.removeAllItems();
        ArrayList<Aranzman> aranzmani = Controller.getInstance().ucitajAranzmaneIzBaze();
        for (Aranzman a : aranzmani) {
            comboAranzmani.addItem(a);
        }
    }

    private void resetPodataka() {
        txtCenaBezPDVPopust.setText("");
        txtCenaSaPDVPopust.setText("");
        txtCenaBezPDVBezPopusta.setText("");
        txtCenaSaPDVBezPopusta.setText("");
        txtPopust.setText("");
        txtKolicina.setText("");
        txtNapomena.setText("");
    }

    private void popuniPromena(Otpremnica otpremnica) {
        try {
            txtDatumIzdavanja.setText(otpremnica.getDatumIzdavanja() + "");
            ukupnaSa = otpremnica.getUkupanIznosSaPDV();
            ukupnaBez = otpremnica.getUkupanIznosBezPDv();
            ukupanPopust = otpremnica.getUkupanPopust();
            comboBoxCvecar.setSelectedItem(otpremnica.getCvecar());
            comboBoxKupac.setSelectedItem(otpremnica.getKupac());
            txtUkupnoBez.setText(otpremnica.getUkupanIznosBezPDv() + "");
            txtUkupnoSaPDV.setText(otpremnica.getUkupanIznosSaPDV() + "");
            txtUkupanPopust.setText(otpremnica.getUkupanPopust() + "");
            tableStavke.setModel(new TableModelStavkaOtpremnice(otpremnica));
        } catch (Exception ex) {
            Logger.getLogger(KreirajOtpremnicuForma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
