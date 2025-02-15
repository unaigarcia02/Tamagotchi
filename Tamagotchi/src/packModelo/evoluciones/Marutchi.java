package packModelo.evoluciones;

public class Marutchi implements Evoluciones{
    private int corazones = 1;
    private int comida = 1;
    private String evolucion = "Marutchi";
    
    public Marutchi(){

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
