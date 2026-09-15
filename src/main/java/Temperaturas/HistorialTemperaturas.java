package Temperaturas;

public class HistorialTemperaturas {
    public static void main(String[] args) {

        int[] temperaturas = {
                30, 32, 28, 27, 29, 31, 33, 34, 28, 26,
                25, 27, 29, 30, 32, 35, 36, 33, 31, 28,
                27, 26, 25, 29, 30, 32, 34, 33, 31, 28
        };

        // Calcular promedio
        int suma = 0;
        for (int t : temperaturas) {
            suma += t;
        }
        double promedio = (double) suma / temperaturas.length;

        // Encontrar día más frío y más cálido
        int min = temperaturas[0], max = temperaturas[0];
        int diaMin = 1, diaMax = 1;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] < min) {
                min = temperaturas[i];
                diaMin = i + 1;
            }
            if (temperaturas[i] > max) {
                max = temperaturas[i];
                diaMax = i + 1;
            }
        }

        // Mostrar resultados
        System.out.println(" Historial de Temperaturas ");
        System.out.println("Promedio: " + promedio + "°C");
        System.out.println("Día más frío: Día " + diaMin + " con " + min + "°C");
        System.out.println("Día más cálido: Día " + diaMax + " con " + max + "°C");

        // Graficar en texto
        System.out.println(" Gráfico de Temperaturas ");
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.printf("Día %2d (%2d°C): ", i+1, temperaturas[i]);
            for (int j = 0; j < temperaturas[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}

