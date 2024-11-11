package Modelos;

public class Cabagna extends Hospederia{
    //Atributos
    private boolean chimenea;
    //Constructor

    public Cabagna(String nombre, int rutCliente, float valorBaseNoche, String tipoTemporada, int cantidadNoches, int capacidad, boolean esFumador, boolean chimenea) {
        super(nombre, rutCliente, valorBaseNoche, tipoTemporada, cantidadNoches, capacidad, esFumador);
        this.chimenea = chimenea;
    }


    //Getters and Setters

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    @Override
    public float valorAdicional() {
        float valorAdicional = 0;
        if (this.isEsFumador()) {
            valorAdicional = this.subtotal() * 30 / 100;
        }
        return valorAdicional;
    }
    public float IncrementoVBase(){
        float IncrementoVBase=0;
        if(this.capacidad>5){
           IncrementoVBase=this.subtotal()*18/100;
        }return IncrementoVBase;
    }

    @Override
    public float valorACancelar() {

        float valorACancelar=this.subtotal()-bonoDescuento()+valorAdicional()+IncrementoVBase();
        return valorACancelar;
    }
}
