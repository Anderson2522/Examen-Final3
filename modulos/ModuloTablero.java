package modulos;

import component.ComponentCarta;
import java.awt.*;
import javax.swing.*;

public class ModuloTablero extends JPanel {
    private int rows;
    private int cols;
    private ComponentCarta[][] cartas;

    public ModuloTablero(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cartas = new ComponentCarta[rows][cols];
        inicializarTablero();
    }

    private void inicializarTablero() {
        setLayout(new GridLayout(rows, cols, 5, 5));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cartas[i][j] = new ComponentCarta();
                add(cartas[i][j]);
            }
        }
    }

    public ComponentCarta getCard(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return cartas[row][col];
        return null;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
}
