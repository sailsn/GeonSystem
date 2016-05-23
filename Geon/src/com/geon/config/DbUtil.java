package com.geon.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	private static Connection connection = null;

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		try {
			Properties prop = new Properties();
			File file = new File("D:\\Supportportal\\Geon\\src\\db.properties");
			FileInputStream inputstream = new FileInputStream(file);
			prop.load(inputstream);
			String driver = prop.getProperty("driver");

			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String Password = prop.getProperty("password");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, Password);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
