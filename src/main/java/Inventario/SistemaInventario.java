package Inventario;

import java.util.Scanner;

public class SistemaInventario {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Producto[] productos = new Producto[3];

        productos[0] = new Producto("Laptop", 10);
        productos[1] = new Producto("Mouse", 25);
        productos[2] = new Producto("Teclado", 15);

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE INVENTARIO =====");
            System.out.println("1. Ver existencias");
            System.out.println("2. Registrar entrada");
            System.out.println("3. Registrar salida");
            System.out.println("4. Ver historial");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("EXISTENCIAS:");

                    for (Producto producto : productos) {
                        producto.mostrarExistencias();
                    }

                    break;

                case 2:

                    System.out.println("Productos disponibles:");

                    for (int i = 0; i < productos.length; i++) {
                        System.out.println(i + " - " + productos[i].nombre);
                    }

                    System.out.print("Seleccione producto: ");
                    int indiceEntrada = scanner.nextInt();

                    System.out.print("Cantidad a ingresar: ");
                    int entrada = scanner.nextInt();

                    productos[indiceEntrada].registrarEntrada(entrada);

                    break;

                case 3:

                    System.out.println("Productos disponibles:");

                    for (int i = 0; i < productos.length; i++) {
                        System.out.println(i + " - " + productos[i].nombre);
                    }

                    System.out.print("Seleccione producto: ");
                    int indiceSalida = scanner.nextInt();

                    System.out.print("Cantidad a retirar: ");
                    int salida = scanner.nextInt();

                    productos[indiceSalida].registrarSalida(salida);

                    break;

                case 4:

                    System.out.println("Productos disponibles:");

                    for (int i = 0; i < productos.length; i++) {
                        System.out.println(i + " - " + productos[i].nombre);
                    }

                    System.out.print("Seleccione producto: ");
                    int indiceHistorial = scanner.nextInt();

                    productos[indiceHistorial].mostrarHistorial();

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

class Producto {

    String nombre;
    int stock;

    String[] historial = new String[50];
    int totalMovimientos = 0;

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    public void registrarEntrada(int cantidad) {

        stock += cantidad;

        historial[totalMovimientos] =
                "Entrada de " + cantidad + " unidades";

        totalMovimientos++;
    }

    public void registrarSalida(int cantidad) {

        if (cantidad <= stock) {

            stock -= cantidad;

            historial[totalMovimientos] =
                    "Salida de " + cantidad + " unidades";

            totalMovimientos++;

        } else {

            System.out.println("No hay suficiente stock.");
        }
    }

    public void mostrarExistencias() {
        System.out.println(nombre + " | Stock: " + stock);
    }

    public void mostrarHistorial() {

        System.out.println("\nHistorial de " + nombre);

        if (totalMovimientos == 0) {

            System.out.println("No hay movimientos registrados.");

        } else {

            for (int i = 0; i < totalMovimientos; i++) {
                System.out.println((i + 1) + ". " + historial[i]);
            }
        }
    }
}
