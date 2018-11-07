package Ejercicio_Menu_Musical;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ListaReproduccion {
	
	private int id, anyo;
	private String titulo, artista;
	private boolean cancion_españa;
	
	public ListaReproduccion(int i, int a, String ti, String ar, Boolean ce) {
		
		id=i;
		anyo=a;
		titulo=ti;
		artista=ar;
		cancion_españa=ce;
	}
	
	public ListaReproduccion() {
		// Creamos un constructor vacio para que nos deje inicializar la Lista de reproduccion 
	}

	public int getId() {
		return id;
		 
	}
	
	public int getAnyo() {
		return anyo;
	
	}
	
	public String getTitulo() {
		return titulo;
		
	}
	
	public String getArtista() {
		return artista;
		
	}
	
	public boolean getCancionEspañola() {
		return cancion_españa;
		
	}
	
	//setters
	
	public void setId (int i) {
	
			this.id=i;
    }

	public void setAnyo (int a) {
			 
			this.anyo=a;
	}
	
	public void setTitulo (String ti) {
		
			this.titulo=ti;
	}
	
	public void setArtista (String ar) {
		
		this.artista=ar;
	}
	
	public void setCancionEspañola (boolean ce) {
		
		this.cancion_españa=ce;
	
	}
	
	public boolean comprobarId (int existe_id) throws IOException{
		File f1 = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros"
				+ "\\src\\Ejerc_Lista_Reproduccion\\listaReproduccion.dat");
		RandomAccessFile raf = new RandomAccessFile(f1,"r");
		int posicion=0,id;
		
		try {
			do{
				raf.seek(posicion); 
				id=raf.readInt();
				
				posicion += 49;//esta es la posicion
				/*2 int = 8 bytes
				 *2 string = 2b x 10 x 2 = 40 bytes
				  1 boolean = 1 bytes*/
				
				if(existe_id==id) {
					return true;
				}

				}while(raf.getFilePointer()!=raf.length());
			raf.close();
		}
		catch(EOFException e) {
			System.out.println("");
		}
		return false;
	}
}