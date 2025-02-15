package packModelo;

public class Jugador {
    private String nombre;
    private int score;

    public Jugador(String pNombre, int pScore){
        this.nombre = pNombre;
        this.score = pScore;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int pScore){
        this.score = pScore;
    }
}
