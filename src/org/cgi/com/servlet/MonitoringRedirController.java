package org.cgi.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MonitoringRedirController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5504184555079283987L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("from  MonitoringRedirController ");
		request.setAttribute("promoConfigs",AutoDiscallController.getPromoDetails() );
		request.getRequestDispatcher("/monitoring.jsp").forward(request, response);
	}

}
