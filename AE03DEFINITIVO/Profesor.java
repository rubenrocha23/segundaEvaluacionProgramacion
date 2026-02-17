package pack;

public class Profesor extends Persona {

    // Atributo propio del profesor
    private String especialidad;

    // Constructor
    public Profesor(String nombre, String dni, String especialidad) {
        super(nombre, dni); // Llamada al constructor de Persona
        this.especialidad = especialidad;
    }

    // Getter
    public String getEspecialidad() {
        return especialidad;
    }

    // Setter
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Mostrar toda la información del profesor con el toString
    public String toString() {
        return super.toString() + " - Especialidad: " + especialidad;
    }
}
