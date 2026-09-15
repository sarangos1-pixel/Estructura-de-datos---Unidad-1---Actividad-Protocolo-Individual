package paquetes;


public class CafeteriaPedidos {
    public static void main(String[] args) {

        // Arreglo de pedidos del día
        String[] pedidos = {
                "Café", "Té", "Café", "Jugo", "Café",
                "Té", "Sandwich", "Café", "Jugo", "Té"
        };

        // Tipos de productos
        String[] tipos = {"Café", "Té", "Jugo", "Sandwich"};
        int[] conteo = new int[tipos.length];

        // Contar pedidos por tipo
        for (String pedido : pedidos) {
            for (int i = 0; i < tipos.length; i++) {
                if (pedido.equalsIgnoreCase(tipos[i])) {
                    conteo[i]++;
                }
            }
        }

        // Mostrar conteo
        System.out.println("*** Registro de Pedidos ***");
        for (int i = 0; i < tipos.length; i++) {
            System.out.println(tipos[i] + ": " + conteo[i]);
        }

        // Encontrar el más solicitado
        int max = 0;
        int idxMax = 0;
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] > max) {
                max = conteo[i];
                idxMax = i;
            }
        }
        System.out.println("Más solicitado: " + tipos[idxMax] + " (" + max + " pedidos)");
    }
}
