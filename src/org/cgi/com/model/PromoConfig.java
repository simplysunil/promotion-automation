package org.cgi.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROMO_Auto_CONFIG")
public class PromoConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROMOTION_ID")
	private String promotionId;

	@Column(name = "ARTICLE_NO")
	private String articleNo;
	
	@Column(name = "PROMOTION_SUBS_ADJ_ID")
	private int promoationSubsAdjId;
	
	@Column(name = "PROMO_NAME")
	private String promoName;
	
	@Column(name = "PROMO_START_DATE")
	private Date promoStartDate;
	
	@Column(name = "PROMO_END_DATE")
	private Date promoEndDate;
	
	@Column(name = "PROMO_QUAL_END_DATE")
	private Date promoQualEndDate;
	
	@Column(name = "PROMO_DECOM_DATE")
	private Date promoDecomDate;

	@Column(name = "LEDGER_DESC_EN")
	private String ledgerDescEn;
	
	@Column(name = "LEDGER_DESC_FR")
	private String ledgerDescFr;
	
	@Column(name = "CSG_SERVICE_CD")
	private String csgServiceCD;
	
	@Column(name = "CSG_REASON_CD")
	private String csgReasonCD;
	
	@Column(name = "EXCL_PERM_DISC_IND")
	private String exclPermDiscInd;
	
	@Column(name = "PROMO_NAME_EN")
	private String promoNameEn;
	
	@Column(name = "PROMO_NAME_FR")
	private String promoNameFr;
	
	@Column(name = "PROMO_DESC_EN")
	private String promoDescEn;
	
	@Column(name = "PROMO_DESC_FR")
	private String promoDescFr;

	@Column(name = "PROMO_CATEGORY")
	private String promoCategory;
	
	@Column(name = "PROMO_CREDIT_TYPE")
	private String promoCreditType;
	
	@Column(name = "MULTI_QUAL_ALLOWED_ONEVU")
	private String multiQualAllowedOneVu;
	
	@Column(name = "FORCE_CREDIT_ON_TPS")
	private String forceCreditONTPS;
	
	@Column(name = "GLOBAL_FORCE_QUAL_IND")
	private String globalForceQualInd;
	
	@Column(name = "GLOBAL_FORCE_DISQ_IND")
	private String globalForceDisqInd;
	
	@Column(name = "FIRST_CREDIT_BY")
	private String firstCreditBY;
	
	@Column(name = "CREDIT_CALC_TYPE")
	private String creditCalcType;
	
	@Column(name = "QSP_INITIAL_SETUP_IND")
	private String qspInitialSetupInd;

	@Column(name = "DISQUAL_PROCESS_IND")
	private String disqualProcessInd;
	
	@Column(name = "MONITOR_PROCESS_IND")
	private String monitorProcessInd;
	
	@Column(name = "CALC_CRED_ONCE_IND")
	private String calcCredOnceInd;
	
	@Column(name = "TOTAL_NO_OF_CYCLES")
	private int totalNoOfCycles;
	
	@Column(name = "FLAT_CREDIT_AMT")
	private int flatCreditAmt;
	
	@Column(name = "PERCENTAGE")
	private int percentage;
	
	@Column(name = "CAP_AMT")
	private int capAmt;
	
	@Column(name = "LOSE_SKIP_CYCLE_IND")
	private String loseSkipCycleInd;
	
	@Column(name = "OFFER_TYPE")
	private String offerType;
	
	@Column(name = "INIT_CREDIT_NO")
	private String initCrdeitNo;
	
	@Column(name = "CLAWBACK_IND")
	private String clabBackInd;
	
	@Column(name = "DISQUALIFY_IND")
	private String disqualifyInd;
	
	@Column(name = "REGISTRATION_CLAWBACK_IND")
	private String registrationClawbackInd;
	
	@Column(name = "REGISTRATION_DISQUALIFY_IND")
	private String registrationDisqualifyInd;
	
	@Column(name = "CLAWBACK_MONITOR_IND")
	private String clawbackMonitorInd;
	
	@Column(name = "DISQUALIFY_MONITOR_IND")
	private String disqualifyMonitorInd;
	
	@Column(name = "CLAWBACK_VISIBILITY_IND")
	private String clawbackVisibilityInd;
	
	@Column(name = "DISPLAY_PROMO_START_DATE")
	private String displayPromoStartDate;
	
	@Column(name = "DISPLAY_PROMO_END_DATE")
	private String displayPromoEndDate;
	
	@Column(name = "DISPLAY_PROMO_BILL_DATES")
	private String displayPromoBillDates;
	
	@Column(name = "DISPLAY_QUAL_INFO")
	private String displayQualInfo;
	
	@Column(name = "DISPLAY_CREDIT_INFO")
	private String displayCreditInfo;
	
	@Column(name = "PROMO_CTGRY_IND")
	private String promoCtgryInd;
	
	@Column(name = "PROMO_UPD_IND")
	private String promoUpdInd;
	
	@Column(name = "PROFILE_QUAL_VIS_IND")
	private String profileQualVisInd;
	
	@Column(name = "PROFILE_CREDIT_VIS_IND")
	private String profileCrdeitVisInd;
	
	@Column(name = "DISPLAY_CLAWBACK_INFO")
	private String displayClawbackInfo;
	
	@Column(name = "MULTI_QUAL_ALLOWED_FQ")
	private char multiQualAllowedFQ;

	@Column(name = "REQUAL_ALLOWED_FQ")
	private char requalAllowedFq;
	
	@Column(name = "DISQUAL_ALLOWED_FQ")
	private char disqualAllowedFq;
	
	@Column(name = "DISQ_MSG_ID")
	private double disqMsgId;
	
	@Column(name = "DISQ_MSG_INTERNAL")
	private String disqMsgInternal;
	
	@Column(name = "VIS_DISQ_MSG_EN")
	private String visDisqMsgEn;
	
	@Column(name = "VIS_DISQ_MSG_FR")
	private String visDisqMsgFr;

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public String getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}

	public int getPromoationSubsAdjId() {
		return promoationSubsAdjId;
	}

	public void setPromoationSubsAdjId(int promoationSubsAdjId) {
		this.promoationSubsAdjId = promoationSubsAdjId;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public Date getPromoStartDate() {
		return promoStartDate;
	}

	public void setPromoStartDate(Date promoStartDate) {
		this.promoStartDate = promoStartDate;
	}

	public Date getPromoEndDate() {
		return promoEndDate;
	}

	public void setPromoEndDate(Date promoEndDate) {
		this.promoEndDate = promoEndDate;
	}

	public Date getPromoQualEndDate() {
		return promoQualEndDate;
	}

	public void setPromoQualEndDate(Date promoQualEndDate) {
		this.promoQualEndDate = promoQualEndDate;
	}


	public Date getPromoDecomDate() {
		return promoDecomDate;
	}

	public void setPromoDecomDate(Date promoDecomDate) {
		this.promoDecomDate = promoDecomDate;
	}

	public String getLedgerDescEn() {
		return ledgerDescEn;
	}

	public void setLedgerDescEn(String ledgerDescEn) {
		this.ledgerDescEn = ledgerDescEn;
	}

	public String getLedgerDescFr() {
		return ledgerDescFr;
	}

	public void setLedgerDescFr(String ledgerDescFr) {
		this.ledgerDescFr = ledgerDescFr;
	}

	public String getCsgServiceCD() {
		return csgServiceCD;
	}

	public void setCsgServiceCD(String csgServiceCD) {
		this.csgServiceCD = csgServiceCD;
	}

	public String getCsgReasonCD() {
		return csgReasonCD;
	}

	public void setCsgReasonCD(String csgReasonCD) {
		this.csgReasonCD = csgReasonCD;
	}

	public String getExclPermDiscInd() {
		return exclPermDiscInd;
	}

	public void setExclPermDiscInd(String exclPermDiscInd) {
		this.exclPermDiscInd = exclPermDiscInd;
	}

	public String getPromoNameEn() {
		return promoNameEn;
	}

	public void setPromoNameEn(String promoNameEn) {
		this.promoNameEn = promoNameEn;
	}

	public String getPromoNameFr() {
		return promoNameFr;
	}

	public void setPromoNameFr(String promoNameFr) {
		this.promoNameFr = promoNameFr;
	}

	public String getPromoDescEn() {
		return promoDescEn;
	}

	public void setPromoDescEn(String promoDescEn) {
		this.promoDescEn = promoDescEn;
	}

	public String getPromoDescFr() {
		return promoDescFr;
	}

	public void setPromoDescFr(String promoDescFr) {
		this.promoDescFr = promoDescFr;
	}

	public String getPromoCategory() {
		return promoCategory;
	}

	public void setPromoCategory(String promoCategory) {
		this.promoCategory = promoCategory;
	}

	public String getPromoCreditType() {
		return promoCreditType;
	}

	public void setPromoCreditType(String promoCreditType) {
		this.promoCreditType = promoCreditType;
	}

	public String getMultiQualAllowedOneVu() {
		return multiQualAllowedOneVu;
	}

	public void setMultiQualAllowedOneVu(String multiQualAllowedOneVu) {
		this.multiQualAllowedOneVu = multiQualAllowedOneVu;
	}

	public String getForceCreditONTPS() {
		return forceCreditONTPS;
	}

	public void setForceCreditONTPS(String forceCreditONTPS) {
		this.forceCreditONTPS = forceCreditONTPS;
	}

	public String getGlobalForceQualInd() {
		return globalForceQualInd;
	}

	public void setGlobalForceQualInd(String globalForceQualInd) {
		this.globalForceQualInd = globalForceQualInd;
	}

	public String getGlobalForceDisqInd() {
		return globalForceDisqInd;
	}

	public void setGlobalForceDisqInd(String globalForceDisqInd) {
		this.globalForceDisqInd = globalForceDisqInd;
	}

	public String getFirstCreditBY() {
		return firstCreditBY;
	}

	public void setFirstCreditBY(String firstCreditBY) {
		this.firstCreditBY = firstCreditBY;
	}

	public String getCreditCalcType() {
		return creditCalcType;
	}

	public void setCreditCalcType(String creditCalcType) {
		this.creditCalcType = creditCalcType;
	}

	public String getQspInitialSetupInd() {
		return qspInitialSetupInd;
	}

	public void setQspInitialSetupInd(String qspInitialSetupInd) {
		this.qspInitialSetupInd = qspInitialSetupInd;
	}

	public String getDisqualProcessInd() {
		return disqualProcessInd;
	}

	public void setDisqualProcessInd(String disqualProcessInd) {
		this.disqualProcessInd = disqualProcessInd;
	}

	public String getMonitorProcessInd() {
		return monitorProcessInd;
	}

	public void setMonitorProcessInd(String monitorProcessInd) {
		this.monitorProcessInd = monitorProcessInd;
	}

	public String getCalcCredOnceInd() {
		return calcCredOnceInd;
	}

	public void setCalcCredOnceInd(String calcCredOnceInd) {
		this.calcCredOnceInd = calcCredOnceInd;
	}

	public int getTotalNoOfCycles() {
		return totalNoOfCycles;
	}

	public void setTotalNoOfCycles(int totalNoOfCycles) {
		this.totalNoOfCycles = totalNoOfCycles;
	}

	public double getFlatCreditAmt() {
		return flatCreditAmt;
	}

	public void setFlatCreditAmt(int flatCreditAmt) {
		this.flatCreditAmt = flatCreditAmt;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getCapAmt() {
		return capAmt;
	}

	public void setCapAmt(int capAmt) {
		this.capAmt = capAmt;
	}

	public String getLoseSkipCycleInd() {
		return loseSkipCycleInd;
	}

	public void setLoseSkipCycleInd(String loseSkipCycleInd) {
		this.loseSkipCycleInd = loseSkipCycleInd;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public String getInitCrdeitNo() {
		return initCrdeitNo;
	}

	public void setInitCrdeitNo(String initCrdeitNo) {
		this.initCrdeitNo = initCrdeitNo;
	}

	

	public String getClabBackInd() {
		return clabBackInd;
	}

	public void setClabBackInd(String clabBackInd) {
		this.clabBackInd = clabBackInd;
	}

	public String getDisqualifyInd() {
		return disqualifyInd;
	}

	public void setDisqualifyInd(String disqualifyInd) {
		this.disqualifyInd = disqualifyInd;
	}

	public String getRegistrationClawbackInd() {
		return registrationClawbackInd;
	}

	public void setRegistrationClawbackInd(String registrationClawbackInd) {
		this.registrationClawbackInd = registrationClawbackInd;
	}

	public String getRegistrationDisqualifyInd() {
		return registrationDisqualifyInd;
	}

	public void setRegistrationDisqualifyInd(String registrationDisqualifyInd) {
		this.registrationDisqualifyInd = registrationDisqualifyInd;
	}

	public String getClawbackMonitorInd() {
		return clawbackMonitorInd;
	}

	public void setClawbackMonitorInd(String clawbackMonitorInd) {
		this.clawbackMonitorInd = clawbackMonitorInd;
	}

	public String getDisqualifyMonitorInd() {
		return disqualifyMonitorInd;
	}

	public void setDisqualifyMonitorInd(String disqualifyMonitorInd) {
		this.disqualifyMonitorInd = disqualifyMonitorInd;
	}

	public String getClawbackVisibilityInd() {
		return clawbackVisibilityInd;
	}

	public void setClawbackVisibilityInd(String clawbackVisibilityInd) {
		this.clawbackVisibilityInd = clawbackVisibilityInd;
	}

	public String getDisplayPromoStartDate() {
		return displayPromoStartDate;
	}

	public void setDisplayPromoStartDate(String displayPromoStartDate) {
		this.displayPromoStartDate = displayPromoStartDate;
	}

	public String getDisplayPromoEndDate() {
		return displayPromoEndDate;
	}

	public void setDisplayPromoEndDate(String displayPromoEndDate) {
		this.displayPromoEndDate = displayPromoEndDate;
	}

	public String getDisplayPromoBillDates() {
		return displayPromoBillDates;
	}

	public void setDisplayPromoBillDates(String displayPromoBillDates) {
		this.displayPromoBillDates = displayPromoBillDates;
	}

	public String getDisplayQualInfo() {
		return displayQualInfo;
	}

	public void setDisplayQualInfo(String displayQualInfo) {
		this.displayQualInfo = displayQualInfo;
	}

	public String getDisplayCreditInfo() {
		return displayCreditInfo;
	}

	public void setDisplayCreditInfo(String displayCreditInfo) {
		this.displayCreditInfo = displayCreditInfo;
	}

	public String getPromoCtgryInd() {
		return promoCtgryInd;
	}

	public void setPromoCtgryInd(String promoCtgryInd) {
		this.promoCtgryInd = promoCtgryInd;
	}

	public String getPromoUpdInd() {
		return promoUpdInd;
	}

	public void setPromoUpdInd(String promoUpdInd) {
		this.promoUpdInd = promoUpdInd;
	}

	public String getProfileQualVisInd() {
		return profileQualVisInd;
	}

	public void setProfileQualVisInd(String profileQualVisInd) {
		this.profileQualVisInd = profileQualVisInd;
	}

	public String getProfileCrdeitVisInd() {
		return profileCrdeitVisInd;
	}

	public void setProfileCrdeitVisInd(String profileCrdeitVisInd) {
		this.profileCrdeitVisInd = profileCrdeitVisInd;
	}

	public String getDisplayClawbackInfo() {
		return displayClawbackInfo;
	}

	public void setDisplayClawbackInfo(String displayClawbackInfo) {
		this.displayClawbackInfo = displayClawbackInfo;
	}

	public char getMultiQualAllowedFQ() {
		return multiQualAllowedFQ;
	}

	public void setMultiQualAllowedFQ(char multiQualAllowedFQ) {
		this.multiQualAllowedFQ = multiQualAllowedFQ;
	}

	public char getRequalAllowedFq() {
		return requalAllowedFq;
	}

	public void setRequalAllowedFq(char requalAllowedFq) {
		this.requalAllowedFq = requalAllowedFq;
	}

	public char getDisqualAllowedFq() {
		return disqualAllowedFq;
	}

	public void setDisqualAllowedFq(char disqualAllowedFq) {
		this.disqualAllowedFq = disqualAllowedFq;
	}

	public double getDisqMsgId() {
		return disqMsgId;
	}

	public void setDisqMsgId(double disqMsgId) {
		this.disqMsgId = disqMsgId;
	}

	public String getDisqMsgInternal() {
		return disqMsgInternal;
	}

	public void setDisqMsgInternal(String disqMsgInternal) {
		this.disqMsgInternal = disqMsgInternal;
	}

	public String getVisDisqMsgEn() {
		return visDisqMsgEn;
	}

	public void setVisDisqMsgEn(String visDisqMsgEn) {
		this.visDisqMsgEn = visDisqMsgEn;
	}

	public String getVisDisqMsgFr() {
		return visDisqMsgFr;
	}

	public void setVisDisqMsgFr(String visDisqMsgFr) {
		this.visDisqMsgFr = visDisqMsgFr;
	}

}
