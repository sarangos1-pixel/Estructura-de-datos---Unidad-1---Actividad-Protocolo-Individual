package MezcladorDeCanciones;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class MezcladorCanciones {
    public static void main(String[] args) {

        // Arreglo de canciones
        Cancion[] canciones = {
                new Cancion("Song A", "Artista 1", 180),
                new Cancion("Song B", "Artista 2", 200),
                new Cancion("Song C", "Artista 1", 240),
                new Cancion("Song D", "Artista 3", 150),
                new Cancion("Song E", "Artista 2", 300)
        };

        // Crear playlist aleatoria
        List<Cancion> playlist = crearPlaylistAleatoria(canciones);
        System.out.println("Playlist Aleatoria ");
        for (Cancion c : playlist) {
            System.out.println(c);
        }

        // Filtrar por artista
        System.out.println("Canciones de Artista 1 ");
        filtrarPorArtista(canciones, "Artista 1");

        // Filtrar por duración
        System.out.println("Canciones con duración <= 200s ");
        filtrarPorDuracion(canciones, 200);
    }

    // Crear playlist aleatoria sin repetir canciones
    public static List<Cancion> crearPlaylistAleatoria(Cancion[] canciones) {
        List<Cancion> lista = new ArrayList<>();
        List<Integer> indicesUsados = new ArrayList<>();
        Random rand = new Random();

        while (indicesUsados.size() < canciones.length) {
            int idx = rand.nextInt(canciones.length);
            if (!indicesUsados.contains(idx)) {
                lista.add(canciones[idx]);
                indicesUsados.add(idx);
            }
        }
        return lista;
    }

    // Filtrar por artista
    public static void filtrarPorArtista(Cancion[] canciones, String artista) {
        for (Cancion c : canciones) {
            if (c.artista.equalsIgnoreCase(artista)) {
                System.out.println(c);
            }
        }
    }

    // Filtrar por duración
    public static void filtrarPorDuracion(Cancion[] canciones, int maxDuracion) {
        for (Cancion c : canciones) {
            if (c.duracion <= maxDuracion) {
                System.out.println(c);
            }
        }
    }
}

// Clase Cancion
class Cancion {
    String titulo;
    String artista;
    int duracion; // en segundos

    Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + duracion + "s)";
    }
}
