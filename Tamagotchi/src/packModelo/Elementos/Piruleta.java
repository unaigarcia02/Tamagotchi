package packModelo.Elementos;

import packModelo.Partida;

public class Piruleta implements Elemento {

    @Override
    public void usar() {
        // TODO Auto-generated method stub
        Partida.getPartida().getTamagotchi().comerPiruleta();
    }

    @Override
    public String getTipo() {
        // TODO Auto-generated method stub
        return "Piruleta";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Piruleta other = (Piruleta) obj; // Cambio de Ficha a Piruleta
        // Comparar los tipos de las fichas
        return this.getTipo().equals(other.getTipo());
    }

}
