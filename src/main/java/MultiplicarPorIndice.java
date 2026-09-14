import java.util.Random;

public class MultiplicarPorIndice {

    public static void main(String[] args) {

        int[] numeros = new int[10];
        Random random = new Random();

        // Llenar el arreglo con valores aleatorios
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1;
        }

        // Mostrar arreglo original
        System.out.println("Arreglo original:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Índice " + i + ": " + numeros[i]);
        }

        // Multiplicar cada valor por su índice
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = numeros[i] * i;
        }

        // Mostrar arreglo modificado
        System.out.println("\nArreglo después de multiplicar por su índice:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Índice " + i + ": " + numeros[i]);
        }
    }
}