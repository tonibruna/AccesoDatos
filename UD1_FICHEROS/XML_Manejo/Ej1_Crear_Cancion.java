/*Clase que crea un documento XML partiendo del fichero Canciones.dat,
 * que contiene información sobre 5 objetos Cancion. 
 * Después mostrar el contenido del documento por consola.*/

package XML_Manejo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ej1_Crear_Cancion {

	public static void main(String[] args) throws IOException{
		
		 //Creamos variable de fichero y flujo de lectura de objetos
		
		  File f = new File ("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\XML_Manejo\\Canciones.dat");
	 	  
		  FileInputStream fileIn = new FileInputStream(f);
		  ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		  
		 //Creamos variable
		  
		  Cancion cancion = new Cancion();
		   
		 // Instancia para construir el parser
		   
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		  
		 try {
		
			//Para construir el documento XML
			 
		   DocumentBuilder builder = factory.newDocumentBuilder();
		     
		   DOMImplementation implementation = builder.getDOMImplementation();
		   
		   Document document = 
				   implementation.createDocument(null, "Canciones", null);
		         document.setXmlVersion("1.0"); 
		   
		     for(int i=0;i<5;i++) {
		    	 
		    	 	 //leemos objeto cancion
				     cancion = (Cancion) objectIn.readObject();
		    	 
				     //creamos nodo raiz 
					 Element raiz = document.createElement("Cancion");
					 //a�adimos nodo principal
			         document.getDocumentElement().appendChild(raiz); 
			        
			         //Creacion de elementos
			         // ID                       
			         CrearElemento("id",Integer.toString(cancion.getId()), raiz, document); 
			         // A�o
			         CrearElemento("anyo",Integer.toString(cancion.getAnyo()), raiz, document); 
			         // Titulo
			         CrearElemento("titulos",cancion.getTitulo(), raiz, document); 
			         // Artista
			         CrearElemento("artista",cancion.getArtista(), raiz,document); 
			         //Cancion Espa�ola
			         CrearElemento("cancion_espanola",Boolean.toString(cancion.getCancionEspañola()), 
			        		 raiz, document); 
				 }	
				
		     Source source = new DOMSource(document);
		     
		     Result result = 
		            new StreamResult(new java.io.File("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\XML_Manejo\\Canciones.xml"));  
		     
		     Transformer transformer =
		            TransformerFactory.newInstance().newTransformer();
		     
		     //se trasforma el documento al fichero
		     transformer.transform(source, result);

		    
		    // MOSTRAR EL DOCUMENTO POR CONSOLA
		    Result console = new StreamResult(System.out);
		    transformer.transform(source, console);	   
			   
		    }catch(Exception e)
		 { 
		    	System.out.println("Ha habido un error: " + e); 
		 }
		    
		 objectIn.close(); 
		 
 } //fin de main

//Insercion de los datos del empleado
	/**
	 * Metodo que crea un elemento para escribirlo en documento xml
	 * @param datoCancion Elemento de la canci�n
	 * @param valor Valor que se va a dar al elemento
	 * @param raiz Elemento raiz
	 * @param document Documento donde se van a a�adir estos elementos
	 */
static void  CrearElemento(String datoCancion, String valor,
                           Element raiz, Document document)
{
   Element elem = document.createElement(datoCancion); 
   Text text = document.createTextNode(valor); //damos valor
   raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
   elem.appendChild(text); //pegamos el valor al elemento hijo	 	
 }

}//fin de la clase
