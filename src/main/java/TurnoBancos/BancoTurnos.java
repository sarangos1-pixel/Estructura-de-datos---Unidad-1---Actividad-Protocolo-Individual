package TurnoBancos;

import java.util.Scanner;

public class BancoTurnos {
    public static void main(String[] args) {

        // Arreglo
        int[] turnos = new int[10];
        for (int i = 0; i < turnos.length; i++) {
            turnos[i] = i + 1; // Turnos numerados del 1 al 10
        }

        int turnoActual = -1;
        int siguiente = 0;

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("*** Sistema de Turnos en Banco ***");
            System.out.println("1. Mostrar turno actual y siguientes");
            System.out.println("2. Llamar al siguiente turno");
            System.out.println("3. Salir");
            System.out.print("Elige opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarTurnos(turnos, turnoActual, siguiente);
                    break;
                case 2:
                    turnoActual = llamarSiguiente(turnos, siguiente);
                    if (turnoActual != -1) {
                        System.out.println("Atendiendo turno: " + turnoActual);
                        siguiente++;
                    } else {
                        System.out.println("No hay más turnos disponibles.");
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    // Mostrar turno actual y los siguientes
    private static void mostrarTurnos(int[] turnos, int turnoActual, int siguiente) {
        System.out.println("*** Turnos ***");
        if (turnoActual == -1) {
            System.out.println("Ningún turno atendido aún.");
        } else {
            System.out.println("Turno actual: " + turnoActual);
        }

        System.out.print("Siguientes: ");
        for (int i = siguiente; i < turnos.length; i++) {
            System.out.print(turnos[i] + " ");
        }
        System.out.println();
    }

    // Llamar al siguiente turno
    private static int llamarSiguiente(int[] turnos, int siguiente) {
        if (siguiente < turnos.length) {
            return turnos[siguiente];
        }
        return -1; // no hay más turnos
    }
}

