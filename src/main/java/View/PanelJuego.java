package View;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Font miFuente = new Font("Arial", Font.BOLD, 30);
        g2.setFont(miFuente);

        g2.drawString("Piedra, papel o tijera", 350, 50);
        setBackground(new Color(205, 236, 144));

        Font miFuente2 = new Font("Arial", Font.PLAIN, 25);
        g2.setFont(miFuente2);

        g2.drawString("Elija su ataque (Debe seleccionar tantos ataques como rondas haya elegido).", 50, 100);
    }
    public PanelJuego(){
        setLayout(null);
        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        add(ataques);
        add(mensaje);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        Font fuente = new Font("Arial", Font.PLAIN, 18);

        rockButton.setBounds(50, 150, 200, 200);
        rockButton.setBackground(new Color(0,0,0,0));
        rockButton.setBorderPainted(false);
        rockButton.setContentAreaFilled(false);
        rockButton.setCursor(cursor);

        paperButton.setBounds(300, 150, 200, 200);
        paperButton.setBackground(new Color(0,0,0,0));
        paperButton.setBorderPainted(false);
        paperButton.setContentAreaFilled(false);
        paperButton.setCursor(cursor);

        scissorsButton.setBounds(550, 150, 200, 200);
        scissorsButton.setBackground(new Color(0,0,0,0));
        scissorsButton.setBorderPainted(false);
        scissorsButton.setContentAreaFilled(false);
        scissorsButton.setCursor(cursor);

        ataques.setBounds(75, 400, 150, 100);
        ataques.setFont(fuente);

        mensaje.setBounds(200, 400, 300, 100);
        mensaje.setFont(fuente);
        mensaje.setPreferredSize(new Dimension(300,100));
    }
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    Image rock = toolkit.getImage("src/main/java/View/piedra.png");
    public JButton rockButton = new JButton(new ImageIcon(rock));

    Image paper = toolkit.getImage("src/main/java/View/paper.png");
    public JButton paperButton = new JButton(new ImageIcon(paper));

    Image scissors = toolkit.getImage("src/main/java/View/tijera.png");
    public JButton scissorsButton = new JButton(new ImageIcon(scissors));

    public JLabel ataques = new JLabel("Sus ataques: ");

    public JLabel mensaje = new JLabel();
    public void updateMessage(String msg){
        mensaje.setText(msg);
    }
}
