<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>



<!-- <!DOCTYPE html> -->
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="images/favicon.png" type="image/png">
<title>Bell TV</title>
<link rel="stylesheet" href="css/jquery-ui-1.11.0.css" />
<link rel="stylesheet" href="css/tprm.css" />


<style>
.customInput input[type="checkbox"], .customInput input[type="radio"] {
	display: none !important
}

.tprmerrormsg {
	color: #FF0000;
	font-style: normal;
	display: block;
	float: left;
}

.checkboxStyle {
	width: 10%;
}

#checkbox {
	width: 18px;
}

.labelStyle {
	width: 46% !important;
	padding-top: 10px;
}

.errorMessage {
	display: block;
	padding-bottom: 6px;
	overflow: hidden
}

.innerHeading {
	background: #fff;
	margin: 10px 0 0 0;
	padding: 0 15px;
}

.innerHeading h2 {
	padding-top: 1em;
	padding-bottom: 1em;
	padding-left: 1em;
}

.innerHeading h1, .innerHeading h2 {
	font-size: 1.3em;
}

.tenant_container {
	min-height: 300px;
}

.topheading {
    width: 18%;
    font-feature-settings: inherit;
    font-size: large;
}
/* .add_container {
	margin: 3px 0 10px;
} */
</style>

</head>

<body>

	<!-- Preloader starts here-->
	<div id="preloader">
		<div id="status">
			<i class="fa fa-spinner fa-spin"></i>
		</div>
	</div>
	<div class="mainpanel TPRM_bg">

		<jsp:include page="header.jsp"></jsp:include>
		<!--- Menus ends here -->
		<div class="clear"></div>
		<div class="innerHeading">
			<h1 class="title">Promotion Automation</h1>
			<div class="clr"></div>
		</div>
		<div class="clr"></div>
		<!-- container starts here-->
		
		<div class="row"> 
		<div class="col-sm-2 topheading title">
			<c:choose>
			    <c:when test="${sessionScope.DISQUAL_PROCESS=='1'}">
			        <form id="disqualRuleform" method="POST" action="disqualrules">
					<li><a onClick="document.getElementById('disqualRuleform').submit();">Disqual Rules</a></li>
						</form>
			        <br />
			    </c:when>    
			    <c:otherwise>
			        Disqual Rules
			   
			    </c:otherwise>
			</c:choose>
			</div>
			<div class="col-sm-2 topheading title">
			<c:choose>
			    <c:when test="${sessionScope.MONITOR_PROCESS=='1'}">
			       <form id="monitoringRuleform" method="POST" action="monitoringRule">
					<li><a onClick="document.getElementById('monitoringRuleform').submit();"> Monitoring </a></li>
				</form>
				
			        <br />
			    </c:when>    
			    <c:otherwise>
			        Monitoring Rules
			    </c:otherwise>
			</c:choose>
			</div> 
			<div class="col-sm-2 topheading title">
			<c:choose>
			    <c:when test="${sessionScope.CALCCRED_PROCESS=='1'}">
			         <form id="credircalcRuleform" method="POST" action="credircalcRule">
					<li><a onClick="document.getElementById('credircalcRuleform').submit();"> CreditCalc </a></li>
				</form>
			        <br />
			    </c:when>    
			    <c:otherwise>
			        CreditCalc Rules
			    </c:otherwise>
			</c:choose>
			</div>
		</div>
			
		<form action="promoConfig" method="post" name="myForm">

			<div class="container add_container tenant_container">
				<div class="containerPanel clearfix">
					<div class="um-form contract_form">
						<div class="row clear contract_row">

							<!-- Start first half Page -->


							<div class="col-sm-6">

								<div class="leftColFields">
									<label> Promotion Id </label> <input type="text"
										class="text_box tprm_input" name="promoationId" />
								</div>

								<div class="leftColFields">
									<label> Article Number </label> <input type="text"
										class="text_box tprm_input" name="articleNo" />
								</div>

								<div class="leftColFields">
									<label> Promotion Subs Adj Id </label> <input type="text"
										class="text_box tprm_input" name="promoationSubsAdjId" />
								</div>

								<div class="leftColFields">
									<label> Promo Name </label> <input type="text"
										class="text_box tprm_input" name="promoName" />
								</div>

								<div class="row">
									<div class="col-sm-6">
										<div class="leftColFields">
											<label> Promo Start Date </label> <input type="text"
												class="datepicker1" name="promoStartDate" />
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-sm-6">
										<div class="leftColFields">
											<label> Promo End Date </label> 
											<input type="text" class="datepicker1" name="promoEndDate" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-6">
										<div class="leftColFields">
											<label> Promo Qual End date </label> <input type="text"
												class="datepicker1" name="promoQualEndDate" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-6">
										<div class="leftColFields">
											<label> Promotion Dcom Date </label> <input type="text"
												class="datepicker1" name="promoDecomEndDate" />
										</div>
									</div>
								</div>

								<div class="leftColFields">
									<label> Ledger Description EN </label> <input type="text"
										class="text_box tprm_input" name="ledgerDescEn" />
								</div>

								<div class="leftColFields">
									<label> Ledger Description FR </label> <input type="text"
										class="text_box tprm_input" name="ledgerDescFr" />
								</div>



								<div class="leftColFields">
									<label> CSG Service Code </label> <input type="text"
										class="text_box tprm_input" name="csgServiceCD" />
								</div>

								<div class="leftColFields">
									<label> CSG Reason Code </label> <input type="text"
										class="text_box tprm_input" name="csgReasonCD" />
								</div>


							<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="exclPermDiscInd" id="exclPermDiscIndId" />
												<input type="hidden" value="0" name="exclPermDiscInd"
												id="exclPermDiscIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Excl Perm Disc Ind<</div>									
								</div> 


								<div class="leftColFields">
									<label> Promotion Name EN </label> <input type="text"
										class="text_box tprm_input" name="promoNameEn" />
								</div>

								<div class="leftColFields">
									<label> Promotion Name FR </label> <input type="text"
										class="text_box tprm_input" name="promoNameFr" />
								</div>

								<div class="leftColFields">
									<label> Promotion Description EN </label> <input type="text"
										class="text_box tprm_input" name="promoDescEn" />
								</div>

								<div class="leftColFields">
									<label> Promotion Description FR </label> <input type="text"
										class="text_box tprm_input" name="promoDescFr" />
								</div>

								<div class="row">
									<div class="col-sm-6">
										<div class="clear leftColRegion">
											<label> Promotion Category </label> <br /> <select
												class="customSelectNew" name="promoCategory">
												<option selected value="">-Select-</option>
												<option value="Loyalty-Save">Loyalty-Save</option>
												<option value="Acquisition">Acquisition</option>
												<option value="Loyalty- Upsell">Loyalty- Upsell</option>
												<option value="Non-promotion">Audi</option>
												<option value="Loyalty">Loyalty</option>
											</select>
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-sm-6">
										<div class="clear leftColRegion">
											<label> Promo Credit Type </label> <br /> <select
												class="customSelectNew" name="promoCreditType">
												<option selected value="">-Select-</option>
												<option value="DSF">DSF</option>
												<option value="PROGRAMMING">PROGRAMMING</option>
												<option value="HARDWARE">HARDWARE</option>
											</select>
										</div>
									</div>
								</div>



								<!-- <div class="row">
									<div class="col-sm-6">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="multiQualAllowedOneVu" id="multiQualAllowedOneVuId" />
												<input type="hidden" value="0" name="multiQualAllowedOneVu"
												id="multiQualAllowedOneVuIdHidden" /> <label
												for="multiQualAllowedOneVuId">Multi Qual Allowed OneVu</label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="multiQualAllowedOneVu" id="multiQualAllowedOneVuId" />
												<input type="hidden" value="0" name="multiQualAllowedOneVu"
												id="multiQualAllowedOneVuIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Multi Qual Allowed OneVu</div>									
								</div> 


								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="forceCreditONTPS" id="forceCreditONTPSId" /> <input
												type="hidden" value="0" name="forceCreditONTPS"
												id="forceCreditONTPSIdHidden" /> <label
												for="forceCreditONTPSId">Force Credit On TPS </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="forceCreditONTPS" id="forceCreditONTPSId" /> <input
												type="hidden" value="0" name="forceCreditONTPS"
												id="forceCreditONTPSIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Force Credit On TPS </div>									
								</div> 


							<!-- 	<div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="globalForceQualInd" id="globalForceQualIndId" /> <input
												type="hidden" value="0" name="globalForceQualInd"
												id="globalForceQualIndIdHidden" /> <label
												for="globalForceQualIndId">Global Force QUAL Ind </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="globalForceQualInd" id="globalForceQualIndId" /> <input
												type="hidden" value="0" name="globalForceQualInd"
												id="globalForceQualIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Global Force QUAL Ind</div>									
								</div> 

							<!-- 	<div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span><input type="checkbox" value="1"
												name="globalForceDisqInd" id="globalForceDisqInd" /> <input
												type="hidden" value="0" name="globalForceDisqInd"
												id="globalForceDisqIndHidden" /> <label
												for="checkboxDefault"> Global Force DISQ Ind </label></span>
										</div>
									</div>
								</div> -->

							<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="globalForceDisqInd" id="globalForceDisqInd" /> <input
												type="hidden" value="0" name="globalForceDisqInd"
												id="globalForceDisqIndHidden" /></div>
									<div class="col-sm-3 labelStyle">Global Force DISQ Ind </div>									
								</div> 

								<div class="row">
									<div class="col-sm-6">
										<div class="clear leftColRegion">
											<label> First Credit By </label> <br /> <select
												class="customSelectNew" name="firstCreditBY">
												<option selected value="">-Select-</option>
												<option value="0">Onevu</option>
												<option value="1">Promo</option>
											</select>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-6">
										<div class="clear leftColRegion">
											<label>Credit Calc Type </label> <br /> <select
												class="customSelectNew" name="creditCalcType">
												<option selected value="">-Select-</option>
												<option value="Flat">Flat</option>
												<option value="Dynamic">Dynamic</option>
											</select>
										</div>
									</div>
								</div>




							</div>
							<!-- half page div close -->


							<!-- End first half Page -->

							<!-- Start second half Page -->

							<div class="col-sm-6">

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="qspInitialSetupInd" id="qspInitialSetupIndId" /> <input
												type="hidden" value="0" name="qspInitialSetupInd"
												id="qspInitialSetupIndIdHidden" /> <label
												for="qspInitialSetupIndId">QSP Initial Setup Ind </label></span>
										</div>
									</div>
								</div> -->


								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="qspInitialSetupInd" id="qspInitialSetupIndId" /> <input
												type="hidden" value="0" name="qspInitialSetupInd"
												id="qspInitialSetupIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">QSP Initial Setup Ind</div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="disqualProcessInd" id="disqualProcessIndId" /> <input
												type="hidden" value="0" name="disqualProcessInd"
												id="disqualProcessIndIdHidden" /> <label
												for="disqualProcessIndId">DISQUAL Process Ind </label></span>
										</div>
									</div>
								</div> -->

								<div class="row">
									<div class="col-sm-2 checkboxStyle">
										<input id="checkbox" type="checkbox" value="1"
											name="disqualProcessInd" id="disqualProcessIndId" /> <input
											type="hidden" value="0" name="disqualProcessInd"
											id="disqualProcessIndIdHidden" />
									</div>
									<div class="col-sm-3 labelStyle">DISQUAL Process Ind</div>
								</div>
								
								
								

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="monitorProcessInd" id="monitorProcessIndId" /> <input
												type="hidden" value="0" name="monitorProcessInd"
												id="monitorProcessIndIdHidden" /> <label
												for="monitorProcessIndId">Monitor Process Ind </label></span>
										</div>
									</div>
								</div> -->

								<div class="row">
									<div class="col-sm-2 checkboxStyle">
										<input id="checkbox"  type="checkbox" value="1"
												name="monitorProcessInd" id="monitorProcessIndId" /> <input
												type="hidden" value="0" name="monitorProcessInd"
												id="monitorProcessIndIdHidden" />
									</div>
									<div class="col-sm-3 labelStyle">Monitor Process Ind </div>
								</div>

								<!-- <div class="leftColFields">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="calcCredOnceInd" id="calcCredOnceIndId" /> <input
												type="hidden" value="0" name="calcCredOnceInd"
												id="calcCredOnceIndIdHidden" /> <label
												for="calcCredOnceIndId">CALC Credit Once IND </label></span>
										</div>
									</div>
								</div> -->
<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="calcCredOnceInd" id="calcCredOnceIndId" /> <input
												type="hidden" value="0" name="calcCredOnceInd"
												id="calcCredOnceIndIdHidden" /></div>
									<div class="col-sm-3 labelStyle">CALC Credit Once IND</div>									
								</div> 


								<div class="leftColFields">
									<label> Total No of Cycles </label> <input type="text"
										class="text_box tprm_input" name="totalNoOfCycles" />
								</div>

								<div class="leftColFields">
									<label> Flat Credit Amt. </label> <input type="text"
										class="text_box tprm_input" name="flatCreditAmt" />
								</div>


								<div class="leftColFields">
									<label> Percentage </label> <input type="text"
										class="text_box tprm_input" name="percentage" />
								</div>

								<div class="leftColFields">
									<label> CAP amt. </label> <input type="text"
										class="text_box tprm_input" name="capAmt" />
								</div>

<!-- 
								<div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="loseSkipCycleInd" id="loseSkipCycleIndId" /> <input
												type="hidden" value="0" name="loseSkipCycleInd"
												id="loseSkipCycleIndIdHidden" /> <label
												for="loseSkipCycleIndId">Lose Skip Cycle Ind </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="loseSkipCycleInd" id="loseSkipCycleIndId" /> <input
												type="hidden" value="0" name="loseSkipCycleInd"
												id="loseSkipCycleIndIdHidden" /></div>
									<div class="col-sm-3 labelStyle">Lose Skip Cycle Ind</div>									
								</div> 

								<div class="row">
									<div class="col-sm-6">
										<div class="clear leftColRegion">
											<label> Offer Type </label> <br /> <select
												class="customSelectNew" name="offerType">
												<option selected value="">-Select-</option>
												<option value="Config">Config</option>
												<option value="Classic">Classic</option>
												<option value="Hybrid">Hybrid</option>
											</select>
										</div>
									</div>
								</div>

								<div class="leftColFields">
									<label> Initail Credit No </label> <input type="text"
										class="text_box tprm_input" name="initCrdeitNo" />
								</div>


							<!-- 	<div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default checkboxtest">
											<span> <input type="checkbox" value="1"
												name="clabBackInd" id="clabBackIndId" /> <input
												type="hidden" value="0" name="clabBackInd"
												id="clabBackIndIdHidden" /> <label for="clabBackIndId">Clawback
													Ind </label></span>
										</div>
									</div>
								</div> -->

								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="clabBackInd" id="clabBackIndId" /> <input
												type="hidden" value="0" name="clabBackInd"
												id="clabBackIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Clawback Ind </div>									
								</div> 
								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="disqualifyInd" id="disqualifyIndId" /> <input
												type="hidden" value="0" name="disqualifyInd"
												id="disqualifyIndIdHidden" /> <label for="disqualifyIndId">Disqualify
													Ind </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="disqualifyInd" id="disqualifyIndId" /> <input
												type="hidden" value="0" name="disqualifyInd"
												id="disqualifyIndIdHidden" /></div>
									<div class="col-sm-3 labelStyle">Disqualify
													Ind</div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="registrationClawbackInd"
												id="registrationClawbackIndId" /> <input type="hidden"
												value="0" name="registrationClawbackInd"
												id="registrationClawbackIndIdHidden" /> <label
												for="registrationClawbackIndId">Registration
													Clawback Ind </label></span>
										</div>
									</div>
								</div>
								 -->
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="registrationClawbackInd"
												id="registrationClawbackIndId" /> <input type="hidden"
												value="0" name="registrationClawbackInd"
												id="registrationClawbackIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Registration
													Clawback Ind </div>									
								</div> 
								
								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="registrationDisqualifyInd"
												id="registrationDisqualifyIndId" /> <input type="hidden"
												value="0" name="registrationDisqualifyInd"
												id="registrationDisqualifyIndIdHidden" /> <label
												for="registrationDisqualifyIndId">Registration
													Disqualify Ind </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="registrationDisqualifyInd"
												id="registrationDisqualifyIndId" /> <input type="hidden"
												value="0" name="registrationDisqualifyInd"
												id="registrationDisqualifyIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Registration
													Disqualify Ind</div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="clawbackMonitorInd" id="clawbackMonitorIndId" /> <input
												type="hidden" value="0" name="clawbackMonitorInd"
												id="clawbackMonitorIndIdHidden" /> <label
												for="clawbackMonitorIndId">Clawback Monitor Ind </label></span>
										</div>
									</div>
								</div> -->
								
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="clawbackMonitorInd" id="clawbackMonitorIndId" /> <input
												type="hidden" value="0" name="clawbackMonitorInd"
												id="clawbackMonitorIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Clawback Monitor Ind</div>									
								</div> 
								
								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="disqualifyMonitorInd" id="disqualifyMonitorIndId" />
												<input type="hidden" value="0" name="disqualifyMonitorInd"
												id="disqualifyMonitorIndIdHidden" /> <label
												for="disqualifyMonitorIndId">Disqualify Monitor Ind
											</label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="disqualifyMonitorInd" id="disqualifyMonitorIndId" />
												<input type="hidden" value="0" name="disqualifyMonitorInd"
												id="disqualifyMonitorIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Disqualify Monitor Ind</div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="clawbackVisibilityInd" id="clawbackVisibilityIndId" />
												<input type="hidden" value="0" name="clawbackVisibilityInd"
												id="clawbackVisibilityIndIdHidden" /> <label
												for="clawbackVisibilityIndId">Clawbakc Visibility
													Ind </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="clawbackVisibilityInd" id="clawbackVisibilityIndId" />
												<input type="hidden" value="0" name="clawbackVisibilityInd"
												id="clawbackVisibilityIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Clawbakc Visibility
													Ind</div>									
								</div> 


							<!-- 	<div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="displayPromoStartDate" id="displayPromoStartDateId" />
												<input type="hidden" value="0" name="displayPromoStartDate"
												id="displayPromoStartDateIdHidden" /> <label
												for="displayPromoStartDateId">Display Promo Strat
													Date </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="displayPromoStartDate" id="displayPromoStartDateId" />
												<input type="hidden" value="0" name="displayPromoStartDate"
												id="displayPromoStartDateIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Display Promo Strat
													Date</div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="displaPromoEndDate" id="displaPromoEndDateId" /> <input
												type="hidden" value="0" name="displaPromoEndDate"
												id="displaPromoEndDateIdHidden" /> <label
												for="displaPromoEndDateId">Display Promo End Date </label></span>
										</div>
									</div>
								</div>
 -->
			<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="displaPromoEndDate" id="displaPromoEndDateId" /> <input
												type="hidden" value="0" name="displaPromoEndDate"
												id="displaPromoEndDateIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Display Promo End Date</div>									
								</div> 
								
								

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="displayPromoBillDates" id="displayPromoBillDatesId" />
												<input type="hidden" value="0" name="displayPromoBillDates"
												id="displayPromoBillDatesIdHidden" /> <label
												for="displayPromoBillDatesId">Display Promo Bill
													Date </label></span>
										</div>
									</div>
								</div>
								 -->
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="displayPromoBillDates" id="displayPromoBillDatesId" />
												<input type="hidden" value="0" name="displayPromoBillDates"
												id="displayPromoBillDatesIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Display Promo Bill Date</div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="displayQualInfo" id="displayQualInfoId" /> <input
												type="hidden" value="0" name="displayQualInfo"
												id="displayQualInfoIdHidden" /> <label
												for="displayQualInfoId">Display QUAL Info </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="displayQualInfo" id="displayQualInfoId" /> <input
												type="hidden" value="0" name="displayQualInfo"
												id="displayQualInfoIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Display QUAL Info</div>									
								</div> 
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="displayCreditInfo" id="displayCreditInfoId" /> <input
												type="hidden" value="0" name="displayQualInfo"
												id="displayCreditInfoIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Display Credit Info</div>									
								</div> 
								

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="displayCreditInfo" id="displayCreditInfoId" /> <input
												type="hidden" value="0" name="displayCreditInfo"
												id="displayCreditInfoIdHidden" /> <label
												for="displayCreditInfoId">Promo Category Ind </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="promoCtgryInd" id="promoCtgryIndId" /> <input
												type="hidden" value="0" name="displayCreditInfo"
			=====									id="promoCtgryIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Promo Category Ind</div>									
								</div> 
								
								

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="promoUpdInd" id="promoUpdIndId" /> <input
												type="hidden" value="0" name="promoUpdInd"
												id="promoUpdIndIdHidden" /> <label for="promoUpdIndId">Promo
													UPD ind </label></span>
										</div>
									</div>
								</div> -->


<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="promoUpdInd" id="promoUpdIndId" /> <input
												type="hidden" value="0" name="promoUpdInd"
												id="promoUpdIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Promo
													UPD ind</div>									
								</div> 
								
								
								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="profileQualVisInd" id="profileQualVisIndId" /> <input
												type="hidden" value="0" name="profileQualVisInd"
												id="profileQualVisIndIdHidden" /> <label
												for="profileQualVisIndId">Profile QUAL VIS Ind </label></span>
										</div>
									</div>
								</div>
								 -->
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox"  type="checkbox" value="1"
												name="profileQualVisInd" id="profileQualVisIndId" /> <input
												type="hidden" value="0" name="profileQualVisInd"
												id="profileQualVisIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Profile QUAL VIS Ind </div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="profileCrdeitVisInd" id="profileCrdeitVisIndId" /> <input
												type="hidden" value="0" name="profileCrdeitVisInd"
												id="profileCrdeitVisIndIdHidden" /> <label
												for="profileCrdeitVisIndId">Profile Credit VIS Ind </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="profileCrdeitVisInd" id="profileCrdeitVisIndId" /> <input
												type="hidden" value="0" name="profileCrdeitVisInd"
												id="profileCrdeitVisIndIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Profile Credit VIS Ind</div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="1"
												name="displayClawbackInfo" id="displayClawbackInfoId" /> <input
												type="hidden" value="0" name="displayClawbackInfo"
												id="displayClawbackInfoIdHidden" /> <label
												for="displayClawbackInfoId"> Display Clawback Info </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="1"
												name="displayClawbackInfo" id="displayClawbackInfoId" /> <input
												type="hidden" value="0" name="displayClawbackInfo"
												id="displayClawbackInfoIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Display Clawback Info</div>									
								</div> 

							<!-- 	<div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="Y"
												name="multiQualAllowedFQ" id="multiQualAllowedFQId" /> <input
												type="hidden" value="N" name="multiQualAllowedFQ"
												id="multiQualAllowedFQIdHidden" /> <label
												for="multiQualAllowedFQId">Multi QUAL Allowed FQ </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="Y"
												name="multiQualAllowedFQ" id="multiQualAllowedFQId" /> <input
												type="hidden" value="N" name="multiQualAllowedFQ"
												id="multiQualAllowedFQIdHidden"/></div>
									<div class="col-sm-3 labelStyle">Multi QUAL Allowed FQ</div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="Y"
												name="requalAllowedFq" id="requalAllowedFqId" /> <input
												type="hidden" value="N" name="requalAllowedFq"
												id="requalAllowedFqIdHidden"> <label
												for="requalAllowedFqId">REQUAL Allowed FQ </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="Y"
												name="requalAllowedFq" id="requalAllowedFqId" /> <input
												type="hidden" value="N" name="requalAllowedFq"
												id="requalAllowedFqIdHidden"/></div>
									<div class="col-sm-3 labelStyle">REQUAL Allowed FQ </div>									
								</div> 

								<!-- <div class="row">
									<div class="col-sm-4">
										<div class="ckbox ckbox-default">
											<span> <input type="checkbox" value="Y"
												name="disqualAllowedFq" id="disqualAllowedFqId" /> <input
												type="hidden" value="N" name="disqualAllowedFq"
												id="disqualAllowedFqIdHidden" /> <label
												for="disqualAllowedFqId">DISQUAL_ALLOWED_FQ: </label></span>
										</div>
									</div>
								</div> -->
								
								<div class="row">
									<div  class="col-sm-2 checkboxStyle"><input id="checkbox" type="checkbox" value="Y"
												name="disqualAllowedFq" id="disqualAllowedFqId" /> <input
												type="hidden" value="N" name="disqualAllowedFq"
												id="disqualAllowedFqIdHidden"/></div>
									<div class="col-sm-3 labelStyle">DISQUAL ALLOWED FQ</div>									
								</div> 


							</div>
							<!-- closed proper -->



							<!-- End second half Page -->

						</div>
						<!-- class="row clear contract_row" -->

						<div class="row buttonRow">
							<div class="col-md-12 text-right btnContainer">
								<button class="btn btn-xs fr tent_btn" type="submit"
									name="submit">Submit</button>
							</div>
						</div>
					</div>
					<!-- class="um-form contract_form" -->
				</div>
				<!-- class="containerPanel clearfix" -->


			</div>
			<!-- class="container add_container tenant_container" -->

		</form>
		<!-- container -->

		<div class="footer">&copy; 2016 CGI. All rights reserved.</div>
	</div>


	<div class="popupBg"></div>
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/jquery-ui-1.11.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/modernizr.min.js"></script>
	<script src="js/jquery.cookies.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/tprm.js"></script>
	<script src="js/datetprm.js"></script>

	<script type="text/javascript">
		if (document.getElementById("multiQualAllowedOneVuId").checked) {
			document.getElementById('multiQualAllowedOneVuIdHidden').disabled = true;
		}

		if (document.getElementById("forceCreditONTPSId").checked) {
			document.getElementById('forceCreditONTPSIdHidden').disabled = true;
		}

		if (document.getElementById("globalForceQualIndId").checked) {
			document.getElementById('globalForceQualIndIdHidden').disabled = true;
		}

		if (document.getElementById("globalForceDisqInd").checked) {
			document.getElementById('globalForceDisqIndHidden').disabled = true;
		}

		if (document.getElementById("qspInitialSetupIndId").checked) {
			document.getElementById('qspInitialSetupIndIdHidden').disabled = true;
		}

		if (document.getElementById("disqualProcessIndId").checked) {
			document.getElementById('disqualProcessIndIdHidden').disabled = true;
		}

		if (document.getElementById("monitorProcessIndId").checked) {
			document.getElementById('monitorProcessIndIdHidden').disabled = true;
		}

		if (document.getElementById("calcCredOnceIndId").checked) {
			document.getElementById('calcCredOnceIndIdHidden').disabled = true;
		}

		if (document.getElementById("loseSkipCycleIndId").checked) {
			document.getElementById('loseSkipCycleIndIdHidden').disabled = true;
		}

		if (document.getElementById("clabBackIndId").checked) {
			document.getElementById('clabBackIndIdHidden').disabled = true;
		}

		if (document.getElementById("disqualifyIndId").checked) {
			document.getElementById('disqualifyIndIdHidden').disabled = true;
		}

		if (document.getElementById("registrationClawbackIndId").checked) {
			document.getElementById('registrationClawbackIndIdHidden').disabled = true;
		}

		if (document.getElementById("registrationDisqualifyIndId").checked) {
			document.getElementById('registrationDisqualifyIndIdHidden').disabled = true;
		}

		if (document.getElementById("clawbackMonitorIndId").checked) {
			document.getElementById('clawbackMonitorIndIdHidden').disabled = true;
		}

		if (document.getElementById("disqualifyMonitorIndId").checked) {
			document.getElementById('disqualifyMonitorIndIdHidden').disabled = true;
		}

		if (document.getElementById("clawbackVisibilityIndId").checked) {
			document.getElementById('clawbackVisibilityIndIdHidden').disabled = true;
		}

		if (document.getElementById("displayPromoStartDateId").checked) {
			document.getElementById('displayPromoStartDateIdHidden').disabled = true;
		}

		if (document.getElementById("displaPromoEndDateId").checked) {
			document.getElementById('displaPromoEndDateIdHidden').disabled = true;
		}

		if (document.getElementById("displayPromoBillDatesId").checked) {
			document.getElementById('displayPromoBillDatesIdHidden').disabled = true;
		}
		if (document.getElementById("displayQualInfoId").checked) {
			document.getElementById('displayQualInfoIdHidden').disabled = true;
		}

		if (document.getElementById("displayCreditInfoId").checked) {
			document.getElementById('displayCreditInfoIdHidden').disabled = true;
		}

		if (document.getElementById("promoUpdIndId").checked) {
			document.getElementById('promoUpdIndIdHidden').disabled = true;
		}

		if (document.getElementById("profileQualVisIndId").checked) {
			document.getElementById('profileQualVisIndIdHidden').disabled = true;
		}

		if (document.getElementById("profileCrdeitVisIndId").checked) {
			document.getElementById('profileCrdeitVisIndIdHidden').disabled = true;
		}

		if (document.getElementById("displayClawbackInfoId").checked) {
			document.getElementById('displayClawbackInfoIdHidden').disabled = true;
		}

		if (document.getElementById("multiQualAllowedFQId").checked) {
			document.getElementById('multiQualAllowedFQIdHidden').disabled = true;
		}

		if (document.getElementById("requalAllowedFqId").checked) {
			document.getElementById('requalAllowedFqIdHidden').disabled = true;
		}

		if (document.getElementById("disqualAllowedFqId").checked) {
			document.getElementById('disqualAllowedFqIdHidden').disabled = true;
		}
		
		if (document.getElementById("exclPermDiscIndId").checked) {
			document.getElementById('exclPermDiscIndIdHidden').disabled = true;
		}
		
		if (document.getElementById("promoCtgryIndId").checked) {
			document.getElementById('promoCtgryIndIdHidden').disabled = true;
		}
		
		
		
		
		/* if (document.getElementById("testName").checked) {
			document.getElementById('testNameHidden').disabled = true;
		} */
	</script>

</body>
</html>
