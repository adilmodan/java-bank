package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.beans.Customer;
import com.services.MainService;

/**
 * Servlet implementation class CustomerWriteServlet
 */
public class CustomerWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerWriteServlet() {
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
		MainService service = new MainService();
		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		Customer newCustomer = null;
		
		if (servletPath.contentEquals("/CustomerWriteServlet/createCustomer")) {
			newCustomer = constructCustomer(request);
			newCustomer = service.saveCustomer(newCustomer);
			if(newCustomer != null) {
				session.setAttribute("customer", service.findBySsn(newCustomer.getSsn()));
				request.getRequestDispatcher("/jsp/BankPages/UpdateCustomer.jsp").forward(request, response);
			}
			else {
				session.setAttribute("operationResult", "Customer was not added!!");
				request.getRequestDispatcher("/jsp/BankPages/CreateCustomer.jsp").forward(request, response);
			}
		}
		
		else if (servletPath.contentEquals("/CustomerWriteServlet/updateCustomer")) {
			newCustomer = constructCustomer(request);
			newCustomer.setId(request.getParameter("customer_id"));
			System.out.println(newCustomer);
			Customer updatedCustomer = service.updateCustomer(newCustomer);
			if(updatedCustomer != null) {
				session.setAttribute("customer", updatedCustomer);
				session.setAttribute("operationResult", "Customer was updated successfully!!");
			}
			else {
				session.setAttribute("customer", newCustomer);
				session.setAttribute("operationResult", "Customer was not updated!!");
			}
			
			request.getRequestDispatcher("/jsp/BankPages/UpdateCustomer.jsp").forward(request, response);
		}
		
		else if(servletPath.contentEquals("/CustomerWriteServlet/deleteCustomer")) {
			String deleteId = request.getParameter("customerID");
			service.deleteCustomer(deleteId);
			
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
	}
	
	public Customer constructCustomer(HttpServletRequest request) {
		Customer newCustomer = new Customer();
		newCustomer.setFirstName(request.getParameter("firstName"));
		newCustomer.setLastName(request.getParameter("lastName"));
		newCustomer.setSsn(request.getParameter("SSN"));
		newCustomer.setDob(request.getParameter("dob"));
		newCustomer.setAddress1(request.getParameter("addressLine1"));
		newCustomer.setAddress2(request.getParameter("addressLine2"));
		newCustomer.setCity(request.getParameter("city"));
		newCustomer.setState(request.getParameter("state"));
		newCustomer.setZip(request.getParameter("zipCode"));
		return newCustomer;
	}
}