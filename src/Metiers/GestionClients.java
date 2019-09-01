/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import Daos.Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;


/**
 *
 * @author omar
 */
public class GestionClients {
     ExecuteStatement Es ;
     
     public GestionClients()
     {
         Es = new ExecuteStatement();
     }
     
     
//__________________________________Receptionniste_________________________________________________________
     
     public int ajouter_Client(String cin,String nom , String prenom ,String  tel , String email,String adresse,java.util.Date Datenaissance,int codePostal)
     {
         String  req="INSERT INTO `clients` (`CIN`, `NOM`, `PRENOM`, `TEL`, `EMAIL`, `ADRESSE`, `DATENAISSANCE`, `CODEPOSTALE`) "
                 + "VALUES ('"+cin+"','"+nom+"','"+prenom+"', '"+tel+"', '"+email+"','"+adresse+"','"+new java.sql.Date(Datenaissance.getTime())+"', "+codePostal+")";
    
        // String req2="INSERT INTO `compteclients`(`LOGINCL`, `CIN`, `PASSWORD`) VALUES ('"+cin+"_"+nom+"','"+cin+"','"+new java.sql.Date(Datenaissance.getTime())+"')";
         return Es.ExecuteUpdate(req);
     }
     
     public int ajouterCompteClient(String cin,String login, String password)
     {
         String req2="INSERT INTO `compteclients`(`LOGINCL`, `CIN`, `PASSWORD`) VALUES ('"+login+"','"+cin+"','"+password+"')";
         return Es.ExecuteUpdate(req2);
     }
     
      public ResultSet RechercherCLient (String cin)
    {
               String req="select * from clients  where cin='"+cin+"'";
           return Es.ExecuteQuery(req);
    }
      
      public int Modifier_Clients (String cin ,String nom , String prenom , String tel ,String email ,String adresse  ,java.util.Date dateN ,int codeP)
    {
        String req = "Update clients set nom='"+nom+"' , prenom ='"+prenom+"' , tel='"+tel+"' , email ='"+email+"' , adresse='"+adresse+"'  , datenaissance='"+new java.sql.Date(dateN.getTime())+"',codepostale='"+codeP+"' where cin ='"+cin+"'";
        return Es.ExecuteUpdate(req);
    }
     
    
     
     public ResultSet FiltrerNom(String nom) {

            String Like = nom + "%";
            String req = " select Cin , Nom , Prenom from clients where nom like '" + Like + "'";
        
            return Es.ExecuteQuery(req);
    }
     
     public ResultSet FiltrerCin (String cin) {

            String Like = cin + "%";
            String req = " select Cin , Nom , Prenom from clients where cin like '" + Like + "'";
        
            return Es.ExecuteQuery(req);
    }
     
     public ResultSet FiltrerCin_Nom (String cin,String nom) {

            String LikeCin = cin + "%";
            String LikeNom = nom + "%";
            String req = " select Cin , Nom , Prenom from clients where cin like '" + LikeCin + "' and nom like '"+LikeNom+'"';
        
            return Es.ExecuteQuery(req);
    }
     
    public ResultSet Client_Actuel ()
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "Select clients.Cin As CIN , Nom , Prenom , numeroch as Numero_Chambre , DateDebut , DateFin from clients , reserver where clients.cin=reserver.cin and((datedebut<='"+date+"' and datefin >='"+date+"') or datedebut >= '"+date+"') ";
        return Es.ExecuteQuery(req);
    }
    
    public ResultSet Client_Actuel_Filtrer_Nom (String nom)
    {
        String Like = nom + "%";
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "Select clients.Cin As CIN , Nom , Prenom , numeroch as Numero_Chambre , DateDebut , DateFin from clients , reserver where clients.cin=reserver.cin and((datedebut<='"+date+"' and datefin >='"+date+"') or datedebut >= '"+date+"') and nom like '"+Like+"' ";
        return Es.ExecuteQuery(req);
    }
    
    public ResultSet Client_Actuel_Filtrer_Cin (String cin)
    {
        String Like = cin + "%";
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "Select clients.Cin As CIN , Nom , Prenom , numeroch as Numero_Chambre , DateDebut , DateFin from clients , reserver where clients.cin=reserver.cin and((datedebut<='"+date+"' and datefin >='"+date+"') or datedebut >= '"+date+"') and clients.cin like '"+Like+"' ";
        return Es.ExecuteQuery(req);
    }
     
    public ResultSet Client_Actuel_Filtrer_Cin_Nom (String cin,String nom)
    {
        String LikeCin = cin + "%";
        String LikeNom = nom + "%";
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "Select clients.Cin As CIN , Nom , Prenom , numeroch as Numero_Chambre , DateDebut , DateFin from clients , reserver where clients.cin=reserver.cin and((datedebut<='"+date+"' and datefin >='"+date+"') or datedebut >= '"+date+"') and cin like '"+LikeCin+"' and nom like '"+LikeNom+"' ";
        return Es.ExecuteQuery(req);
    }
    
    /**
     * 
     * Afficher les Clients ayant atteint la fin de leur sejour Selon La date Actuel
     *
     * */
    public ResultSet ExpirationCL()
    {
        
           
               java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
               String req="Select r.numeroch as `N°Chambre` , c.Cin , c.Nom , c.Prenom , tel as Telephone , r.datefin as `Date de fin` from clients as c , reserver as r where c.cin = r.cin and datefin= '"+date+"' and payée=0";
               
               return Es.ExecuteQuery(req);
     
    }
    
     public ResultSet ALL_Clients()
    {
        String req = "Select Cin , Nom , Prenom from clients " ;
        return Es.ExecuteQuery(req);
    }
    
     public int delete_client(String cin)
     { String req="delete from clients where cin='"+cin+"'";
         
     return Es.ExecuteUpdate(req);
     }
     
     public boolean Client_existe ( String cin)
    {
       
            String req="Select * from clients where cin = '"+cin+"'";
            
         try {
             return Es.ExecuteQuery(req).first();
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
         }

            return false;
    }
     
     public int Activer_Compte_Client(String cin)
    {
        String req = "update compteclients set actif = 1 where cin='"+cin+"'";
        return Es.ExecuteUpdate(req);
    }
     
     public ResultSet getInformation_Compte (String cin)
    {
        String req ="Select LOGINCL,PASSWORD from compteclients where CIN='"+cin+"'";
        return Es.ExecuteQuery(req);
    }
    //_________________________________________________________________________________________________________________________________________
     
     
     
    
    
    
public ResultSet ClientByDate(Date d,Date f){
 
      
            
          String  req="select CIN,NOM,PRENOM,TEL,EMAIL,ADRESSE,DATENAISSANCE as DateNaissance ,NUMEROCH as N°Chambre from CLIENTS,RESERVER "
                    + "where RESERVER.DATEDEBUT='"+d+"' and RESERVER.DATEFIN='"+f+"'AND CLIENTS.CIN=RESERVER.CIN ";
   
            return Es.ExecuteQuery(req);
       
   }
/**
 * rechrche by cin
 * 
 * */
public ResultSet ClientByCin_Reserver(String Cin ){
      

            String req ;
            
            req="select NOM,PRENOM,TEL,EMAIL,ADRESSE,DATENAISSANCE as DateNaissance,NUMEROCH as N°Chambre ,R.DateDebut,R.DateFin  from CLIENTS C,RESERVER R "
                    + "where CLIENTS.CIN='"+Cin+"' AND CLIENTS.CIN=RESERVER.CIN ";
            return Es.ExecuteQuery(req);
      
       

}

/**
 * 
* afficher les service d un client
*/
public ResultSet ServiceByClient(String c)
    {
        
   
            String req ;
            
            req="select IDS,DESIGNATION,PRIX from DEMANDER D,SERVICES S WHERE S.IDS=D.IDS "
                    + "AND D.CIN='"+c+"' ";
          
             return Es.ExecuteQuery(req);
        }
     
 public boolean authentification_Client ( String login , String pwd)
    {
       
            String req="Select * from clients where Login = '"+login+"' and Password = '"+pwd+"'";
            
         try {
             return Es.ExecuteQuery(req).first();
         } catch (SQLException ex) {
             Logger.getLogger(GestionComptePersonnel.class.getName()).log(Level.SEVERE, null, ex);
         }

            return false;
    }

public int AjouterComplainte(String cin,String description)
{
    String req="INSERT INTO `complaintes`(`CIN`, `DESCRIPTION`) VALUES (['"+cin+"','"+description+"')";
return Es.ExecuteUpdate(req);
}

public int Paiement(String Numeroc ,String Cin,Date dateexp,String ccv)
{
    String req="INSERT INTO `compte_banquaire`(`NUMEROC`, `CIN`, `DATEEXPIRATION`, `CCV`) VALUES ('"+Numeroc+"','"+Cin+"','"+new java.sql.Date(dateexp.getTime())+"','"+ccv+"')";
    return Es.ExecuteUpdate(req);
}


 public ResultSet Client_Actuel_Filtre (String nom)
    {
        String Like = nom + "%";
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "Select clients.Cin As CIN , Nom , Prenom , numeroch as Numero_Chambre , DateDebut , DateFin from clients , reserver where clients.cin=reserver.cin and((datedebut<='"+date+"' and datefin >='"+date+"') or datedebut >= '"+date+"') and nom like '"+Like+"' ";
        return Es.ExecuteQuery(req);
    }
  
 public ResultSet get_nom_prenom_cin (String login)
    {
        String req="select nom , prenom , clients.cin from clients , compteclients where clients.cin = compteclients.cin and logincl ='"+login+"'";
        return Es.ExecuteQuery(req);
    }
//---------------------------------------------------------
     public ResultSet Client_precedent(int num_chambre)
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "Select clients.Cin As CIN , Nom , Prenom , numeroch as Numero_Chambre , DateDebut , DateFin from "
                + "clients , reserver "
                + "where numeroch= '"+num_chambre+"' and clients.cin=reserver.cin  and "
                + "  DateFin <= '"+date+"' ";
        return Es.ExecuteQuery(req);
    }
}
