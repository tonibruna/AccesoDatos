package P03_LecturaEscritura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LecturaEscritura {

	public static void main(String[] args) throws IOException{
		
       File f1=new File("C:\\Users\\ifc\\eclipse-workspace\\f1.txt"); 
	
       //Se puede hacer de dos maneras. una de ellas poneindo el throws IOException
       // y esta con el try catch
       
		    FileReader fichero = new FileReader(f1); 
		    int i; //caracter actual
		    
		    while ((i=fichero.read())!=-1) {
		    	System.out.println((char)i);
		    }

			}			
		}

