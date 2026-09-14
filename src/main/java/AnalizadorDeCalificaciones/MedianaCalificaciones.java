package AnalizadorDeCalificaciones;

import java.util.Scanner;

public class MedianaCalificaciones {
    public static void main (String[] args){

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

        // Calcular la suma
        int suma = 0;

        for (int calificacion : calificaciones) {
            suma += calificacion;
        }

        // Calcular el promedio
        double promedio = (double) suma / n;

        System.out.println("Calificaciones ingresadas:");

        for (int calificacion : calificaciones) {
            System.out.print(calificacion + " ");
        }

        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + promedio);

        // Calcular la mediana
        double mediana;

        if (n % 2 == 0) {
            mediana = (calificaciones[n / 2 - 1] + calificaciones[n / 2]) / 2.0;
        } else {
            mediana = calificaciones[n / 2];
        }

        System.out.println("\nCalificaciones ordenadas:");

        for (int calificacion : calificaciones) {
            System.out.print(calificacion + " ");
        }

        System.out.println("\n\nSuma: " + suma);
        System.out.println("Promedio: " + promedio);
        System.out.println("Mediana: " + mediana);



        scanner.close();


    }
}
