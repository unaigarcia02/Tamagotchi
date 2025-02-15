package packModelo.evoluciones;

public class Mimitchi implements Evoluciones{
    private int corazones = 7;
    private int comida = 7;
    private String evolucion = "Mimitchi";
    
    public Mimitchi(){

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
