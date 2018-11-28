/*Clase que crea un objeto Persona con sus respectivos atributos, contructor y métodos. 
 * Implementamos Serializable para que el objeto pueda ser leido y escrito en un fichero*/

package P04_FicherosBytes;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private int edad;
	private String nombre;
	
	public Persona(int ed, String no) {
		edad=ed;
		nombre=no;
	}
	
	//getters
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}

	//setters
	
	public void setEdad(int x) {
		edad=x;
	}
	
	public void setNombre(String no) {
		nombre=no;
	}
	
	
}
