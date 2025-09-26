package vistas;

import control.JuegoControl;
import database.Puntos;
import java.awt.*;
import javax.swing.*;
import modulos.ModuloTablero;

public class VistaNivelDos extends JFrame {
    public VistaNivelDos() {
        setTitle("Nivel 2 - Memoria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Puntos puntosData = new Puntos();
        VistaInfo vistaInfo = new VistaInfo(puntosData);
        add(vistaInfo, BorderLayout.NORTH);

        ModuloTablero tablero = new ModuloTablero(4, 4);
        add(tablero, BorderLayout.CENTER);

        new JuegoControl(tablero, 2, vistaInfo, puntosData);

        setVisible(true);
    }
}
