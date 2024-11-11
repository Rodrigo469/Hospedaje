package Controlador;

import Modelos.Cabagna;
import Modelos.Carpa;
import Modelos.Hotel;
import Modelos.MedioDeAlojamiento;

import java.util.ArrayList;
import java.util.Objects;

public class Hospedaje {
    //Atributos
     ArrayList<MedioDeAlojamiento> hospedaje;

    // Constructor

    public Hospedaje(ArrayList<MedioDeAlojamiento> hospedaje) {
        this.hospedaje = hospedaje;
    }

    //Getters and Setters

    public ArrayList<MedioDeAlojamiento> getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(ArrayList<MedioDeAlojamiento> hospedaje) {
        this.hospedaje = hospedaje;
    }

    //Métodos

    //1.Ingresar Medio de Alojamiento((almacena un objeto de tipo Carpa/Cabaña/Hotel en la colección,
    // siempre que no exista, es decir solo se puede asociar un cliente por medio de alojamiento.)

    //Buscar alojamiento
    public int buscarAlojamiento(int rutCliente){
        for(int i=0;i<hospedaje.size();i++){
            if(hospedaje.get(i).getRutCliente()==rutCliente){
                System.out.println("El cliente existe: "+hospedaje.get(i).getRutCliente()+"\n");
                return i;
            }
        }
        System.out.println("No se encontro el rut en la lista de cliente existente +\n");
        return -1;
    }

   //Ingresar alojamiento de carpa
    public void ingresarAlojamientoCarpa(Carpa carpa){
        if(buscarAlojamiento(carpa.getRutCliente())==-1){
         //No hay un alojamiento asociado
            hospedaje.add(carpa);
        }
    }

    //Ingresar alojamiento de hotel
    public void ingresarAlojamientoHotel(Hotel hotel){
        if(buscarAlojamiento(hotel.getRutCliente())==-1){
            //No hay un alojamiento asociado
            hospedaje.add(hotel);
        }
    }

    //Ingresar alojamiento de cabagna
    public void ingresarAlojamientoCabagna(Cabagna cabagna){
        if(buscarAlojamiento(cabagna.getRutCliente())==-1){
            //No hay un alojamiento asociado
            hospedaje.add(cabagna);
        }
    }
    // 2.	Mostrar medios de alojamiento (muestra datos de todos los objetos almacenados)
    public void imprimirMedioAlojamiento(){
        Carpa carpa=null;
        Hotel hotel=null;
        Cabagna cabagna= null;
        for(int i=0;i<hospedaje.size();i++) {
            if (hospedaje.get(i) instanceof Carpa) {
                carpa = (Carpa) hospedaje.get(i);
                System.out.println("El cliente alojado en carpa " + carpa.getRutCliente() + " " + carpa.getNombre());
                System.out.println("Tipo de temporada: " + carpa.getTipoTemporada());
                System.out.println("Cantidad de noches: " + carpa.getCantidadNoches());
                System.out.println("Cantidad de personas: " + carpa.getCantidadPersonas()+"\n");
            }
            if (hospedaje.get(i) instanceof Hotel) {
                hotel = (Hotel) hospedaje.get(i);
                System.out.println("El cliente alojado en hotel " + hotel.getRutCliente() + " " + hotel.getNombre());
                System.out.println("Tipo de temporada: " + hotel.getTipoTemporada());
                System.out.println("Cantidad de noches: " + hotel.getCantidadNoches());
                System.out.println("Con desayuno? : " + hotel.isConDesayuno());
                System.out.println("Capacidad ? " + hotel.getCapacidad());
                System.out.println("Es fumador ? " + hotel.isEsFumador()+"\n");
            }
            if (hospedaje.get(i) instanceof Cabagna) {
                cabagna = (Cabagna) hospedaje.get(i);
                System.out.println("El cliente alojado en cabagna " + cabagna.getRutCliente() + " " + cabagna.getNombre());
                System.out.println("Tipo de temporada: " + cabagna.getTipoTemporada());
                System.out.println("Cantidad de noches: " + cabagna.getCantidadNoches());
                System.out.println("Con chimenea? : " + cabagna.isChimenea());
                System.out.println("Capacidad ? " + cabagna.getCapacidad());
                System.out.println("Es fumador ? " + cabagna.isEsFumador()+"\n");
            }
        }
     }
    //3.	Datos de un cliente X (si existe, muestra donde está alojado y todos los datos asociados)

    public void imprimirAlojamientoClientex(int rutCliente){
        int posicion=buscarAlojamiento(rutCliente);
        Carpa carpa=null;
        Hotel hotel=null;
        Cabagna cabagna= null;
        if (hospedaje.get(posicion) instanceof Carpa) {
            carpa = (Carpa) hospedaje.get(posicion);
            System.out.println("El cliente alojado en carpa " + carpa.getRutCliente() + " " + carpa.getNombre());
            System.out.println("Tipo de temporada: " + carpa.getTipoTemporada());
            System.out.println("Cantidad de noches: " + carpa.getCantidadNoches());
            System.out.println("Cantidad de personas: " + carpa.getCantidadPersonas()+"\n");
        }
        if (hospedaje.get(posicion) instanceof Hotel) {
            hotel = (Hotel) hospedaje.get(posicion);
            System.out.println("El cliente alojado en hotel " + hotel.getRutCliente() + " " + hotel.getNombre());
            System.out.println("Tipo de temporada: " + hotel.getTipoTemporada());
            System.out.println("Cantidad de noches: " + hotel.getCantidadNoches());
            System.out.println("Con desayuno? : " + hotel.isConDesayuno());
            System.out.println("Capacidad ? " + hotel.getCapacidad());
            System.out.println("Es fumador ? " + hotel.isEsFumador()+"\n");
        }
        if (hospedaje.get(posicion) instanceof Cabagna) {
            cabagna = (Cabagna) hospedaje.get(posicion);
            System.out.println("El cliente alojado en cabagna " + cabagna.getRutCliente() + " " + cabagna.getNombre());
            System.out.println("Tipo de temporada: " + cabagna.getTipoTemporada());
            System.out.println("Cantidad de noches: " + cabagna.getCantidadNoches());
            System.out.println("Con chimenea? : " + cabagna.isChimenea());
            System.out.println("Capacidad ? " + cabagna.getCapacidad());
            System.out.println("Es fumador ? " + cabagna.isEsFumador()+"\n");
        }
    }
    //4,	Total adicional
    public void totalAdicional(){
        Hotel hotel=null;
        Cabagna cabagna= null;
        for(int i=0;i<hospedaje.size();i++) {
            if (hospedaje.get(i) instanceof Hotel) {
                hotel = (Hotel) hospedaje.get(i);
                System.out.println("El valor total adicional del hotel: "+hotel.valorAdicional());
            }
            if (hospedaje.get(i) instanceof Cabagna) {
                cabagna = (Cabagna) hospedaje.get(i);
                System.out.println("El valor total adicional de la cabagna: "+cabagna.valorAdicional());
            }
        }
    }
    //5.	Total bono descuento
     public void totalBonoDescuento(){
         Carpa carpa=null;
         Hotel hotel=null;
         Cabagna cabagna= null;
         for(int i=0;i<hospedaje.size();i++) {
             if (hospedaje.get(i) instanceof Carpa) {
                 carpa = (Carpa) hospedaje.get(i);
                 System.out.println("El valor total de bono de la carpa : "+carpa.bonoDescuento());
             }
             if (hospedaje.get(i) instanceof Hotel) {
                 hotel = (Hotel) hospedaje.get(i);
                 System.out.println("El valor total de bono del hotel : "+hotel.bonoDescuento());
             }
             if (hospedaje.get(i) instanceof Cabagna) {
                 cabagna = (Cabagna) hospedaje.get(i);
                 System.out.println("El valor total de bono de la cabagna : "+cabagna.bonoDescuento());
             }
         }

     }

    //6. Cantidad medios de alojamiento X

     public void totalMediosDeAlojamiento(String alojamiento){
         int cantidadX=0;
         Carpa carpa=null;
         Hotel hotel=null;
         Cabagna cabagna= null;
         for(int i=0;i<hospedaje.size();i++) {
             if (hospedaje.get(i) instanceof Carpa && alojamiento.equalsIgnoreCase("carpa")) {
                 cantidadX++;
             }
             if (hospedaje.get(i) instanceof Hotel  && alojamiento.equalsIgnoreCase("hotel")) {
                 cantidadX++;
             }
             if (hospedaje.get(i) instanceof Cabagna && alojamiento.equalsIgnoreCase("cabagna")) {
                 cantidadX++;


             }
         }
         System.out.println("Total medio de alojamiento es igual a: "+cantidadX);
     }

    //7.	Valor a cancelar por un cliente X (el cliente debe existir)
     public void valorACancelar(int rutCliente){
         int posicion=buscarAlojamiento(rutCliente);
         Carpa carpa=null;
         Hotel hotel=null;
         Cabagna cabagna= null;
         if (hospedaje.get(posicion) instanceof Carpa) {
             carpa = (Carpa) hospedaje.get(posicion);
             System.out.println("valor a cancelar del cliente: "+carpa.getNombre()+" "+rutCliente+" es de $"+carpa.valorACancelar()+"\n");
         }
         if (hospedaje.get(posicion) instanceof Hotel) {
             hotel = (Hotel) hospedaje.get(posicion);
             System.out.println("valor a cancelar del cliente: "+hotel.getNombre()+" "+rutCliente+" es de $"+hotel.valorACancelar()+"\n");
         }
         if (hospedaje.get(posicion) instanceof Cabagna) {
             cabagna = (Cabagna) hospedaje.get(posicion);

             System.out.println("valor a cancelar del cliente: "+cabagna.getNombre()+" "+rutCliente+" es de $"+cabagna.valorACancelar()+"\n");
         }
     }
    //8.    Aplicar incremento del valor base (donde corresponda)
          public void incremento(){
              Cabagna cabagna= null;
              for(int i=0;i<hospedaje.size();i++) {
                  if (hospedaje.get(i) instanceof Cabagna){
                      cabagna = (Cabagna) hospedaje.get(i);
                      System.out.println("el incremento del cliente alojado en cabagna es: "+cabagna.getNombre()+" "+cabagna.getRutCliente()+" es de $"+cabagna.IncrementoVBase()+"\n");
                  }
              }
          }

}


























