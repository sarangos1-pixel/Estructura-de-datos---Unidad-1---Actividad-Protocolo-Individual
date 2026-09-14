package AgendaTelefono;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class AgendaTelefonica {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nombres = new String[100];
        String[] telefonos = new String[100];
        String[] correos = new String[100];

        int totalContactos = 0;
        int opcion;

        do {

            System.out.println("\n===== AGENDA TELEFONICA =====");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Buscar por correo");
            System.out.println("4. Mostrar contactos");
            System.out.println("5. Exportar a archivo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    nombres[totalContactos] = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    telefonos[totalContactos] = scanner.nextLine();

                    System.out.print("Correo: ");
                    correos[totalContactos] = scanner.nextLine();

                    totalContactos++;

                    System.out.println("Contacto agregado.");
                    break;

                case 2:

                    System.out.print("Ingrese el nombre o prefijo: ");
                    String prefijo = scanner.nextLine().toLowerCase();

                    System.out.println("\nResultados:");

                    for (int i = 0; i < totalContactos; i++) {

                        if (nombres[i].toLowerCase().startsWith(prefijo)) {

                            System.out.println(
                                    nombres[i] + " | " +
                                            telefonos[i] + " | " +
                                            correos[i]);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Ingrese parte del correo: ");
                    String textoCorreo = scanner.nextLine().toLowerCase();

                    System.out.println("\nResultados:");

                    for (int i = 0; i < totalContactos; i++) {

                        if (correos[i].toLowerCase().contains(textoCorreo)) {

                            System.out.println(
                                    nombres[i] + " | " +
                                            telefonos[i] + " | " +
                                            correos[i]);
                        }
                    }

                    break;

                case 4:

                    System.out.println("\nLISTA DE CONTACTOS");

                    for (int i = 0; i < totalContactos; i++) {

                        System.out.println(
                                nombres[i] + " | " +
                                        telefonos[i] + " | " +
                                        correos[i]);
                    }

                    break;

                case 5:

                    try {

                        PrintWriter archivo =
                                new PrintWriter("agenda.txt");

                        for (int i = 0; i < totalContactos; i++) {

                            archivo.println(
                                    nombres[i] + " | " +
                                            telefonos[i] + " | " +
                                            correos[i]);
                        }

                        archivo.close();

                        System.out.println(
                                "Agenda exportada a agenda.txt");

                    } catch (IOException e) {

                        System.out.println(
                                "Error al crear el archivo.");
                    }

                    break;

                case 0:

                    System.out.println("Programa finalizado.");
                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}