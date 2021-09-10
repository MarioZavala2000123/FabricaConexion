package edu.uspg.conexion;

import java.sql.Connection;

public interface IConexion {

	Connection conectar();
	void desconectar();
}
