package AnalizadorDeClima;

public class AnalizadorClima {
    public static void main(String[] args) {
        // Datos: [día][0] = temperatura, [día][1] = humedad
        int[][] datos = {
                {30, 70}, {32, 65}, {28, 80}, {27, 90}, {29, 75},
                {31, 60}, {33, 85}, {34, 72}, {28, 68}, {26, 95},
                {25, 50}, {27, 55}, {29, 60}, {30, 65}, {32, 70},
                {35, 85}, {36, 90}, {33, 75}, {31, 65}, {28, 60},
                {27, 55}, {26, 50}, {25, 45}, {29, 70}, {30, 75},
                {32, 80}, {34, 85}, {33, 65}, {31, 60}, {28, 55}
        };

        // Calcular promedios
        double promTemp = promedio(datos, 0);
        double promHum = promedio(datos, 1);

        System.out.println("**** Análisis Climático ****");
        System.out.println("Promedio mensual temperatura: " + promTemp + "°C");
        System.out.println("Promedio mensual humedad: " + promHum + "%");

        // Detectar anomalías
        System.out.println(" Anomalías detectadas");
        detectarAnomalias(datos);
    }

    // Calcular promedio de una columna (0 = temperatura, 1 = humedad)
    public static double promedio(int[][] datos, int columna) {
        int suma = 0;
        for (int i = 0; i < datos.length; i++) {
            suma += datos[i][columna];
        }
        return (double) suma / datos.length;
    }

    // Detectar anomalías (ejemplo: temperatura < 20 o > 40, humedad < 30 o > 90)
    public static void detectarAnomalias(int[][] datos) {
        for (int i = 0; i < datos.length; i++) {
            int temp = datos[i][0];
            int hum = datos[i][1];
            boolean anomalia = false;

            if (temp < 20 || temp > 40) {
                System.out.println("Día " + (i+1) + ": Temperatura anómala (" + temp + "°C)");
                anomalia = true;
            }
            if (hum < 30 || hum > 90) {
                System.out.println("Día " + (i+1) + ": Humedad anómala (" + hum + "%)");
                anomalia = true;
            }
            if (!anomalia) {

            }
        }
    }
}
