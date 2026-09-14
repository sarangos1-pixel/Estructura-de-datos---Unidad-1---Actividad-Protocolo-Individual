package GenderadorDeContraseñas;

import java.util.Random;

public class GeneradorContrasenas {
    public static void main(String[] args) {
        int longitud = 12; // Puedes cambiar la longitud aquí
        String contrasena = generarContrasena(longitud);
        System.out.println("Contraseña generada: " + contrasena);
    }

    public static String generarContrasena(int longitud) {

        // Arreglos de caracteres
        char[] mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] minusculas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digitos = "0123456789".toCharArray();
        char[] simbolos = "!@#$%&*-_".toCharArray();

        // Unir todos los caracteres en un solo arreglo
        String todos = new String(mayusculas) + new String(minusculas) + new String(digitos) + new String(simbolos);
        char[] todosChars = todos.toCharArray();

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        // Garantizar al menos un carácter de cada tipo
        sb.append(mayusculas[rand.nextInt(mayusculas.length)]);
        sb.append(minusculas[rand.nextInt(minusculas.length)]);
        sb.append(digitos[rand.nextInt(digitos.length)]);
        sb.append(simbolos[rand.nextInt(simbolos.length)]);

        // Completar hasta la longitud deseada
        for (int i = sb.length(); i < longitud; i++) {
            sb.append(todosChars[rand.nextInt(todosChars.length)]);
        }

        // Mezclar la contraseña para que no siempre empiece con los 4 tipos
        return mezclar(sb.toString().toCharArray());
    }

    // Metodo para mezclar caracteres
    private static String mezclar(char[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int j = rand.nextInt(array.length);
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return new String(array);
    }
}

