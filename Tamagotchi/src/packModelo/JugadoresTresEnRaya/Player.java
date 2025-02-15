package packModelo.JugadoresTresEnRaya;

import packModelo.Fichas.Ficha;

public abstract class Player {
    public abstract void ponerFicha(int pPos);

    protected abstract void quitarFicha(int pPos);

    protected abstract void cambiarFicha(int pPos);
}
