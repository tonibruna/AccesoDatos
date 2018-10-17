package P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Leer_fichero_aleatorio {

	public static void main(String[] args) throws IOException{
		
		File f2 = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P04_FicherosBytes\\aleatorio.dat");
		
		RandomAccessFile raf = new RandomAccessFile(f2,"r");//acceso a fichero aleatorio
		
		int id;//con esta i, sacabamos en la escritura el id del empleado
		char[] apellido = new char[10];//ponemos la variable de apellido en caracter, para que lea letra a letra en 2bytes
		int departamento;
		double salario;
		char aux;
		String apellidos;
		int posicion=0;//variable para meter la posicion de byte que quieres buscar
		
		try {
			for (;;) {//este for sirve para hacer un bucle infinito
				
				raf.seek(posicion); //para que fije la posicion de byte donde quieres leer (en este caso en 0).
				id=raf.readInt();//guardo en id el primer entero que aparece
				System.out.println(id);
				
				posicion+=36;//para que lea cada 36 bytes el id
				
				for (int i=0; i<apellido.length;i++) {//metemos en un auxiliar los apellidos
					aux=raf.readChar();
					apellido[i]=aux;
				}
				
				apellidos = new String(apellido);
				departamento = raf.readInt();
				salario = raf.readDouble();
				
				System.out.println("Id: "+id+"Apellidos: "+apellidos+"Departamento: "+departamento+"Salario: "+salario);
				
				if(raf.getFilePointer()==raf.length()) {    //el primer metodo es para saber la posicion donde esta el puntero
															//el segundo me dice el total de bytes de la informacion
					break;//rompemos el bucle infinito    
					
				}
				
			}
			raf.close();
		}
		catch(EOFException e) {
			System.out.println("Se ha llegado al final del fichero");
		}

	}

}
