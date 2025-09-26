package vistas;

import control.JuegoControl;
import database.Puntos;
import java.awt.*;
import javax.swing.*;
import modulos.ModuloTablero;

public class VistaNivelUno extends JFrame {
    public VistaNivelUno() {
        setTitle("Nivel 1 - Memoria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de puntos y tiempo
        Puntos puntosData = new Puntos();
        VistaInfo vistaInfo = new VistaInfo(puntosData);
        add(vistaInfo, BorderLayout.NORTH);

        // Tablero
        ModuloTablero tablero = new ModuloTablero(2, 3);
        add(tablero, BorderLayout.CENTER);

        // Control del juego
        new JuegoControl(tablero, 1, vistaInfo, puntosData);

        // Botón "Regresar a Bienvenida"
        JButton btnRegresar = new JButton("Regresar a Bienvenida");
        btnRegresar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegresar.setBackground(new Color(220, 20, 60)); // Rojo
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setPreferredSize(new Dimension(200, 40));
        btnRegresar.addActionListener(e -> {
            new VistaInicio();       // Abrir pantalla de bienvenida
            dispose();               // Cerrar ventana actual
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnRegresar);
        add(panelBoton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
