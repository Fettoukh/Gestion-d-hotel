/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Receptionniste;

import Metiers.GestionClients;
import Metiers.GestionDemande;
import TableModele.MonModele;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;


/**
 *
 * @author amine
 */
public class JPAccueil extends javax.swing.JPanel {

    GestionClients Gc = new GestionClients();
    GestionDemande Gd = new GestionDemande();
    IHMReceptionniste Jp;
    boolean Service = false ;
    /**
     * Creates new form JPExpiration
     */
    public JPAccueil() {
        initComponents();
    }
    
    public JPAccueil(IHMReceptionniste Jp)
    {
        this.Jp=Jp ;
        initComponents();
        AfficherTableReservation();
        AfficherTableService();
        resetInfo();
    }
    
    public void AfficherTableReservation()
    {
        ResultSet Res = Gc.ExpirationCL();
        MonModele modele = new MonModele(Res);
        TChambre.setModel(modele);
    }
    
    public void AfficherTableService()
    {
        jLabel3.setText("Les Services demander aujourd'hui :");
        ResultSet Res = Gd.Service_aujourdui();
        MonModele modele = new MonModele(Res);
        TService.setModel(modele);
    }
    
    public void AfficherAllService()
    {
        jLabel3.setText("Tout les Services non effectuées");
        ResultSet Res = Gd.Service_non_effectuee();
        MonModele modele = new MonModele(Res);
        TService.setModel(modele);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TService = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TChambre = new javax.swing.JTable();
        RadioServices = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtInfo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(857, 638));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel1.setText("Liberation de chambre prévue pour aujourd'hui (Non payée):");

        jLabel2.setText("Remarque !!  Double Click pour accéder a la facture du client");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel3.setText("Les Services demander aujourd'hui :");

        TService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TServiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TService);

        TChambre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TChambre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TChambreMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TChambre);

        RadioServices.setText("Afficher tout les Services non effectuée");
        RadioServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioServicesMouseClicked(evt);
            }
        });
        RadioServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioServicesActionPerformed(evt);
            }
        });

        jLabel4.setText("Remarque !! Double Click pour marquer comme effectuée");

        txtInfo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtInfo.setForeground(new java.awt.Color(0, 153, 0));
        txtInfo.setText("Se change en cas de confirmation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RadioServices)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel4)))))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(txtInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioServices)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(txtInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TChambreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TChambreMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==2)
        {
        int lig = TChambre.getSelectedRow();
        String cin = TChambre.getValueAt(lig, 1).toString();
        Jp.JPLFacture.gettxtCin().setText(cin);   
        Jp.passageFacture();
        Jp.JPLFacture.setVisible(true);
        this.setVisible(false);
        }
    }//GEN-LAST:event_TChambreMouseClicked

    private void TServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TServiceMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==2)
        {
          int lig = TService.getSelectedRow();
          Gd.Effectuee_Service(Integer.parseInt(TService.getValueAt(lig, 0).toString()));
          if(Service==false)
          {
            AfficherTableService(); 
          }
          else
          {
              AfficherAllService();
          }
          txtInfo.setText("Le Service a été efffectuée !!");
          
        }
    }//GEN-LAST:event_TServiceMouseClicked

    private void RadioServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioServicesMouseClicked
        // TODO add your handling code here:
        if(Service==true)
        {
            AfficherTableService();
            Service = false ;
        }
        else
        {
            AfficherAllService();
            Service = true ;
        }
    }//GEN-LAST:event_RadioServicesMouseClicked

    private void RadioServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioServicesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioServicesActionPerformed

    
    public void resetInfo()
    {
        java.util.Timer timer = new Timer();
        //Set the schedule function
        timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Magic here
                          txtInfo.setText("");
                                }
                            },
                0, 20000);
                    }
    
    public void vider()
    {
        Service=false ;
        RadioServices.setSelected(false);
        AfficherTableService();
        txtInfo.setText("");
        AfficherTableReservation();
        AfficherTableService();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioServices;
    private javax.swing.JTable TChambre;
    private javax.swing.JTable TService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel txtInfo;
    // End of variables declaration//GEN-END:variables
}
