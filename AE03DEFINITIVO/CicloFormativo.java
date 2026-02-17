package pack;

public class CicloFormativo {

    // Atributos
    private String nombre;
    private int duracion; // en meses
    private String descripcion;

    // Constructor
    public CicloFormativo(String nombre, int duracion, String descripcion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString para mostrar
    public String toString() {
        return nombre + " - Duración: " + duracion + " meses - " + descripcion;
    }
}
