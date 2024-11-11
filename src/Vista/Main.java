package Vista;

import Controlador.Hospedaje;
import Modelos.*;
import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
      int opcion;
      int codigoRut;

      Hospedaje hospedaje = new Hospedaje(new ArrayList<>());

      do{
         opcion=menu();
         switch (opcion) {
            case 1: //Importamos el medio de alojamiento
                codigoRut=pideRut();
                if(hospedaje.buscarAlojamiento(codigoRut)==-1){
                //Solicitamos info
               System.out.println("¿Nombre?"); String nombre= Leer.dato(); //Pedimos el nombre del cliente
               System.out.println("Ingrese el rut del nuevo cliente "); int rut= Leer.datoInt();// y el rut
                   System.out.println("Ingrese tipo de temporada: ");
                   String temporada =Leer.dato();
                 do{ // Comprobamos si la temporada es válida
                 if(temporada.equalsIgnoreCase("baja")||temporada.equalsIgnoreCase("media")||temporada.equalsIgnoreCase("alta")){
                    System.out.println("Temporada seleccionada: "+temporada+"\n");
                    break; // Comprobamos si la temporada es válida,salimos del bucle
                 }else{
                    System.out.println("Seleccione una temporada valida! (baja,media,alta)");
                     temporada =Leer.dato();//volvemos a pedir la temporada
                   }
                 }while(true); //  se repite hasta que se ingrese una temporada válida

                   float   valorBaseNoche;
                   System.out.println("Ingrese valor Base Noche: ");
                   valorBaseNoche=Leer.datoFloat();

                   int cantNoches;
                   System.out.println("Ingrese cantidad de noches: ");
                   cantNoches=Leer.datoInt();

                   int respuesta; //Pedimos info sobre tipo de alojamiento (carpa,hotel,cabagna)
                   do{
                      System.out.println("Ingrese una opcion...");
                      System.out.println("1.Carpa 2.Hotel 3.Cabagna");
                      respuesta=Leer.datoInt();

                   }while(respuesta<1 || respuesta>3);
                   System.out.println("Ingrese cantidad de personas: ");
                   if(respuesta==1) {//Carpa
                      int cantPersonas= Leer.datoInt();
                      Carpa carpa =new Carpa(nombre,rut,valorBaseNoche,temporada,cantNoches,cantPersonas);
                      hospedaje.ingresarAlojamientoCarpa(carpa);

                   }else{
                      System.out.println("Ingrese capacidad: "); int capacidad =Leer.datoInt();
                      System.out.println("Es fumador? true:si  false:no"); boolean fumador =Leer.datoBoolean();
                      if(respuesta==2){
                         System.out.println("Con desayuno? true:si  false:no "); boolean desayuno=Leer.datoBoolean();
                         Hotel hotel=new Hotel(nombre,rut,valorBaseNoche,temporada,cantNoches,capacidad,true,true);
                         hospedaje.ingresarAlojamientoHotel(hotel);


                      }else{
                         System.out.println("Con chimenea? true:si  false:no"); boolean chimenea=Leer.datoBoolean();
                         Cabagna cabagna = new Cabagna(nombre,rut,valorBaseNoche,temporada,cantNoches,capacidad,true,true);
                         hospedaje.ingresarAlojamientoCabagna(cabagna);

                      }
                   }
                   System.out.println("Alojamiento con el codigo : "+codigoRut+" ,agregado correctamente\n");
                }
               break;
            case 2:
               System.out.println("Opción 2: Mostrar medios de alojamiento.");
               hospedaje.imprimirMedioAlojamiento();

               break;
            case 3:
               System.out.println("Opción: 3: Mostrando datos para el cliente con rut: ");
               hospedaje.imprimirAlojamientoClientex(pideRut());
               break;
            case 4:
               hospedaje.totalAdicional();
               break;
            case 5:
               System.out.println("Opción 5: Total bono descuento.");
               hospedaje.totalBonoDescuento();
               break;
            case 6:
               System.out.println("Opción 6: Cantidad medios de alojamiento.");
                System.out.println("Ingrese medio de alojamiento: (carpa,hotel,cabagna)");
               String alojamiento =Leer.dato();
               hospedaje.totalMediosDeAlojamiento(alojamiento);
               break;
            case 7:
               System.out.println("Opción 7: Valor a cancelar por un cliente.");
               hospedaje.valorACancelar(pideRut());
               break;
            case 8:
               hospedaje.incremento();
               break;
            case 9:
               System.out.println("Saliendo del sistema.");
               break;
            default:
               System.out.println("Opción no válida, por favor ingrese una opción entre 1 y 9.");
               break;
         }
      }while(opcion!=9);

   }

   public static int pideRut(){
      System.out.println("Ingrese rut de Cliente para verificar alojamiento : ");
      return Leer.datoInt();
   }

   public static int menu(){
      System.out.println("Sistema Medios de Alojamientos");
      System.out.println(" ");
      System.out.println("1.\tIngresar medio de Alojamiento "); // (almacena un objeto de tipo Carpa/Cabaña/Hotel en la colección, siempre que no exista," +
      // es decir solo se puede asociar un cliente por medio de alojamiento.)
      System.out.println("2.\tMostrar medios de alojamiento "); // (muestra datos de todos los objetos almacenados)
      System.out.println("3.\tDatos de un cliente X "); //(si existe, muestra donde está alojado y todos los datos asociados)
      System.out.println("4.\tTotal adicional");
      System.out.println("5.\tTotal bono descuento ");
      System.out.println("6.\tCantidad medios de alojamiento X");
      System.out.println("7.\tValor a cancelar por un cliente X "); //(el cliente debe existir)
      System.out.println("8.\tAplicar incremento del valor base"); //(donde corresponda)
      System.out.println("9.\tSalir");
      System.out.println("-------------------");
      System.out.println("Ingrese una opcion para continuar...");
      return Leer.datoInt();
   }
}

