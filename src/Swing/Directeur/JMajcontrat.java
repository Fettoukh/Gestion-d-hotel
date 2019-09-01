/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Directeur;

import Metiers.Directeur;
import Metiers.GestionContrats;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author omar
 */
public class JMajcontrat extends javax.swing.JFrame {
    String cinP,nom,prenom;
    JPersonnel jp;
  

   Directeur dr;
    int xmouse;
    int ymouse;
    static boolean maximized = true ;
    /**
     * Creates new form Majcontrat
     */
    public JMajcontrat(String cinP,String nom,String prenom,Directeur dr,JPersonnel jp) {
        initComponents();
            this.dr=dr;
            this.cinP=cinP;
            this.nom=nom;
            this.prenom=prenom;
            this.jp=jp;
            charger();
    }

    private JMajcontrat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  void charger()
    {
         ResultSet rs=dr.gc.GetContrats(cinP);
         this.labelnom.setText(nom);
         this.labelprenom.setText(prenom);
         this.labelcin.setText(cinP);
        try {
            rs.next();
            this.txtrole.setText(rs.getString(7));
            this.txtsalaire.setText(rs.getString(8));
            this.txtdescription.setText(rs.getString(9));
            this.jdatedebut.setDate(rs.getDate(4));
            this.jdatedebut.setEnabled(false);
          //  this.jdatefin.setDate(rs.getDate(5));
            if(rs.getString(7).equalsIgnoreCase("Gerant"))
            {
            this.cbrole.setSelectedIndex(0);
            }
            else if(rs.getString(7).equalsIgnoreCase("Receptionniste"))
            {
                this.cbrole.setSelectedIndex(1);
                
            }
            else
            {
                this.cbrole.setSelectedIndex(2);
            }
            if(rs.getString(6).equalsIgnoreCase("CDD"))
            {
                this.cbcontrat.setSelectedIndex(0);
                this.jdatefin.setDate(rs.getDate(5));
            }
            else if (rs.getString(6).equalsIgnoreCase("CDI"))
            {
                 this.cbcontrat.setSelectedIndex(1);
                
            }
            else
            {
                
                 this.cbcontrat.setSelectedIndex(2);
                 this.jdatefin.setDate(rs.getDate(5));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         
         
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtdescription = new javax.swing.JTextField();
        btnmaj = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbrole = new javax.swing.JComboBox<>();
        jdatedebut = new com.toedter.calendar.JDateChooser();
        txtrole = new javax.swing.JTextField();
        jdatefin = new com.toedter.calendar.JDateChooser();
        txtsalaire = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbcontrat = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelcin = new javax.swing.JLabel();
        topPanel6 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMaximize = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        labelnom = new javax.swing.JLabel();
        labelprenom = new javax.swing.JLabel();
        btnreset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescriptionActionPerformed(evt);
            }
        });
        getContentPane().add(txtdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 521, 193, 59));

        btnmaj.setText("Mettre a jour");
        btnmaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmajActionPerformed(evt);
            }
        });
        getContentPane().add(btnmaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 208, -1));

        jLabel14.setText("Description");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 518, -1, -1));

        cbrole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerant", "Receptionniste", "autres" }));
        cbrole.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbroleItemStateChanged(evt);
            }
        });
        getContentPane().add(cbrole, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 287, 193, -1));
        getContentPane().add(jdatedebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 169, 193, -1));

        txtrole.setEnabled(false);
        txtrole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroleActionPerformed(evt);
            }
        });
        getContentPane().add(txtrole, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 327, 193, -1));
        getContentPane().add(jdatefin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 227, 193, -1));
        getContentPane().add(txtsalaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 394, 193, -1));

        jLabel9.setText("Date fin");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 214, -1, -1));

        jLabel10.setText("Date debut");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 169, -1, -1));

        jLabel11.setText("Role ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 277, -1, -1));

        cbcontrat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CDD", "CDI", "CTT" }));
        cbcontrat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbcontratItemStateChanged(evt);
            }
        });
        cbcontrat.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbcontratPropertyChange(evt);
            }
        });
        getContentPane().add(cbcontrat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 464, 193, -1));

        jLabel12.setText("Salaire");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 384, 60, -1));

        jLabel13.setText("Type Contrat");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 454, -1, -1));

        jLabel1.setText("Nom : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel3.setText("Prenom :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel2.setText("Cin  :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 118, 35, -1));

        labelcin.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        getContentPane().add(labelcin, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 118, -1, -1));

        topPanel6.setBackground(new java.awt.Color(73, 75, 79));
        topPanel6.setPreferredSize(new java.awt.Dimension(146, 32));
        topPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanel6MouseDragged(evt);
            }
        });
        topPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topPanel6MousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(73, 75, 79));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        btnExit.setContentAreaFilled(false);
        btnExit.setOpaque(true);
        btnExit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit (2).png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        btnMaximize.setBackground(new java.awt.Color(73, 75, 79));
        btnMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maximize.png"))); // NOI18N
        btnMaximize.setContentAreaFilled(false);
        btnMaximize.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Maximize (2).png"))); // NOI18N
        btnMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseClicked(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(73, 75, 79));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize.png"))); // NOI18N
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setOpaque(true);
        btnMinimize.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize (2).png"))); // NOI18N
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanel6Layout = new javax.swing.GroupLayout(topPanel6);
        topPanel6.setLayout(topPanel6Layout);
        topPanel6Layout.setHorizontalGroup(
            topPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize)
                .addGap(0, 0, 0)
                .addComponent(btnMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topPanel6Layout.setVerticalGroup(
            topPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMaximize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(topPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 623, -1));

        labelnom.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        getContentPane().add(labelnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 40, 20));

        labelprenom.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        getContentPane().add(labelprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 180, 20));

        btnreset.setText(" Réinitialiser");
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresetMouseClicked(evt);
            }
        });
        getContentPane().add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 650, 196, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescriptionActionPerformed

    private void btnmajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmajActionPerformed

        

        /* contrat */
        Date datedebut=this.jdatedebut.getDate();
        Date datefin=this.jdatefin.getDate();
        Date date= new java.sql.Date(Calendar.getInstance().getTime().getTime());

        String role=this.cbrole.getSelectedItem().toString();
        String roleE=this.txtrole.getText();
        float salaire=Float.parseFloat(this.txtsalaire.getText());
        String typec=this.cbcontrat.getSelectedItem().toString();
        String description = this.txtdescription.getText();
        int reponse =JOptionPane.showConfirmDialog(null, "Etes vous sur d'effectuer cette mise a jour", null, JOptionPane.YES_NO_OPTION);
         if(reponse==JOptionPane.NO_OPTION)
          {
           return;
          }
                
        if(typec.equalsIgnoreCase("CDI"))
        {
            Calendar cal = Calendar.getInstance();
            cal.set(2100, 1, 1);
            datefin=new java.sql.Date(cal.getTime().getTime());

        }
        if(datefin.before(datedebut)  ){

            JOptionPane.showMessageDialog(null, " la date fin ou la date debut non valide ");
            return ;

        }

        if(role.equalsIgnoreCase("gerant"))
        {
          this.dr.gcp.activer_Compte(cinP);
         
        }
        else if(role.equalsIgnoreCase("receptionniste"))
        {
           this.dr.gcp.activer_Compte(cinP);
          
        }
        else if(role.equalsIgnoreCase("autres"))
        {
           this.dr.gcp.Desactiver_Compte(cinP);
       
        }

        this.dr.gc.MajContrat(cinP, dr.getCinE(), datefin, datedebut, typec, roleE, salaire, description);
        this.jp.refresh();
        JOptionPane.showMessageDialog(null, "Contrat mis a jour !!!");

        // TODO add your handling code here:
    }//GEN-LAST:event_btnmajActionPerformed

    private void txtroleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroleActionPerformed

    private void cbcontratItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbcontratItemStateChanged
        // TODO add your handling code here:
        if(this.cbcontrat.getSelectedItem().toString().equalsIgnoreCase("CDI"))
        {
            this.jdatefin.setEnabled(false);
        }
        else
        {
            this.jdatefin.setEnabled(true);

        }
    }//GEN-LAST:event_cbcontratItemStateChanged

    private void cbcontratPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbcontratPropertyChange

     
    }//GEN-LAST:event_cbcontratPropertyChange

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
       int reponse =JOptionPane.showConfirmDialog(null, "Etes vous sur du vouloir Quitter", "Fermeture !!!", JOptionPane.YES_NO_OPTION);
       if(reponse==JOptionPane.YES_OPTION)
          {
            this.dispose();
          }
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        // TODO add your handling code here:
       btnExit.setBackground(Color.red);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        // TODO add your handling code here:
        btnExit.setBackground(new Color(73,75,79));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnMaximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseClicked
        // TODO add your handling code here:
        if (maximized)
        {
            JMajcontrat.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            JMajcontrat.this.setMaximizedBounds(env.getMaximumWindowBounds());
            maximized=false ;
        }
        else
        {
            setExtendedState(JFrame.NORMAL);
            maximized = true ;
        }
    }//GEN-LAST:event_btnMaximizeMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void topPanel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanel6MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xmouse, y - ymouse);
        //System.out.println(x+","+y);
    }//GEN-LAST:event_topPanel6MouseDragged

    private void topPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanel6MousePressed
        // TODO add your handling code here:
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_topPanel6MousePressed

    private void cbroleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbroleItemStateChanged
        // TODO add your han
         if(this.cbrole.getSelectedItem().toString().equalsIgnoreCase("autres"))
        {
            this.txtrole.setEnabled(true);
            this.txtrole.setText("");
        }
        else
        {
            this.txtrole.setEnabled(false);
            txtrole.setText(cbrole.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbroleItemStateChanged

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
    this.charger();
    }//GEN-LAST:event_btnresetMouseClicked
 
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
            java.util.logging.Logger.getLogger(JMajcontrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMajcontrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMajcontrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMajcontrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMajcontrat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMaximize;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnmaj;
    private javax.swing.JButton btnreset;
    private javax.swing.JComboBox<String> cbcontrat;
    private javax.swing.JComboBox<String> cbrole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JDateChooser jdatedebut;
    private com.toedter.calendar.JDateChooser jdatefin;
    private javax.swing.JLabel labelcin;
    private javax.swing.JLabel labelnom;
    private javax.swing.JLabel labelprenom;
    private javax.swing.JPanel topPanel6;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtrole;
    private javax.swing.JTextField txtsalaire;
    // End of variables declaration//GEN-END:variables
}
