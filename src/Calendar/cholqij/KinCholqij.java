/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendar.cholqij;

/**
 *
 * @author jesfrin
 */
public class KinCholqij {

    private Energia energia;
    private Nahual nahual;

    public KinCholqij(Nahual nahual) {
        this.nahual = nahual;
    }

    public KinCholqij(Nahual nahual, Energia energia) {
        this.nahual = nahual;
        this.energia = energia;
    }

    public Energia getEnergia() {
        return energia;
    }

    public void setEnergia(Energia energia) {
        this.energia = energia;
    }

    public Nahual getNahual() {
        return nahual;
    }

    public void setNahual(Nahual nahual) {
        this.nahual = nahual;
    }

}
