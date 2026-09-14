package AnalizadorDeTexto;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class AnalizadorTexto {
    public static void main(String[] args) {

        // Párrafo de ejemplo
        String texto = "La ingeniería de software es la aplicación de un enfoque sistemático, disciplinado y " +
                      "cuantificable al diseño, desarrollo, pruebas y mantenimiento de programas informáticos";

        // Normalizar: quitar signos de puntuación y pasar a minúsculas
        texto = texto.replaceAll("[^a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]", "").toLowerCase();

        // Dividir en palabras y guardarlas en un arreglo
        String[] palabras = texto.split("\\s+");

        // Contar repeticiones usando un mapa
        Map<String, Integer> frecuencia = new HashMap<>();
        for (String palabra : palabras) {
            frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
        }

        // Ordenar por frecuencia (de mayor a menor)
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(frecuencia.entrySet());
        lista.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Mostrar las 5 más frecuentes
        System.out.println("Top 5 palabras más frecuentes");
        for (int i = 0; i < Math.min(5, lista.size()); i++) {
            System.out.println(lista.get(i).getKey() + " → " + lista.get(i).getValue() + " veces");
        }
    }
}
