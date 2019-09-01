/***********************************************************************
 * Module:  Gerant.java
 * Author:  omar
 * Purpose: Defines the Class Personnel
 ***********************************************************************/
package Metiers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public abstract class Personne {

   private java.lang.String cinE;
   
   private java.lang.String nom;

   private java.lang.String prenom;

   private java.util.Date dateNaissance;

   private java.lang.String email;

   private String telephone;

   private java.lang.String sexe;

   private java.lang.String adresse;
  
   private String role ; 
    
    public String getCinE() {
        return cinE;
    }

    public void setCinE(String cinE) {
        this.cinE = cinE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(long codePostal) {
        this.codePostal = codePostal;
    }


   public long codePostal;

    public Personne(ResultSet rs) {
       try {
           rs.next();
         this.cinE=rs.getString(1);
         this.nom=rs.getString(2);
         this.prenom= rs.getString(3);                
         this.dateNaissance =rs.getDate(4);
         this.email= rs.getString(5);
         this.telephone = rs.getString(6);
         this.sexe=  rs.getString(7);
         this.adresse =rs.getString(8);
        this.codePostal= rs.getInt(9);
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }
                
    }
    

}