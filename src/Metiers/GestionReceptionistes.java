/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import java.sql.ResultSet;

/**
 *
 * @author amine
 */
public class GestionReceptionistes {
     ExecuteStatement es ;
     
   public  GestionReceptionistes()
     {
         es = new ExecuteStatement();
     }
   
   public ResultSet Information_Receptionniste(String cin)
   {
       String req = "Select * from receptionistes where cin_r='"+cin+"'";
       return es.ExecuteQuery(req);
   }
}
