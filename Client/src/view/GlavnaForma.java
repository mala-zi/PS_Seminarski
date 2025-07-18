/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Cvecar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import session.Session;



/**
 *
 * @author Saki
 */
public class GlavnaForma extends javax.swing.JFrame {
Cvecar cvecar;
  //  ModelTableOtpremnica mto= new ModelTableOtpremnica( Controller.getInstance().ucitajOtpremniceIzBaze());
    /**
     * Creates new form MainForma
     */
    public GlavnaForma(Cvecar c) {
        initComponents();
        cvecar=c;
        setTitle(cvecar.getIme()+" "+cvecar.getPrezime());
        setResizable(false);
        setLocationRelativeTo(null);
        //tblOtp.setModel(new model);
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOtp = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        meniCvecar = new javax.swing.JMenu();
        itemCvecarChange = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        itemSSAdd = new javax.swing.JMenuItem();
        itemSSChange = new javax.swing.JMenuItem();
        meniOtpremnica = new javax.swing.JMenu();
        itemOtpAdd = new javax.swing.JMenuItem();
        itemOtpChange = new javax.swing.JMenuItem();
        itemOtpSearch = new javax.swing.JMenuItem();
        meniKupac = new javax.swing.JMenu();
        itemKupacAdd = new javax.swing.JMenuItem();
        itemKupacChange = new javax.swing.JMenuItem();
        meniAranzman = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        meniMesto = new javax.swing.JMenu();
        itemMestoView = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("izloguj se");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblOtp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOtp);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Otpremnice");

        meniCvecar.setText("Cvecar");

        itemCvecarChange.setText("Kreiraj Cvecara");
        itemCvecarChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCvecarChangeActionPerformed(evt);
            }
        });
        meniCvecar.add(itemCvecarChange);

        jMenuItem10.setText("Upravljaj cvecarima");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        meniCvecar.add(jMenuItem10);

        itemSSAdd.setText("Ubaci strucnu spremu");
        itemSSAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSSAddActionPerformed(evt);
            }
        });
        meniCvecar.add(itemSSAdd);

        itemSSChange.setText("Promeni strucnu spremu");
        itemSSChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSSChangeActionPerformed(evt);
            }
        });
        meniCvecar.add(itemSSChange);

        jMenuBar1.add(meniCvecar);

        meniOtpremnica.setText("Otpremnica");

        itemOtpAdd.setText("Kreiraj otp");
        itemOtpAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOtpAddActionPerformed(evt);
            }
        });
        meniOtpremnica.add(itemOtpAdd);

        itemOtpChange.setText("Promeni otp");
        itemOtpChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOtpChangeActionPerformed(evt);
            }
        });
        meniOtpremnica.add(itemOtpChange);

        itemOtpSearch.setText("Pretrazi otp");
        itemOtpSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOtpSearchActionPerformed(evt);
            }
        });
        meniOtpremnica.add(itemOtpSearch);

        jMenuBar1.add(meniOtpremnica);

        meniKupac.setText("Kupac");

        itemKupacAdd.setText("Kreiraj kupca");
        itemKupacAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemKupacAddActionPerformed(evt);
            }
        });
        meniKupac.add(itemKupacAdd);

        itemKupacChange.setText("Promeni kupca");
        itemKupacChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemKupacChangeActionPerformed(evt);
            }
        });
        meniKupac.add(itemKupacChange);

        jMenuBar1.add(meniKupac);

        meniAranzman.setText("Aranzman");

        jMenuItem1.setText("Kreiraj aranzman");
        meniAranzman.add(jMenuItem1);

        jMenuItem14.setText("Promeni aranzman");
        meniAranzman.add(jMenuItem14);

        jMenuBar1.add(meniAranzman);

        meniMesto.setText("Mesto");

        itemMestoView.setText("Pregled Mesta");
        itemMestoView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMestoViewActionPerformed(evt);
            }
        });
        meniMesto.add(itemMestoView);

        jMenuBar1.add(meniMesto);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(284, 284, 284))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemOtpAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOtpAddActionPerformed
    try {
        // TODO add your handling code here:
        KreirajOtp ko=new KreirajOtp(this, true);
        ko.setVisible(true);
        //tblOtp.setModel(mto);
    } catch (Exception ex) {
        Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_itemOtpAddActionPerformed

    private void itemKupacChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemKupacChangeActionPerformed
        // TODO add your handling code here:
        PromeniKupacForma pkf=new PromeniKupacForma(false);
        pkf.setVisible(true);
    }//GEN-LAST:event_itemKupacChangeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int odgovor= JOptionPane.showConfirmDialog(this,
                "Da li ste sigurni da zelite da se odjavite?", 
                "Odjava",
                JOptionPane.YES_NO_OPTION);
        
        if(odgovor==JOptionPane.NO_OPTION) return;
        else if(odgovor==JOptionPane.YES_OPTION) {
            Session.getInstance().setUlogovani(null);
            LoginForma lf= new LoginForma();
            lf.setVisible(true);
                 
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void itemOtpChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOtpChangeActionPerformed
        // TODO add your handling code here:
        FormaPromeni pf=new FormaPromeni(this, true);
        pf.setVisible(true);
    }//GEN-LAST:event_itemOtpChangeActionPerformed

    private void itemKupacAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemKupacAddActionPerformed
        // TODO add your handling code here:
        KreirajKupcaForma kf=new KreirajKupcaForma(null,null);
        kf.setVisible(true);
    }//GEN-LAST:event_itemKupacAddActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
  
        // TODO add your handling code here:
        PromeniCvecaraForma pc;
        try {
            pc = new PromeniCvecaraForma();
            pc.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void itemCvecarChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCvecarChangeActionPerformed
        // TODO add your handling code here:
        KreirajCvecaraForma kcf=new KreirajCvecaraForma();
        kcf.setVisible(true);
    }//GEN-LAST:event_itemCvecarChangeActionPerformed

    private void itemSSAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSSAddActionPerformed
        // TODO add your handling code here:
        UbaciStrucnuSpremuForma ssf=new UbaciStrucnuSpremuForma();
        ssf.setVisible(true);
    }//GEN-LAST:event_itemSSAddActionPerformed

    private void itemSSChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSSChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemSSChangeActionPerformed

    private void itemOtpSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOtpSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemOtpSearchActionPerformed

    private void itemMestoViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMestoViewActionPerformed
        // TODO add your handling code here:
        PregledMestaForma pmf=new PregledMestaForma();
        pmf.setVisible(true);
    }//GEN-LAST:event_itemMestoViewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCvecarChange;
    private javax.swing.JMenuItem itemKupacAdd;
    private javax.swing.JMenuItem itemKupacChange;
    private javax.swing.JMenuItem itemMestoView;
    private javax.swing.JMenuItem itemOtpAdd;
    private javax.swing.JMenuItem itemOtpChange;
    private javax.swing.JMenuItem itemOtpSearch;
    private javax.swing.JMenuItem itemSSAdd;
    private javax.swing.JMenuItem itemSSChange;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu meniAranzman;
    private javax.swing.JMenu meniCvecar;
    private javax.swing.JMenu meniKupac;
    private javax.swing.JMenu meniMesto;
    private javax.swing.JMenu meniOtpremnica;
    private javax.swing.JTable tblOtp;
    // End of variables declaration//GEN-END:variables
}
