package br.com.webapp.domain.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:postgresql://localhost/webapp";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "11081977";

	public static Connection getConnection() {

		try {

			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(URL, USUARIO, SENHA);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		return null;
	}

}
