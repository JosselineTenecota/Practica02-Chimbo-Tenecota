
package ec.edu.ups.pratica02_chimbod_tenecotaj;

// Implementa la interfaz Prestable para gestionar el estado de disponibilidad del libro.
 
public class Libro implements Prestable {
 // Atributos 
    private String titulo;
    private String autor;
    private int año;
    private boolean disponible;
//-------------------------------------------------------------------------------------  
    
    //Constructor de la clase Libro.
    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.disponible = true;
    }
//-------------------------------------------------------------------------------------  

   //GETTER AND SETTER
    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setAño(int año) {
	this.año = año;
    }
//-------------------------------------------------------------------------------------  
	

	//Muestra la información del libro
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + año);
        System.out.println("Disponible: " + disponible);
    }
//-------------------------------------------------------------------------------------  
    
    //Obtiene el título del libro.
    public String getTitulo() {
        return titulo;
    }
 //Obtiene el autor del libro.
    public String getAutor() {
        return autor;
    }
//Obtiene el año de publicación del libro.
    public int getAño() {
        return año;
    }
 //-------------------------------------------------------------------------------------  
    
    //Verifica si el libro está disponible para préstamo.
    public boolean isDisponible() {
        return disponible;
    }
//Establece la disponibilidad del libro.
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
 //-------------------------------------------------------------------------------------  

     //Implementación del método prestar de la interfaz Prestable.
     //Muestra el estado de préstamo del libro.
    @Override
    public void prestar() {
        if (disponible) {
            System.out.println("Estado: prestado");
            disponible = false;
	}
	else {
            System.out.println("Libro no disponible");
	}
    }
//-------------------------------------------------------------------------------------  


    //Implementación del método devolver de la interfaz Prestable.
    //Muestra el estado de devolución del libro.
    @Override
    public void devolver() {
        if (!disponible) {
            System.out.println("Estado: devuelto");
            disponible = true;
        }
        else {
            System.out.println("Libro disponible");
        }
    }
}
