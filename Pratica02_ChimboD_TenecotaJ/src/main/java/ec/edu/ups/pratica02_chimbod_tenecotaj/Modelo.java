
package ec.edu.ups.pratica02_chimbod_tenecotaj;


//La clase Modelo actúa como un contenedor para una instancia 
//de la clase Biblioteca.
public class Modelo {
//ATRIBUTO
    private Biblioteca biblioteca;
//-------------------------------------------------------------------------------------  

 
 // Constructor de la clase Modelo que inicializa la biblioteca. 
    public Modelo() {
        this.biblioteca = new Biblioteca("Biblioteca", "AvenidPrincipal 5-30");
    }
//-------------------------------------------------------------------------------------  

 
 // Método para obtener la instancia de Biblioteca almacenada en el modelo.
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
 // Método para establecer la instancia de Biblioteca en el modelo.
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
 
//-------------------------------------------------------------------------------------  

 // Método toString que proporciona una representación en cadena del objeto Modelo.
    @Override
    public String toString() {
        return "Modelo{" + "biblioteca=" + biblioteca + '}';
    }
}
    

