package database;

public class Puntos {
    private int puntos;
    private int segundos;

    public Puntos() {
        puntos = 0;
        segundos = 0;
    }

    public void sumarPuntos(int cantidad) {
        puntos += cantidad;
    }

    public int getPuntos() {
        return puntos;
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
    }
}
