package com.geon.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geon.domain.Person;
import com.geon.domain.User;
import com.geon.repository.UserDao;
import com.geon.repository.Userlist;

//contains the Servlets
public class UserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao dao;
	private Userlist db;

	// private static String FORWARD_USER = "/user.jsp";
	private static String RESOLVED = "/resolved.jsp";
	private static String LIST_USER = "/complaintList.jsp";
	private static String INSERT_OR_EDIT = "/addComplaint.jsp";
	private static String DISPLAY = "/display.jsp";
	private static String ADMIN = "/admin.jsp";

	public UserController() throws ClassNotFoundException, SQLException, IOException {
		super();
		dao = new UserDao();
		db = new Userlist();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		try {
			// DELETE OPERATION
			if (action.equalsIgnoreCase("delete")) {
				int TicketRefNumber = Integer.parseInt(request.getParameter("TicketRefNumber"));
				dao.deleteUser(TicketRefNumber);
				forward = LIST_USER;
				request.setAttribute("users", dao.getAllUsers());
			}
			// else if (action.equalsIgnoreCase("Edit")) {// EDIT OPERATION
			// forward = INSERT_OR_EDIT;
			// Person user = dao.getUserById(TicketRefNumber);
			// request.setAttribute("user", user);
			// }
			else if (action.equalsIgnoreCase("complaintlist")) {// LIST OF
				// COMPLAINTS

				forward = LIST_USER;
				request.setAttribute("complaints", dao.complaints());

			} else if (action.equalsIgnoreCase("resolved")) {// RESOLVED
																// COMPLAINTS
				forward = RESOLVED;
				request.setAttribute("resolved", dao.resolvedStatus());
			}

			else if (action.equalsIgnoreCase("insert")) {

				forward = INSERT_OR_EDIT;
				int nextNumber = dao.getRecords();
				List<User> allUsers = db.getAllRecords();

				List<String> s = new ArrayList<String>();
				for (User u : allUsers) {
					String FirstName = u.getFirstName();
					String LastName = u.getLastName();
					s.add(FirstName);
//					FirstName = FirstName.concat( u.getLastName());
//					System.out.println(FirstName);
//					s.add(FirstName);
					System.out.println(s);
					
				}
				request.setAttribute("assignees", s);
				request.setAttribute("TicketRefNumber", nextNumber);
			} else if (action.equalsIgnoreCase("display")) {
				forward = DISPLAY;

				int TicketRefNumber = Integer.parseInt(request.getParameter("TicketRefNumber"));
				Person user = dao.getUserById(TicketRefNumber);
				ArrayList<Person> a = new ArrayList<Person>();
				a.add(user);

				request.setAttribute("users", a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Person user = new Person();
			String CompanyName = request.getParameter("CompanyName");
			user.setCompanyName(CompanyName);
			System.out.println(request.getParameter("CompanyName"));
			String CustomerName = request.getParameter("CustomerName");
			user.setCustomerName(CustomerName);
			user.setEmail(request.getParameter("Email"));
			String ForwardEmail = request.getParameter("ForwardedEmail");
			user.setForwardedEmail(ForwardEmail);
			user.setIssueDescription(request.getParameter("IssueDescription"));
			user.setRemarks(request.getParameter("Remarks"));
			user.setSeverity(request.getParameter("Range"));
			user.setSupportCategory(request.getParameter("SupportCategory"));
			user.setWarrantyStatus(request.getParameter("status"));
			user.setPhoneNumber(Integer.parseInt(request.getParameter("PhoneNumber")));
			String Assignee = request.getParameter("assignee");
			user.setAssignee(Assignee);
			String TicketRefNumber = request.getParameter("TicketRefNumber");
			if (TicketRefNumber == null || TicketRefNumber.isEmpty()) {
				user.setTicketRefNumber(Integer.parseInt(TicketRefNumber));
				dao.updateUser(user);
			} else {
				dao.addUser(user);
				dao.Send(TicketRefNumber, ForwardEmail, CustomerName);

			}

			RequestDispatcher view = request.getRequestDispatcher(LIST_USER);

			request.setAttribute("users", dao.getAllUsers());
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
