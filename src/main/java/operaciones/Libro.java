package operaciones;
import java.util.Scanner;
//Clase Padre de Libro
public class Libro {
    //Clase Scanner
    Scanner sc = new Scanner(System.in);
    //Atributos
    protected String libro, autor;
    protected int ejemplares, ejemplaresPres;
    
    //Constructor por defecto
    public Libro() {
    }

    //Constructor Parametros
    public Libro(String libro, String autor, int ejemplares, int ejemplaresPres) {
        this.libro = libro;
        this.autor = autor;
        this.ejemplares = ejemplares;
        this.ejemplaresPres = ejemplaresPres;
    }

    //Getters y Setters
    public String getLibro() {
        return libro;
    }
    public String getAutor() {
        return autor;
    }
    public int getEjemplares() {
        return ejemplares;
    }
    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }
    public int getEjemplaresPres() {
        return ejemplaresPres;
    }
    public void setEjemplaresPres(int ejemplaresPres) {
        this.ejemplaresPres = ejemplaresPres;
    }
    
    //Metodo Mostrar propiedades
    public void Mostrar(){
        System.out.println("\n\nInformacion: ");
        System.out.println("Libro: "+getLibro());
        System.out.println("Autor: "+getAutor());
        System.out.println("Cantidad: "+getEjemplares());
        System.out.println("Prestados: "+getEjemplaresPres());
    }
}
