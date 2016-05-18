package com.geon.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geon.domain.User;
import com.geon.repository.Userlist;

public class AdminController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Userlist db;
	private static String ADMIN = "/usersList.jsp";
	private static String EDIT = "/editUser.jsp";

	public AdminController() throws ClassNotFoundException, IOException, SQLException {
		super();
		db = new Userlist();
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
			} else if(action.equalsIgnoreCase("delete"))
			{
				forward = ADMIN;
				String Email = request.getParameter("email");
				db.deleteUser(Email);
				request.setAttribute("users", db.getAllRecords());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		User u = new User();

		String FirstName = request.getParameter("firstName");
		u.setFirstName(FirstName);

		String LastName = request.getParameter("lastName");
		u.setLastName(LastName);

		String Email = request.getParameter("email");
		u.setEmail(Email);

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
		
		if(Email==null || Email.isEmpty())
		{
			try {
				db.addUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else 
		{
			try {
				db.updateUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		

	}

}
