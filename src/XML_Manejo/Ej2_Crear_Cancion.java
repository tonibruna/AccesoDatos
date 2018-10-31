package XML_Manejo;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Ej2_Crear_Cancion {

	public static void main(String[] args) throws IOException{
		
		 //Creamos variable de fichero y flujo de lectura de objetos
		
		  File f = new File ("C:\\Users\\ifc\\eclipse-workspace"
		  		+ "\\AD_01_Ficheros\\src\\P04_FicherosBytes\\Canciones.dat");
	 	  
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
					 Element raiz = document.createElement("cancion");
					 //añadimos nodo principal
			         document.getDocumentElement().appendChild(raiz); 
			        
			         //Creacion de elementos
			         // ID                       
			         CrearElemento("id",Integer.toString(cancion.getId()), raiz, document); 
			         // Año
			         CrearElemento("anyo",Integer.toString(cancion.getAnyo()), raiz, document); 
			         // Titulo
			         CrearElemento("titulos",cancion.getTitulo(), raiz, document); 
			         // Artista
			         CrearElemento("artista",cancion.getArtista(), raiz,document); 
			         //Cancion Española
			         CrearElemento("cancion_española",Boolean.toString(cancion.getCancionEspañola()), 
			        		 raiz, document); 
				 }	
				
		     Source source = new DOMSource(document);
		     
		     Result result = 
		            new StreamResult(new java.io.File("C:\\Users\\ifc\\eclipse-workspace"
		          		  +"\\AD_01_Ficheros\\src\\P04_FicherosBytes\\Canciones.dat"));  
		     
		     Transformer transformer =
		            TransformerFactory.newInstance().newTransformer();
		     
		     //se trasforma el documento al fichero
		     transformer.transform(source, result);

		    
		    // MOSTRAR EL DOCUMENTO POR CONSOLA
		    Result console = new StreamResult(System.out);
		    transformer.transform(source, console);	   
			   
		    }catch(Exception e){ System.err.println("Error: "+ e); }
		    
		 objectIn.close(); 
		 
 } //fin de main

//Insercion de los datos del empleado
	/**
	 * Metodo que crea un elemento para escribirlo en documento xml
	 * @param datoCancion Elemento de la canción
	 * @param valor Valor que se va a dar al elemento
	 * @param raiz Elemento raiz
	 * @param document Documento donde se van a añadir estos elementos
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

