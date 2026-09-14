package AnalizadorArchivos;

import java.io.*;
import java.util.*;

public class AnalizadorNumericoArray {
    public static void main(String[] args) throws IOException {
        String archivoEntrada = "numeros.txt";
        String archivoSalida = "numeros_ordenados.txt";

        // Primero contamos cuántos números hay
        Scanner sc = new Scanner(new File(archivoEntrada));
        int contador = 0;
        while (sc.hasNextDouble()) {
            sc.nextDouble();
            contador++;
        }
        sc.close();

        // Creamos el arreglo con el tamaño exacto
        double[] numeros = new double[contador];

        // Volvemos a leer para llenar el arreglo
        sc = new Scanner(new File(archivoEntrada));
        for (int i = 0; i < contador; i++) {
            numeros[i] = sc.nextDouble();
        }
        sc.close();

        // Calcular estadísticas
        double min = numeros[0], max = numeros[0], suma = 0;
        for (double n : numeros) {
            if (n < min) min = n;
            if (n > max) max = n;
            suma += n;
        }
        double promedio = suma / numeros.length;

        System.out.println("Mínimo: " + min);
        System.out.println("Máximo: " + max);
        System.out.println("Promedio: " + promedio);

        // Ordenar arreglo
        Arrays.sort(numeros);

        // Guardar en archivo
        PrintWriter pw = new PrintWriter(new FileWriter(archivoSalida));
        for (double n : numeros) {
            pw.println(n);
        }
        pw.close();

        System.out.println("Números ordenados guardados en " + archivoSalida);
    }
}

