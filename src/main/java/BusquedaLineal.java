public class BusquedaLineal {

    public static void main(String[] args) {

        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int objetivo = 5;

        int resultado = busquedaLineal(numeros, objetivo);

        if (resultado != -1) {
            System.out.println("Elemento encontrado en la posición: " + resultado);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }

    public static int busquedaLineal(int[] numeros, int objetivo) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}