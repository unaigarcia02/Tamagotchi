package packModelo;

import java.util.Observable;

import packModelo.Fichas.Ficha;

public class BloqueTresEnRaya extends Observable{
    private int pos;
    private Ficha ficha;

    public BloqueTresEnRaya(int pPos){
        this.pos = pPos;
    }

    public void setFicha(Ficha pFicha){
        this.ficha = pFicha;
    }

    public int getPos(){
        return this.pos;
    }

    public Ficha getFicha(){
        return this.ficha;
    }

    public void ponerFicha(Ficha pFicha){
        setFicha(pFicha);
        setChanged();
        notifyObservers(getFicha());
    }
}
