package Ejemplos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			
			// Damos valor a los argumentos
			llamada.setInt(1, dep); // primer argumento-dep ?
			
			llamada.executeUpdate(); // ejecutar el procedimiento
			
			System.out.println(llamada.getString(1));
			llamada.close();
			conexion.close();
			
			
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

