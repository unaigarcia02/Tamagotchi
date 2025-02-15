package packModelo.Elementos;

import packModelo.Partida;
import packModelo.Fichas.Ficha;

public class Sopa implements Elemento {

    @Override
    public void usar() {
        // TODO Auto-generated method stub
        Partida.getPartida().getTamagotchi().comerSopa();
    }

    @Override
    public String getTipo() {
        // TODO Auto-generated method stub
        return "Sopa";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Sopa other = (Sopa) obj; // Cambio de Ficha a Piruleta
        // Comparar los tipos de las fichas
        return this.getTipo().equals(other.getTipo());
    }

}
