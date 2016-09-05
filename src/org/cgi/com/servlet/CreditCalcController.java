package org.cgi.com.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cgi.com.dao.PromoConfigDAO;
import org.cgi.com.model.CreditCalc;
import org.cgi.com.model.PromoConfig;



public class CreditCalcController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String promotionId = "";
	static int promoationSubsAdjId = -1;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("calling from CreditCalcController...");
		response.setContentType("text/html");
		PromoConfigDAO promoConfigDAO = new PromoConfigDAO();
		promotionId = request.getParameter("promoConfig");
		if(promotionId != null && (!"".equals(promotionId))) {
			promoationSubsAdjId = PromoConfigDAO.getPromotionSubsAdjId(promotionId);	
		}
		
		try {

			CreditCalcController creditCalcController = new CreditCalcController();
			CreditCalc creditCalc = null;//new creditCalc();
			List<CreditCalc> creditCalcList = new ArrayList<CreditCalc>();
			for(String ruleName : CreditCalcController.getRuleList()) {
				
				if(ruleName.equals("AGENT_CD")) {
					
					//code for ,
					String ruleParameters = request.getParameter("AGENT_CD_RP");
					
					System.out.println("ruleParameters is : "+ruleParameters);
					
					if(ruleParameters.contains(",")) {
						System.out.println("from  , cndition ");
						List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
						if(commaSeprateList.size()>0) {
							for(String inputRuleName : commaSeprateList) {
								
								System.out.println("ruleName is"+inputRuleName);
								creditCalc = new CreditCalc();
								creditCalc.setRuleName("AGENT_CD");
								if(promotionId != null) {
									creditCalc.setPromotionId(promotionId);
								}
								
								creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
								
								String desc = creditCalcController.getRuleDescription("AGENT_CD");
								System.out.println("desc===>>"+desc);
								
								creditCalc.setRuleDesc(desc);
								
								System.out.println("setRuleDesc : "+creditCalc.getRuleDesc());
								String ruleIndicator = request.getParameter("AGENT_CD");
								System.out.println("Rule indicator : "+ruleIndicator);
								
								creditCalc.setRuleInd(ruleIndicator);
								
								if(inputRuleName != null) {
									creditCalc.setRuleParameters(inputRuleName);
								}
								
								creditCalcList.add(creditCalc);
							}
						}
						
					} else {
					
					
						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();
						creditCalc.setRuleName("AGENT_CD");
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
							
						}
						
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						
						System.out.println("Promotion Id : "+creditCalc.getPromotionId());
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("AGENT_CD"));
						System.out.println("setRuleDesc : "+creditCalc.getRuleDesc());
						System.out.println("Rule indicator : else condi :  "+request.getParameter("AGENT_CD"));
						if (request.getParameter("AGENT_CD") != null) {
							creditCalc.setRuleInd(request.getParameter("AGENT_CD"));
						}
						if (request.getParameter("AGENT_CD_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("AGENT_CD_RP"));
						}
						
						creditCalcList.add(creditCalc);
					}
					
					
				}
				
				else if("PROVINCE_CD".equals(ruleName)) {
					creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("PROVINCE_CD_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("PROVINCE_CD");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("PROVINCE_CD"));
									
									if(request.getParameter("PROVINCE_CD") != null) {
										creditCalc.setRuleInd(request.getParameter("PROVINCE_CD"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();
						creditCalc.setRuleName("PROVINCE_CD");
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("PROVINCE_CD"));

						if (request.getParameter("PROVINCE_CD") != null) {
							creditCalc.setRuleInd(request.getParameter("PROVINCE_CD"));
						}
						if (request.getParameter("PROVINCE_CD_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("PROVINCE_CD_RP"));
						}
						
						creditCalcList.add(creditCalc);
					}
				}else if("HIGHEST_ANY".equals(ruleName)) {
					//creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("HIGHEST_ANY_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("HIGHEST_ANY");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_ANY"));
									
									if(request.getParameter("HIGHEST_ANY") != null) {
										creditCalc.setRuleInd(request.getParameter("HIGHEST_ANY"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
								
					} else {
						creditCalc = new CreditCalc();
						
						creditCalc.setRuleName("HIGHEST_ANY");
						System.out.println("ruleName is" + ruleName);
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_ANY"));

						if (request.getParameter("HIGHEST_ANY") != null) {
							creditCalc.setRuleInd(request.getParameter("HIGHEST_ANY"));
						}
						if (request.getParameter("HIGHEST_ANY_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("HIGHEST_ANY_RP"));
						}
						
						creditCalcList.add(creditCalc);
					
					}
				}else if("HIGHEST_ORS".equals(ruleName)) {
					
					creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("HIGHEST_ORS_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("HIGHEST_ORS");
									System.out.println("ruleName is"+inputRuleName);
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_ORS"));
									if(request.getParameter("HIGHEST_ORS") != null) {
										creditCalc.setRuleInd(request.getParameter("HIGHEST_ORS"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									creditCalcList.add(creditCalc);
								}
							}
								
					} else  {
						creditCalc = new CreditCalc();
						creditCalc.setRuleName("HIGHEST_ORS");
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_ORS"));
						if (request.getParameter("HIGHEST_ORS") != null) {
							creditCalc.setRuleInd(request.getParameter("HIGHEST_ORS"));
						}
						if (request.getParameter("HIGHEST_ORS_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("HIGHEST_ORS_RP"));
						}
						creditCalcList.add(creditCalc);
					}
				}else if("HIGHEST_RCP".equals(ruleName)) {
					
					//creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("HIGHEST_RCP_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("HIGHEST_RCP");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_RCP"));
									if(request.getParameter("HIGHEST_RCP") != null) {
										creditCalc.setRuleInd(request.getParameter("HIGHEST_RCP"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									creditCalcList.add(creditCalc);
								}
							}
					} else {
						creditCalc = new CreditCalc();
						creditCalc.setRuleName("HIGHEST_RCP");
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_RCP"));
						if (request.getParameter("HIGHEST_RCP") != null) {
							creditCalc.setRuleInd(request.getParameter("HIGHEST_RCP"));
						}
						if (request.getParameter("HIGHEST_RCP_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("HIGHEST_RCP_RP"));
						}
						creditCalcList.add(creditCalc);
					}
					
				}else if("HIGHEST_RCP36".equals(ruleName)) {
					String ruleParameters = request.getParameter("HIGHEST_RCP36_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("HIGHEST_RCP36");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_RCP36"));
									if(request.getParameter("HIGHEST_RCP36") != null) {
										creditCalc.setRuleInd(request.getParameter("HIGHEST_RCP36"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									creditCalcList.add(creditCalc);
								}
							}
								
					} else {
						creditCalc = new CreditCalc();
						creditCalc.setRuleName("HIGHEST_RCP36");
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_RCP36"));
						if (request.getParameter("HIGHEST_RCP36") != null) {
							creditCalc.setRuleInd(request.getParameter("HIGHEST_RCP36"));
						}
						if (request.getParameter("HIGHEST_RCP36_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("HIGHEST_RCP36_RP"));
						}
						creditCalcList.add(creditCalc);
					}
						
				}else if("HIGHEST_RCP60".equals(ruleName)) {
					//creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("HIGHEST_RCP60_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("HIGHEST_RCP60");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_RCP60"));
									
									if(request.getParameter("HIGHEST_RCP60") != null) {
										creditCalc.setRuleInd(request.getParameter("HIGHEST_RCP60"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();
						creditCalc.setRuleName("HIGHEST_RCP60");
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("HIGHEST_RCP60"));

						if (request.getParameter("HIGHEST_RCP60") != null) {
							creditCalc.setRuleInd(request.getParameter("HIGHEST_RCP60"));
						}
						if (request.getParameter("HIGHEST_RCP60_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("HIGHEST_RCP60_RP"));
						}
						
						creditCalcList.add(creditCalc);
					
					}
				}else if("CORE_PROG_MONTHLY_SPEND".equals(ruleName)) {
					
					creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("CORE_PROG_MONTHLY_SPEND_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									creditCalc = new CreditCalc();
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("CORE_PROG_MONTHLY_SPEND"));
									creditCalc.setRuleName("CORE_PROG_MONTHLY_SPEND");
									if(request.getParameter("CORE_PROG_MONTHLY_SPEND") != null) {
										creditCalc.setRuleInd(request.getParameter("CORE_PROG_MONTHLY_SPEND"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
					} else {
						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						
						
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("CORE_PROG_MONTHLY_SPEND"));
						creditCalc.setRuleName("CORE_PROG_MONTHLY_SPEND");
						if (request.getParameter("CORE_PROG_MONTHLY_SPEND") != null) {
							creditCalc.setRuleInd(request.getParameter("CORE_PROG_MONTHLY_SPEND"));
						}
						if (request.getParameter("CORE_PROG_MONTHLY_SPEND_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("CORE_PROG_MONTHLY_SPEND_RP"));
						}
						
						creditCalcList.add(creditCalc);
					}
					
				}else if("MTH_CHARGE_WDSC_AMT".equals(ruleName)) {
					
					creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("MTH_CHARGE_WDSC_AMT_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									creditCalc = new CreditCalc();
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									
									creditCalc.setRuleName("MTH_CHARGE_WDSC_AMT");
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("MTH_CHARGE_WDSC_AMT"));
									
									if(request.getParameter("MTH_CHARGE_WDSC_AMT") != null) {
										creditCalc.setRuleInd(request.getParameter("MTH_CHARGE_WDSC_AMT"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
					} else {
						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();
						creditCalc.setRuleName("MTH_CHARGE_WDSC_AMT");
						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("MTH_CHARGE_WDSC_AMT"));

						if (request.getParameter("MTH_CHARGE_WDSC_AMT") != null) {
							creditCalc.setRuleInd(request.getParameter("MTH_CHARGE_WDSC_AMT"));
						}
						if (request.getParameter("MTH_CHARGE_WDSC_AMT_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("MTH_CHARGE_WDSC_AMT_RP"));
						}
						
						creditCalcList.add(creditCalc);
					
					}
				}else if("MTH_PROG_WDSC_AMT".equals(ruleName)) {
					
					creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("MTH_PROG_WDSC_AMT_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									creditCalc = new CreditCalc();
									
									creditCalc.setRuleName("MTH_PROG_WDSC_AMT");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("MTH_PROG_WDSC_AMT"));
									
									if(request.getParameter("MTH_PROG_WDSC_AMT") != null) {
										creditCalc.setRuleInd(request.getParameter("MTH_PROG_WDSC_AMT"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();

						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						
						creditCalc.setRuleName("MTH_PROG_WDSC_AMT");
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("MTH_PROG_WDSC_AMT"));

						if (request.getParameter("MTH_PROG_WDSC_AMT") != null) {
							creditCalc.setRuleInd(request.getParameter("MTH_PROG_WDSC_AMT"));
						}
						if (request.getParameter("MTH_PROG_WDSC_AMT_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("MTH_PROG_WDSC_AMT_RP"));
						}
						
						creditCalcList.add(creditCalc);
					
					}
					
				}else if("PROG_CLASS_SPEND".equals(ruleName)) {
					creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("PROG_CLASS_SPEND_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , condition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("PROG_CLASS_SPEND");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("PROG_CLASS_SPEND"));
									
									if(request.getParameter("PROG_CLASS_SPEND") != null) {
										creditCalc.setRuleInd(request.getParameter("PROG_CLASS_SPEND"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();

						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("PROG_CLASS_SPEND"));
						creditCalc.setRuleName("PROG_CLASS_SPEND");
						if (request.getParameter("PROG_CLASS_SPEND") != null) {
							creditCalc.setRuleInd(request.getParameter("PROG_CLASS_SPEND"));
						}
						if (request.getParameter("PROG_CLASS_SPEND_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("PROG_CLASS_SPEND_RP"));
						}
						
						creditCalcList.add(creditCalc);
					}
				}else if("CUSTOM_CLASS_SPEND".equals(ruleName)) {
					creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("CUSTOM_CLASS_SPEND_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , condition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("CUSTOM_CLASS_SPEND");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("CUSTOM_CLASS_SPEND"));
									
									if(request.getParameter("CUSTOM_CLASS_SPEND") != null) {
										creditCalc.setRuleInd(request.getParameter("CUSTOM_CLASS_SPEND"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();

						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("CUSTOM_CLASS_SPEND"));
						creditCalc.setRuleName("CUSTOM_CLASS_SPEND");
						if (request.getParameter("CUSTOM_CLASS_SPEND") != null) {
							creditCalc.setRuleInd(request.getParameter("CUSTOM_CLASS_SPEND"));
						}
						if (request.getParameter("CUSTOM_CLASS_SPEND_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("CUSTOM_CLASS_SPEND_RP"));
						}
						
						creditCalcList.add(creditCalc);
					}
				}
				
				else if("CORE_CLASS_SPEND".equals(ruleName)) {
					creditCalc = new CreditCalc();
					String ruleParameters = request.getParameter("CORE_CLASS_SPEND_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , condition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									creditCalc = new CreditCalc();
									creditCalc.setRuleName("CORE_CLASS_SPEND");
									if(promotionId != null) {
										creditCalc.setPromotionId(promotionId);
									}
									creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
									creditCalc.setRuleDesc(creditCalcController.getRuleDescription("CORE_CLASS_SPEND"));
									
									if(request.getParameter("CORE_CLASS_SPEND") != null) {
										creditCalc.setRuleInd(request.getParameter("CORE_CLASS_SPEND"));
									}
									if(inputRuleName != null) {
										creditCalc.setRuleParameters(inputRuleName);
									}
									
									creditCalcList.add(creditCalc);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						creditCalc = new CreditCalc();

						if (promotionId != null) {
							creditCalc.setPromotionId(promotionId);
						}
						creditCalc.setPromotionSubsAdjId(promoationSubsAdjId);
						creditCalc.setRuleDesc(creditCalcController.getRuleDescription("CORE_CLASS_SPEND"));
						creditCalc.setRuleName("CORE_CLASS_SPEND");
						if (request.getParameter("CORE_CLASS_SPEND") != null) {
							creditCalc.setRuleInd(request.getParameter("CORE_CLASS_SPEND"));
						}
						if (request.getParameter("CORE_CLASS_SPEND_RP") != null) {
							creditCalc.setRuleParameters(request.getParameter("CORE_CLASS_SPEND_RP"));
						}
						
						creditCalcList.add(creditCalc);
					}
				}
				
			}
			String result = promoConfigDAO.saveCreditCalcObj(creditCalcList);
			request.setAttribute("result", result);
			request.setAttribute("promoConfigs",AutoDiscallController.getPromoDetails() );
			request.getRequestDispatcher("/CreditCalc.jsp").forward(request, response);
			System.out.println("Result :" + result);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	
public String getRuleDescription(String ruleName) {
		
		System.out.println("ruleName >>>"+ruleName);
		String description = "";
		if(ruleName.equals("AGENT_CD")) {
			description = "AGENT_CD_IND";
		} else if(ruleName.equals("PROVINCE_CD")) {
			description = "PROVINCE_CD_IND";
		} else if(ruleName.equals("HIGHEST_ANY")) {
			description = "HIGHEST_HW_IND";
		} else if(ruleName.equals("HIGHEST_ORS") ) {
			description = "HIGHEST_ORS_IND";
		} else if(ruleName.equals("HIGHEST_RCP") ) {
			description = "HIGHEST_RCP_IND";
		} else if(ruleName.equals("HIGHEST_RCP36") ) {
			description = "HIGHEST_RCP_WPLAN_IND";
		} else if(ruleName.equals("HIGHEST_RCP60") ) {
			description = "HIGHEST_RCP_WPLAN_IND";
		} else if(ruleName.equals("CORE_PROG_MONTHLY_SPEND") ) {
			description = "CORE_PROG_SPEND_IND";
		} else if(ruleName.equals("MTH_CHARGE_WDSC_AMT") ) {
			description = "TOTAL_MTH_SPEND_IND";
		} else if(ruleName.equals("MTH_PROG_WDSC_AMT") ) {
			description = "PROG_MTH_SPEND_IND";
		} else if(ruleName.equals("PROG_CLASS_SPEND") ) {
			description = "PROG_CLASS_SPEND_IND";
		} else if(ruleName.equals("CUSTOM_CLASS_SPEND") ) {
			description = "CUSTOM_CLASS_SPEND_IND";
		} else if(ruleName.equals("CORE_CLASS_SPEND") ) {
			description = "CORE_CLASS_SPEND_IND";
		}
		
		
		return description;
	}
	
public static List<String> getRuleList() {
	List<String> ruleList = new LinkedList<String>();
	
	ruleList.add("AGENT_CD");
	ruleList.add("PROVINCE_CD");
	ruleList.add("HIGHEST_ANY");
	ruleList.add("HIGHEST_ORS");
	ruleList.add("HIGHEST_RCP");
	ruleList.add("HIGHEST_RCP36");
	ruleList.add("HIGHEST_RCP60");
	ruleList.add("CORE_PROG_MONTHLY_SPEND");
	ruleList.add("MTH_CHARGE_WDSC_AMT");
	ruleList.add("MTH_PROG_WDSC_AMT");
	ruleList.add("PROG_CLASS_SPEND");
	ruleList.add("CUSTOM_CLASS_SPEND");
	ruleList.add("CORE_CLASS_SPEND");
	return ruleList;
}

	
	
}
