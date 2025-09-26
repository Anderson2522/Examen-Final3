package component;

import java.awt.*;
import javax.swing.*;

public class ComponentCarta extends JButton {
    private int valor;
    private boolean revelada;

    public ComponentCarta() {
        valor = -1;
        revelada = false;

        setFont(new Font("Arial", Font.BOLD, 24));
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setText("");
    }

    public void setValue(int valor) { this.valor = valor; }
    public int getValue() { return valor; }

    public boolean isRevealed() { return revelada; }
    public void setRevealed(boolean estado) { revelada = estado; }

    public void revealValue() {
        setText(String.valueOf(valor));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        revelada = true;
    }

    public void hideValue() {
        setText("");
        setBackground(Color.LIGHT_GRAY);
        revelada = false;
    }

    public void marcarCorrecta() {
        setBackground(Color.GREEN);
        setForeground(Color.WHITE);
        setEnabled(false);
        revelada = true;
    }
}
