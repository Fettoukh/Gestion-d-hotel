/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Gerant;

import Metiers.*;

import Swing.*;
//import Swing.Receptionniste.JPAccueil;
import Swing.Receptionniste.JPClients;
import Swing.Receptionniste.JPFacture;
import Swing.Receptionniste.JPRecu;
import Swing.Receptionniste.JPReserver;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author amine
 */
public class IHMGerant extends javax.swing.JFrame {

    int xmouse;
    int ymouse;
    Gerant gerant;
    public String cin , login; 
    
    public  GridBagLayout layout =new GridBagLayout();
    public JPchambres JPLChambre;
    public JPEmploye JPLEmploye ;
    public JPPlainte JPLPlainte ;
    public JPClient JPLClient;
   
    static boolean maximized = true ;
    /**
     * Creates new form IHMGerant
     */
    public IHMGerant() {
        initComponents();
        CurrentDate();
        setIcon();
        
        JPLChambre = new JPchambres(this);
        JPLEmploye = new JPEmploye(this);
        JPLPlainte = new JPPlainte(this);
        JPLClient = new JPClient(this);
       
        this.dynamicpanel.setLayout(layout); 
        dynamicAdd(new JPanel[] {JPLChambre,JPLEmploye,JPLPlainte,JPLClient});
        JPLPlainte.setVisible(true);
        visibleFalse(new JPanel[] {JPLChambre,JPLEmploye,JPLClient});
    }
    
   
    public IHMGerant (String Login)
    {
        
        initComponents();
        CurrentDate();
        setIcon();
        this.login = Login ;
        JPLChambre = new JPchambres(this);
        JPLEmploye = new JPEmploye(this);
        JPLPlainte = new JPPlainte(this);
        JPLClient = new JPClient(this);
        this.dynamicpanel.setLayout(layout); 
        dynamicAdd(new JPanel[] {JPLChambre,JPLEmploye,JPLPlainte,JPLClient});
        JPLPlainte.setVisible(true);
        visibleFalse(new JPanel[] {JPLChambre,JPLEmploye,JPLClient});
    }
    
    public void dynamicAdd( JPanel [] p)
    {
        for(int i=0 ; i<p.length ;i++)
        {
            GridBagConstraints c =new GridBagConstraints();
            c.gridx=0;
            c.gridy=0; 
            dynamicpanel.add(p[i] , c );
        }
    }
    
    public void visibleFalse( JPanel [] p)
    {
        for(int i=0 ; i<p.length ;i++)
        {
            p[i].setVisible(false);
        }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icon.png")));
    }
    
    public void CurrentDate()
    {
        java.util.Timer timer = new Timer();
        //Set the schedule function
        timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Magic here
                    Calendar cal=Calendar.getInstance();
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        month++ ;
                        String jour = ""+day ;
                        String mois = ""+month;
        
                        if(day <10)
                        {
                          jour = "0"+day;
                        }
                        if (month <10)
                        {
                        mois = "0"+month;
                        }
        
       
                        setDate.setText("Date : "+jour + "/" + mois + "/" + year );
        
                        int seconde = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int heure = cal.get(Calendar.HOUR);
                        heure++;
                        String sec=""+seconde;
                        String min =""+minute;
                        String hour =""+heure;
                        if(seconde <10)
                        {
                          sec = "0"+seconde;
                        }
                        if(heure <10)
                        {
                          hour = "0"+hour;
                        }
                        if(minute <10)
                        {
                          min = "0"+minute;
                        }
                        
        
                        setTime.setText("Time : " +hour+":"+min+":"+sec );
        
                        if (cal.get(Calendar.AM_PM)==Calendar.PM)
                        {
                            setF.setText("PM");
                        }
                        else{
                            setF.setText("AM");
                        }
                                }
                            },
                0, 1000);
                    }
    
    private void setColorClicked (JPanel p)
    {
        p.setBackground(new Color(255,255,255));
    }
    
    private void setColorEntered (JPanel p)
    {
        p.setBackground(new Color(60,103,164));
    }
    
    private void setColorExited (JPanel p)
    {
        p.setBackground(new Color(73,75,79));
    }
    
    public void resetColor( JPanel [] p)
    {
        for(int i=0 ; i<p.length ;i++)
        {
            p[i].setBackground(new Color (73,75,79) );
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

        leftPanel = new javax.swing.JPanel();
        Pplaintes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        H1 = new javax.swing.JPanel();
        Pemployes = new javax.swing.JPanel();
        H2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Pchambres = new javax.swing.JPanel();
        H3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Pclients = new javax.swing.JPanel();
        H4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Pdeconnexion = new javax.swing.JPanel();
        H5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblProfil = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        H7 = new javax.swing.JPanel();
        dynamicpanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMaximize = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        setDate = new javax.swing.JLabel();
        setTime = new javax.swing.JLabel();
        setF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        leftPanel.setBackground(new java.awt.Color(51, 51, 51));
        leftPanel.setPreferredSize(new java.awt.Dimension(120, 263));

        Pplaintes.setBackground(new java.awt.Color(73, 75, 79));
        Pplaintes.setPreferredSize(new java.awt.Dimension(143, 50));
        Pplaintes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PplaintesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PplaintesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PplaintesMouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PLainte (1).png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(73, 75, 79));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Plaintes");

        H1.setBackground(new java.awt.Color(73, 75, 79));
        H1.setPreferredSize(new java.awt.Dimension(9, 0));

        javax.swing.GroupLayout H1Layout = new javax.swing.GroupLayout(H1);
        H1.setLayout(H1Layout);
        H1Layout.setHorizontalGroup(
            H1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        H1Layout.setVerticalGroup(
            H1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PplaintesLayout = new javax.swing.GroupLayout(Pplaintes);
        Pplaintes.setLayout(PplaintesLayout);
        PplaintesLayout.setHorizontalGroup(
            PplaintesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PplaintesLayout.createSequentialGroup()
                .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        PplaintesLayout.setVerticalGroup(
            PplaintesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
            .addGroup(PplaintesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PplaintesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pemployes.setBackground(new java.awt.Color(73, 75, 79));
        Pemployes.setPreferredSize(new java.awt.Dimension(143, 50));
        Pemployes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PemployesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PemployesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PemployesMouseExited(evt);
            }
        });
        Pemployes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        H2.setBackground(new java.awt.Color(73, 75, 79));
        H2.setPreferredSize(new java.awt.Dimension(9, 0));

        javax.swing.GroupLayout H2Layout = new javax.swing.GroupLayout(H2);
        H2.setLayout(H2Layout);
        H2Layout.setHorizontalGroup(
            H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        H2Layout.setVerticalGroup(
            H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Pemployes.add(H2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employés");
        Pemployes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Personnel1.png"))); // NOI18N
        Pemployes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, -1));

        Pchambres.setBackground(new java.awt.Color(73, 75, 79));
        Pchambres.setPreferredSize(new java.awt.Dimension(143, 50));
        Pchambres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PchambresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PchambresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PchambresMouseExited(evt);
            }
        });
        Pchambres.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        H3.setBackground(new java.awt.Color(73, 75, 79));
        H3.setPreferredSize(new java.awt.Dimension(9, 0));

        javax.swing.GroupLayout H3Layout = new javax.swing.GroupLayout(H3);
        H3.setLayout(H3Layout);
        H3Layout.setHorizontalGroup(
            H3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        H3Layout.setVerticalGroup(
            H3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Pchambres.add(H3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Chambres");
        Pchambres.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Chambre.png"))); // NOI18N
        Pchambres.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Pclients.setBackground(new java.awt.Color(73, 75, 79));
        Pclients.setPreferredSize(new java.awt.Dimension(143, 50));
        Pclients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PclientsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PclientsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PclientsMouseExited(evt);
            }
        });
        Pclients.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        H4.setBackground(new java.awt.Color(73, 75, 79));
        H4.setPreferredSize(new java.awt.Dimension(9, 0));

        javax.swing.GroupLayout H4Layout = new javax.swing.GroupLayout(H4);
        H4.setLayout(H4Layout);
        H4Layout.setHorizontalGroup(
            H4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        H4Layout.setVerticalGroup(
            H4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Pclients.add(H4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 52));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clients");
        Pclients.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Client logo.png"))); // NOI18N
        Pclients.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Pdeconnexion.setBackground(new java.awt.Color(73, 75, 79));
        Pdeconnexion.setPreferredSize(new java.awt.Dimension(143, 50));
        Pdeconnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PdeconnexionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PdeconnexionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PdeconnexionMouseExited(evt);
            }
        });

        H5.setBackground(new java.awt.Color(73, 75, 79));
        H5.setPreferredSize(new java.awt.Dimension(9, 0));

        javax.swing.GroupLayout H5Layout = new javax.swing.GroupLayout(H5);
        H5.setLayout(H5Layout);
        H5Layout.setHorizontalGroup(
            H5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        H5Layout.setVerticalGroup(
            H5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Deconnexion.png"))); // NOI18N

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Déconnexion");

        javax.swing.GroupLayout PdeconnexionLayout = new javax.swing.GroupLayout(Pdeconnexion);
        Pdeconnexion.setLayout(PdeconnexionLayout);
        PdeconnexionLayout.setHorizontalGroup(
            PdeconnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PdeconnexionLayout.createSequentialGroup()
                .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PdeconnexionLayout.setVerticalGroup(
            PdeconnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(PdeconnexionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(PdeconnexionLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gerant");

        lblProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Directeur.png"))); // NOI18N
        lblProfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblProfilMouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo1.png"))); // NOI18N

        H7.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout H7Layout = new javax.swing.GroupLayout(H7);
        H7.setLayout(H7Layout);
        H7Layout.setHorizontalGroup(
            H7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        H7Layout.setVerticalGroup(
            H7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pplaintes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Pdeconnexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pemployes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pclients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pchambres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel9))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(leftPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProfil))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(87, 87, 87)
                .addComponent(Pplaintes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pemployes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pchambres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pclients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pdeconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dynamicpanelLayout = new javax.swing.GroupLayout(dynamicpanel);
        dynamicpanel.setLayout(dynamicpanelLayout);
        dynamicpanelLayout.setHorizontalGroup(
            dynamicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 847, Short.MAX_VALUE)
        );
        dynamicpanelLayout.setVerticalGroup(
            dynamicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );

        topPanel.setBackground(new java.awt.Color(73, 75, 79));
        topPanel.setPreferredSize(new java.awt.Dimension(146, 32));
        topPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanelMouseDragged(evt);
            }
        });
        topPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topPanelMousePressed(evt);
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

        setDate.setForeground(new java.awt.Color(255, 255, 255));
        setDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        setTime.setForeground(new java.awt.Color(255, 255, 255));

        setF.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addComponent(setDate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setTime, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(setF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
                .addComponent(btnMinimize)
                .addGap(0, 0, 0)
                .addComponent(btnMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMaximize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(dynamicpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dynamicpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PplaintesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PplaintesMouseClicked
        // TODO add your handling code here:
        JPLPlainte.setVisible(true);
        visibleFalse(new JPanel[] {JPLEmploye,JPLChambre,JPLClient});
        setColorClicked(H1);
        resetColor(new JPanel[] {H2,H3,H4,H5});
    }//GEN-LAST:event_PplaintesMouseClicked

    private void PplaintesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PplaintesMouseEntered
        // TODO add your handling code here:
        setColorEntered(Pplaintes);
    }//GEN-LAST:event_PplaintesMouseEntered

    private void PplaintesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PplaintesMouseExited
        // TODO add your handling code here:
        setColorExited(Pplaintes);
    }//GEN-LAST:event_PplaintesMouseExited

    private void PemployesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PemployesMouseClicked
        // TODO add your handling code here:
        JPLEmploye.setVisible(true);
        visibleFalse(new JPanel[] {JPLPlainte,JPLChambre,JPLClient});
        setColorClicked(H2);
        resetColor(new JPanel[] {H1,H3,H4,H5});
    }//GEN-LAST:event_PemployesMouseClicked

    private void PemployesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PemployesMouseEntered
        // TODO add your handling code here:
        setColorEntered(Pemployes);
    }//GEN-LAST:event_PemployesMouseEntered

    private void PemployesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PemployesMouseExited
        // TODO add your handling code here:
        setColorExited(Pemployes);
    }//GEN-LAST:event_PemployesMouseExited

    private void PclientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PclientsMouseClicked
        // TODO add your handling code here:
        JPLClient.setVisible(true);
        visibleFalse(new JPanel[] {JPLPlainte,JPLEmploye,JPLChambre});
        setColorClicked(H4);
        resetColor(new JPanel[] {H1,H2,H3,H5});
    }//GEN-LAST:event_PclientsMouseClicked

    private void PclientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PclientsMouseEntered
        // TODO add your handling code here:
        setColorEntered(Pclients);
    }//GEN-LAST:event_PclientsMouseEntered

    private void PclientsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PclientsMouseExited
        // TODO add your handling code here:
        setColorExited(Pclients);
    }//GEN-LAST:event_PclientsMouseExited

    private void PdeconnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PdeconnexionMouseClicked
        // TODO add your handling code here:
        setColorClicked(H5);
        resetColor(new JPanel[] {H1,H2,H3,H4});
        new IHMLoginPersonnel().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PdeconnexionMouseClicked

    private void PdeconnexionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PdeconnexionMouseEntered
        // TODO add your handling code here:
        setColorEntered(Pdeconnexion);
    }//GEN-LAST:event_PdeconnexionMouseEntered

    private void PdeconnexionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PdeconnexionMouseExited
        // TODO add your handling code here:
        setColorExited(Pdeconnexion);
    }//GEN-LAST:event_PdeconnexionMouseExited

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
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
            IHMGerant.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            IHMGerant.this.setMaximizedBounds(env.getMaximumWindowBounds());
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

    private void topPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xmouse, y - ymouse);
        //System.out.println(x+","+y);
    }//GEN-LAST:event_topPanelMouseDragged

    private void topPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMousePressed
        // TODO add your handling code here:
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_topPanelMousePressed

    private void PchambresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PchambresMouseClicked
        // TODO add your handling code here:
        JPLChambre.setVisible(true);
        visibleFalse(new JPanel[] {JPLPlainte,JPLEmploye,JPLClient});
        setColorClicked(H3);
        resetColor(new JPanel[] {H1,H2,H4,H5});
    }//GEN-LAST:event_PchambresMouseClicked

    private void PchambresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PchambresMouseEntered
        // TODO add your handling code here:
        setColorEntered(Pchambres);
    }//GEN-LAST:event_PchambresMouseEntered

    private void PchambresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PchambresMouseExited
        // TODO add your handling code here:
        setColorExited(Pchambres);
    }//GEN-LAST:event_PchambresMouseExited

    private void lblProfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfilMouseClicked
        // TODO add your handling code here:
        new JFProfil().setVisible(true);
        
    }//GEN-LAST:event_lblProfilMouseClicked

    private void lblProfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfilMouseEntered
        // TODO add your handling code here:
        setColorEntered(H7);
    }//GEN-LAST:event_lblProfilMouseEntered

    private void lblProfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfilMouseExited
        // TODO add your handling code here:
        H7.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblProfilMouseExited

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
            java.util.logging.Logger.getLogger(IHMGerant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHMGerant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHMGerant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHMGerant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHMGerant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel H1;
    private javax.swing.JPanel H2;
    private javax.swing.JPanel H3;
    private javax.swing.JPanel H4;
    private javax.swing.JPanel H5;
    private javax.swing.JPanel H7;
    private javax.swing.JPanel Pchambres;
    private javax.swing.JPanel Pclients;
    private javax.swing.JPanel Pdeconnexion;
    private javax.swing.JPanel Pemployes;
    private javax.swing.JPanel Pplaintes;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMaximize;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JPanel dynamicpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblProfil;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel setDate;
    private javax.swing.JLabel setF;
    private javax.swing.JLabel setTime;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
