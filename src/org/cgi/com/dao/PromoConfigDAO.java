package org.cgi.com.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.cgi.com.model.AutoDiscall;
import org.cgi.com.model.CreditCalc;
import org.cgi.com.model.Monitoring;
import org.cgi.com.model.PromoConfig;
import org.cgi.com.utils.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class PromoConfigDAO {

	public String savePromoConfig(PromoConfig promoConfig) {
		try {
			Session session = HibernateUtil.openSession();
			session.save(promoConfig);
			Transaction tx =session.beginTransaction();
     		tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e: " + e);
		}
		return "Promo Data Saved Successfully  ";
	}

	
	public String saveAutoDisCallObj(List<AutoDiscall> autoDiscallList) {
		try {
			AutoDiscall autoDiscal = null;
			for(AutoDiscall autoDiscall : autoDiscallList) {
				autoDiscal = new AutoDiscall();
				autoDiscal.setPromotionId(autoDiscall.getPromotionId());
				autoDiscal.setPromotionSubsAdjId(autoDiscall.getPromotionSubsAdjId());
				autoDiscal.setRuleName(autoDiscall.getRuleName());
				System.out.println("before sabving autoDiscal.getRuleName : "+autoDiscal.getRuleName());
				autoDiscal.setRuleInd(autoDiscall.getRuleInd());
				autoDiscal.setRuleDesc(autoDiscall.getRuleDesc());
				autoDiscal.setRuleParameters(autoDiscall.getRuleParameters());
				autoDiscal.setVisDisqMsdFR(autoDiscall.getVisDisqMsdFR());
				autoDiscal.setVisDisqMsgEN(autoDiscall.getVisDisqMsgEN());
				Session session = HibernateUtil.openSession();
				System.out.println("New Object Created");
				session.save(autoDiscal);
				Transaction tx =session.beginTransaction();
	     		tx.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e: " + e);
		}
		return "AutoDiscall Object Saved Successfully  ";
	}

	public String saveCreditCalcObj(List<CreditCalc> creditcalList) {
		try {
			CreditCalc creditCal = null;
			System.out.println("creditcalList size is : "+creditcalList.size());
			for(CreditCalc creditCalc : creditcalList) {
				creditCal = new CreditCalc();
				creditCal.setPromotionId(creditCalc.getPromotionId());
				creditCal.setPromotionSubsAdjId(creditCalc.getPromotionSubsAdjId());
				creditCal.setRuleName(creditCalc.getRuleName());
				creditCal.setRuleInd(creditCalc.getRuleInd());
				creditCal.setRuleDesc(creditCalc.getRuleDesc());
				creditCal.setRuleParameters(creditCalc.getRuleParameters());
				Session session = HibernateUtil.openSession();
				session.save(creditCal);
				Transaction tx =session.beginTransaction();
	     		tx.commit();
			}
			System.out.println("after saving creditcall Object");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e: " + e);
			return "Error while saving promo data .....  "+e.getCause();
		}

		return "AutoDiscall Object Saved Successfully  ";
	}
	
	
	public String savemonitoringObj(List<Monitoring> monitoringList) {
		try {
			Monitoring monitor = null;
			System.out.println("creditcalList size is : "+monitoringList.size());
			for(Monitoring monitoring : monitoringList) {
				monitor = new Monitoring();
				monitor.setPromotionId(monitoring.getPromotionId());
				System.out.println("getPromotionId >>> : "+monitor.getPromotionId());
				monitor.setPromotionSubsAdjId(monitoring.getPromotionSubsAdjId());
				monitor.setRuleName(monitoring.getRuleName());
				System.out.println("getRuleName >>>. : "+monitor.getRuleName());
				monitor.setRuleInd(monitoring.getRuleInd());
				System.out.println("creditCal.getRuleInd() : "+monitor.getRuleInd() );
				monitor.setRuleDesc(monitoring.getRuleDesc());
				System.out.println("creditCal.getRuleDesc : "+monitor.getRuleDesc());
				monitor.setRuleParameters(monitoring.getRuleParameters());
				System.out.println("creditCal.getRuleParameters : "+monitor.getRuleParameters());
				Session session = HibernateUtil.openSession();
				System.out.println("before saving AutoDiscall Object");
				System.out.println("New Object Created");
				session.save(monitor);
				Transaction tx =session.beginTransaction();
	     		tx.commit();
			}
			System.out.println("after saving AutoDiscall Object");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e: " + e);
			return "Error while saving promo data .....  "+e.getCause();
		}
		return "AutoDiscall Object Saved Successfully  ";
	}
	
	public List<PromoConfig> getPromoConfig() {
		List<PromoConfig> promoConfigListObj = new ArrayList<PromoConfig>();
		Session session = HibernateUtil.openSession();
		String query = "select promotion_id, promotion_subs_adj_id from PROMO_Auto_CONFIG";
		SQLQuery sqlQury=session.createSQLQuery(query);
		
		@SuppressWarnings("unchecked")
		List<Object[]> promoCongList=(List<Object[]>)sqlQury.list();
		System.out.println("promoCongList size : "+promoCongList.size());
		for(Object[] ary : promoCongList){
			PromoConfig promoConfig=new PromoConfig();
			promoConfig.setPromotionId(((String)ary[0]));
			promoConfig.setPromoationSubsAdjId(BigDecimal.valueOf(new Integer(String.valueOf(ary[1]))).intValue());
			promoConfigListObj.add(promoConfig);
		}
		return promoConfigListObj;
	}
	
	
	public List<CreditCalc> getCreditCalc() {
		List<CreditCalc> creditCalcObjList = new ArrayList<CreditCalc>();
		Session session = HibernateUtil.openSession();
		String query = "select promotion_id, promotion_subs_adj_id from PROMO_Auto_CONFIG";
		SQLQuery sqlQury=session.createSQLQuery(query);
	
		@SuppressWarnings("unchecked")
		List<Object[]> creditCalcList=(List<Object[]>)sqlQury.list();
		System.out.println("assigneesList size : "+creditCalcList.size());
		for(Object[] ary : creditCalcList){
			CreditCalc creditCalc=new CreditCalc();
			creditCalc.setPromotionId(((String)ary[0]));
			creditCalc.setPromotionSubsAdjId(BigDecimal.valueOf(new Integer(String.valueOf(ary[1]))).intValue());
			creditCalcObjList.add(creditCalc);
		}
		
		
		return creditCalcObjList;
	}
	
	
	public List<Monitoring> getMonitoring() {
		List<Monitoring> monitoringObjList = new ArrayList<Monitoring>();
		Session session = HibernateUtil.openSession();
		String query = "select promotion_id, promotion_subs_adj_id from PROMO_Auto_CONFIG";
		SQLQuery sqlQury=session.createSQLQuery(query);
		
		@SuppressWarnings("unchecked")
		List<Object[]> monitoringList=(List<Object[]>)sqlQury.list();
		System.out.println("assigneesList size : "+monitoringList.size());
		for(Object[] ary : monitoringList){
			Monitoring monitoring=new Monitoring();
			monitoring.setPromotionId(((String)ary[0]));
			monitoring.setPromotionSubsAdjId(BigDecimal.valueOf(new Integer(String.valueOf(ary[1]))).intValue());
			monitoringObjList.add(monitoring);
		}
		return monitoringObjList;
	}
	
	public static int getPromotionSubsAdjId(String promotionId) {
		
		Session session = HibernateUtil.openSession();
		String qry =  "select promotion_subs_adj_id from promo_auto_config where promotion_id = "+"'"+promotionId+"'";
		SQLQuery query = session.createSQLQuery(qry);
		int promotionSubsAdjId = BigDecimal.valueOf(new Integer(String.valueOf(query.uniqueResult()))).intValue();
		System.out.println("promotionSubsAdjId===>>"+promotionSubsAdjId);
		return promotionSubsAdjId;
	}
	
	
	
	public static void main(String [] args) {
		PromoConfigDAO prmconfig = new PromoConfigDAO();
		String promotionId = "Q216AHW0723";
		int value = PromoConfigDAO.getPromotionSubsAdjId(promotionId);
		System.out.println("promotionSubsAdjId final value : "+value);
		
	}
}
