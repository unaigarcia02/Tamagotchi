package packModelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Observable;

public class ListaJugadores extends Observable{
    private static ListaJugadores listaJugadores = null;
    private ArrayList<Jugador> lista = new ArrayList<>();

    private ListaJugadores(){
        Jugador j1 = new Jugador("AMD", 46);
        this.lista.add(j1);

        Jugador j2 = new Jugador("DEZ", 70);
        this.lista.add(j2);

        Jugador j3 = new Jugador("PLS", 50);
        this.lista.add(j3);

        Jugador j4 = new Jugador("UGP", 20);
        this.lista.add(j4);

        Jugador j5 = new Jugador("BBB", 0);
        this.lista.add(j5);

        lista.sort(Comparator.comparing(Jugador::getScore).reversed());
    }

    public static ListaJugadores getListaJugadores(){
        if(listaJugadores == null){
            listaJugadores = new ListaJugadores();
        }
        return listaJugadores;
    }

    public void addJugador(Jugador pJugador){
        this.lista.add(pJugador);
        lista.sort(Comparator.comparing(Jugador::getScore).reversed());
        this.setChanged();
        this.notifyObservers(new Jugador[] {this.lista.get(0), this.lista.get(1), this.lista.get(2), this.lista.get(3), this.lista.get(4)});
    }

    public ArrayList<Jugador> getLista(){
        return this.lista;
    }
}
