package P03_LecturaEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Provincias {

	public static void main(String[] args) throws IOException {
		
		//Metemos un array de provincias para escribirlo en el fichero provincias
		
		File f3=new File("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\ficheros\\provincias.txt");
		
		FileWriter fichero_escritura = new FileWriter(f3);
		
		String provincias[] = new String [10];
		
		provincias[0]="Zaragoza";
		provincias[1]="Teruel";
		provincias[2]="Huesca";
		provincias[3]="Logro�o";
		provincias[4]="Pamplona";
		provincias[5]="Madrid";
		provincias[6]="Salamanca";
		provincias[7]="Soria";
		provincias[8]="Valladolid";
		provincias[9]="Burgos";
		
		for(int i=0;i<provincias.length;i++) {
			fichero_escritura.write(provincias[i]+"\r\n");//ponemos salto de lineas para que salga un listado
		}
		
		fichero_escritura.close();
		
		

	}

}
