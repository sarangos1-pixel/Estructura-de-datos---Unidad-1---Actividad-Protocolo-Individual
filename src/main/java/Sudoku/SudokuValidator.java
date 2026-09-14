package Sudoku;

public class SudokuValidator {
    public static void main(String[] args) {
        // Ejemplo de tablero Sudoku (0 representa celda vacía)
        int[][] tablero = {
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };

        if (validarSudoku(tablero)) {
            System.out.println("El Sudoku es válido.");
        } else {
            System.out.println("El Sudoku contiene errores.");
        }
    }

    public static boolean validarSudoku(int[][] tablero) {

        // Validar filas
        for (int i = 0; i < 9; i++) {
            if (!validarConjunto(tablero[i])) {
                System.out.println("Error en fila " + (i+1));
                return false;
            }
        }

        // Validar columnas
        for (int j = 0; j < 9; j++) {
            int[] columna = new int[9];
            for (int i = 0; i < 9; i++) {
                columna[i] = tablero[i][j];
            }
            if (!validarConjunto(columna)) {
                System.out.println("Error en columna " + (j+1));
                return false;
            }
        }

        // Validar subcuadrículas 3x3
        for (int fila = 0; fila < 9; fila += 3) {
            for (int col = 0; col < 9; col += 3) {
                int[] bloque = new int[9];
                int k = 0;
                for (int i = fila; i < fila + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        bloque[k++] = tablero[i][j];
                    }
                }
                if (!validarConjunto(bloque)) {
                    System.out.println("Error en bloque 3x3 en posición (" + (fila+1) + "," + (col+1) + ")");
                    return false;
                }
            }
        }

        return true;
    }

    // Verifica que un conjunto de 9 números contenga valores únicos del 1 al 9
    private static boolean validarConjunto(int[] conjunto) {
        boolean[] visto = new boolean[10]; // índices 1-9
        for (int num : conjunto) {
            if (num < 1 || num > 9 || visto[num]) {
                return false;
            }
            visto[num] = true;
        }
        return true;
    }
}
