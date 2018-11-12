package P06_JAXB;

import javax.xml.bind.annotation.XmlType; 

@XmlType(propOrder = {"id", "anyo", "titulo", "artista", "cancion_españa"}) 

public class Ej1_Cancion_JABX {

	   private int id;
	   private int anyo;
	   private String titulo;
	   private String artista;
	   private Boolean cancion_españa;
	    
	 public Ej1_Cancion_JABX(int id, int anyo, String titulo, String artista, Boolean cancion_españa) {
		 
			id=this.id;
			anyo=this.anyo;
			titulo=this.titulo;
			artista=this.artista;
			cancion_españa=this.cancion_españa;
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
	}

