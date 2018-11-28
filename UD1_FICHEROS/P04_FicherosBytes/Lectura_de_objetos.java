/*Clase que lee los objetos Persona que contiene un fichero.*/

package P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Lectura_de_objetos {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File f = new File ("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\P04_FicherosBytes\\personas.dat");

		FileInputStream filein = new FileInputStream(f);
		ObjectInputStream objectin = new ObjectInputStream(filein);
		
		Persona pe;
		
		try {
				while(true) {
								pe=(Persona)objectin.readObject();
								System.out.println("Nombre: "+pe.getNombre()+", Edad: "+pe.getEdad());
				           }
			
		}catch (EOFException eo) {
			System.out.println("");
		}
		objectin.close();
	}

}
