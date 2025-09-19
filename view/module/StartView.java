package view.module;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartView extends JPanel {
    private JButton startButton;
    private JLabel welcomeLabel;

    public StartView() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        // Panel principal con padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(240, 240, 240));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Texto de bienvenida
        welcomeLabel = new JLabel("¡Bienvenido al Juego de Memoria!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(50, 50, 150));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        // Botón de iniciar
        startButton = new JButton("Iniciar Juego");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBackground(new Color(70, 130, 180));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir componentes al panel principal
        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(startButton);

        add(mainPanel, BorderLayout.CENTER);
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public JButton getStartButton() {
        return startButton;
    }
}