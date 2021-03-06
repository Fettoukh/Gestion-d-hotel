/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Receptionniste;

import Metiers.GestionComptePersonnel;
import Swing.*;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author amine
 */
public class IHMReceptionniste extends javax.swing.JFrame {

    GestionComptePersonnel Gcp = new GestionComptePersonnel();
    public  GridBagLayout layout =new GridBagLayout();
    public JPAccueil JPLAccueil ;
    public JPReserver JPLReserver ;
    public JPRecu JPLRecu ;
    public JPClients JPLCl ;
    public JPFacture JPLFacture;
    public String cin; 
    
    //________________________________
    int xmouse;
    int ymouse;
    static boolean maximized = true ;
    /**
     * Creates new form IHMReceptionniste
     */
    public IHMReceptionniste() {

        initComponents();
        CurrentDate();
        setIcon();
        setColorClicked(H1);
        
        JPLAccueil=new JPAccueil(this);
        JPLReserver = new JPReserver(this);
        JPLRecu = new JPRecu(this);
        JPLCl = new JPClients(this);
        JPLFacture = new JPFacture(this);
        this.dynamicpanel.setLayout(layout); 
        dynamicAdd(new JPanel[] {JPLAccueil ,JPLReserver,JPLRecu,JPLCl,JPLFacture});
        JPLAccueil.setVisible(true);
        visibleFalse(new JPanel[] {JPLReserver,JPLRecu,JPLCl,JPLFacture});
    }
    
    public IHMReceptionniste(String Login)
    {
        initComponents();
        CurrentDate();
        setIcon();
        setColorClicked(H1);
        cin = Gcp.Cin_Personnel(Login);
        
        JPLAccueil=new JPAccueil(this);
        JPLReserver = new JPReserver(this);
        JPLRecu = new JPRecu(this);
        JPLCl = new JPClients(this);
        JPLFacture = new JPFacture(this);
        this.dynamicpanel.setLayout(layout); 
        dynamicAdd(new JPanel[] {JPLAccueil ,JPLReserver,JPLRecu,JPLCl,JPLFacture});
        JPLAccueil.setVisible(true);
        visibleFalse(new JPanel[] {JPLReserver,JPLRecu,JPLCl,JPLFacture});
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
        PAccueil = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        H1 = new javax.swing.JPanel();
        PReserver = new javax.swing.JPanel();
        H2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Pdeconnexion = new javax.swing.JPanel();
        H4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblProfil = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        PFacture = new javax.swing.JPanel();
        H5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        PClient = new javax.swing.JPanel();
        H6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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

        PAccueil.setBackground(new java.awt.Color(73, 75, 79));
        PAccueil.setPreferredSize(new java.awt.Dimension(143, 50));
        PAccueil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PAccueilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PAccueilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PAccueilMouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Accueil logo.png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(73, 75, 79));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Accueil");

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

        javax.swing.GroupLayout PAccueilLayout = new javax.swing.GroupLayout(PAccueil);
        PAccueil.setLayout(PAccueilLayout);
        PAccueilLayout.setHorizontalGroup(
            PAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAccueilLayout.createSequentialGroup()
                .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        PAccueilLayout.setVerticalGroup(
            PAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(PAccueilLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAccueilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(17, 17, 17))
        );

        PReserver.setBackground(new java.awt.Color(73, 75, 79));
        PReserver.setPreferredSize(new java.awt.Dimension(143, 50));
        PReserver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PReserverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PReserverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PReserverMouseExited(evt);
            }
        });

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
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Réservation");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Reserver logo.png"))); // NOI18N

        javax.swing.GroupLayout PReserverLayout = new javax.swing.GroupLayout(PReserver);
        PReserver.setLayout(PReserverLayout);
        PReserverLayout.setHorizontalGroup(
            PReserverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PReserverLayout.createSequentialGroup()
                .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );
        PReserverLayout.setVerticalGroup(
            PReserverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(PReserverLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3))
            .addGroup(PReserverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5))
        );

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Deconnexion.png"))); // NOI18N

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Déconnexion");

        javax.swing.GroupLayout PdeconnexionLayout = new javax.swing.GroupLayout(Pdeconnexion);
        Pdeconnexion.setLayout(PdeconnexionLayout);
        PdeconnexionLayout.setHorizontalGroup(
            PdeconnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PdeconnexionLayout.createSequentialGroup()
                .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PdeconnexionLayout.setVerticalGroup(
            PdeconnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H4, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
            .addGroup(PdeconnexionLayout.createSequentialGroup()
                .addGroup(PdeconnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PdeconnexionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(PdeconnexionLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Receptionniste");

        lblProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Receptionniste2.png"))); // NOI18N
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

        PFacture.setBackground(new java.awt.Color(73, 75, 79));
        PFacture.setPreferredSize(new java.awt.Dimension(143, 50));
        PFacture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PFactureMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PFactureMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PFactureMouseExited(evt);
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
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Facture");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Facture.png"))); // NOI18N

        javax.swing.GroupLayout PFactureLayout = new javax.swing.GroupLayout(PFacture);
        PFacture.setLayout(PFactureLayout);
        PFactureLayout.setHorizontalGroup(
            PFactureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PFactureLayout.createSequentialGroup()
                .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        PFactureLayout.setVerticalGroup(
            PFactureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(PFactureLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel11))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PFactureLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(14, 14, 14))
        );

        PClient.setBackground(new java.awt.Color(73, 75, 79));
        PClient.setPreferredSize(new java.awt.Dimension(143, 50));
        PClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PClientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PClientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PClientMouseExited(evt);
            }
        });

        H6.setBackground(new java.awt.Color(73, 75, 79));
        H6.setPreferredSize(new java.awt.Dimension(9, 0));

        javax.swing.GroupLayout H6Layout = new javax.swing.GroupLayout(H6);
        H6.setLayout(H6Layout);
        H6Layout.setHorizontalGroup(
            H6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        H6Layout.setVerticalGroup(
            H6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Clients");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Client logo.png"))); // NOI18N

        javax.swing.GroupLayout PClientLayout = new javax.swing.GroupLayout(PClient);
        PClient.setLayout(PClientLayout);
        PClientLayout.setHorizontalGroup(
            PClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PClientLayout.createSequentialGroup()
                .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        PClientLayout.setVerticalGroup(
            PClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(PClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15))
            .addGroup(PClientLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14))
        );

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
            .addComponent(PAccueil, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pdeconnexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PReserver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(leftPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblProfil)
                                        .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(leftPanelLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel9)))))
                            .addComponent(PFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(PAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PReserver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pdeconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dynamicpanelLayout = new javax.swing.GroupLayout(dynamicpanel);
        dynamicpanel.setLayout(dynamicpanelLayout);
        dynamicpanelLayout.setHorizontalGroup(
            dynamicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dynamicpanelLayout.setVerticalGroup(
            dynamicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(dynamicpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dynamicpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PAccueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAccueilMouseClicked
        // TODO add your handling code here:
        JPLAccueil.setVisible(true);
        visibleFalse(new JPanel[] {JPLReserver,JPLRecu,JPLCl,JPLFacture});
        JPLAccueil.vider();
//        JPLReserver.setVisible(false);
//        JPLRecu.setVisible(false);
//        JPLCl.setVisible(false);
        setColorClicked(H1);
        resetColor(new JPanel[] {H2,H4,H5,H6});
    }//GEN-LAST:event_PAccueilMouseClicked

    private void PAccueilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAccueilMouseEntered
        // TODO add your handling code here:
        setColorEntered(PAccueil);
    }//GEN-LAST:event_PAccueilMouseEntered

    private void PAccueilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAccueilMouseExited
        // TODO add your handling code here:
        setColorExited(PAccueil);
    }//GEN-LAST:event_PAccueilMouseExited

    private void PReserverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PReserverMouseClicked
        // TODO add your handling code here:
        JPLReserver.setVisible(true);
        JPLReserver.vider();
        visibleFalse(new JPanel[] {JPLAccueil,JPLRecu,JPLCl,JPLFacture});
        setColorClicked(H2);
        resetColor(new JPanel[] {H1,H4,H5,H6});
    }//GEN-LAST:event_PReserverMouseClicked

    private void PReserverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PReserverMouseEntered
        // TODO add your handling code here:
        setColorEntered(PReserver);
    }//GEN-LAST:event_PReserverMouseEntered

    private void PReserverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PReserverMouseExited
        // TODO add your handling code here:
        setColorExited(PReserver);
    }//GEN-LAST:event_PReserverMouseExited

    private void PdeconnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PdeconnexionMouseClicked
        // TODO add your handling code here:
        setColorClicked(H4);
        resetColor(new JPanel[] {H1,H2,H5,H6});
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
            IHMReceptionniste.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            IHMReceptionniste.this.setMaximizedBounds(env.getMaximumWindowBounds());
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

    private void PFactureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PFactureMouseClicked
        // TODO add your handling code here:
        JPLFacture.setVisible(true);
        JPLFacture.Vider();
        visibleFalse(new JPanel[] {JPLAccueil,JPLRecu,JPLCl,JPLReserver});       
        setColorClicked(H5);
        resetColor(new JPanel[] {H1,H2,H4,H6});
    }//GEN-LAST:event_PFactureMouseClicked

    private void PFactureMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PFactureMouseEntered
        // TODO add your handling code here:
        setColorEntered(PFacture);
    }//GEN-LAST:event_PFactureMouseEntered

    private void PFactureMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PFactureMouseExited
        // TODO add your handling code here:
        setColorExited(PFacture);
    }//GEN-LAST:event_PFactureMouseExited

    private void PClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PClientMouseClicked
        // TODO add your handling code here:
        JPLCl.setVisible(true);
        JPLCl.Vider();
        visibleFalse(new JPanel[] {JPLAccueil,JPLRecu,JPLReserver,JPLFacture});
        setColorClicked(H6);
        resetColor(new JPanel[] {H1,H2,H4,H5});
    }//GEN-LAST:event_PClientMouseClicked

    private void PClientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PClientMouseEntered
        // TODO add your handling code here:
        setColorEntered(PClient);
    }//GEN-LAST:event_PClientMouseEntered

    private void PClientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PClientMouseExited
        // TODO add your handling code here:
        setColorExited(PClient);
    }//GEN-LAST:event_PClientMouseExited

    private void lblProfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfilMouseEntered
        // TODO add your handling code here:
        setColorEntered(H7);
    }//GEN-LAST:event_lblProfilMouseEntered

    private void lblProfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfilMouseExited
        // TODO add your handling code here:
        H7.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblProfilMouseExited

    private void lblProfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfilMouseClicked
        // TODO add your handling code here:
        new JFProfil(cin).setVisible(true);
        
    }//GEN-LAST:event_lblProfilMouseClicked

    public void passageFacture()
    {
        setColorClicked(H5);
        resetColor(new JPanel[] {H1,H2,H4,H6});
    }
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
            java.util.logging.Logger.getLogger(IHMReceptionniste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHMReceptionniste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHMReceptionniste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHMReceptionniste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHMReceptionniste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel H1;
    private javax.swing.JPanel H2;
    private javax.swing.JPanel H4;
    private javax.swing.JPanel H5;
    private javax.swing.JPanel H6;
    private javax.swing.JPanel H7;
    private javax.swing.JPanel PAccueil;
    private javax.swing.JPanel PClient;
    private javax.swing.JPanel PFacture;
    private javax.swing.JPanel PReserver;
    private javax.swing.JPanel Pdeconnexion;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMaximize;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JPanel dynamicpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblProfil;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel setDate;
    private javax.swing.JLabel setF;
    private javax.swing.JLabel setTime;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
