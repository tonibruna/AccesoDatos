//Clase que crea un fichero

package P01_Manipular;

import java.io.File;
import java.io.IOException;

public class CrearFichero {

	public static void main(String[] args) {
		
		File f1=new File("C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD1_FICHEROS\\P01_Manipular\\f1.txt");
		
		if(f1.exists()) {
			System.out.println("El fichero ya existe");
		}else {
			try {
				f1.createNewFile();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}			
		}
	}
}
