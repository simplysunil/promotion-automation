package org.cgi.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auto_disqual_rules")
public class AutoDiscall {
	
	@Id
	@Column(name = "PROMOTION_ID")
	private String promotionId;
	@Column(name = "PROMOTION_SUBS_ADJ_ID")
	private int promotionSubsAdjId;
	@Column(name = "RULE_NAME")
	private String ruleName;
	@Column(name = "RULE_DESC")
	private String ruleDesc;
	@Column(name = "RULE_IND")
	private String ruleInd;
	@Column(name = "RULE_PARAMETERS")
	private String ruleParameters;
	@Column(name = "VIS_DISQ_MSG_EN")
	private String visDisqMsgEN;
	@Column(name = "VIS_DISQ_MSG_FR")
	private String visDisqMsdFR;
	
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public int getPromotionSubsAdjId() {
		return promotionSubsAdjId;
	}
	public void setPromotionSubsAdjId(int promotionSubsAdjId) {
		this.promotionSubsAdjId = promotionSubsAdjId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleDesc() {
		return ruleDesc;
	}
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}
	public String getRuleInd() {
		return ruleInd;
	}
	public void setRuleInd(String ruleInd) {
		this.ruleInd = ruleInd;
	}
	public String getRuleParameters() {
		return ruleParameters;
	}
	public void setRuleParameters(String ruleParameters) {
		this.ruleParameters = ruleParameters;
	}
	public String getVisDisqMsgEN() {
		return visDisqMsgEN;
	}
	public void setVisDisqMsgEN(String visDisqMsgEN) {
		this.visDisqMsgEN = visDisqMsgEN;
	}
	public String getVisDisqMsdFR() {
		return visDisqMsdFR;
	}
	public void setVisDisqMsdFR(String visDisqMsdFR) {
		this.visDisqMsdFR = visDisqMsdFR;
	}
	
}


