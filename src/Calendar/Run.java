/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar;

import Connection.Conn;
import Haab.Kin_Haab;
import MVC.ManejadorHaab;
import java.sql.Connection;

/**
 *
 * @author bryan
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManejadorHaab manejadorHab = new ManejadorHaab();
        Kin_Haab[][] kinHaab2= manejadorHab.getDiaCero();
        
        System.out.println("HOLA");
        
        for (int i = 0; i < 20; i++) {
            
            for (int j = 0; j < 18; j++) {
                System.out.println("Nombre Dia: "+kinHaab2[i][j].getDia().getNombre());
                System.out.println("Url Dia: "+kinHaab2[i][j].getDia().getUrl());
                System.out.println("Nombre Mes: "+kinHaab2[i][j].getMes().getNombre());
                System.out.println("Url Mes: " +kinHaab2[i][j].getMes().getUrl());
               
            }
        }
    }
    
}
