package Haab;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpmazate
 */
public class Kin_Haab {
    Dia_Haab dia;
    Mes_Haab mes;
    Date fecha;

    public Kin_Haab(Dia_Haab dia, Mes_Haab mes) {
        this.dia = dia;
        this.mes = mes;
        
    }

    public Dia_Haab getDia() {
        return dia;
    }

    public void setDia(Dia_Haab dia) {
        this.dia = dia;
    }

    public Mes_Haab getMes() {
        return mes;
    }

    public void setMes(Mes_Haab mes) {
        this.mes = mes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
