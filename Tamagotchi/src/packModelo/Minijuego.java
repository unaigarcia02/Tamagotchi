package packModelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import packModelo.BloquesMinijuego.BloqueMinijuego;
import packVista.PantallaPrincipal;
import packVista.PantallaTamaDigOut;

public class Minijuego {
    private static Minijuego minijuego = null;
    private Timer timerTerminar = null;
    private int cont = 20;
    private ArrayList<BloqueMinijuego> listaBloques = new ArrayList<>();

    public static Minijuego getMinijuego(){
        if (minijuego == null) {
            minijuego = new Minijuego();
        }
        return minijuego;
    }
    public void iniciarMinijuego(){
        Partida.getPartida().pararTimer();
        timerTerminar = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                finalMinijuego(terminarMinijuego());
                cont--;
                if (cont == 0) {
                    finalMinijuego(true);
                    Partida.getPartida().setScore(-20);
                } 
            }
            
        };

        timerTerminar.scheduleAtFixedRate(timerTask, 0000, 1000);
    }

    private boolean terminarMinijuego(){
        boolean terminar = false;
        for(BloqueMinijuego b : getListaBloques()){
            if (!terminar) {
                if (b.getTamagotchi() && b.getPastel()) {
                    terminar =  true;
                }
            }
        }
        return terminar;
    }

    private void finalMinijuego(boolean pBoolean){
        if (pBoolean) {
            reset();
            cont = 20;
            timerTerminar.cancel();
            timerTerminar.purge();
            timerTerminar = null;
            PantallaTamaDigOut.geTamaDigOut().setVisible(false);
            PantallaPrincipal.getPantalla().setVisible(true);
            Partida.getPartida().setScore(20);
            Partida.getPartida().iniciarTimer();
            Partida.getPartida().getTamagotchi().puedeJugar(true);
            PantallaTamaDigOut.geTamaDigOut().reset();
        }
    }

    public void iniciarTablero() {
		Random random = new Random();
		int posTamagotchi = random.nextInt(96);
		int posPastel = random.nextInt(96);
		do {
			posPastel = random.nextInt(96);
		} while (posPastel == posTamagotchi);

		for (int i = 0; i < 96; i++) {
			BloqueMinijuego bloque = Factory.geFactory().crearBloqueMinijuego(i);
			if (i == posTamagotchi) {
				bloque.setTamagotchi(true);
			} else if (i == posPastel) {
				bloque.setPastel();
			}
			this.getListaBloques().add(bloque);
		}
	}

	public ArrayList<BloqueMinijuego> getListaBloques() {
		return this.listaBloques;
	}

	private int getPosBloqueTamagotchi() {
		int pos = -1;
		for (BloqueMinijuego b : getListaBloques()) {
			if (b.getTamagotchi()) {
				pos = b.getPos();
			}
		}
		return pos;
	}

    public void moverTamagotchi(String pTecla){
        if (pTecla.equalsIgnoreCase("a")) {
            int num = getPosBloqueTamagotchi();
            if (num % 12 != 0 && getListaBloques().get(num - 1).getDureza() == 0) {
                getListaBloques().get(num - 1).setTamagotchi(true);
                getListaBloques().get(num).setTamagotchi(false);

                getListaBloques().get(num - 1).setDatos();
                getListaBloques().get(num).setDatos();
            }
        }

        else if (pTecla.equalsIgnoreCase("w")) {
            int num = getPosBloqueTamagotchi();
            if (num > 12 && getListaBloques().get(num - 12).getDureza() == 0) {
                getListaBloques().get(num - 12).setTamagotchi(true);
                getListaBloques().get(num).setTamagotchi(false);

                getListaBloques().get(num - 12).setDatos();
                getListaBloques().get(num).setDatos();
            }
        }

        else if (pTecla.equalsIgnoreCase("d")) {
            int num = getPosBloqueTamagotchi();
            if (num % 12 != 11 && getListaBloques().get(num + 1).getDureza() == 0) {
                getListaBloques().get(num + 1).setTamagotchi(true);
                getListaBloques().get(num).setTamagotchi(false);

                getListaBloques().get(num + 1).setDatos();
                getListaBloques().get(num).setDatos();
            }
        }

        else if (pTecla.equalsIgnoreCase("s")) {
            int num = getPosBloqueTamagotchi();
            if (num + 12 < 96 && getListaBloques().get(num + 12).getDureza() == 0) {
                getListaBloques().get(num + 12).setTamagotchi(true);
                getListaBloques().get(num).setTamagotchi(false);

                getListaBloques().get(num + 12).setDatos();
                getListaBloques().get(num).setDatos();
            }
        }
    }

    private void reset(){
        minijuego = null;
    }
}
