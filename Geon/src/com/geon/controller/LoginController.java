package com.geon.controller;

import java.io.IOException;

import java.sql.SQLException;
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

public class LoginController extends HttpServlet {

	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;
	private LoginDb ldb;
	private UserDao dao;
	private Userlist db;

	private static String HOME = "/home.jsp";
	private static String LIST_USER = "/complaintList.jsp";

	public LoginController() throws ClassNotFoundException, IOException, SQLException {
		super();
		ldb = new LoginDb();
		dao = new UserDao();
		db = new Userlist();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login l = new Login();

		String forward = "";
		try {
			String Email = request.getParameter("email");
			System.out.println(Email);
			l.setEmail(Email);

			String Password = request.getParameter("password");
			System.out.println(Password);
			l.setPassword(Password);

			l = ldb.handle(Email, Password);

			String Role = l.getRole();

			if (Role != null && Role.equals("ROLE_ADMIN")) {

				System.out.println("Admin");
				request.setAttribute("home", l);
				forward = HOME;
			} else {
				System.out.println("User");
				String email = l.getEmail();
				User u = db.getUserById(email);
				List<Person> comp = dao.userComplaints(u.getFirstName());
				request.setAttribute("complaints", comp);
				forward = LIST_USER;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse reponse) {

	}
}
