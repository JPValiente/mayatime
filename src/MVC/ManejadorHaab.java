/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

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
    
    public Kin_Haab getDiaCero(){
        return  calendarioHaab.getFechaExacta()[0][0];
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

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public CalendarioHaab getCalendarioHaab() {
        return calendarioHaab;
    }
}
