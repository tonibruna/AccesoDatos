//Convertimos un fichero XML en HTML a traves de una plantilla XSL.

package XML_Manejo;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Ej3_Convertidor_XML_HTML {
 public static void main(String argv[]) throws IOException{ 
  String hojaEstilo = "C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros"
  		+ "\\src\\XML_Manejo\\cancionesPlantilla.xsl";
  
  String datosCanciones = "C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros"
  		+ "\\src\\XML_Manejo\\Canciones.xml";
  
  File pagHTML = new File("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros"
  		+ "\\src\\XML_Manejo\\Canciones.html");
  
  FileOutputStream os = new FileOutputStream(pagHTML); //crear fichero HTML
  
  Source estilos =new StreamSource(hojaEstilo); //fuente XSL
  Source datos =new StreamSource(datosCanciones); //fuente XML
  Result result = new StreamResult(os);         //resultado de la transformaci�n
  
  try{     
   Transformer transformer =  
               TransformerFactory.newInstance().newTransformer(estilos);   
   transformer.transform(datos, result);	//obtiene el HTML
  }
  catch(Exception e){System.err.println("Error: "+e);}
  
  os.close();  //cerrar fichero 	
 }
}