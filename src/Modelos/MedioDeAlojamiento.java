package Modelos;

public abstract class MedioDeAlojamiento extends DatosCliente {
    //Atributos

    protected float valorBaseNoche;
    protected String tipoTemporada;
    protected int cantidadNoches;
    //Constructor

    public MedioDeAlojamiento(String nombre, int rutCliente, float valorBaseNoche, String tipoTemporada, int cantidadNoches) {
        super(nombre, rutCliente);
        this.valorBaseNoche = valorBaseNoche;
        this.tipoTemporada = tipoTemporada;
        this.cantidadNoches = cantidadNoches;
    }


    //Getters and Setters

    public float getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(float valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    //Metodos
    public float subtotal() {
        float subtotal = 0;
        return subtotal = this.getValorBaseNoche() * getCantidadNoches();
    }

    public float bonoDescuento() {
        float bonoDescuento = 0;
        if (this.getTipoTemporada().equalsIgnoreCase("baja")) {
            bonoDescuento = this.subtotal() * 25 / 100;
        }
        else if(this.getTipoTemporada().equalsIgnoreCase("media")) {
            bonoDescuento = (float) (this.subtotal() * 12.5 / 100);
        }

        return bonoDescuento;
    }

    public abstract float valorACancelar();

}