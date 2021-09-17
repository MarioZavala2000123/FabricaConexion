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
		
		
		DatosPostgre postgre  = new DatosPostgre();
		DatosSQLServer sqlserver = new DatosSQLServer();
		
		char DataBase;

		System.out.println("Seleccione la base de datos a registrar:");
		System.out.println("PostgreSQL = p 	SQL Server = s");

		System.out.print("Base de Datos: ");
		DataBase = scn.next().charAt(0);

		if (DataBase == 'p' | DataBase == 's') {

			if (DataBase == 'p') {
				
				System.out.println("Base de Datos PostgreSQL");
				Connection cnPostgres = fabricaConexiones.getConexion("POSTGRES");

				// PostgreSQL
				if (cnPostgres != null) {
					System.out.println("Conectado a postgres");
					String nombre;
					int id;

					System.out.println("   Ingrese id: ");
					System.out.print(" -");
					id = scn.nextInt();

					System.out.println("   Ingrese nombre: ");
					System.out.print(" -");
					nombre = scn.next();

					

					postgre.RegistrarDatos(nombre, id);
				}

			}
//--------------------------------------------------------------------------------------------------------------------------
			if (DataBase == 's') {
				System.out.println("Base de Datos SQL Server");
				Connection cnServer = fabricaConexiones.getConexion("SQLSERVER");

				// SQLServer
				if (cnServer != null) {
					System.out.println("Conectado a SQLServer");
					try {
						PreparedStatement sql = cnServer.prepareStatement("insert into alumno(id,nombre) "
								+ "values(?,?)");
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
