package pack;

import java.util.ArrayList;
import java.util.Scanner;


public class principal {

    // =========================
    // VARIABLES GLOBALES
    // =========================
    static Scanner sc = new Scanner(System.in); // Scanner global para leer datos

    static ArrayList<Alumno> alumnos = new ArrayList<>(); // Lista de objetos Alumno
    static ArrayList<Profesor> profesores = new ArrayList<>(); // Lista de objetos Profesor

    // =========================
    // MÉTODO PRINCIPAL
    // =========================
    public static void main(String[] args) {
        int opcionPrincipal;

        do {
            mostrarMenuPrincipal(); // Mostramos el menú principal
            opcionPrincipal = leerEntero("Selecciona una opción: "); // Leemos opción

            switch (opcionPrincipal) {
                case 1:
                    menuAlumnos(); // Abrimos el submenú de alumnos
                    break;
                case 2:
                    menuProfesores(); // Abrimos el submenú de profesores
                    break;
                case 3:
                    System.out.println("Gestión de ciclos (pendiente de implementar).");
                    break;
                case 4:
                    System.out.println("Gestión de módulos (pendiente de implementar).");
                    break;
                case 5:
                    System.out.println("Gestión de aulas (pendiente de implementar).");
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcionPrincipal != 0);

        sc.close(); // Cerramos el Scanner al salir del programa
    }

    // =========================
    // MENÚ PRINCIPAL
    // =========================
    static void mostrarMenuPrincipal() {
        System.out.println("\n===== GESTIÓN DEL CENTRO EDUCATIVO =====");
        System.out.println("1. Alumnos");
        System.out.println("2. Profesores");
        System.out.println("3. Ciclos formativos");
        System.out.println("4. Módulos");
        System.out.println("5. Aulas");
        System.out.println("0. Salir");
    }

    // =========================
    // MENÚ ALUMNOS
    // =========================
    static void menuAlumnos() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ ALUMNOS ---");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Consultar alumnos");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Estadísticas");
            System.out.println("0. Volver");

            opcion = leerEntero("Opción: "); // Leemos opción

            switch (opcion) {
                case 1:
                    registrarAlumno();
                    break;
                case 2:
                    mostrarAlumnos();
                    break;
                case 3:
                    modificarAlumno();
                    break;
                case 4:
                    eliminarAlumno();
                    break;
                case 5:
                    estadisticasAlumnos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);
    }

    // =========================
    // MÉTODOS ALUMNOS
    // =========================
    static void registrarAlumno() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        int edad = leerEntero("Edad: ");

        Alumno a = new Alumno(nombre, dni, edad); // Creamos objeto Alumno
        alumnos.add(a); // Lo añadimos al array de alumnos

        System.out.println("Alumno registrado correctamente.");
    }

    static void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (int i = 0; i < alumnos.size(); i++) {
                System.out.println((i + 1) + ". " + alumnos.get(i)); // Enseña el toString() del Alumno
            }
        }
    }

    static void modificarAlumno() {
        mostrarAlumnos();

        if (!alumnos.isEmpty()) {
            int pos = leerEntero("Número de alumno a modificar: ") - 1;

            if (pos >= 0 && pos < alumnos.size()) {
                Alumno a = alumnos.get(pos);

                System.out.print("Nuevo nombre: ");
                a.setNombre(sc.nextLine());

                System.out.print("Nuevo DNI: ");
                a.setDni(sc.nextLine());

                a.setEdad(leerEntero("Nueva edad: "));
                System.out.println("Alumno modificado.");
            } else {
                System.out.println("Posición incorrecta.");
            }
        }
    }

    static void eliminarAlumno() {
        mostrarAlumnos();

        if (!alumnos.isEmpty()) {
            int pos = leerEntero("Número de alumno a eliminar: ") - 1;

            if (pos >= 0 && pos < alumnos.size()) {
                alumnos.remove(pos); // Eliminamos al alumno de la lista
                System.out.println("Alumno eliminado.");
            } else {
                System.out.println("Posición incorrecta.");
            }
        }
    }

    static void estadisticasAlumnos() {
        System.out.println("Total de alumnos: " + alumnos.size());
    }

    // =========================
    // MENÚ PROFESORES
    // =========================
    static void menuProfesores() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ PROFESORES ---");
            System.out.println("1. Registrar profesor");
            System.out.println("2. Consultar profesores");
            System.out.println("3. Modificar profesor");
            System.out.println("4. Eliminar profesor");
            System.out.println("5. Estadísticas");
            System.out.println("0. Volver");

            opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1:
                    registrarProfesor();
                    break;
                case 2:
                    mostrarProfesores();
                    break;
                case 3:
                    modificarProfesor();
                    break;
                case 4:
                    eliminarProfesor();
                    break;
                case 5:
                    estadisticasProfesores();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);
    }

    // =========================
    // MÉTODOS PROFESORES
    // =========================
    static void registrarProfesor() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        Profesor p = new Profesor(nombre, dni, especialidad); // Creamos objeto Profesor
        profesores.add(p); // Añadimos a la lista de profesores

        System.out.println("Profesor registrado correctamente.");
    }

    static void mostrarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            for (int i = 0; i < profesores.size(); i++) {
                System.out.println((i + 1) + ". " + profesores.get(i)); // enseña el toString() del Profesor
            }
        }
    }

    static void modificarProfesor() {
        mostrarProfesores();

        if (!profesores.isEmpty()) {
            int pos = leerEntero("Número de profesor a modificar: ") - 1;

            if (pos >= 0 && pos < profesores.size()) {
                Profesor p = profesores.get(pos);

                System.out.print("Nuevo nombre: ");
                p.setNombre(sc.nextLine());

                System.out.print("Nuevo DNI: ");
                p.setDni(sc.nextLine());

                System.out.print("Nueva especialidad: ");
                p.setEspecialidad(sc.nextLine());

                System.out.println("Profesor modificado.");
            } else {
                System.out.println("Posición incorrecta.");
            }
        }
    }

    static void eliminarProfesor() {
        mostrarProfesores();

        if (!profesores.isEmpty()) {
            int pos = leerEntero("Número de profesor a eliminar: ") - 1;

            if (pos >= 0 && pos < profesores.size()) {
                profesores.remove(pos); // Eliminamos de la lista
                System.out.println("Profesor eliminado.");
            } else {
                System.out.println("Posición incorrecta.");
            }
        }
    }

    static void estadisticasProfesores() {
        System.out.println("Total de profesores: " + profesores.size());
    }

    // =========================
    // MÉTODO DE APOYO
    // =========================
    static int leerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                valido = true; // si no hay error, salimos del bucle
            } catch (Exception e) {
                System.out.println("Error: debes introducir un número válido.");
                sc.nextLine(); // limpiar lo que el usuario escribió mal
            }
        }

        return numero;
    }

}
