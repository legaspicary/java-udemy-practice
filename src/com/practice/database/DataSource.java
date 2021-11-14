package com.practice.database;

import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
	public static final String DB_NAME = "music.db";
	public static final String CURRENT_DIR = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
	public static final String CONNECTION_STRING = "jdbc:sqlite:" + CURRENT_DIR + "\\" + DB_NAME;

	public static final String INSERT_ARTIST = "INSERT INTO artists(name) VALUES(?)";
	public static final String QUERY_ARTIST = "SELECT * FROM artists WHERE name=?";
	private PreparedStatement queryArtistStatement;
	private PreparedStatement insertArtistStatement;

	private Connection conn;

	public int insertArtist(String name) {
		try {
			queryArtistStatement = conn.prepareStatement(QUERY_ARTIST);
			queryArtistStatement.setString(1, name);
			ResultSet resultQuery = queryArtistStatement.executeQuery();
			if (resultQuery.next()) {
				return resultQuery.getInt(1);
			}
			insertArtistStatement = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
			insertArtistStatement.setString(1, name);
			int affectedRows = insertArtistStatement.executeUpdate();
			if (affectedRows != 1)
				throw new SQLException("Failed to insert artist");
			ResultSet generatedResultSet = insertArtistStatement.getGeneratedKeys();
			return generatedResultSet.getInt(1);
		} catch (SQLException e) {
			System.out.println("Error occured when trying to insert artist: " + e.getMessage());
		}
		return -1;

	}

	public List<Artist> queryArtists() {
		List<Artist> artists = new ArrayList<>();

		try (Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Artist.TABLE_NAME);) {

			while (resultSet.next()) {
				Artist artist = new Artist();
				artist.setId(resultSet.getInt(Artist.COL_ID));
				artist.setName(resultSet.getString(Artist.COL_NAME));
				artists.add(artist);
			}

		} catch (SQLException e) {
			System.out.println("Query failed: " + e.getMessage());
		}

		return artists;
	}

	public boolean open() {
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING);
			return true;
		} catch (SQLException e) {
			System.out.println("Couldn't connect to database: " + e.getMessage());
			return false;
		}
	}

	public boolean close() {
		try {
			if (queryArtistStatement != null) {
				queryArtistStatement.close();
			}
			if (insertArtistStatement != null) {
				insertArtistStatement.close();
			}
			if (conn != null) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Couldn't close connection: " + e.getMessage());
		}
		return false;
	}
}
