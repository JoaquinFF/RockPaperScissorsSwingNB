package Model;

import View.PanelRules;
import View.PanelEleccion;
import View.PanelJuego;
import View.PanelFinal;
import View.Ventana;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Model {
    private PanelRules pR;
    private PanelEleccion pE;
    private PanelJuego pJ;
    private PanelFinal pF;
    private Ventana vent;
    private int nRondas = 0;
    private String[] arrayAtaques;
    private String[] arrayAtaquesEnemigo;
    private int victorias;
    private int victoriasEnemigo;
    private int numeroAtaques = 0;
    private String condicion;

    public Model(Ventana vent, PanelRules pR, PanelEleccion pE, PanelJuego pJ, PanelFinal pF){
        this.vent = vent;
        this.pR = pR;
        this.pE = pE;
        this.pJ = pJ;
        this.pF = pF;
    }

    public void leerReglas(){
        try {
            FileReader reglas = new FileReader("src/main/java/Files/Rules.txt");
            int c = 0;
            String texto = "";

            while(c != -1){
                c = reglas.read();
                char letra = (char) c;
                texto += letra;
            }
            pR.updateReglas(texto);
            reglas.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public void continuar(){
        vent.cardLayout.show(vent.paneles, "pE");
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
        String aliado = "";
        String enemigo = "\nAtaques de la IA \n";
        String con = "\nResultado: ";
        for(int i = 0; i < nRondas; i++){
            textoAliado += arrayAtaques[i] + "\n";
            textoEnemigo += arrayAtaquesEnemigo[i] + "\n";
        }
        aliado = "\nAtaques del jugador: \n" + textoAliado + enemigo  + textoEnemigo + con + condicion;
        pF.updateAtaques(textoAliado);
        pF.updateAtaquesEnemigos(textoEnemigo);
        pF.updateCondicion(condicion);

        try {
            FileWriter historialJugadas = new FileWriter("src/main/java/Files/Historial.txt", true);
            for (int i = 0; i < aliado.length(); i++) {
                historialJugadas.write(aliado.charAt(i));
            }
            historialJugadas.close();
        } catch (IOException e){
            System.out.println(e);
        }
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
