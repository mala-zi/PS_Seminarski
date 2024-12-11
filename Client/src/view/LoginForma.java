/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Controller;
import domain.Cvecar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author Saki
 */
public class LoginForma extends javax.swing.JFrame {

    /**
     * Creates new form LoginForma
     */
    public LoginForma() {
        
        initComponents();
        setTitle("Login forma");
        setResizable(false);
        setLocationRelativeTo(null);
        txtErrorLozinka.setVisible(false);
        unos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblkorisnickoIme = new javax.swing.JLabel();
        lblLoznika = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        btnUlogujSe = new javax.swing.JButton();
        txtLozinka = new javax.swing.JPasswordField();
        txtErrorLozinka = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblkorisnickoIme.setText("korisnicko ime:");

        lblLoznika.setText("lozinka");

        txtKorisnickoIme.setText("ana3");
        txtKorisnickoIme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKorisnickoImeActionPerformed(evt);
            }
        });

        btnUlogujSe.setText("uloguj se");
        btnUlogujSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlogujSeActionPerformed(evt);
            }
        });

        txtLozinka.setText("asdfghjkl");
        txtLozinka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLozinkaActionPerformed(evt);
            }
        });

        txtErrorLozinka.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnUlogujSe)
                        .addGap(143, 143, 143))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLoznika, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblkorisnickoIme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtLozinka)
                            .addComponent(txtErrorLozinka))
                        .addGap(64, 64, 64)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblkorisnickoIme)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoznika)
                    .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txtErrorLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUlogujSe)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKorisnickoImeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKorisnickoImeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKorisnickoImeActionPerformed

    private void txtLozinkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLozinkaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLozinkaActionPerformed

    private void btnUlogujSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlogujSeActionPerformed
        // TODO add your handling code here:
        try {
            //Controller controller=new Controller();
            
            Controller controller = Controller.getInstance();
            Cvecar cvecar=new Cvecar(txtKorisnickoIme.getText(), new String(txtLozinka.getPassword()));
            cvecar=controller.prijaviCvecara(cvecar);
            System.out.println(cvecar);
            JOptionPane.showMessageDialog(this, cvecar.getIme()+" logged in!", "Login", JOptionPane.INFORMATION_MESSAGE);
            JFrame frame=new GlavnaForma(cvecar);
            frame.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Login unsucessful!\n"+ex.getMessage(), "Login", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUlogujSeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUlogujSe;
    private javax.swing.JLabel lblLoznika;
    private javax.swing.JLabel lblkorisnickoIme;
    private javax.swing.JTextField txtErrorLozinka;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtLozinka;
    // End of variables declaration//GEN-END:variables

    private void unos() {
        MyDocumentListener listener = new MyDocumentListener();
        txtKorisnickoIme.getDocument().addDocumentListener(listener);
        txtLozinka.getDocument().addDocumentListener(listener);
    }

    public class MyDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            validate(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            validate(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            validate(e);
        }

        private void validate(DocumentEvent e) {
            Document source = e.getDocument();

            if (source == txtKorisnickoIme.getDocument()) {
                txtErrorLozinka.setText("");
                txtErrorLozinka.setVisible(false);

            }
            if (source == txtLozinka.getDocument()) {
                String pass = String.valueOf(txtLozinka.getPassword());
                if (pass != null && pass.length() >= 8) {
                    txtErrorLozinka.setText("");
                    txtErrorLozinka.setVisible(false);

                } else {
                    txtErrorLozinka.setVisible(true);
                    txtErrorLozinka.setText("Nedovoljno karaktera lozinke!");
                }
            }
            txtErrorLozinka.getParent().revalidate();
        }

    }
}
