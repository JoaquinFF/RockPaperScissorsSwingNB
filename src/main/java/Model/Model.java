

package Model;

import View.PanelEleccion;
import View.PanelJuego;
import View.PanelFinal;
import View.Ventana;

import java.util.Random;

public class Model {
    public PanelEleccion pE;
    public PanelJuego pJ;
    public PanelFinal pF;
    public Ventana vent;
    public int nRondas = 0;
    public String[] arrayAtaques;
    public String[] arrayAtaquesEnemigo;
    private int victorias;
    private int victoriasEnemigo;
    protected int numeroAtaques = 0;
    protected String condicion;

    public Model(Ventana vent, PanelEleccion pE, PanelJuego pJ, PanelFinal pF){
        this.vent = vent;
        this.pE = pE;
        this.pJ = pJ;
        this.pF = pF;
    }

    public void rondas(int nRondas){
        this.nRondas = nRondas;
        arrayAtaques = new String[nRondas];
        arrayAtaquesEnemigo = new String[nRondas];
        vent.cardLayout.show(vent.paneles, "pJ");
    }

    public void combate(int ataque){
        String texto = "";
        if(numeroAtaques < nRondas ){
            if(ataque == 1){
                arrayAtaques[numeroAtaques] = "PIEDRA";
            } else if (ataque == 2) {
                arrayAtaques[numeroAtaques] = "PAPEL";
            } else {
                arrayAtaques[numeroAtaques] = "TIJERA";
            }

            arrayAtaquesEnemigo[numeroAtaques] = ataquesAleatorios();

            for(int i = 0; i <= numeroAtaques; i++){
                texto += arrayAtaques[i] + ", ";
                pJ.updateMessage(texto);
            }

            numeroAtaques++;

            if(numeroAtaques == nRondas){
                for(int i = 0; i < nRondas; i++){
                    if(arrayAtaques[i] == "PIEDRA" && arrayAtaquesEnemigo[i] == "TIJERA"){
                        victorias++;
                    } else if (arrayAtaques[i] == "PAPEL" && arrayAtaquesEnemigo[i] == "PIEDRA") {
                        victorias++;
                    } else if (arrayAtaques[i] == "TIJERA" && arrayAtaquesEnemigo[i] == "PAPEL") {
                        victorias++;
                    } else if (arrayAtaques[i] == arrayAtaquesEnemigo[i]) {
                        
                    } else {
                        victoriasEnemigo++;
                    }
                }

                if(victorias > victoriasEnemigo){
                    condicion = "GANASTE";
                } else if (victoriasEnemigo > victorias) {
                    condicion = "PERDISTE";
                } else {
                    condicion = "EMPATE";
                }
                mostrarMFinal();
                vent.cardLayout.show(vent.paneles, "pF");
            }
        }
    }

    public String ataquesAleatorios(){
        Random rand = new Random();
        int numAtaque = rand.nextInt(3);
        if (numAtaque ==  0){
            return "PIEDRA";
        } else if (numAtaque == 1) {
            return "PAPEL";
        } else {
            return "TIJERA";
        }
    }

    public void mostrarMFinal(){
        String textoAliado = "";
        String textoEnemigo = "";
        for(int i = 0; i < nRondas; i++){
            textoAliado += arrayAtaques[i] + "\n";
            textoEnemigo += arrayAtaquesEnemigo[i] + "\n";
        }
        pF.updateAtaques(textoAliado);
        pF.updateAtaquesEnemigos(textoEnemigo);
        pF.updateCondicion(condicion);
    }

    public void reiniciar(){
        vent.cardLayout.show(vent.paneles, "pE");
        nRondas = 0;
        numeroAtaques = 0;
        victorias = 0;
        victoriasEnemigo = 0;
        condicion = "";
        pJ.updateMessage("");
    }

    public void salir(){
        vent.dispose();
    }
}

