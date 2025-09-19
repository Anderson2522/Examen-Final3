import view.module.BoardView;
import view.module.StartView;
import control.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private StartView startView;
    private BoardView boardView;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Juego de Memoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);

        // Usar CardLayout para cambiar entre ventanas
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Crear ventana de inicio
        startView = new StartView();
        
        // Crear ventana del juego (pero no inicializarla todavía)
        boardView = new BoardView(4, 4);
        
        // Añadir ambas vistas al panel principal
        mainPanel.add(startView, "start");
        mainPanel.add(boardView, "game");

        frame.add(mainPanel);
        
        // Mostrar la ventana de inicio primero
        cardLayout.show(mainPanel, "start");

        // Añadir listener al botón de iniciar
        startView.addStartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });

        frame.setVisible(true);
    }

    private void iniciarJuego() {
        // Cambiar a la vista del juego
        cardLayout.show(mainPanel, "game");
        
        // Inicializar el controlador del juego
        new GameController(boardView);
        
        // Enfocar el panel del juego
        boardView.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}