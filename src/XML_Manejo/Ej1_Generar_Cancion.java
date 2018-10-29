package XML_Manejo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import P04_FicherosBytes.Persona;

public class Ej1_Generar_Cancion {

	public static void main(String[] args) throws IOException {
		
		File f = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros"
		+"\\src\\P04_FicherosBytes\\Cancion.dat");
		f.createNewFile();
		
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);

		Cancion canciones[]= new Cancion[5];
		canciones[0] = new Cancion(1,1999,"1999","Loveof",true);
		canciones[1] = new Cancion(2,2017,"Autoterapia","Izal",true);
		canciones[2] = new Cancion(3,2009,"Cophenage","Vetusta",true);
		canciones[3] = new Cancion(4,2002,"Live","Sabina",true);
		canciones[4] = new Cancion(5,2012,"Gran truco ","Loveof",true);
		
		
		for(int i=0; i<canciones.length; i++) {
			objectout.writeObject(canciones[i]);
		}
		
		objectout.close();

	}

}
