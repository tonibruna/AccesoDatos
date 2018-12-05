package Examen_1Ev_Acceso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2_BD_Empleados {
	
	//Establecemos conexion
	
		static Connection conexion;

	public static void main(String[] args) {
		
		//cargamos el driver y establecemos conexion
		System.out.println("Iniciamos conexion");	    
		try {	    	
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       conexion = DriverManager.getConnection(
		        		"jdbc:mysql://www.db4free.net:3306/toni_dam",
		        		"toni_dam",	"12345678"); 
		       
		 //METODOS REQUERIDOS    
		 
		 //insertarDept(2,"2","2");
		       
		 //consultarDepartamentos(1);
		       
		 //subidaSalario();
		       
		 //subidaSalarioResultSet();
		       
		 //databaseMetaData();
		       
		 //databaseMetaData2();

		 conexion.close();
		 System.out.println("Conexion cerrada");
		 }	    
		 catch ( Exception e){
		    e.printStackTrace();
		 }
}
	
	//Metodo para insertar un departamento que recibe 3 argumentos
	
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
 	
	//Metodo que recibe un numero de departamento y devuelve sus datos mediante un objeto.
 	
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
	
	//Metodo que recibe una cantidad y un numero de dept e incrementa el sueldo
	
	public static void subidaSalario() throws SQLException {
		
					int dep = 10;   //"10"; // departamento
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
	
	}
	

	//Metodo idem al anterior pero sin uso de MySOL
	
	public static void subidaSalarioResultSet() throws SQLException {
		
		Statement sentencia = conexion.createStatement();
		ResultSet rs = sentencia
				.executeQuery("SELECT * FROM departamentos");
		
		
	}
	
	//Metodo que imprime el gestor, el driver y usuario
	
	public static void databaseMetaData() throws SQLException {
		
		DatabaseMetaData dbmd = conexion.getMetaData();
        
		ResultSet resul = null;
	 
  		 String nombre  = dbmd.getDatabaseProductName();
  		 String driver  = dbmd.getDriverName();
  		 String url     = dbmd.getURL(); 
  		 String usuario = dbmd.getUserName() ;
		 		 
  		 System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
  		 System.out.println("===================================");
  		 System.out.printf("Nombre : %s %n", nombre );
  		 System.out.printf("Driver : %s %n", driver );
  		 System.out.printf("URL    : %s %n", url );
  		 System.out.printf("Usuario: %s %n", usuario );
	}
	
	//Metodo que imprime esquema actual de las tablas
	
	public static void databaseMetaData2() throws SQLException {
		
		DatabaseMetaData dbmd = conexion.getMetaData();
        
		ResultSet resul = null;
		
		   //Obtener información de las tablas y vistas		       
        resul = dbmd.getTables(null, "USUARIO", null, null);
		 
 		 while (resul.next()) {			   
			     String catalogo = resul.getString(1);//columna 1 
			     String esquema = resul.getString(2); //columna 2
			     String tabla = resul.getString(3);   //columna 3
			     String tipo = resul.getString(4);	  //columna 4
 			     System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", 
 					   tipo, catalogo, esquema, tabla);
 		 }   				
 		 conexion.close(); //Cerrar conexion  
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
	
