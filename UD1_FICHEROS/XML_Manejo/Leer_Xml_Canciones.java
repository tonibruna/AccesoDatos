/*Clase que realiza lo mismo que la clase annterior PruebaSax, pero esta vez con 
 * un contador para que cuente el número de canciones que son españolas*/

package XML_Manejo;

import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class Leer_Xml_Canciones {		
	
	public static void main(String[] args)
              throws FileNotFoundException, IOException, SAXException
	{
		
	 XMLReader  procesadorXML = XMLReaderFactory.createXMLReader();
	 
	 GestionContenido2 gestor= new GestionContenido2();  
	 
	 procesadorXML.setContentHandler(gestor);
	 
 	 InputSource fileXML = 
 			 new InputSource("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\XML_Manejo\\canciones.xml");	    
       
 	 procesadorXML.parse(fileXML);        	      
	
	}
}

class GestionContenido2 extends DefaultHandler {	 
	
	int contador;
	
	    public GestionContenido2() {
	        super();
	    }	    
	    
	    public void startDocument() {
	        System.out.println("Comienzo del Documento XML");
	    }	
    
	    public void endDocument() {
	        System.out.println("Final del Documento XML");
	        
	        System.out.println("->El numero de canciones espa�olas es " + contador);
	    }
	    
	    public void startElement(String uri, String nombre,
	              String nombreC, Attributes atts)
	    {
	    	
	        System.out.printf("\tPrincipio Elemento: %s %n",nombre);	 	        
	    } 	
    
	    public void endElement(String uri, String nombre, String nombreC) 
	    {
	        System.out.printf("\tFin Elemento: %s %n", nombre);
	    }	
	    
	    public void characters(char[] ch, int inicio, int longitud) 
	                                        throws SAXException 
	    {
		   String car=new String(ch, inicio, longitud);
		   
	       //quitar saltos de linea
		   
		   car = car.replaceAll("[\t\n]","");	   
		   System.out.printf ("\t Caracteres: %s %n", car);		
		   
		   if(car.equals("true")) {
			  
			   contador++;
		   }
			   
	    }	
      
}//Fin GestionContenido 