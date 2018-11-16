package P03_LecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LeerLinea {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Con esto leemos una linea completa, en vez de caracter por caracter

		File f4=new File("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\ficheros\\LeerLinea.txt");
		
		FileReader fichero = new FileReader (f4);
		
		BufferedReader br= new BufferedReader(fichero);
		
		String tmp;
		
		while ((tmp=br.readLine())!=null) {
			System.out.println(tmp);
		}
		
		br.close();
	}

}
