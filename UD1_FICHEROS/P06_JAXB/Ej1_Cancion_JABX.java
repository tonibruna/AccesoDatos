package P06_JAXB;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType; 

/*anotacion para establecer el orden en el que se introducirán 
 los elementos en el mfichero xml*/
@XmlType(propOrder = {"id", "anyo", "titulo", "artista", "cancion_espanya"}) 

public class Ej1_Cancion_JABX implements Serializable{

	   private int id;
	   private int anyo;
	   private String titulo;
	   private String artista;
	   private Boolean cancion_espanya;
	    
	 public Ej1_Cancion_JABX(int i, int a, String ti, String ar, Boolean c_esp) {
		 
			id=i;
			anyo=a;
			titulo=ti;
			artista=ar;
			cancion_espanya=c_esp;
		}
	 
	 public Ej1_Cancion_JABX() { //creamos un constructor vacio
		 
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
			return cancion_espanya;
			
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
			
			this.cancion_espanya=ce;
		
		}
	}

