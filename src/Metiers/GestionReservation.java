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

/**
 *
 * @author omar
 */
public class GestionReservation {
     ExecuteStatement es ;
     
    public  GestionReservation()
     {
         es = new ExecuteStatement();
     }
    
//_________________________________________Receptionniste______________________________________________________________________
     /**
      * 
      * Ajouts d'une reservation
      * @param numeroCh
      * @param cin
      * @param cin_Recep
      * @param datedebut
      * @param datefin
      * @return 
      * pour  ajouter une reservation
      */
      public int Ajouter_reservation(int numeroCh,String cin,String cin_Recep,java.util.Date datedebut,java.util.Date datefin)
      { 
                String req="INSERT INTO reserver (`CIN_R`, `CIN`, `NUMEROCH`, `DATEDEBUT`, `DATEFIN`) "
                        + "VALUES ('"+cin_Recep+"','"+cin+"', '"+numeroCh+"', '"+new java.sql.Date(datedebut.getTime())+"', '"+ new java.sql.Date(datefin.getTime())+"')";
              return es.ExecuteUpdate(req);
      }
      
      public ResultSet getIDR (String cin , int numeroch , java.util.Date db , java.util.Date df)
    {
        String req = "Select id_R from reserver where cin='"+cin+"' and numeroch='"+numeroch+"' and datedebut='"+new java.sql.Date(db.getTime())+"' and datefin='"+new java.sql.Date(df.getTime())+"'";
        return es.ExecuteQuery(req);
    }
      
      public ResultSet Reservation_Client (String cin)
    {
        String req = "Select ID_R as `N°Réservation` ,reserver.Numeroch as `N°Chambre` , DateDebut as `Date de Debut` , DateFin as `Date de Fin` , (TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix As Prix from chambres , reserver where chambres.numeroch=reserver.numeroch and cin='"+cin+"' and payée=0";
        return es.ExecuteQuery(req);
    }
      
      public ResultSet Prix_Reservation (int idR)
    {
        String req = "Select sum((TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix) As Prix from chambres , reserver where chambres.numeroch=reserver.numeroch and ID_R='"+idR+"' and payée=0";
        return es.ExecuteQuery(req);
    }
      
      public int Valider_Payment (int idR)
    {
        String req="Update reserver set payée=1 where id_r ='"+idR+"'";
        return es.ExecuteUpdate(req);
    }
      
      public ResultSet getInformationReservation (int idr )
    {
        String req = "Select reserver.numeroch , datedebut , datefin ,sum((TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix) from chambres , reserver where chambres.numeroch=reserver.numeroch and id_R='"+idr+"'";
        return es.ExecuteQuery(req);
    }
      
      public ResultSet Filtrer(String cin) {

            String Like = cin + "%";
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            String Req = "select ID_R as Numero_Reservation , Cin , Numeroch as Numero_Chambre , DateDebut , DateFin from reserver where ((datedebut<='"+date+"' and datefin >='"+date+"') or datedebut>'"+date+"') and cin like '" + Like + "'";
        
            return es.ExecuteQuery(Req);
    }
      
      public ResultSet getReservation ()
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String Req = "select ID_R as `N°Réservation` , Cin , Numeroch as `N°Chambre` , DateDebut as `Date de Debut` , DateFin as `Date de Fin` from reserver where (datedebut<='"+date+"' and datefin >='"+date+"') or datedebut>'"+date+"'";
        return es.ExecuteQuery(Req);
    }
      
      public ResultSet getDb_Df(int idr)
    {
        String req = "select datedebut , datefin from reserver where id_r='"+idr+"'";
        return es.ExecuteQuery(req);
    }
      
      public int delete_Reservation(int idr)
    {
        String Res = "delete from reserver where id_r='"+idr+"'";
        return es.ExecuteUpdate(Res);
    }
//_____________________________________________________________________________________________________________________________

//_________________________________________Directeur___________________________________________________________________________
      
public  Vector<String> getAnneeReservations()
      {
           Vector<String> annee =new Vector<String>();
           String req="select  distinct YEAR(datedebut)  from  reserver;";
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

    public ResultSet GetGainReservYear()
   {
       String req="Select YEAR(datedebut),sum((TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix) As Prix from chambres , reserver where chambres.numeroch=reserver.numeroch and payée=1  group by YEAR(datedebut);";
               return es.ExecuteQuery(req);    
   }
    
      public ResultSet GetGainReservAnneeMois(int year)
   {
       String req="Select MONTH(datedebut),sum((TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix) As Prix from chambres , reserver where chambres.numeroch=reserver.numeroch "
               + "and YEAR(datedebut)='"+year+"' and payée= 1 "
               + "group by MONTH(datedebut);";
               return es.ExecuteQuery(req);
   }
      
//_______________________________________________________________________________________________________________________________
 /**
  * 
  * 
  * -Rechercher Les information de la Reservation d'une chambre par un client
   * 
 */ 
    public ResultSet RechercherRes (String cin , int numC )
    {
        
              java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
              String req="Select numeroch as N°chambre,cin, datedebut , datefin from reserver where cin = '"+cin+"' and numeroch = "+numC+" and datedebut < '"+date+"' and datefin >= '"+date+"' ";
           return es.ExecuteQuery(req);
    }
    
    
      

//    public ResultSet Reservation_Client (String cin)
//    {
//        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//        String req = "Select ID_R as ID_Reservation ,reserver.Numeroch as Numero_Chambre , DateDebut , DateFin , (TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix As Prix from chambres , reserver where chambres.numeroch=reserver.numeroch and cin='"+cin+"'and datefin<='"+date+"' and payée=0";
//        return es.ExecuteQuery(req);
//    }
    
    
    
    
      
      
        
     public ResultSet Prix_Totale (String cin)
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "Select sum((TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix) As Prix from chambres , reserver where chambres.numeroch=reserver.numeroch and cin='"+cin+"'and datefin<='"+date+"' and payée=0";
        return es.ExecuteQuery(req);
    }
    
//    public ResultSet Prix_Reservation (int idR)
//    {
//        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//        String req = "Select sum((TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix) As Prix from chambres , reserver where chambres.numeroch=reserver.numeroch and ID_R='"+idR+"' and datefin<='"+date+"' and payée=0";
//        return es.ExecuteQuery(req);
//    }
    
    
    
    
    
    
      
    public ResultSet GetGainYear() 
   {
       String req="Select YEAR(datedebut),sum((TO_DAYS(`datefin`)-TO_DAYS(`datedebut`))*prix) As Prix from chambres , reserver where chambres.numeroch=reserver.numeroch  group by YEAR(datedebut);";
               return es.ExecuteQuery(req);
       
   }

    public ResultSet GetServiceYear()
    {
        String req=" select YEAR(demander.DATE),sum((services.PRIX)) from demander , services where services.IDS=demander.IDS group by YEAR(demander.date)";
        return es.ExecuteQuery(req);
    }
    
    public ResultSet GetServiceParDemande()
    {
        String req="select services.Designation,count(demander.IDS) from demander ,services where services.IDS=demander.IDS group by services.Designation";
        return es.ExecuteQuery(req);
    }
    
    
    // ______________Receptionniste Reservation_______________________________________
    
    
    
    
    
    
    
    
    
}
