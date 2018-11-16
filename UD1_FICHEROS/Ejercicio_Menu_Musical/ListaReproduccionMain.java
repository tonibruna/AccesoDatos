package Ejercicio_Menu_Musical;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ListaReproduccionMain {

	public static void main(String[] args) throws IOException{
		
		int numero=0;
		
		Scanner teclado= new Scanner(System.in);
		
		do {
				System.out.println(" _____________________________");
				System.out.println("| LISTA DE REPRODUCCION       |");
				System.out.println("|-----------------------------|");
				System.out.println("| 1.Crear fichero             |");
				System.out.println("| 2.Consultar datos           |");
				System.out.println("| 3.Insertar datos            |");
				System.out.println("| 4.Modificar a�o cancion     |");
				System.out.println("| 5.Borrar cancion            |");
				System.out.println("| 6.Mostrar canciones borradas|");
				System.out.println("| 7.Mostrar listado canciones |");
				System.out.println("| 8.Salir                     |");
				System.out.println("|_____________________________|");
			
				numero = teclado.nextInt();
				File f1 = new File ("C:\\Users\\ifc\\eclipse-workspace\\"
			    + "AD_01_Ficheros\\src\\Ejerc_Lista_Reproduccion\\listaReproduccion.dat");
			 	RandomAccessFile raf = new RandomAccessFile(f1,"rw");
		 		StringBuffer sbuf = null;

		 		ListaReproduccion li = new ListaReproduccion ();
	 	
			 	int id,anyo;//4+4 bytes
			 	String titulo,artista;//20+20 bytes
			 	boolean cancion_españa;//1 byte
			 	int anyo_anterior; //para modificar a�o cancion
			 	char[] titulos = new char[10];
			 	char[] artistas = new char[10];
			 	char aux;
			 	long posicion=0;
	 	
	 	
			 	switch (numero) { 
	
			 	case 1:
				 		System.out.println("Generamos un nuevo fichero de datos");
						f1.createNewFile();
						System.out.println("Tu fichero ha sido creado");
				 		break; 
	  	
			 	case 2:
			 
			 		do {
				 			System.out.println("Introduce el numero de Id (mayor de 0)que quieras consultar");
				 			id=teclado.nextInt();
				 			
			 		}while(id<=0);
			 		
			 		if(li.comprobarId(id)) {
			 			
				 			posicion=(id-1)*49;
				 			raf.seek(posicion);
				 			id=raf.readInt();
				 			anyo=raf.readInt();
				 			
				 			for(int i=0;i<titulos.length;i++) {
				 					aux=raf.readChar();
				 					titulos[i]=aux;
				 			}
				 			titulo = new String(titulos);
				 			
				 			for(int i=0;i<artistas.length;i++) {
								aux=raf.readChar();
								artistas[i]=aux;
							}					
							artista = new String(artistas);
						
							cancion_españa = raf.readBoolean();
			 			
							System.out.println("Id: "+li.getId()+", A�o: "+li.getAnyo()+", Titulo: "+li.getTitulo()
									+", Artista: "+li.getArtista()+", Cancion espa�ola: "+li.getCancionEspañola());
			 		}else 
			 			
			 				System.out.println("El Id no existe");
			 		
			 		break;
	 		
			 	case 3:
			 		
			 		do {
				 			System.out.println("Introduce un numero de Id para insertar(mayor de 0)");
				 			id=teclado.nextInt();
				 			
			 		}while(id<=0);
	 		
			 		if(!li.comprobarId(id)) {//el simbolo ! sirve de negacion, en este caso si comprobarId es igual a False
					 		System.out.println("Insertamos datos de canciones");
					 		System.out.println("Inserta el A�o");
					 		anyo=teclado.nextInt();
					 		System.out.println("Inserta el Titulo");
					 		titulo=teclado.nextLine();
					 		titulo=teclado.nextLine();
					 		System.out.println("Inserta el Artista");
					 		artista=teclado.nextLine();
					 		System.out.println("Inserta si es cancion espa�ola(true)");
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
			 		
			 		do {
			 				System.out.println("Introduce un id para modificar el a�o de la cancion");
			 				id=teclado.nextInt();
			 				
			 		}while(id<=0);
			 		
			 		if(li.comprobarId(id)) {
			 			
				 			posicion=(id-1)*49+4; //con esto el puntero lo posicionas en el a�o
				 			                      //sumandole los 4 bytes de valor que tiene el id
				 			raf.seek(posicion);
				 			anyo_anterior=raf.readInt();
			 			
				 			System.out.println("Introduce el a�o modificado");
				 			anyo=teclado.nextInt();
				 			
				 			raf.seek(posicion);
				 			
				 			raf.writeInt(anyo);
				 			
				 			for(int i=0;i<titulos.length;i++) {
			 					aux=raf.readChar();
			 					titulos[i]=aux;
				 			}
				 			titulo = new String(titulos);
			 			
				 			System.out.println("Id: "+id+" A�o anterior: "+anyo_anterior+
				 					" A�o nuevo: "+anyo+" Titulo: "+titulo);
			 		}else 
			 				
			 				System.out.println("No existe cancion con este Id");
			 		
			 		break;
	 		
			 	case 5:
			 			do {
			 				
			 					System.out.println("Introduce un id para borrar la cancion");
			 					id=teclado.nextInt();
			 			
			 			}while(id<=0);
			 			
			 		if(li.comprobarId(id)) {
				 			
				 			posicion=(id-1)*49;
				 			
				 			raf.seek(posicion);

				 			raf.writeInt(-1);
				 			System.out.println("Se ha borrado la cancion elegida");
			 		}else 
			 				System.out.println("No hay cancion con este Id");
			 			
	 		
			 		break;
	 		
			 	case 6:
			 		
			 		try {
			 			
			 				posicion=0;
			 				System.out.println("CANCIONES BORRADAS:");
			 				do {
			 					
			 						raf.seek(posicion);
			 						id=raf.readInt();
			 						
			 						if(id==1) {
			 							
			 								anyo=raf.readInt();
			 								
			 								for(int i=0;i<titulos.length;i++) {
			 									aux=raf.readChar();
			 									titulos[i]=aux;
			 								}					
			 								titulo = new String(titulos);
			 								
			 								for(int i=0;i<artistas.length;i++) {
			 									aux=raf.readChar();
			 									artistas[i]=aux;
			 								}					
			 								artista = new String(artistas);
			 								
			 								cancion_españa = raf.readBoolean();
			 								
			 								System.out.println("Id: "+id+" A�o: "+anyo+" Titulo: "+titulo+" Artista: "+artista+" �Canci�n espa�ola?: "+cancion_españa);
			 						}			
			 						
			 							posicion += 49;
			 							
			 				}while(raf.getFilePointer()!=raf.length());
			 				/*.getFilePointer nos dice hacia donde est� apuntando el puntero
							.length dice el total de bytes que ocupa la informacion escrita en el fichero*/
			 			
			 		}catch (EOFException e) {			
						System.out.println("No hay ninguna canci�n borrada");
					}
			 		
			 		break;
	 		
	 	
			 	case 7:
	 		                   System.out.println("LISTADO DE CANCIONES:");
	 		
			
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
											
											System.out.println("Id: "+id+" Titulo: "+titulo+" Artista: "+artista+" A�o: "+anyo);
											
											posicion+=49;
					
	 		                	   		}while(raf.getFilePointer()!=raf.length());  //el primer metodo es para saber la posicion donde esta el puntero
																 					//el segundo me dice el total de bytes de la informacion  
						
					
	 		                	   		raf.close();
	 		                   }catch(EOFException e) {
	 		                   							System.out.println("Fin de fichero");
	 		                   }
	 		
	 		              break;
	 		
			 	case 8:
			 				System.out.println("Has salido del MENU. Good bye my friend");
	 		
			 				break;
	 		
			 	default:
			 		
			 		System.out.println("Has elegido una opcion incorrecta, prueba con un numero del 1 al 8.");
	 		
	 	}
	 	
		}while(numero!=8);	
	 	teclado.close();
	}


}
