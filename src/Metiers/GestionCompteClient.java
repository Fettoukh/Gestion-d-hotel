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

/**
 *
 * @author amine
 */
public class GestionCompteClient {
    ExecuteStatement Es ;

    public GestionCompteClient() {
        Es = new ExecuteStatement();
    }
    
//___________________________Receptionniste_________________________________________________________
    
    public ResultSet get_Compte (String cin)
    {
        String Req = "Select logincl , password from compteclients where cin ='"+cin+"' ";
        return Es.ExecuteQuery(Req);
    }
    
//_______________________________________________________________________________________________________
    
//____________________________Client________________________________________________________________
    
    public int modifier_mdp (String login , String mdp)
    {
        String Req ="Update compteclients set password = '"+mdp+"' where logincl='"+login+"'";
        return Es.ExecuteUpdate(Req);
    }
//____________________________________________________________________________________________________
    
    public boolean authentification_Client ( String login , String pwd)
    {
       
            String req="Select * from Compteclients where Logincl = '"+login+"' and Password = '"+pwd+"'";
            
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
             String req="select actif from CompteClients where logincl = '"+login+"'";
             ResultSet Rs =  Es.ExecuteQuery(req);
                 Rs.next();
             return Rs.getInt(1);
             
         } catch (SQLException ex) {
             Logger.getLogger(GestionComptePersonnel.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0 ;
         
    }
    
    
    
    
}
