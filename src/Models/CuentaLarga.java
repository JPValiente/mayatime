/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author anclenius
 */
public class CuentaLarga {

    private String fechaLarga;
    private String Glifo_G;
    private static final String FECHA_REFERENCIA_GREGORIANA = "21/12/2012";
    private static final String FECHA_REFERENCIA_MAYA = "13.0.0.0.0";
    private int[] fecha;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private int dias;
    private static final int BAKTUN = 144000;
    private static final int KATUN = 7200;
    private static final int TUN = 360;
    private static final int UINAL = 20;
    private static final int KIN = 1;
    
    private static final int BAKTUNMAYA = 20;
    private static final int KATUNMAYA = 20;
    private static final int TUNMAYA = 18;
    private static final int UINALMAYA = 20;
    
    private Kin_Haab haab;
    private Kin_Cholqij cholqij;
    
    public CuentaLarga(Kin_Haab haab, Kin_Cholqij cholqij, String Glifo_G) {
        this.haab = haab;
        this.cholqij = cholqij;
        this.Glifo_G = Glifo_G;
    }
    
    
    
    //Conversiones
    private static int cuentaLargaHoy() throws ParseException {
        int dias = 0;
        Date fechaInicial=dateFormat.parse("0001-01-01");
        Date fechaFinal=dateFormat.parse("3114-08-11");
        dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
        fechaInicial=dateFormat.parse("0001-01-01");
        fechaFinal=new Date();
        dias+=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
        return dias - 82;
    }
    
    public static Integer[] getCuentaLarga() throws ParseException {
        int dias = cuentaLargaHoy();
        Integer[] fecha = new Integer[5];
        for (int i = 0;i<5;i++) {
            fecha[i] = 0;
        }
        fecha[4] = dias;
        do{ 
            if(fecha[4] >= UINALMAYA) {
                fecha[3]++;
                fecha[4] -= UINALMAYA;
                dias -= UINAL;
                if(fecha[3] >= TUNMAYA) {
                    fecha[2]++;
                    fecha[3] -= TUNMAYA;
                    dias -= TUN;
                    if(fecha[2] >= KATUNMAYA) {
                        fecha[1]++;
                        fecha[2] -= KATUNMAYA;
                        dias -= KATUN;
                        if(fecha[1] >= BAKTUNMAYA) {
                            fecha[0]++;
                            fecha[1] -= BAKTUNMAYA;
                            dias -= BAKTUN;
                        }
                    } 
                } 
            } 
            
            
               
        }while( fecha[4] >= 19);
        return fecha;
    }

    public String getGlifo_G() {
        return Glifo_G;
    }

    public Kin_Haab getHaab() {
        return haab;
    }

    public Kin_Cholqij getCholqij() {
        return cholqij;
    }
    
    

    
    
    
    
    
}
