package pack;

public class Persona {

    // Atributos comunes a todas las personas
    protected String nombre; //Profesor y Alumno pueden acceder a nombre y dni
    protected String dni;

    // Constructor de Persona
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Mostrar la información con el toString
    public String toString() {
        return nombre + " - DNI: " + dni;
    }
}
