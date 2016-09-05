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
.dataTableContainer {
	top: 0 !important;
}

.customInput input[type="checkbox"], .customInput input[type="radio"] {
	display: none !important
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

.topheading {
    width: 14%;
    font-feature-settings: inherit;
    font-size: large;
}

.labelStyle {
	width: 46% !important;
	padding-top: 10px;
}

.styleHeading {
	line-height: 70px;
	font-weight: bold;
}

.selectDrop {
    height: 25px;
    width: 16%;
    position: absolute;
    filter: alpha(opacity=0);
    z-index: 999;
    margin-left: 27px;
}


/* .add_container {
	margin: 3px 0 10px;
} */
</style>

</head>

<body style="overflow: auto;">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="innerHeading">
			<h1 class="title">Promo Automation Tool</h1>
			<div class="clr"></div>
		</div>
		<div class="row"> 
			<div class="col-sm-2 topheading title ">
			<a href="index.jsp"> Home </a> </div>
		</div>
		
		<form action="creditcalc" method="post">
		<div class="container">
			<c:choose>
				<c:when test="${sessionScope.DISQUAL_PROCESS=='1'}">
					<div class="row">
						<div class="col-sm-1"><input type="checkbox" value="1" name="disqualProcessInd" checked="checked"/> </div>
						<div class="col-sm-2 labelStyle "><b></b>Credit Calc Ind</b></div>
					</div>
					<br />
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-sm-1"><input type="checkbox" value="1" name="disqualProcessInd"/> </div>
						<div class="col-sm-2 labelStyle "><b></b>Credit Calc Ind</b></div>
					</div>
					<br />
				</c:otherwise>
			</c:choose>
			
			<!-- <div class="clear leftColRegion"> -->	
			<div class="row">					
				<label>Promotion Id <span class="red">*</span> </label> 	
				<select name="promoConfig" class="selectDrop">
					<option value="" label="Select Promotion" />
    				<c:forEach items="${promoConfigs}" var="promoConfig">
        				<option value="${promoConfig.promotionId}"><c:out value="${promoConfig.promotionId}" /></option>
    				</c:forEach>
				</select>
			</div>
			
			
			<div class="row">
				<div class="col-sm-4 styleHeading"> RuleNames </div>
				<div class="col-sm-4 styleHeading"> Select </div>
				<div class="col-sm-4 styleHeading"> Rule Parameter </div>
			</div>

			<div class="row">
				<div class="col-sm-4"> <b> AGENT_CD </b></div>
				<div class="col-sm-4"> <input type="checkbox" name="AGENT_CD" value='1' id="AGENT_CDId">
				<input type="hidden" name="AGENT_CD" value='0' id="AGENT_CDIdHidden">
				</div>
				<div class="col-sm-4"><input type="text" name="AGENT_CD_RP" id="AGENT_CD_RP_ID" disabled="disabled"></div>
						</div>
						
						<div class="row">
							<div class="col-sm-4"> <b> PROVINCE_CD </b></div>
							<div class="col-sm-4"><input type="checkbox" name="PROVINCE_CD" value='1' id="PROVINCE_CDId">
							<input type="hidden" name="PROVINCE_CD" value='0' id="PROVINCE_CDIdHidden">
							</div>
							<div class="col-sm-4"><input type="text" name="PROVINCE_CD_RP" id="PROVINCE_CD_RP_ID" disabled="disabled"></div></div>

						<div class="row">
								<div class="col-sm-4"> <b> HIGHEST_ANY </b></div>
								<div class="col-sm-4"><input type="checkbox" name="HIGHEST_ANY" value='1' id="HIGHEST_ANYId">
								<input type="hidden" name="HIGHEST_ANY" value='0' id="HIGHEST_ANYIdHidden">
								
								</div>
								<div class="col-sm-4"><input type="text" name="HIGHEST_ANY_RP" id="HIGHEST_ANY_RP_ID" disabled="disabled"></div>
						</div>

						<div class="row">
							<div class="col-sm-4" > <b> HIGHEST_ORS </b></div>
							<div class="col-sm-4" ><input type="checkbox" name="HIGHEST_ORS" value='1' id="HIGHEST_ORSId">
							<input type="hidden" name="HIGHEST_ORS" value='0' id="HIGHEST_ORSIdHidden">
							</div>
							<div class="col-sm-4"><input type="text" name="HIGHEST_ORS_RP" id="HIGHEST_ORS_RP_ID" disabled="disabled"></div>
						</div>
							
						<div class="row">
							<div class="col-sm-4"> <b> HIGHEST_RCP </b></div>
							<div class="col-sm-4">
								<input type="checkbox" name="HIGHEST_RCP" value='1' id="HIGHEST_RCPId">
								<input type="hidden" name="HIGHEST_RCP" value='0' id="HIGHEST_RCPIdHidden">
							</div>
							<div class="col-sm-4">
								<input type="text" name="HIGHEST_RCP_RP" id="HIGHEST_RCP_RP_ID" disabled="disabled">
							</div>
						</div>
						
						<div class="row">
						<div class="col-sm-4"> <b> HIGHEST_RCP36 </b></div>
							<div class="col-sm-4">
								<input type="checkbox" name="HIGHEST_RCP36" value='1' id="HIGHEST_RCP36Id">
								<input type="hidden" name="HIGHEST_RCP36" value='0' id="HIGHEST_RCP36IdHidden">
							</div>
							<div class="col-sm-4"><input type="text" name="HIGHEST_RCP36_RP" id="HIGHEST_RCP36_RP_ID" disabled="disabled">
							</div>
						</div>
						
						<div class="row">
								<div class="col-sm-4"> <b> HIGHEST_RCP60 </b></div>
								<div class="col-sm-4">
									<input type="checkbox" name="HIGHEST_RCP60" value='1' id="HIGHEST_RCP60Id">
									<input type="hidden" name="HIGHEST_RCP60" value='0' id="HIGHEST_RCP60IdHidden">
								</div>
								<div class="col-sm-4">
									<input type="text" name="HIGHEST_RCP60_RP" id="HIGHEST_RCP60_RP_ID" disabled="disabled">
								</div>
						</div>
						<div class="row">
								<div class="col-sm-4"> <b> CORE_PROG_MONTHLY_SPEND </b></div>
								<div class="col-sm-4">
									<input type="checkbox" name="CORE_PROG_MONTHLY_SPEND" value='1' id="CORE_PROG_MONTHLY_SPENDId">
									<input type="hidden" name="CORE_PROG_MONTHLY_SPEND" value='0' id="CORE_PROG_MONTHLY_SPENDIdHidden">
								</div>
								<div class="col-sm-4">
									<input type="text" name="CORE_PROG_MONTHLY_SPEND_RP" id="CORE_PROG_MONTHLY_SPEND_RP_ID" disabled="disabled">
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4"> <b> MTH_CHARGE_WDSC_AMT </b></div>
								<div class="col-sm-4">
									<input type="checkbox" name="MTH_CHARGE_WDSC_AMT" value='1' id="MTH_CHARGE_WDSC_AMTId">
									<input type="hidden" name="MTH_CHARGE_WDSC_AMT" value='0' id="MTH_CHARGE_WDSC_AMTIdHidden">
								</div>
								<div class="col-sm-4">
									<input type="text" name="MTH_CHARGE_WDSC_AMT_RP" id="MTH_CHARGE_WDSC_AMT_RP_ID" disabled="disabled">
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4"> <b> MTH_PROG_WDSC_AMT </b></div>
								<div class="col-sm-4">
									<input type="checkbox" name="MTH_PROG_WDSC_AMT" value='1' id="MTH_PROG_WDSC_AMTId">
									<input type="hidden" name="MTH_PROG_WDSC_AMT" value='0' id="MTH_PROG_WDSC_AMTIdHidden">
								</div>
								<div class="col-sm-4">
									<input type="text" name="MTH_PROG_WDSC_AMT_RP" id="MTH_PROG_WDSC_AMT_RP_ID" disabled="disabled">
								</div>
							</div>
							
							<div class="row">
								<div class="col-sm-4"> <b> PROG_CLASS_SPEND </b></div>
								<div class="col-sm-4">
									<input type="checkbox" name="PROG_CLASS_SPEND" value='1' id="PROG_CLASS_SPENDid">
									<input type="hidden" name="PROG_CLASS_SPEND" value='0' id="PROG_CLASS_SPENDidHidden">
								</div>
								<div class="col-sm-4">
									<input type="text" name="PROG_CLASS_SPEND_RP" id="PROG_CLASS_SPEND_RP_ID" disabled="disabled">
								</div>
							</div>
							
							<div class="row">
								<div class="col-sm-4"> <b> CUSTOM_CLASS_SPEND </b> </div>
								<div class="col-sm-4">
									<input type="checkbox" name="CUSTOM_CLASS_SPEND" value='1' id="CUSTOM_CLASS_SPENDId">
									<input type="hidden" name="CUSTOM_CLASS_SPEND" value='0' id="CUSTOM_CLASS_SPENDIdHidden">
								</div>
								<div class="col-sm-4">
									<input type="text" name="CUSTOM_CLASS_SPEND_RP" id="CUSTOM_CLASS_SPEND_RP_ID" disabled="disabled">
								</div>
							</div>
							
							<div class="row">
								<div class="col-sm-4"> <b> CORE_CLASS_SPEND </b></div>
								<div class="col-sm-4">
									<input type="checkbox" name="CORE_CLASS_SPEND" value='1' id="CORE_CLASS_SPENDId">
									<input type="hidden" name="CORE_CLASS_SPEND" value='0' id="CORE_CLASS_SPENDIdHidden">
								</div>
								<div class="col-sm-4">
									<input type="text" name="CORE_CLASS_SPEND_RP" id="CORE_CLASS_SPEND_RP_ID" disabled="disabled">
								</div>
							</div>
							
							

					
					
					<div class="row">
						<div class="col-md-12 text-right btnContainer"><button class="btn btn-xs fr tent_btn" type="submit" name="submit">Submit</button></div>
					</div>
							
					<!-- <input type="submit" value="submit"> -->
			</div>

					
	</form>
	<!-- container -->

	<div class="footer">&copy; 2016 CGI. All rights reserved.</div>
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
	    jq(function () {
	    	jq("#AGENT_CDId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#AGENT_CD_RP_ID").removeAttr("disabled");
	            	jq("#AGENT_CD_RP_ID").focus();
	            } else {
	            	jq("#AGENT_CD_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#PROVINCE_CDId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#PROVINCE_CD_RP_ID").removeAttr("disabled");
	            	jq("#PROVINCE_CD_RP_ID").focus();
	            } else {
	            	jq("#PROVINCE_CD_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#HIGHEST_ANYId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#HIGHEST_ANY_RP_ID").removeAttr("disabled");
	            	jq("#HIGHEST_ANY_RP_ID").focus();
	            } else {
	            	jq("#HIGHEST_ANY_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#HIGHEST_ORSId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#HIGHEST_ORS_RP_ID").removeAttr("disabled");
	            	jq("#HIGHEST_ORS_RP_ID").focus();
	            } else {
	            	jq("#HIGHEST_ORS_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	<script type="text/javascript">
	    jq(function () {
	    	jq("#HIGHEST_RCPId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#HIGHEST_RCP_RP_ID").removeAttr("disabled");
	            	jq("#HIGHEST_RCP_RP_ID").focus();
	            } else {
	            	jq("#HIGHEST_RCP_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
		<script type="text/javascript">
	    jq(function () {
	    	jq("#HIGHEST_RCP36Id").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#HIGHEST_RCP36_RP_ID").removeAttr("disabled");
	            	jq("#HIGHEST_RCP36_RP_ID").focus();
	            } else {
	            	jq("#HIGHEST_RCP36_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
		<script type="text/javascript">
	    jq(function () {
	    	jq("#HIGHEST_RCP60Id").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#HIGHEST_RCP60_RP_ID").removeAttr("disabled");
	            	jq("#HIGHEST_RCP60_RP_ID").focus();
	            } else {
	            	jq("#HIGHEST_RCP60_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
		<script type="text/javascript">
	    jq(function () {
	    	jq("#CORE_PROG_MONTHLY_SPENDId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#CORE_PROG_MONTHLY_SPEND_RP_ID").removeAttr("disabled");
	            	jq("#CORE_PROG_MONTHLY_SPEND_RP_ID").focus();
	            } else {
	            	jq("#CORE_PROG_MONTHLY_SPEND_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
		<script type="text/javascript">
	    jq(function () {
	    	jq("#MTH_CHARGE_WDSC_AMTId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#MTH_CHARGE_WDSC_AMT_RP_ID").removeAttr("disabled");
	            	jq("#MTH_CHARGE_WDSC_AMT_RP_ID").focus();
	            } else {
	            	jq("#MTH_CHARGE_WDSC_AMT_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	<script type="text/javascript">
	    jq(function () {
	    	jq("#MTH_PROG_WDSC_AMTId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#MTH_PROG_WDSC_AMT_RP_ID").removeAttr("disabled");
	            	jq("#MTH_PROG_WDSC_AMT_RP_ID").focus();
	            } else {
	            	jq("#MTH_PROG_WDSC_AMT_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#PROG_CLASS_SPENDid").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#PROG_CLASS_SPEND_RP_ID").removeAttr("disabled");
	            	jq("#PROG_CLASS_SPEND_RP_ID").focus();
	            } else {
	            	jq("#PROG_CLASS_SPEND_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	<script type="text/javascript">
	    jq(function () {
	    	jq("#CUSTOM_CLASS_SPENDId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#CUSTOM_CLASS_SPEND_RP_ID").removeAttr("disabled");
	            	jq("#CUSTOM_CLASS_SPEND_RP_ID").focus();
	            } else {
	            	jq("#CUSTOM_CLASS_SPEND_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	  jq(function () {
	   	jq("#CORE_CLASS_SPENDId").click(function () {
	        if (jq(this).is(":checked")) {
	           	jq("#CORE_CLASS_SPEND_RP_ID").removeAttr("disabled");
	           	jq("#CORE_CLASS_SPEND_RP_ID").focus();
	        } else {
	           	jq("#CORE_CLASS_SPEND_RP_ID").attr("disabled", "disabled");
	          }
	       });
	    });
	</script>
	
	<script type="text/javascript">
	if (document.getElementById("AGENT_CDId").checked) {
		document.getElementById('AGENT_CDIdHidden').disabled = true;
	}
	
	if (document.getElementById("PROVINCE_CDId").checked) {
		document.getElementById('PROVINCE_CDIdHidden').disabled = true;
	}
	
	if (document.getElementById("HIGHEST_ANYId").checked) {
		document.getElementById('HIGHEST_ANYIdHidden').disabled = true;
	}
	
	if (document.getElementById("HIGHEST_ORSId").checked) {
		document.getElementById('HIGHEST_ORSIdHidden').disabled = true;
	}
	
	if (document.getElementById("HIGHEST_RCPId").checked) {
		document.getElementById('HIGHEST_RCPIdHidden').disabled = true;
	}
	
	if (document.getElementById("HIGHEST_RCP36Id").checked) {
		document.getElementById('HIGHEST_RCP36IdHidden').disabled = true;
	}
	
	if (document.getElementById("HIGHEST_RCP60Id").checked) {
		document.getElementById('HIGHEST_RCP60IdHidden').disabled = true;
	}
	
	if (document.getElementById("CORE_PROG_MONTHLY_SPENDId").checked) {
		document.getElementById('CORE_PROG_MONTHLY_SPENDIdHidden').disabled = true;
	}
	
	if (document.getElementById("MTH_CHARGE_WDSC_AMTId").checked) {
		document.getElementById('MTH_CHARGE_WDSC_AMTIdHidden').disabled = true;
	}
	
	if (document.getElementById("MTH_PROG_WDSC_AMTId").checked) {
		document.getElementById('MTH_PROG_WDSC_AMTIdHidden').disabled = true;
	}
	
	if (document.getElementById("PROG_CLASS_SPENDid").checked) {
		document.getElementById('PROG_CLASS_SPENDidHidden').disabled = true;
	}
	
	if (document.getElementById("CUSTOM_CLASS_SPENDId").checked) {
		document.getElementById('CUSTOM_CLASS_SPENDIdHidden').disabled = true;
	}
	
	if (document.getElementById("CORE_CLASS_SPENDId").checked) {
		document.getElementById('CORE_CLASS_SPENDIdHidden').disabled = true;
	} 
	
	</script>

</body>
</html>
