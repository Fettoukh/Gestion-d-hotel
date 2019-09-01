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
 * @author amine
 */
public class GestionPlaintes {
    
    private ExecuteStatement Es ;
    
    
    public GestionPlaintes()
     {
         Es=new ExecuteStatement();
     }
//__________________________________Client___________________________________________________________________   
    
    public int Ajouter_Plainte(String cin , String desc)
    {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req ="insert into plaintes (cin ,description , datep) values ('"+cin+"' , '"+desc+"' , '"+date+"')";
        return Es.ExecuteUpdate(req);
    }
    
//____________________________________________________________________________________________________
    
//_____________________________________Directeur___________________________________________________________
    
    public ResultSet Afficher_Plainte()
    {
        String req = "Select Cin as `Cin Client` , Description , DateP as Date , Remarque from plaintes";
        return Es.ExecuteQuery(req);
    }
    
    public ResultSet GetPlaintparAnnee()
   {
       String req="select YEAR(DateP),count(*) from plaintes  group by YEAR(DateP) order by YEAR(DateP) ";
        return Es.ExecuteQuery(req);
   }
    
    public ResultSet GetPlaintParAnneeMois(int annee)
   {

        String req="select MONTH(DateP),count(*) from plaintes where YEAR(DATEP)='"+annee+"' group by MONTH(DateP) order by MONTH(DateP) ";
        //String req1="select MONTHNAME(DateP),count(*) from plaintes where YEAR(DATEP)='"+annee+"' group by MONTHNAME(DateP) order by MONTHNAME(DateP) ";
       // String req2="select DATEP,count(*) from plaintes where YEAR(DATEP)='"+annee+"' group by DateP order by DateP";
        return Es.ExecuteQuery(req);
   }
    
//______________________________________________________________________________________________________________
    public ResultSet Afficher_PlainteSANSremarque()
    {
        String remarque="Aucune remarque";
        String req = "Select Cin as `Cin Client` , Description , DateP as Date from plaintes where remarque='"+remarque+"'";
        return Es.ExecuteQuery(req);
    }
    
    
    
    public ResultSet nbre_Plaintes()
    {
        String remarque="Aucune remarque";
        String req = "Select Count(*) from plaintes where remarque ='"+remarque+"'";
        return Es.ExecuteQuery(req);
    }
    
    public int Ajouter_Remarque(String cinG , String remarque,String cin , String desc , String date)
    {
        String req = "Update plaintes Set cin_gr='"+cinG+"' , remarque='"+remarque+"' where cin='"+cin+"' and description='"+desc+"'";
        return Es.ExecuteUpdate(req);
    }
    
    
       
    public  Vector<String> getannee()
      {
           Vector<String> annee =new Vector<String>();
           String req="SELECT DISTINCT YEAR(DateP) FROM plaintes  order by YEAR(DateP) desc";
         try {           

           
             ResultSet rs=Es.ExecuteQuery(req);
              while(rs.next())
              {
                  annee.add(""+rs.getInt(1));
              }
             
             
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
         }
            
           return annee;
      }
}
