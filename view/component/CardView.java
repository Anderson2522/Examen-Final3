package view.component;

import java.awt.*;
import javax.swing.*;

public class CardView extends JButton {
    private int value;
    private boolean revealed = false;
    private ImageIcon frontImage;
    private ImageIcon backImage;

    public CardView() {
        super();
        setPreferredSize(new Dimension(100, 100));
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(true);
        setFocusPainted(false);
        setMargin(new Insets(2, 2, 2, 2));
        setBackground(new Color(200, 200, 200));
        setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setImages(ImageIcon front, ImageIcon back) {
        this.frontImage = front;
        this.backImage = back;
        hideValue(); // Mostrar el reverso inicialmente
    }

    public void showValue() {
        if (frontImage != null) {
            setIcon(frontImage);
            setText("");
        } else {
            setIcon(null);
            setText(String.valueOf(value));
            setBackground(new Color(220, 240, 255));
        }
        revealed = true;
    }

    public void hideValue() {
        if (backImage != null) {
            setIcon(backImage);
            setText("");
        } else {
            setIcon(null);
            setText("?");
            setBackground(new Color(200, 200, 200));
        }
        revealed = false;
    }
}