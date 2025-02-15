package packModelo;

import java.util.Random;

import packModelo.evoluciones.Egg;
import packModelo.evoluciones.Evoluciones;
import packModelo.evoluciones.Kuchipatchi;
import packModelo.evoluciones.Marutchi;
import packModelo.evoluciones.Maskutchi;
import packModelo.evoluciones.Mimitchi;

public class Tamagotchi {
    private int vida;
    private int hambre;
    private Evoluciones evo = new Egg();
    private boolean estaCagado = false;
    private boolean estaEnfermo = false;
    private Random random = new Random();
    private boolean puedeCagar = true;
    private boolean puedeEnfermar = true;
    private boolean quiereJugarTama = false;
    private boolean quiereJugarTres = false;
    private boolean puedeJugar = true;
    private boolean pasado = false;

    public Tamagotchi() {
        this.vida = 40;
        this.hambre = 40;
    }

    public void ponerEnfermo() {
        if (!estaEnfermo && !estaCagado && puedeEnfermar) {
            int num = random.nextInt(100);
            if (num <= 29) {
                this.estaEnfermo = true;
                puedeEnfermar(false);
            }
        }
    }

    public void cagarse() {
        if (!estaCagado && !estaEnfermo && puedeCagar) {
            int num = random.nextInt(100);
            if (num <= 19) {
                this.estaCagado = true;
                puedeCagar(false);
            }
        }
    }

    public void limpiar() {
        this.estaCagado = false;
    }

    public void curar() {
        this.estaEnfermo = false;
    }

    public void bajarVidaComida() {
        int i = 0;
        int j = 0;
        if (estaCagado) {
            i = 5;
            j = 10;
        }
        if (estaEnfermo) {
            i = 7;
            j = 5;
        }
        this.vida = this.vida - this.evo.decrementoCorazones() - i;
        this.hambre = this.hambre - evo.decrementoComida() + j;
    }

    public int getVida() {
        return this.vida;
    }

    public int getHambre() {
        return this.hambre;
    }

    public void evolucionar() {
        if (!this.evo.evolucion().equalsIgnoreCase("Marutchi") || !this.evo.evolucion().equalsIgnoreCase("Maskutchi")) {
            if (this.evo.evolucion().equalsIgnoreCase("Egg")) {
                this.evo = new Kuchipatchi();
            } else if (this.getEvolucion().equalsIgnoreCase("Kuchipatchi")) {
                this.evo = new Mimitchi();
            } else if (this.getEvolucion().equalsIgnoreCase("Mimitchi")) {
                if (this.getVida() >= 30 && this.getHambre() >= 30) {
                    this.evo = new Marutchi();
                } else {
                    this.evo = new Maskutchi();
                }
            }
        }
    }

    public boolean estaMuerto() {
        if (this.vida <= 0 || this.hambre <= 0) {
            return true;
        }
        return false;
    }

    public String getEvolucion() {
        return this.evo.evolucion();
    }

    public boolean estaCagado() {
        return this.estaCagado;
    }

    public boolean estaEnfermo() {
        return this.estaEnfermo;
    }

    public void puedeCagar(boolean pBoolean) {
        this.puedeCagar = pBoolean;
    }

    public void puedeEnfermar(boolean pBoolean) {
        this.puedeEnfermar = pBoolean;
    }

    public void comerPiruleta() {
        this.vida += 10;
        if (getVida() > 40) {
            pasado = true;
            this.vida = 40;
        }
    }

    public void comerSopa() {
        this.hambre += 10;
        if (getHambre() > 40) {
            pasado = true;
            this.hambre = 40;
        }
    }

    public boolean getPasado() {
        return this.pasado;
    }

    public void setPasado() {
        this.pasado = false;
    }

    public void setVida(int pVida) {
        this.vida = pVida;
    }

    public void setHambre(int pHambre) {
        this.hambre = pHambre;
    }

    public void jugar() {
        if (!quiereJugarTama && !quiereJugarTres && puedeJugar) {
            int num = random.nextInt(100);
            if (num < 12) {
                if (num < 6) {
                    this.quiereJugarTama = true;
                    this.puedeJugar = false;
                } else {
                    this.quiereJugarTres = true;
                    this.puedeJugar = false;
                }
            }
        }
    }

    public boolean quiereJugarTama() {
        return this.quiereJugarTama;
    }

    public boolean quiereJugarTres() {
        return this.quiereJugarTres;
    }

    public void puedeJugar(boolean pBoolean) {
        this.puedeJugar = pBoolean;
    }

    public void setQuiereJugar() {
        this.quiereJugarTama = false;
        this.quiereJugarTres = false;
    }
}
