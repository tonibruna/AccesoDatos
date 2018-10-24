package Ejercicio_Menu_Musical;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ListaReproduccionMain {

	public static void main(String[] args) throws IOException{
		
		System.out.println(" _____________________________");
		System.out.println("| LISTA DE REPRODUCCION       |");
		System.out.println("|-----------------------------|");
		System.out.println("| 1.Crear fichero             |");
		System.out.println("| 2.Consultar datos           |");
		System.out.println("| 3.Insertar datos            |");
		System.out.println("| 4.Modificar año cancion     |");
		System.out.println("| 5.Borrar cancion            |");
		System.out.println("| 6.Mostrar canciones borradas|");
		System.out.println("| 7.Mostrar listado canciones |");
		System.out.println("| 8.Salir                     |");
		System.out.println("|_____________________________|");
		
		
		
	 	Scanner teclado= new Scanner(System.in);
	 	 
	 	int opcion= teclado.nextInt();
	 	File f1 = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P04_FicherosBytes\\listaReproduccion.dat");
	 	RandomAccessFile raf = new RandomAccessFile(f1,"rw");
 		StringBuffer sbuf = null;
	 	ListaReproduccion li = new ListaReproduccion ();
	 	
	 	int id,anyo;//4+4 bytes
	 	String titulo,artista;//20+20 bytes
	 	Boolean cancion_españa;//1 byte
	 	
	 	char[] titulos = new char[10];
	 	char[] artistas = new char[10];
	 	char aux;
	 	long posicion=0;
	 	
	 	
	 	switch (opcion) { //para seleccionar solo uno de los casos
	
	 	case 1:
	 		System.out.println("Generamos un nuevo fichero de datos");
			f1.createNewFile();
	 	
	 		break; 
	  	
	 	case 2:
	 		System.out.println("Consulta de datos, mete el numero de Id que quieras consultar");
	 		id=teclado.nextInt();
	 		
	 		if(li.comprobarId(id)) {
	 			System.out.println(
	 		 		"Id: "+li.getId()+", Año: "+li.getAnyo()+", Titulo: "+li.getTitulo()+", Artista: "+li.getArtista()+", Cancion española: "+li.getCancionEspañola());
	 		}else {
	 			System.out.println("El Id no existe");
	 		}
	 		break;
	 		
	 	case 3:
	 		System.out.println("Introduce un id desde tu teclado");
	 		id=teclado.nextInt();
	 		
	 		if(!li.comprobarId(id)) {//el simbolo ! sirve de negacion, en este caso si comprobarId es igual a False
		 		System.out.println("Insertamos datos de canciones");
		 		System.out.println("Inserta el Id");
		 		id=teclado.nextInt();
		 		System.out.println("Inserta el Año");
		 		anyo=teclado.nextInt();
		 		System.out.println("Inserta el Titulo");
		 		titulo=teclado.nextLine();
		 		titulo=teclado.nextLine();
		 		System.out.println("Inserta el Artista");
		 		artista=teclado.nextLine();
		 		System.out.println("Inserta si es cancion española(true)");
		 		cancion_españa=teclado.nextBoolean();
		 				
		 		posicion= raf.length();//con estas dos lineas hacemos que las canciones no se sobreescriban
				raf.seek(posicion);//el puntero posicion marca la posicion a escribir a partir de los bytes que ocupa
				
		 		raf.writeInt(id);
		 		raf.writeInt(anyo);
		 		
		 		sbuf = new StringBuffer(titulo);
				sbuf.setLength(10);
				raf.writeChars(sbuf.toString());
				sbuf = new StringBuffer(artista);
				sbuf.setLength(10);
				raf.writeChars(sbuf.toString());
				raf.writeBoolean(cancion_españa);
				System.out.println("Se ha creado la cancion");
				
	 		}else
	 			System.out.println("El Id de esta cancion ya esta introducido");
	 		 break;
	 		 
	 	case 4:
	 		System.out.println("Modificamos el año de cancion");
	 		
	 		break;
	 		
	 	case 5:
	 		System.out.println("Borra cancion que desees");
	 		 
	 		break;
	 		
	 	case 6:
	 		System.out.println("Te mostramos las canciones borradas");
	 		
	 		break;
	 		
	 	case 7:
	 		System.out.println("Listado de canciones");
	 		
			try {
				posicion=0;
				do{
					
					raf.seek(posicion); //para que fije la posicion de byte donde quieres leer (en este caso en 0).
					id=raf.readInt();//guardo en id el primer entero que aparece
					anyo = raf.readInt();
					
					for (int i=0; i<titulos.length;i++) {
						aux=raf.readChar();
						titulos[i]=aux;
					}
					titulo= new String(titulos);
					
					for (int i=0; i<artistas.length;i++) {
						aux=raf.readChar();
						artistas[i]=aux;
					}
					artista= new String(artistas);
					cancion_españa= raf.readBoolean();
					
					System.out.println("Id: "+id+" Titulo: "+titulo+" Artista: "+artista+" Año: "+anyo);
					
					posicion+=49;
					
					}while(raf.getFilePointer()!=raf.length());  //el primer metodo es para saber la posicion donde esta el puntero
																 //el segundo me dice el total de bytes de la informacion  
						
					
				raf.close();
			}
			catch(EOFException e) {
				System.out.println("Fin de fichero");
			}
	 		
	 		break;
	 		
	 	case 8:
	 		System.out.println("Good bye my friend");
	 		
	 		break;
	 		
	 		default:System.out.println("Has metido una opcion incorrecta"); ; break;
	 		
	 	}
	 	teclado.close();
	}

}
