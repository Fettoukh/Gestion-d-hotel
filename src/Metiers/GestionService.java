/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amine
 */
public class GestionService{
    ExecuteStatement es;
    
    public GestionService()
    {
        es = new ExecuteStatement();
    }
    
    //__________________________________________Receptionniste________________________________________________________
    
    public ResultSet Prix_Service (int ids)
    {
        String req ="Select prix from services where ids='"+ids+"'";
        return es.ExecuteQuery(req);
    }

//____________________________________________________________________________________________________________________________
  
//_______________________________________________Client___________________________________________________________________
    
    public ResultSet get_IDS (String desc)
    {
        String req ="Select ids from services where designation='"+desc+"'";
        return es.ExecuteQuery(req);
    }
    
//________________________________________________________________________________________________________________________
    
//______________________________________Client_Receptionniste______________________________________________________________
    
    public ResultSet Prix_Service (String desc)
    {
        String req ="Select prix from services where designation='"+desc+"'";
        return es.ExecuteQuery(req);
    }
//____________________________________________________________________________________________________________________________
    
//________________________________________Directeur__________________________________________________________________________
    public void ModifierService(int id,String cin,float prix,String designation){
        
     
           int reponse =JOptionPane.showConfirmDialog(null, "Etes vous sur du changement", "Mise Ã  jour", JOptionPane.OK_CANCEL_OPTION);
       if(reponse==JOptionPane.YES_OPTION)
          { String query="update services Set PRIX='"+prix+"',Designation='"+designation+"',cin_D='"+cin+"' where IDS='"+id+"';";
             es.ExecuteUpdate(query);  
          }
       
   }
    
    public  Vector<String> getanneeDemande()
      {
           Vector<String> annee =new Vector<String>();
           String req="select DISTINCT YEAR(demander.DATE)  from demander ;";
         try {           

           
             ResultSet rs=es.ExecuteQuery(req);
              while(rs.next())
              {
                  annee.add(""+rs.getInt(1));
              }
             
             
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
         }
            
           return annee;
      }
    
     public ResultSet GetServiceAnnee()
    {
        String req=" select YEAR(demander.DATE),sum((services.PRIX)) from demander , services where services.IDS=demander.IDS and payée=1 group by YEAR(demander.date)";
        return es.ExecuteQuery(req);
    }
     
     public ResultSet GetServiceMois(int year)
    {
        String req=" select MONTH(demander.DATE),sum((services.PRIX)) from demander , services where services.IDS=demander.IDS  and  YEAR(demander.date)='"+year+"' and payée=1  "
                + "  group by MONTH(demander.date)";
        return es.ExecuteQuery(req);
    }
     
      public void SupprimerService(int id)
    {
        int reponse =JOptionPane.showConfirmDialog(null, "Etes vous sur du suppression", "suppression", JOptionPane.OK_CANCEL_OPTION);
        if(reponse==JOptionPane.YES_OPTION)
        {
            String query= "update  services set actif=0 where IDS="+id+"";
            es.ExecuteUpdate(query);      
        }
    }
      
      public void AjouterService(String cinD, float prix , String designation)
    {
        String query= "INSERT INTO `services`( `CIN_D`,`PRIX`, `DESIGNATION`) VALUES ('"+cinD+"','"+prix+"','"+designation+"')";
        es.ExecuteUpdate(query);
    }
      
      public ResultSet GetServiceParDemande()
    {
        String req="select services.Designation,count(demander.IDS) from demander ,services where services.IDS=demander.IDS group by services.Designation";
        return es.ExecuteQuery(req);
    }
      
      
    
//_____________________________________________________________________________________________________________________________
//__________________________________________________Client_Directeur__________________________________________________________
     
     public ResultSet ListeServices() 
    {
  
        String query = "Select IDS as `N°service`,Prix,Designation from services where actif=1";
        return es.ExecuteQuery(query);
    }


 //________________________________________________________________________________________________________________________
     
    // Rechercher Les Service D'un client Actuel D'une Chambre
    public ResultSet ServicesClientActuel (String cin ,int numch)
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        String query = "Select Designation , prix , d.date from service AS s , demander AS d , reserver AS r where" + 
                "s.ids=d.ids and d.id_r=r.id_r and r.cin = '" + cin + "' and r.numeroch = '" + numch + "' and datedebut < '" + date + "' and datfin >= '" + date + "'";
        return es.ExecuteQuery(query);
    }
    
    // Prix Totale Des service d'un Client Actuel
    public ResultSet PrixTotaleService (String cin ,int numch)
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        String query = "Select sum(prix) from service AS s , demander AS d , reserver AS r where" + 
                "s.ids=d.ids and d.id_r=r.id_r and r.cin = '" + cin + "' and r.numeroch = '" + numch + "' and datedebut < '" + date + "' and datfin >= '" + date + "'";
        return es.ExecuteQuery(query);
    }
     
    // Les info sur la reservation d'un client actuel d une chambre
    public ResultSet InfoReservation (String cin ,int numch) // pour l affichage des service
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        String query = "Select numeroch , datedebut , datefin  from reserver where" + 
                "cin = '" + cin + "' and numeroch = '" + numch + "' and datedebut < '" + date + "' and datfin >= '" + date + "'";
        return es.ExecuteQuery(query);
    }
    
    //Ajouter un service
    
    
    //Supprimer un Service 
    

    
 
    
    
//    public ResultSet Prix_Service(int ids)
//    {
//        String req ="Select prix from service where ids='"+ids+"'";
//        return es.ExecuteQuery(req);
//    }
    
    
    public Vector<String> getServices()
     {
          Vector<String> services=new Vector<String>();
         String req="select * from services";
         ResultSet rs=es.ExecuteQuery(req);
        try {
            while(rs.next())
            {
                services.add(rs.getInt(1)+"-"+rs.getString(3));
                
            }
            return services;
        } catch (SQLException ex) {
            Logger.getLogger(GestionService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return null; 
     }
    






public ResultSet GetServiceYear()
    {
        String req=" select YEAR(demander.DATE),sum((services.PRIX)) from demander , services where services.IDS=demander.IDS group by YEAR(demander.date)";
        return es.ExecuteQuery(req);
    }
 
    
 
 
 
 

    



    //pie chart  
    
}