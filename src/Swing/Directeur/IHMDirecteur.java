/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Directeur;

import Metiers.Directeur;
import Swing.IHMLoginPersonnel;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author omar
 */
public class IHMDirecteur extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
  
    public  GridBagLayout layout =new GridBagLayout();
    int xmouse;
    int ymouse;
    static boolean maximized = true ;
    public Directeur dr;
    public JPersonnel  jp;
    public JServices  js;
    public JGain  jst;
    public Jprofil  jpr;
    public JPlaintes jpl;
    public IHMDirecteur() {
        
        initComponents();
        CurrentDate();
        setIcon();
    }
    
    public IHMDirecteur (ResultSet rs)
    { 
        dr=new Directeur(rs);
        initComponents();
        CurrentDate();
        setIcon();
        jp=new JPersonnel(this);
        js=new JServices(this);
        jst=new JGain(this);
        jpr=new Jprofil(this);
        jpl=new JPlaintes(this);
        
        this.dynamicpanel.setLayout(layout);
        GridBagConstraints c =new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;  
        dynamicpanel.add(jp,c);
        dynamicpanel.add(js,c);
        dynamicpanel.add(jst,c);
        dynamicpanel.add(jst,c);
        dynamicpanel.add(jpr,c);
        dynamicpanel.add(jpl,c);
        jst.setVisible(true);
        js.setVisible(false);
        jp.setVisible(false);
        jpr.setVisible(false);
        jpl.setVisible(false);
        
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
    
    //_______________________________________First Attempt_________________________________________________________
    
    public void CurrentDate1()
    {
        
        
        Thread clock = new Thread(){
            public void run(){
                for(;;){
                        Calendar cal=Calendar.getInstance();;
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
        
        setTime.setText("Time : " +heure+1+":"+minute+":"+seconde );
        
        if (cal.get(Calendar.AM_PM)==Calendar.PM)
        {
            setF.setText("PM");
        }
        else{
            setF.setText("AM");
        }
                   try { 
                        sleep(1000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(IHMDirecteur.class.getName()).log(Level.SEVERE, null, ex);
                   }
                    
                }
                   
            }
        };
        clock.start();
                    
    }
    
    //____________________________________________________________________________________________________________________
    
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

        topPanel = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMaximize = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        setDate = new javax.swing.JLabel();
        setTime = new javax.swing.JLabel();
        setF = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        Pstats = new javax.swing.JPanel();
        H1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pservices = new javax.swing.JPanel();
        H2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ppersonnel = new javax.swing.JPanel();
        H3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Pdeconnexion = new javax.swing.JPanel();
        H4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pplaintes = new javax.swing.JPanel();
        H6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pprofil = new javax.swing.JPanel();
        H5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dynamicpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 600));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
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

        leftPanel.setBackground(new java.awt.Color(51, 51, 51));
        leftPanel.setPreferredSize(new java.awt.Dimension(120, 263));

        Pstats.setBackground(new java.awt.Color(73, 75, 79));
        Pstats.setPreferredSize(new java.awt.Dimension(143, 50));
        Pstats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PstatsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PstatsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PstatsMouseExited(evt);
            }
        });
        Pstats.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        H1.setBackground(new java.awt.Color(255, 255, 255));
        H1.setForeground(new java.awt.Color(255, 255, 255));
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

        Pstats.add(H1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 55));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Gains.png"))); // NOI18N
        Pstats.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 50));

        jLabel1.setBackground(new java.awt.Color(73, 75, 79));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gain");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Pstats.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 10, 50, 30));

        pservices.setBackground(new java.awt.Color(73, 75, 79));
        pservices.setPreferredSize(new java.awt.Dimension(143, 50));
        pservices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pservicesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pservicesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pservicesMouseExited(evt);
            }
        });
        pservices.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pservices.add(H2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Services");
        pservices.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/roomservice.png"))); // NOI18N
        pservices.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 50));

        ppersonnel.setBackground(new java.awt.Color(73, 75, 79));
        ppersonnel.setPreferredSize(new java.awt.Dimension(143, 50));
        ppersonnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ppersonnelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ppersonnelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ppersonnelMouseExited(evt);
            }
        });
        ppersonnel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        ppersonnel.add(H3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 52));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Personnel");
        ppersonnel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 16, -1, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Personnel1.png"))); // NOI18N
        ppersonnel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 50));

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

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Deconnexion.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Déconnexion");

        javax.swing.GroupLayout PdeconnexionLayout = new javax.swing.GroupLayout(Pdeconnexion);
        Pdeconnexion.setLayout(PdeconnexionLayout);
        PdeconnexionLayout.setHorizontalGroup(
            PdeconnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PdeconnexionLayout.createSequentialGroup()
                .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PdeconnexionLayout.setVerticalGroup(
            PdeconnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H4, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
            .addGroup(PdeconnexionLayout.createSequentialGroup()
                .addGroup(PdeconnexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PdeconnexionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Directeur");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Directeur.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo1.png"))); // NOI18N

        pplaintes.setBackground(new java.awt.Color(73, 75, 79));
        pplaintes.setPreferredSize(new java.awt.Dimension(143, 50));
        pplaintes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pplaintesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pplaintesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pplaintesMouseExited(evt);
            }
        });
        pplaintes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        H6.setBackground(new java.awt.Color(73, 75, 79));
        H6.setPreferredSize(new java.awt.Dimension(9, 0));

        javax.swing.GroupLayout H6Layout = new javax.swing.GroupLayout(H6);
        H6.setLayout(H6Layout);
        H6Layout.setHorizontalGroup(
            H6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        H6Layout.setVerticalGroup(
            H6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pplaintes.add(H6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 52));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Plaintes");
        pplaintes.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PLainte (1).png"))); // NOI18N
        pplaintes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 50));

        pprofil.setBackground(new java.awt.Color(73, 75, 79));
        pprofil.setPreferredSize(new java.awt.Dimension(143, 50));
        pprofil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pprofilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pprofilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pprofilMouseExited(evt);
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

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profil.png"))); // NOI18N

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mon Profil");

        javax.swing.GroupLayout pprofilLayout = new javax.swing.GroupLayout(pprofil);
        pprofil.setLayout(pprofilLayout);
        pprofilLayout.setHorizontalGroup(
            pprofilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprofilLayout.createSequentialGroup()
                .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pprofilLayout.setVerticalGroup(
            pprofilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(H5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pprofilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
            .addGroup(pprofilLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leftPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel9))
                    .addComponent(Pstats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pservices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pplaintes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ppersonnel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pdeconnexion, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(pprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 149, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(44, 44, 44)
                .addComponent(pprofil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pstats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pservices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pplaintes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ppersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pdeconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dynamicpanelLayout = new javax.swing.GroupLayout(dynamicpanel);
        dynamicpanel.setLayout(dynamicpanelLayout);
        dynamicpanelLayout.setHorizontalGroup(
            dynamicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
        );
        dynamicpanelLayout.setVerticalGroup(
            dynamicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dynamicpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dynamicpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            IHMDirecteur.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            IHMDirecteur.this.setMaximizedBounds(env.getMaximumWindowBounds());
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
      
       
    }//GEN-LAST:event_topPanelMouseDragged

    private void topPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMousePressed
        // TODO add your handling code here:
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_topPanelMousePressed

    private void PstatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PstatsMouseClicked
        // TODO add your handling code here:
        setColorClicked(H1);
        resetColor(new JPanel[] {H2,H3,H4,H6,H5});
        jst.setVisible(true);
        js.setVisible(false);
        jp.setVisible(false);
         jpr.setVisible(false);
        jpl.setVisible(false);
        
    }//GEN-LAST:event_PstatsMouseClicked

    private void PstatsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PstatsMouseEntered
        // TODO add your handling code here:
        setColorEntered(Pstats);
    }//GEN-LAST:event_PstatsMouseEntered

    private void PstatsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PstatsMouseExited
        // TODO add your handling code here:
        setColorExited(Pstats);
    }//GEN-LAST:event_PstatsMouseExited

    private void pservicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pservicesMouseClicked
        // TODO add your handling code here:
        setColorClicked(H2);
        resetColor(new JPanel[] {H1,H3,H4,H6,H5});
        jst.setVisible(false);
        js.setVisible(true);
        jp.setVisible(false);
         jpr.setVisible(false);
        jpl.setVisible(false);
        
        js.vider();
    }//GEN-LAST:event_pservicesMouseClicked

    private void pservicesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pservicesMouseEntered
        // TODO add your handling code here:
        setColorEntered(pservices);
    }//GEN-LAST:event_pservicesMouseEntered

    private void pservicesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pservicesMouseExited
        // TODO add your handling code here:
        setColorExited(pservices);
    }//GEN-LAST:event_pservicesMouseExited

    private void ppersonnelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ppersonnelMouseClicked
        // TODO add your handling code here:
        setColorClicked(H3);
        resetColor(new JPanel[] {H1,H2,H4,H6,H5});
         jst.setVisible(false);
        js.setVisible(false);
        jp.setVisible(true);
         jpr.setVisible(false);
        jpl.setVisible(false);
        jp.vider();
        
    }//GEN-LAST:event_ppersonnelMouseClicked

    private void ppersonnelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ppersonnelMouseEntered
        // TODO add your handling code here:
        setColorEntered(ppersonnel);
    }//GEN-LAST:event_ppersonnelMouseEntered

    private void ppersonnelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ppersonnelMouseExited
        // TODO add your handling code here:
        setColorExited(ppersonnel);
    }//GEN-LAST:event_ppersonnelMouseExited

    private void PdeconnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PdeconnexionMouseClicked
        // TODO add your handling code here:
        setColorClicked(H4);
        resetColor(new JPanel[] {H1,H2,H3,H6,H5});
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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void pprofilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pprofilMouseExited
         setColorExited(this.pprofil);
    }//GEN-LAST:event_pprofilMouseExited

    private void pprofilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pprofilMouseEntered
        setColorEntered(this.pprofil);
    }//GEN-LAST:event_pprofilMouseEntered

    private void pprofilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pprofilMouseClicked
        setColorClicked(H5);
        resetColor(new JPanel[] {H1,H2,H4,H6,H3});
        jst.setVisible(false);
        js.setVisible(false);
        jp.setVisible(false);
         jpr.setVisible(true);
        jpl.setVisible(false);
        
    }//GEN-LAST:event_pprofilMouseClicked

    private void pplaintesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pplaintesMouseExited
       setColorExited(pplaintes);
    }//GEN-LAST:event_pplaintesMouseExited

    private void pplaintesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pplaintesMouseEntered
        setColorEntered(pplaintes);
    }//GEN-LAST:event_pplaintesMouseEntered

    private void pplaintesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pplaintesMouseClicked
         
           
             setColorClicked(H6);
        resetColor(new JPanel[] {H1,H2,H4,H3,H5});
         jst.setVisible(false);
        js.setVisible(false);
        jp.setVisible(false);
         jpr.setVisible(false);
        jpl.setVisible(true);
        
    }//GEN-LAST:event_pplaintesMouseClicked

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
            java.util.logging.Logger.getLogger(IHMDirecteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHMDirecteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHMDirecteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHMDirecteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHMDirecteur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel H1;
    private javax.swing.JPanel H2;
    private javax.swing.JPanel H3;
    private javax.swing.JPanel H4;
    private javax.swing.JPanel H5;
    private javax.swing.JPanel H6;
    private javax.swing.JPanel Pdeconnexion;
    private javax.swing.JPanel Pstats;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMaximize;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JPanel dynamicpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel ppersonnel;
    private javax.swing.JPanel pplaintes;
    private javax.swing.JPanel pprofil;
    private javax.swing.JPanel pservices;
    private javax.swing.JLabel setDate;
    private javax.swing.JLabel setF;
    private javax.swing.JLabel setTime;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
