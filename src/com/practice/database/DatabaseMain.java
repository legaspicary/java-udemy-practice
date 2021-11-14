package com.practice.database;

import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMain {
	public static void main(String[] args) {
//		connectionDemo();
//		loopingResultsDemo();
		DataSource dataSource = new DataSource();
		if (!dataSource.open())
			return;
		dataSource.insertArtist("Cary cary!");
		for (Artist a : dataSource.queryArtists()) {
			System.out.println(a.getId() + " " + a.getName());
		}
	}

	public static void loopingResultsDemo() {
		String projectDirectory = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
		String jdbcUrl = "jdbc:sqlite:" + projectDirectory + "\\testjava.db";
		System.out.println(jdbcUrl);
		try (Connection connection = DriverManager.getConnection(jdbcUrl);
				Statement statement = connection.createStatement();) {
			statement.execute("SELECT * FROM contacts");
			@SuppressWarnings("resource")
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name") + " " + resultSet.getInt("phone") + " "
						+ resultSet.getString("email"));
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong: " + e.getMessage());
		}
	}

	public static void connectionDemo() {
		String projectDirectory = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
		String jdbcUrl = "jdbc:sqlite:" + projectDirectory + "\\testjava.db";
		System.out.println(jdbcUrl);
		try (Connection connection = DriverManager.getConnection(jdbcUrl);
				Statement statement = connection.createStatement();) {
			connection.setAutoCommit(false);
			statement.execute("CREATE TABLE IF NOT EXISTS contacts(name TEXT, phone INTEGER, email TEXT)");
			statement.execute("INSERT INTO contacts(name, phone, email) VALUES('Cary3', 12345, 'test@test.com')");
			statement.execute("DELETE FROM contacts WHERE name='Cary1'");
			connection.commit();
		} catch (SQLException e) {
			System.out.println("Something went wrong: " + e.getMessage());
		}
	}
}
