/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author omar
 */
public class GestionPersonnel {
     private ExecuteStatement Es ;
    
    public GestionPersonnel()
    {
        Es = new ExecuteStatement();
    }
    /**
     * Recherche du Personnel selon son Login
     * @param login
     * @return 
     */
    public ResultSet ChercherPersonnel(String login )
    {
        String req="select * from Personnel where cin_e in ( select cin_e from comptepersonnel where login='"+login+"')";
        ResultSet rs=Es.ExecuteQuery(req);
        return rs;
 
     
    }
    
    
    public boolean CheckCinPersonnel(String cin) 
    {
        
        String req = "select * from Personnel WHERE cin_E='"+cin+"';";
        ResultSet rs=Es.ExecuteQuery(req);
         try {
             return rs.first();
         } catch (SQLException ex) {
             ex.getMessage();
         }
         return false;
    }
     public boolean CheckCinGerant(String cin) 
    {
        
        String req = "select * from gerant WHERE cin_GR='"+cin+"';";
        ResultSet rs=Es.ExecuteQuery(req);
         try {
             return rs.first();
         } catch (SQLException ex) {
             ex.getMessage();
         }
         return false;
    }
       public boolean CheckCinReceptionniste(String cin) 
    {
        
        String req = "select * from receptionistes WHERE cin_R='"+cin+"';";
        ResultSet rs=Es.ExecuteQuery(req);
         try {
             return (rs.first()) ;
         } catch (SQLException ex) {
             ex.getMessage();
         }
         return false;
    }
    public int MajPersonnel(String cin ,String email,String adresse,String codePostal,String telephone)
    {
        String  req="UPDATE  `personnel` SET  `EMAIL` = '"+email+"',  `TELEPHONE` ='"+telephone+"',  `ADRESSE` ='"+adresse+"',  `CODEPOSTAL` ='"+codePostal+"' WHERE cin_E='"+cin+"';";
        
      return  Es.ExecuteUpdate(req);
    }
       public int Majreceptionniste(String cin ,String email,String adresse,String codePostal,String telephone)
    {
        String  req="UPDATE  `receptionistes` SET  `EMAIL` = '"+email+"',  `TELEPHONE` ='"+telephone+"',  `ADRESSE` ='"+adresse+"',  `CODEPOSTAL` ='"+codePostal+"' WHERE cin_R='"+cin+"';";
        
      return  this.MajEmploye(cin, email, adresse, codePostal, telephone)+Es.ExecuteUpdate(req);
    }
          public int MajGerant(String cin ,String email,String adresse,String codePostal,String telephone)
    {
        String  req="UPDATE  `gerant` SET  `EMAIL` = '"+email+"',  `TELEPHONE` ='"+telephone+"',  `ADRESSE` ='"+adresse+"',  `CODEPOSTAL` ='"+codePostal+"' WHERE CIN_GR='"+cin+"';";
        
      return  this.MajEmploye(cin, email, adresse, codePostal, telephone)+Es.ExecuteUpdate(req);
    }
          
          
     public int MajEmploye(String cin ,String email,String adresse,String codePostal,String telephone)
    {
        String  req="UPDATE  `employe` SET  `EMAIL` = '"+email+"',  `TELEPHONE` ='"+telephone+"',  `ADRESSE` ='"+adresse+"',  `CODEPOSTAL` ='"+codePostal+"' WHERE cin_E='"+cin+"';";
        
      return  this.MajPersonnel(cin, email, adresse, codePostal, telephone)+Es.ExecuteUpdate(req);
    }
             
     public int DeleteGerant(String cin)
     {
         String req="delete from gerant where cin_gr='"+cin+"'";
         return Es.ExecuteUpdate(req);
     }
      public int DeleteReceptionniste(String cin)
     {
         String req="delete from receptionistes where cin_r='"+cin+"'";
         return Es.ExecuteUpdate(req);
     }
     
     
    public ResultSet getAllEmployeactif()
    {
        String req="SELECT e.CIN_E as  `cin` ,ROLEPERSONNEL as Role ,Nom,Prenom,Telephone,cp.DATEDEBUC as `date debut`,cp.DATEFINC as `date fin` FROM `employe` as e inner JOIN contratpersonnel as cp  on e.cin_E=cp.CIN_E;";
        return Es.ExecuteQuery(req);
    }
    
    
    public ResultSet getAllEmployeactuels()
    {
        String req="SELECT *  FROM employeactuel;";
        return Es.ExecuteQuery(req);
    }
    
    
    public ResultSet getAllEmployeprecedents()
    {
        String req="SELECT * FROM employeprecedent";
        return Es.ExecuteQuery(req);
    }
     public ResultSet getAllEmploye()
    {
        String req="SELECT  * FROM allemploye";
                
        return Es.ExecuteQuery(req);
    }
   public ResultSet Employe_Actuel_Filtre(String nom) {

            String Like = nom + "%";
            String req = " SELECT *  FROM employeactuel where nom like '" + Like + "'";
        
            return Es.ExecuteQuery(req);
    }
     /**
      * chercher personnel   par cin avec contrat  " 
      * @param cin_e
      * @return 
      */

      
    public ResultSet getEmployeByInfos(String infos)
    {
         
        String req="SELECT  * FROM allemploye where cin like '%"+infos+"%' or role like '%"+infos+"%'  or  nom like '%"+infos+"%' ";
        return Es.ExecuteQuery(req);
    }
            
            
         
      
      public ResultSet getEmployeNom(String nom)
    {
        String req="SELECT e.CIN_E as  `cin` ,ROLEPERSONNEL as Role ,Nom,Prenom,Telephone,cp.DATEDEBUC as `date debut`,cp.DATEFINC as `date fin` FROM `employe` as e inner JOIN contratpersonnelhIstorique as cp  on e.cin_E=cp.CIN_E and e.nom='"+nom+"' order by nom "
                + "union "
                + "SELECT e.CIN_E as  `cin` ,ROLEPERSONNEL as Role ,Nom,Prenom,Telephone,cp.DATEDEBUC as `date debut`,cp.DATEFINC as `date fin` FROM `employe` as e inner JOIN contratpersonnel as cp  on e.cin_E=cp.CIN_E and e.nom='"+nom+"';";
        return Es.ExecuteQuery(req);
    }   
    public void ajouterPersonnel(String cin_e,String nom,String prenom,java.util.Date Date_naissance, String email , String telephone,String sexe,String adresse,int codepostal )
    {
       String req= "INSERT INTO personnel VALUES ('"+cin_e+"','"+nom+"','"+prenom+"','"+new java.sql.Date(Date_naissance.getTime())+"','"+email+"','"+telephone+"','"+sexe+"','"+adresse+"','"+codepostal+"')";
       
        Es.ExecuteUpdate(req);
     }  
    
    public void ajouterEmploye(String cin_e,String nom,String prenom,java.util.Date Date_naissance, String email , String telephone,String sexe,String adresse,int codepostal )
    {
     String req= "INSERT INTO employe VALUES ('"+cin_e+"','"+nom+"','"+prenom+"','"+new java.sql.Date(Date_naissance.getTime())+"','"+email+"','"+telephone+"','"+sexe+"','"+adresse+"','"+codepostal+"')";
       this.ajouterPersonnel(cin_e, nom, prenom, Date_naissance, email, telephone, sexe, adresse, codepostal);
       Es.ExecuteUpdate(req);
    }
          
    public void ajouterReceptioniste(String cin_r,String nom,String prenom,java.util.Date Date_naissance, String email ,String telephone,String sexe,String adresse,int codepostal )
    {
       
       String req= "INSERT INTO receptionistes VALUES ('"+cin_r+"','"+nom+"','"+prenom+"','"+new java.sql.Date(Date_naissance.getTime())+"','"+email+"','"+telephone+"','"+sexe+"','"+adresse+"','"+codepostal+"')";
       this.ajouterEmploye(cin_r, nom, prenom, Date_naissance, email, telephone, sexe, adresse, codepostal);
       Es.ExecuteUpdate(req);
    }  
    
    public void ajouterGerant(String cin_gr,String nom,String prenom,java.util.Date Date_naissance, String email ,String telephone,String sexe,String adresse,int codepostal )
    {
       String req= "INSERT INTO gerant VALUES ('"+cin_gr+"','"+nom+"','"+prenom+"','"+new java.sql.Date(Date_naissance.getTime())+"','"+email+"','"+telephone+"','"+sexe+"','"+adresse+"','"+codepostal+"')";
       System.out.println("ajouterpersonnel");
       this.ajouterEmploye(cin_gr, nom, prenom, Date_naissance, email, telephone, sexe, adresse, codepostal);
       System.out.println("ajoutergerant");
       Es.ExecuteUpdate(req);
    }  
    
    public void ajouterDirecteur(String cin_d,String nom,String prenom,java.util.Date Date_naissance, String email , String  telephone,String sexe,String adresse,int codepostal )
    {
     String req= "INSERT INTO directeur VALUES ('"+cin_d+"','"+nom+"','"+prenom+"','"+new java.sql.Date(Date_naissance.getTime())+"','"+email+"','"+telephone+"','"+sexe+"','"+adresse+"','"+codepostal+"')";
       
     this.ajouterPersonnel(cin_d, nom, prenom, Date_naissance, email, telephone, sexe, adresse, codepostal);
     
       Es.ExecuteUpdate(req);
    }  


        public int MajDirecteur(String cin ,String email,String adresse,String codePostal,String telephone)
    {
        
        
        String  req="UPDATE  `directeur` SET  `EMAIL` = '"+email+"',  `TELEPHONE` ='"+telephone+"',  `ADRESSE` ='"+adresse+"',  `CODEPOSTAL` ='"+codePostal+"' WHERE cin_d='"+cin+"';";
        
          return  this.MajPersonnel(cin, email, adresse, codePostal, telephone)+Es.ExecuteUpdate(req);
    }
         
        
    public ResultSet chercherPersonnel(String cin)
     {
         String req="select  * from Personnel where cin_E='"+cin+"'";
         return Es.ExecuteQuery(req);
     }


}

