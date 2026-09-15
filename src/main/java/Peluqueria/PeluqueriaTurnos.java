package Peluqueria;

import java.util.Scanner;

public class PeluqueriaTurnos {
    public static void main(String[] args) {
        // Arreglo de horarios disponibles
        String[] horarios = {
                "09:00", "10:00", "11:00", "12:00",
                "13:00", "14:00", "15:00", "16:00"
        };

        // Estado de cada horario (true = ocupado, false = libre)
        boolean[] ocupado = new boolean[horarios.length];

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("*** Control de Turnos ***");
            System.out.println("1. Mostrar horarios");
            System.out.println("2. Registrar cita");
            System.out.println("3. Cancelar cita");
            System.out.println("4. Salir");
            System.out.print("Elige opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarHorarios(horarios, ocupado);
                    break;
                case 2:
                    System.out.print("Ingrese número de horario (0-" + (horarios.length-1) + "): ");
                    int h = sc.nextInt();
                    registrarCita(horarios, ocupado, h);
                    break;
                case 3:
                    System.out.print("Ingrese número de horario (0-" + (horarios.length-1) + "): ");
                    int c = sc.nextInt();
                    cancelarCita(horarios, ocupado, c);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    // Mostrar horarios libres y ocupados
    private static void mostrarHorarios(String[] horarios, boolean[] ocupado) {
        System.out.println("*** Horarios ***1");
        for (int i = 0; i < horarios.length; i++) {
            String estado = ocupado[i] ? "Ocupado" : "Libre";
            System.out.println(i + ". " + horarios[i] + " → " + estado);
        }
    }

    // Registrar cita
    private static void registrarCita(String[] horarios, boolean[] ocupado, int idx) {
        if (idx < 0 || idx >= horarios.length) {
            System.out.println("Horario inválido.");
            return;
        }
        if (ocupado[idx]) {
            System.out.println("Ese horario ya está ocupado.");
        } else {
            ocupado[idx] = true;
            System.out.println("Cita registrada en " + horarios[idx]);
        }
    }

    // Cancelar cita
    private static void cancelarCita(String[] horarios, boolean[] ocupado, int idx) {
        if (idx < 0 || idx >= horarios.length) {
            System.out.println("Horario inválido.");
            return;
        }
        if (!ocupado[idx]) {
            System.out.println("Ese horario ya estaba libre.");
        } else {
            ocupado[idx] = false;
            System.out.println("Cita cancelada en " + horarios[idx]);
        }
    }
}
