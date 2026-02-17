package pack;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class principal {

    // =========================
    // VARIABLES GLOBALES
    // =========================
    static Scanner sc = new Scanner(System.in); // Scanner global para leer datos

    static ArrayList<Alumno> alumnos = new ArrayList<>(); // Lista de objetos Alumno
    static ArrayList<Profesor> profesores = new ArrayList<>(); // Lista de objetos Profesor
    static ArrayList<CicloFormativo> ciclos = new ArrayList<>(); //Nueva lista de objetos para ciclos

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
                    menuCiclos(); // CAMBIO: Implementado submenú para ciclos
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

    // CAMBIO: Nuevo método para menú de ciclos
    static void menuCiclos() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ CICLOS FORMATIVOS ---");
            System.out.println("1. Registrar ciclo");
            System.out.println("2. Consultar ciclos");
            System.out.println("3. Modificar ciclo");
            System.out.println("4. Eliminar ciclo");
            System.out.println("5. Estadísticas");
            System.out.println("0. Volver");

            opcion = leerEntero("Opción: "); // Leemos opción

            switch (opcion) {
                case 1:
                    registrarCiclo();
                    break;
                case 2:
                    mostrarCiclos();
                    break;
                case 3:
                    modificarCiclo();
                    break;
                case 4:
                    eliminarCiclo();
                    break;
                case 5:
                    estadisticasCiclos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);
    }

    // CAMBIO: Métodos para ciclos (similares a alumnos)
    static void registrarCiclo() {
        System.out.print("Nombre del ciclo: ");
        String nombre = sc.nextLine();

        System.out.print("Duración (en meses): ");
        int duracion = leerEntero(""); // Usa el método existente

        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        CicloFormativo c = new CicloFormativo(nombre, duracion, descripcion);
        ciclos.add(c);

        System.out.println("Ciclo registrado correctamente.");
    }

    static void mostrarCiclos() {
        if (ciclos.isEmpty()) {
            System.out.println("No hay ciclos registrados.");
        } else {
            for (int i = 0; i < ciclos.size(); i++) {
                System.out.println((i + 1) + ". " + ciclos.get(i));
            }
        }
    }

    static void modificarCiclo() {
        mostrarCiclos();

        if (!ciclos.isEmpty()) {
            int pos = leerEntero("Número de ciclo a modificar: ") - 1;

            if (pos >= 0 && pos < ciclos.size()) {
                CicloFormativo c = ciclos.get(pos);

                System.out.print("Nuevo nombre: ");
                c.setNombre(sc.nextLine());

                System.out.print("Nueva duración (meses): ");
                c.setDuracion(leerEntero(""));

                System.out.print("Nueva descripción: ");
                c.setDescripcion(sc.nextLine());

                System.out.println("Ciclo modificado.");
            } else {
                System.out.println("Posición incorrecta.");
            }
        }
    }

    static void eliminarCiclo() {
        mostrarCiclos();

        if (!ciclos.isEmpty()) {
            int pos = leerEntero("Número de ciclo a eliminar: ") - 1;

            if (pos >= 0 && pos < ciclos.size()) {
                ciclos.remove(pos);
                System.out.println("Ciclo eliminado.");
            } else {
                System.out.println("Posición incorrecta.");
            }
        }
    }

    static void estadisticasCiclos() {
        System.out.println("Total de ciclos: " + ciclos.size());
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
    // MÉTODOS ALUMNOS (Actualizados con fecha)
    // =========================
    static void registrarAlumno() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("DNI: ");
        String dni = sc.nextLine();
        validarDNI(dni); // CAMBIO: Validación con try-catch

        int edad = leerEntero("Edad: ");

        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        LocalDate fechaNac = parsearFecha(fechaStr); // CAMBIO: Parseo con try-catch

        Alumno a = new Alumno(nombre, dni, edad, fechaNac); // CAMBIO: Constructor actualizado
        alumnos.add(a); // Lo añadimos al array de alumnos

        System.out.println("Alumno registrado correctamente.");
    }

    //Validar DNI con try-catch
    static void validarDNI(String dni) {
        try {
            if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
                throw new IllegalArgumentException("DNI inválido: debe tener 8 dígitos + 1 letra.");
            }
            // Aquí podrías añadir más validación (ej. letra correcta), pero simple por ahora
            System.out.println("DNI válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // No re-lanzamos; solo informamos. Si quieres, pide nuevo DNI en bucle.
        }
    }

    // CAMBIO: Nuevo método para parsear fecha con try-catch
    static LocalDate parsearFecha(String fechaStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(fechaStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Error en formato de fecha: usa dd/MM/yyyy. Usando fecha por defecto (01/01/2000).");
            return LocalDate.of(2000, 1, 1); // Fecha por defecto si falla
        }
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
                String nuevoDni = sc.nextLine();
                validarDNI(nuevoDni); // CAMBIO: Validación
                a.setDni(nuevoDni);

                a.setEdad(leerEntero("Nueva edad: "));

                // CAMBIO: Opción para modificar fecha
                System.out.print("Nueva fecha de nacimiento (dd/MM/yyyy, o Enter para mantener): ");
                String fechaStr = sc.nextLine();
                if (!fechaStr.isEmpty()) {
                    a.setFechaNacimiento(parsearFecha(fechaStr));
                }

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
    // MÉTODOS PROFESORES (Actualizados con DNI validación)
    // =========================
    static void registrarProfesor() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("DNI: ");
        String dni = sc.nextLine();
        validarDNI(dni); // CAMBIO: Validación con try-catch

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
                String nuevoDni = sc.nextLine();
                validarDNI(nuevoDni); // CAMBIO: Validación
                p.setDni(nuevoDni);

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

    // CAMBIO: Imports para fechas (añadir al inicio del archivo)
    // import java.time.LocalDate;
    // import java.time.format.DateTimeFormatter;
    // import java.time.format.DateTimeParseException;
}
