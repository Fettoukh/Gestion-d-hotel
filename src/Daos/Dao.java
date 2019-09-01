/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author omar
 */
public class Dao {
    private static String Pilote = "com.mysql.jdbc.Driver" ;
    private static String Url = "jdbc:mysql://localhost:3306/bd_hotel_hancock" ;
    private static String Login = "root" ;
    private static String Password = "" ;
    private static Connection Connexion ;
    
    public void Seconnecter()
    {
        try
        {
            System.out.println("Chargement de Pilote ...");
            Class.forName(Pilote);
            System.out.println("Chargement de Pilote réussi ...");
            Connexion = DriverManager.getConnection(Url , Login , Password);
            System.out.println("Connexion établie ...");
        }
        catch (ClassNotFoundException ex)
        {
            System.err.println("Pb de pilote !!!");
        }
        catch (SQLException ex)
        {
            System.err.println("Pb de connexion !!!");
        }
    }

    public static String getPilote() {
        return Pilote;
    }

    public static void setPilote(String Pilote) {
        Dao.Pilote = Pilote;
    }

    public static String getUrl() {
        return Url;
    }

    public static void setUrl(String Url) {
        Dao.Url = Url;
    }

    public static String getLogin() {
        return Login;
    }

    public static void setLogin(String Login) {
        Dao.Login = Login;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        Dao.Password = Password;
    }

    public static Connection getConnexion() {
        return Connexion;
    }

    public static void setConnexion(Connection Connexion) {
        Dao.Connexion = Connexion;
    }
    
     
}