
package ec.edu.ups.pratica02_chimbod_tenecotaj;
import java.util.Scanner;


public class Controlar {
//ATRIBUTOS
//La clase Controlar se encarga de gestionar las interacciones entre el usuario y el sistema.
    private Modelo mod;
    private MostrarPantalla muestra;
    private Scanner scanner;
//-------------------------------------------------------------------------------------   
 
 // Constructor de la clase Controlar.
    public Controlar(Modelo mod, MostrarPantalla muestra) {
        this.mod = mod;
        this.muestra = muestra;
        this.scanner = new Scanner(System.in);
    }
//-------------------------------------------------------------------------------------   

 
 //GETTER AND SETTER
    public Modelo getMod() {
	return mod;
    }
    public void setMod(Modelo mod) {
	this.mod = mod;
    }
    public MostrarPantalla getMuestra() {
	return muestra;
    }
    public void setMuestra(MostrarPantalla muestra) {
	this.muestra = muestra;
    }
    public Scanner getScanner() {
	return scanner;
    }
    public void setScanner(Scanner scanner) {
	this.scanner = scanner;
    }
//-------------------------------------------------------------------------------------   


// Método principal para ejecutar las acciones del sistema según las opciones del usuario.
    public void ejecutar() {
        int opcion;
//Permite controlar la condicion.
        boolean continuar = true;

        do {
            muestra.MenudeOpciones();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    prestarLibro();
                    break;
                case 5:
                    devolverLibro();
                    break;
                case 6:
                    muestra.Mensajes("Salir");
                    continuar = false; // Actualización para salir del bucle
                    break;
            }
        } while (continuar); // Cambio en la condición

        scanner.close();
    }
//-------------------------------------------------------------------------------------   

 
 // Método para devolver un libro prestado.
    public  void devolverLibro() {
    muestra.Mensajes("Ingrese el título del libro que desea devolver: ");
    String tituloLibro = scanner.nextLine();
    Libro libroDevolver = mod.getBiblioteca().buscarLibro(tituloLibro);

    if (libroDevolver == null) {
        muestra.Mensajes("Libro no encontrado.");
    } else if (!libroDevolver.isDisponible()) {
        muestra.Mensajes("Ingrese el ID del usuario que devolverá el libro: ");
        String idUsuario = scanner.nextLine();
        Usuario usuarioDevolucion = null;

        // Buscar el usuario por identificación
        for (Usuario usuario : mod.getBiblioteca().getListaUsuarios()) {
            if (usuario.getIdentificacion().equals(idUsuario)) {
                usuarioDevolucion = usuario;
                break;
            }
        }
        if (usuarioDevolucion != null) {
            muestra.MenudeOpciones();
            muestra.Mensajes("El libro ha sido devuelto.");
        } else {
            muestra.Mensajes("No encontrado.");
        }
    } else {
        muestra.Mensajes("No está disponible.");
    }   
}
//-------------------------------------------------------------------------------------   
 
 
 // Método para prestar un libro.
    public  void prestarLibro() {
        muestra.Mensajes("Ingrese el título del libro que desea prestar: ");
        String tituloLibro = scanner.nextLine();
        Libro libroPrestar = mod.getBiblioteca().buscarLibro(tituloLibro);

        if (libroPrestar == null) {
            muestra.Mensajes("Libro no encontrado.");
        } else if (libroPrestar.isDisponible()) {
            muestra.Mensajes("Ingrese el ID del prestamista: ");
            String idUsuario = scanner.nextLine();
            Usuario usuarioPrestamo = null;

        // Buscar el usuario por identificación
            for (Usuario usuario : mod.getBiblioteca().getListaUsuarios()) {
               if (usuario.getIdentificacion().equals(idUsuario)) {
                   usuarioPrestamo = usuario;
                   break;
                }
            }

            if (usuarioPrestamo != null) {
                mod.getBiblioteca().prestarLibro(libroPrestar, usuarioPrestamo);
                muestra.Mensajes("Se ha realizado el préstamo.");
            } else {
            muestra.Mensajes("No se ha encontrado ningún usuario con ese nombre.");
            }
        } else {
            muestra.Mensajes("No está disponible.");
        }
    }
//-------------------------------------------------------------------------------------   

 
 // Método para buscar un libro por título.
    public  void buscarLibro() {
        muestra.Mensajes("Ingrese el título del libro que desea buscar: ");
        String criterioBusqueda = scanner.nextLine();
        Libro libroEncontrado = mod.getBiblioteca().buscarLibro(criterioBusqueda);
        if (libroEncontrado != null) {
            libroEncontrado.mostrarInformacion();
        } else {
            muestra.Mensajes("Libro no encontrado.");
        }
    }
//-------------------------------------------------------------------------------------   

 
 // Método para registrar un nuevo usuario.
    public  void registrarUsuario() {
        muestra.Mensajes("Ingrese los datos del nuevo usuario:");
        muestra.Mensajes("Nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();
        muestra.Mensajes("ID del usuario: ");
        String idUsuario = scanner.nextLine();
        muestra.Mensajes("Correo electrónico del usuario: ");
        String correoUsuario = scanner.nextLine();
        Usuario nuevoUsuario = new Usuario(nombreUsuario, idUsuario, correoUsuario);
        mod.getBiblioteca().registrarUsuario(nuevoUsuario);
        muestra.Mensajes("Se ha registrado el nombre del usuario.");
    }
//-------------------------------------------------------------------------------------   
 
 
 // Método para agregar un nuevo libro a la biblioteca.
    public void agregarLibro() {
        muestra.Mensajes("Ingrese los detalles del libro:");
        muestra.Mensajes("Título del libro: ");
        String tituloLibro = scanner.nextLine();
        muestra.Mensajes("Autor del libro: ");
        String autorLibro = scanner.nextLine();
        muestra.Mensajes("Año del libro: ");
        int añoLibro = scanner.nextInt();
        Libro nuevoLibro = new Libro(tituloLibro, autorLibro, añoLibro);
        mod.getBiblioteca().agregarLibro(nuevoLibro);
        muestra.Mensajes("El libro ha sido agregado.");
    }
}