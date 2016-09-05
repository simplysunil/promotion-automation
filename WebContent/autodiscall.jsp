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
.labelStyle {
	width: 46% !important;
	padding-top: 10px;
}

.styleHeading {
	line-height: 70px;
	font-weight: bold;
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

	<!-- Preloader starts here-->
	<!-- <div id="preloader">
		<div id="status">
			<i class="fa fa-spinner fa-spin"></i>
		</div>
	</div> -->
	<!-- <div class="mainpanel TPRM_bg"> -->

		<jsp:include page="header.jsp"></jsp:include>
		<!--- Menus ends here -->
		<div class="clear"></div>
		<div class="innerHeading">
			<h1 class="title">Promotion Automation</h1>
			<div class="clr"></div>
		</div>
		<!-- <div class="clr"></div> -->
		<!-- container starts here-->


		<div class="row"> 
			<div class="col-sm-2 topheading title">
			<a href="index.jsp"> Home </a> </div>
		</div>

		<form action="autodiscall" method="post" name="myForm">
			<div class="container  ">
					<!-- <div class="um-form contract_form"> -->
						
							<!-- <div class="row">
							<div class="col-sm-1"><input type="checkbox" value="1" name="disqualProcessInd"/> </div>
							<div class="col-sm-2"><b></b>DISQUAL_PROCESS_IND</b></div>
							</div>
							 -->
							<c:choose>
			   					 <c:when test="${sessionScope.DISQUAL_PROCESS=='1'}">
			       				 <div class="row">
									<div class="col-sm-1"><input type="checkbox" value="1" name="disqualProcessInd" checked="checked"/> </div>
									<div class="col-sm-2 labelStyle "><b></b>DISQUAL PROCESS IND</b></div>
								</div>
			        			<br />
			    				</c:when>    
			   				 <c:otherwise>
			        			 <div class="row">
									<div class="col-sm-1"><input type="checkbox" value="1" name="disqualProcessInd"/> </div>
									<div class="col-sm-2 labelStyle"><b></b>DISQUAL PROCESS IND</b></div>
								</div>
			        		<br />
			    			</c:otherwise>
							</c:choose>
							
							<div class="clear leftColRegion">						
				<label>Promotion Id <span class="red">*</span> </label> 	
				<select name="promoConfig" class="selectDrop">
					<option value="" label="Select Promotion" />
    				<c:forEach items="${promoConfigs}" var="promoConfig">
        				<option value="${promoConfig.promotionId}"><c:out value="${promoConfig.promotionId}" /></option>
    				</c:forEach>
				</select>
			</div>
							
							
							<div class="row">
								<div class="col-sm-1 styleHeading" >Select <b><span></span></b></div>
								<div class="col-sm-2 styleHeading" >Rule Name</div>
								<div class="col-sm-3 styleHeading" >Rule Parameter <b><span></span></b></div>
								<div class="col-sm-3 styleHeading"  >Vis Disq Msg EN <b><span></span></b></div>
								<div class="col-sm-3 styleHeading" >Vis Disq Msg FR<b><span></span></b></div>
							</div>
							
							<div class="row">
								<div class="col-sm-1">
								<input type="checkbox" name="RCP_TYPE" value='1' id="RCP_TYPEId">
								<input type="hidden" value="0" name="RCP_TYPE" id="RCP_TYPEIdHidden" />
								</div>
								<div class="col-sm-2"><b> RCP_TYPE </b></div>
								<div class="col-sm-3"><input type="text" name="RCP_TYPE_RP" id="RCP_TYPE_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="RCP_TYPE_VEn" id="RCP_TYPE_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="RCP_TYPE_VFr" id="RCP_TYPE_VFr_ID" disabled="disabled"></div>
							</div>
							
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="RCP_TYPE_WPLAN" value='1' id="RCP_TYPE_WPLANId" >
								<input type="hidden" name="RCP_TYPE_WPLAN" value='0' id="RCP_TYPE_WPLANIdHidden">
								</div>
								<div class="col-sm-2"> <b> RCP_TYPE_WPLAN </b> </div>
								<div class="col-sm-3"><input type="text" name="RCP_TYPE_WPLAN_RP" id="RCP_TYPE_WPLAN_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="RCP_TYPE_WPLAN_VEn" id="RCP_TYPE_WPLAN_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="RCP_TYPE_WPLAN_VFr" id="RCP_TYPE_WPLAN_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="RCP_RCVR" value='1' id="RCP_RCVRId">
								<input type="hidden" name="RCP_RCVR" value='0' id="RCP_RCVRIdHidden">
								</div>
								<div class="col-sm-2"> <b> RCP_RCVR </b></div>
								<div class="col-sm-3"><input type="text" name="RCP_RCVR_RP" id="RCP_RCVR_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="RCP_RCVR_VEn" id="RCP_RCVR_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="RCP_RCVR_VFr" id="RCP_RCVR_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="RCP_RCVR_WPLAN" value='1' id="RCP_RCVR_WPLANId" >
								<input type="hidden" name="RCP_RCVR_WPLAN" value='0' name="RCP_RCVR_WPLANIdHidden" >
								</div>
								<div class="col-sm-2"> <b> RCP_RCVR_WPLAN </b> </div>
								<div class="col-sm-3"><input type="text" name="RCP_RCVR_WPLAN_RP" id="RCP_RCVR_WPLAN_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="RCP_RCVR_WPLAN_VEn" id="RCP_RCVR_WPLAN_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="RCP_RCVR_WPLAN_VFr" id="RCP_RCVR_WPLAN_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="HW_TYPE" value='1' id="HW_TYPEId">
								<input type="hidden" name="HW_TYPE" value='0' id="HW_TYPEIdHidden">
								</div>
								<div class="col-sm-2"> <b> HW_TYPE </b></div>
								<div class="col-sm-3"><input type="text" name="HW_TYPE_RP" id="HW_TYPE_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="HW_TYPE_VEn" id="HW_TYPE_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="HW_TYPE_VFr" id="HW_TYPE_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="PLATFORM" value='1' id="PLATFORMId">
								<input type="hidden" name="PLATFORM" value='0' id="PLATFORMIdHidden">
								</div>
							    <div class="col-sm-2"> <b> PLATFORM </b></div>
								<div class="col-sm-3"><input type="text" name="PLATFORM_RP" id="PLATFORM_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="PLATFORM_VEn" id="PLATFORM_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="PLATFORM_VFr" id="PLATFORM_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="CORE_PROG" value='1' id="CORE_PROGId">
								<input type="hidden" name="CORE_PROG" value='0' id="CORE_PROGIdHidden">
								</div>
							    <div class="col-sm-2"> <b> CORE_PROG </b></div>
								<div class="col-sm-3"><input type="text" name="CORE_PROG_RP" id="CORE_PROG_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="CORE_PROG_VEn" id="CORE_PROG_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="CORE_PROG_VFr" id="CORE_PROG_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="PROG_CLASS_ANY" value='1' id="PROG_CLASS_ANYId">
								<input type="hidden" name="PROG_CLASS_ANY" value='0' id="PROG_CLASS_ANYIdHidden">
								</div>
								<div class="col-sm-2"> <b> PROG_CLASS_ANY </b></div>
								<div class="col-sm-3"><input type="text" name="PROG_CLASS_ANY_RP" id="PROG_CLASS_ANY_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="PROG_CLASS_ANY_VEn" id="PROG_CLASS_ANY_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="PROG_CLASS_ANY_VFr" id="PROG_CLASS_ANY_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="PROG_CLASS_ALL" value='1' id="PROG_CLASS_ALLId">
								<input type="hidden" name="PROG_CLASS_ALL" value='0' id="PROG_CLASS_ALLIdHidden">
								</div>
								<div class="col-sm-2"> <b> PROG_CLASS_ALL </b> </div>
								<div class="col-sm-3"><input type="text" name="PROG_CLASS_ALL_RP" id="PROG_CLASS_ALL_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="PROG_CLASS_ALL_VEn" id="PROG_CLASS_ALL_VEn_ID" disabled="disabled" ></div>
								<div class="col-sm-3"><input type="text" name="PROG_CLASS_ALL_VFr" id="PROG_CLASS_ALL_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="INELIG_PROG" value='1' id="INELIG_PROGId">
								<input type="hidden" name="INELIG_PROG" value='0' id="INELIG_PROGIdHidden">
								</div>
								<div class="col-sm-2"> <b> INELIG_PROG </b></div>
								<div class="col-sm-3"><input type="text" name="INELIG_PROG_RP" id="INELIG_PROG_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="INELIG_PROG_VEn" id="INELIG_PROG_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="INELIG_PROG_VFr" id="INELIG_PROG_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row">
								<div class="col-sm-1"><input type="checkbox" name="CUSTOM_PROGPKG" value='1' id="CUSTOM_PROGPKGId">
								<input type="hidden" name="CUSTOM_PROGPKG" value='0' id="CUSTOM_PROGPKGIdhidden">
								</div>
								<div class="col-sm-2"><b> CUSTOM_PROGPKG </b></div>
								<div class="col-sm-3"><input type="text" name="CUSTOM_PROGPKG_RP" id="CUSTOM_PROGPKG_RP_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="CUSTOM_PROGPKG_VEn" id="CUSTOM_PROGPKG_VEn_ID" disabled="disabled"></div>
								<div class="col-sm-3"><input type="text" name="CUSTOM_PROGPKG_VFr" id="CUSTOM_PROGPKG_VFr_ID" disabled="disabled"></div>
							</div>
							<div class="row buttonRow">
								<div class="col-md-12 text-right btnContainer">
								<button class="btn btn-xs fr tent_btn" type="submit" name="submit">Submit</button>
							</div>
					</div>
		
	</div>
	</div>								
</form>
</div>

	


	


	
	<!-- container -->
	</form>
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
	<!-- <script src="js/datetprm.js"></script> -->
	
	<!-- <script type="text/javascript">
	    jq(function () {
	    	jq("#chkPassport").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#txtPassportNumber").removeAttr("disabled");
	            	jq("#txtPassportNumber").focus();
	            } else {
	            	jq("#txtPassportNumber").attr("disabled", "disabled");
	            }
	        });
	    });
	</script> -->
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#RCP_TYPEId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#RCP_TYPE_RP_ID").removeAttr("disabled");
	            	jq("#RCP_TYPE_RP_ID").focus();
	            	jq("#RCP_TYPE_VEn_ID").removeAttr("disabled");
	            	jq("#RCP_TYPE_VEn_ID").focus();
	            	jq("#RCP_TYPE_VFr_ID").removeAttr("disabled");
	            	jq("#RCP_TYPE_VFr_ID").focus();
	            } else {
	            	jq("#RCP_TYPE_RP_ID").attr("disabled", "disabled");
	            	jq("#RCP_TYPE_VEn_ID").attr("disabled", "disabled");
	            	jq("#RCP_TYPE_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#RCP_TYPE_WPLANId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#RCP_TYPE_WPLAN_RP_ID").removeAttr("disabled");
	            	jq("#RCP_TYPE_WPLAN_RP_ID").focus();
	            	jq("#RCP_TYPE_WPLAN_VEn_ID").removeAttr("disabled");
	            	jq("#RCP_TYPE_WPLAN_VEn_ID").focus();
	            	jq("#RCP_TYPE_WPLAN_VFr_ID").removeAttr("disabled");
	            	jq("#RCP_TYPE_WPLAN_VFr_ID").focus();
	            } else {
	            	jq("#RCP_TYPE_WPLAN_RP_ID").attr("disabled", "disabled");
	            	jq("#RCP_TYPE_WPLAN_VEn_ID").attr("disabled", "disabled");
	            	jq("#RCP_TYPE_WPLAN_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#RCP_RCVRId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#RCP_RCVR_RP_ID").removeAttr("disabled");
	            	jq("#RCP_RCVR_RP_ID").focus();
	            	jq("#RCP_RCVR_VEn_ID").removeAttr("disabled");
	            	jq("#RCP_RCVR_VEn_ID").focus();
	            	jq("#RCP_RCVR_VFr_ID").removeAttr("disabled");
	            	jq("#RCP_RCVR_VFr_ID").focus();
	            } else {
	            	jq("#RCP_RCVR_RP_ID").attr("disabled", "disabled");
	            	jq("#RCP_RCVR_VEn_ID").attr("disabled", "disabled");
	            	jq("#RCP_RCVR_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#RCP_RCVR_WPLANId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#RCP_RCVR_WPLAN_RP_ID").removeAttr("disabled");
	            	jq("#RCP_RCVR_WPLAN_RP_ID").focus();
	            	jq("#RCP_RCVR_WPLAN_VEn_ID").removeAttr("disabled");
	            	jq("#RCP_RCVR_WPLAN_VEn_ID").focus();
	            	jq("#RCP_RCVR_WPLAN_VFr_ID").removeAttr("disabled");
	            	jq("#RCP_RCVR_WPLAN_VFr_ID").focus();
	            } else {
	            	jq("#RCP_RCVR_WPLAN_RP_ID").attr("disabled", "disabled");
	            	jq("#RCP_RCVR_WPLAN_VEn_ID").attr("disabled", "disabled");
	            	jq("#RCP_RCVR_WPLAN_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#HW_TYPEId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#HW_TYPE_RP_ID").removeAttr("disabled");
	            	jq("#HW_TYPE_RP_ID").focus();
	            	jq("#HW_TYPE_VEn_ID").removeAttr("disabled");
	            	jq("#HW_TYPE_VEn_ID").focus();
	            	jq("#HW_TYPE_VFr_ID").removeAttr("disabled");
	            	jq("#HW_TYPE_VFr_ID").focus();
	            } else {
	            	jq("#HW_TYPE_RP_ID").attr("disabled", "disabled");
	            	jq("#HW_TYPE_VEn_ID").attr("disabled", "disabled");
	            	jq("#HW_TYPE_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#PLATFORMId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#PLATFORM_RP_ID").removeAttr("disabled");
	            	jq("#PLATFORM_RP_ID").focus();
	            	jq("#PLATFORM_VEn_ID").removeAttr("disabled");
	            	jq("#PLATFORM_VEn_ID").focus();
	            	jq("#PLATFORM_VFr_ID").removeAttr("disabled");
	            	jq("#PLATFORM_VFr_ID").focus();
	            } else {
	            	jq("#PLATFORM_RP_ID").attr("disabled", "disabled");
	            	jq("#PLATFORM_VEn_ID").attr("disabled", "disabled");
	            	jq("#PLATFORM_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#CORE_PROGId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#CORE_PROG_RP_ID").removeAttr("disabled");
	            	jq("#CORE_PROG_RP_ID").focus();
	            	jq("#CORE_PROG_VEn_ID").removeAttr("disabled");
	            	jq("#CORE_PROG_VEn_ID").focus();
	            	jq("#CORE_PROG_VFr_ID").removeAttr("disabled");
	            	jq("#CORE_PROG_VFr_ID").focus();
	            } else {
	            	jq("#CORE_PROG_RP_ID").attr("disabled", "disabled");
	            	jq("#CORE_PROG_VEn_ID").attr("disabled", "disabled");
	            	jq("#CORE_PROG_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#PROG_CLASS_ANYId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#PROG_CLASS_ANY_RP_ID").removeAttr("disabled");
	            	jq("#PROG_CLASS_ANY_RP_ID").focus();
	            	jq("#PROG_CLASS_ANY_VEn_ID").removeAttr("disabled");
	            	jq("#PROG_CLASS_ANY_VEn_ID").focus();
	            	jq("#PROG_CLASS_ANY_VFr_ID").removeAttr("disabled");
	            	jq("#PROG_CLASS_ANY_VFr_ID").focus();
	            } else {
	            	jq("#PROG_CLASS_ANY_RP_ID").attr("disabled", "disabled");
	            	jq("#PROG_CLASS_ANY_VEn_ID").attr("disabled", "disabled");
	            	jq("#PROG_CLASS_ANY_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#PROG_CLASS_ALLId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#PROG_CLASS_ALL_RP_ID").removeAttr("disabled");
	            	jq("#PROG_CLASS_ALL_RP_ID").focus();
	            	jq("#PROG_CLASS_ALL_VEn_ID").removeAttr("disabled");
	            	jq("#PROG_CLASS_ALL_VEn_ID").focus();
	            	jq("#PROG_CLASS_ALL_VFr_ID").removeAttr("disabled");
	            	jq("#PROG_CLASS_ALL_VFr_ID").focus();
	            } else {
	            	jq("#PROG_CLASS_ALL_RP_ID").attr("disabled", "disabled");
	            	jq("#PROG_CLASS_ALL_VEn_ID").attr("disabled", "disabled");
	            	jq("#PROG_CLASS_ALL_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#INELIG_PROGId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#INELIG_PROG_RP_ID").removeAttr("disabled");
	            	jq("#INELIG_PROG_RP_ID").focus();
	            	jq("#INELIG_PROG_VEn_ID").removeAttr("disabled");
	            	jq("#INELIG_PROG_VEn_ID").focus();
	            	jq("#INELIG_PROG_VFr_ID").removeAttr("disabled");
	            	jq("#INELIG_PROG_VFr_ID").focus();
	            } else {
	            	jq("#INELIG_PROG_RP_ID").attr("disabled", "disabled");
	            	jq("#INELIG_PROG_VEn_ID").attr("disabled", "disabled");
	            	jq("#INELIG_PROG_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#CUSTOM_PROGPKGId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#CUSTOM_PROGPKG_RP_ID").removeAttr("disabled");
	            	jq("#CUSTOM_PROGPKG_RP_ID").focus();
	            	jq("#CUSTOM_PROGPKG_VEn_ID").removeAttr("disabled");
	            	jq("#CUSTOM_PROGPKG_VEn_ID").focus();
	            	jq("#CUSTOM_PROGPKG_VFr_ID").removeAttr("disabled");
	            	jq("#CUSTOM_PROGPKG_VFr_ID").focus();
	            } else {
	            	jq("#CUSTOM_PROGPKG_RP_ID").attr("disabled", "disabled");
	            	jq("#CUSTOM_PROGPKG_VEn_ID").attr("disabled", "disabled");
	            	jq("#CUSTOM_PROGPKG_VFr_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	
	if (document.getElementById("RCP_TYPEId").checked) {
		document.getElementById('RCP_TYPEIdHidden').disabled = true;
	}

	if (document.getElementById("RCP_TYPE_WPLANId").checked) {
		document.getElementById('RCP_TYPE_WPLANIdHidden').disabled = true;
	}

	if (document.getElementById("RCP_RCVRId").checked) {
		document.getElementById('RCP_RCVRIdHidden').disabled = true;
	}

	if (document.getElementById("RCP_RCVR_WPLANId").checked) {
		document.getElementById('RCP_RCVR_WPLANIdHidden').disabled = true;
	}

	if (document.getElementById("HW_TYPEId").checked) {
		document.getElementById('HW_TYPEIdHidden').disabled = true;
	}
	if (document.getElementById("CORE_PROGId").checked) {
		document.getElementById('CORE_PROGIdHidden').disabled = true;
	}

	if (document.getElementById("PROG_CLASS_ANYId").checked) {
		document.getElementById('PROG_CLASS_ANYIdHidden').disabled = true;
	}

	if (document.getElementById("PROG_CLASS_ALLId").checked) {
		document.getElementById('PROG_CLASS_ALLIdHidden').disabled = true;
	}

	if (document.getElementById("INELIG_PROGId").checked) {
		document.getElementById('INELIG_PROGIdHidden').disabled = true;
	}

	if (document.getElementById("CUSTOM_PROGPKGId").checked) {
		document.getElementById('CUSTOM_PROGPKGIdhidden').disabled = true;
	}
	
	</script>

</body>
</html>
