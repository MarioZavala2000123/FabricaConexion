package edu.uspg.EnvioDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatosPostgre {

	public void RegistrarDatos(String nombre, String apellido, String direccion, int telefono, String correo,
			String fechaN, double altura, double peso) throws SQLException {

	
		Connection conexion = null;

		try {

			

			PreparedStatement st = conexion.prepareCall("insert into personas (Nombre, Apellido, Direccion, Telefono, "
					+ "Correo, Fecha, Altura, Peso) values (?,?,?,?,?,?,?,?)");
			st.setString(1, nombre);
			st.setString(2, apellido);
			st.setString(3, direccion);
			st.setInt(4, telefono);
			st.setString(5, correo);
			st.setString(6, fechaN);
			st.setDouble(7, altura);
			st.setDouble(8, peso);

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
		String apellido;
		String direccion;
		int telefono;
		String correo;
		String fechaN;
		double altura;
		double peso;

		System.out.println("   Ingrese nombre: ");
		System.out.print(" -");
		nombre = sc.next();

		System.out.println("   Ingrese apellido: ");
		System.out.print(" -");
		apellido = sc.next();

		System.out.println("   Ingrese la dirección: ");
		System.out.print(" -");
		direccion = sc.next();

		System.out.println("   Ingrese su número de telefono: ");
		System.out.print(" -");
		telefono = sc.nextInt();

		System.out.println("   Ingrese correo electronico: ");
		System.out.print(" -");
		correo = sc.next();

		System.out.println("   Ingrese su fecha de nacimiento con las siguientes indicaciones:");
		System.out.println("   Debe de ir separado por diagonales y junto día/mes/año ");
		System.out.print(" -");
		fechaN = sc.next();

		System.out.println("Ingrese su altura:");
		System.out.print(" -");
		altura = sc.nextDouble();

		System.out.println("Ingrese su peso:");
		System.out.print(" -");
		peso = sc.nextDouble();

		DatosPostgre conexion = new DatosPostgre();

		conexion.RegistrarDatos(nombre, apellido, direccion, telefono, correo, fechaN, altura, peso);

	}

}
