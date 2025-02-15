package packModelo;

import java.util.Observable;

public class Juego extends Observable{
    private static Juego juego = null;
    

    private Juego(){

    }

    public static Juego getJuego(){
        if(juego == null){
            juego = new Juego();
        }
        return juego;
    }

    public void iniciarPartida(String pNombre){
        Jugador jugador = new Jugador(pNombre, 0);
        Tamagotchi tamagotchi = new Tamagotchi();
        Partida.getPartida().setJugador(jugador);
        Partida.getPartida().setTamagotchi(tamagotchi);
        setChanged();
        notifyObservers();
    }
}
