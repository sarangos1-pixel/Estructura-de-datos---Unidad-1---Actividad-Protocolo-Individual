package SimuladorDeVentas;

public class SimuladorVentas {
    public static void main(String[] args) {
        // Arreglo de productos
        String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor"};

        // Arreglo de precios
        double[] precios = {2500.0, 25.0, 45.0, 300.0};

        // Arreglo de cantidades vendidas
        int[] cantidades = {10, 50, 30, 20};

        // Arreglo para totales por producto
        double[] totales = new double[productos.length];

        double totalGeneral = 0;
        int indiceMasVendido = 0;

        // Calcular totales
        for (int i = 0; i < productos.length; i++) {
            totales[i] = precios[i] * cantidades[i];
            totalGeneral += totales[i];

            // Verificar producto más vendido (por cantidad)
            if (cantidades[i] > cantidades[indiceMasVendido]) {
                indiceMasVendido = i;
            }
        }

        // Mostrar resultados
        System.out.println("Reporte de Ventas ");
        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i] + ": " + cantidades[i] + " unidades, Total = $" + totales[i]);
        }

        System.out.println("Total General: $" + totalGeneral);
        System.out.println("Producto más vendido: " + productos[indiceMasVendido] + " (" + cantidades[indiceMasVendido] + " unidades)");
    }
}

