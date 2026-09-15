package ControlDepaquetas;

import java.util.Scanner;

public class ControlPaquetes {
    public static void main(String[] args) {


        // Arreglo
        boolean[] paquetes = new boolean[8]; // 8 paquetes en el día

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("*** Control de Entregas de Paquetes ***");
            System.out.println("1. Mostrar estado de paquetes");
            System.out.println("2. Marcar paquete como entregado");
            System.out.println("3. Marcar paquete como pendiente");
            System.out.println("4. Mostrar paquetes pendientes");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarPaquetes(paquetes);
                    break;
                case 2:
                    System.out.print("Ingrese número de paquete (0-7): ");
                    int idxEnt = sc.nextInt();
                    marcarEntregado(paquetes, idxEnt);
                    break;
                case 3:
                    System.out.print("Ingrese número de paquete (0-7): ");
                    int idxPend = sc.nextInt();
                    marcarPendiente(paquetes, idxPend);
                    break;
                case 4:
                    mostrarPendientes(paquetes);
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

    // Mostrar estado de todos los paquetes
    private static void mostrarPaquetes(boolean[] paquetes) {
        System.out.println("\n=== Estado de Paquetes ===");
        for (int i = 0; i < paquetes.length; i++) {
            String estado = paquetes[i] ? "Entregado" : "Pendiente";
            System.out.println("Paquete " + i + " → " + estado);
        }
    }

    // Marcar paquete como entregado
    private static void marcarEntregado(boolean[] paquetes, int idx) {
        if (idx < 0 || idx >= paquetes.length) {
            System.out.println("Número inválido.");
            return;
        }
        paquetes[idx] = true;
        System.out.println("Paquete " + idx + " marcado como ENTREGADO.");
    }

    // Marcar paquete como pendiente
    private static void marcarPendiente(boolean[] paquetes, int idx) {
        if (idx < 0 || idx >= paquetes.length) {
            System.out.println("Número inválido.");
            return;
        }
        paquetes[idx] = false;
        System.out.println("Paquete " + idx + " marcado como PENDIENTE.");
    }

    // Mostrar solo los pendientes
    private static void mostrarPendientes(boolean[] paquetes) {
        System.out.println("*** Paquetes Pendientes ***");
        boolean hayPendientes = false;
        for (int i = 0; i < paquetes.length; i++) {
            if (!paquetes[i]) {
                System.out.println("Paquete " + i + " → Pendiente");
                hayPendientes = true;
            }
        }
        if (!hayPendientes) {
            System.out.println("Todos los paquetes han sido entregados.");
        }
    }
}
