package view.module;

import java.awt.*;
import javax.swing.*;
import view.component.CardView;

public class BoardView extends JPanel {
    private CardView[][] cards;
    private int rows, cols;

    public BoardView(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.setLayout(new GridLayout(rows, cols, 5, 5));
        this.setBackground(new Color(240, 240, 240));
        cards = new CardView[rows][cols];

        // Crear y añadir cartas al tablero
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                CardView card = new CardView();
                cards[r][c] = card;
                this.add(card);
            }
        }
    }

    public CardView getCard(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return cards[row][col];
        }
        return null;
    }

    public int getRows() { 
        return rows; 
    }
    
    public int getCols() { 
        return cols; 
    }

    public boolean allRevealed() {
        for (CardView[] row : cards) {
            for (CardView card : row) {
                if (card.isEnabled() && !card.isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }
}