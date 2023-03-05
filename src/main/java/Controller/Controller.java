
package Controller;

import Model.Model;
import View.View;
import View.PanelEleccion;
import View.PanelJuego;
import View.PanelFinal;
import View.Ventana;

public class Controller {
    public Model m;
    public View v;
    public PanelEleccion pE;
    public PanelJuego pJ;
    public PanelFinal pF;
    public Ventana vent;


    public Controller(Model m, View v, PanelEleccion pE, PanelJuego pJ, PanelFinal pF, Ventana vent){
        this.m = m;
        this.v = v;
        this.pE = pE;
        this.pJ = pJ;
        this.pF = pF;
        this.vent = vent;

        vent.paneles.add(pE, "pE");
        vent.paneles.add(pJ, "pJ");
        vent.paneles.add(pF, "pF");

        vent.setVisible(true);
        vent.cardLayout.show(vent.paneles, "pE");

        pE.ronda1.addActionListener(e -> ronda1ButtonPressed());
        pE.ronda3.addActionListener(e -> ronda3ButtonPressed());
        pE.ronda5.addActionListener(e -> ronda5ButtonPressed());

        pJ.rockButton.addActionListener(e -> rockButtonPressed());
        pJ.paperButton.addActionListener(e -> paperButtonPressed());
        pJ.scissorsButton.addActionListener(e -> scissorsButtonPressed());

        pF.reiniciar.addActionListener(e -> reiniciarButtonPressed());
        pF.salir.addActionListener(e -> salirButtonPressed());
    }
    private void ronda1ButtonPressed(){
        m.rondas(1);
    }

    private void ronda3ButtonPressed(){
        m.rondas(3);
    }
    private void ronda5ButtonPressed(){
        m.rondas(5);
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
    }

    private void salirButtonPressed(){
        m.salir();
    }
}

