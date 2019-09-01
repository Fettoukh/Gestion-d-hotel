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
public class Gerant extends Personne {
public GestionPersonnel gp;
    
    public GestionComptePersonnel gcp;
    public GestionService gs;
    public GestionClients Gclient;
    public GestionClients Gc;
    public  GestionReservation Gr;
    
    public Gerant(ResultSet rs) {
        super(rs);
     gp=new GestionPersonnel();
     gcp=new GestionComptePersonnel();
     gs= new GestionService();
     Gclient=new GestionClients(); 
     Gc = new GestionClients();
     Gr = new GestionReservation();
      
    }

    
  
    
    
   
}
