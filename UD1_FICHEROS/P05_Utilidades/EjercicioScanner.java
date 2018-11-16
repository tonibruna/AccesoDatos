package P05_Utilidades;

import java.util.*;

public class EjercicioScanner {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		int numero;
		float decimales;
		String texto;
		
		System.out.println("dame un numero: ");
	    numero=teclado.nextInt();
	    
	    System.out.println("Dame un numero con decimales: ");
	    decimales=teclado.nextFloat();
	    
	    texto=teclado.nextLine(); //para evitar que el intro anterior lo adjudique a texto
	    System.out.println("dime algo bonito:");
	    texto=teclado.nextLine();
	    
	    System.out.println("el numero fue: "+numero);
	    System.out.println("el numero con decimal fue: "+decimales);
	    System.out.println("lo bonito que me dijiste fue: "+texto);
		
		teclado.close();
	}

}
