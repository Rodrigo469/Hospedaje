package Modelos;

public class DatosCliente {
    //Atributos
    private String Nombre;
    private int rutCliente;

    //Constructor


    public DatosCliente(String nombre, int rutCliente) {
        Nombre = nombre;
        this.rutCliente = rutCliente;
    }

    //Getters and Setters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;

    }
}
