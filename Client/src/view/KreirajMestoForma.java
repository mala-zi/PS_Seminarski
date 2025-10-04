/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Controller;
import domain.Mesto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tableModel.TableModelMesto;

/**
 *
 * @author Saki
 */
public class KreirajMestoForma extends javax.swing.JFrame {

    private boolean uspeh = false;
    private Mesto mestoChange;
    private Mesto mestoCreate;
    private PregledMestaForma viewForm;
    private KreirajKupcaForma kupacForm;
    private boolean dodaj = false;
    private ArrayList<Mesto> listaMesta;
    private static final Map<String, Integer> gradPBMap = new HashMap<>();

    static {
        gradPBMap.put("Beograd", 11000);
        gradPBMap.put("Valjevo", 14000);
        gradPBMap.put("Novi Sad", 21000);
        gradPBMap.put("Niš", 18000);
        gradPBMap.put("Kragujevac", 34000);
        gradPBMap.put("Subotica", 24000);
        gradPBMap.put("Zrenjanin", 23000);
        gradPBMap.put("Pančevo", 26000);
        gradPBMap.put("Sombor", 25000);
        gradPBMap.put("Čačak", 32000);
        gradPBMap.put("Kraljevo", 36000);
        gradPBMap.put("Novi Pazar", 36300);
        gradPBMap.put("Loznica", 15300);
        gradPBMap.put("Šabac", 15000);
        gradPBMap.put("Leskovac", 16000);
        gradPBMap.put("Vranje", 17500);
        gradPBMap.put("Užice", 31000);
        gradPBMap.put("Smederevo", 11300);
        gradPBMap.put("Jagodina", 35000);
        gradPBMap.put("Požarevac", 12000);
    }

    public boolean isUspeh() {
        return uspeh;
    }

    public void setUspeh(boolean uspeh) {
        this.uspeh = uspeh;
    }

    public KreirajMestoForma(PregledMestaForma viewForm) {
        initComponents();
        this.viewForm = viewForm;
        this.mestoChange = null;
        setTitle("Kreiraj mesto");
        setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mestoCreate = new Mesto(-1, "", 11000, "");
        try {
            Controller.getInstance().kreirajMesto(mestoCreate);
            ArrayList<Mesto> lista = Controller.getInstance().ucitajMestaIzBaze();
            for (Mesto m : lista) {
                if (m.equals(mestoCreate)) {
                    mestoCreate.setId(m.getId());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(KreirajMestoForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(this, "Sistem je kreirao mesto.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        KreirajMestoForma.this,
                        "Da li želite da prekinete kreiranje mesta?",
                        "Potvrda zatvaranja",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (choice == JOptionPane.YES_OPTION) {
                    if (mestoCreate != null && mestoChange == null) {
                        try {
                            Controller.getInstance().obrisiMesto(mestoCreate);
                        } catch (Exception ex) {
                            Logger.getLogger(KreirajMestoForma.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    dispose();
                }
            }
        });
    }

    public KreirajMestoForma(PregledMestaForma viewForm, Mesto m) {
        initComponents();
        this.viewForm = viewForm;
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if (m != null) {
            setTitle("Promeni mesto");
            mestoChange = m;
            popuniIzmenuMesto(mestoChange);
        }
    }

    public KreirajMestoForma(KreirajKupcaForma kupacForm, boolean dodaj) {
        initComponents();
        this.dodaj = dodaj;
        this.kupacForm = kupacForm;
        this.mestoChange = null;
        setTitle("Kreiraj mesto");
        setResizable(false);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mestoCreate = new Mesto(-1, "", 11000, "");
        try {
            Controller.getInstance().kreirajMesto(mestoCreate);
            ArrayList<Mesto> lista = Controller.getInstance().ucitajMestaIzBaze();
            for (Mesto m : lista) {
                if (m.equals(mestoCreate)) {
                    mestoCreate.setId(m.getId());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(KreirajMestoForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(this, "Sistem je kreirao mesto.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        KreirajMestoForma.this,
                        "Da li želite da prekinete kreiranje mesta?",
                        "Potvrda zatvaranja",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (choice == JOptionPane.YES_OPTION) {
                    if (mestoCreate != null && mestoChange == null) {
                        try {
                            Controller.getInstance().obrisiMesto(mestoCreate);
                        } catch (Exception ex) {
                            Logger.getLogger(KreirajMestoForma.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    dispose();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtGrad = new javax.swing.JTextField();
        txtPostanskiBroj = new javax.swing.JTextField();
        txtUlica = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancel.setBackground(new java.awt.Color(153, 255, 204));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Otkaži");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
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

        txtGrad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPostanskiBroj.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtUlica.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Grad");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Poštanski broj");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ulica");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPostanskiBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(txtUlica, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave)))
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtUlica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPostanskiBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (mestoCreate != null && mestoChange == null) {
            try {
                Controller.getInstance().obrisiMesto(mestoCreate);
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(KreirajMestoForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            // TODO add your handling code here:
            if (txtGrad.getText().isEmpty() || txtPostanskiBroj.getText().isEmpty() || txtUlica.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate popuniti sva polja!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int pb = Integer.parseInt(txtPostanskiBroj.getText());
            if (pb < 11000 || pb > 40000) {
                JOptionPane.showMessageDialog(this, "Poštanski broj ne postoji!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String grad = txtGrad.getText().trim();
            if (!gradPBMap.containsKey(grad)) {
                JOptionPane.showMessageDialog(this, "Grad ne postoji u Srbiji! Proverite uneti naziv.", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (gradPBMap.get(grad) != pb) {
                JOptionPane.showMessageDialog(this, "Poštanski broj ne odgovara gradu " + grad + "!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (mestoChange == null && mestoCreate != null) {
                mestoCreate.setGrad(grad);
                mestoCreate.setPostanskiBroj(pb);
                mestoCreate.setUlica(txtUlica.getText());
                try {
                    listaMesta = Controller.getInstance().ucitajMestaIzBaze();
                } catch (Exception ex) {
                    Logger.getLogger(KreirajMestoForma.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (Mesto m : listaMesta) {
                    if (m.equals(mestoCreate)) {
                        JOptionPane.showMessageDialog(this, "Mesto već postoji u bazi.", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                Controller.getInstance().promeniMesto(mestoCreate);
                if (dodaj == false) {
                    JOptionPane.showMessageDialog(this, "Sistem je zapamtio mesto.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                    viewForm.getTblMesta().setModel(new TableModelMesto());
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem je zapamtio mesto.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                    uspeh = true;
                    kupacForm.getComboBoxMesto().removeAllItems();
                    ArrayList<Mesto> listaMesta = Controller.getInstance().ucitajMestaIzBaze();
                    for (Mesto mesto1 : listaMesta) {
                        kupacForm.getComboBoxMesto().addItem(mesto1);
                    }
                    this.dispose();
                }

            } else {
                mestoChange.setGrad(grad);
                mestoChange.setUlica(txtUlica.getText());
                mestoChange.setPostanskiBroj(pb);
                try {
                    listaMesta = Controller.getInstance().ucitajMestaIzBaze();
                } catch (Exception ex) {
                    Logger.getLogger(KreirajMestoForma.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (Mesto m : listaMesta) {
                    if (m.equals(mestoChange)) {
                        JOptionPane.showMessageDialog(this, "Mesto već postoji u bazi.", "Greška", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                Controller.getInstance().promeniMesto(mestoChange);
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio mesto.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                viewForm.getTblMesta().setModel(new TableModelMesto());
                this.dispose();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem nije uspeo da zapamti mesto.", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }


    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(KreirajMestoForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreirajMestoForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreirajMestoForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreirajMestoForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtGrad;
    private javax.swing.JTextField txtPostanskiBroj;
    private javax.swing.JTextField txtUlica;
    // End of variables declaration//GEN-END:variables

    private void popuniIzmenuMesto(Mesto mesto) {
        txtGrad.setText(mesto.getGrad());
        txtPostanskiBroj.setText(mesto.getPostanskiBroj() + "");
        txtUlica.setText(mesto.getUlica());
    }

}
