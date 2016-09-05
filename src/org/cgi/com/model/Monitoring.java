/**
 * 
 */
package org.cgi.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sunil.kumar2
 *
 */

@Entity
@Table(name = "auto_monitoring_rules")
public class Monitoring {
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
	public String getRuleParameters() {
		return ruleParameters;
	}
	public void setRuleParameters(String ruleParameters) {
		this.ruleParameters = ruleParameters;
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
	
}
