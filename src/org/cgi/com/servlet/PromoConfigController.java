package org.cgi.com.servlet;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.cgi.com.dao.PromoConfigDAO;
import org.cgi.com.model.PromoConfig;

/**
 * Servlet implementation class PromoConfig
 */
public class PromoConfigController extends HttpServlet {

	
	private static final long serialVersionUID = 2596487098871719352L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Start Calling doPost() in PromoConfigController...");
		PromoConfigDAO service = new PromoConfigDAO();

		try{
		
		PromoConfig promoConfig = new PromoConfig();
		
		if(request.getParameter("promoationId") != null) {
			promoConfig.setPromotionId(request.getParameter("promoationId"));
		}
		
		if(request.getParameter("articleNo") != null) {
			promoConfig.setArticleNo(request.getParameter("articleNo"));
		}
		
		if(!"".equals(request.getParameter("promoationSubsAdjId")) && request.getParameter("promoationSubsAdjId") != null) {
			promoConfig.setPromoationSubsAdjId(Integer.parseInt(request.getParameter("promoationSubsAdjId")));
		}
		
		if(request.getParameter("promoName") != null) {
			promoConfig.setPromoName(request.getParameter("promoName"));
		}
		
		if(request.getParameter("promoStartDate") != null) {
			
			Date startDate = PromoConfigController.convertToDate(request.getParameter("promoStartDate"));
			promoConfig.setPromoStartDate(startDate);
		}
		
		if(request.getParameter("promoEndDate") != null && (!"".equals(request.getParameter("promoEndDate")))) {
			Date endDate = PromoConfigController.convertToDate(request.getParameter("promoEndDate"));
			promoConfig.setPromoEndDate(endDate);
		}
		
		if(request.getParameter("promoQualEndDate") != null && (!"".equals(request.getParameter("promoQualEndDate")))) {
			Date promoQualEndDate = PromoConfigController.convertToDate(request.getParameter("promoQualEndDate"));
			promoConfig.setPromoQualEndDate(promoQualEndDate);
		}

		if(request.getParameter("promoDecomEndDate") != null && (!"".equals(request.getParameter("promoDecomEndDate")))) {
			Date promoDecomEndDate = PromoConfigController.convertToDate(request.getParameter("promoDecomEndDate"));
			promoConfig.setPromoDecomDate(promoDecomEndDate);
		}
		
		if(request.getParameter("ledgerDescEn") != null) {
			promoConfig.setLedgerDescEn(request.getParameter("ledgerDescEn"));
		}
		
		if(request.getParameter("ledgerDescFr") != null) {
			promoConfig.setLedgerDescFr(request.getParameter("ledgerDescFr"));
		}
		
		if(request.getParameter("csgServiceCD") != null) {
			promoConfig.setCsgServiceCD(request.getParameter("csgServiceCD"));
		}
		
		if(request.getParameter("csgReasonCD") != null) {
			promoConfig.setCsgReasonCD(request.getParameter("csgReasonCD"));
		}
		
		if(request.getParameter("exclPermDiscInd") != null) {
			promoConfig.setExclPermDiscInd(request.getParameter("exclPermDiscInd"));
		}
		
		if(request.getParameter("promoNameEn") != null) {
			promoConfig.setPromoNameEn(request.getParameter("promoNameEn"));
		}
		
		if(request.getParameter("promoNameFr") != null) {
			promoConfig.setPromoNameFr(request.getParameter("promoNameFr"));
		}
		
		if(request.getParameter("promoDescEn") != null) {
			promoConfig.setPromoDescEn(request.getParameter("promoDescEn"));
		}
		
		if(request.getParameter("promoDescFr") != null) {
			promoConfig.setPromoDescFr(request.getParameter("promoDescFr"));
		}
		
		if(request.getParameter("multiQualAllowedOneVu") != null) {
			promoConfig.setMultiQualAllowedOneVu(request.getParameter("multiQualAllowedOneVu"));
		}

		if(request.getParameter("promoCategory") != null) {
			promoConfig.setPromoCategory(request.getParameter("promoCategory"));
		}
		
		if(request.getParameter("promoCreditType") != null) {
			promoConfig.setPromoCreditType(request.getParameter("promoCreditType"));
		}
		
		if(request.getParameter("forceCreditONTPS") != null) {
			promoConfig.setForceCreditONTPS(request.getParameter("forceCreditONTPS"));
		}
	
		if(request.getParameter("globalForceQualInd") != null) {
			promoConfig.setGlobalForceQualInd(request.getParameter("globalForceQualInd"));
		}
		
		if(request.getParameter("globalForceDisqInd") != null) {
			promoConfig.setGlobalForceDisqInd(request.getParameter("globalForceDisqInd"));
		}
		
		if(request.getParameter("firstCreditBY") != null) {
			promoConfig.setFirstCreditBY(request.getParameter("firstCreditBY"));
		}
		
		if(request.getParameter("creditCalcType") != null) {
			promoConfig.setCreditCalcType(request.getParameter("creditCalcType"));
		}
		
		if(request.getParameter("qspInitialSetupInd") != null) {
			promoConfig.setQspInitialSetupInd(request.getParameter("qspInitialSetupInd"));
		}
		
		
		if(request.getParameter("disqualProcessInd") != null) {
			String disqualProcessInd = request.getParameter("disqualProcessInd");
			promoConfig.setDisqualProcessInd(disqualProcessInd);
			HttpSession session=request.getSession();  
			session.setAttribute("DISQUAL_PROCESS",disqualProcessInd);
			request.setAttribute("session", session);
			
		}
		
		if(request.getParameter("monitorProcessInd") != null) {
			String monitorProcessInd = request.getParameter("monitorProcessInd");
			promoConfig.setMonitorProcessInd(monitorProcessInd);
			HttpSession session=request.getSession();  
			session.setAttribute("MONITOR_PROCESS",monitorProcessInd);
			request.setAttribute("session", session);
		}
		
		if(request.getParameter("calcCredOnceInd") != null) {
			String calcCredOnceInd = request.getParameter("calcCredOnceInd");
			promoConfig.setCalcCredOnceInd(calcCredOnceInd);
			HttpSession session=request.getSession(); 
			session.setAttribute("CALCCRED_PROCESS",calcCredOnceInd);
			request.setAttribute("session", session);
		}
		
		if(request.getParameter("exclPermDiscInd") != null) {
			promoConfig.setExclPermDiscInd(request.getParameter("exclPermDiscInd"));
		}
		
		if(!"".equals(request.getParameter("totalNoOfCycles")) && request.getParameter("totalNoOfCycles") != null) {
			promoConfig.setTotalNoOfCycles(Integer.parseInt(request.getParameter("totalNoOfCycles")));
		}
		
		if(!"".equals(request.getParameter("flatCreditAmt")) && request.getParameter("flatCreditAmt") != null) {
			promoConfig.setFlatCreditAmt(Integer.parseInt(request.getParameter("flatCreditAmt")));
		}
		
		if(!"".equals(request.getParameter("percentage")) && request.getParameter("percentage") != null) {
			promoConfig.setPercentage(Integer.parseInt(request.getParameter("percentage")));
		}
		
		if(!"".equals(request.getParameter("capAmt")) && request.getParameter("capAmt") != null) {
			promoConfig.setCapAmt(Integer.parseInt(request.getParameter("capAmt")));
		}
		
		if(request.getParameter("loseSkipCycleInd") != null) {
			promoConfig.setLoseSkipCycleInd(request.getParameter("loseSkipCycleInd"));
		}
		
		if(request.getParameter("offerType") != null) {
			promoConfig.setOfferType(request.getParameter("offerType"));
		}
		
		if(request.getParameter("initCrdeitNo") != null) {
			String initCrdeitNo = request.getParameter("initCrdeitNo");
			System.out.println("initCrdeitNo====>>"+initCrdeitNo);
			promoConfig.setInitCrdeitNo(initCrdeitNo);
		}
		
		if(request.getParameter("clabBackInd") != null) {
			promoConfig.setClabBackInd(request.getParameter("clabBackInd"));
		}
		
		if(request.getParameter("disqualifyInd") != null) {
			promoConfig.setDisqualifyInd(request.getParameter("disqualifyInd"));
		}
		
		if(request.getParameter("registrationClawbackInd") != null) {
			promoConfig.setRegistrationClawbackInd(request.getParameter("registrationClawbackInd"));
		}
		
		if(request.getParameter("registrationDisqualifyInd") != null) {
			promoConfig.setRegistrationDisqualifyInd(request.getParameter("registrationDisqualifyInd"));
		}
		
		if(request.getParameter("clawbackMonitorInd") != null) {
			promoConfig.setClawbackMonitorInd(request.getParameter("clawbackMonitorInd"));
		}
		
		if(request.getParameter("disqualifyMonitorInd") != null) {
			promoConfig.setDisqualifyMonitorInd(request.getParameter("disqualifyMonitorInd"));
		}
		
		if(request.getParameter("clawbackVisibilityInd") != null) {
			promoConfig.setClawbackVisibilityInd(request.getParameter("clawbackVisibilityInd"));
		}
		
		if(request.getParameter("displayPromoStartDate") != null) {
			promoConfig.setDisplayPromoStartDate(request.getParameter("displayPromoStartDate"));
		}
		
		if(request.getParameter("displaPromoEndDate") != null) {
			promoConfig.setDisplayPromoEndDate(request.getParameter("displaPromoEndDate"));
		}

		if(request.getParameter("displayPromoBillDates") != null) {
			promoConfig.setDisplayPromoBillDates(request.getParameter("displayPromoBillDates"));
		}
		
		if(request.getParameter("displayQualInfo") != null) {
			promoConfig.setDisplayQualInfo(request.getParameter("displayQualInfo"));
		}
		
		if(request.getParameter("displayCreditInfo") != null) {
			promoConfig.setDisplayCreditInfo(request.getParameter("displayCreditInfo"));
		}
		
		if(request.getParameter("promoCtgryInd") != null) {
			promoConfig.setPromoCtgryInd(request.getParameter("promoCtgryInd"));
		}
		
		if(request.getParameter("promoUpdInd") != null) {
			promoConfig.setPromoUpdInd(request.getParameter("promoUpdInd"));
		}
		
		if(request.getParameter("profileQualVisInd") != null) {
			promoConfig.setProfileQualVisInd(request.getParameter("profileQualVisInd"));
		}
		
		if(request.getParameter("profileCrdeitVisInd") != null) {
			promoConfig.setProfileCrdeitVisInd(request.getParameter("profileCrdeitVisInd"));
		}
		
		if(request.getParameter("displayClawbackInfo") != null) {
			promoConfig.setDisplayClawbackInfo(request.getParameter("displayClawbackInfo"));	
		}
		
		if(request.getParameter("multiQualAllowedFQ") != null) {
			promoConfig.setMultiQualAllowedFQ(request.getParameter("multiQualAllowedFQ").charAt(0));
		}
		
		if(request.getParameter("requalAllowedFq") != null) {
			promoConfig.setRequalAllowedFq(request.getParameter("requalAllowedFq").charAt(0));
		}
		
		
		if(request.getParameter("disqualAllowedFq") != null) {
			promoConfig.setDisqualAllowedFq(request.getParameter("disqualAllowedFq").charAt(0));
		}
		
		
		
		String result = service.savePromoConfig(promoConfig);
		request.setAttribute("result", result);
	/*	request.setAttribute("listOfValues",AutoDiscallController.getPromoDetails() );
		HttpSession session=request.getSession();
		session.setAttribute("listOfValues",AutoDiscallController.getPromoDetails());
		request.setAttribute("session", session);
	*/	
		request.setAttribute("promoConfigs",AutoDiscallController.getPromoDetails() );
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		System.out.println("Result :" + result);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
	}
		
		
	}
	
	public static Date convertToDate(String date) {
		
		Date formattedDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (date != null && !"".equals(date)) {
			try {
				formattedDate = sdf.parse(date);
			} catch (ParseException e) {
				System.out.println("Exception while parsing your date of format dd/MM/yyyy ");
				e.printStackTrace();
			}
		}
		return formattedDate;
	}
	
	public void doRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("autodiscall Input from User : "+request.getParameter("autodiscall"));
		System.out.println("monitoring Input from User : "+request.getParameter("monitoring"));
		System.out.println("CreditCalc Input from User : "+request.getParameter("CreditCalc"));
		
		
		if("autodiscall".equals(request.getParameter("autodiscall"))){
			request.getRequestDispatcher("/autodiscall.jsp").forward(request, response);
		} else if("monitoring".equals(request.getParameter("monitoring"))) {
			request.getRequestDispatcher("/monitoring.jsp").forward(request, response);
		} else if("CreditCalc".equals(request.getParameter("CreditCalc"))) {
			request.getRequestDispatcher("/CreditCalc.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	/*private void forwardToPage(final HttpServletRequest request, final HttpServletResponse response, String url) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}*/
	

}
