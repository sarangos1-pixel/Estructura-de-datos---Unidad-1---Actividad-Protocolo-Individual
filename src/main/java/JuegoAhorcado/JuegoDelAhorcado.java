package JuegoAhorcado;

import java.util.Scanner;

public class JuegoDelAhorcado {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "SOFTWARE";

        char[] palabra = palabraSecreta.toCharArray();
        char[] palabraOculta = new char[palabra.length];

        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '_';
        }

        System.out.print("¿Cuántos jugadores participaran? ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine();

        String[] jugadores = new String[numJugadores];
        int[] puntajes = new int[numJugadores];

        for (int j = 0; j < numJugadores; j++) {

            System.out.println(" Jugador " + (j + 1) + " ===");

            System.out.print("Nombre: ");
            jugadores[j] = scanner.nextLine();

            // Reiniciar palabra oculta
            for (int i = 0; i < palabraOculta.length; i++) {
                palabraOculta[i] = '_';
            }

            int errores = 0;
            int maxErrores = 6;
            boolean gano = false;

            while (errores < maxErrores) {

                System.out.print("Palabra: ");

                for (char c : palabraOculta) {
                    System.out.print(c + " ");
                }

                System.out.print("Ingrese una letra: ");
                char letra = Character.toUpperCase(scanner.next().charAt(0));

                boolean encontrada = false;

                for (int i = 0; i < palabra.length; i++) {

                    if (palabra[i] == letra) {
                        palabraOculta[i] = letra;
                        encontrada = true;
                    }
                }

                if (!encontrada) {
                    errores++;
                    System.out.println("Incorrecto. Errores: " + errores);
                }

                gano = true;

                for (int i = 0; i < palabra.length; i++) {

                    if (palabraOculta[i] != palabra[i]) {
                        gano = false;
                        break;
                    }
                }

                if (gano) {
                    break;
                }
            }

            if (gano) {
                puntajes[j] = (maxErrores - errores) * 10;
                System.out.println("¡Felicidades! Adivinaste la palabra.");
            } else {
                puntajes[j] = 0;
                System.out.println("Perdiste.");
            }

            System.out.println("La palabra era: " + palabraSecreta);

            scanner.nextLine();
        }

        System.out.println("===== RESULTADOS =====");

        for (int i = 0; i < numJugadores; i++) {
            System.out.println(
                    jugadores[i] + " -> " +
                            puntajes[i] + " puntos");
        }

        scanner.close();
    }
}