package P03_LecturaEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f2=new File("C:\\Users\\ifc\\eclipse-workspace\\f1.txt"); 
		
		FileWriter fichero_escritura = new FileWriter(f2);
		
		String cad = "Tarazona Mo-la";//creamos una cadena de caracteres
		char c_array[]= cad.toCharArray();//Pasamos de cadena a vector 
		
		for(int i=0;i<c_array.length;i++) {
			fichero_escritura.write(c_array[i]);
		}
		
		fichero_escritura.append("*");//con esto añadimos este caracter al final de lo escrito
		
		fichero_escritura.close();
		
		

	}

}
