package packModelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import packModelo.Elementos.Elemento;
import packVista.PantallaInicio;
import packVista.PantallaPrincipal;

public class Partida extends Observable {
    public static Partida partida = null;
    private int score;
    private Timer timer = null;
    private Jugador jugador;
    private Tamagotchi tamagotchi;
    private boolean evolucionadoMarutchi = false;
    private ArrayList<Elemento> elementos;
    private Timer timerMiniJuego = null;

    private Partida() {
        this.elementos = new ArrayList<>();

        iniciarTimer();
    }

    public static Partida getPartida() {
        if (partida == null) {
            partida = new Partida();
        }
        return partida;
    }

    public void terminarPartida(boolean pMuerto) {
        if (pMuerto) {
            PantallaInicio.getPantallaInicio().setVisible(true);
            this.timer.cancel();
            jugador.setScore(score);
            ListaJugadores.getListaJugadores().addJugador(this.jugador);
            PantallaInicio.getPantallaInicio().getTextFieldNombre().setText("");
            PantallaPrincipal.getPantalla().setVisible(false);
            PantallaPrincipal.getPantalla().reset();
            partida = null;
        }
    }

    public void limpiar() {
        this.tamagotchi.limpiar();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tamagotchi.puedeCagar(true);
            }
        }, 5000); // 5000 milisegundos = 5 segundos
    }

    public void curar() {
        this.tamagotchi.curar();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tamagotchi.puedeEnfermar(true);
            }
        }, 5000); // 5000 milisegundos = 5 segundos
    }

    public void setJugador(Jugador pJugador) {
        this.jugador = pJugador;
    }

    public void setTamagotchi(Tamagotchi pTamagotchi) {
        this.tamagotchi = pTamagotchi;
    }

    public void usarElementos() {
        this.elementos.stream().forEach(Elemento::usar);
        if (!getTamagotchi().getPasado()) {
            int sum = elementos.size()*3*elementos.size();
            setScore(sum);
        }
        this.elementos.clear();
        getTamagotchi().setPasado();
        mandarElementos();
    }

    public void addElemento(Elemento pElemento) {
        // Verificar si ya hay 6 elementos en la lista
        if (elementos.size() < 6) {
            // Verificar si el tipo de elemento ya está en la lista
            if (!tipoElementoRepetido(pElemento)) {
                this.elementos.add(pElemento);
            }
        }
        mandarElementos();
    }
    
    // Método para verificar si ya hay tres elementos del mismo tipo
    private boolean tipoElementoRepetido(Elemento pElemento) {
        int count = 0;
        for (Elemento elemento : elementos) {
            if (elemento.getTipo().equals(pElemento.getTipo())) {
                count++;
            }
        }
        return count >= 3;
    }

    public void mandarElementos(){
        setChanged();
        notifyObservers(elementos);
    }

    public Tamagotchi getTamagotchi() {
        return this.tamagotchi;
    }

    public int getScore() {
        return this.score;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void setScore(int pSum) {
        this.score += pSum;
    }

    // iniciar el timer para gestionar la actualizacion de la pantalla
    public void iniciarTimer() {
        timer = new Timer();
        timerMiniJuego = null;
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // Actualizar la puntuación y bajar la vida de la comida cada 4 segundos
                score += 1;
                String evo = tamagotchi.getEvolucion();
                if (evo.equalsIgnoreCase("Marutchi") && !evolucionadoMarutchi) {
                    score += 20;
                    evolucionadoMarutchi = true;
                }
                if (tamagotchi.estaCagado()) {
                    score -= 5;
                }
                if (tamagotchi.estaEnfermo()) {
                    score -= 5;
                }
                tamagotchi.bajarVidaComida();
                tamagotchi.cagarse();
                tamagotchi.ponerEnfermo();
                // Notificar cambios de puntuación y hambre a los observadores
                setChanged();
                notifyObservers(new Object[] { score, tamagotchi.getVida(), tamagotchi.getHambre(),
                        tamagotchi.getEvolucion() });
            }
        };

        TimerTask timerTaskEstado = new TimerTask() {
            @Override
            public void run() {
                // Actualizar el estado del Tamagotchi cada 2 segundos
                usarElementos();
                mandarElementos();
                tamagotchi.jugar();
                boolean cagado = tamagotchi.estaCagado();
                boolean enfermo = tamagotchi.estaEnfermo();
                boolean quiereJugarTama = tamagotchi.quiereJugarTama();
                boolean quiereJugarTres = tamagotchi.quiereJugarTres();
                // Notificar cambios de estado a los observadores
                setChanged();
                notifyObservers(new boolean[] { cagado, enfermo, quiereJugarTama, quiereJugarTres });

                tamagotchi.setQuiereJugar();
            }
        };

        TimerTask timerTernimarPartida = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                terminarPartida(tamagotchi.estaMuerto());
            }

        };

        TimerTask timerEvolucionar = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                tamagotchi.evolucionar();
            }

        };

        
        timer.scheduleAtFixedRate(timerTask, 4000, 4000); // Actualizar cada 4 segundos
        timer.scheduleAtFixedRate(timerTaskEstado, 1000, 2000); // Actualizar cada 2 segundos
        timer.scheduleAtFixedRate(timerTernimarPartida, 0, 1000); // Actualizar cada 1 segundo
        timer.scheduleAtFixedRate(timerEvolucionar, 8000, 8000);
    }

    // parar el timer para que el tamagotchi no se muera e iniciar el timer para el
    // minijuego
    public void pararTimer() {
        timerMiniJuego = new Timer();
        timer.cancel();
        timer.purge();
        timer = null;
        TimerTask tm = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                setChanged();
                notifyObservers(score);
            }
        };
        
        timerMiniJuego.scheduleAtFixedRate(tm, 0001, 0001);
    }
}
