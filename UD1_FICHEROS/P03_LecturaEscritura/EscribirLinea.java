package P03_LecturaEscritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirLinea {

	public static void main(String[] args) {
		
		try {
		
		File f5=new File("C:\\Users\\ifc\\eclipse-workspace\\ACCESO_DATOS_DAM_2\\UD1_FICHEROS\\ficheros\\LeerLinea.txt");
		
		FileWriter fichero = new FileWriter (f5);
		
		BufferedWriter br= new BufferedWriter(fichero);
		
		int nLineas = 10;
		
		for(int i=1;i<=nLineas;i++) {
			    br.write("Fila numero" + i);
			    br.newLine();
			
		}
		br.close();
		
	}
	catch (FileNotFoundException fn) {
		System.out.println("El fichero no se encuentra...");
	}
	
	catch (IOException io) {
		System.out.println("Error de E/S");
	}
	
   }

}


