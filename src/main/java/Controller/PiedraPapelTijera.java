package Controller;

import Model.Model;
import View.View;
import View.PanelRules;
import View.PanelEleccion;
import View.PanelJuego;
import View.PanelFinal;
import View.Ventana;

public class PiedraPapelTijera {
    public static void main(String[] args) {
        View v = new View();
        PanelRules pR = new PanelRules();
        PanelEleccion pE = new PanelEleccion();
        PanelJuego pJ = new PanelJuego();
        PanelFinal pF = new PanelFinal();
        Ventana vent = new Ventana();
        Controller c = new Controller(v, pR, pE, pJ, pF, vent);
        Model m = new Model(c);
    }
}
