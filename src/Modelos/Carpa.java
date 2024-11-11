package Modelos;

public class Carpa extends MedioDeAlojamiento{
    //Atributos
    private int cantidadPersonas;


    //Constructor

    public Carpa(String nombre, int rutCliente, float valorBaseNoche, String tipoTemporada, int cantidadNoches, int cantidadPersonas) {
        super(nombre, rutCliente, valorBaseNoche, tipoTemporada, cantidadNoches);
        this.cantidadPersonas = cantidadPersonas;
    }


    //Getters and Setters

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
    //Métodos

    @Override
    public float valorACancelar() {
        float valorACancelar=this.subtotal()-this.bonoDescuento();
        return valorACancelar;
    }
}
