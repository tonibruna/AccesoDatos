package XML_Manejo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.thoughtworks.xstream.XStream;

public class Ej2_Leer_Cancion {

	public static void main(String[] args) throws IOException{
		
		XStream xstream = new XStream();
		
		 xstream.alias("ListaCanciones", Ej2_Lista_Canciones.class);		
		 xstream.alias("DatosCancion", Cancion.class);	
		 xstream.addImplicitCollection(Ej2_Lista_Canciones.class, "lista");
		 
		 //leemos el fichero XML
		 Ej2_Lista_Canciones listadoTodas = (Ej2_Lista_Canciones) 
		         xstream.fromXML(new FileInputStream("C:\\Users\\ifc\\"
		         	+ "eclipse-workspace\\AD_01_Ficheros\\src\\XML_Manejo\\Canciones_xs.xml"));			
		    System.out.println("Numero de Canciones: " + 
		         listadoTodas.getListaCanciones().size());
		    
		    //Creamos lista y metemos dentro las canciones
		    List<Cancion> listaCanciones = new ArrayList<Cancion>();
			listaCanciones = listadoTodas.getListaCanciones();
			
			//Iterador como hacer un for mas efectivo
			Iterator<Cancion> iterador = listaCanciones.listIterator(); 
			 
			//Para recorrer y mostrar la lista de canciones
			 while( iterador.hasNext() ) {
				    Cancion ca = (Cancion) iterador.next(); 
				    System.out.printf("Titulo: %s, Artista: %d %n", 
			                          ca.getTitulo(), ca.getArtista()); 
			    }    
			    System.out.println("Fin de listado .....");
			    
	   } //fin main
  }//fin Ej2_Leer_Cancion