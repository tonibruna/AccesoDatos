/*Practica creada con acceso a BD empleados con metodos para usar
 * sentencias ya preparadas
 */

package Ejercicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Ej_CrearBD_Metodos {
	
	//Establecemos conexion
	
	static Connection conexion;
	
	public static void main(String[] args) {
	
    System.out.println("Iniciamos conexion");	    
    try {	    	
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(
        				"jdbc:mysql://www.db4free.net:3306/toni_dam",
        				"toni_dam",	"12345678");    
        
        //Metodos solicitados para practica
        
        //insertarDept(1,"1","1");
        
        //departamento dept = new departamento(2,"2","2");
        //insertarDept(dept);
        
        //mostrarDepartamentos();
        
        //consultarDepartamentos(1);
        
        //departamento dept = new departamento(2,"Toni","Monteagudo");
        //actualizarDepartamento(dept);
        
        //borrarDepartamento(2);
        
        //borrarYMostrarFilasAfectadas(2);
        
        //actualizarLocalidad(2,"Novallas");
        
        mostrarDepartamentos();
        
        conexion.close();
	       System.out.println("Conexion cerrada");
	    }	    
	    catch ( Exception e){
	        e.printStackTrace();
	    }
}

	//Metodo Insertar departamento que recibe 3 argumentos
	
 	public static void insertarDept (int numero, String nombre, String localidad) {
		String query = "INSERT INTO `DEPT`(`DEPTNO`, `DNAME`, `LOC`) "
				+ "VALUES ("+numero+","+nombre+","+localidad+")";
		Statement stmt = null;
        try {
            stmt = conexion.createStatement();        
            stmt.execute(query);
            stmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();        
        } 
	}
 	
 	//Metodo Insertar departamento que recibe 1 argumento que es objeto de la clase dpto.
 	
 	public static void insertarDept (departamento d) {
 		String query = "INSERT INTO `DEPT`(`DEPTNO`, `DNAME`, `LOC`) "
				+ "VALUES ("+d.getNumero()+","+d.getNombre()+","+d.getLocalidad()+")";
		Statement stmt = null;
        try {
            stmt = conexion.createStatement();        
            stmt.execute(query);
            stmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();        
        } 
 	}
 	
 	//Este metodo devuelve una lista con Array de objetos dept a raiz de la consulta SELECT
 	
 	public static List<departamento> mostrarDepartamentos() {
		List<departamento> lista = new ArrayList<departamento>();
		String query = "SELECT * FROM `DEPT`";
		Statement stmt = null;
		
	try {
	        stmt = conexion.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        int numero;
	        String nombre, localidad;
	        while (rs.next()){
	            numero = rs.getInt("DEPTNO");
	            nombre = rs.getString("DNAME");
	            localidad = rs.getString("LOC");
	            departamento dept = new departamento(numero,nombre,localidad);
	            lista.add(dept);
	            System.out.println("Numero: " + numero + " Nombre: " + nombre+" Localidad: " + localidad);               
	           }
	           stmt.close();
	        }
	        catch (SQLException e){
	            e.printStackTrace();        
	        } 
	        return lista;
		}
 	

	//Este metodo recibe un numero de departamento y devuelve sus datos mediante un objeto.
 	
	public static departamento consultarDepartamentos(int num) {
		String query = "SELECT * FROM `DEPT` WHERE `DEPTNO` = "+num+"";
		Statement stmt = null;
		 departamento dept = new departamento();  
        try {
        	stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int numero;
            String nombre, localidad;   
            while (rs.next()){
	            numero = rs.getInt("DEPTNO");
	            nombre = rs.getString("DNAME");
	            localidad = rs.getString("LOC");
	            dept = new departamento(numero,nombre,localidad);          
	            System.out.println("Numero: " + numero + " Nombre: " + nombre+" Localidad: " + localidad);                       
            }
            stmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();        
        } 
        return dept;
	}
	
	//Este metodo actualiza un departamento que recibe un objeto departamento
	
	public static void actualizarDepartamento(departamento d) {
		String query = "UPDATE `DEPT` SET `DNAME` = '"+d.getNombre()+"',"
				+ "`LOC`= '"+d.getLocalidad()+"' WHERE `DEPTNO` = "+d.getNumero();
		Statement stmt = null;
        try {
            stmt = conexion.createStatement();        
            stmt.execute(query);
            stmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();        
        } 
	}
	
	//Este metodo recibe un número de departamento y lo da de baja.
	
	public static void borrarDepartamento(int numero) {
		String query = "DELETE FROM `DEPT` WHERE DEPTNO = "+numero+"";
		Statement stmt = null;
        try {
            stmt = conexion.createStatement();        
            stmt.execute(query);
            stmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();        
        } 
	}
	
	//Este metodo recibe un número de departamento y lo da de baja. Tambien devuelve el número de filas afectadas.
	
		public static void borrarYMostrarFilasAfectadas(int numero) {
			String query = "DELETE FROM `DEPT` WHERE DEPTNO = "+numero;
			Statement stmt = null;
			int filas=0;
	        try {
	            stmt = conexion.createStatement();       
	            filas = stmt.executeUpdate(query.toString());       
	  		  	System.out.println("Filas afectadas: " + filas);
	            stmt.close();
	        }
	        catch (SQLException e){
	            e.printStackTrace();        
	        } 
		}
		
	//Este metodo actualiza la localidad mediante un numero de depto.
		
		public static void actualizarLocalidad(int numero, String localidad) {
			String sql = "{ call actualizaDept (?, ?) } ";		
			
			try {
				CallableStatement llamada = conexion.prepareCall(sql);
				
				// Damos valor a los argumentos
				llamada.setInt(1, numero); // primer argumento
				llamada.setString(2, localidad); // segundo argumento
																
				llamada.executeUpdate(); // ejecutar el procedimiento
				System.out.println("Sa ha actualizado correctamente");
				llamada.close();
			} catch (SQLException e){
				e.printStackTrace();        
			} 
		}
	}
	
	//Creamos la clase departamento
	
	class departamento{
		int numero;
		String nombre;
		String localidad;
		
		//constructor vacio
		public departamento() {
		
		}
		
		public departamento(int num, String nom, String loc) {
			this.numero=num;
			this.nombre=nom;
			this.localidad=loc;
		}
		
		public int getNumero() {
			 return numero;
		 }
		 public String getNombre() {
			 return nombre;
		 }
		 public String getLocalidad() {
			 return localidad;
		 }
		
		 public void setNumero(int numero) {
			 this.numero = numero;
		 }
		 public void setNombre(String nombre) {
			 this.nombre = nombre;
		 }
		 public void setLocalidad(String localidad) {
			 this.localidad = localidad;
		 }	
		 
		 public String mostrarDepartamentos() {
			 return "Numero: " + numero + " Nombre: " + nombre+" Localidad: " + localidad;
		 }
	}
	

