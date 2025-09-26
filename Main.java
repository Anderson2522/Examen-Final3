import javax.swing.*;
import vistas.VistaInicio;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaInicio(); 
        });
    }
}
