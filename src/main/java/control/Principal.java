/*Crea una clase llamada Libro que guarde la información de cada uno de los libros de una biblioteca. 
  La clase debe guardar el título del libro, autor, número de ejemplares del libro y número de ejemplares prestados. 

La clase contendrá los siguientes métodos:
Constructor por defecto. --
Constructor con parámetros. --
Métodos Setters/getters. --

Método préstamo que incremente el atributo correspondiente cada vez que se realice un préstamo del libro. 
No se podrán prestar libros de los que no queden ejemplares disponibles para prestar. 
Devuelve true si se ha podido realizar la operación y false en caso contrario.
Método devolución que decremente el atributo correspondiente cuando se produzca la devolución de un libro. 
No se podrán devolver libros que no se hayan prestado. 
Devuelve true si se ha podido realizar la operación y false en caso contrario.
Método toString para mostrar los datos de los libros. */
package control;
import java.util.Scanner;
import operaciones.Libro;
public class Principal {
    //Clase Scanner
    static Scanner sc = new Scanner(System.in);
    //Atributos Clase
    static int opc = 0, cant = 0, ejemplares = 0, prestados = 0;
    static String libro = "", autor = "", prestamo="";
    //Declaracion Arreglo de Objetos
    static Libro libros[];
    public static void main(String[] args) {
        int intento = 0, pres = 0, volver = 0;
        boolean repetir = false, devolucion=false;
        System.out.println("Bienvenid@ a Biblioteca\n");
        System.out.print("¿Cuantos libros vas a Registrar?: ");
        cant = sc.nextInt();

        libros = new Libro[cant];

        for (int i = 0; i < libros.length; i++) {
            System.out.println("\nCaracteristicas: " + (i + 1) + ".-Libro");
            sc.nextLine();
            System.out.print("Libro: ");
            libro = sc.nextLine();
            System.out.print("Autor: ");
            autor = sc.nextLine();
            System.out.print("Cantidad: ");
            ejemplares = sc.nextInt();
            System.out.print("Prestados: ");
            prestados = sc.nextInt();

            libros[i] = new Libro(libro, autor, ejemplares, prestados);
        }           
        do {
            System.out.println("\n\nSelecciona una opcion: \n1.-Prestamo.\n2.-Devolucion.\n3.-Informacion.\n4.-Salir.\n");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    //Prestamo....
                    do {
                        repetir = false;
                        System.out.println("¿Que libro deseas Prestar?\n");
                        sc.nextLine();
                        prestamo = sc.nextLine();
                        for (int i = 0; i < libros.length; i++) {
                            if (libros[i].getLibro().equals(prestamo)) {
                                libros[i].Mostrar();
                                do {
                                    repetir = false;
                                    System.out.println("\n¿Cuantos libros necesitas?: ");
                                    pres = sc.nextInt();
                                    if(pres <= 0){
                                        System.out.println("Cantidad no Valida.\n");
                                        repetir=true;
                                    }
                                    if (pres > libros[i].getEjemplares()) {
                                        System.out.println("No es posible prestar " + pres + " libros.");
                                        System.out.println("¿Deseas intentar con otra cantidad?\n1.-Si.\n2.-No.\n");
                                        volver = sc.nextInt();
                                        if (volver == 1) {
                                            repetir = true;
                                        }
                                    }
                                } while (repetir != false);
                                if (pres < libros[i].getEjemplares()) {
                                    libros[i].setEjemplares(libros[i].getEjemplares() - pres);
                                    libros[i].setEjemplaresPres(pres + libros[i].getEjemplaresPres());
                                    System.out.println("Libro Prestado\n");
                                }
                                //Actualiza el movimiento que se hizo
                                libros[i].Mostrar();

                            } else if (libros[i].getLibro() != (prestamo)) {
                                System.out.println("No encontrado: " + prestamo);
                                sc.nextLine();
                                System.out.println("¿Deseas buscar algun otro libro? \n1.-Si.\n2.-No.\n");
                                intento = sc.nextInt();
                                if (intento == 1) {
                                    repetir = true;
                                }
                            }
                        }
                    } while (repetir != false);
                    break;
                case 2:
                    //Devolucion
                    System.out.println("¿Que libro deseas devolver?\n");
                    sc.nextLine();
                    prestamo = sc.nextLine();
                    for (int i = 0; i < libros.length; i++) {
                        if (libros[i].getLibro().equals(prestamo)) {
                            libros[i].Mostrar();
                            if (libros[i].getEjemplaresPres() == 0) {
                                System.out.println("\nEse libro no se ha prestado\n");
                                break;
                            }
                            do {
                                repetir = false;
                                System.out.println("\n¿Cuantos libros vas a regresar?\n");
                                pres = sc.nextInt();

                                if (pres <= 0) {
                                    System.out.println("No es posible devolver " + pres + " libros.\n");
                                    System.out.println("¿Deseas intentar nuevamente?\n1.-Si.\n2.-No.\n");
                                    intento = sc.nextInt();
                                    if (intento == 1) {
                                        repetir = true;
                                    }
                                } else {
                                    libros[i].setEjemplares(libros[i].getEjemplares() + pres);
                                    libros[i].setEjemplaresPres(libros[i].getEjemplaresPres() - pres);
                                    libros[i].Mostrar();
                                }
                            } while (repetir != false || devolucion != false);
                        }
                    }
                    break;
                case 3:
                        for (int i = 0; i < libros.length; i++) {
                            libros[i].Mostrar();
                        }
                    break;
                case 4:
                    System.out.println("Fin del Programa...\n");
                    break;
                default:
                    System.out.println("Opcion invalida, intentelo nuevamente...\n");
            }
        } while (opc != 4);
    }
}
