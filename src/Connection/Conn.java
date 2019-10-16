/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author ricardo
 */
public class Conn {
    
    public static Connection conectarDB(){
    // La url incluye el esquema a usar, en este caso 'mysql'
            String urlConnection = "jdbc:mysql://localhost:3306/MayaTime";
            String user = "root";
            String password = "mariadb";
            
            Connection conection = null;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            conection =(Connection) DriverManager.getConnection(urlConnection, user, password);
                System.out.println("se conecto");

            }catch(Exception e){
                System.out.println(e);
       
            }
            return conection;
    }
   
    }

