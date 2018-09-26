package P01_Manipular;

import java.io.File;
import java.io.FileWriter;

public class CrearFichero {

	public static void main(String[] args) {
		
		try {
		//Creamos ficheros de texto en ifc
		FileWriter f1 = new FileWriter("C:\\Users\\ifc\\f1.txt");
		
		
		FileWriter f2 = new FileWriter("C:\\Users\\ifc\\f2.txt");
		
		} catch (Exception ex) {
			
			System.out.println(ex);
		
		}

	}

}
