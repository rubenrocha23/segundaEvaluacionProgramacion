package pack;

import java.time.LocalDate;

public class Alumno extends Persona {

    // Atributos propios del alumno
    private int edad;
    private LocalDate fechaNacimiento; // CAMBIO: Nuevo campo para fecha

    // Constructor actualizado
    public Alumno(String nombre, String dni, int edad, LocalDate fechaNacimiento) {
        super(nombre, dni); // Llama al constructor de Persona
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters
    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaNacimiento() { // CAMBIO: Nuevo getter
        return fechaNacimiento;
    }

    // Setters
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) { // CAMBIO: Nuevo setter
        this.fechaNacimiento = fechaNacimiento;
    }

    // Mostrar toda la información del alumno con el toString actualizado
    public String toString() {
        return super.toString() + " - Edad: " + edad + " - Nacido: " + fechaNacimiento; // CAMBIO: Incluye fecha
    }
}
