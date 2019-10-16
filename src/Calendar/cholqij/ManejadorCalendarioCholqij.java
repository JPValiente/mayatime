/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar.cholqij;

import Calendar.Calendario;
import java.util.Date;

/**
 *
 * @author jesfrin
 */
public class ManejadorCalendarioCholqij implements Calendario {

    private final Energia[] energias;
    private final Nahual[] nahuales;
    private final KinCholqij[][] kinesCalendarioCholqij;
    private int numeroDeEnergia = 1;
    private int numeroDeNahual = 1;

    public ManejadorCalendarioCholqij() {
        this.energias = new Energia[13];
        this.nahuales = new Nahual[20];
        this.kinesCalendarioCholqij = new KinCholqij[20][13];
        this.numeroDeEnergia = 1;
        this.numeroDeNahual = 1;
        crearEnergias();
        crearNahuales();
    }

    private void crearEnergias() {//Se crean 13 energias,se encarga de recopilar la informacion de la base de datos
        for (int i = 0; i < energias.length; i++) {
            this.energias[i] = new Energia(i + 1);
        }
    }

    private void crearNahuales() {//Se crean 20 nahuales,se encarga de recopilar informacion de la base de datos
        for (int i = 0; i < nahuales.length; i++) {
            this.nahuales[i] = new Nahual(i + 1);
        }
    }

    private void crearCalendario() {//El metodo se basa en el avance de filas
        int numeroDeFila = 1;
        for (int i = 0; i < nahuales.length; i++) {
            if (numeroDeFila == 14) {
                numeroDeFila = 1;
            }
            int valorDeEnergiaEnColumna = numeroDeFila;//El numero de fila es la base para saber la energia
            for (int j = 0; j < energias.length; j++) {
                KinCholqij dia = new KinCholqij(nahuales[i]);
                if (j == 0) {
                } else if (valorDeEnergiaEnColumna + 7 >= 14) {
                    valorDeEnergiaEnColumna -= 6;
                } else {
                    valorDeEnergiaEnColumna += 7;
                }
                dia.setEnergia(energias[valorDeEnergiaEnColumna - 1]);
                kinesCalendarioCholqij[i][j] = dia;
            }
            numeroDeFila++;
        }
    }

    public Energia[] getEnergias() {
        return energias;
    }

    public Nahual[] getNahuales() {
        return nahuales;
    }

    public KinCholqij[][] getKinesCalendarioCholqij() {
        return kinesCalendarioCholqij;
    }

    public KinCholqij verDiaSiguiente() {
        if (numeroDeNahual == 20) {
            numeroDeNahual = 1;
            if (numeroDeEnergia == 13) {
                numeroDeEnergia = 1;
            } else {
                numeroDeEnergia++;
            }
        } else {
            numeroDeNahual++;
        }
        return this.kinesCalendarioCholqij[numeroDeNahual - 1][numeroDeEnergia - 1];
    }

    /**
     * La energia disminuye basado en el nahual, si sobrepasan su limite
     * inferior vuelven a su limite inferior
     *
     * @return
     */
    public KinCholqij verDiaAnterior() {
        if (numeroDeNahual == 1) {
            numeroDeNahual = 20;
            if (numeroDeEnergia == 1) {
                numeroDeEnergia = 13;
            } else {
                numeroDeEnergia--;
            }
        } else {
            numeroDeNahual--;
        }
        return this.kinesCalendarioCholqij[numeroDeNahual - 1][numeroDeEnergia - 1];
    }

    public Calendario getToday() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Calendario getTomorrow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Calendario getYesterday() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Calendario[][] getMatrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Calendario parseDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
