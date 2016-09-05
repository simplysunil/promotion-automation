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
import org.cgi.com.model.AutoDiscall;
import org.cgi.com.model.PromoConfig;


public class AutoDiscallController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String promotionId = "";
	static int promoationSubsAdjId = -1;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Calling from AutoDiscallController...");
	
		promotionId = request.getParameter("promoConfig");
		if(promotionId != null && (!"".equals(promotionId))) {
			promoationSubsAdjId = PromoConfigDAO.getPromotionSubsAdjId(promotionId);	
		}
		try {
			PromoConfigDAO promoConfigDAO = new PromoConfigDAO();
			AutoDiscallController autoDiscallController = new AutoDiscallController();
			AutoDiscall autoDiscall = null;//new AutoDiscall();
			List<AutoDiscall> autoDiscallList = new ArrayList<AutoDiscall>();
			for(String ruleName : AutoDiscallController.getRuleList()) {
				
				if(ruleName.equals("RCP_TYPE")) {
					
					//code for ,
					String ruleParameters = request.getParameter("RCP_TYPE_RP");
					System.out.println("ruleParameters is : "+ruleParameters);
					
					if(ruleParameters.contains(",")) {
						System.out.println("from  , cndition ");
						List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
						if(commaSeprateList.size()>0) {
							for(String inputRuleName : commaSeprateList) {
								
								System.out.println("ruleName is"+inputRuleName);
								autoDiscall = new AutoDiscall();
								autoDiscall.setRuleName("RCP_TYPE");
								if(promotionId != null) {
									autoDiscall.setPromotionId(promotionId);
								}
								
								System.out.println("before setting "+autoDiscall.getPromotionSubsAdjId());
								autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
								System.out.println("after setting "+autoDiscall.getPromotionSubsAdjId());
								
								String desc = autoDiscallController.getRuleDescription("RCP_TYPE");
								System.out.println("desc===>>"+desc);
								
								autoDiscall.setRuleDesc(desc);
								
								System.out.println("setRuleDesc : "+autoDiscall.getRuleDesc());
								String ruleIndicator = request.getParameter("RCP_TYPE");
								System.out.println("Rule indicator : "+ruleIndicator);
								
								autoDiscall.setRuleInd(ruleIndicator);
								
								if(inputRuleName != null) {
									autoDiscall.setRuleParameters(inputRuleName);
								}
								if(request.getParameter("RCP_TYPE_VEn") != null) {
									autoDiscall.setVisDisqMsgEN(request.getParameter("RCP_TYPE_VEn"));
								}
								if(request.getParameter("RCP_TYPE_VFr") != null) {
									autoDiscall.setVisDisqMsdFR(request.getParameter("RCP_TYPE_VFr"));
								}
								autoDiscallList.add(autoDiscall);
							}
						}
						
					} else {
						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();
						autoDiscall.setRuleName("RCP_TYPE");
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("RCP_TYPE"));
						System.out.println("setRuleDesc : "+autoDiscall.getRuleDesc());
						System.out.println("Rule indicator : else condi :  "+request.getParameter("RCP_TYPE"));
						if (request.getParameter("RCP_TYPE") != null) {
							autoDiscall.setRuleInd(request.getParameter("RCP_TYPE"));
						}
						if (request.getParameter("RCP_TYPE_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("RCP_TYPE_RP"));
						}
						if (request.getParameter("RCP_TYPE_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("RCP_TYPE_VEn"));
						}
						if (request.getParameter("RCP_TYPE_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("RCP_TYPE_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					}
					
					
				} else if("RCP_TYPE_WPLAN".equals(ruleName)) {
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("RCP_TYPE_WPLAN_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									autoDiscall.setRuleName("RCP_TYPE_WPLAN");
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("RCP_TYPE_WPLAN"));
									
									if(request.getParameter("RCP_TYPE_WPLAN") != null) {
										autoDiscall.setRuleInd(request.getParameter("RCP_TYPE_WPLAN"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("RCP_TYPE_WPLAN_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("RCP_TYPE_WPLAN_VEn"));
									}
									if(request.getParameter("RCP_TYPE_WPLAN_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("RCP_TYPE_WPLAN_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();
						autoDiscall.setRuleName("RCP_TYPE_WPLAN");
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("RCP_TYPE_WPLAN"));

						if (request.getParameter("RCP_TYPE_WPLAN") != null) {
							autoDiscall.setRuleInd(request.getParameter("RCP_TYPE_WPLAN"));
						}
						if (request.getParameter("RCP_TYPE_WPLAN_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("RCP_TYPE_WPLAN_RP"));
						}
						if (request.getParameter("RCP_TYPE_WPLAN_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("RCP_TYPE_WPLAN_VEn"));
						}
						if (request.getParameter("RCP_TYPE_WPLAN_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("RCP_TYPE_WPLAN_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					}
				}else if("RCP_RCVR".equals(ruleName)) {
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("RCP_RCVR_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									autoDiscall.setRuleName("RCP_RCVR");
									System.out.println("RCP_RCVR : Value set successfully if  !!"+autoDiscall.getRuleName());
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("RCP_RCVR"));
									if(request.getParameter("RCP_RCVR") != null) {
										autoDiscall.setRuleInd(request.getParameter("RCP_RCVR"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("RCP_RCVR_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("RCP_RCVR_VEn"));
									}
									if(request.getParameter("RCP_RCVR_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("RCP_RCVR_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
								
					} else {
						autoDiscall = new AutoDiscall();
						autoDiscall.setRuleName("RCP_RCVR");
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("RCP_RCVR"));
						if (request.getParameter("RCP_RCVR") != null) {
							autoDiscall.setRuleInd(request.getParameter("RCP_RCVR"));
						}
						if (request.getParameter("RCP_RCVR_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("RCP_RCVR_RP"));
						}
						if (request.getParameter("RCP_RCVR_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("RCP_RCVR_VEn"));
						}
						if (request.getParameter("RCP_RCVR_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("RCP_RCVR_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					
					}
				}else if("RCP_RCVR_WPLAN".equals(ruleName)) {
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("RCP_RCVR_WPLAN_RP");
						if(ruleParameters.contains(",")) {
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									autoDiscall.setRuleName("RCP_RCVR_WPLAN");
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("RCP_RCVR_WPLAN"));
									
									if(request.getParameter("RCP_RCVR_WPLAN") != null) {
										autoDiscall.setRuleInd(request.getParameter("RCP_RCVR_WPLAN"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("RCP_RCVR_WPLAN_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("RCP_RCVR_WPLAN_VEn"));
									}
									if(request.getParameter("RCP_RCVR_WPLAN_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("RCP_RCVR_WPLAN_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
								
					} else  {
						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();
						autoDiscall.setRuleName("RCP_RCVR_WPLAN");
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("RCP_RCVR_WPLAN"));
						if (request.getParameter("RCP_RCVR_WPLAN") != null) {
							autoDiscall.setRuleInd(request.getParameter("RCP_RCVR_WPLAN"));
						}
						if (request.getParameter("RCP_RCVR_WPLAN_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("RCP_RCVR_WPLAN_RP"));
						}
						if (request.getParameter("RCP_RCVR_WPLAN_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("RCP_RCVR_WPLAN_VEn"));
						}
						if (request.getParameter("RCP_RCVR_WPLAN_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("RCP_RCVR_WPLAN_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					}
				}else if("HW_TYPE".equals(ruleName)) {
					
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("HW_TYPE_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									autoDiscall.setRuleName("HW_TYPE");
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("HW_TYPE"));
									
									if(request.getParameter("HW_TYPE") != null) {
										autoDiscall.setRuleInd(request.getParameter("HW_TYPE"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("HW_TYPE_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("HW_TYPE_VEn"));
									}
									if(request.getParameter("HW_TYPE_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("HW_TYPE_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
					} else {
						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();
						autoDiscall.setRuleName("HW_TYPE");
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("HW_TYPE"));
						if (request.getParameter("HW_TYPE") != null) {
							autoDiscall.setRuleInd(request.getParameter("HW_TYPE"));
						}
						if (request.getParameter("HW_TYPE_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("HW_TYPE_RP"));
						}
						if (request.getParameter("HW_TYPE_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("HW_TYPE_VEn"));
						}
						if (request.getParameter("HW_TYPE_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("HW_TYPE_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					}
					
				}else if("PLATFORM".equals(ruleName)) {
					
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("PLATFORM_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									autoDiscall = new AutoDiscall();
									
									autoDiscall.setRuleName("PLATFORM");
									
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									
									
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("PLATFORM"));
									
									if(request.getParameter("PLATFORM") != null) {
										autoDiscall.setRuleInd(request.getParameter("PLATFORM"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("PLATFORM_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("PLATFORM_VEn"));
										
									}
									if(request.getParameter("PLATFORM_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("PLATFORM_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();
						autoDiscall.setRuleName("PLATFORM");
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("PLATFORM"));

						if (request.getParameter("PLATFORM") != null) {
							autoDiscall.setRuleInd(request.getParameter("PLATFORM"));
						}
						if (request.getParameter("PLATFORM_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("PLATFORM_RP"));
						}
						if (request.getParameter("PLATFORM_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("PLATFORM_VEn"));
						}
						if (request.getParameter("PLATFORM_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("PLATFORM_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					}
						
				}else if("CORE_PROG".equals(ruleName)) {
					
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("CORE_PROG_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									autoDiscall.setRuleName("CORE_PROG");
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									
									
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("CORE_PROG"));
									
									if(request.getParameter("CORE_PROG") != null) {
										autoDiscall.setRuleInd(request.getParameter("CORE_PROG"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("CORE_PROG_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("CORE_PROG_VEn"));
									}
									if(request.getParameter("CORE_PROG_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("CORE_PROG_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();
						autoDiscall.setRuleName("CORE_PROG");
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("CORE_PROG"));

						if (request.getParameter("CORE_PROG") != null) {
							autoDiscall.setRuleInd(request.getParameter("CORE_PROG"));
						}
						if (request.getParameter("CORE_PROG_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("CORE_PROG_RP"));
						}
						if (request.getParameter("CORE_PROG_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("CORE_PROG_VEn"));
						}
						if (request.getParameter("CORE_PROG_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("CORE_PROG_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					
					}
				}else if("PROG_CLASS_ANY".equals(ruleName)) {
					
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("PROG_CLASS_ANY_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("PROG_CLASS_ANY"));
									autoDiscall.setRuleName("PROG_CLASS_ANY");
									if(request.getParameter("PROG_CLASS_ANY") != null) {
										autoDiscall.setRuleInd(request.getParameter("PROG_CLASS_ANY"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("PROG_CLASS_ANY_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("PROG_CLASS_ANY_VEn"));
									}
									if(request.getParameter("PROG_CLASS_ANY_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("PROG_CLASS_ANY_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
					} else {
						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("PROG_CLASS_ANY"));
						autoDiscall.setRuleName("PROG_CLASS_ANY");
						if (request.getParameter("PROG_CLASS_ANY") != null) {
							autoDiscall.setRuleInd(request.getParameter("PROG_CLASS_ANY"));
						}
						if (request.getParameter("PROG_CLASS_ANY_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("PROG_CLASS_ANY_RP"));
						}
						if (request.getParameter("PROG_CLASS_ANY_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("PROG_CLASS_ANY_VEn"));
						}
						if (request.getParameter("PROG_CLASS_ANY_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("PROG_CLASS_ANY_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					}
					
				}else if("PROG_CLASS_ALL".equals(ruleName)) {
					
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("PROG_CLASS_ALL_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									
									autoDiscall.setRuleName("PROG_CLASS_ALL");
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("PROG_CLASS_ALL"));
									
									if(request.getParameter("PROG_CLASS_ALL") != null) {
										autoDiscall.setRuleInd(request.getParameter("PROG_CLASS_ALL"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("PROG_CLASS_ALL_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("PROG_CLASS_ALL_VEn"));
									}
									if(request.getParameter("PROG_CLASS_ALL_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("PROG_CLASS_ALL_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
					} else {
						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();
						autoDiscall.setRuleName("PROG_CLASS_ALL");
						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("PROG_CLASS_ALL"));

						if (request.getParameter("PROG_CLASS_ALL") != null) {
							autoDiscall.setRuleInd(request.getParameter("PROG_CLASS_ALL"));
						}
						if (request.getParameter("PROG_CLASS_ALL_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("PROG_CLASS_ALL_RP"));
						}
						if (request.getParameter("PROG_CLASS_ALL_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("PROG_CLASS_ALL_VEn"));
						}
						if (request.getParameter("PROG_CLASS_ALL_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("PROG_CLASS_ALL_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					
					}
				}else if("INELIG_PROG".equals(ruleName)) {
					
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("INELIG_PROG_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									
									autoDiscall.setRuleName("INELIG_PROG");
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("INELIG_PROG"));
									
									if(request.getParameter("INELIG_PROG") != null) {
										autoDiscall.setRuleInd(request.getParameter("INELIG_PROG"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("INELIG_PROG_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("INELIG_PROG_VEn"));
									}
									if(request.getParameter("INELIG_PROG_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("INELIG_PROG_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();

						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						autoDiscall.setRuleName("INELIG_PROG");
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("INELIG_PROG"));

						if (request.getParameter("INELIG_PROG") != null) {
							autoDiscall.setRuleInd(request.getParameter("INELIG_PROG"));
						}
						if (request.getParameter("INELIG_PROG_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("INELIG_PROG_RP"));
						}
						if (request.getParameter("INELIG_PROG_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("INELIG_PROG_VEn"));
						}
						if (request.getParameter("INELIG_PROG_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("INELIG_PROG_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					
					}
					
				}else if("CUSTOM_PROGPKG".equals(ruleName)) {
					autoDiscall = new AutoDiscall();
					String ruleParameters = request.getParameter("CUSTOM_PROGPKG_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , condition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									autoDiscall = new AutoDiscall();
									autoDiscall.setRuleName("CUSTOM_PROGPKG");
									if(promotionId != null) {
										autoDiscall.setPromotionId(promotionId);
									}
									autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
									autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("CUSTOM_PROGPKG"));
									
									if(request.getParameter("CUSTOM_PROGPKG") != null) {
										autoDiscall.setRuleInd(request.getParameter("CUSTOM_PROGPKG"));
									}
									if(inputRuleName != null) {
										autoDiscall.setRuleParameters(inputRuleName);
									}
									if(request.getParameter("CUSTOM_PROGPKG_VEn") != null) {
										autoDiscall.setVisDisqMsgEN(request.getParameter("CUSTOM_PROGPKG_VEn"));
									}
									if(request.getParameter("CUSTOM_PROGPKG_VFr") != null) {
										autoDiscall.setVisDisqMsdFR(request.getParameter("CUSTOM_PROGPKG_VFr"));
									}
									autoDiscallList.add(autoDiscall);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						autoDiscall = new AutoDiscall();

						if (promotionId != null) {
							autoDiscall.setPromotionId(promotionId);
						}
						
						autoDiscall.setPromotionSubsAdjId(promoationSubsAdjId);
						
						autoDiscall.setRuleDesc(autoDiscallController.getRuleDescription("CUSTOM_PROGPKG"));
						autoDiscall.setRuleName("CUSTOM_PROGPKG");
						if (request.getParameter("CUSTOM_PROGPKG") != null) {
							autoDiscall.setRuleInd(request.getParameter("CUSTOM_PROGPKG"));
						}
						if (request.getParameter("CUSTOM_PROGPKG_RP") != null) {
							autoDiscall.setRuleParameters(request.getParameter("CUSTOM_PROGPKG_RP"));
						}
						if (request.getParameter("CUSTOM_PROGPKG_VEn") != null) {
							autoDiscall.setVisDisqMsgEN(request.getParameter("CUSTOM_PROGPKG_VEn"));
						}
						if (request.getParameter("CUSTOM_PROGPKG_VFr") != null) {
							autoDiscall.setVisDisqMsdFR(request.getParameter("CUSTOM_PROGPKG_VFr"));
						}
						autoDiscallList.add(autoDiscall);
					}
				}
				
			}
			String result = promoConfigDAO.saveAutoDisCallObj(autoDiscallList);
			request.setAttribute("result", result);
			request.getRequestDispatcher("/autodiscall.jsp").forward(request, response);
			System.out.println("Result :" + result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	
	public static List<PromoConfig> getPromoDetails() {
		PromoConfigDAO promoConfigDAO = new PromoConfigDAO();
		List<PromoConfig> promoConfigList = promoConfigDAO.getPromoConfig();
		return promoConfigList;
	}
	
	
	public static List<String> getRuleList() {
		List<String> ruleList = new LinkedList<String>();
		
		ruleList.add("RCP_TYPE");
		ruleList.add("RCP_TYPE_WPLAN");
		ruleList.add("RCP_RCVR");
		ruleList.add("RCP_RCVR_WPLAN");
		ruleList.add("HW_TYPE");
		ruleList.add("PLATFORM");
		ruleList.add("CORE_PROG");
		ruleList.add("PROG_CLASS_ANY");
		ruleList.add("PROG_CLASS_ALL");
		ruleList.add("INELIG_PROG");
		ruleList.add("CUSTOM_PROGPKG");
		
		return ruleList;
	}
	
	public String getRuleDescription(String ruleName) {
		
		System.out.println("ruleName >>>"+ruleName);
		String description = "";
		if(ruleName.equals("RCP_TYPE")) {
			description = "REQ_RCP_TYPES_IND";
		} else if(ruleName.equals("RCP_TYPE_WPLAN")) {
			description = "REQ_RCP_TYPES_WPLAN_IND";
		} else if(ruleName.equals("RCP_RCVR")) {
			description = "RCP_HW_REQ_IND";
		} else if(ruleName.equals("RCP_RCVR_WPLAN") ) {
			description = "RCP_HW_REQ_WPLAN_IND";
		} else if(ruleName.equals("HW_TYPE") ) {
			description = "REQ_HW_TYPES_IND";
		} else if(ruleName.equals("PLATFORM") ) {
			description = "INCL_PROG_PLATFORM_IND";
		} else if(ruleName.equals("CORE_PROG") ) {
			description = "INCL_CORE_PROGPKG_IND";
		} else if(ruleName.equals("PROG_CLASS_ANY") ) {
			description = "INCL_ANY_PROGCLASS_IND";
		} else if(ruleName.equals("PROG_CLASS_ALL") ) {
			description = "INCL_ALL_PROGCLASS_IND";
		} else if(ruleName.equals("INELIG_PROG") ) {
			description = "EXCL_INELIG_PROGPKG_IND";
		} else if(ruleName.equals("CUSTOM_PROGPKG") ) {
			description = "INCL_CUSTOM_PROGPKG_IND";
		}
		return description;
	}
	
}
