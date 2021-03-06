/*Clase que va a hacer una consulta en un fichero aleatorio.
 * Lo que vamos a hacer es en vez de leer todos los empleados, solo queremos leer uno (consulta)*/

package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Consulta_fichero_aleatoria {//para consultar directamente un determinado empleado

	public static void main(String[] args) throws IOException{
		
		File f2 = new File ("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\P04_FicherosBytes\\aleatorio.dat");
		
		RandomAccessFile raf = new RandomAccessFile(f2,"r");//acceso a fichero aleatorio
		
		char[] apellido = new char[10];
		int departamento;
		double salario;
		char aux;
		String apellidos;
		
		int id=5;
		int posicion=(id-1)*36; 
		
		raf.seek(posicion);
		
		id=raf.readInt(); //hay que leer en el mismo orden en el que escribimos
		
		for (int i=0; i<apellido.length;i++) {//metemos en un auxiliar los apellidos
			aux=raf.readChar();
			apellido[i]=aux;
		}
		
		apellidos = new String(apellido);
		departamento = raf.readInt();
		salario = raf.readDouble();
		
		System.out.println("Id: "+id+" Apellidos: "+apellidos+" Departamento: "+departamento+" Salario: "+salario);
		
		raf.close();
	}

}
