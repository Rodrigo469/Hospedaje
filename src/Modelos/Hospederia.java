package Modelos;

public abstract class Hospederia extends MedioDeAlojamiento{
    //Atributos
    protected int capacidad;
    protected boolean esFumador;
//Constructor


    public Hospederia(String nombre, int rutCliente, float valorBaseNoche, String tipoTemporada, int cantidadNoches, int capacidad, boolean esFumador) {
        super(nombre, rutCliente, valorBaseNoche, tipoTemporada, cantidadNoches);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    //Getters and Setters
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }
    // Métodos

    public abstract float valorAdicional();
}
