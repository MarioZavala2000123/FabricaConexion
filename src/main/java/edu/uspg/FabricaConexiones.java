package edu.uspg;

import java.sql.Connection;

import edu.uspg.impl.Postgres;
import edu.uspg.impl.SQLServer;

public class FabricaConexiones {

	public Connection getConexion(String tipoDeConexion) {
		if(tipoDeConexion == null) {
			return null;
	//	} else if(tipoDeConexion.equalsIgnoreCase("POSTGRES")) {
	//		Postgres ps = new Postgres();
	//		return ps.conectar();
		} else if(tipoDeConexion.equalsIgnoreCase("SQLSERVER")) {
			SQLServer sql = new SQLServer();
			return sql.conectar();
		}
		
		return null;
		
	}
}
