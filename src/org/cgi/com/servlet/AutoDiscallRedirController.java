package org.cgi.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoDiscallRedirController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4548709143870289447L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("from  AutoDiscallRedirController ");
		request.setAttribute("promoConfigs",AutoDiscallController.getPromoDetails() );
		request.getRequestDispatcher("/autodiscall.jsp").forward(request, response);
	}

}
