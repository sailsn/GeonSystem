package com.geon.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.geon.config.DbUtil;
import com.geon.domain.Login;

public class LoginDb {

	private Connection connection;

	public LoginDb() throws ClassNotFoundException, IOException, SQLException {
		connection = DbUtil.getConnection();
	}

	public Login handle(String email, String password) throws SQLException {

		Statement stmt = connection.createStatement();
		String getQuery = "SELECT `email`, `password`, `role` FROM `login` WHERE email = '" + email
				+ "' and password = '" + password + "'";
		ResultSet rs = stmt.executeQuery(getQuery);
		Login l = new Login();
		while (rs.next()) {

			l.setEmail(rs.getString("email"));

			//System.out.println(rs.getString("email"));
			l.setPassword(rs.getString("password"));
			//System.out.println(password);
			l.setRole(rs.getString("role"));
			//System.out.println("role");

		}
		return l;
	}
	public Login userHandle(Login l) throws SQLException
	{
		try
		{
		
		String userRecord = "INSERT INTO `login`(`email`, `password`, `role`) VALUES (?,?,?)";
		PreparedStatement preparedstatement = connection.prepareStatement(userRecord);
		preparedstatement.setString(1, l.getEmail());
		preparedstatement.setString(2, l.getPassword());
		preparedstatement.setString(3, "USER");
		preparedstatement.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
		
		
		
	}

}
