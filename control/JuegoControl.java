package control;

import component.ComponentCarta;
import database.Puntos;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import modulos.ModuloTablero;
import vistas.VistaInfo;

public class JuegoControl {
    private ModuloTablero tablero;
    private VistaInfo vistaInfo;
    private Puntos puntosData;

    private ComponentCarta primeraCarta = null;
    private ComponentCarta segundaCarta = null;
    private boolean bloqueado = false;

    private int paresEncontrados = 0;
    private int intentos = 0;

    public JuegoControl(ModuloTablero tablero, int nivel, VistaInfo vistaInfo, Puntos puntosData) {
        this.tablero = tablero;
        this.vistaInfo = vistaInfo;
        this.puntosData = puntosData;
        inicializarCartas();
    }

    private void inicializarCartas() {
        int filas = tablero.getRows();
        int columnas = tablero.getCols();
        int totalCartas = filas * columnas;

        if (totalCartas % 2 != 0) {
            JOptionPane.showMessageDialog(tablero,
                    "El tablero debe tener número par de cartas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Integer> valores = new ArrayList<>();
        for (int i = 0; i < totalCartas / 2; i++) {
            valores.add(i);
            valores.add(i);
        }
        Collections.shuffle(valores);

        int index = 0;
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                ComponentCarta carta = tablero.getCard(f, c);
                carta.setValue(valores.get(index++));
                carta.hideValue();
                carta.setEnabled(true);

                for (java.awt.event.ActionListener al : carta.getActionListeners())
                    carta.removeActionListener(al);

                carta.addActionListener(e -> manejarClick(carta));
            }
        }

        primeraCarta = null;
        segundaCarta = null;
        bloqueado = false;
        paresEncontrados = 0;
        intentos = 0;
        vistaInfo.reiniciar();
    }

    private void manejarClick(ComponentCarta carta) {
        if (bloqueado || carta.isRevealed()) return;

        carta.revealValue();

        if (primeraCarta == null) {
            primeraCarta = carta;
        } else {
            segundaCarta = carta;
            bloqueado = true;
            intentos++;

            Timer timer = new Timer(600, e -> {
                if (primeraCarta.getValue() == segundaCarta.getValue()) {
                    primeraCarta.marcarCorrecta();
                    segundaCarta.marcarCorrecta();
                    paresEncontrados++;
                    puntosData.sumarPuntos(10);
                } else {
                    primeraCarta.hideValue();
                    segundaCarta.hideValue();
                }

                primeraCarta = null;
                segundaCarta = null;
                bloqueado = false;
                vistaInfo.actualizarLabels();

                if (paresEncontrados >= (tablero.getRows() * tablero.getCols()) / 2) {
                    mostrarVictoria();
                }
                ((Timer) e.getSource()).stop();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void mostrarVictoria() {
        double eficiencia = (paresEncontrados / (double) intentos) * 100;
        String mensaje = String.format("¡Felicidades!\nPares: %d\nIntentos: %d\nEficiencia: %.1f%%",
                paresEncontrados, intentos, eficiencia);
        JOptionPane.showMessageDialog(tablero, mensaje, "Victoria", JOptionPane.INFORMATION_MESSAGE);

        int opcion = JOptionPane.showConfirmDialog(tablero,
                "¿Quieres jugar otra vez?", "Reiniciar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            inicializarCartas();
        }
    }
}
