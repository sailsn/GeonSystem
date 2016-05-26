package com.geon.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geon.domain.Login;
import com.geon.repository.LoginDb;

public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginDb ldb;
	private static String HOME = "/home.jsp";

	public LoginController() throws ClassNotFoundException, IOException, SQLException {
		super();
		ldb = new LoginDb();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login l = new Login();
		String forward = "";
		try {
			//String FirstName = request.getParameter("");
			String Email = request.getParameter("email");
			System.out.println(Email);
			l.setEmail(Email);

			String Password = request.getParameter("password");
			System.out.println(Password);
			l.setPassword(Password);

			l=ldb.handle(Email, Password);
			
			String Role = l.getRole();
			
			if (Role != null ) {

				System.out.println("Admin");
				request.setAttribute("home", l);
				forward = HOME;

			} else {
				System.out.println("User");
				request.setAttribute("home", ldb.userHandle(l));
				
				forward = HOME;
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
