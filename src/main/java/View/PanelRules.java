package View;

import javax.swing.*;
import java.awt.*;

public class PanelRules extends JPanel {
    private Color color = new Color(205, 236, 144);
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Font miFuente = new Font("Arial", Font.BOLD, 30);
        g2.setFont(miFuente);

        g2.drawString("Piedra, papel o tijera", 350, 50);
        setBackground(color);

    }

    public PanelRules(){
        setLayout(null);
        Font fuente = new Font("Arial", Font.PLAIN, 25);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

        add(reglas);
        add(continuar);

        reglas.setBounds(50, 100, 850, 290);
        reglas.setFont(fuente);
        reglas.setBackground(color);
        reglas.setEditable(false);
        reglas.setLineWrap(true);


        continuar.setBounds(400, 400, 200, 100);
        continuar.setFont(fuente);
        continuar.setCursor(cursor);
        continuar.setBorderPainted(false);
        continuar.setContentAreaFilled(false);
    }

    public JTextArea reglas = new JTextArea("");
    public JButton continuar = new JButton("CONTINUAR");

    public void updateReglas(String rules){
        reglas.setText(rules);
    }
}
