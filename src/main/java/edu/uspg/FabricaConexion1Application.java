package edu.uspg;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FabricaConexion1Application {

	public static void main(String[] args) {
		SpringApplication.run(FabricaConexion1Application.class, args);

		FabricaConexiones fabricaConexiones = new FabricaConexiones();

		Connection cnPostgres = fabricaConexiones.getConexion("POSTGRES");

		Connection cnServer = fabricaConexiones.getConexion("SQLSERVER");

		// Menú para registrar
		// 1. Alumnos
		// 2. Lista Alumnos
		// 3. Actualizar Alumno
		// 4. Salir

		// Ingrese nombres:
		// Ingrese apellidos:
		// Ingrese telefono:

		// id nombres apellidos telefono
		// 1 Juan Carrasco 12948575
		// 2 Juan Carrasco 12948575
		// 3 Juan Carrasco 12948575

		// ingrese id a actualizar
		// 3
		// Carlos
		// Carrasco
		// 7889-2323

		if (cnPostgres != null) {
			System.out.println("Conectado a postgres");
			try {
				PreparedStatement st = cnPostgres.prepareStatement("insert into alumno(id, nombre) values(?,?)");
				st.setInt(1, 2);
				st.setString(2, "Diego");
				st.execute();
				st.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		if (cnServer != null) {
			System.out.println("Conectado a SQLServer");
			try {
				PreparedStatement sql = cnServer.prepareStatement("insert into alumno(id,nombre) values(?,?)");
				sql.setInt(1, 1);
				sql.setString(2, "Diego");
				sql.execute();
				sql.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		

	}
}
