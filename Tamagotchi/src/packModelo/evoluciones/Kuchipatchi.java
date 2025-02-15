package packModelo.evoluciones;

public class Kuchipatchi implements Evoluciones{
    private int corazones = 2;
    private int comida = 5;
    private String evolucion = "Kuchipatchi";
    
    public Kuchipatchi(){

    }

    public int decrementoCorazones(){
        return this.corazones;
    }

    public int decrementoComida(){
        return this.comida;
    }

    @Override
    public String evolucion() {
        // TODO Auto-generated method stub
        return this.evolucion;
    }
}
