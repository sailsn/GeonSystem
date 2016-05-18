package com.geon.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.geon.config.DbUtil;
import com.geon.domain.Person;

//contains the logic for database operation
public class UserDao {

	private Connection connection;

	public UserDao() throws ClassNotFoundException, IOException, SQLException {
		connection = DbUtil.getConnection();
	}

	public void addUser(Person user) throws SQLException {

		try {

			/*
			 * String strQry =
			 * "INSERT INTO `complaintregistration`(`CustomerName`, `Severity`, `CompanyName`, `Email`, `Warranty status`, `SupportCategory`, `Issue Description`, `Forwarded Email`, `Remarks`, `PhoneNumber`, `TicketRefNumber`) VALUES ('"
			 * + user.getCustomerName() + "','" + user.getSeverity() + "','" +
			 * user.getCompanyName() + "','" + user.getEmail() + "','" +
			 * user.getWarrantyStatus() + "','" + user.getSupportCategory() +
			 * "','" + user.getIssueDescription() + "','" +
			 * user.getForwardedEmail() + "','" + user.getRemarks() + "','" +
			 * user.getPhoneNumber() + "','" + user.getTicketRefNumber() + "'";
			 */
			String strQry = "INSERT INTO `complaintregistration`(`CustomerName`, `Severity`, `CompanyName`, `Email`, `Warrantystatus`, `SupportCategory`, `IssueDescription`, `ForwardedEmail`, `Remarks`, `PhoneNumber`, `TicketRefNumber`, `status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedstatement = connection.prepareStatement(strQry);
			preparedstatement.setString(1, user.getCustomerName());
			preparedstatement.setString(2, user.getSeverity());
			preparedstatement.setString(3, user.getCompanyName());
			preparedstatement.setString(4, user.getEmail());
			preparedstatement.setString(5, user.getWarrantyStatus());
			preparedstatement.setString(6, user.getSupportCategory());
			preparedstatement.setString(7, user.getIssueDescription());
			preparedstatement.setString(8, user.getForwardedEmail());
			preparedstatement.setString(9, user.getRemarks());
			preparedstatement.setInt(10, user.getPhoneNumber());
			preparedstatement.setLong(11, user.getTicketRefNumber());
			preparedstatement.setString(12, "new");
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int TicketRefNumber) throws SQLException {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"DELETE FROM `complaintregistration` WHERE `TicketRefNumber`='" + TicketRefNumber + "'");
			preparedstatement.setInt(1, TicketRefNumber);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(Person user) throws SQLException {
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("UPDATE `complaintregistration` SET `CustomerName`='" + user.getCustomerName()
							+ "',`Severity`='" + user.getSeverity() + "',`CompanyName`='" + user.getCompanyName()
							+ "',`Email`='" + user.getEmail() + "',`Warranty status`='" + user.getWarrantyStatus()
							+ "',`SupportCategory`='" + user.getSupportCategory() + "',`Issue Description`='"
							+ user.getIssueDescription() + "',`Forwarded Email`='" + user.getForwardedEmail()
							+ "',`Remarks`='" + user.getRemarks() + "',`PhoneNumber`='" + user.getPhoneNumber()
							+ "',`TicketRefNumber`='" + user.getTicketRefNumber() + "' WHERE `TicketRefNumber`='"
							+ user.getTicketRefNumber() + "'");
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Person> getAllUsers() throws SQLException {
		List<Person> users = new ArrayList<Person>();
		try {
			Statement stmt = connection.createStatement();
			String allusers = "SELECT * FROM `complaintregistration` WHERE NOT status = 'resolved'";

			ResultSet rs = stmt.executeQuery(allusers);

			while (rs.next()) {
				Person user = new Person();
				user.setCompanyName(rs.getString("CompanyName"));
				System.out.println(rs.getString("CompanyName"));

				user.setCustomerName(rs.getString("CustomerName"));
				System.out.println(rs.getString("CustomerName"));
				user.setEmail(rs.getString("Email"));
				System.out.println(rs.getString("Email"));
				user.setForwardedEmail(rs.getString("ForwardedEmail"));
				System.out.println(rs.getString("ForwardedEmail"));
				user.setIssueDescription(rs.getString("IssueDescription"));
				System.out.println(rs.getString("IssueDescription"));
				user.setPhoneNumber(rs.getInt("PhoneNumber"));
				System.out.println(rs.getInt("PhoneNumber"));
				user.setRemarks(rs.getString("Remarks"));
				System.out.println(rs.getString("Remarks"));
				user.setSeverity(rs.getString("Severity"));
				System.out.println(rs.getString("Severity"));
				user.setSupportCategory(rs.getString("SupportCategory"));
				System.out.println(rs.getString("SupportCategory"));
				user.setTicketRefNumber(rs.getInt("TicketRefNumber"));
				user.setWarrantyStatus(rs.getString("Warrantystatus"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<Person> complaints() {
		List<Person> users = new ArrayList<Person>();
		try {
			Statement stmt = connection.createStatement();
			String allusers = "SELECT * FROM `complaintregistration` WHERE NOT status = 'resolved'";

			ResultSet rs = stmt.executeQuery(allusers);

			while (rs.next()) {
				Person user = new Person();
				user.setCompanyName(rs.getString("CompanyName"));
				System.out.println(rs.getString("CompanyName"));

				user.setCustomerName(rs.getString("CustomerName"));
				System.out.println(rs.getString("CustomerName"));
				user.setEmail(rs.getString("Email"));
				System.out.println(rs.getString("Email"));
				user.setForwardedEmail(rs.getString("ForwardedEmail"));
				System.out.println(rs.getString("ForwardedEmail"));
				user.setIssueDescription(rs.getString("IssueDescription"));
				System.out.println(rs.getString("IssueDescription"));
				user.setPhoneNumber(rs.getInt("PhoneNumber"));
				System.out.println(rs.getInt("PhoneNumber"));
				user.setRemarks(rs.getString("Remarks"));
				System.out.println(rs.getString("Remarks"));
				user.setSeverity(rs.getString("Severity"));
				System.out.println(rs.getString("Severity"));
				user.setSupportCategory(rs.getString("SupportCategory"));
				System.out.println(rs.getString("SupportCategory"));
				user.setTicketRefNumber(rs.getInt("TicketRefNumber"));
				user.setWarrantyStatus(rs.getString("Warrantystatus"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

	public Person getUserById(int TicketRefNumber) throws SQLException {
		Person user = new Person();
		PreparedStatement preparedstatement = connection.prepareStatement(
				"SELECT * FROM `complaintregistration` WHERE `TicketRefNumber` = '" + TicketRefNumber + "'");

		ResultSet rs = preparedstatement.executeQuery();
		if (rs.next()) {
			user.setCompanyName(rs.getString("CompanyName"));
			user.setCustomerName(rs.getString("CustomerName"));
			user.setEmail(rs.getString("Email"));
			user.setForwardedEmail(rs.getString("ForwardedEmail"));
			user.setIssueDescription(rs.getString("IssueDescription"));
			user.setPhoneNumber(rs.getInt("PhoneNumber"));
			user.setRemarks(rs.getString("Remarks"));
			user.setSeverity(rs.getString("Severity"));
			user.setSupportCategory(rs.getString("SupportCategory"));
			user.setTicketRefNumber(rs.getInt("TicketRefNumber"));
			user.setWarrantyStatus(rs.getString("WarrantyStatus"));
			user.setStatus(rs.getString("status"));
		}
		return user;
	}

	public List<Person> resolvedStatus() throws SQLException {

		List<Person> users = new ArrayList<Person>();
		try {
			Statement stmt = connection.createStatement();
			String allusers = "SELECT * FROM `complaintregistration` WHERE `status`= 'resolved'";

			ResultSet rs = stmt.executeQuery(allusers);

			while (rs.next()) {
				Person user = new Person();
				user.setCompanyName(rs.getString("CompanyName"));
				System.out.println(rs.getString("CompanyName"));

				user.setCustomerName(rs.getString("CustomerName"));
				System.out.println(rs.getString("CustomerName"));
				user.setEmail(rs.getString("Email"));
				System.out.println(rs.getString("Email"));
				user.setForwardedEmail(rs.getString("ForwardedEmail"));
				System.out.println(rs.getString("ForwardedEmail"));
				user.setIssueDescription(rs.getString("IssueDescription"));
				System.out.println(rs.getString("IssueDescription"));
				user.setPhoneNumber(rs.getInt("PhoneNumber"));
				System.out.println(rs.getInt("PhoneNumber"));
				user.setRemarks(rs.getString("Remarks"));
				System.out.println(rs.getString("Remarks"));
				user.setSeverity(rs.getString("Severity"));
				System.out.println(rs.getString("Severity"));
				user.setSupportCategory(rs.getString("SupportCategory"));
				System.out.println(rs.getString("SupportCategory"));
				user.setTicketRefNumber(rs.getInt("TicketRefNumber"));
				user.setWarrantyStatus(rs.getString("Warrantystatus"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

	public int getRecords() throws SQLException {
		List<Person> users = new ArrayList<Person>();
		Statement stmt = connection.createStatement();
		String allusers = "SELECT TicketRefNumber FROM `complaintregistration`";

		ResultSet rs = stmt.executeQuery(allusers);
		int i = 0;

		while (rs.next()) {
			if (rs.isLast()) {
				i = rs.getInt(1);
			}

		}

		return i;
	}

	//
	// public int getRecord() throws SQLException
	// {
	// List<Person> users = new ArrayList<Person>();
	// Statement stmt = connection.createStatement();
	// String user = "SELECT * FROM `complaintregistration` WHERE
	// `TicketRefNumber`= ";
	//
	// }
	public void Send(String ticketRefNumber, String ForwardEmail, String CustomerName)
			throws AddressException, MessagingException {

		String from = "testingtheis@gmail.com";
		String password = "lsnworks";
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// SmtpAuthenticator authentication = new SmtpAuthenticator();

		Session session = Session.getDefaultInstance(properties);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(ForwardEmail));
		message.setSubject("TICKET REFERENCE NUMBER");
		message.setText("Take this Ticket RefNumber then give the support for this complaint");

		String Emailbody = "Hi " + CustomerName + ",<br>Thank you for contacting Geon <br> We have logged a Ticket # "
				+ ticketRefNumber
				+ " for your reference. <br>One of our agents will be in touch with you shortly. <br> You can track your Order transaction status here:<p><a href='http://localhost:8080/Geon/UserController?action=display&TicketRefNumber="
				+ ticketRefNumber + "'>Click Here</a></p> <br> Thanks & Regards,<br><b>D.V.SAIKUMAR</b>   ";
		message.setContent(Emailbody, "text/html");

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, password);

		transport.sendMessage(message, message.getAllRecipients());

		transport.close();
	}

}
