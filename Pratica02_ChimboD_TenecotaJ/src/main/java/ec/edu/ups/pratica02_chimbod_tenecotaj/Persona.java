
package ec.edu.ups.pratica02_chimbod_tenecotaj;


// CLASE PADRE DE USUARIO 

//La clase Persona es una clase abstracta que sirve 
//como clase base para las clases más específicas.
public abstract class Persona {
// Atributos protegidos de la clase Persona.
    protected String nombre;
    protected String identificacion;
//-------------------------------------------------------------------------------------  

 // Constructor de la clase Persona.
    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }
//GETTER AND SETTER 
    public String getNombre() {
 	return nombre;
    }
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
    public String getIdentificacion() {
	return identificacion;
    }
    public void setIdentificacion(String identificacion) {
	this.identificacion = identificacion;
    }

//-------------------------------------------------------------------------------------  

// Método abstracto para mostrar la información de la persona.
 // Cada clase hija deberá proporcionar su propia implementación.
    public abstract void mostrarInformacion();
   }