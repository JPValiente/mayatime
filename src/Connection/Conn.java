/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ricardo
 */
public class Conn {
    
    public Connection conectarDB(){
    // La url incluye el esquema a usar, en este caso 'mysql'
            String urlConnection = "jdbc:mysql://localhost:3306/mayaConnection";
            String user = "root";
            String password = "@#test1T#$";
            
            Connection conection = null;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            conection =(Connection) DriverManager.getConnection(urlConnection, user, password);

            }catch(Exception e){
                System.out.println(e);
       
            }
            return conection;
    }
   
    }

