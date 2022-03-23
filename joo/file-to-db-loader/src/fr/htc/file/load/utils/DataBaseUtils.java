package fr.htc.file.load.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtils {

	public static Connection getConnection() {
		try (Connection conn = 
				DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {

			if (conn != null) {
				System.out.println("Connected to the database!");
				return conn;
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
