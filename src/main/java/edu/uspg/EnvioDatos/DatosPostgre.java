package edu.uspg.EnvioDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import edu.uspg.FabricaConexiones;

public class DatosPostgre {

	public void RegistrarDatos(String nombre, int id) throws SQLException {

		FabricaConexiones fabricaConexiones = new FabricaConexiones();
		Connection conexion = null;
		Connection cnPostgres = fabricaConexiones.getConexion("POSTGRES");

		try {

			

			PreparedStatement st = cnPostgres.prepareStatement("insert into alumno(id,nombre) "
					+ "values(?,?)");
						
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

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String nombre;
		
		int id;

		System.out.println("   Ingrese nombre: ");
		System.out.print(" -");
		nombre = sc.next();

		

		System.out.println("   Ingrese su número de telefono: ");
		System.out.print(" -");
		id = sc.nextInt();

		

		DatosPostgre conexion = new DatosPostgre();

		conexion.RegistrarDatos(nombre, id);

	}

}
