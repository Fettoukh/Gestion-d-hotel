/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import java.sql.ResultSet;

/**
 *
 * @author omar
 */
public class Receptionniste extends Personne {
    
    
  public GestionClients Gclient;
  public  GestionComptePersonnel Gcp ;
  public GestionClients Gc;
  public  GestionReservation Gr;
  public  GestionService Gs;
   
  
  public Receptionniste(ResultSet rs) {
        super(rs);
        
      Gclient=new GestionClients(); ;
      Gcp = new GestionComptePersonnel();
      Gc = new GestionClients();
      Gr = new GestionReservation();
      Gs=new GestionService();
    }

 

    
          
          
  

    
    
}
