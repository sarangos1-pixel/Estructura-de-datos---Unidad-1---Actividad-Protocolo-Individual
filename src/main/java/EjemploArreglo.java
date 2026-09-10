import java.util.Random;

public class EjemploArreglo {

    public static void main(String[] args) {

        int[] numeros = new int[10];
        Random rd = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rd.nextInt(100) + 1;
        }

        System.out.println("Arreglo generado:");

        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}