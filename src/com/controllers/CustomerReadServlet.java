package com.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Account;
import com.beans.Customer;
import com.services.MainService;

/**
 * Servlet implementation class CustomerReadServlet
 */
public class CustomerReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainService service = new MainService();
		HttpSession session = request.getSession();
		String action = (String) session.getAttribute("action");
		String userRole = (String) session.getAttribute("userRole");
		String servletPath = request.getServletPath();
		if(servletPath.contentEquals("/CustomerReadServlet/updateCustomer")) {
			Customer customer = service.findCustomerByStringId(request.getParameter("customerId"));
			session.setAttribute("customer", customer);
			session.setAttribute("accounts", service.findAllAccountsByCustomerId(customer.getId()));
			request.getRequestDispatcher("/jsp/BankPages/UpdateCustomer.jsp").forward(request, response);
		}
		else if(servletPath.contentEquals("/CustomerReadServlet/deleteCustomer")) {
			Customer customer = service.findCustomerByStringId(request.getParameter("customerId"));
			session.setAttribute("customer", customer);
			
			request.getRequestDispatcher("/jsp/BankPages/DeleteCustomer.jsp").forward(request,response);
			
		}
		else if(servletPath.contentEquals("/CustomerReadServlet/customerStatus")) {
			ArrayList<Customer> customers = service.findAllCustomers();
			session.setAttribute("customers", customers);
			
			request.getRequestDispatcher("/jsp/BankPages/CustomersStatusPage.jsp").forward(request,response);
		}
		
		else if(servletPath.contentEquals("/CustomerReadServlet/viewCustomer")) {
			String customerId = (String)request.getParameter("customerId");
			System.out.println(customerId);
			Customer newCustomer = service.findCustomerByStringId(customerId);
			ArrayList<Account> accounts = service.findAllAccountsByCustomerId(customerId);
			session.setAttribute("customer", newCustomer);
			session.setAttribute("accounts", accounts);
			request.getRequestDispatcher("/jsp/BankPages/TellerAccount.jsp").forward(request, response);

		}
		else if(servletPath.contentEquals("/CustomerReadServlet/searchCustomer")) {

			ArrayList<Customer> customers = new ArrayList<Customer> ();
			String searchId = request.getParameter("search-criteria");
			String searchString = request.getParameter("search-text");
			
			switch (searchId) {
			
			case "SSN":
				customers.add(service.findBySsn(searchString));
				
				break;
			case "lastName":
				customers = service.findByLastName(searchString);
				System.out.println(searchString);
				System.out.println("reached lastname");
				break;
			case "customerId":
				customers.add(service.findCustomerByStringId(searchString));
				break;
			case "accountId":
				System.out.println(searchString);
				customers.add(service.findCustomerByAccountId(searchString));
				break;
			}
				
			
			session.setAttribute("customers", customers);
			
			if (userRole.contentEquals("Executive")) {
				request.getRequestDispatcher("/jsp/BankPages/ExecutiveHome.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/jsp/BankPages/TellerHome.jsp").forward(request, response);
			}
		}
		
		else {
			if (action.contentEquals("getCustomers")) {
				ArrayList<Customer> customers = service.displayCustomerService("A");
				session.setAttribute("customers", customers);
				if (userRole.contentEquals("Executive")) {
					request.getRequestDispatcher("/jsp/BankPages/ExecutiveHome.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("/jsp/BankPages/TellerHome.jsp").forward(request, response);
				}
			}
		}
	}

}

