package edu.uspg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uspg.EnvioDatos.DatosPostgre;
import edu.uspg.EnvioDatos.DatosSQLServer;

@SpringBootApplication
public class FabricaConexion1Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(FabricaConexion1Application.class, args);
		Scanner scn = new Scanner(System.in);
		FabricaConexiones fabricaConexiones = new FabricaConexiones();

		char DataBase;

		System.out.println("Seleccione la base de datos a registrar:");
		System.out.println("PostgreSQL = p 	SQL Server = s");

		System.out.print("Base de Datos: ");
		DataBase = scn.next().charAt(0);

		if (DataBase == 'p' | DataBase == 's') {

			if (DataBase == 'p') {
				DatosPostgre postgre = new DatosPostgre();
				System.out.println("Base de Datos PostgreSQL");
				Connection cnPostgres = fabricaConexiones.getConexion("POSTGRES");

				// PostgreSQL
				if (cnPostgres != null) {
					System.out.println("Conectado a Postgres");
					String nombrePost;
					int idPost;

					System.out.println("   Ingrese id: ");
					System.out.print(" -");
					idPost = scn.nextInt();

					System.out.println("   Ingrese nombre: ");
					System.out.print(" -");
					nombrePost = scn.next();

					postgre.RegistrarDatos(nombrePost, idPost);
				}

			}
//--------------------------------------------------------------------------------------------------------------------------
			if (DataBase == 's') {
				DatosSQLServer sqlserver = new DatosSQLServer();
				System.out.println("Base de Datos SQL Server");
				Connection cnServer = fabricaConexiones.getConexion("SQLSERVER");

				// SQLServer
				if (cnServer != null) {

					System.out.println("Conectado a SQLServer");
					String nombreSQL;
					int idSQL;

					System.out.println("   Ingrese id: ");
					System.out.print(" -");
					idSQL = scn.nextInt();

					System.out.println("   Ingrese nombre: ");
					System.out.print(" -");
					nombreSQL = scn.next();

					sqlserver.RegistrarDatos(nombreSQL, idSQL);
				}
			}

		} else {
			System.out.println("Base de datos seleccionada no coincide, por favor ingrese una opción valida.");
		}

	}
}
