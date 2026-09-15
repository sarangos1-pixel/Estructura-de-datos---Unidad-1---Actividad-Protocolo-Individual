package RegistroTransportePublico;

public class TransportePublico {
    public static void main(String[] args) {


        // Arreglo
        int[] viajes = {30, 45, 20, 60, 50, 40};

        // Calcular total y promedio
        int total = 0;
        for (int pasajeros : viajes) {
            total += pasajeros;
        }
        double promedio = (double) total / viajes.length;

        System.out.println("*** Registro de Transporte Público ***");
        System.out.println("Total de pasajeros transportados: " + total);
        System.out.println("Promedio de pasajeros por viaje: " + promedio);

        // Identificar el viaje con mayor ocupación
        int max = viajes[0];
        int idxMax = 0;
        for (int i = 1; i < viajes.length; i++) {
            if (viajes[i] > max) {
                max = viajes[i];
                idxMax = i;
            }
        }
        System.out.println("El viaje con mayor ocupación fue el #" + (idxMax+1) + " con " + max + " pasajeros.");
    }
}

