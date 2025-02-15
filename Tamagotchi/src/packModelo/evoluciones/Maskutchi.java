package packModelo.evoluciones;

public class Maskutchi implements Evoluciones {
    private int corazones = 3;
    private int comida = 14;
    private String evolucion = "Maskutchi";

    public Maskutchi() {

    }

    public int decrementoCorazones() {
        return this.corazones;
    }

    public int decrementoComida() {
        return this.comida;
    }

    @Override
    public String evolucion() {
        // TODO Auto-generated method stub
        return this.evolucion;
    }
}
