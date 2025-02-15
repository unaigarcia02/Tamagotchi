package packModelo.BloquesMinijuego;

import packModelo.Partida;

public class Bloque3 extends BloqueMinijuego{
    private int durezaInicial;

    public Bloque3(int pPos, int pDureza) {
        super(pPos, pDureza);
        this.durezaInicial = pDureza;
    }

    @Override
    public void sumarPuntos(){
        Partida.getPartida().setScore(this.durezaInicial);
    }
}
