package Haab;

import Connection.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpmazate
 */
public class Dia_Haab {
    private String nombre;
    private String url;

    public Dia_Haab(String nombre) {
        Connection conexion = Conn.conectarDB();
        try {
            PreparedStatement declaracion;// prepara la orden 
            declaracion = conexion.prepareStatement("SELECT * FROM MES WHERE Nombre=?;");
            ResultSet resultado = declaracion.executeQuery();

            while (resultado.next()) {// maneja el resultado 
                Object datos[] = new Object[2];
                this.nombre = resultado.getString(1);
                url = resultado.getString(2);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
