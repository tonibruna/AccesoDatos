/*Creamos una lista de tipo canción, para introducir ahí todas las canciones
 * del fichero Canciones.dat*/

package XML_Manejo;

import java.util.ArrayList;
import java.util.List;

public class Ej2_Lista_Canciones {
		
	    private List<Cancion> lista = new ArrayList<Cancion>();
	    
	    public Ej2_Lista_Canciones() {    	
	    }

	    public void add(Cancion ca) {
	            lista.add(ca);
	    }
	   
	   public List<Cancion> getListaCanciones() {
	            return lista;
	    }
	}

