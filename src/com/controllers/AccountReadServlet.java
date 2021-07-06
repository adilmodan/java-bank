package com.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Account;
import com.services.MainService;

/**
 * Servlet implementation class AccountReadServlet
 */
public class AccountReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MainService service = new MainService();
		HttpSession session = request.getSession();
		String action = (String) session.getAttribute("action");
		String userRole = (String) session.getAttribute("userRole");
		String servletPath = request.getServletPath();
		doGet(request, response);
		
		if(servletPath.equals("/AccountReadServlet/accountStatus")) {
			ArrayList <Account> accounts = service.findAllAccounts();
			session.setAttribute("accounts", accounts);
			
			request.getRequestDispatcher("/jsp/BankPages/AccountStatus.jsp").forward(request,response);
		}
		
	}

}
