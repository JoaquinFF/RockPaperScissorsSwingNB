package Controller;


import Model.Model;
import View.View;
import View.PanelRules;
import View.PanelEleccion;
import View.PanelJuego;
import View.PanelFinal;
import View.Ventana;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {
    private Model m;
    private View v;

    private PanelRules pR;
    private PanelEleccion pE;
    private PanelJuego pJ;
    private PanelFinal pF;
    private Ventana vent;


    public Controller(View v, PanelRules pR, PanelEleccion pE, PanelJuego pJ, PanelFinal pF, Ventana vent){
        this.m = new Model(this);
        this.v = v;
        this.pR = pR;
        this.pE = pE;
        this.pJ = pJ;
        this.pF = pF;
        this.vent = vent;

        vent.paneles.add(pR, "pR");
        vent.paneles.add(pE, "pE");
        vent.paneles.add(pJ, "pJ");
        vent.paneles.add(pF, "pF");

        vent.setVisible(true);
        vent.setFocusable(true);
        m.leerReglas();
        vent.cardLayout.show(vent.paneles, "pR");//Cambiar esto

        pE.ronda1.addActionListener(e -> ronda1ButtonPressed());//Checkear por que los botones no llaman al metodo. Probar poner el addevent en el archivo origen de cada boton
        pE.ronda3.addActionListener(e -> ronda3ButtonPressed());
        pE.ronda5.addActionListener(e -> ronda5ButtonPressed());

        pJ.rockButton.addActionListener(e -> rockButtonPressed());
        pJ.paperButton.addActionListener(e -> paperButtonPressed());
        pJ.scissorsButton.addActionListener(e -> scissorsButtonPressed());

        pF.reiniciar.addActionListener(e -> reiniciarButtonPressed());
        pF.salir.addActionListener(e -> salirButtonPressed());

        pR.continuar.addActionListener(e -> continuarPressed());
        vent.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    salirButtonPressed();
                }
            }
        });
    }
    private void ronda1ButtonPressed(){
        m.rondas(1);
        vent.cardLayout.show(vent.paneles, "pJ");
    }

    private void ronda3ButtonPressed(){
        m.rondas(3);
        vent.cardLayout.show(vent.paneles, "pJ");
    }
    private void ronda5ButtonPressed(){
        m.rondas(5);
        vent.cardLayout.show(vent.paneles, "pJ");
    }

    private void rockButtonPressed(){
        m.combate(1);
    }

    private void paperButtonPressed(){
        m.combate(2);
    }

    private void scissorsButtonPressed(){
        m.combate(3);
    }

    private void reiniciarButtonPressed(){
        m.reiniciar();
        vent.cardLayout.show(vent.paneles, "pE");
    }

    private void salirButtonPressed(){
        vent.dispose();
    }

    private void continuarPressed(){
        vent.cardLayout.show(vent.paneles, "pE");
    }
    
    public void updateReglas(String rules){
        pR.reglas.setText(rules);
    }
    
    public void updateMessage(String msg){
        pJ.mensaje.setText(msg);
    }
    public void updateAtaques(String texto){
        pF.ataques.setText(texto);
    }
    public void updateAtaquesEnemigos(String texto){
        pF.ataquesEnemigo.setText(texto);
    }
    public void updateCondicion(String texto){
        pF.condicion.setText(texto);
    }
    public void cambiarFinal(){
        vent.cardLayout.show(vent.paneles, "pF");
    }
}
