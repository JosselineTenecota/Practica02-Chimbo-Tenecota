
package ec.edu.ups.pratica02_chimbod_tenecotaj;
import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {
//ATRIBUTOS
// La clase Biblioteca representa una biblioteca con una lista 
// de libros y usuarios.
    private String nombre;
    private String direccion;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;

//-------------------------------------------------------------------------------------   

    // Constructor de la clase Biblioteca.
    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaLibros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }
    
//-------------------------------------------------------------------------------------   
    
// GETTER AND SETTER    
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}


//-------------------------------------------------------------------------------------   

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

//-------------------------------------------------------------------------------------   


	// Agrega un libro a la lista de libros de la biblioteca.
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    // Registra un nuevo usuario en la biblioteca.
    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    // Busca un libro en la biblioteca según un criterio (título, autor o año).
    public Libro buscarLibro(String criterio) {
        for (Libro libro : listaLibros) {
            if (cumpleCriterio(libro, criterio)) {
                return libro;
            }
        }
        return null;
    }
    
    // Verifica si un libro cumple con un criterio de búsqueda.
    public boolean cumpleCriterio(Libro libro, String criterio) {
        return libro.getTitulo().equalsIgnoreCase(criterio) ||
                libro.getAutor().equalsIgnoreCase(criterio) ||
                String.valueOf(libro.getAño()).equalsIgnoreCase(criterio);
    }

    // Realiza el préstamo de un libro a un usuario.
    public void prestarLibro(Libro libro, Usuario usuario) {
        if (!libro.isDisponible()) {
            return;
        }

        Prestamo p = new Prestamo(libro, usuario);
        usuario.agregarPrestamo(p);
        libro.prestar();
        System.out.println("Hecho el préstamo.");
    }

    
//-------------------------------------------------------------------------------------   


    // Obtiene la lista de usuarios de la biblioteca.
    Iterable<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
 //-------------------------------------------------------------------------------------   

    // Realiza la devolución de un libro por parte de un usuario.
    public void devolverLibro(Libro libroDevolver, Usuario usuarioDevolver) {
        boolean libroPrestado = false;

        for (Prestamo p : usuarioDevolver.getListaPrestamos()) {
            if (p.getLibro().equals(libroDevolver) && p.esPrestamoVigente()) {
                libroPrestado = true;
                break;
            }
        }

        if (libroPrestado) {
            libroDevolver.setDisponible(true);

            Iterator<Prestamo> iterator = usuarioDevolver.getListaPrestamos().iterator();
            while (iterator.hasNext()) {
                Prestamo p = iterator.next();
                if (p.getLibro().equals(libroDevolver) && p.esPrestamoVigente()) {
                    iterator.remove();
                    break;
                }
            }
            System.out.println("Libro devuelto correctamente.");
        }
    }
}