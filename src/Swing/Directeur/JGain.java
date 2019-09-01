/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Directeur;


import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author omar
 */
public class JGain extends javax.swing.JPanel {

 IHMDirecteur jdir;
    /**
     * Creates new form Statistiques
     */
    public JGain() {
        initComponents();
        refresh();
    }

  public void    refresh()
    {
        
         BarChartYearGainReserv();
         BarChartYearGainService();
         Vector<String> VCBanneeService=this.jdir.dr.gs.getanneeDemande();
         Vector<String> VCBanneeReservation=this.jdir.dr.gr.getAnneeReservations();
         DefaultComboBoxModel dfs  = new DefaultComboBoxModel(VCBanneeService);
         DefaultComboBoxModel dfr  = new DefaultComboBoxModel(VCBanneeReservation);
         this.cbanneeR.setModel(dfr);
         this.cbanneeS.setModel(dfs);
         this.rbanneeR.setSelected(true);
         this.rbanneeS.setSelected(true);
        
         
    }
    public  void  BarChartYearGainReserv()
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ResultSet rs=jdir.dr.gr.GetGainReservYear();
       
        
     try {
         while(rs.next())
         {  
             System.out.println(rs.getFloat(2)+"Gain"+rs.getString(1));
             dataset.addValue(rs.getFloat(2),"Gain", rs.getString(1));
         }
             JFreeChart  barchart=ChartFactory.createBarChart("Gain Par Anneé Des Reservations ",  "Année","Gain", dataset,PlotOrientation.VERTICAL, false, true, false);
            /*CategoryPlot barchrt=barchart.getCategoryPlot();
             barchrt.setRangeGridlinePaint(Color.ORANGE);
             ChartPanel chartpanel = new ChartPanel(barchart);
             chartpanel.setPreferredSize(new Dimension(400, 400));*/

              ImageIcon img=new ImageIcon(barchart.createBufferedImage(800, 260));
             
              this.jchartReservation.setIcon(img);
           
          
            
     } catch (SQLException ex) {
         Logger.getLogger(JGain.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    public  void  BarChartYearGainService()
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ResultSet rs=jdir.dr.gs.GetServiceAnnee();
       
        
     try {
         while(rs.next())
         {  
             dataset.addValue(rs.getFloat(2),"Gain", rs.getString(1));
         }
             JFreeChart  barchart=ChartFactory.createBarChart("Gain par annee des services ",  "Année","Gain", dataset,PlotOrientation.VERTICAL, false, true, false);
             CategoryPlot barchrt=barchart.getCategoryPlot();
             barchrt.setRangeGridlinePaint(Color.BLUE);
               ((BarRenderer)barchrt.getRenderer()).setBarPainter(new StandardBarPainter());

           BarRenderer r = (BarRenderer)barchart.getCategoryPlot().getRenderer();
           r.setSeriesPaint(0, Color.blue);
             
            /* ChartPanel chartpanel = new ChartPanel(barchart);
             chartpanel.setPreferredSize(new Dimension(400, 400)); */

              ImageIcon img=new ImageIcon(barchart.createBufferedImage(800, 260));
              this.jchartService.setIcon(img);
            
             
     
              
            
     } catch (SQLException ex) {
         Logger.getLogger(JGain.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    
    
    
        public  void  LineChartServiceYearMonth(int year)
    {
        TimeSeriesCollection dataset = new TimeSeriesCollection();  
        ResultSet rs=jdir.dr.gs.GetServiceMois(year);
       
        TimeSeries s1 = new TimeSeries("Gain");  
         for(int i=1;i<=12;i++)
         {s1.add(new Month(i, year), 0);}
     try {
         while(rs.next())
         {      s1.addOrUpdate(new Month(rs.getInt(1), year), rs.getInt(2));
            
         }
             dataset.addSeries(s1);
             JFreeChart  linechart=ChartFactory.createTimeSeriesChart("Gain par mois \n dans l'annnee  "+year+"  des services ",  "Mois","Les Gain(DH)", dataset, false, true, false);     
             

              ImageIcon img=new ImageIcon(linechart.createBufferedImage(800, 260));
             
              this.jchartService.setIcon(img);
           
          
            
     } catch (SQLException ex) {
         Logger.getLogger(JGain.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
        
               public  void  LineChartReservationYearMonth(int year)
    {
        TimeSeriesCollection dataset = new TimeSeriesCollection();  
        ResultSet rs=jdir.dr.gr.GetGainReservAnneeMois(year);
       
        TimeSeries s1 = new TimeSeries("Gain");  
         for(int i=1;i<=12;i++)
         {s1.add(new Month(i, year), 0);}
     try {
         while(rs.next())
         {      s1.addOrUpdate(new Month(rs.getInt(1), year), rs.getInt(2));
            
         }
             dataset.addSeries(s1);
             JFreeChart  linechart=ChartFactory.createTimeSeriesChart("Gain par mois \n dans l'annnee  "+year+"  des reservations",  "Mois","Les Gain(DH)", dataset, false, true, false);     
             

              ImageIcon img=new ImageIcon(linechart.createBufferedImage(800, 260));
             
              this.jchartReservation.setIcon(img);
           
          
            
     } catch (SQLException ex) {
         Logger.getLogger(JGain.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
        
    JGain(IHMDirecteur jdir) {
        this.jdir=jdir;
        initComponents();
        
        refresh();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jchartService = new javax.swing.JLabel();
        jchartReservation = new javax.swing.JLabel();
        rbanneeS = new javax.swing.JRadioButton();
        rbmoisS = new javax.swing.JRadioButton();
        cbanneeS = new javax.swing.JComboBox<>();
        rbanneeR = new javax.swing.JRadioButton();
        rbmoisR = new javax.swing.JRadioButton();
        cbanneeR = new javax.swing.JComboBox<>();

        jchartService.setBackground(new java.awt.Color(255, 255, 255));

        rbanneeS.setText("Par année");
        rbanneeS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbanneeSMouseClicked(evt);
            }
        });
        rbanneeS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbanneeSActionPerformed(evt);
            }
        });

        rbmoisS.setText("Par mois");
        rbmoisS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbmoisSMouseClicked(evt);
            }
        });
        rbmoisS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmoisSActionPerformed(evt);
            }
        });

        cbanneeS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbanneeS.setEnabled(false);
        cbanneeS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbanneeSItemStateChanged(evt);
            }
        });
        cbanneeS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbanneeSActionPerformed(evt);
            }
        });
        cbanneeS.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbanneeSPropertyChange(evt);
            }
        });

        rbanneeR.setText("Par année");
        rbanneeR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbanneeRMouseClicked(evt);
            }
        });
        rbanneeR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbanneeRActionPerformed(evt);
            }
        });

        rbmoisR.setText("Par mois");
        rbmoisR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbmoisRMouseClicked(evt);
            }
        });
        rbmoisR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmoisRActionPerformed(evt);
            }
        });

        cbanneeR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbanneeR.setEnabled(false);
        cbanneeR.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbanneeRItemStateChanged(evt);
            }
        });
        cbanneeR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbanneeRActionPerformed(evt);
            }
        });
        cbanneeR.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbanneeRPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(rbanneeR)
                        .addGap(78, 78, 78)
                        .addComponent(rbmoisR)
                        .addGap(27, 27, 27)
                        .addComponent(cbanneeR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(rbanneeS)
                        .addGap(59, 59, 59)
                        .addComponent(rbmoisS)
                        .addGap(46, 46, 46)
                        .addComponent(cbanneeS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jchartReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchartService, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbanneeR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbmoisR)
                    .addComponent(rbanneeR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchartReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbanneeS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbmoisS)
                    .addComponent(rbanneeS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchartService, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbanneeSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbanneeSMouseClicked
        if(this.rbanneeS.isSelected())
        {
            this.rbmoisS.setSelected(false);
            this.cbanneeS.setEnabled(false);
           this.BarChartYearGainService();

        }
    }//GEN-LAST:event_rbanneeSMouseClicked

    private void rbanneeSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbanneeSActionPerformed
        if(this.rbanneeS.isSelected())
        {
            this.rbmoisS.setSelected(false);
            this.cbanneeS.setEnabled(false);
            this.BarChartYearGainService();

        }
    }//GEN-LAST:event_rbanneeSActionPerformed

    private void rbmoisSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbmoisSMouseClicked
        if(this.rbmoisS.isSelected())
        {
            this.rbanneeS.setSelected(false);
            this.cbanneeS.setEnabled(true);
            this.cbanneeS.setSelectedIndex(0);
           this.LineChartServiceYearMonth(Integer.parseInt(this.cbanneeS.getSelectedItem().toString()));

        }
    }//GEN-LAST:event_rbmoisSMouseClicked

    private void rbmoisSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmoisSActionPerformed
        if(this.rbmoisS.isSelected())
        {
            this.rbanneeS.setSelected(false);
            this.cbanneeS.setEnabled(true);
            this.cbanneeS.setSelectedIndex(0);
           this.LineChartServiceYearMonth(Integer.parseInt(this.cbanneeS.getSelectedItem().toString()));

        }
    }//GEN-LAST:event_rbmoisSActionPerformed

    private void cbanneeSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbanneeSItemStateChanged
  this.LineChartServiceYearMonth(Integer.parseInt(this.cbanneeS.getSelectedItem().toString()));
    }//GEN-LAST:event_cbanneeSItemStateChanged

    private void cbanneeSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbanneeSActionPerformed
   this.LineChartServiceYearMonth(Integer.parseInt(this.cbanneeS.getSelectedItem().toString()));
    }//GEN-LAST:event_cbanneeSActionPerformed

    private void cbanneeSPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbanneeSPropertyChange

    }//GEN-LAST:event_cbanneeSPropertyChange

    private void rbanneeRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbanneeRMouseClicked
      if(this.rbanneeR.isSelected())
        {
            this.rbmoisR.setSelected(false);
            this.cbanneeR.setEnabled(false);
           this.BarChartYearGainReserv();

        }
    }//GEN-LAST:event_rbanneeRMouseClicked

    private void rbanneeRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbanneeRActionPerformed
        if(this.rbanneeR.isSelected())
        {
            this.rbmoisR.setSelected(false);
            this.cbanneeR.setEnabled(false);
          this.BarChartYearGainReserv();

        }
    }//GEN-LAST:event_rbanneeRActionPerformed

    private void rbmoisRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbmoisRMouseClicked
if(this.rbmoisR.isSelected())
        {
            this.rbanneeR.setSelected(false);
            this.cbanneeR.setEnabled(true);
            this.cbanneeR.setSelectedIndex(0);
            this.LineChartReservationYearMonth(Integer.parseInt(this.cbanneeR.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_rbmoisRMouseClicked

    private void rbmoisRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmoisRActionPerformed
        if(this.rbmoisR.isSelected())
        {
            this.rbanneeR.setSelected(false);
            this.cbanneeR.setEnabled(true);
            this.cbanneeR.setSelectedIndex(0);
            this.LineChartReservationYearMonth(Integer.parseInt(this.cbanneeR.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_rbmoisRActionPerformed

    private void cbanneeRItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbanneeRItemStateChanged
      this.LineChartReservationYearMonth(Integer.parseInt(this.cbanneeR.getSelectedItem().toString()));
    }//GEN-LAST:event_cbanneeRItemStateChanged

    private void cbanneeRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbanneeRActionPerformed
         this.LineChartReservationYearMonth(Integer.parseInt(this.cbanneeR.getSelectedItem().toString()));
    }//GEN-LAST:event_cbanneeRActionPerformed

    private void cbanneeRPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbanneeRPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbanneeRPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbanneeR;
    private javax.swing.JComboBox<String> cbanneeS;
    private javax.swing.JLabel jchartReservation;
    private javax.swing.JLabel jchartService;
    private javax.swing.JRadioButton rbanneeR;
    private javax.swing.JRadioButton rbanneeS;
    private javax.swing.JRadioButton rbmoisR;
    private javax.swing.JRadioButton rbmoisS;
    // End of variables declaration//GEN-END:variables
}
