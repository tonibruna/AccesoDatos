package Examen_1Ev_Acceso;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio1_Fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		
		Scanner teclado = new Scanner (System.in);
		
		String ruta;
		double a, b, c, d, e;
		
		//Creamos el fichero 
		System.out.println("Dame la ruta y nombre del fichero: ");
	    ruta=teclado.nextLine();
	    
		File f1 = new File (ruta);
		f1.createNewFile();
		
		RandomAccessFile raf = new RandomAccessFile(f1,"rw");
		
		System.out.println("Dame un numero con decimales: ");
	    a=teclado.nextFloat();
	    System.out.println("Dame un numero con decimales: ");
	    b=teclado.nextFloat();
	    System.out.println("Dame un numero con decimales: ");
	    c=teclado.nextFloat();
	    System.out.println("Dame un numero con decimales: ");
	    d=teclado.nextFloat();
	    System.out.println("Dame un numero con decimales: ");
	    e=teclado.nextFloat();
	    
	    StringBuffer sbuf = null;
	    
	   
	    
	    
		
	    
	    //No me da tiempo a mas ;-(
	    
	}

}
