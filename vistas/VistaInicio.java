package vistas;

import java.awt.*;
import javax.swing.*;

public class VistaInicio extends JFrame {

    public VistaInicio() {
        setTitle("Bienvenido al Juego de Memoria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Mensaje de bienvenida
        JLabel bienvenida = new JLabel("¡Bienvenido al Juego de Memoria!", SwingConstants.CENTER);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        add(bienvenida, BorderLayout.CENTER);

        // Panel con botones de niveles en columna
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(0, 1, 10, 10)); // 1 columna, espacio vertical 10px

        JButton nivel1 = crearBotonRedondeado("Nivel 1");
        JButton nivel2 = crearBotonRedondeado("Nivel 2");

        panelBotones.add(nivel1);
        panelBotones.add(nivel2);

        // Contenedor para centrar los botones
        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        contenedorBotones.add(panelBotones);
        add(contenedorBotones, BorderLayout.SOUTH);

        // Acciones de los botones
        nivel1.addActionListener(e -> {
            new VistaNivelUno();
            dispose();
        });

        nivel2.addActionListener(e -> {
            new VistaNivelDos();
            dispose();
        });

        setVisible(true);
    }

    // Método para crear botón redondeado con tamaño
    private JButton crearBotonRedondeado(String texto) {
        JButton boton = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Bordes redondeados
                g2.dispose();
                super.paintComponent(g);
            }

            @Override
            public void updateUI() {
                super.updateUI();
                setContentAreaFilled(false);
                setFocusPainted(false);
            }
        };

        boton.setPreferredSize(new Dimension(150, 50)); // Tamaño del botón
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(new Color(100, 149, 237)); // Color azul tipo Cornflower
        boton.setForeground(Color.WHITE);

        return boton;
    }
}
