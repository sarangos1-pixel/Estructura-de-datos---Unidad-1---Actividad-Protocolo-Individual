package EditoDeImagenes;
public class EditorGrises {
    public static void main(String[] args) {
        // Ejemplo de imagen 5x5 en escala de grises
        int[][] imagen = {
                {  0,  50, 100, 150, 200},
                { 20,  60, 110, 160, 210},
                { 30,  70, 120, 170, 220},
                { 40,  80, 130, 180, 230},
                { 50,  90, 140, 190, 240}
        };

        System.out.println("*** Imagen Original ***");
        imprimirImagen(imagen);

        System.out.println("*** Inversión de Colores ***");
        int[][] invertida = invertir(imagen);
        imprimirImagen(invertida);

        System.out.println("*** Aclarar +30 ***");
        int[][] aclarada = ajustarBrillo(imagen, 30);
        imprimirImagen(aclarada);

        System.out.println("*** Oscurecer -30 ***");
        int[][] oscurecida = ajustarBrillo(imagen, -30);
        imprimirImagen(oscurecida);

        System.out.println("*** Detección de Bordes ***");
        int[][] bordes = detectarBordes(imagen);
        imprimirImagen(bordes);
    }

    // Inversión de colores: 255 - valor
    public static int[][] invertir(int[][] img) {
        int filas = img.length, cols = img[0].length;
        int[][] salida = new int[filas][cols];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                salida[i][j] = 255 - img[i][j];
            }
        }
        return salida;
    }

    // Ajustar brillo (positivo = aclarar, negativo = oscurecer)
    public static int[][] ajustarBrillo(int[][] img, int delta) {
        int filas = img.length, cols = img[0].length;
        int[][] salida = new int[filas][cols];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                int nuevo = img[i][j] + delta;
                if (nuevo < 0) nuevo = 0;
                if (nuevo > 255) nuevo = 255;
                salida[i][j] = nuevo;
            }
        }
        return salida;
    }

    // Detección de bordes simple: diferencia absoluta con vecinos
    public static int[][] detectarBordes(int[][] img) {
        int filas = img.length, cols = img[0].length;
        int[][] salida = new int[filas][cols];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                int val = img[i][j];
                int maxDif = 0;
                if (i > 0) maxDif = Math.max(maxDif, Math.abs(val - img[i-1][j]));
                if (j > 0) maxDif = Math.max(maxDif, Math.abs(val - img[i][j-1]));
                if (i < filas-1) maxDif = Math.max(maxDif, Math.abs(val - img[i+1][j]));
                if (j < cols-1) maxDif = Math.max(maxDif, Math.abs(val - img[i][j+1]));
                salida[i][j] = maxDif;
            }
        }
        return salida;
    }

    // Imprimir matriz como texto
    public static void imprimirImagen(int[][] img) {
        for (int[] fila : img) {
            for (int val : fila) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
}

