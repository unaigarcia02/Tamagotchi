package packModelo.JugadoresTresEnRaya;

import java.util.ArrayList;
import java.util.Random;

import packModelo.TresEnRaya;
import packModelo.Fichas.Ficha;
import packModelo.Fichas.FichaTamagotchi;

public class Bot extends Player {
    private ArrayList<Ficha> fichas = new ArrayList<>();
    private Random random = new Random();
    private int posIni;
    private int posFin;

    public Bot() {
        fichas.add(new FichaTamagotchi());
        fichas.add(new FichaTamagotchi());
        fichas.add(new FichaTamagotchi());

        posIni = -1;
        posFin = -1;
    }

    @Override
    public void ponerFicha(int pPos) {
        // Implementamos la lógica para que el bot coloque una ficha solo si el panel
        // está vacío
        int pos = random.nextInt(9);
        if (!fichas.isEmpty()) {
            boolean puesto = false;
            while (!puesto) {
                if (TresEnRaya.getTresEnRaya().getListaPaneles().get(pos).getFicha() == null) {
                    TresEnRaya.getTresEnRaya().getListaPaneles().get(pos).ponerFicha(fichas.get(0));
                    fichas.remove(0);
                    puesto = true;
                } else {
                    pos = random.nextInt(9);
                }
            }
        } else {
            cambiarFicha(pPos);
        }
    }

    private void ponerFicha(Ficha pFicha, int pPos) {
        TresEnRaya.getTresEnRaya().getListaPaneles().get(pPos).ponerFicha(pFicha);
    }

    @Override
    protected void quitarFicha(int pPos) {
        if (TresEnRaya.getTresEnRaya().getListaPaneles().get(pPos).getFicha() instanceof FichaTamagotchi) {
            TresEnRaya.getTresEnRaya().getListaPaneles().get(pPos).ponerFicha(null);
        }
    }

    @Override
    protected void cambiarFicha(int pPos) {
        // TODO Auto-generated method stub
        if (posIni == -1) {
            boolean valido = false;
            posIni = random.nextInt(9);
            while (!valido) {
                if (TresEnRaya.getTresEnRaya().getListaPaneles().get(posIni).getFicha() instanceof FichaTamagotchi) {
                    valido = true;
                } else {
                    posIni = random.nextInt(9);
                }
            }
        } else {
            posFin = random.nextInt(9);
            boolean cambiado = false;
            while (!cambiado) {
                if (posFin == posIni || TresEnRaya.getTresEnRaya().getListaPaneles().get(posFin).getFicha() != null) {
                    posFin = random.nextInt(9);
                } else {
                    Ficha ficha = TresEnRaya.getTresEnRaya().getListaPaneles().get(posIni).getFicha();
                    quitarFicha(posIni);
                    ponerFicha(ficha, posFin);
                    reset();
                    cambiado = true;
                }
            }
        }
    }

    private void reset(){
        posIni = -1;
        posFin = -1;
    }

}
