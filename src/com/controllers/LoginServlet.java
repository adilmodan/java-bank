package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.UserDetails;
import com.services.MainService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MainService service = new MainService();
		HttpSession session = request.getSession();
		if(session.getAttribute("userRole") == null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username + " " + password);
//			if (username.contentEquals("user1234") && password.contentEquals("nicedaytoday")) {
//				session.setAttribute("userRole", "executive");
//				request.getRequestDispatcher("/jsp/BankPages/ExecutiveHome.jsp").forward(request, response);
//			}
			
			UserDetails user = service.logInService(username, password); //user:  id, role;// true or false
			if(user != null) {
				session.setAttribute("id", user.getId());
				session.setAttribute("userRole", user.getRole());
				session.setAttribute("action", "getCustomers");
				request.getRequestDispatcher("/CustomerReadServlet").forward(request, response);
			}
			else {
				session.setAttribute("message", "Invalid username or password!");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		else {
			System.out.println("hello");
			session.setAttribute("action", "getCustomers");
			request.getRequestDispatcher("/CustomerReadServlet").forward(request, response);
		}
	}

}