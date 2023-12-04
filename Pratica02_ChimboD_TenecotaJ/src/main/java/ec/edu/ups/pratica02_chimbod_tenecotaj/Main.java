
package ec.edu.ups.pratica02_chimbod_tenecotaj;


public class Main {
    public static void main(String[] args) {
//Permite entrelazar los metodos creados para realizar la ejecuacion. 
        Modelo mod = new Modelo();
        MostrarPantalla muestra = new MostrarPantalla();
        Controlar controla = new Controlar(mod, muestra);
//Muestra el menu de opciones del sistema. 
        System.out.println("==== SISTEMA ====");
        System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Registrar Usuario");
        System.out.println("3. Buscar Libro");
        System.out.println("4. Prestar Libro");
        System.out.println("5. Devolver Libro");
        System.out.println("6. Salir");

        controla.ejecutar();
}
}
    



    

