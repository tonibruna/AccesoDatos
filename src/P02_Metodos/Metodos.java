package P02_Metodos;

import java.io.FileWriter;

public class Metodos {

	public static void main(String[] args) {
		
		try {
			
		FileWriter f1 = new FileWriter("C:\\Users\\ifc\\f1.txt");
		
		//Escribimos en el archivo f1
		f1.write("El cipotegato es en Agosto");
		f1.close(); 
				
		System.out.println(f1.getEncoding()); //metodo de ejemplo
	    

		} catch (Exception ex) {
			
			System.out.println(ex);
		

	   }

	}
}
