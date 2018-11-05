package XML_Manejo;

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class Ej2_Escribir_Cancion {

	public static void main(String[] args) 
			throws IOException, ClassNotFoundException{
		
		File fichero = new File("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\XML_Manejo\\Canciones.dat");
		//flujo de entrada 
   		FileInputStream filein = new FileInputStream(fichero); 
   		
   		//conecta el flujo de bytes al flujo de datos
    	ObjectInputStream dataIS = new ObjectInputStream(filein);
    	
    	System.out.println
        ("Comienza el proceso de creacion del fichero a XML ...");
    	
    	//Creamos un objeto Lista de Personas
    	Ej2_Lista_Canciones listacan = new Ej2_Lista_Canciones();
        
        try {
            while (true) { //lectura del fichero
                //leer una cancion
      	    Cancion cancion= (Cancion) dataIS.readObject();    
      	    listacan.add(cancion); //añadir cancion a la lista  
            }	
          }catch (EOFException eo) {}
          
          dataIS.close();  //cerrar stream de entrada   
          
          try {
        	  
      		XStream xstream = new XStream();   
      		//cambiar de nombre a las etiquetas XML
      		xstream.alias("ListaCanciones", 
      				Ej2_Lista_Canciones.class);	
      		xstream.alias("DatosCancion", Cancion.class);
      		
      		//Para cambiar nombre a subetiquetas Xml 
      	    //xstream.aliasField("artista cancion", Cancion.class, "artista");
    		//xstream.aliasField("titulo cancion", Cancion.class, "titulo");
      		
      		//quitar etiqueta lista (atributo de la claseListaPersonas)
      		xstream.addImplicitCollection
                                (Ej2_Lista_Canciones.class, "lista");
      		//Insertar los objetos en el XML
      	      xstream.toXML(listacan, new
                         FileOutputStream("C:\\Users\\ifc\\"
                       + "eclipse-workspace\\AD_01_Ficheros\\src\\XML_Manejo\\Canciones_xs.xml"));	
      		System.out.println("Creado fichero XML....");
      	
           }catch (Exception e) 
      	   {e.printStackTrace();}	    
        } // fin main
      } //fin EscribirPersonas

