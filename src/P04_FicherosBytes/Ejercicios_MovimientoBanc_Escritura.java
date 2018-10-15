package P04_FicherosBytes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicios_MovimientoBanc_Escritura {

	public static void main(String[] args) throws IOException{
		
		File f = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P04_FicherosBytes\\mov_bancario.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		MovimientoBancario mo;
		
		Scanner teclado = new Scanner (System.in);
		
		String fecha;
		String concepto;
		int cantidad;
		boolean tipo;
		String opcion = "Si";
		
		
		while(opcion.equals("Si") || opcion.equals("si")) {
			System.out.println("Introduce la fecha del movimiento");
			fecha=teclado.nextLine();
			System.out.println("Introduce el concepto");
			concepto=teclado.nextLine();
			System.out.println("Introduce cantidad");
			cantidad=teclado.nextInt();
			System.out.println("Introduce tipo");//boolean
			tipo=teclado.nextBoolean();
			teclado.nextLine();
		
				mo = new MovimientoBancario (fecha, concepto, cantidad, tipo);
				
				objectout.writeObject(mo);
				
		      System.out.println("Quieres seguir haciendo movimientos?(Si/No)");
				
		      opcion = teclado.nextLine();
				
			}
			teclado.close();
			objectout.close();
			
		
		}

	}

