package AnalizadorDeSecuencias;

public class AnalizadorSecuencias {
    public static void main(String[] args) {
        int[] numeros = {3, 6, 7, 9, 10};


        String orden = verificarOrden(numeros);


        String progresion = verificarProgresion(numeros);


        System.out.println("Análisis de Secuencia ");
        System.out.println("Secuencia: " + java.util.Arrays.toString(numeros));
        System.out.println("Orden: " + orden);
        System.out.println("Progresión: " + progresion);
    }

    // Detectar si está ordenado
    public static String verificarOrden(int[] arr) {
        boolean asc = true, desc = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) asc = false;
            if (arr[i] > arr[i-1]) desc = false;
        }
        if (asc) return "Ascendente";
        if (desc) return "Descendente";
        return "Desordenado";
    }

    // Detectar progresión aritmética o geométrica
    public static String verificarProgresion(int[] arr) {
        if (arr.length < 2) return "No aplica";

        // Progresión aritmética
        int diferencia = arr[1] - arr[0];
        boolean aritmetica = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != diferencia) {
                aritmetica = false;
                break;
            }
        }

        // Progresión geométrica
        boolean geometrica = true;
        if (arr[0] == 0) geometrica = false; // evitar división por cero
        else {
            double razon = (double) arr[1] / arr[0];
            for (int i = 1; i < arr.length; i++) {
                if ((double) arr[i] / arr[i-1] != razon) {
                    geometrica = false;
                    break;
                }
            }
        }

        if (aritmetica) return "Progresión aritmética (diferencia = " + diferencia + ")";
        if (geometrica) return "Progresión geométrica (razón = " + (double) arr[1]/arr[0] + ")";
        return "No es progresión aritmética ni geométrica";
    }
}

