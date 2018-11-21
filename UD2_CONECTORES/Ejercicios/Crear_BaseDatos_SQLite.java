package Ejercicios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Crear_BaseDatos_SQLite {
	
	static Statement statement;
	static ResultSet rs;

	public static void main(String[] args) {
		
	  Connection connection = null;
		
	  try {
		   
		// Crear una conexion de base de datos
          connection = DriverManager.getConnection
          ("jdbc:sqlite:C:\\Users\\ifc\\eclipse-workspace\\ACCESO_DATOS_DAM_2\\UD2_CONECTORES\\SQLite\\SQLite\\datos.db");
          
          statement = connection.createStatement();
          statement.setQueryTimeout(30);  // tiempo para ejecutar el objeto
          
          //Crear tabla
          statement.executeUpdate("drop table if exists persona");
          
          statement.executeUpdate("create table persona (id integer, nombre string,"
          		+ "apellido string, edad interger, telefono interger, nacionalidad string)");
          
          statement.executeUpdate("insert into persona values(1, 'leo', 'perez', 32, 976234567, 'espanola')");
          
          statement.executeUpdate("insert into persona values(2, 'julia', 'marquez', 42, 987465213, 'espanola')");
          
          //para ejecutar la consulta
          rs = statement.executeQuery("select * from persona");
          while(rs.next())
          {
        	  // leer el resultado
        	  System.out.println("id = " + rs.getInt("id"));
              System.out.println("nombre = " + rs.getString("nombre"));
              System.out.println("apellido = " + rs.getString("apellido"));
              System.out.println("edad = " + rs.getInt("edad"));
              System.out.println("telefono = " + rs.getInt("telefono"));
              System.out.println("nacionalidad = " + rs.getString("nacionalidad"));
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
	
	public static void insertar(int id, String nombre, String apellido, 
			  int edad, int telefono, String nacionalidad) throws SQLException {
		  
		statement.executeUpdate("insert into persona values("+id+", 'leo', 'perez', 32, 976234567, 'espanola')");
		  
		  
	  }
	  
    /*  public static consultar() throws SQLException{
    	   
    	   ResultSet rs = statement.executeQuery("select * from persona");
           while(rs.next())
           {
         	  // leer el resultado
         	  System.out.println("id = " + rs.getInt("id"));
               System.out.println("nombre = " + rs.getString("nombre"));
               System.out.println("apellido = " + rs.getString("apellido"));
               System.out.println("edad = " + rs.getInt("edad"));
               System.out.println("telefono = " + rs.getInt("telefono"));
               System.out.println("nacionalidad = " + rs.getString("nacionalidad"));
             }
       }

     }*/
   }
 


