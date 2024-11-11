package Modelos;

public class Hotel extends Hospederia{
    //Atributos
    private boolean conDesayuno;

    //Constructor

    public Hotel(String nombre, int rutCliente, float valorBaseNoche, String tipoTemporada, int cantidadNoches, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(nombre, rutCliente, valorBaseNoche, tipoTemporada, cantidadNoches, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }


    //Getters and Setters

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    @Override
    public float valorAdicional(){
        float valorAdicional=0;
        if(this.isEsFumador()||this.isConDesayuno() ){ valorAdicional=this.subtotal()*30/100;
        } return valorAdicional;
    }

    @Override
    public float valorACancelar() {
        float valorACancelar=this.subtotal()-bonoDescuento()+valorAdicional();
        return valorACancelar;
    }
}
