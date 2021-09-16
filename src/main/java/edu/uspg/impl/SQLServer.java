package edu.uspg.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.uspg.conexion.IConexion;

public class SQLServer implements IConexion {

	private static Connection instancia;

	private static String DB_URL = "jdbc:sqlserver://localhost\\LAPTOP-ZT:1433;databaseName=Conexion";
	private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String USER = "usuarioSQL";
	private static String PASS = "123";

	@Override
	public Connection conectar() {
		try {

			if (instancia == null) {
				Class.forName(DRIVER);
				instancia = DriverManager.getConnection(DB_URL, USER, PASS);
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
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

	}

}
