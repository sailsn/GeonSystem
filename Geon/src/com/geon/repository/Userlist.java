package com.geon.repository;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.geon.config.DbUtil;

import com.geon.domain.User;

public class Userlist {

	private Connection connection;

	public Userlist() throws ClassNotFoundException, IOException, SQLException {
		connection = DbUtil.getConnection();
	}

	public void addUser(User u) throws SQLException {
		String adduser = "INSERT INTO `users`(`firstName`, `lastName`, `email`, `joiningDate`, `phoneNumber`, `experience`, `education`) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement preparedstatement = connection.prepareStatement(adduser);
		preparedstatement.setString(1, u.getFirstName());
		preparedstatement.setString(2, u.getLastName());
		preparedstatement.setString(3, u.getEmail());
		java.sql.Date sqlDate = new java.sql.Date(u.getJoiningDate().getTime());
		preparedstatement.setDate(4, sqlDate);
		preparedstatement.setInt(5, u.getPhoneNumber());
		preparedstatement.setLong(6, u.getExperience());
		preparedstatement.setString(7, u.getEducation());

		preparedstatement.executeUpdate();
	}

	public User getUserById(String email) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM `users` WHERE email ='" + email + "'");
			// preparedStatement.setString(3, email);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setJoiningDate(rs.getDate("joiningDate"));
				user.setExperience(rs.getInt("experience"));
				user.setEducation(rs.getString("education"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<User> getAllRecords() throws SQLException {

		List<User> l = new ArrayList<User>();
		try {

			Statement statement = connection.createStatement();

			String allUsers = "SELECT * FROM `users`";

			ResultSet rs = statement.executeQuery(allUsers);

			while (rs.next()) {
				User d = new User();

				d.setFirstName(rs.getString("firstName"));
				System.out.println(rs.getString("firstName"));

				d.setLastName(rs.getString("lastName"));
				System.out.println(rs.getString("lastName"));

				d.setEmail(rs.getString("email"));
				System.out.println(rs.getString("email"));

				d.setJoiningDate(rs.getDate("joiningDate"));
				System.out.println(rs.getString("joiningDate"));

				d.setPhoneNumber(rs.getInt("phoneNumber"));
				System.out.println(rs.getString("phoneNumber"));

				d.setExperience(rs.getInt("experience"));
				System.out.println(rs.getString("experience"));

				d.setEducation(rs.getString("education"));
				System.out.println(rs.getString("education"));

				l.add(d);

			}
		} catch (Exception e) {
			System.out.println();
		}
		return l;

	}

	public void updateUser(User  user) throws SQLException {
		java.sql.Date sqlDate = new java.sql.Date(user.getJoiningDate().getTime());
		try
		{
		String updateQuery = "UPDATE `users` SET `firstName`='" + user.getFirstName() + "',`lastName`= '"
				+ user.getLastName() + "',`email`= '" + user.getEmail() + "',`joiningDate`= '" + sqlDate
				+ "',`phoneNumber`='" + user.getPhoneNumber() + "',`experience`= '" + user.getExperience()
				+ "',`education`='" + user.getEducation() + "' WHERE `email`='" + user.getEmail() + "'";
		PreparedStatement preparedstatement = connection.prepareStatement(updateQuery);
		preparedstatement.executeUpdate();
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void deleteUser(String email) throws SQLException {
		
		String deleteQuery = "DELETE FROM `users` WHERE `email` = '"+email+"'";
		PreparedStatement preparedstatement = connection.prepareStatement(deleteQuery);
		preparedstatement.executeUpdate();
		
	}
}
