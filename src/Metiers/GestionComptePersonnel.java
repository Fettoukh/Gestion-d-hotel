/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author omar
 */
public class GestionComptePersonnel {
     ExecuteStatement Es ;
     
    public GestionComptePersonnel()
     {
    Es = new ExecuteStatement();
     }
    
    
    //_________________________________________Receptionniste______________________________________________________________
    public String Cin_Personnel (String login)
    {
        try {
        String req="select cin_e from comptepersonnel where login = '"+login+"'";
        ResultSet Rs = Es.ExecuteQuery(req);
        Rs.next();
             return Rs.getString(1);
         } catch (SQLException ex) {
             System.out.println("Erreur Role !!!!!!");
         }
         return null;
    }
    
    public ResultSet get_Compte (String cin)
    {
        String Req = "Select login , password from comptepersonnel where cin_e ='"+cin+"' ";
        return Es.ExecuteQuery(Req);
    }
    
    public int modifier_mdp (String login , String mdp)
    {
        String Req ="Update comptepersonnel set password = '"+mdp+"' where login='"+login+"'";
        return Es.ExecuteUpdate(Req);
    }
    
    //________________________________________________________________________________________________________________________
    
    //_____________________________________Directeur___________________________________________________________________
    
    public int activer_Compte(String cin)
    {
      
               String req="Update  comptepersonnel set actif=1 where cin_e = '"+cin+"'";
               return Es.ExecuteUpdate(req);
           
    }
    
    public int Desactiver_Compte(String cin)
    {
      
               String req="Update  comptepersonnel set actif=0 where cin_e = '"+cin+"'";
               return Es.ExecuteUpdate(req);
           
    }
    
    public int  ajouter_Compte(String login , String cin , String pwd , String role )
    {
          
               String req = "insert into comptepersonnel values ('"+login+"', '"+cin+"' ,'"+pwd+"' , "+1+" , '"+role+"')";
                       return Es.ExecuteUpdate(req);
            
    }
    
    public String Getlogin(String cin)
    {
        try {
        String req="select login from comptepersonnel where cin_e= '"+cin+"'";
        ResultSet Rs = Es.ExecuteQuery(req);
        Rs.next();
             return Rs.getString(1);
         } catch (SQLException ex) {
             System.out.println("Erreur Role !!!!!!");
         }
         return null;
    }
    
     public int UpdateMotsDepasse(String cin,String password)
    {
       String req="Update  comptepersonnel set Password='"+password+"' where cin_e = '"+cin+"'";
       return Es.ExecuteUpdate(req);
    }
    
    //____________________________________________________________________________________________________________________
    
    
    
    
    
    public String Getpwd(String cin)
     {
        try {
        String req="select Password  from comptepersonnel where cin_e= '"+cin+"'";
        ResultSet Rs = Es.ExecuteQuery(req);
        Rs.next();
             return Rs.getString(1);
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Aucun Compte  ne correspond aux termes de recherche spécifiés   !!");
         }
         return null;
    }
    
    public ResultSet  GetCompteActif()
    {
        
        String req="SELECT `LOGIN`, `CIN_E` as CIN , `PASSWORD` as `MOTS DE PASSE`, `ROLE` FROM `comptepersonnel` WHERE ACTIF=1";
        ResultSet Rs = Es.ExecuteQuery(req);
             return Rs; 
    }
    
    //________________________________________________________________________________________________________________
    
    
    
    
     
    
    
     
    public boolean authentification_Personnel ( String login , String pwd)
    {
       
            String req="Select * from comptepersonnel where Login = '"+login+"' and Password = '"+pwd+"'";
            
         try {
             return Es.ExecuteQuery(req).first();
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
         }

            return false;
    }
        public int Compte_actif (String login)
    {
         try {
             String req="select actif from comptepersonnel where login = '"+login+"'";
             ResultSet Rs =  Es.ExecuteQuery(req);
                 Rs.next();
             return Rs.getInt(1);
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionComptePersonnel.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0 ;
         
    }
    
    public String Role_Personnel (String login)
    {
        try {
        String req="select role from comptepersonnel where login = '"+login+"'";
        ResultSet Rs = Es.ExecuteQuery(req);
        Rs.next();
             return Rs.getString(1);
         } catch (SQLException ex) {
             System.out.println("Erreur Role !!!!!!");
         }
         return null;
    }
    
    
}
