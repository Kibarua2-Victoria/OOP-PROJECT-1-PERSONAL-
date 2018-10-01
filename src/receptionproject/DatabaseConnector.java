/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptionproject;

/**
 *
 * @author kibarua muthoni
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector {
    String URL = "jdbc:mysql://localhost:3306/oopclass";
    String user = "root";
    String pass = "";
    Connection conn;
    
    public Connection DatabaseConnector(){
        try {
            conn = DriverManager.getConnection(URL,user,pass);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
     // method to obtain all data in table client details
    public ResultSet getData(){
        ResultSet Data = null;
        try {
            Connection conn = DatabaseConnector();
            String sql = "Select * from clientdetails";
            PreparedStatement st = conn.prepareStatement(sql);
            Data = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Data;
    }

    
}



