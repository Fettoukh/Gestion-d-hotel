/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers;

import Daos.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar
 */
public class ExecuteStatement {
    Dao dao ;
    Statement St ;
    Connection con ;
    public ExecuteStatement() 
     {
        this.dao=new Dao();
        dao.Seconnecter();
        this.con=Dao.getConnexion();
      
     }
    
    public ResultSet ExecuteQuery (String Query)
    {
        ResultSet Rs  = null ;
        try {
            St = con.createStatement();
            Rs = St.executeQuery(Query);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Rs ;
    }
    
    public int ExecuteUpdate (String Query)
    {
        try {
            St = con.createStatement();
           return (St.executeUpdate(Query));
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
        return 0;
    }
    
}
