package RegistroDeLlamada;

public class RegistroLlamadas {
    public static void main(String[] args) {


        // Arreglo
        int[] llamadas = {5, 12, 3, 20, 7, 15, 8};

        // Calcular total de minutos
        int total = 0;
        for (int duracion : llamadas) {
            total += duracion;
        }
        System.out.println("*** Registro de Llamadas ***");
        System.out.println("Total de minutos usados: " + total);

        // Identificar la llamada más larga
        int max = llamadas[0];
        int idxMax = 0;
        for (int i = 1; i < llamadas.length; i++) {
            if (llamadas[i] > max) {
                max = llamadas[i];
                idxMax = i;
            }
        }
        System.out.println("La llamada más larga fue de " + max + " minutos (posición " + idxMax + ")");
    }
}
