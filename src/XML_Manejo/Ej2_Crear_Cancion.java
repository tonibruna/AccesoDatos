package XML_Manejo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.lang.model.element.Element;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;

public class Ej2_Crear_Cancion {

	public static void main(String[] args) throws IOException{
		
		  File fichero = new File ("C:\\Users\\ifc\\eclipse-workspace"
		  +"\\\\AD_01_Ficheros\\\\src\\\\P04_FicherosBytes\\\\Canciones.dat");
	 	  RandomAccessFile file = new RandomAccessFile(fichero,"r");
		   
		   int  id, anyo, posicion=0; //para situarnos al principio del fichero        
		   String titulo,artista;
		   boolean cancion_españa;
		   char aux;
		   char[] titulos = new char[10];
		   char[] artistas = new char[10];
		     
		   // Instancia para construir el parser
		   DocumentBuilderFactory factory =
		                  DocumentBuilderFactory.newInstance();
		  
		   try {
			   
		     DocumentBuilder builder = factory.newDocumentBuilder();
		     DOMImplementation implementation = builder.getDOMImplementation();
		     Document document = 
		          implementation.createDocument(null, "Canciones", null);
		     document.setXmlVersion("1.0"); 
		   
		     for(;;) {
		    	 
				 file.seek(posicion);
				 id=file.readInt();   // obtengo id de empleado	  	  
			       for (int i = 0; i < apellido.length; i++) {
			         aux = file.readChar();
			         apellido[i] = aux;    
			       }   
			       String apellidos = new String(apellido);
			       dep = file.readInt();
			  	   salario = file.readDouble();  
				   
				 if(id>0) {
				   
					 Element raiz = 
			                   document.createElement("cancion");//nodo empleado
			         document.getDocumentElement().appendChild(raiz); 
			        
			         // ID                       
			         CrearElemento("id",Integer.toString(id), raiz, document); 
			         // Año
			         CrearElemento("anyo",Integer.toString(id), raiz, document); 
			         // Titulo
			         CrearElemento("titulos",titulos.trim(), raiz, document); 
			         // Artista
			         CrearElemento("artista",, raiz,document); 
			         //Cancion Española
			         CrearElemento("cancion_española",titulos.trim(), raiz, 
			        		                                        document); 
				 }	
				 
				 posicion= posicion+49; // me posiciono para el sig empleado	  	  
				 
				 if (file.getFilePointer() == file.length()) break; 

		     }
				
		     Source source = new DOMSource(document);
		     Result result = 
		            new StreamResult(new java.io.File("Empleados.xml"));        
		     Transformer transformer =
		            TransformerFactory.newInstance().newTransformer();
		     transformer.transform(source, result); // se transforma el documento al fichero
		    
		    // MOSTRAR EL DOCUMENTO POR CONSOLA
		    // Result console = new StreamResult(System.out);
		    // transformer.transform(source, console);	   
			   
		    }catch(Exception e){ System.err.println("Error: "+ e); }
		    
		    file.close();  //cerrar fichero 	
		 }//fin de main
	}

