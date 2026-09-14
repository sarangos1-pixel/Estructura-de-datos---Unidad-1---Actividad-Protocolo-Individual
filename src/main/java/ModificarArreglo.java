import java.util.Random;

public class ModificarArreglo {

    public static void main(String[] args) {

        int[] numeros = new int[10];
        Random rd = new Random();

        // Llenar el arreglo con valores aleatorios
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rd.nextInt(100) + 1;
        }

        // Mostrar arreglo original
        System.out.println("Arreglo original:");

        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        // Cambiar valores impares a cero
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                numeros[i] = 0;
            }
        }

        // Mostrar arreglo modificado
        System.out.println("\n\nArreglo después de cambiar los impares a cero:");

        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}