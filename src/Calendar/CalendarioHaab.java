/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar;

import Haab.Mes_Haab;
import Haab.Kin_Haab;
import Haab.Dia_Haab;
import java.util.Date;
import javax.swing.JOptionPane;
import Haab.Dia_Haab;
import Haab.Kin_Haab;
import Haab.Mes_Haab;

/**
 *
 * @author jpmazate
 */
public class CalendarioHaab implements Calendario {
    private final String INCIO_URL_DE_NUMERO = "/com/imagenesNumerosMayas/numero";
    private final String INCIO_URL_DE_MES = "/com/imagenesMesesHaab/Mes";
    private  Mes_Haab mes[];
    private Dia_Haab dia[];
    private final Kin_Haab[][] kinHaab = new Kin_Haab[20][19];
    private int diaActual;
    private int mesActual;
    
    
    
     public CalendarioHaab(boolean esParaCuadricula) {
        dia = new Dia_Haab[20];
        mes = new Mes_Haab[19];
        diaActual = 0;
        mesActual = 0;
        //llenar info de cada dia
        if (!esParaCuadricula) {
            crearDias();
            crearMeses();
        } else {

        }
        crearCalendario();
    }
    
    private void crearDias() {//Se crean 20 dias
        int numeroDeImagen;
        Dia_Haab[] dias = dayNumber();
        for (int i = 0; i < this.dia.length; i++) {
            numeroDeImagen = i;
            this.dia[i] = dias[i];
        }
    }

    private void crearMeses() {//Se crean 18 meses Mas el mes extra
        String[] meses = monthName();
        int numeroDeImagen;
        int i;
        int mesExtra;
        for (i = 0; i < this.mes.length - 1; i++) {
            numeroDeImagen = i + 1;
            this.mes[i] = new Mes_Haab(meses[i]);
        }
        mesExtra=i+1;
        this.mes[i] = new Mes_Haab(Integer.toString(mesExtra));
    }
    
     public Dia_Haab[] dayNumber(){
        Dia_Haab[] numbers = new Dia_Haab[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Dia_Haab(Integer.toString(i));
        }
        return numbers;
    }
    
    public String[] monthName(){
        String[] months = new String[19];
        
        months[0] = "Pop";
        months[1] = "Wo'";
        months[2] = "Sip";
        months[3] = "Sotz'";
        months[4] = "Sek";
        months[5] = "Xul";
        months[6] = "Yaxk'in";
        months[7] = "Mol";
        months[8] = "Ch'en";
        months[9] = "Yax";
        months[10] = "Sak'";
        months[11] = "Keh";
        months[12] = "Mak";
        months[13] = "K'ank'in";
        months[14] = "Muwan";
        months[15] = "Pax";
        months[16] = "Kayab";
        months[17] = "Kumk'u";
        months[18] = "Wayeb";
        return months;
        
    }
    
    private void crearCalendario() {
        Kin_Haab fecha;
        
        for (int i = 0; i < mes.length ; i++) {
            if (mesActual==19) {
                for (int k = 0; k < 5; k++) {
                    fecha = new Kin_Haab(dia[k], mes[i]);
                    this.kinHaab[k][i]= fecha;   
                }
            } else {
                for (int j = 0; j < dia.length; j++) {
                    fecha = new Kin_Haab(dia[j], mes[i]);
                    this.kinHaab[j][i] = fecha;
                }
            }
        }
    }

    public Calendario getToday() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Kin_Haab getTomorrow() {
        
        if (mesActual != 18) {
            if (diaActual+1 > 19) {
                diaActual = 0;
                mesActual++;
            } else {
                diaActual++;
            }
        }else{
            if(diaActual+1>4){
                diaActual=0;
                mesActual=0;
            }else{
                diaActual++;
            }
        }

        return getFechaExacta()[diaActual][mesActual];
    }
    
    public Kin_Haab[][] getFechaExacta() {
        return kinHaab;
    }

    public Kin_Haab getYesterday() {
        if(mesActual>0){
            if(diaActual==0){
                diaActual = 19;
                mesActual--;
            }else{
                diaActual--;
            }
        }else{
            if(diaActual==0){
                mesActual = 18;
                diaActual = 4;
            }else{
                diaActual--;
            }
        }

        return getFechaExacta()[diaActual][mesActual];
    }
    
    public Kin_Haab getFechaEspecifica(int mes, int dia){
        if(mes < 0 || mes > 18){
            JOptionPane.showMessageDialog(null,"MES INCORRECTO");
            return null;
        }else {
            if(mes == 18){
                if(dia < 0 || dia>4){
                    JOptionPane.showMessageDialog(null,"DIA INCORRECTO, EL ULTIMO MES SOLO TIENE 5 DIAS");
                    return null;
                }
            }else{
                if(dia<0 || dia>19){
                    JOptionPane.showMessageDialog(null,"DIA INCORRECTO, SOLO TIENEN 20 DIAS");
                    return null;
                }
            }
        }
        
        
        this.mesActual = mes;
        this.diaActual = dia;
        return getFechaExacta()[dia][mes];
    }

    public Calendario[][] getMatrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Calendario parseDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
