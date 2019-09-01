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
public class Directeur extends Personne {
    
    public GestionPersonnel gp;
    public GestionContrats gc;
    public GestionComptePersonnel gcp;
    public GestionService gs;
    public GestionReservation gr;
    public GestionPlaintes gpl;
    public Directeur(ResultSet rs) {
        super(rs);
    gp=new GestionPersonnel();
    gc=new GestionContrats();
    gcp=new GestionComptePersonnel();
    gs= new GestionService();
     gr=new GestionReservation();
     gpl=new GestionPlaintes();
    }
   

   
 
}
