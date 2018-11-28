//con esta clase ejecutamos subidas a los empleados partiendo 
//de su numero de empleado. Lo miramos a traves de PHPmyadmin

package Ejemplos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedimiento_Subida_salario {

	public static void main(String[] args) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
    				"tubalcain_dam",
    				"12345678"
    				); 

			// recuperar parametros de main
			int dep = 1;   //"10"; // departamento
			float subida = 500;//"1000"; // subida
			
			// construir orden DE LLAMADA
			String sql = "{ call subida_sal_toni (?, ?) } "; 

			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);
			
			// Damos valor a los argumentos
			llamada.setInt(1, dep); // primer argumento-dep ?
			llamada.setFloat(2,subida); // segundo arg ?
															
			llamada.executeUpdate(); // ejecutar el procedimiento
			System.out.println("Subida realizada....");
			llamada.close();
			conexion.close();
			
			
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}