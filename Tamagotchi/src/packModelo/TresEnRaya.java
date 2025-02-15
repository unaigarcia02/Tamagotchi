package packModelo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import packModelo.Fichas.Ficha;
import packModelo.JugadoresTresEnRaya.Bot;
import packModelo.JugadoresTresEnRaya.Humano;
import packModelo.JugadoresTresEnRaya.Player;
import packVista.PantallaPrincipal;
import packVista.PantallaTresEnRaya;

public class TresEnRaya {
    private static TresEnRaya tresEnRaya = null;
    private ArrayList<BloqueTresEnRaya> listaPaneles = new ArrayList<>();
    private int turno;
    private int fichasJugador, fichasTamagotchi, panelInicial, panelFinal;
    private String ganador;
    private Timer timer = null;
    private ArrayList<Player> jugadores = new ArrayList<>();
    private Player jugadorConTurno;

    private TresEnRaya() {
        this.turno = 1;
        this.panelFinal = -1;
        this.panelInicial = -1;
        this.fichasJugador = 0;
        this.fichasTamagotchi = 0;
        jugadores.add(new Humano());
        jugadores.add(new Bot());
        jugadorConTurno = jugadores.get(0);
    }

    public void cambiarTurno() {
        int indiceActual = jugadores.indexOf(jugadorConTurno);
        int siguienteIndice = (indiceActual + 1) % jugadores.size(); // Obtiene el índice del siguiente jugador,
                                                                     // considerando el caso circular
        jugadorConTurno = jugadores.get(siguienteIndice); // Cambia al siguiente jugador
    }

    public static TresEnRaya getTresEnRaya() {
        if (tresEnRaya == null) {
            tresEnRaya = new TresEnRaya();
        }
        return tresEnRaya;
    }

    public void iniciarTablero() {
        for (int i = 0; i < 9; i++) {
            listaPaneles.add(new BloqueTresEnRaya(i));
        }
    }

    public ArrayList<BloqueTresEnRaya> getListaPaneles() {
        return this.listaPaneles;
    }

    public void jugar() {
        Partida.getPartida().pararTimer();
    }

    public int getTurno() {
        return this.turno;
    }

    public int getFichasJugador() {
        return this.fichasJugador;
    }

    public int getFichasTamagotchi() {
        return this.fichasTamagotchi;
    }

    public void ponerFicha(int pPos) {

        if (jugadorConTurno instanceof Humano) {
            jugadorConTurno.ponerFicha(pPos);
            terminarMiniJuego(hayGanador());

            if (!hayGanador()) {
                cambiarTurno();

                if (jugadorConTurno instanceof Bot) {
                    jugadorConTurno.ponerFicha(pPos);
                    terminarMiniJuego(hayGanador());

                    // Verificar si hay un ganador después de que el bot haya colocado su ficha
                    if (!hayGanador()) {
                        // Cambiar de turno de nuevo
                        cambiarTurno();
                    }
                }
            }
        }
    }

    public int getPanelInicial() {
        return this.panelInicial;
    }

    public int getPanelFinal() {
        return this.panelFinal;
    }

    public void setPanelInicial(int pPos) {
        this.panelInicial = pPos;
    }

    public void setPanelFinal(int pPos) {
        this.panelFinal = pPos;
    }

    public void reiniciar() {
        this.panelInicial = -1;
        this.panelFinal = -1;
    }

    public boolean hayGanador() {
        int[][] lineasGanadoras = {
                { 0, 1, 2 }, // Líneas horizontales
                { 3, 4, 5 },
                { 6, 7, 8 },
                { 0, 3, 6 }, // Líneas verticales
                { 1, 4, 7 },
                { 2, 5, 8 },
                { 0, 4, 8 }, // Diagonales
                { 2, 4, 6 }
        };

        for (int[] linea : lineasGanadoras) {
            BloqueTresEnRaya primerBloque = getListaPaneles().get(linea[0]);
            Ficha primeraFicha = primerBloque.getFicha();
            if (primeraFicha != null) {
                boolean todasIguales = true;
                for (int i = 1; i < linea.length; i++) {
                    BloqueTresEnRaya bloque = getListaPaneles().get(linea[i]);
                    Ficha ficha = bloque.getFicha();
                    if (ficha == null || !ficha.equals(primeraFicha)) {
                        todasIguales = false;
                        break;
                    }
                }
                if (todasIguales) {
                    this.ganador = primeraFicha.getTipo();
                    return true;
                }
            }
        }

        return false;
    }

    public void terminarMiniJuego(boolean pBoolean) {
        if (pBoolean) {
            getListaPaneles().stream().forEach(p -> p.deleteObservers());
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (ganador.equals("Jugador")) {
                        Partida.getPartida().setScore(20);
                    } else {
                        Partida.getPartida().setScore(-20);
                    }
                    PantallaTresEnRaya.gPantallaTresEnRaya().setVisible(false);
                    PantallaPrincipal.getPantalla().setVisible(true);
                    Partida.getPartida().iniciarTimer();
                    Partida.getPartida().getTamagotchi().puedeJugar(true);
                    PantallaTresEnRaya.gPantallaTresEnRaya().reset();
                    reset();
                }
            };

            // Espera de 3 segundos antes de ejecutar el código dentro de run()
            timer.schedule(timerTask, 3000);
        }

    }

    public void reset() {
        tresEnRaya = null;
    }
}
