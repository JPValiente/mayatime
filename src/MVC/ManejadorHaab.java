/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import Haab.Kin_Haab;
import Calendar.CalendarioHaab;
import javax.swing.JOptionPane;

/**
 *
 * @author jpmazate
 */
public class ManejadorHaab {
    private CalendarioHaab calendarioHaab;
    

    public ManejadorHaab() {
        this.calendarioHaab = new CalendarioHaab(false);
       
    }
    
    public Kin_Haab[][] getDiaCero(){
        return  calendarioHaab.getFechaExacta();
    }

    public Kin_Haab getTomorrow() {
        return calendarioHaab.getTomorrow();
    }
    
    
    public Kin_Haab getFechaEspecifica(int mes, int dia){
        return calendarioHaab.getFechaEspecifica(mes,dia);
    }

    public Kin_Haab getYesterday() {
        return calendarioHaab.getYesterday();
    }


    public CalendarioHaab getCalendarioHaab() {
        return calendarioHaab;
    }
}
