/*Clase que hace una llamada a la función nombre_dep_toni,
 * que trata de mostrar el nombre del departamento cuyo dpto_no
 * es pasado por parámetro*/

package Ejemplos;

import java.sql.*;

public class Funcion_nombre_dept {
	public static void main(String[] args) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
    				"tubalcain_dam",
    				"12345678"
    				); 
			
			//recuperar parametros main
			
			int dep= 87;
			
			// construir orden DE LLAMADA
			String sql = "{ ? = call nombre_dep_toni (?) } "; 
			
			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);
			
			//registramos el parametro de salida que esta en la posicion 1
			llamada.registerOutParameter(1, Types.VARCHAR);
			
			// Damos valor a los argumentos
			llamada.setInt(2, dep); // primer argumento-dep ?
			
			llamada.execute(); // ejecutar el procedimiento
			
			//Mostrar parametro de salida
			System.out.println("Número de departamento: "+dep+
					" Nombre: "+llamada.getString(1));
					//mostramos primer argumento
			
			llamada.close();
			conexion.close();
			
			
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

