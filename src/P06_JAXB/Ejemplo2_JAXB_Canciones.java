// MAPEAR clase Java a XML

/*Genera un documento XML que contenga una lista de reproducción. 
Dentro de esa lista deben aparecer diferentes canciones. 
(Mapear la clase lista de reproducción a un fichero XML)*/

package P06_JAXB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Ejemplo2_JAXB_Canciones {
	
	//metemos la ruta final donde se escribira el archivo XML
	//Ruta del pc de clase
	
	private static final String ruta_xml = 
			"C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P06_JAXB"
			+ "\\canciones_jabx.xml";
	

	public static void main(String[] args) throws JAXBException, FileNotFoundException{
	
                //Se crea la lista de canciones
				ArrayList<Ej1_Cancion_JABX> lista = new ArrayList<Ej1_Cancion_JABX>();
				
				//Creamos dos canciones y las añadimos
				Ej1_Cancion_JABX c1 = new Ej1_Cancion_JABX(1, 2010, "Arenas movedizas",
						"Sabina", false);
				lista.add(c1);
				
				Ej1_Cancion_JABX c2 = new Ej1_Cancion_JABX(2, 2014, "Pajaros de Portugal",
						"Sabina", false);
				lista.add(c2);
				
				//se crea la lista de canciones y se le asigna la lista
				Ej1_Lista_Canciones listaCanciones = new Ej1_Lista_Canciones();
				listaCanciones.setListaCanciones(lista);
				
				//Creamos el contexto indicando la clase raiz
				JAXBContext context = JAXBContext.newInstance(Ej1_Lista_Canciones.class);
				
				//Creamos el Marshaller, convierte el java bean en una cadena XML
		        Marshaller m = context.createMarshaller();
		        
		        //Formateamos el xml para que quede bien
		        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		        
		        //Lo visualizamos con system out
		        m.marshal(listaCanciones, System.out);
		        
		        //Escribimos en el archivo
		        m.marshal(listaCanciones, new File(ruta_xml));
		        
		        // Visualizamos ahora los datos del documento XML creado
		        System.out.println("------------ Leo el XML ---------");
		        
		        //Se crea Unmarshaller en el cotexto de la clase Libreria
		        Unmarshaller unmars = context.createUnmarshaller();
		        
		        //Utilizamos el método unmarshal, para obtener datos de un Reader
		        Ej1_Lista_Canciones lista2 = (Ej1_Lista_Canciones) unmars.unmarshal(
		        		new FileReader(ruta_xml));
				
	}

}