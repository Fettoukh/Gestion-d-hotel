/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author omar
 */
public class GestionContrats {
      ExecuteStatement Es ;
      GestionComptePersonnel Gcp =new GestionComptePersonnel();
    public GestionContrats()
     {
    Es = new ExecuteStatement();
     }
    
    public ResultSet GetContrats(String cin )
    {
      String req="select * from  contrat where cin_e='"+cin+"' limit 1";
      return Es.ExecuteQuery(req);
              }
    public int AjouteContrat(String cin_e,String cin_d,java.util.Date datefin,java.util.Date datedebut,String type,String role , float salaire , String description)
    {
        String req="INSERT INTO `contratpersonnel`( `CIN_E`,`CIN_D`, `DATEDEBUC`, `DATEFINC`, `TYPECONTRAT`, `ROLEPERSONNEL`, `SALAIRE`, `DESCRIPTION`)"
                + " VALUES ('"+cin_e+"','"+cin_d+"','"+new java.sql.Date(datedebut.getTime())+"','"+new java.sql.Date(datefin.getTime())+"','"+type+"','"+role+"','"+salaire+"','"+description+"')" ;
                             System.out.println("test45645");
    return Es.ExecuteUpdate(req);
    }
    
    
    public int  MajContrat(String cin_e,String cin_d,Date datefin,Date datedebut,String type,String role , float salaire , String description)
    {
       
        String reqHISTO="insert into contratpersonnelhistorique select * from contratpersonnel where cin_e='"+cin_e+"';";
        String reqDel=" delete from contratpersonnel where cin_e='"+cin_e+"';";
       
        String reqDeleteRecep=" delete from receptionistes where cin_R='"+cin_e+"'" ;
        String reqDeleteGerant=" delete from Gerant where cin_Gr='"+cin_e+"'";
        String reqAddRecep="insert into receptionistes select * from personnel  where cin_e='"+cin_e+"';";
        String reqAddGerant="insert into gerant select  * from personnel where  cin_e='"+cin_e+"';";
     
        String reqCp=" update comptePersonnel set role='"+role+"' where cin_e='"+cin_e+"'";
      
        Es.ExecuteUpdate(reqCp);
       
        if(role.equalsIgnoreCase("Gerant"))
        {
       
     
        Gcp.activer_Compte(cin_e);
        Es.ExecuteUpdate(reqAddGerant);
        
        }
        else if(role.equalsIgnoreCase("Receptionniste"))
        {    
             Gcp.activer_Compte(cin_e);
         
             
            
           Es.ExecuteUpdate(reqAddRecep);
           
            

        }else{
            
           
            
          
            Gcp.Desactiver_Compte(cin_e);
        }
           
       
        Es.ExecuteUpdate(reqHISTO);
        
        Es.ExecuteUpdate(reqDel);
       
       
        this.AjouteContrat(cin_e,cin_d, datefin, datedebut, type, role, salaire, description);
        String req="delete from contratpersonnel where contratpersonnel.CIN_E='"+cin_e+"'  and DATE(NOW())>=DATE(DATEFINC);";
        reqHISTO="insert into contratpersonnelhistorique select * from contratpersonnel where cin_e='"+cin_e+"'  and DATE(NOW())>=DATE(DATEFINC);";
       
        return Es.ExecuteUpdate(req)+Es.ExecuteUpdate(req);
    }
            
            }
