package packModelo;

import java.util.Random;

import packModelo.BloquesMinijuego.Bloque1;
import packModelo.BloquesMinijuego.Bloque2;
import packModelo.BloquesMinijuego.Bloque3;
import packModelo.BloquesMinijuego.BloqueMinijuego;

public class Factory {
    private static Factory factoria = null;

    private Factory() {

    }

    public static Factory geFactory() {
        if (factoria == null) {
            factoria = new Factory();
        }
        return factoria;
    }

    public BloqueMinijuego crearBloqueMinijuego(int pPos) {
        Random random = new Random();
        int pDureza = random.nextInt(3) + 1;
        BloqueMinijuego bloque = null;
        switch (pDureza) {
            case 1:
                bloque = new Bloque1(pPos, pDureza);
                break;
            case 2:
                bloque = new Bloque2(pPos, pDureza);
                break;
            case 3: 
                bloque = new Bloque3(pPos, pDureza);
                break;
        }
        return bloque;
    }
}
