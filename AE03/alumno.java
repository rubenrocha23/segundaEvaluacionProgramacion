package pack;

public class Alumno extends Persona {

    // Atributo propio del alumno
    private int edad;

    // Constructor
    public Alumno(String nombre, String dni, int edad) {
        super(nombre, dni); // Llama al constructor de Persona
        this.edad = edad;
    }

    // Getter
    public int getEdad() {
        return edad;
    }

    // Setter
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Mostrar toda la información del alumno con el toString
    public String toString() {
        return super.toString() + " - Edad: " + edad;
    }
}
