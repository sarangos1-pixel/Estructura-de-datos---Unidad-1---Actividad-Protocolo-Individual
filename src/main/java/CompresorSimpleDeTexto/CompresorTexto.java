package CompresorSimpleDeTexto;

import java.util.Scanner;

public class CompresorTexto {

    // Metodo para comprimir
    public static String comprimir(String texto) {

        if (texto.isEmpty()) {
            return "";
        }

        char[] letras = texto.toCharArray();

        String comprimido = "";
        int contador = 1;

        for (int i = 1; i < letras.length; i++) {

            if (letras[i] == letras[i - 1]) {
                contador++;
            } else {
                comprimido += letras[i - 1] + String.valueOf(contador);
                contador = 1;
            }
        }

        comprimido += letras[letras.length - 1] + String.valueOf(contador);

        return comprimido;
    }

    // Metodo para descomprimir
    public static String descomprimir(String texto) {

        String resultado = "";

        for (int i = 0; i < texto.length(); i += 2) {

            char letra = texto.charAt(i);
            int cantidad = Character.getNumericValue(texto.charAt(i + 1));

            for (int j = 0; j < cantidad; j++) {
                resultado += letra;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un texto: ");
        String texto = scanner.nextLine();

        // Guardar letras en arreglo
        char[] arreglo = texto.toCharArray();

        System.out.println("Contenido del arreglo:");

        for (char letra : arreglo) {
            System.out.print(letra + " ");
        }

        String comprimido = comprimir(texto);
        String descomprimido = descomprimir(comprimido);

        System.out.println("Texto comprimido: " + comprimido);
        System.out.println("Texto descomprimido: " + descomprimido);

        scanner.close();
    }
}
