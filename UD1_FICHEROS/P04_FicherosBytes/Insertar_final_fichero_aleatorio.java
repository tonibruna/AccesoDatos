/*Clase que inserta datos al final del fichero aleatorio*/

package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Insertar_final_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		
		File f2 = new File ("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\P04_FicherosBytes\\aleatorio.dat");
		
		RandomAccessFile raf = new RandomAccessFile(f2,"rw");
		
		int id = 11;
		String apellidos = "Perez";
		int departamento = 11;
		double salario = 3500;
		
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
