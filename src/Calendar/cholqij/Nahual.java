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
public class Nahual {
    
    
    private int numero;
    private String nombre;
    private String direccionDeImagen;
    private String descripcion;

    public Nahual(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionDeImagen() {
        return direccionDeImagen;
    }

    public void setDireccionDeImagen(String direccionDeImagen) {
        this.direccionDeImagen = direccionDeImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
