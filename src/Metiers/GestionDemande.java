/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import java.sql.ResultSet;
import java.util.Calendar;

/**
 *
 * @author amine
 */
public class GestionDemande {
     ExecuteStatement Es ;
    
    public GestionDemande()
    {
      Es = new ExecuteStatement();
    }
    
    //_____________________________Receptionniste________________________________________________________
    
    public ResultSet Service_aujourdui()
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "select id_d as `N°Demande` , designation as Désignation , Prix , demander.Cin  , Nom , Prenom from services,demander,clients where clients.cin=demander.cin and services.ids=demander.ids and date='"+date+"' and effectuée = 0";
        return Es.ExecuteQuery(req);
    }
    
    public ResultSet Service_non_effectuee()
    {
        String req = "select id_d as `N°Demande` , designation as Désignation , Prix , demander.Cin  , Nom , Prenom from services,demander,clients where clients.cin=demander.cin and services.ids=demander.ids and effectuée = 0";
        return Es.ExecuteQuery(req);
    }
    
    public int Effectuee_Service(int idd)
    {
        String req = "update demander set effectuée = 1 where id_d = '"+idd+"'";
        return Es.ExecuteUpdate(req);
    }
    
    public ResultSet ServicesClientActuel (String cin)
    { 
        String query="Select id_d as `N°Demande` , services.ids as `N°Service` , designation as Désignation ,Date , Prix from services , demander where services.ids=demander.ids and cin = '"+cin+"' and payée = 0 and effectuée = 1";
        return Es.ExecuteQuery(query);
    }   
    
    public ResultSet get_ids(int idd)
    {
        String req ="select ids from demander where id_d='"+idd+"'";
        return Es.ExecuteQuery(req);
    }
    
    public int payer_service(int idd)
    {
        String query ="update demander set payée = 1 where id_d = '"+idd+"'";
        return Es.ExecuteUpdate(query);
    }
    
    public ResultSet Information_Service (int ids , String cin)
    {
        String query = "select services.ids , designation , date ,Prix from services , demander where demander.ids = services.ids and services.ids = '"+ids+"' and cin ='"+cin+"'";
        return Es.ExecuteQuery(query);
    }
    
    //__________________________________________________________________________________________________________
   
    //____________________________________Client_______________________________________________________________
    
    /**
    * 
    * 
    *Ajouter Demande
    */
    public int Add_Demande (String cin , int ids)
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req="insert into demander (cin , ids,date ) values ('"+cin+"','"+ids+"','"+date+"')";
        return Es.ExecuteUpdate(req);
               
    }
   //___________________________________________________________________________________________________________________
   
}