package edu.uspg.EnvioDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import edu.uspg.FabricaConexiones;

public class DatosSQLServer {
	
	public void RegistrarDatos(String nombre, int id) throws SQLException {

		FabricaConexiones fabricaConexiones = new FabricaConexiones();
		Connection conexion = null;
		Connection cnServer = fabricaConexiones.getConexion("SQLSERVER");

		try {

			PreparedStatement st = cnServer.prepareStatement("insert into alumno(id,nombre) " + "values(?,?)");

			st.setInt(1, id);
			st.setString(2, nombre);

			st.execute();
			st.close();

		} catch (Exception e) {

			e.getMessage();

		} finally {

			if (conexion != null) {

				if (!conexion.isClosed()) {

					conexion.close();
				}
			}
		}
	}

}
