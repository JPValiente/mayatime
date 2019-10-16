package Calendar.cholqij;

/**
 *
 * @author jesfrin
 */
public class Energia {


    private int numero;
    private String nombre;
    private String direccionDeImagen;
    private String descripcion;
    
    public Energia(int numero) {
        this.numero=numero;
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
