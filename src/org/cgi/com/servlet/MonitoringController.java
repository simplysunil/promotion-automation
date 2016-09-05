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
import org.cgi.com.model.Monitoring;
import org.cgi.com.model.PromoConfig;



public class MonitoringController extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String promotionId = "";
	static int promoationSubsAdjId = -1;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Calling from MonitoringController...");
	
		PromoConfigDAO promoConfigDAO = new PromoConfigDAO();
		promotionId = request.getParameter("promoConfig");
		if(promotionId != null && (!"".equals(promotionId))) {
			promoationSubsAdjId = PromoConfigDAO.getPromotionSubsAdjId(promotionId);	
		}
		try {
			MonitoringController monitoringController = new MonitoringController();
			Monitoring monitoring = null;//new Monitoring();
			List<Monitoring> monitoringList = new ArrayList<Monitoring>();
			for(String ruleName : MonitoringController.getRuleList()) {
				
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
								monitoring = new Monitoring();
								monitoring.setRuleName("RCP_TYPE");
								if(promotionId != null) {
									monitoring.setPromotionId(promotionId);
								}
								monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
								String desc = monitoringController.getRuleDescription("RCP_TYPE");
								System.out.println("desc===>>"+desc);
								
								monitoring.setRuleDesc(desc);
								
								System.out.println("setRuleDesc : "+monitoring.getRuleDesc());
								String ruleIndicator = request.getParameter("RCP_TYPE");
								System.out.println("Rule indicator : "+ruleIndicator);
								
								monitoring.setRuleInd(ruleIndicator);
								
								if(inputRuleName != null) {
									monitoring.setRuleParameters(inputRuleName);
								}
								
								monitoringList.add(monitoring);
							}
						}
						
					} else {
						System.out.println("ruleName is" + ruleName);
						monitoring = new Monitoring();
						monitoring.setRuleName("RCP_TYPE");
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						
						monitoring.setRuleDesc(monitoringController.getRuleDescription("RCP_TYPE"));
						System.out.println("setRuleDesc : "+monitoring.getRuleDesc());
						System.out.println("Rule indicator : else condi :  "+request.getParameter("RCP_TYPE"));
						if (request.getParameter("RCP_TYPE") != null) {
							monitoring.setRuleInd(request.getParameter("RCP_TYPE"));
						}
						if (request.getParameter("RCP_TYPE_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("RCP_TYPE_RP"));
						}
						
						monitoringList.add(monitoring);
					}
					
					
				} else if("RCP_TYPE_WPLAN".equals(ruleName)) {
					//monitoring = new Monitoring();
					String ruleParameters = request.getParameter("RCP_TYPE_WPLAN_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									monitoring = new Monitoring();
									monitoring.setRuleName("RCP_TYPE_WPLAN");
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									
									monitoring.setRuleDesc(monitoringController.getRuleDescription("RCP_TYPE_WPLAN"));
									
									if(request.getParameter("RCP_TYPE_WPLAN") != null) {
										monitoring.setRuleInd(request.getParameter("RCP_TYPE_WPLAN"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									
									monitoringList.add(monitoring);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						monitoring = new Monitoring();
						monitoring.setRuleName("RCP_TYPE_WPLAN");
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						
						monitoring.setRuleDesc(monitoringController.getRuleDescription("RCP_TYPE_WPLAN"));

						if (request.getParameter("RCP_TYPE_WPLAN") != null) {
							monitoring.setRuleInd(request.getParameter("RCP_TYPE_WPLAN"));
						}
						if (request.getParameter("RCP_TYPE_WPLAN_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("RCP_TYPE_WPLAN_RP"));
						}
						
						monitoringList.add(monitoring);
					}
				}else if("RCP_RCVR".equals(ruleName)) {
					//monitoring = new Monitoring();
					String ruleParameters = request.getParameter("RCP_RCVR_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									monitoring = new Monitoring();
									monitoring.setRuleName("RCP_RCVR");
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									
									monitoring.setRuleDesc(monitoringController.getRuleDescription("RCP_RCVR"));
									
									if(request.getParameter("RCP_RCVR") != null) {
										monitoring.setRuleInd(request.getParameter("RCP_RCVR"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									
									monitoringList.add(monitoring);
								}
							}
								
					} else {
						monitoring = new Monitoring();
						monitoring.setRuleName("RCP_RCVR");
						System.out.println("ruleName is" + ruleName);
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						monitoring.setRuleDesc(monitoringController.getRuleDescription("RCP_RCVR"));

						if (request.getParameter("RCP_RCVR") != null) {
							monitoring.setRuleInd(request.getParameter("RCP_RCVR"));
						}
						if (request.getParameter("RCP_RCVR_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("RCP_RCVR_RP"));
						}
						
						monitoringList.add(monitoring);
					
					}
				}else if("RCP_RCVR_WPLAN".equals(ruleName)) {
					
					//monitoring = new Monitoring();
					String ruleParameters = request.getParameter("RCP_RCVR_WPLAN_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									monitoring = new Monitoring();
									monitoring.setRuleName("RCP_RCVR_WPLAN");
									System.out.println("ruleName is"+inputRuleName);
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									monitoring.setRuleDesc(monitoringController.getRuleDescription("RCP_RCVR_WPLAN"));
									if(request.getParameter("RCP_RCVR_WPLAN") != null) {
										monitoring.setRuleInd(request.getParameter("RCP_RCVR_WPLAN"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									
									monitoringList.add(monitoring);
								}
							}
								
					} else  {
						System.out.println("ruleName is" + ruleName);
						monitoring = new Monitoring();
						monitoring.setRuleName("RCP_RCVR_WPLAN");
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						
						monitoring.setRuleDesc(monitoringController.getRuleDescription("RCP_RCVR_WPLAN"));
						if (request.getParameter("RCP_RCVR_WPLAN") != null) {
							monitoring.setRuleInd(request.getParameter("RCP_RCVR_WPLAN"));
						}
						if (request.getParameter("RCP_RCVR_WPLAN_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("RCP_RCVR_WPLAN_RP"));
						}
						
						monitoringList.add(monitoring);
					}
				}else if("HW_TYPE".equals(ruleName)) {
					
					//monitoring = new Monitoring();
					String ruleParameters = request.getParameter("HW_TYPE_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									monitoring = new Monitoring();
									monitoring.setRuleName("HW_TYPE");
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									
									monitoring.setRuleDesc(monitoringController.getRuleDescription("HW_TYPE"));
									
									if(request.getParameter("HW_TYPE") != null) {
										monitoring.setRuleInd(request.getParameter("HW_TYPE"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									
									monitoringList.add(monitoring);
								}
							}
					} else {
						System.out.println("ruleName is" + ruleName);
						monitoring = new Monitoring();
						monitoring.setRuleName("HW_TYPE");
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						
						monitoring.setRuleDesc(monitoringController.getRuleDescription("HW_TYPE"));
						if (request.getParameter("HW_TYPE") != null) {
							monitoring.setRuleInd(request.getParameter("HW_TYPE"));
						}
						if (request.getParameter("HW_TYPE_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("HW_TYPE_RP"));
						}
						
						monitoringList.add(monitoring);
					}
					
				}else if("PLATFORM".equals(ruleName)) {
					
					//monitoring = new Monitoring();
					String ruleParameters = request.getParameter("PLATFORM_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , cndition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									monitoring = new Monitoring();
									
									monitoring.setRuleName("PLATFORM");
									
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									monitoring.setRuleDesc(monitoringController.getRuleDescription("PLATFORM"));
									
									if(request.getParameter("PLATFORM") != null) {
										monitoring.setRuleInd(request.getParameter("PLATFORM"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									
									monitoringList.add(monitoring);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						monitoring = new Monitoring();
						monitoring.setRuleName("PLATFORM");
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						monitoring.setRuleDesc(monitoringController.getRuleDescription("PLATFORM"));

						if (request.getParameter("PLATFORM") != null) {
							monitoring.setRuleInd(request.getParameter("PLATFORM"));
						}
						if (request.getParameter("PLATFORM_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("PLATFORM_RP"));
						}
						
						monitoringList.add(monitoring);
					}
						
				}else if("CORE_PROG".equals(ruleName)) {
					String ruleParameters = request.getParameter("CORE_PROG_RP");
						if(ruleParameters.contains(",")) {
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									monitoring = new Monitoring();
									monitoring.setRuleName("CORE_PROG");
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									monitoring.setRuleDesc(monitoringController.getRuleDescription("CORE_PROG"));
									if(request.getParameter("CORE_PROG") != null) {
										monitoring.setRuleInd(request.getParameter("CORE_PROG"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									monitoringList.add(monitoring);
								}
							}
					} else {
						monitoring = new Monitoring();
						monitoring.setRuleName("CORE_PROG");
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						monitoring.setRuleDesc(monitoringController.getRuleDescription("CORE_PROG"));

						if (request.getParameter("CORE_PROG") != null) {
							monitoring.setRuleInd(request.getParameter("CORE_PROG"));
						}
						if (request.getParameter("CORE_PROG_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("CORE_PROG_RP"));
						}
						
						monitoringList.add(monitoring);
					
					}
				}else if("PROG_CLASS_ANY".equals(ruleName)) {
					
					String ruleParameters = request.getParameter("PROG_CLASS_ANY_RP");
					if(ruleParameters.contains(",")) {
						List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
						if(commaSeprateList.size()>0) {
							for(String inputRuleName : commaSeprateList) {
									monitoring = new Monitoring();
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									monitoring.setRuleDesc(monitoringController.getRuleDescription("PROG_CLASS_ANY"));
									monitoring.setRuleName("PROG_CLASS_ANY");
									if(request.getParameter("PROG_CLASS_ANY") != null) {
										monitoring.setRuleInd(request.getParameter("PROG_CLASS_ANY"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									monitoringList.add(monitoring);
								}
							}
					} else {
						monitoring = new Monitoring();
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						monitoring.setRuleDesc(monitoringController.getRuleDescription("PROG_CLASS_ANY"));
						monitoring.setRuleName("PROG_CLASS_ANY");
						if (request.getParameter("PROG_CLASS_ANY") != null) {
							monitoring.setRuleInd(request.getParameter("PROG_CLASS_ANY"));
						}
						if (request.getParameter("PROG_CLASS_ANY_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("PROG_CLASS_ANY_RP"));
						}
						monitoringList.add(monitoring);
					}
					
				}else if("PROG_CLASS_ALL".equals(ruleName)) {
					String ruleParameters = request.getParameter("PROG_CLASS_ALL_RP");
						if(ruleParameters.contains(",")) {
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									monitoring = new Monitoring();
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									monitoring.setRuleName("PROG_CLASS_ALL");
									monitoring.setRuleDesc(monitoringController.getRuleDescription("PROG_CLASS_ALL"));
									
									if(request.getParameter("PROG_CLASS_ALL") != null) {
										monitoring.setRuleInd(request.getParameter("PROG_CLASS_ALL"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									monitoringList.add(monitoring);
								}
							}
					} else {
						monitoring = new Monitoring();
						monitoring.setRuleName("PROG_CLASS_ALL");
						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						monitoring.setRuleDesc(monitoringController.getRuleDescription("PROG_CLASS_ALL"));

						if (request.getParameter("PROG_CLASS_ALL") != null) {
							monitoring.setRuleInd(request.getParameter("PROG_CLASS_ALL"));
						}
						if (request.getParameter("PROG_CLASS_ALL_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("PROG_CLASS_ALL_RP"));
						}
						monitoringList.add(monitoring);
					}
				} else if("CUSTOM_PROG".equals(ruleName)) {
					//monitoring = new Monitoring();
					String ruleParameters = request.getParameter("CUSTOM_PROG_RP");
						System.out.println("ruleParameters is : "+ruleParameters);
						if(ruleParameters.contains(",")) {
							System.out.println("from  , condition ");
							List<String> commaSeprateList = Arrays.asList(ruleParameters.split(","));
							if(commaSeprateList.size()>0) {
								for(String inputRuleName : commaSeprateList) {
									System.out.println("ruleName is"+inputRuleName);
									monitoring = new Monitoring();
									monitoring.setRuleName("CUSTOM_PROG");
									if(promotionId != null) {
										monitoring.setPromotionId(promotionId);
									}
									monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
									monitoring.setRuleDesc(monitoringController.getRuleDescription("CUSTOM_PROG"));
									
									if(request.getParameter("CUSTOM_PROG") != null) {
										monitoring.setRuleInd(request.getParameter("CUSTOM_PROG"));
									}
									if(inputRuleName != null) {
										monitoring.setRuleParameters(inputRuleName);
									}
									monitoringList.add(monitoring);
								}
							}
								
					} else {

						System.out.println("ruleName is" + ruleName);
						monitoring = new Monitoring();

						if (promotionId != null) {
							monitoring.setPromotionId(promotionId);
						}
						monitoring.setPromotionSubsAdjId(promoationSubsAdjId);
						monitoring.setRuleDesc(monitoringController.getRuleDescription("CUSTOM_PROG"));
						monitoring.setRuleName("CUSTOM_PROG");
						if (request.getParameter("CUSTOM_PROG") != null) {
							monitoring.setRuleInd(request.getParameter("CUSTOM_PROG"));
						}
						if (request.getParameter("CUSTOM_PROG_RP") != null) {
							monitoring.setRuleParameters(request.getParameter("CUSTOM_PROG_RP"));
						}
						monitoringList.add(monitoring);
					}
				}
			}
			String result = promoConfigDAO.savemonitoringObj(monitoringList);
			request.setAttribute("result", result);
			request.setAttribute("promoConfigs",AutoDiscallController.getPromoDetails() );
			request.getRequestDispatcher("/monitoring.jsp").forward(request, response);
			System.out.println("Result :" + result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
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
		ruleList.add("CUSTOM_PROG");
		
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
		}  else if(ruleName.equals("CUSTOM_PROG") ) {
			description = "INCL_ANY_CUSTOM_PROGPKG_IND";
		}
		return description;
	}
	
	
	
}
