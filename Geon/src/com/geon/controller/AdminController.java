package com.geon.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geon.domain.Login;
import com.geon.domain.Person;
import com.geon.domain.User;
import com.geon.repository.LoginDb;
import com.geon.repository.UserDao;
import com.geon.repository.Userlist;
import com.geon.service.RandomPassword;
import com.geon.service.SendMail;

public class AdminController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Userlist db;
	private LoginDb ldb;
	private UserDao dao;
	private static String ADMIN = "/usersList.jsp";
	private static String EDIT = "/editUser.jsp";
	private static String INSERT = "/addUser.jsp";

	public AdminController() throws ClassNotFoundException, IOException, SQLException {
		super();
		db = new Userlist();
		ldb = new LoginDb();
		dao = new UserDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		User user = null;
		String action = request.getParameter("action");
		try {
			if (action.equalsIgnoreCase("userslist")) {
				forward = ADMIN;
				request.setAttribute("users", db.getAllRecords());

			} else if (action.equalsIgnoreCase("edit")) {
				forward = EDIT;
				String email = request.getParameter("email");
				user = db.getUserById(email);
				request.setAttribute("user", user);
			} else if (action.equalsIgnoreCase("delete")) {
				forward = ADMIN;
				String Email = request.getParameter("email");
				db.deleteUser(Email);
				request.setAttribute("users", db.getAllRecords());
			} else {
				forward = INSERT;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User u = new User();
		Login l = new Login();
		String FirstName = request.getParameter("firstName");
		u.setFirstName(FirstName);

		String LastName = request.getParameter("lastName");
		u.setLastName(LastName);

		String Email = request.getParameter("email");
		u.setEmail(Email);
		l.setEmail(Email);

		try {
			String dobString = request.getParameter("joiningDate");
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			Date dob = format.parse(dobString);
			u.setJoiningDate(dob);
		} catch (ParseException e) {
			e.printStackTrace();
			String dobString = request.getParameter("joiningDate");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date dob;
			try {
				dob = format.parse(dobString);
				u.setJoiningDate(dob);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		String PhoneNumber = request.getParameter("phoneNumber");
		int Phone = Integer.parseInt(PhoneNumber);
		u.setPhoneNumber(Phone);

		String Experience = request.getParameter("experience");
		int exp = Integer.parseInt(Experience);
		u.setExperience(exp);

		String Education = request.getParameter("education");
		u.setEducation(Education);
		System.out.println(Education);

		String forward = "";
		if (Email == null || Email.isEmpty()) {
			try {

				db.updateUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {

				db.addUser(u);

				SendMail s = new SendMail();
				RandomPassword rp = new RandomPassword();
				String password = rp.getPassword();
				l.setPassword(password);
				s.Sendto(Email, password);
				ldb.userHandle(l);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher(ADMIN);
		try {
			request.setAttribute("users", db.getAllRecords());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
