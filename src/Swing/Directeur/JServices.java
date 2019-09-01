/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Directeur;

import TableModele.MonModele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author omar
 */
public class JServices extends javax.swing.JPanel {
 IHMDirecteur jdir;
    /**
     * Creates new form Services
     */
    public JServices() {
        initComponents();
    }

    JServices(IHMDirecteur jdir) {
            this.jdir=jdir;
            initComponents();

        AfficherAllService();
   
        modif.setEnabled(false);
      PieChartServiceDemande();
       
    }
 
    public void AfficherAllService()
    {
        //ResultSet Res = (ResultSet) Gs.getServices();
        ResultSet Res =  jdir.dr.gs.ListeServices();
        MonModele modele = new MonModele(Res);
        this.jtableservice.setModel(modele);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prixtext = new javax.swing.JTextField();
        desctext = new javax.swing.JTextField();
        ajouterservice = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableservice = new javax.swing.JTable();
        modif = new javax.swing.JButton();
        jGraph = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnsupprimer = new javax.swing.JButton();

        jPanel1.setNextFocusableComponent(this);
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 672));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Ajouter un nouveau service ");

        jLabel3.setText("Prix");

        jLabel4.setText("Description");

        ajouterservice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ajouterservice.setText("ajouter");
        ajouterservice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterserviceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(ajouterservice, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(prixtext)
                                    .addComponent(desctext, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addGap(247, 247, 247))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prixtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(desctext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(ajouterservice)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ajouter Service", jPanel1);

        jtableservice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtableservice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableserviceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableservice);

        modif.setText("modifier");
        modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        btnsupprimer.setText("supprimer");
        btnsupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsupprimerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnsupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(modif, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modif)
                    .addComponent(btnsupprimer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGraph, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("liste des services", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtableserviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableserviceMouseClicked

      
        modif.setEnabled(true);

    }//GEN-LAST:event_jtableserviceMouseClicked

    private void modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifActionPerformed
        TableModel model = (TableModel)jtableservice.getModel();
        int id= Integer.parseInt(model.getValueAt(jtableservice.getSelectedRow(),0).toString());
        float prix=Float.parseFloat(model.getValueAt(jtableservice.getSelectedRow(),1).toString());
        String designation=model.getValueAt(jtableservice.getSelectedRow(),2).toString();

        new JFmodifierService(id,prix,designation,jdir.dr,this).setVisible(true);
       

    }//GEN-LAST:event_modifActionPerformed

    private void ajouterserviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterserviceActionPerformed
    
        float Prix = Float.parseFloat(prixtext.getText());
        String designation = desctext.getText();
   
       jdir.dr.gs.AjouterService(jdir.dr.getCinE(),Prix,designation);
       this.AfficherAllService();
       JOptionPane.showMessageDialog(null, "Service Ajoutée" , "Ajout Service ",JOptionPane.INFORMATION_MESSAGE);
       vider();

    }//GEN-LAST:event_ajouterserviceActionPerformed

    private void btnsupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsupprimerMouseClicked
         jdir.dr.gs.SupprimerService(Integer.parseInt(jtableservice.getModel().getValueAt(jtableservice.getSelectedRow(),0).toString()));
         AfficherAllService();
         
         JOptionPane.showMessageDialog(null, "Service Supprimée" , "",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnsupprimerMouseClicked

    
    public  void  PieChartServiceDemande()
    {
        DefaultPieDataset dataset = new DefaultPieDataset();
        ResultSet rs=jdir.dr.gs.GetServiceParDemande();
       
        
     try {
         while(rs.next())
         {  
            // System.out.println(rs.getFloat(2)+"rs.getString(1));
             dataset.setValue( rs.getString(1),rs.getFloat(2));
         }


             JFreeChart  piechart=ChartFactory.createPieChart3D("Services demandes par les clients", dataset, true, true, false);
             //CategoryPlot barchrt=piechart.getCategoryPlot();
            // barchrt.setRangeGridlinePaint(Color.ORANGE);
             
            ChartPanel chartpanel = new ChartPanel(piechart);
            PiePlot plot = (PiePlot) piechart.getPlot();
       
               // plot.setSimpleLabels(true);

             PieSectionLabelGenerator gen;
                    gen = new StandardPieSectionLabelGenerator( "{0}: {1} ({2})", NumberFormat.getInstance(),NumberFormat.getPercentInstance()); 
                plot.setLabelGenerator(gen);
             //chartpanel.setPreferredSize(new Dimension(400, 400));
             

              ImageIcon img=new ImageIcon(piechart.createBufferedImage(650,260));
             
              this.jGraph.setIcon(img);
           
          
     
     } catch (SQLException ex) {
         Logger.getLogger(JGain.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    
    public void vider()
    {
        prixtext.setText("");
        desctext.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterservice;
    private javax.swing.JButton btnsupprimer;
    private javax.swing.JTextField desctext;
    private javax.swing.JLabel jGraph;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtableservice;
    private javax.swing.JButton modif;
    private javax.swing.JTextField prixtext;
    // End of variables declaration//GEN-END:variables
}
