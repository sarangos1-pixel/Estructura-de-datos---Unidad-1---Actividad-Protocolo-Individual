package AnalizadorDeCalificaciones;

import java.util.Arrays;
import java.util.Scanner;

public class ModaYAprobados {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de calificaciones: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Error: la cantidad de calificaciones debe ser mayor que 0.");
            scanner.close();
            return;
        }

        int[] calificaciones = new int[n];

        // Ingreso de calificaciones
        for (int i = 0; i < n; i++) {

            do {
                System.out.print("Ingrese la calificación " + (i + 1) + " (0-5): ");
                calificaciones[i] = scanner.nextInt();

                if (calificaciones[i] < 0 || calificaciones[i] > 5) {
                    System.out.println("Error: la calificación debe estar entre 0 y 5.");
                }

            } while (calificaciones[i] < 0 || calificaciones[i] > 5);
        }

        // Calcular suma
        int suma = 0;

        for (int calificacion : calificaciones) {
            suma += calificacion;
        }

        // Calcular promedio
        double promedio = (double) suma / n;

        // Ordenar calificaciones
        Arrays.sort(calificaciones);

        // Calcular mediana
        double mediana;

        if (n % 2 == 0) {
            mediana = (calificaciones[n / 2 - 1] + calificaciones[n / 2]) / 2.0;
        } else {
            mediana = calificaciones[n / 2];
        }

        // Calcular moda
        int moda = calificaciones[0];
        int mayorFrecuencia = 1;
        int frecuenciaActual = 1;

        for (int i = 1; i < n; i++) {

            if (calificaciones[i] == calificaciones[i - 1]) {
                frecuenciaActual++;
            } else {
                frecuenciaActual = 1;
            }

            if (frecuenciaActual > mayorFrecuencia) {
                mayorFrecuencia = frecuenciaActual;
                moda = calificaciones[i];
            }
        }

        // Calcular aprobados y reprobados
        int aprobados = 0;
        int reprobados = 0;

        for (int calificacion : calificaciones) {

            if (calificacion >= 3) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        double porcentajeAprobados = (double) aprobados * 100 / n;
        double porcentajeReprobados = (double) reprobados * 100 / n;

        // Mostrar resultados
        System.out.println("\nCalificaciones ordenadas:");

        for (int calificacion : calificaciones) {
            System.out.print(calificacion + " ");
        }

        System.out.println("\n");
        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + promedio);
        System.out.println("Mediana: " + mediana);
        System.out.println("Moda: " + moda);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + reprobados);
        System.out.println("Porcentaje de aprobados: " + porcentajeAprobados + "%");
        System.out.println("Porcentaje de reprobados: " + porcentajeReprobados + "%");

        scanner.close();
    }
}
