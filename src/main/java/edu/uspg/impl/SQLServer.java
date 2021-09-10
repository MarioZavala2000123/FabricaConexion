package edu.uspg.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.uspg.conexion.IConexion;

public class SQLServer implements IConexion  {
	
	private static Connection instancia;
	

	String connectionUrl = "jdbc:sqlserver://LAPTOP-ZT.Conexion.windows.net:1433;" + "database=AdventureWorks;"
			+ "user=usuarioSQL@LAPTOP-ZT;" + "password=123;" + "encrypt=true;"
			+ "trustServerCertificate=false;" + "loginTimeout=30;";
	
	
	
	@Override
	public Connection conectar() {
		try {
			if(instancia == null) {
				Class.forName(connectionUrl);
				instancia = DriverManager.getConnection(connectionUrl);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Conexión fallida", e);
		}
		return instancia;
	}

	@Override
	public void desconectar() {
		try {
			Connection conn = conectar();
			conn.close();
		} catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
		
	}

}
