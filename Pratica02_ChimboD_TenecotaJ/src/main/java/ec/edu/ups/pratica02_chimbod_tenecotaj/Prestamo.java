
package ec.edu.ups.pratica02_chimbod_tenecotaj;
import java.util.Date;
//La clase Prestamo representa un préstamo de un libro a un usuario en la biblioteca.
public class Prestamo {
//ATRIBUTOS
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
//-------------------------------------------------------------------------------------  

 // Constructor de la clase Prestamo.
    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = new Date();
    }
    //-------------------------------------------------------------------------------------  

 
 // GETTER AND SETTER
    public Date getFechaPrestamo() {
	return fechaPrestamo;
    }
    public void setFechaPrestamo(Date fechaPrestamo) {
	this.fechaPrestamo = fechaPrestamo;
    }
    public Date getFechaDevolucion() {
	return fechaDevolucion;
    }
    public void setFechaDevolucion(Date fechaDevolucion) {
	this.fechaDevolucion = fechaDevolucion;
    }
    public void setLibro(Libro libro) {
	this.libro = libro;
    }
    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }
//-------------------------------------------------------------------------------------   
 

 // Método para obtener el libro prestado en este préstamo.
    public Libro getLibro() {
        return libro;
    }
// Método para verificar si el préstamo sigue vigente.
    public boolean esPrestamoVigente() {
        int maxDiasPrestamo = 14;
        return calcularDiasPrestamo(fechaPrestamo.getTime(), System.currentTimeMillis()) <= maxDiasPrestamo;
    }
 // Método para obtener el usuario que realizó el préstamo.
    public Usuario getUsuario() {
        return usuario;
    }
// Método para calcular la duración del préstamo en días.
    public int calcularDiasPrestamo(long tiempoInicio, long tiempoFin) {
        long tiempoPrestamo = tiempoFin - tiempoInicio;
        return (int) (tiempoPrestamo / (1000 * 60 * 60 * 24));
    }
}
