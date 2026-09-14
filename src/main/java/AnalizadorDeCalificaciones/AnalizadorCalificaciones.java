package AnalizadorDeCalificaciones;

import java.util.Scanner;

 public class AnalizadorCalificaciones {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de calificaciones: ");
        int n = scanner.nextInt();

        int[] calificaciones = new int[n];

        for (int i = 0; i < n; i++) {

            do {
                System.out.print("Ingrese la calificación " + (i + 1) + " (0-5): ");
                calificaciones[i] = scanner.nextInt();

                if (calificaciones[i] < 0 || calificaciones[i] > 5) {
                    System.out.println("Error: la calificación debe estar entre 0 y 5.");
                }

            } while (calificaciones[i] < 0 || calificaciones[i] > 5);
        }

        System.out.println("Calificaciones ingresadas:");

        for (int calificacion : calificaciones) {
            System.out.print(calificacion + " ");
        }

        scanner.close();
    }
}