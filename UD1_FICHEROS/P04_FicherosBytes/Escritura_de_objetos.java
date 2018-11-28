/*Clase que escribe 5 objetos Persona en un fichero.
 * Los atributos son pasados por teclado.*/

package P04_FicherosBytes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Escritura_de_objetos {

	public static void main(String[] args) throws IOException{
		
		File f = new File ("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\P04_FicherosBytes\\personas.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		Persona pe;
		
		
		Scanner teclado = new Scanner (System.in);
		String [] nombres = new String [5];
		int[] edades = new int[5];
		
		for(int i=0; i<5; i++) {
			System.out.println("Introduce nombre de la persona");
			nombres[i]=teclado.next();
			System.out.println("Introduce edad de la persona");
			edades[i]=teclado.nextInt();
		}
		
		for(int i=0; i<5; i++) {
			
			//inicializamos persona
			pe = new Persona(edades[i],nombres[i]);
			//escribir un objeto en un fichero
			objectout.writeObject(pe);
		}
		
		teclado.close();
		objectout.close();
	}

}
