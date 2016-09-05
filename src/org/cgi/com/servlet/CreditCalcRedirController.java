package org.cgi.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreditCalcRedirController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8752994157142836549L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("from  CreditCalcRedirController ");
		request.setAttribute("promoConfigs",AutoDiscallController.getPromoDetails() );
		request.getRequestDispatcher("/CreditCalc.jsp").forward(request, response);
	}

}
