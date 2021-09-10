package edu.uspg.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.uspg.conexion.IConexion;

public class SQLServer implements IConexion {

	String connectionUrl = "jdbc:sqlserver://yourserver.database.windows.net:1433;" + "database=AdventureWorks;"
			+ "user=yourusername@yourserver;" + "password=yourpassword;" + "encrypt=true;"
			+ "trustServerCertificate=false;" + "loginTimeout=30;";

	String insertSql = "INSERT INTO SalesLT.Product (Name, ProductNumber, Color, StandardCost, ListPrice, SellStartDate) VALUES "
			+ "('NewBike', 'BikeNew', 'Blue', 50, 120, '2016-01-01');";

	ResultSet resultSet = null;

	try(
	Connection connection = DriverManager.getConnection(connectionUrl);
	PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);)
	{

		prepsInsertProduct.execute();
		// Retrieve the generated key from the insert.
		resultSet = prepsInsertProduct.getGeneratedKeys();

		// Print the ID of the inserted row.
		while (resultSet.next()) {
			System.out.println("Generated: " + resultSet.getString(1));
		}
	}
	// Handle any errors that may have occurred.
	catch(
	Exception e)
	{
		e.printStackTrace();
	}
}

}
