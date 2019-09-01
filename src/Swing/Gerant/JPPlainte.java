/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Gerant;

import Metiers.GestionComptePersonnel;
import Metiers.GestionPlaintes;
import TableModele.MonModele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amine
 */
public class JPPlainte extends javax.swing.JPanel {

    IHMGerant Jp;
    GestionComptePersonnel Gcp = new GestionComptePersonnel();
    GestionPlaintes Gp = new GestionPlaintes();
    String cin  , date; 
    String cinGr;
 
    /**
     * Creates new form JPPlainte
     */
    public JPPlainte() {
        initComponents();
    }
    
    public JPPlainte(IHMGerant Jp)
    {
        this.Jp=Jp ;
        initComponents();
        AfficherTable();
        Afficher_nb_Plaintes();
        resetInfo();
        cinGr = Gcp.Cin_Personnel(Jp.login);
                    
    }
    
    public void resetInfo()
    {
        java.util.Timer timer = new Timer();
        //Set the schedule function
        timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Magic here
                          lblinfo.setText("");
                                }
                            },
                0, 20000);
                    }
   
    public void Afficher_nb_Plaintes()
    {
        ResultSet Res = Gp.nbre_Plaintes();
        try {
            Res.first();
            lblnbPlaintes.setText(""+Res.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(JPPlainte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void AfficherTable()
    {
        ResultSet Res = Gp.Afficher_PlainteSANSremarque();
        TPlaintes.setModel(new MonModele(Res));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TPlaintes = new javax.swing.JTable();
        lblDescription = new javax.swing.JLabel();
        lblRemarque = new javax.swing.JLabel();
        txtDescription = new javax.swing.JLabel();
        txtRemarque = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblnbPlaintes = new javax.swing.JLabel();
        btnAjouter = new javax.swing.JButton();
        lblinfo = new javax.swing.JLabel();

        TPlaintes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TPlaintes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPlaintesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TPlaintes);

        lblDescription.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        lblDescription.setText("Description : ");

        lblRemarque.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        lblRemarque.setText("Remarque : ");

        txtDescription.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N

        txtRemarque.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        txtRemarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemarqueActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel1.setText("Plainte(s)");

        lblnbPlaintes.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N

        btnAjouter.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        btnAjouter.setText("Ajouter");
        btnAjouter.setEnabled(false);
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        lblinfo.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        lblinfo.setForeground(new java.awt.Color(51, 204, 0));
        lblinfo.setText("qsdqsd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblnbPlaintes)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDescription)
                                        .addComponent(lblRemarque))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRemarque)
                                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(btnAjouter))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(lblinfo)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblnbPlaintes))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRemarque)
                    .addComponent(txtRemarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAjouter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinfo)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtRemarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemarqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemarqueActionPerformed

    private void TPlaintesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPlaintesMouseClicked
        // TODO add your handling code here:
        lblinfo.setText("");
        int lig = TPlaintes.getSelectedRow();
        txtDescription.setVisible(true);
        txtRemarque.setVisible(true);
        lblDescription.setVisible(true);
        lblRemarque.setVisible (true);
        txtDescription.setText(TPlaintes.getValueAt(lig, 1).toString());
        cin = TPlaintes.getValueAt(lig, 0).toString();
        date = TPlaintes.getValueAt(lig, 2).toString();
        btnAjouter.setEnabled(true);
        
    }//GEN-LAST:event_TPlaintesMouseClicked

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        // TODO add your handling code here:
        Gp.Ajouter_Remarque(cinGr, txtRemarque.getText(), cin, txtDescription.getText(), date);
        Vider();
        lblinfo.setText("La remarque a été ajoutée !!");
        
    }//GEN-LAST:event_btnAjouterActionPerformed


    public void Vider()
    {
        txtDescription.setVisible(true);
        txtRemarque.setVisible(true);
        lblDescription.setVisible(true);
        lblRemarque.setVisible (true);
        txtDescription.setText("");
        txtRemarque.setText("");
        lblinfo.setText((""));
        btnAjouter.setEnabled(false);
        AfficherTable();
        Afficher_nb_Plaintes();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TPlaintes;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblRemarque;
    private javax.swing.JLabel lblinfo;
    private javax.swing.JLabel lblnbPlaintes;
    private javax.swing.JLabel txtDescription;
    private javax.swing.JTextField txtRemarque;
    // End of variables declaration//GEN-END:variables
}