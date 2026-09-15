package Semaforo;

public class SemaforoInteligente {
    public static void main(String[] args) throws InterruptedException {

        // Arreglo con estados del semáforo
        String[] estados = {"Rojo", "Verde", "Amarillo"};

        // Duración de cada color en milisegundos
        int[] duraciones = {3000, 3000, 1500}; //

        System.out.println("=== Simulador de Semáforo Inteligente ===");

        int idx = 0;
        while (true) { // ciclo infinito simulando funcionamiento
            String estadoActual = estados[idx];
            System.out.println("Estado: " + estadoActual);

            // Esperar según duración
            Thread.sleep(duraciones[idx]);

            // Cambiar al siguiente estado
            idx = (idx + 1) % estados.length;
        }
    }
}
