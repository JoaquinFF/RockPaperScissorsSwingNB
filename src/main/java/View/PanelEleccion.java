package View;

import javax.swing.*;
import java.awt.*;

public class PanelEleccion extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Font miFuente = new Font("Arial", Font.BOLD, 30);
        g2.setFont(miFuente);

        g2.drawString("Piedra, papel o tijera", 350, 50);
        setBackground(new Color(205, 236, 144));

        Font miFuente2 = new Font("Arial", Font.PLAIN, 25);
        g2.setFont(miFuente2);

        g2.drawString("Elija la cantidad de rondas", 50, 100);
    }

    public PanelEleccion(){
        setLayout(null);
        Font fuente = new Font("Arial", Font.PLAIN, 25);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        add(ronda1);
        add(ronda3);
        add(ronda5);

        ronda1.setBounds(50, 200, 200, 100);
        ronda1.setFont(fuente);
        ronda1.setCursor(cursor);
        ronda1.setBorderPainted(false);
        ronda1.setContentAreaFilled(false);

        ronda3.setBounds(350, 200, 200, 100);
        ronda3.setFont(fuente);
        ronda3.setCursor(cursor);
        ronda3.setBorderPainted(false);
        ronda3.setContentAreaFilled(false);

        ronda5.setBounds(650, 200, 200, 100);
        ronda5.setFont(fuente);
        ronda5.setCursor(cursor);
        ronda5.setBorderPainted(false);
        ronda5.setContentAreaFilled(false);

    }

    public JButton ronda1 = new JButton("1 RONDA");
    public JButton ronda3 = new JButton("3 RONDAS");
    public JButton ronda5 = new JButton("5 RONDAS");
}
