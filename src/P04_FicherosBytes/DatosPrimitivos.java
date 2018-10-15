package P04_FicherosBytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatosPrimitivos {

	public static void main(String[] args) throws IOException{
	
		File f = new File("C:\\Users\\ifc\\eclipse-workspace\\AD_01_Ficheros\\src\\P04_FicherosBytes\\primitivos.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		DataOutputStream dataOS = new DataOutputStream(fileout);
		
		Byte by=1;
		char ch = 2;
		boolean bo =true;
		int in=3;
		String str="hola";		
		
		dataOS.writeByte(by);
		dataOS.writeChar(ch);
		dataOS.writeBoolean(bo);
		dataOS.writeInt(in);	
		dataOS.writeUTF(str);//String
		
		dataOS.close();	
		
		FileInputStream filein = new FileInputStream(f);
		DataInputStream dataIS = new DataInputStream(filein);
		
		try {
			while(true){
				by=dataIS.readByte();
				System.out.println("Esto es un byte: "+by);
				ch=dataIS.readChar();
				System.out.println("Esto es un char: "+ch);
				bo=dataIS.readBoolean();
				System.out.println("Esto es un boolean: "+bo);
				in=dataIS.readInt();
				System.out.println("Esto es un int: "+in);
				str=dataIS.readUTF();
				System.out.println("Esto es un String: "+str);
			}
		}catch (EOFException eo) {
			System.out.println("Error");//Sale simepre al final porque siempre espera algun fichero m�s
		}		
	}
}
