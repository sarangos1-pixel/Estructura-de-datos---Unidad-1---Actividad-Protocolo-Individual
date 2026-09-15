package SistemaDeParqueadero;

import java.util.Scanner;

public class Parqueadero {
    public static void main(String[] args) {

        // Arreglo de espacios
        boolean[] espacios = new boolean[10];

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("**** Sistema de Parqueadero ****");
            System.out.println("1. Mostrar estado de espacios");
            System.out.println("2. Registrar entrada de vehículo");
            System.out.println("3. Registrar salida de vehículo");
            System.out.println("4. Contar espacios libres");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarEspacios(espacios);
                    break;
                case 2:
                    System.out.print("Ingrese número de espacio (0-9): ");
                    int entrada = sc.nextInt();
                    registrarEntrada(espacios, entrada);
                    break;
                case 3:
                    System.out.print("Ingrese número de espacio (0-9): ");
                    int salida = sc.nextInt();
                    registrarSalida(espacios, salida);
                    break;
                case 4:
                    contarLibres(espacios);
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

    // Mostrar estado de los espacios
    private static void mostrarEspacios(boolean[] espacios) {
        System.out.println("\n=== Estado de Espacios ===");
        for (int i = 0; i < espacios.length; i++) {
            String estado = espacios[i] ? "Ocupado" : "Libre";
            System.out.println("Espacio " + i + " → " + estado);
        }
    }

    // Registrar entrada
    private static void registrarEntrada(boolean[] espacios, int idx) {
        if (idx < 0 || idx >= espacios.length) {
            System.out.println("Espacio inválido.");
            return;
        }
        if (espacios[idx]) {
            System.out.println("Ese espacio ya está ocupado.");
        } else {
            espacios[idx] = true;
            System.out.println("Vehículo registrado en espacio " + idx);
        }
    }

    // Registrar salida
    private static void registrarSalida(boolean[] espacios, int idx) {
        if (idx < 0 || idx >= espacios.length) {
            System.out.println("Espacio inválido.");
            return;
        }
        if (!espacios[idx]) {
            System.out.println("Ese espacio ya estaba libre.");
        } else {
            espacios[idx] = false;
            System.out.println("Vehículo salió del espacio " + idx);
        }
    }

    // Contar espacios libres
    private static void contarLibres(boolean[] espacios) {
        int libres = 0;
        for (boolean e : espacios) {
            if (!e) libres++;
        }
        System.out.println("Espacios libres: " + libres + " de " + espacios.length);
    }
}

