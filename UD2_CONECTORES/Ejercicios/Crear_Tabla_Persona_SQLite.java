/*Clase que se conecta con una base de datos SQLite (local), crea una tabla llamda persona
 * que contiene 6 campos e implementa métodos diferentes para realizar las operaciones 
 * básicas sobre una BD (CRUD)*/

package Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Crear_Tabla_Persona_SQLite {
	
	static Statement statement;
	static ResultSet rs;

	public static void main(String[] args) {
		
	  Connection connection = null;
		
	  try {
		   
		// Crear una conexion de base de datos   
          connection = DriverManager.getConnection
          ("jdbc:sqlite:C:\\Users\\Maria Aznar\\git\\AccesoDatos\\UD2_CONECTORES\\SQLite\\SQLite\\datos.db");
          
          statement = connection.createStatement();
          statement.setQueryTimeout(30);  // tiempo para ejecutar el objeto
          
          //Crear tabla
          
          statement.executeUpdate("drop table if exists persona");
          statement.executeUpdate("create table persona (id integer, nombre string,"
          		+ "apellido string, edad integer, telefono integer, nacionalidad string)");
          
          //statement.executeUpdate("insert into persona values(1, 'leo', 'perez', 32, 976234567, 'espanola')");
          
          //statement.executeUpdate("insert into persona values(2, 'julia', 'marquez', 42, 987465213, 'espanola')");
          
          //mostrar();
	      //actualizar(1, 'laura', 'gimeno', 36, 976236767, 'portuguesa')");
	      //consultar();
	      //borrar(1);
	      //buscar(2);
	      //consultar();
          
          
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
	  
	  //Metodo para que muestre todos los datos de la tabla 
	
      public static void consultar() throws SQLException {
    	   
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
      
      //Metodo para modificar los datos de la persona con el Id que le pides por parametro
      
      public static void actualizar(int id, String nombre, String apellido, 
			  int edad, int telefono, String nacionalidad) throws SQLException { 
  		statement.executeUpdate("update persona set nombre='"+nombre+"', apellido="+apellido+", edad="+edad+", "
  				+ "telefono="+telefono+", nacion="+nacionalidad+ "where id="+id+"");	  
  	}

  	  //Metodo para borrar los datos de la persona con el Id que le pides por parametro
      
  	  public static void borrar(int id) throws SQLException { 
  		statement.executeUpdate("delete from persona where id="+id+"");	   
  	}
    
  	 //Metodo que muetra los datos de la persona cuyo id es el que le pides por parámetro.
  	  
  	  public static void buscar(int id) throws SQLException { 
  		rs = statement.executeQuery("select * from persona where id="+id+"");
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
 
}


