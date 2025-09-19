package control;

import java.util.*;
import javax.swing.*;
import view.component.CardView;
import view.module.BoardView;

public class GameController {
    private BoardView board;
    private CardView firstCard = null;
    private boolean lock = false;
    private int paresEncontrados = 0;

    public GameController(BoardView board) {
        this.board = board;
        inicializarCartas();
    }

    private void inicializarCartas() {
        int rows = board.getRows();
        int cols = board.getCols();
        int totalCartas = rows * cols;

        // Crear lista de valores (pares)
        List<Integer> valores = new ArrayList<>();
        for (int i = 0; i < totalCartas / 2; i++) {
            valores.add(i); // Primer carta del par
            valores.add(i); // Segunda carta del par
        }
        
        // Mezclar las cartas
        Collections.shuffle(valores);

        // Asignar valores a las cartas
        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int valor = valores.get(index++);
                CardView card = board.getCard(r, c);
                card.setValue(valor);
                card.hideValue(); // Mostrar reverso inicialmente

                // Añadir listener para manejar clics
                card.addActionListener(e -> manejarClick(card));
            }
        }
    }

    private void manejarClick(CardView card) {
        // No hacer nada si está bloqueado, ya revelada o es la misma carta
        if (lock || card.isRevealed() || card == firstCard) {
            return;
        }

        // Mostrar el valor de la carta
        card.showValue();

        if (firstCard == null) {
            // Primera carta seleccionada
            firstCard = card;
        } else {
            // Segunda carta seleccionada - verificar si son pares
            lock = true; // Bloquear para evitar más clics

            
                if (firstCard.getValue() == card.getValue()) {
                    // ¡Par encontrado!
                    firstCard.setEnabled(false);
                    card.setEnabled(false);
                    paresEncontrados++;
                    
                    // Verificar si ganó
                    if (paresEncontrados == (board.getRows() * board.getCols()) / 2) {
                        JOptionPane.showMessageDialog(board, "¡Felicidades! ¡Ganaste el juego!");
                    }
                } else {
                    // No son pares, voltear de nuevo
                    firstCard.hideValue();
                    card.hideValue();
                }
                
                // Resetear para el siguiente turno
                firstCard = null;
                lock = false;

        }
    }
}
