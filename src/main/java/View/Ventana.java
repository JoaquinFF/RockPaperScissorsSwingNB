package View;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public JPanel paneles;
    public CardLayout cardLayout;

    public Ventana(){
        cardLayout = new CardLayout();
        paneles = new JPanel(cardLayout);

        PanelRules pR = new PanelRules();
        PanelEleccion pE = new PanelEleccion();
        PanelJuego pJ = new PanelJuego();
        PanelFinal pF = new PanelFinal();

        paneles.add(pR, "pR");
        paneles.add(pE, "pE");
        paneles.add(pJ, "pJ");
        paneles.add(pF, "pF");

        add(paneles);

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension dimensionPantalla = miPantalla.getScreenSize();

        int width = dimensionPantalla.width;
        int height = dimensionPantalla.height;

        setSize(width/2, height/2);
        setLocation(width/4, height/4);

        setTitle("Piedra, papel o tijera");

        Image icon = miPantalla.getImage("src/main/java/View/icon.jpg");
        setIconImage(icon);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}
