package SalaDeComputo;

import java.util.Scanner;

public class SalaComputo {
    public static void main(String[] args) {

        // Arreglo de computadores (
        String[] computadores = new String[5];

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("*** Control de Sala de Cómputo ***");
            System.out.println("1. Mostrar estado de equipos");
            System.out.println("2. Registrar uso por usuario");
            System.out.println("3. Liberar equipo");
            System.out.println("4. Mostrar equipos disponibles");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    mostrarEquipos(computadores);
                    break;
                case 2:
                    System.out.print("Ingrese número de equipo (0-4): ");
                    int idxUso = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese nombre del usuario: ");
                    String usuario = sc.nextLine();
                    registrarUso(computadores, idxUso, usuario);
                    break;
                case 3:
                    System.out.print("Ingrese número de equipo (0-4): ");
                    int idxLib = sc.nextInt();
                    liberarEquipo(computadores, idxLib);
                    break;
                case 4:
                    mostrarDisponibles(computadores);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    // Mostrar estado de todos los equipos
    private static void mostrarEquipos(String[] compus) {
        System.out.println("***Estado de Equipos ***");
        for (int i = 0; i < compus.length; i++) {
            if (compus[i] == null) {
                System.out.println("Equipo " + i + " → Disponible");
            } else {
                System.out.println("Equipo " + i + " → Ocupado por " + compus[i]);
            }
        }
    }

    // Registrar uso por usuario
    private static void registrarUso(String[] compus, int idx, String usuario) {
        if (idx < 0 || idx >= compus.length) {
            System.out.println("Equipo inválido.");
            return;
        }
        if (compus[idx] != null) {
            System.out.println("Ese equipo ya está ocupado por " + compus[idx]);
        } else {
            compus[idx] = usuario;
            System.out.println("Equipo " + idx + " asignado a " + usuario);
        }
    }

    // Liberar equipo
    private static void liberarEquipo(String[] compus, int idx) {
        if (idx < 0 || idx >= compus.length) {
            System.out.println("Equipo inválido.");
            return;
        }
        if (compus[idx] == null) {
            System.out.println("Ese equipo ya estaba libre.");
        } else {
            System.out.println("Equipo " + idx + " liberado (usuario: " + compus[idx] + ")");
            compus[idx] = null;
        }
    }

    // Mostrar equipos disponibles
    private static void mostrarDisponibles(String[] compus) {
        System.out.println("*** Equipos Disponibles ***");
        boolean hayLibres = false;
        for (int i = 0; i < compus.length; i++) {
            if (compus[i] == null) {
                System.out.println("Equipo " + i + " → Disponible");
                hayLibres = true;
            }
        }
        if (!hayLibres) {
            System.out.println("No hay equipos disponibles.");
        }
    }
}
