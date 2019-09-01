/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing.Client;

import Metiers.GestionClients;
import Metiers.GestionCompteClient;
import Metiers.GestionComptePersonnel;
import Swing.IHMLoginClient;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class IHMClient extends javax.swing.JFrame {

    GestionCompteClient Gcc = new GestionCompteClient();
    
    public  GridBagLayout layout =new GridBagLayout();
    public JpAccueil JPLAccueil ;
    public JpPlaintes JPLPlaintes ;
    public JpServices JPLServices ;
    public String cin , login; 
    
    //________________________________
    int xmouse;
    int ymouse;
    GestionClients Gc = new GestionClients();
    /**
     * Creates new form NewJFrame
     */
    public IHMClient() {
        initComponents();
        CurrentDate();
        setIcon();
        
        JPLAccueil=new JpAccueil(this);
        JPLPlaintes = new JpPlaintes(this);
        JPLServices = new JpServices(this);
        this.dynamicpanel.setLayout(layout); 
        dynamicAdd(new JPanel[] {JPLAccueil ,JPLPlaintes ,JPLServices});
        JPLAccueil.setVisible(true);
        visibleFalse(new JPanel[] {JPLPlaintes,JPLServices});
        cacher_Maj_Mdp();
    }
    
    public IHMClient(String Login) {
        initComponents();
        CurrentDate();
        setIcon();
        
        this.login = Login ;
        JPLAccueil=new JpAccueil(this);
        JPLPlaintes = new JpPlaintes(this);
        JPLServices = new JpServices(this);
        this.dynamicpanel.setLayout(layout); 
        dynamicAdd(new JPanel[] {JPLAccueil ,JPLPlaintes ,JPLServices});
        JPLAccueil.setVisible(true);
        visibleFalse(new JPanel[] {JPLPlaintes,JPLServices});
        ResultSet Res = Gc.get_nom_prenom_cin(Login);
        try {
            Res.first();
            lblnom.setText(Res.getString(1)+" "+Res.getString(2));
            this.cin = Res.getString(3);
        } catch (SQLException ex) {
            Logger.getLogger(IHMClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        cacher_Maj_Mdp();
        
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icon.png")));
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dynamicpanel = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        setDate = new javax.swing.JLabel();
        setTime = new javax.swing.JLabel();
        setF = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblnom = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAccueil = new javax.swing.JButton();
        lblAccueil = new javax.swing.JLabel();
        btnServices = new javax.swing.JButton();
        lblNews = new javax.swing.JLabel();
        btnPlaintes = new javax.swing.JButton();
        lblPlaintes = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblLogOut = new javax.swing.JLabel();
        txtmdp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblAnnuler = new javax.swing.JLabel();
        lblValider = new javax.swing.JLabel();
        lblConfirmation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 600));

        dynamicpanel.setBackground(new java.awt.Color(255, 255, 255));
        dynamicpanel.setPreferredSize(new java.awt.Dimension(1000, 329));

        javax.swing.GroupLayout dynamicpanelLayout = new javax.swing.GroupLayout(dynamicpanel);
        dynamicpanel.setLayout(dynamicpanelLayout);
        dynamicpanelLayout.setHorizontalGroup(
            dynamicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        dynamicpanelLayout.setVerticalGroup(
            dynamicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        pnlHeader.setBackground(new java.awt.Color(7, 20, 90));
        pnlHeader.setForeground(new java.awt.Color(255, 255, 255));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(7, 20, 90));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.setOpaque(true);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(7, 20, 90));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize.png"))); // NOI18N
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setDisabledIcon(null);
        btnMinimize.setFocusable(false);
        btnMinimize.setOpaque(true);
        btnMinimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimize (2).png"))); // NOI18N
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        setDate.setForeground(new java.awt.Color(127, 140, 141));

        setTime.setForeground(new java.awt.Color(127, 140, 141));

        setF.setForeground(new java.awt.Color(127, 140, 141));

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(setDate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(setTime, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(setF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(setDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(setTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(btnExit)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(setF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenu.setBackground(new java.awt.Color(7, 20, 52));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo1.png"))); // NOI18N

        lblnom.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        lblnom.setForeground(new java.awt.Color(210, 180, 140));
        lblnom.setText("Nom et Prenom");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 140, 141));
        jLabel3.setText("Bonjour Mr");

        btnAccueil.setBackground(new java.awt.Color(7, 20, 52));
        btnAccueil.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnAccueil.setForeground(new java.awt.Color(255, 255, 255));
        btnAccueil.setText("Accueil");
        btnAccueil.setContentAreaFilled(false);
        btnAccueil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAccueil.setFocusable(false);
        btnAccueil.setOpaque(true);
        btnAccueil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAccueilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAccueilMouseExited(evt);
            }
        });
        btnAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccueilActionPerformed(evt);
            }
        });

        lblAccueil.setBackground(new java.awt.Color(52, 152, 219));
        lblAccueil.setOpaque(true);

        btnServices.setBackground(new java.awt.Color(7, 20, 52));
        btnServices.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnServices.setForeground(new java.awt.Color(255, 255, 255));
        btnServices.setText("Services");
        btnServices.setContentAreaFilled(false);
        btnServices.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnServices.setFocusable(false);
        btnServices.setOpaque(true);
        btnServices.setPreferredSize(new java.awt.Dimension(100, 27));
        btnServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnServicesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServicesMouseExited(evt);
            }
        });
        btnServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicesActionPerformed(evt);
            }
        });

        lblNews.setBackground(new java.awt.Color(7, 20, 52));
        lblNews.setForeground(new java.awt.Color(7, 20, 52));
        lblNews.setOpaque(true);

        btnPlaintes.setBackground(new java.awt.Color(7, 20, 52));
        btnPlaintes.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnPlaintes.setForeground(new java.awt.Color(255, 255, 255));
        btnPlaintes.setText("Plaintes");
        btnPlaintes.setContentAreaFilled(false);
        btnPlaintes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPlaintes.setFocusable(false);
        btnPlaintes.setOpaque(true);
        btnPlaintes.setPreferredSize(new java.awt.Dimension(100, 27));
        btnPlaintes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlaintesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlaintesMouseExited(evt);
            }
        });
        btnPlaintes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaintesActionPerformed(evt);
            }
        });

        lblPlaintes.setBackground(new java.awt.Color(7, 20, 52));
        lblPlaintes.setOpaque(true);
        lblPlaintes.setPreferredSize(new java.awt.Dimension(100, 0));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(52, 152, 219));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Changer Mot de Passe");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        lblLogOut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLogOut.setForeground(new java.awt.Color(52, 152, 219));
        lblLogOut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogOut.setText("Se Déconnecter ?");
        lblLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
        });

        txtmdp.setBackground(new java.awt.Color(255, 255, 255));
        txtmdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmdpActionPerformed(evt);
            }
        });

        jLabel2.setText(",");

        lblAnnuler.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        lblAnnuler.setForeground(new java.awt.Color(210, 180, 140));
        lblAnnuler.setText("Annuler");
        lblAnnuler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnnulerMouseClicked(evt);
            }
        });

        lblValider.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        lblValider.setForeground(new java.awt.Color(210, 180, 140));
        lblValider.setText("Valider");
        lblValider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblValider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblValiderMouseClicked(evt);
            }
        });

        lblConfirmation.setForeground(new java.awt.Color(102, 204, 0));
        lblConfirmation.setText("Mot de passe modifié !!");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblAccueil, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(btnAccueil, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(60, 60, 60)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnom)
                    .addComponent(jLabel3)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNews, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnServices, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPlaintes, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lblPlaintes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLogOut))
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtmdp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                            .addComponent(lblAnnuler)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValider)))
                    .addComponent(lblConfirmation))
                .addGap(18, 18, 18))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblnom)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnServices, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlaintes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNews, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlaintes, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblLogOut)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmdp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnnuler)
                            .addComponent(lblValider))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblConfirmation))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dynamicpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dynamicpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(232,17,35));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(7,20,90));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        btnMinimize.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        btnMinimize.setBackground(new Color(7,20,90));
    }//GEN-LAST:event_btnMinimizeMouseExited

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse, y - ymouse);

    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void btnServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicesActionPerformed
        lblNews.setBackground(new Color(52,152,219));
        lblAccueil.setBackground(new Color(7,20,52));
        lblPlaintes.setBackground(new Color(7,20,52));
        JPLServices.setVisible(true);
        visibleFalse(new JPanel[] {JPLPlaintes,JPLAccueil});
        JPLServices.Vider();
        cacher_Maj_Mdp();

    }//GEN-LAST:event_btnServicesActionPerformed

    private void btnPlaintesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaintesActionPerformed
        lblPlaintes.setBackground(new Color(52,152,219));
        lblAccueil.setBackground(new Color(7,20,52));
        lblNews.setBackground(new Color(7,20,52));
        JPLPlaintes.setVisible(true);
        visibleFalse(new JPanel[] {JPLAccueil,JPLServices});
        JPLPlaintes.vider();
        cacher_Maj_Mdp();
    }//GEN-LAST:event_btnPlaintesActionPerformed

    private void btnServicesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicesMouseEntered
        // TODO add your handling code here:
         btnServices.setBackground(new Color(44,62,80));
    }//GEN-LAST:event_btnServicesMouseEntered

    private void btnServicesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicesMouseExited
        // TODO add your handling code here:
        btnServices.setBackground(new Color(7,20,52));
    }//GEN-LAST:event_btnServicesMouseExited

    private void btnPlaintesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlaintesMouseEntered
        // TODO add your handling code here:
        btnPlaintes.setBackground(new Color(44,62,80));
    }//GEN-LAST:event_btnPlaintesMouseEntered

    private void btnPlaintesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlaintesMouseExited
        // TODO add your handling code here:
        btnPlaintes.setBackground(new Color(7,20,52));
    }//GEN-LAST:event_btnPlaintesMouseExited

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        // TODO add your handling code here:
        new IHMLoginClient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void txtmdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmdpActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtmdpActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        txtmdp.setVisible(true);
        lblValider.setVisible(true);
        lblAnnuler.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void lblAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnnulerMouseClicked
        // TODO add your handling code here:
        cacher_Maj_Mdp();
        
    }//GEN-LAST:event_lblAnnulerMouseClicked

    private void lblValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblValiderMouseClicked
        // TODO add your handling code here:
        String mdp = txtmdp.getText();
        Gcc.modifier_mdp(login, mdp);
        cacher_Maj_Mdp();
        lblConfirmation.setVisible(true);
    }//GEN-LAST:event_lblValiderMouseClicked

    private void btnAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccueilActionPerformed
        lblAccueil.setBackground(new Color(52,152,219));
        lblNews.setBackground(new Color(7,20,52));
        lblPlaintes.setBackground(new Color(7,20,52));
        JPLAccueil.setVisible(true);
        visibleFalse(new JPanel[] {JPLPlaintes,JPLServices});
        cacher_Maj_Mdp();
    }//GEN-LAST:event_btnAccueilActionPerformed

    private void btnAccueilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccueilMouseExited
        // TODO add your handling code here:
        btnAccueil.setBackground(new Color(7,20,52));
    }//GEN-LAST:event_btnAccueilMouseExited

    private void btnAccueilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccueilMouseEntered
        // TODO add your handling code here:
        btnAccueil.setBackground(new Color(44,62,80));
    }//GEN-LAST:event_btnAccueilMouseEntered

    public void cacher_Maj_Mdp ()
    {
        txtmdp.setVisible(false);
        lblValider.setVisible(false);
        lblAnnuler.setVisible(false);
        lblConfirmation.setVisible(false);
        txtmdp.setText("");
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
            java.util.logging.Logger.getLogger(IHMClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHMClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHMClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHMClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHMClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccueil;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnPlaintes;
    private javax.swing.JButton btnServices;
    private javax.swing.JPanel dynamicpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblAccueil;
    private javax.swing.JLabel lblAnnuler;
    private javax.swing.JLabel lblConfirmation;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblNews;
    private javax.swing.JLabel lblPlaintes;
    private javax.swing.JLabel lblValider;
    private javax.swing.JLabel lblnom;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JLabel setDate;
    private javax.swing.JLabel setF;
    private javax.swing.JLabel setTime;
    private javax.swing.JTextField txtmdp;
    // End of variables declaration//GEN-END:variables
}
