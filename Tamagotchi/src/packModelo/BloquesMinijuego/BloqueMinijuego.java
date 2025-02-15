package packModelo.BloquesMinijuego;

import java.util.Observable;

public abstract class BloqueMinijuego extends Observable {
    private int dureza, pos;
    private boolean tieneTamagotchi = false;
    private boolean tienePastel = false;

    public BloqueMinijuego(int pPos, int pDureza) {
        this.dureza = pDureza;
        this.pos = pPos;
    }

    public int getDureza() {
        return this.dureza;
    }

    public int getPos() {
        return this.pos;
    }

    public boolean getTamagotchi() {
        return this.tieneTamagotchi;
    }

    public void setTamagotchi(Boolean pBoolean) {
        this.tieneTamagotchi = pBoolean;
    }

    public boolean getPastel() {
        return this.tienePastel;
    }

    public void setPastel() {
        this.tienePastel = true;
    }

    public abstract void sumarPuntos();

    public void quitarDureza() {
        if (this.dureza > 0) {
            this.dureza--;
            if (this.dureza == 0) {
                sumarPuntos();
            }
        }
        this.setDatos();
    }

    public void setDatos() {
        setChanged();
        notifyObservers(new Object[] { this.getDureza(), this.getTamagotchi(), this.getPastel() });
    }
}
