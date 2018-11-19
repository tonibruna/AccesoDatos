package Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Crear_BaseDatos_SQLite {

	public static void main(String[] args) {
		
	  Connection connection = null;
		
	  try {
		  
		// Crear una conexion de base de datos
          connection = DriverManager.getConnection
          ("jdbc:sqlite:\\ACCESO_DATOS_DAM_2\\UD2_CONECTORES\\Ejercicios\\databaseSQLite.db");
          
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // tiempo para ejecutar el objeto
          
          //Crear tabla
          statement.executeUpdate("drop table if exists person");
          
          statement.executeUpdate("create table persona (id integer, nombre string,"
          		+ "apellido string, edad interger, telefono interger, nacionalidad string)");
          
          statement.executeUpdate("insert into persona values(1, 'leo', 'perez', 32, 976234567, española)");
          
          statement.executeUpdate("insert into persona values(2, 'julia', 'marquez, 42, 987465213, española)");
          
          //para ejecutar la consulta
          ResultSet rs = statement.executeQuery("select * from persona");
          while(rs.next())
          {
        	  // leer el resultado
              System.out.println("name = " + rs.getString("name"));
              System.out.println("id = " + rs.getInt("id"));
            }
          }
          catch(SQLException e)
          {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
          }
	   finally
       {
         try
         {
           if(connection != null)
             connection.close();
         }
         catch(SQLException e)
         {
           // connection close failed.
           System.err.println(e.getMessage());
         }
       }
     }
   }
 
