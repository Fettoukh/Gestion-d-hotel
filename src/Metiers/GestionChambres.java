    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import Daos.Dao;
import java.sql.*;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar
 */
public class GestionChambres {
     private ExecuteStatement Es ;
     
     
    public GestionChambres()
     {
         Es=new ExecuteStatement();
     }
     //___________________________________Receptionniste_________________________________________________________
    
    /**
      * methode permet de recuperer les  chambres vide dans un plage de jours selon la classe et le nombre de place demandes
      * @param dateDebut
      * @param datefin
      * @param classe
      * @param nbplaces
      * @return 
      */
      public ResultSet  getChambre_vide_date(java.util.Date dateDebut, java.util.Date datefin,int classe,int nbplaces )
      {  
                
                String req=" SELECT * from chambres C where   C.NUMEROCH " +
            "not IN ( select R.NUMEROCH from reserver R where '"+
                new java.sql.Date(dateDebut.getTime())+"'<=R.DATEFIN and R.DATEDEBUT<='"+new java.sql.Date(datefin.getTime())+"'  )" +
                    " and C.IDCLASSE="+classe+" and C.NBPLACES="+nbplaces+" and C.DISPONIBILITE>0; ";
             
                return this.Es.ExecuteQuery(req);
            
      }
      
     public ResultSet Chambre_reserver () // a enlever
    {

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String req = "Select chambres.numeroch as `Numero Chambre` , idclasse as Classe , nbplaces as `Nombre de Place` , Etage , Prix from chambres , reserver where chambres.numeroch=reserver.numeroch and((datedebut<='"+date+"' and datefin >='"+date+"') or datedebut >= '"+date+"')";
        return Es.ExecuteQuery(req);
    }
     
     public  Vector<String> getclasseChambre()
      {
           Vector<String> classes =new Vector<String>();
           String req="SELECT DISTINCT `IDCLASSE` FROM `chambres` order by idclasse";
         try {           

           
             ResultSet rs=Es.ExecuteQuery(req);
              while(rs.next())
              {
                  classes.add(""+rs.getInt(1));
              }
             
             
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
         }
            
           return classes;
      }
     
      public  Vector<String> getplacesChambre()
      {
           Vector<String> classes =new Vector<String>();
           String req="SELECT DISTINCT `NBPLACES` FROM `chambres` order by nbplaces";
         try {           

           
             ResultSet rs=Es.ExecuteQuery(req);
              while(rs.next())
              {
                  classes.add(""+rs.getInt(1));
              }
             
             
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
         }
            
           return classes;
      }
     
     //_____________________________________________________________________________________________________________
     
     
      
      
      
      
      
      
      
      public ResultSet RechercherChambre(Integer classe,Integer nbplaces,Float prix,Integer etage,Boolean etat )
      {  
          String req="select *  from chambres";
          int  start=0;
          if(!(classe==null)){
              if(start==0)
              { 
                  req+=" where idclasse='"+classe+"'";
                  start++;    
              }
          }
          if(!(nbplaces==null))
          { 
              if(start==0)
              { 
                  req+=" where NBPLACES="+nbplaces;
                  start++;    
              }
              else{
                  req+=" and NBPLACES="+nbplaces;
                  
              }       
          }
          
          if(!(prix==null))
          { 
              if(start==0)
              { 
                  req+=" where prix<="+prix;
                  start++;    
              }
              else{
                  req+=" and prix<="+prix;
                  
              }       
          }
           if(!(etage==null))
          { 
              if(start==0)
              { 
                  req+=" where etage="+etage;
                  start++;    
              }
              else{
                  req+=" and etage="+etage;
                  
              }       
          }
            if(!(etat==null))
          { 
              if(start==0)
              { 
                  req+=" where etat="+etat;
                  start++;    
              }
              else{
                  req+=" and etat="+etat;
                  
              }       
          }
          
      
            return Es.ExecuteQuery(req);
            
      }
      public ResultSet AllChambres(){
        String req=" SELECT * from chambres ;";
                 return this.Es.ExecuteQuery(req);
    }
    
    public ResultSet ChambresDispo(){
        String req=" SELECT * from chambres where DISPONIBILITE=1;";
                 return this.Es.ExecuteQuery(req);
    }

      }
      
