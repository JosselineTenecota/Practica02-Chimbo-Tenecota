
package ec.edu.ups.pratica02_chimbod_tenecotaj;


import java.util.ArrayList;
import java.util.Iterator;

// CLASE HIJA DE PERSONA
//Clase que representa a un usuario en la biblioteca, heredando de la clase abstracta Persona.
public class Usuario extends Persona {
    private String correo;
    private ArrayList<Prestamo> listaPrestamos;
//-------------------------------------------------------------------------------------   

    // Constructor de la clase Usuario.
    public Usuario(String nombre, String identificacion, String correo) {
        super(nombre, identificacion);
        this.correo = correo;
        this.listaPrestamos = new ArrayList<>();
    }
//-------------------------------------------------------------------------------------   
   // GETTER AND SETTER
    public String getCorreo() {
	return correo;
    }
    public void setCorreo(String correo) {
	this.correo = correo;
    }
    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
	this.listaPrestamos = listaPrestamos;
    }
//-------------------------------------------------------------------------------------   



    // Implementación del método abstracto de la clase padre para mostrar la información del usuario.
    @Override
    public void mostrarInformacion() {//este si
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + identificacion);
        System.out.println("Correo: " + correo);
    }
//-------------------------------------------------------------------------------------   

    // Método para solicitar el préstamo de un libro.
   public void solicitarPrestamo(Libro libro) {
       if (!libro.isDisponible()) {
        System.out.println("El libro no está disponible.");
        return;
       }
       Prestamo prestamo = new Prestamo(libro, this);
       libro.prestar();
       agregarPrestamo(prestamo);
       System.out.println("Préstamo solicitado con éxito.");
    }
//-------------------------------------------------------------------------------------   

    
    // Método para devolver un libro prestado.
    public void devolverLibro(Libro libro) {
        boolean devolucionExitosa = false;

        Iterator<Prestamo> iterator = listaPrestamos.iterator();
        while (iterator.hasNext()) {
            Prestamo prestamo = iterator.next();
            if (prestamo.getLibro().equals(libro) && prestamo.esPrestamoVigente()) {
                libro.devolver();
                iterator.remove();
                devolucionExitosa = true;
                break;
            }
        }

        if (devolucionExitosa) {
            System.out.println("Está disponible");
        }
    }
//-------------------------------------------------------------------------------------   

    // Método para agregar un préstamo a la lista de préstamos del usuario.
    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }
    // Método para obtener la identificación del usuario.
    public String getIdentificacion() {
        return identificacion;
    }
    // Método para obtener la lista de préstamos del usuario.
    public Iterable<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
}

