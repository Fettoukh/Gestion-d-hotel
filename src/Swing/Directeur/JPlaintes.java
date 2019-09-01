/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Directeur;

import TableModele.MonModele;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author omar
 */
public class JPlaintes extends javax.swing.JPanel {
IHMDirecteur jdir;
    /**
     * Creates new form JPlaintes
     */
    public JPlaintes() {
        initComponents();
    }
public JPlaintes(IHMDirecteur jdir) {
    this.jdir=jdir;
        initComponents();
         this.rbannee.setSelected(true);
        BarChartPLainteYear();
    try {
        remplir();
    } catch (SQLException ex) {
        Logger.getLogger(JPlaintes.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }

public void remplir() throws SQLException
{
  ResultSet rs=this.jdir.dr.gpl.Afficher_Plainte();
   
    this.tableplaintes.setModel(new MonModele(rs));
      Vector<String> annee=this.jdir.dr.gpl.getannee();
       DefaultComboBoxModel df  = new DefaultComboBoxModel(annee);
        this.cbannee.setModel(df);
         this.cbannee.setEnabled(false);
    
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
        jgraph = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbannee = new javax.swing.JRadioButton();
        rbmois = new javax.swing.JRadioButton();
        cbannee = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableplaintes = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Plaintes  ");

        jgraph.setText("Graph");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        rbannee.setText("Par année");
        rbannee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbanneeMouseClicked(evt);
            }
        });
        rbannee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbanneeActionPerformed(evt);
            }
        });

        rbmois.setText("Par mois");
        rbmois.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbmoisMouseClicked(evt);
            }
        });
        rbmois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmoisActionPerformed(evt);
            }
        });

        cbannee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbannee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbanneeItemStateChanged(evt);
            }
        });
        cbannee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbanneeActionPerformed(evt);
            }
        });
        cbannee.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbanneePropertyChange(evt);
            }
        });

        tableplaintes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableplaintes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(319, 319, 319))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbannee)
                        .addGap(78, 78, 78)
                        .addComponent(rbmois)
                        .addGap(27, 27, 27)
                        .addComponent(cbannee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jgraph, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbannee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbmois)
                    .addComponent(rbannee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jgraph, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbanneeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbanneeMouseClicked
         if(this.rbannee.isSelected())
         {
             this.rbmois.setSelected(false);
              this.cbannee.setEnabled(false);
              BarChartPLainteYear();
             
         }
    }//GEN-LAST:event_rbanneeMouseClicked

    private void rbanneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbanneeActionPerformed
       if(this.rbannee.isSelected())
         {
             this.rbmois.setSelected(false);
              this.cbannee.setEnabled(false);
              BarChartPLainteYear();
             
         }
    }//GEN-LAST:event_rbanneeActionPerformed

    private void rbmoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmoisActionPerformed
    if(this.rbmois.isSelected())
         {
             this.rbannee.setSelected(false);
             this.cbannee.setEnabled(true);
             this.cbannee.setSelectedIndex(0);
             LineChartPLainteYearMonth(Integer.parseInt(this.cbannee.getSelectedItem().toString()));
             
         }
    }//GEN-LAST:event_rbmoisActionPerformed

    private void rbmoisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbmoisMouseClicked
          if(this.rbmois.isSelected())
         {
             this.rbannee.setSelected(false);
             this.cbannee.setEnabled(true);
             this.cbannee.setSelectedIndex(0);
             LineChartPLainteYearMonth(Integer.parseInt(this.cbannee.getSelectedItem().toString()));
         }
    }//GEN-LAST:event_rbmoisMouseClicked

    private void cbanneePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbanneePropertyChange
                 
    }//GEN-LAST:event_cbanneePropertyChange

    private void cbanneeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbanneeItemStateChanged
         LineChartPLainteYearMonth(Integer.parseInt(this.cbannee.getSelectedItem().toString()));
    }//GEN-LAST:event_cbanneeItemStateChanged

    private void cbanneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbanneeActionPerformed
         LineChartPLainteYearMonth(Integer.parseInt(this.cbannee.getSelectedItem().toString()));
    }//GEN-LAST:event_cbanneeActionPerformed

    public  void  BarChartPLainteYear()
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ResultSet rs=jdir.dr.gpl.GetPlaintparAnnee();
       
        
     try {
         while(rs.next())
         {  
             System.out.println(rs.getFloat(2)+"Nombre de¨Plaintes"+rs.getString(1));
             dataset.addValue(rs.getFloat(2),"Nombre de Plaintes", rs.getString(1));
         }
             JFreeChart  barchart=ChartFactory.createBarChart("Plaintes  par Annee",  "Année","Nombre de Plaintes", dataset,PlotOrientation.VERTICAL, false, true, false);
             CategoryPlot barchrt=barchart.getCategoryPlot();
             barchrt.setRangeGridlinePaint(Color.ORANGE);
             barchrt.setBackgroundPaint(Color.GRAY);
             ChartPanel chartpanel = new ChartPanel(barchart);
             chartpanel.setPreferredSize(new Dimension(970,330));

              ImageIcon img=new ImageIcon(barchart.createBufferedImage(700, 260));
             
              this.jgraph.setIcon(img);
           
          
            
     } catch (SQLException ex) {
         Logger.getLogger(JGain.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    
        public  void  LineChartPLainteYearMonth(int year)
    {
        TimeSeriesCollection dataset = new TimeSeriesCollection();  
        ResultSet rs=jdir.dr.gpl.GetPlaintParAnneeMois(year);
       
        TimeSeries s1 = new TimeSeries("Nombre de Plaintes");  
         for(int i=1;i<=12;i++)
         {s1.add(new Month(i, year), 0);}
     try {
         while(rs.next())
         {      s1.addOrUpdate(new Month(rs.getInt(1), year), rs.getInt(2));
            
         }
             dataset.addSeries(s1);
             JFreeChart  barchart=ChartFactory.createTimeSeriesChart("Plaintes  par Mois",  "Mois","Nombre de Plaintes", dataset, false, true, false);
//             CategoryPlot barchrt=barchart.getCategoryPlot();
            // barchrt.setRangeGridlinePaint(Color.ORANGE);
            // barchrt.setBackgroundPaint(Color.GRAY);
             ChartPanel chartpanel = new ChartPanel(barchart);
             chartpanel.setPreferredSize(new Dimension(970,330));

              ImageIcon img=new ImageIcon(barchart.createBufferedImage(700, 260));
             
              this.jgraph.setIcon(img);
           
          
            
     } catch (SQLException ex) {
         Logger.getLogger(JGain.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbannee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jgraph;
    private javax.swing.JRadioButton rbannee;
    private javax.swing.JRadioButton rbmois;
    private javax.swing.JTable tableplaintes;
    // End of variables declaration//GEN-END:variables
}