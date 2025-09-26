package vistas;

import database.Puntos;
import java.awt.*;
import javax.swing.*;

public class VistaInfo extends JPanel {
    private JLabel labelTiempo;
    private JLabel labelPuntos;
    private Puntos puntosData;
    private Timer timer;

    public VistaInfo(Puntos puntosData) {
        this.puntosData = puntosData;

        setLayout(new GridLayout(1, 2, 10, 10));
        setBackground(Color.DARK_GRAY);

        // Etiqueta de tiempo
        labelTiempo = new JLabel("⏱ Tiempo: 0s", SwingConstants.CENTER);
        labelTiempo.setForeground(Color.WHITE);
        labelTiempo.setFont(new Font("Arial", Font.BOLD, 16));

        // Etiqueta de puntos
        labelPuntos = new JLabel("⭐ Puntos: 0", SwingConstants.CENTER);
        labelPuntos.setForeground(Color.WHITE);
        labelPuntos.setFont(new Font("Arial", Font.BOLD, 16));

        add(labelTiempo);
        add(labelPuntos);

        // Timer que actualiza el tiempo cada segundo
        timer = new Timer(1000, e -> {
            puntosData.incrementarSegundos();
            actualizarLabels();
        });
        timer.start();
    }

    // Actualiza las etiquetas de tiempo y puntos
    public void actualizarLabels() {
        labelTiempo.setText("⏱ Tiempo: " + puntosData.getSegundos() + "s");
        labelPuntos.setText("⭐ Puntos: " + puntosData.getPuntos());
    }

    // Reinicia tiempo y puntos
    public void reiniciar() {
        puntosData.reiniciar();
        actualizarLabels();
        timer.restart();
    }
}
