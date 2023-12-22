package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	//Tendra un solo metodo estatico.
	
	public static Connection getConnection() {
		String username = "root";
		String password = "contraseña";
		String port = "3306";
		String host = "localhost";
		String dbName = "integrador_cac";
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		String dbUrl = "jdbc:mysql://"+host+":"+port+"/"+dbName + "?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(dbUrl, username, password);
		}catch(Exception e) {
			throw new IllegalArgumentException("No se pudo conectar a la db: " + dbUrl);
		}
		
	}
}
