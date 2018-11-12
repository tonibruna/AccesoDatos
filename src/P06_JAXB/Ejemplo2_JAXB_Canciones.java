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
				
	}

}
