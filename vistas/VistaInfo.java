package vistas;

import database.Puntos;
import java.awt.*;
import javax.swing.*;

public class VistaInfo extends JPanel {
    private JLabel labelTiempo;
    private JLabel labelPuntos;
    private JLabel labelMaxPuntos; // Nuevo label para puntaje más alto
    private Puntos puntosData;
    private Timer timer;

    public VistaInfo(Puntos puntosData) {
        this.puntosData = puntosData;

        setLayout(new GridLayout(1, 3, 10, 10)); // Ahora 3 columnas
        setBackground(Color.DARK_GRAY);

        // Etiqueta de tiempo
        labelTiempo = new JLabel("⏱ Tiempo: 0s", SwingConstants.CENTER);
        labelTiempo.setForeground(Color.WHITE);
        labelTiempo.setFont(new Font("Arial", Font.BOLD, 16));

        // Etiqueta de puntos
        labelPuntos = new JLabel("⭐ Puntos: 0", SwingConstants.CENTER);
        labelPuntos.setForeground(Color.WHITE);
        labelPuntos.setFont(new Font("Arial", Font.BOLD, 16));

        // Etiqueta de puntaje máximo
        labelMaxPuntos = new JLabel("🏆 Máx: 0", SwingConstants.CENTER);
        labelMaxPuntos.setForeground(Color.YELLOW);
        labelMaxPuntos.setFont(new Font("Arial", Font.BOLD, 16));

        add(labelTiempo);
        add(labelPuntos);
        add(labelMaxPuntos);

        // Timer que actualiza tiempo y labels cada segundo
        timer = new Timer(1000, e -> {
            puntosData.incrementarSegundos();
            actualizarLabels();
        });
        timer.start();
    }

    // Actualiza los labels
    public void actualizarLabels() {
        labelTiempo.setText("⏱ Tiempo: " + puntosData.getSegundos() + "s");
        labelPuntos.setText("⭐ Puntos: " + puntosData.getPuntos());

        // Calcular puntaje máximo
        int max = puntosData.getHistorialPuntos().stream().max(Integer::compare).orElse(0);
        labelMaxPuntos.setText("🏆 Máx: " + max);
    }

    public void reiniciar() {
        puntosData.reiniciar();
        actualizarLabels();
        timer.restart();
    }

    // Getter para acceder al objeto Puntos desde JuegoControl
    public Puntos getPuntosData() {
        return puntosData;
    }
}
