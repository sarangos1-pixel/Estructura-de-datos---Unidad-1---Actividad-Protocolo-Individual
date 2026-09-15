package TorneoSimulador;

import java.util.Random;

public class SimuladorTorneo {
    public static void main(String[] args) {
        // Arreglo de equipos
        String[] equipos = {"junior", "Atletico Nacional", "Santa Fe", "Deportivo Cali", "Barcelona"};

        // Arreglo de puntajes
        int[] puntajes = new int[equipos.length];

        Random random = new Random();

        // Simular enfrentamientos (todos contra todos)
        for (int i = 0; i < equipos.length; i++) {
            for (int j = i + 1; j < equipos.length; j++) {

                // Resultado aleatorio: 0 = empate, 1 = gana equipo i, 2 = gana equipo j
                int resultado = random.nextInt(3);

                if (resultado == 0) { // empate
                    puntajes[i] += 1;
                    puntajes[j] += 1;
                } else if (resultado == 1) { // gana equipo i
                    puntajes[i] += 3;
                } else { // gana equipo j
                    puntajes[j] += 3;
                }
            }
        }

        // Mostrar tabla final
        System.out.println("=== Tabla Final de Posiciones ===");
        for (int i = 0; i < equipos.length; i++) {
            System.out.println(equipos[i] + " → " + puntajes[i] + " puntos");
        }

        // Ordenar por puntaje (descendente)
        ordenarPorPuntaje(equipos, puntajes);

        System.out.println("Clasificación");
        for (int i = 0; i < equipos.length; i++) {
            System.out.println((i+1) + ". " + equipos[i] + " (" + puntajes[i] + " puntos)");
        }
    }

    // Metodo para ordenar equipos y puntajes juntos
    public static void ordenarPorPuntaje(String[] equipos, int[] puntajes) {
        for (int i = 0; i < puntajes.length - 1; i++) {
            for (int j = i + 1; j < puntajes.length; j++) {
                if (puntajes[j] > puntajes[i]) {

                    // Intercambiar puntajes
                    int tempP = puntajes[i];
                    puntajes[i] = puntajes[j];
                    puntajes[j] = tempP;

                    // Intercambiar equipos
                    String tempE = equipos[i];
                    equipos[i] = equipos[j];
                    equipos[j] = tempE;
                }
            }
        }
    }
}

