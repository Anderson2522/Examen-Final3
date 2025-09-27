package database;

import java.util.ArrayList;

public class Puntos {
    private int puntos;
    private int segundos;
    private ArrayList<Integer> historialPuntos; // <-- Array para almacenar puntos

    public Puntos() {
        puntos = 0;
        segundos = 0;
        historialPuntos = new ArrayList<>();
    }

    // Sumar puntos y guardarlos en el historial
    public void sumarPuntos(int cantidad) {
        puntos += cantidad;
        historialPuntos.add(puntos); // guardamos el valor actual en el array
    }

    public int getPuntos() {
        return puntos;
    }

    // Obtener historial completo
    public ArrayList<Integer> getHistorialPuntos() {
        return historialPuntos;
    }

    public void incrementarSegundos() {
        segundos++;
    }

    public int getSegundos() {
        return segundos;
    }

    public void reiniciar() {
        puntos = 0;
        segundos = 0;
        historialPuntos.clear(); // opcional: reiniciar historial
    }
}
