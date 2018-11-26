package P07_Mapear_XML_Clase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Ejercicio_Menu_Musical.ListaReproduccion;
import P07_Mapear_XML_Clase.*;
import P07_Mapear_XML_Clase.ListaReproduccion.cancion;

public class Principal_ListaRep {
	
	public static void main(String[] args) {

		visualizarxml();

	}
	
	public static void visualizarxml()throws IOException, JAXBException {

		System.out.println("------------------------------ ");
		System.out.println("-------VISUALIZAR XML--------- ");
		System.out.println("------------------------------ ");

		try {
			// JAXBContext jaxbContext = JAXBContext.newInstance("datosclases");
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			
			// Crear un objeto de tipo Unmarshaller para convertir datos XML en
			// un arbol de objetos Java
			Unmarshaller u = jaxbContext.createUnmarshaller();

			// La clase JAXBElement representa a un elemento de un documento XML
			// en este caso a un elemento del documento ventasarticulos.xml
			ListaReproduccion milista = (ListaReproduccion) u.unmarshal(new FileInputStream
					("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P07_Mapear_XML_Clase\\listareproduccion.xml"));

			// Visualizo el documento
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(milista, System.out);
			
			// Si queremos operar con el documento obtenemos los
			// objetos del jaxbElement
			// El método getValue() retorna el modelo de contenido (content
			// model) y el valor de los atributos del elemento

			// Guardamos las ventas en la lista
			List listaCancion = new ArrayList();
			listaCancion = milista.getcancion();

			System.out.println("---------------------------- ");
			System.out.println("---VISUALIZAR LOS OBJETOS--- ");
			System.out.println("---------------------------- ");
			

			for (int i = 0; i < listaCancion.size(); i++) {
				ListaReproduccion.cancion lis = (cancion) listaCancion.get(i);
				System.out.println("Identificacion cancion: " + lis.getId() + ". Año: " + lis.getAnyo()
						+ ", Titulo: " + lis.getTitulo() + ", artista: " + lis.getArtista()+ ". ¿Canción española?: " + lis.CancionEspañola());
			}

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}
}
