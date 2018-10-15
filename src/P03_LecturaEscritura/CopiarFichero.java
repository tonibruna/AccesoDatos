package P03_LecturaEscritura;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarFichero {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Creamos el primer fichero
		File f1 = new File("C:\\Users\\ifc\\eclipse-workspace\\copiarfichero1.txt");
		f1.createNewFile();
		
		//Creamos el primer fichero
		File f2 = new File("C:\\Users\\ifc\\eclipse-workspace\\copiarfichero2.txt");
		f2.createNewFile();
		
		int i=0; //creamos la variable i
		String texto=""; //creamos la cadena texto para meter el texto a copiar
		char caracter[]; //creamos el array para meter los caracteres
	
		//hacemos lectura del fichero a copiar
		FileReader fichero = new FileReader(f1);
		
		while((i=fichero.read())!=-1) {
			texto= texto+(char)i;
		}
		fichero.close();
		
		//hacemos escritura en el segundo fichero
		FileWriter escribir = new FileWriter(f2);
	
		caracter = texto.toCharArray();
		
		for(int y=0;y<caracter.length;y++) {
			escribir.write(caracter[y]);
		}
		escribir.close();
	
	}
}