/*Para convertir de XML a HTML, primero vamos a tener que crear un fichero xsl.
 * 
 * En este ejercicio vamos a convertir el archivo Canciones.xml a un HTML Canciones.html
 * mediante la plantilla cancionesPlantilla.xsl*/

package XML_Manejo;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Ej3_Convertidor_XML_HTML {
	
 public static void main(String argv[]) throws IOException{ 
	 
  String hojaEstilo = "C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\XML_Manejo\\cancionesPlantilla.xsl";
  
  String datosCanciones = "C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\XML_Manejo\\Canciones.xml";
  
  File pagHTML = new File("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\XML_Manejo\\Canciones.html");
  
  FileOutputStream os = new FileOutputStream(pagHTML); //crear fichero HTML
  
  Source estilos =new StreamSource(hojaEstilo); //fuente XSL
  Source datos =new StreamSource(datosCanciones); //fuente XML
  Result result = new StreamResult(os);      //resultado de la transformacion
  
  try{     
   Transformer transformer =  
               TransformerFactory.newInstance().newTransformer(estilos);   
   
   transformer.transform(datos, result); //obtiene el HTML
  }
  catch(Exception e){System.err.println("Error: "+e);}
  
  os.close();  //cerrar fichero 	
 }
}