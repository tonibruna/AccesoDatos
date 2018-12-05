/*Hacemos llamada al procedimiento, recibe un numero de departamento
 * y lo devuelve en parametros de salida Nombre y Localidad */

package Ejemplos;

import java.sql.*;

public class Procedimiento_Datos_Dpto {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
					"tubalcain_dam", "12345678" ); 
	
			//recuperar parametros main
			
			int dep= 87;
			
			// construir orden DE LLAMADA
			String sql = "{ ? = call nombre_dep_toni (?) } "; 
			
			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);
						
			//registramos el parametro de salida que esta en la posicion 1
			llamada.registerOutParameter(2, Types.VARCHAR);
			llamada.registerOutParameter(3, Types.VARCHAR);
			
			//Doy valor al parametro de entrada (posicion 2)
			llamada.setInt(1, dep);
															
			llamada.execute(); // ejecutar el procedimiento
			
			//Mostrar parametro de salida
			System.out.println("Número de departamento: "+dep+" Nombre: "
			+llamada.getString(2)+" Localidad: "+llamada.getString(3));
			
			llamada.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
