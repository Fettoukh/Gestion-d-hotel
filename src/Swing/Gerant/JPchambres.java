
package Swing.Gerant;

import Metiers.GestionChambres;
import Metiers.GestionClients;
import Metiers.GestionComptePersonnel;
import TableModele.MonModele;
import java.awt.Color;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class JPchambres extends javax.swing.JPanel {
GestionChambres Gc = new GestionChambres();
 GestionClients Gcl=new GestionClients();
  GestionComptePersonnel Gcp=new  GestionComptePersonnel();
 IHMGerant Jp ;
  boolean dispo = false ;
   
    /**
     * Creates new form JPchambres
     */
    public JPchambres() {
        initComponents();
    }
    
     public JPchambres(IHMGerant Jp)
    {
        this.Jp=Jp ;
        initComponents();
        AfficherChambres();
    }
    public void AfficherChambres()
    {
        label.setText("Toutes les chambres");
        label.setBackground(new Color(51,51,51));
        label.setSize(20, 20);
        ResultSet Res = Gc.AllChambres();
        MonModele modele = new MonModele(Res);
        Ttable.setModel(modele);
    }
    public void chambredispo(){
        label.setText("les chambres disponibles");
         label.setBackground(new Color(51,51,51));
        label.setSize(14, 12);
          ResultSet Res = Gc.ChambresDispo();
        MonModele modele = new MonModele(Res);
        Ttable.setModel(modele);
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Ttable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tclientp = new javax.swing.JTable();
        jradio = new javax.swing.JRadioButton();
        label = new javax.swing.JLabel();

        Ttable.setBackground(new java.awt.Color(153, 153, 153));
        Ttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Ttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Ttable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 0));
        jLabel2.setText("pour voir les clients qui ont deja reservé  une chambre particuliere, il faut clicker dessus.");

        Tclientp.setBackground(new java.awt.Color(153, 153, 153));
        Tclientp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tclientp);

        jradio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jradio.setForeground(new java.awt.Color(51, 51, 51));
        jradio.setText("afficher toutes les chambres disponibles");
        jradio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jradioMouseClicked(evt);
            }
        });

        label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label.setForeground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jradio)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jradio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TtableMouseClicked
       int lig = Ttable.getSelectedRow();
    
        String num= Ttable.getValueAt(lig, 0).toString();
        int num_chambre=Integer.valueOf(num);
        ResultSet Res = Gcl.Client_precedent(num_chambre);
        MonModele modele = new MonModele(Res);
        Tclientp.setModel(modele);
      
    }//GEN-LAST:event_TtableMouseClicked

    private void jradioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jradioMouseClicked
          if(dispo==true)
        {
             AfficherChambres();
            
           dispo = false ;
        }
        else
        {
            chambredispo();
            
            dispo= true ;
        }
    }//GEN-LAST:event_jradioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tclientp;
    private javax.swing.JTable Ttable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton jradio;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
