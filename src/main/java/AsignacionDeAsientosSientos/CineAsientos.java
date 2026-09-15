package AsignacionDeAsientosSientos;

import java.util.Scanner;

public class CineAsientos {
    public static void main(String[] args) {


        // Matriz de asientos
        boolean[][] sala = new boolean[5][6]; // 5 filas x 6 columnas

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("*** Sistema de Asignación de Asientos ***");
            System.out.println("1. Mostrar mapa de asientos");
            System.out.println("2. Reservar asiento");
            System.out.println("3. Liberar asiento");
            System.out.println("4. Salir");
            System.out.print("Elige opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMapa(sala);
                    break;
                case 2:
                    System.out.print("Ingrese fila (0-4): ");
                    int fila = sc.nextInt();
                    System.out.print("Ingrese columna (0-5): ");
                    int col = sc.nextInt();
                    reservar(sala, fila, col);
                    break;
                case 3:
                    System.out.print("Ingrese fila (0-4): ");
                    int f = sc.nextInt();
                    System.out.print("Ingrese columna (0-5): ");
                    int c = sc.nextInt();
                    liberar(sala, f, c);
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

    // Mostrar mapa de asientos
    private static void mostrarMapa(boolean[][] sala) {
        System.out.println("*** Mapa de Asientos ***    ");
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[0].length; j++) {
                System.out.print((sala[i][j] ? "[X]" : "[ ]") + " ");
            }
            System.out.println();
        }
        System.out.println("X = Ocupado, [ ] = Libre");
    }

    // Reservar asiento
    private static void reservar(boolean[][] sala, int fila, int col) {
        if (fila < 0 || fila >= sala.length || col < 0 || col >= sala[0].length) {
            System.out.println("Posición inválida.");
            return;
        }
        if (sala[fila][col]) {
            System.out.println("Ese asiento ya está ocupado.");
        } else {
            sala[fila][col] = true;
            System.out.println("Asiento reservado en fila " + fila + ", columna " + col);
        }
    }

    // Liberar asiento
    private static void liberar(boolean[][] sala, int fila, int col) {
        if (fila < 0 || fila >= sala.length || col < 0 || col >= sala[0].length) {
            System.out.println("Posición inválida.");
            return;
        }
        if (!sala[fila][col]) {
            System.out.println("Ese asiento ya estaba libre.");
        } else {
            sala[fila][col] = false;
            System.out.println("Asiento liberado en fila " + fila + ", columna " + col);
        }
    }
}

