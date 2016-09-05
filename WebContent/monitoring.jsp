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
	margin-left: inherit;
}

.styleHeading {
	line-height: 60px;
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
			<a href="index.jsp"> Home </a>
		</div>
	</div>



	<form action="monitoring" method="post">

		<div class="container ">
			<!-- <div class="row">
				<div class="col-sm-4">
					<span> <input type="checkbox" value="1"
						name="monitorProcessInd" /> <label>MONITOR_PROCESS_IND: </label></span>
				</div>
			</div> -->

			<c:choose>
				<c:when test="${sessionScope.DISQUAL_PROCESS=='1'}">

					<div class="row">
						<div class="col-sm-1">
							<input type="checkbox" value="1" name="monitorProcessInd"
								checked="checked" />
						</div>
						<div class="col-sm-2 labelStyle ">
							<b></b>MONITOR PROCESS IND</b>
						</div>
					</div>
					<br />
				</c:when>
				<c:otherwise>

					<div class="row">
						<div class="col-sm-1">
							<input type="checkbox" value="1" name="monitorProcessInd" />
						</div>
						<div class="col-sm-2 labelStyle ">
							<b></b>MONITOR PROCESS IND</b>
						</div>
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
				<div class="col-sm-4 styleHeading">RuleNames</div>
				<div class="col-sm-4 styleHeading">Select</div>
				<div class="col-sm-4 styleHeading">Rule Parameter</div>
			</div>
			<div class="row">
				<div class="col-sm-4"><b> RCP_TYPE </b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="RCP_TYPE" value='1' id="RCP_TYPEId">
					<input type="hidden" name="RCP_TYPE" value='0' id="RCP_TYPEIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="RCP_TYPE_RP" id="RCP_TYPE_RP_ID" disabled="disabled">
				</div>
			</div>


			<div class="row">
				<div class="col-sm-4"> <b>RCP_TYPE_WPLAN</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="RCP_TYPE_WPLAN" value='1' id="RCP_TYPE_WPLANId">
					<input type="hidden" name="RCP_TYPE_WPLAN" value='0' id="RCP_TYPE_WPLANIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="RCP_TYPE_WPLAN_RP" id="RCP_TYPE_WPLAN_RP_ID" disabled="disabled">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4"> <b>RCP_RCVR</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="RCP_RCVR" value='1' id="RCP_RCVRId">
					<input type="hidden" name="RCP_RCVR" value='0' id="RCP_RCVRIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="RCP_RCVR_RP" id="RCP_RCVR_RP_ID" disabled="disabled">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4"> <b>RCP_RCVR_WPLAN</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="RCP_RCVR_WPLAN" value='1'
						id="RCP_RCVR_WPLANId"> <input type="hidden"
						name="RCP_RCVR_WPLAN" value='0' id="RCP_RCVR_WPLANIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="RCP_RCVR_WPLAN_RP" id="RCP_RCVR_WPLAN_RP_ID" disabled="disabled">
				</div>
			</div>

			<div class="row">
				<div class="col-sm-4"> <b>HW_TYPE</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="HW_TYPE" value='1' id="HW_TYPEId">
					<input type="hidden" name="HW_TYPE" value='0' id="HW_TYPEIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="HW_TYPE_RP" id="HW_TYPE_RP_ID" disabled="disabled">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4"><b>PLATFORM</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="PLATFORM" value='1' id="PLATFORMId">
					<input type="hidden" name="PLATFORM" value='0'
						id="PLATFORMIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="PLATFORM_RP" id="PLATFORM_RP_ID" disabled="disabled">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4"><b>CORE_PROG</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="CORE_PROG" value='1' id="CORE_PROGId">
					<input type="hidden" name="CORE_PROG" value='0'
						id="CORE_PROGIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="CORE_PROG_RP" id="CORE_PROG_RP_ID" disabled="disabled">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4"><b>PROG_CLASS_ANY</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="PROG_CLASS_ANY" value='1'
						id="PROG_CLASS_ANYId"> <input type="hidden"
						name="PROG_CLASS_ANY" value='0' id="PROG_CLASS_ANYIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="PROG_CLASS_ANY_RP" id="PROG_CLASS_ANY_RP_ID" disabled="disabled">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4"><b>PROG_CLASS_ALL</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="PROG_CLASS_ALL" value='1'
						id="PROG_CLASS_ALLId"> <input type="hidden"
						name="PROG_CLASS_ALL" value='0' id="PROG_CLASS_ALLIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="PROG_CLASS_ALL_RP" id="PROG_CLASS_ALL_RP_ID" disabled="disabled">
				</div>
			</div>

			<div class="row">
				<div class="col-sm-4"><b>CUSTOM_PROG</b></div>
				<div class="col-sm-4">
					<input type="checkbox" name="CUSTOM_PROG" value='1'
						id="CUSTOM_PROGId"> <input type="hidden"
						name="CUSTOM_PROG" value='0' id="CUSTOM_PROGIdHidden">
				</div>
				<div class="col-sm-4">
					<input type="text" name="CUSTOM_PROG_RP" id="CUSTOM_PROG_RP_ID" disabled="disabled">
				</div>
			</div>


			<div class="row">
				<div class="col-md-12 text-right btnContainer">
					<button class="btn btn-xs fr tent_btn" type="submit" name="submit">Submit</button>
				</div>
			</div>

		</div>




		<!-- <input type="submit" value="submit"> -->

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
	    	jq("#RCP_TYPEId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#RCP_TYPE_RP_ID").removeAttr("disabled");
	            	jq("#RCP_TYPE_RP_ID").focus();
	            } else {
	            	jq("#RCP_TYPE_RP_ID").attr("disabled", "disabled");
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
	            } else {
	            	jq("#RCP_TYPE_WPLAN_RP_ID").attr("disabled", "disabled");
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
	            } else {
	            	jq("#RCP_RCVR_RP_ID").attr("disabled", "disabled");
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
	            } else {
	            	jq("#RCP_RCVR_WPLAN_RP_ID").attr("disabled", "disabled");
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
	            } else {
	            	jq("#HW_TYPE_RP_ID").attr("disabled", "disabled");
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
	            } else {
	            	jq("#PLATFORM_RP_ID").attr("disabled", "disabled");
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
	            } else {
	            	jq("#CORE_PROG_RP_ID").attr("disabled", "disabled");
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
	            } else {
	            	jq("#PROG_CLASS_ANY_RP_ID").attr("disabled", "disabled");
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
	            } else {
	            	jq("#PROG_CLASS_ALL_RP_ID").attr("disabled", "disabled");
	            }
	        });
	    });
	</script>
	
	<script type="text/javascript">
	    jq(function () {
	    	jq("#CUSTOM_PROGId").click(function () {
	            if (jq(this).is(":checked")) {
	            	jq("#CUSTOM_PROG_RP_ID").removeAttr("disabled");
	            	jq("#CUSTOM_PROG_RP_ID").focus();
	            } else {
	            	jq("#CUSTOM_PROG_RP_ID").attr("disabled", "disabled");
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
	
	if (document.getElementById("PLATFORMId").checked) {
		document.getElementById('PLATFORMIdHidden').disabled = true;
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

	if (document.getElementById("CUSTOM_PROGId").checked) {
		document.getElementById('CUSTOM_PROGIdhidden').disabled = true;
	}
	
	</script>

</body>
</html>
