package XML_Manejo;

import java.util.ArrayList;
import java.util.List;

public class Ej2_Lista_Canciones {
		
	    private List<Cancion> lista = new ArrayList<Cancion>();
	    
	    public Ej2_Lista_Canciones() {    	
	    }

	    public void add(Cancion p) {
	            lista.add(p);
	    }
	   
	   public List<Cancion> getListaCanciones() {
	            return lista;
	    }
	}

