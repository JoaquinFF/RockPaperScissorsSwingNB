package View;

import javax.swing.*;
import java.awt.*;

public class PanelFinal extends JPanel{
    private Color color = new Color(205, 236, 144);
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Font miFuente = new Font("Arial", Font.BOLD, 30);
        g2.setFont(miFuente);

        g2.drawString("Piedra, papel o tijera", 350, 50);
        setBackground(color);

        Font miFuente2 = new Font("Arial", Font.PLAIN, 25);
        g2.setFont(miFuente2);

        g2.drawString("Sus ataques", 200, 150);
        g2.drawString("Ataques del enemigo", 650, 150);
    }

    public PanelFinal(){
        setLayout(null);
        add(reiniciar);
        add(salir);
        add(ataques);
        add(ataquesEnemigo);
        add(condicion);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        Font fuente = new Font("Arial", Font.PLAIN, 20);

        reiniciar.setBounds(150, 350, 250, 200);
        reiniciar.setBackground(new Color(0,0,0,0));
        reiniciar.setBorderPainted(false);
        reiniciar.setContentAreaFilled(false);
        reiniciar.setCursor(cursor);
        reiniciar.setFont(fuente);

        salir.setBounds(630, 350, 200, 200);
        salir.setBackground(new Color(0,0,0,0));
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setCursor(cursor);
        salir.setFont(fuente);

        ataques.setBounds(225, 200, 100, 200);
        ataques.setFont(fuente);
        ataques.setBackground(color);

        ataquesEnemigo.setBounds(700, 200, 100, 200);
        ataquesEnemigo.setFont(fuente);
        ataquesEnemigo.setBackground(color);

        condicion.setBounds(480, 300, 200, 100);
        condicion.setFont(fuente);
    }
    public JButton reiniciar = new JButton("REINICIAR JUEGO");
    public JButton salir = new JButton("SALIR");

    public JTextArea ataques = new JTextArea("HOLA");

    public JTextArea ataquesEnemigo = new JTextArea("HOLA");

    public JLabel condicion = new JLabel("HOLA");

    public void updateAtaques(String texto){
        ataques.setText(texto);
    }
    public void updateAtaquesEnemigos(String texto){
        ataquesEnemigo.setText(texto);
    }
    public void updateCondicion(String texto){
        condicion.setText(texto);
    }
}
