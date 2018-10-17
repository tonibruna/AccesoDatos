package P04_FicherosBytes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Escritura_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		
		File f1 = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P04_FicherosBytes\\aleatorio.dat");
		f1.createNewFile();
		
		RandomAccessFile raf = new RandomAccessFile(f1,"rw"); //en el modo rw, si no existe fichero, lo crea.
		
		String[] apellido = new String[10];
		apellido[0]="Martinez";
		apellido[1]="Gil";
		apellido[2]="Bueno";
		apellido[3]="Aznar";
		apellido[4]="Gomez";
		apellido[5]="Bruna";
		apellido[6]="Gracia";
		apellido[7]="Moreno";
		apellido[8]="Ruiz";
		apellido[9]="Casado";
		
		int[] departamento = new int[10];
		departamento[0]=1;
		departamento[1]=2;
		departamento[2]=3;
		departamento[3]=4;
		departamento[4]=5;
		departamento[5]=6;
		departamento[6]=7;
		departamento[7]=8;
		departamento[8]=9;
		departamento[9]=10;
		
		double[] salario = new double[10];
		salario[0]=2000.8;
		salario[1]=1958.7;
		salario[2]=1878.5;
		salario[3]=2045.8;
		salario[4]=1947.7;
		salario[5]=1879.5;
		salario[6]=2124.8;
		salario[7]=1412.7;
		salario[8]=1478.5;
		salario[9]=2089.8;
		
		StringBuffer sbuf = null;
		
		for (int i=0;i<10;i++) {
			
			raf.writeInt(i+1);//con esto conseguimos el numero empleado (id)
			
			sbuf = new StringBuffer(apellido[i]);//almacenamos en este buffer todos los apellidos
			sbuf.setLength(10);//con esto le decimos que reservamos un espacio de 10 para apellidos, no mas
			raf.writeChars(sbuf.toString());//esta cadena lo pasa a caracteres
			
			raf.writeInt(departamento[i]);
			raf.writeDouble(salario[i]);
			
		}
			
	}

}
