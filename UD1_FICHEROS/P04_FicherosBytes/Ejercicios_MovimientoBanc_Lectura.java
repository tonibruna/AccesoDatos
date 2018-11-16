package P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicios_MovimientoBanc_Lectura {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File f = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P04_FicherosBytes\\mov_bancario.dat");

		FileInputStream filein = new FileInputStream(f);
		ObjectInputStream objectin = new ObjectInputStream(filein);
		
		MovimientoBancario mo;
		
		int cantidad_total = 0;
		
		try {
			while(true)//bucle infinito hasta que salte la excepcion de que no lea mas lineas
				       {
							mo=(MovimientoBancario)objectin.readObject();
							System.out.println("Fecha: "+mo.getFecha()+", Concepto: "+mo.getConcepto()+", Cantidad: "+mo.getCantidad()+", Tipo: " + mo.getTipo());
			           
							if(mo.getTipo()) //si el boolean es true, hara esto
								cantidad_total += mo.getCantidad();
							else //si el boolean es false, esto
								cantidad_total -= mo.getCantidad();
				       
				       }
		
	}catch (EOFException eo) {
		System.out.println("");
	}
	objectin.close();
	
	System.out.println("La cantidad total es: "+cantidad_total);

	}

}
