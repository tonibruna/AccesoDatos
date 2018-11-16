package P04_FicherosBytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerEscribirBytes {

	public static void main(String[] args) throws IOException{
	
		File f = new File("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P04_FicherosBytes\\datos.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		FileInputStream filein = new FileInputStream(f);
		
		int i;
		
		for(i=0;i<100;i++) {
			fileout.write(i);
		}
		fileout.close();
		
		while((i=filein.read())!=-1) {
			System.out.println(i);
		}
		filein.close();		
	}
}
