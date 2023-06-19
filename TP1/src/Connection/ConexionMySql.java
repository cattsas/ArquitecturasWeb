package Connection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql  {
	
	private Connection conexion; 	
	private String uri = "jdbc:mysql://localhost:3306/bataman";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String user = "root";
	private String password = "root";
		
	public ConexionMySql() {
		this.conexion=this.getInstance();
	}
	
	/**
	 * creates aninstance of a MySQL connection if the instance dont exists, else returns it
	 * @return Connection
	 * @see Connection JAVA interface
	 */
	public Connection getInstance() {
		 if (conexion==null) connect();		
		 
		 return this.conexion;
	}

	/**
	 * connects the DB  
	 */
	public void connect() {
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		   try {
			this.conexion = DriverManager.getConnection(this.uri, this.user, this.password);
			this.conexion.setAutoCommit(false);
		   }
		   catch (SQLException e) {				
			e.printStackTrace();
		}  		
		
	}

	/**
	 * disconnects the DB  
	 */
	public void disconnect() {
		try {
			this.conexion.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}	
	
}
