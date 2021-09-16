package edu.uspg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FabricaConexion1Application {

	public static void main(String[] args) {
		SpringApplication.run(FabricaConexion1Application.class, args);
		Scanner scn = new Scanner(System.in);
		FabricaConexiones fabricaConexiones = new FabricaConexiones();
		
		

		char DBPostgre = 'p';

		System.out.println("Seleccione la base de datos a registrar:");
		System.out.println("PostgreSQL = p 	SQL Server = s");

		System.out.print("Base de Datos: ");
		DBPostgre = scn.next().charAt(0);

		if (DBPostgre == 'p' | DBPostgre == 's') {

			if (DBPostgre == 'p') {
				System.out.println("Base de Datos PostgreSQL");
				Connection cnPostgres = fabricaConexiones.getConexion("POSTGRES");

				// PostgreSQL
				if (cnPostgres != null) {
					System.out.println("Conectado a postgres");
					try {
						PreparedStatement st = cnPostgres.prepareStatement("insert into alumno(id,nombre) values(?,?)");
						st.setInt(1, 2);
						st.setString(2, "Diego");
						st.execute();
						st.close();
					} catch (Exception e) {
						e.getMessage();
					}
				}

			}
//--------------------------------------------------------------------------------------------------------------------------
			if (DBPostgre == 's') {
				System.out.println("Base de Datos SQL Server");
				Connection cnServer = fabricaConexiones.getConexion("SQLSERVER");

				// SQLServer
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

		} else {
			System.out.println("Base de datos seleccionada no coincide, por favor ingrese una opción valida.");
		}

	}
}
