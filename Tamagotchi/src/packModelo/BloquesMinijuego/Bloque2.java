package packModelo.BloquesMinijuego;

import packModelo.Partida;

public class Bloque2 extends BloqueMinijuego{
    private int durezaInicial;
    
    public Bloque2(int pPos, int pDureza) {
        super(pPos, pDureza);
        this.durezaInicial = pDureza;
        //TODO Auto-generated constructor stub
    }

    public void sumarPuntos(){
        Partida.getPartida().setScore(this.durezaInicial);
    }

    
}
