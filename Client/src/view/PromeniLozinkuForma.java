/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.Controller;
import domain.Cvecar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validator.Validator;

/**
 *
 * @author Saki
 */
public class PromeniLozinkuForma extends javax.swing.JDialog {

    private Cvecar cvecar;
    /**
     * Creates new form PromeniLozinkuForma
     */
    public PromeniLozinkuForma(java.awt.Frame parent, boolean modal,Cvecar c) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        cvecar=c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnPromeni = new javax.swing.JButton();
        txtNovaLozinka = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Nova lozinka");

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNovaLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPromeni))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNovaLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnPromeni)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        try {
            // TODO add your handling code here:
            String nova=txtNovaLozinka.getText();
            if(Validator.isValidPassword(nova)==false){
                JOptionPane.showMessageDialog(this, "Lozinka mora da ima minimum 8 karaktera!","Greska",JOptionPane.ERROR_MESSAGE);
                return;
            }
            cvecar.setLozinka(nova);
            Controller.getInstance().promeniLozinkuCvecara(cvecar);
           JOptionPane.showMessageDialog(this, "Lozinka uspesno promenjena!","Obavestenje",JOptionPane.INFORMATION_MESSAGE);
           this.dispose();

        } catch (Exception ex) {
            Logger.getLogger(PromeniLozinkuForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPromeniActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromeni;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNovaLozinka;
    // End of variables declaration//GEN-END:variables
}