package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Insertar_final_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		
		File f2 = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P04_FicherosBytes\\aleatorio.dat");
		
		RandomAccessFile raf = new RandomAccessFile(f2,"rw");
		
		int id = 11;
		String apellidos = "Perez";
		int departamento = 11;
		double salario = 3500;
		
		long posicion= raf.length();
		raf.seek(posicion);
		
		StringBuffer sbuf = null;
		
		raf.writeInt(id);//con esto conseguimos el numero empleado (id)
		
		sbuf = new StringBuffer(apellidos);
		sbuf.setLength(10);
		raf.writeChars(sbuf.toString());
		
		raf.writeInt(departamento);
		raf.writeDouble(salario);
		
		
		raf.close();
		
	}

}
