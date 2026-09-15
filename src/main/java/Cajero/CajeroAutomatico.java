package Cajero;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        // Denominaciones disponibles
        int[] denominaciones = {50000, 20000, 10000, 5000};
        // Cantidad de billetes por denominación
        int[] cantidades = {10, 10, 10, 10}; // inicial: 10 billetes de cada tipo

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Cajero Automático ");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Elige opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo(denominaciones, cantidades);
                    break;
                case 2:
                    System.out.print("Ingrese denominación a depositar: ");
                    int depDen = sc.nextInt();
                    System.out.print("Ingrese cantidad de billetes: ");
                    int depCant = sc.nextInt();
                    depositar(denominaciones, cantidades, depDen, depCant);
                    break;
                case 3:
                    System.out.print("Ingrese monto a retirar: ");
                    int monto = sc.nextInt();
                    retirar(denominaciones, cantidades, monto);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    // Consultar saldo total
    private static void consultarSaldo(int[] denominaciones, int[] cantidades) {
        int total = 0;
        System.out.println(" Saldo disponible ");
        for (int i = 0; i < denominaciones.length; i++) {
            int subtotal = denominaciones[i] * cantidades[i];
            total += subtotal;
            System.out.println(denominaciones[i] + " x " + cantidades[i] + " = " + subtotal);
        }
        System.out.println("Saldo total: " + total);
    }

    // Depositar billetes
    private static void depositar(int[] denominaciones, int[] cantidades, int den, int cant) {
        for (int i = 0; i < denominaciones.length; i++) {
            if (denominaciones[i] == den) {
                cantidades[i] += cant;
                System.out.println("Depósito exitoso: " + cant + " billetes de " + den);
                return;
            }
        }
        System.out.println("Denominación no válida.");
    }

    // Retirar monto
    private static void retirar(int[] denominaciones, int[] cantidades, int monto) {
        int[] usados = new int[denominaciones.length];
        int restante = monto;

        for (int i = 0; i < denominaciones.length; i++) {
            int billetesNecesarios = restante / denominaciones[i];
            int billetesUsados = Math.min(billetesNecesarios, cantidades[i]);
            usados[i] = billetesUsados;
            restante -= billetesUsados * denominaciones[i];
        }

        if (restante == 0) {
            System.out.println("Retiro exitoso:");
            for (int i = 0; i < denominaciones.length; i++) {
                if (usados[i] > 0) {
                    System.out.println(denominaciones[i] + " x " + usados[i]);
                    cantidades[i] -= usados[i];
                }
            }
        } else {
            System.out.println("No hay disponibilidad suficiente para el monto solicitado.");
        }
    }
}

