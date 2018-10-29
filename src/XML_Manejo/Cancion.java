package XML_Manejo;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class Cancion implements Serializable { 
	private int id, anyo;//4+4bytes
	private String titulo, artista;//20+20bytes
	private Boolean cancion_espa�a;//1byte
	//Total = 49bytes
	
	public Cancion(int i, int a, String ti, String ar, Boolean ce) {
		
		id=i;
		anyo=a;
		titulo=ti;
		artista=ar;
		cancion_espa�a=ce;
	}
	
	public Cancion() {
		id=0;
		anyo=0;
		artista="";
		titulo="";
		cancion_espa�a=false;
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
	
	public boolean getCancionEspa�ola() {
		return cancion_espa�a;
		
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
	
	public void setCancionEspa�ola (boolean ce) {
		
		this.cancion_espa�a=ce;
	
	}
	/**
	 * Comprobar la existencia del Id de una cancion
	 * @param existe_id
	 * @return boolean 
	 * @throws IOException
	 */
	public boolean comprobarId (int existe_id) throws IOException{
		File f1 = new File ("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros"
				+ "\\src\\P04_FicherosBytes\\listaReproduccion.dat");
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
