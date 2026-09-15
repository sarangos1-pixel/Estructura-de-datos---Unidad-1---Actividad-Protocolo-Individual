package JuegoDeConecta;

import java.util.Scanner;

public class Conecta4 {
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private static final char VACIO = '.';
    private static final char JUGADOR1 = 'X';
    private static final char JUGADOR2 = 'O';

    public static void main(String[] args) {
        char[][] tablero = new char[FILAS][COLUMNAS];
        inicializarTablero(tablero);

        Scanner sc = new Scanner(System.in);
        char turno = JUGADOR1;
        boolean ganador = false;

        while (!ganador) {
            imprimirTablero(tablero);
            System.out.println("Turno del jugador " + turno + ". Elige columna (0-6): ");
            int col = sc.nextInt();

            if (col < 0 || col >= COLUMNAS) {
                System.out.println("Columna inválida. Intenta de nuevo.");
                continue;
            }

            if (!insertarFicha(tablero, col, turno)) {
                System.out.println("Columna llena. Intenta otra.");
                continue;
            }

            if (verificarGanador(tablero, turno)) {
                imprimirTablero(tablero);
                System.out.println("🎉 ¡Jugador " + turno + " gana!");
                ganador = true;
            } else {
                turno = (turno == JUGADOR1) ? JUGADOR2 : JUGADOR1;
            }
        }
        sc.close();
    }

    // Inicializar
    private static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    // Imprimir tablero
    private static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }

    // Insertar ficha en columna
    private static boolean insertarFicha(char[][] tablero, int col, char jugador) {
        for (int i = FILAS - 1; i >= 0; i--) {
            if (tablero[i][col] == VACIO) {
                tablero[i][col] = jugador;
                return true;
            }
        }
        return false;
    }

    // Verificar ganador
    private static boolean verificarGanador(char[][] tablero, char jugador) {
        // Horizontal
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] == jugador && tablero[i][j+1] == jugador &&
                        tablero[i][j+2] == jugador && tablero[i][j+3] == jugador) {
                    return true;
                }
            }
        }
        // Vertical
        for (int j = 0; j < COLUMNAS; j++) {
            for (int i = 0; i <= FILAS - 4; i++) {
                if (tablero[i][j] == jugador && tablero[i+1][j] == jugador &&
                        tablero[i+2][j] == jugador && tablero[i+3][j] == jugador) {
                    return true;
                }
            }
        }
        // Diagonal descendente
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] == jugador && tablero[i+1][j+1] == jugador &&
                        tablero[i+2][j+2] == jugador && tablero[i+3][j+3] == jugador) {
                    return true;
                }
            }
        }
        // Diagonal ascendente
        for (int i = 3; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] == jugador && tablero[i-1][j+1] == jugador &&
                        tablero[i-2][j+2] == jugador && tablero[i-3][j+3] == jugador) {
                    return true;
                }
            }
        }
        return false;
    }
}
