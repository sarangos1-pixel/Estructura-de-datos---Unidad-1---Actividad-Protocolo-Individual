package BusquedaDeRutas;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BusquedaRutas {
    // Movimientos posibles: arriba, abajo, izquierda, derecha
    private static final int[][] movimientos = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        int[][] mapa = {
                {0,0,1,0,0},
                {1,0,1,0,1},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,1,0}
        };

        int[] inicio = {0,0};
        int[] fin = {4,4};

        List<int[]> ruta = bfs(mapa, inicio, fin);

        if (ruta != null) {
            System.out.println("Ruta encontrada:");
            for (int[] paso : ruta) {
                System.out.println(Arrays.toString(paso));
            }
            imprimirMapaConRuta(mapa, ruta);
        } else {
            System.out.println("No existe ruta posible.");
        }
    }


    public static List<int[]> bfs(int[][] mapa, int[] inicio, int[] fin) {
        int filas = mapa.length, cols = mapa[0].length;
        boolean[][] visitado = new boolean[filas][cols];
        int[][] padre = new int[filas * cols][2]; // guardar padres en arreglo

        Queue<int[]> cola = new LinkedList<>();
        cola.add(inicio);
        visitado[inicio[0]][inicio[1]] = true;
        padre[inicio[0]*cols + inicio[1]] = new int[]{-1,-1};

        while (!cola.isEmpty()) {
            int[] actual = cola.poll();
            if (actual[0] == fin[0] && actual[1] == fin[1]) {
                return reconstruirRuta(padre, inicio, fin, cols);
            }

            for (int[] mov : movimientos) {
                int nf = actual[0] + mov[0];
                int nc = actual[1] + mov[1];
                if (nf >= 0 && nf < filas && nc >= 0 && nc < cols &&
                        mapa[nf][nc] == 0 && !visitado[nf][nc]) {
                    visitado[nf][nc] = true;
                    cola.add(new int[]{nf,nc});
                    padre[nf*cols + nc] = actual;
                }
            }
        }
        return null;
    }

    // ruta usando arreglo padre
    private static List<int[]> reconstruirRuta(int[][] padre, int[] inicio, int[] fin, int cols) {
        List<int[]> ruta = new ArrayList<>();
        int[] actual = fin;
        while (actual[0] != -1) {
            ruta.add(actual);
            actual = padre[actual[0]*cols + actual[1]];
        }
        java.util.Collections.reverse(ruta);
        return ruta;
    }

    // Imprimir mapa con ruta marcada
    private static void imprimirMapaConRuta(int[][] mapa, List<int[]> ruta) {
        char[][] visual = new char[mapa.length][mapa[0].length];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                visual[i][j] = (mapa[i][j] == 1) ? '#' : '.';
            }
        }
        for (int[] paso : ruta) {
            visual[paso[0]][paso[1]] = '*';
        }
        System.out.println("\n=== Mapa con Ruta ===");
        for (char[] fila : visual) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
