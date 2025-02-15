package packModelo.JugadoresTresEnRaya;

import java.util.ArrayList;

import packModelo.TresEnRaya;
import packModelo.Fichas.Ficha;
import packModelo.Fichas.FichaJugador;

public class Humano extends Player {
    private ArrayList<Ficha> fichas = new ArrayList<>();

    public Humano() {
        fichas.add(new FichaJugador());
        fichas.add(new FichaJugador());
        fichas.add(new FichaJugador());
    }

    @Override
    public void ponerFicha(int pPos) {
        if (!fichas.isEmpty()) {
            // Verificamos si el panel está vacío antes de colocar la ficha
            if (TresEnRaya.getTresEnRaya().getListaPaneles().get(pPos).getFicha() == null) {
                TresEnRaya.getTresEnRaya().getListaPaneles().get(pPos).ponerFicha(fichas.get(0));
                fichas.remove(0); // Removemos la ficha utilizada
            }
        } else {
            // Si no hay más fichas para colocar, cambiar la ficha
            cambiarFicha(pPos);
        }
    }

    private void ponerFicha(Ficha pFicha, int pPos) {
        TresEnRaya.getTresEnRaya().getListaPaneles().get(pPos).ponerFicha(pFicha);
    }

    @Override
    protected void quitarFicha(int pPos) {
        if (TresEnRaya.getTresEnRaya().getListaPaneles().get(pPos).getFicha() instanceof FichaJugador) {
            TresEnRaya.getTresEnRaya().getListaPaneles().get(pPos).ponerFicha(null);
        }
    }

    @Override
    protected void cambiarFicha(int pPos) {
        // TODO Auto-generated method stub
        if (TresEnRaya.getTresEnRaya().getPanelInicial() == -1) {
            TresEnRaya.getTresEnRaya().setPanelInicial(pPos);
        } else {
            Ficha ficha = TresEnRaya.getTresEnRaya().getListaPaneles().get(TresEnRaya.getTresEnRaya().getPanelInicial())
                    .getFicha();
            TresEnRaya.getTresEnRaya().setPanelFinal(pPos);
            quitarFicha(TresEnRaya.getTresEnRaya().getPanelInicial());
            ponerFicha(ficha, TresEnRaya.getTresEnRaya().getPanelFinal());
            TresEnRaya.getTresEnRaya().reiniciar();
        }
    }

}
