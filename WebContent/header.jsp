<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>

<style>
.header_bar {
	background: #fff;
	width: 100%;
	padding: 10px 3px 15px 10px;
}
/********Menu style *********/
.clr {
	clear: both;
}

.flt {
	float: left;
}

.flr {
	float: right;
}

body {
	min-width: 320px;
	max-width: 1000px;
	margin: 0 auto;
}

.top_menu {
	margin: 10px 0 10px -5px;
	position: relative;
}

.top_menu ul li {
	float: left;
	margin: 0 5px;
	padding: 0;;
	width: 130px;
	color: #fff;
	background-image: url(./images/icons/down_arrow.png);
	background-repeat: no-repeat;
	background-position: 92% 18px;
	cursor: pointer;
	position: relative;
}

.top_menu ul li img {
	margin: 0 5px 0 10px;
}

.home_menu {
	background: #17a2d6;
	background-image: none !important;
}

.patnrs_menu {
	background: #13a75e;
	background-image: none !important;
}

.board_menu {
	background: #b05e9d;
}

.report_menu {
	background: #e39344;
	background-image: none !important;
}

.mngmnt_menu {
	background: #d83949;
	background-image: none !important;
}

.quick_menu {
	float: right;
	margin: -1px 0px 0 0;
}

.top_menu ul li .top_submenu li {
	background-image: none;
	color: #fff;
	padding: 15px 0;
	width: auto;
}

.top_submenu li span {
	border-right: 1px solid #fff;
	padding: 5px 7px;
}

.top_submenu {
	position: absolute;
	width: 100%;
	padding: 0;
	left: 0;;
	top: 44px;
}

.srch_box {
	border: 1px solid #17a2d6;
	width: 75px;
	float: left;
	height: 25px;
	margin: 0 5px 0 0;
	position: relative;
	right: -25px;
	z-index: 1;
	padding: 0 25px 0 5px; /* top:6px; */
}

#srchIcon {
	cursor: pointer;
	position: relative;
	z-index: 9;
	right: 4px;
	bottom: 1px;
}

.logout {
	cursor: pointer;
}

#myform {
	display: inline;
}

.notify {
	margin-right: 8px;
	cursor: pointer;
}

.top_submenu .last-child span {
	border: none !important;
}

.prof_init {
	position: relative;
}

.initialDrop {
	display: none;
	position: absolute;
	top: 52px;
	right: 0px;
	border: 1px solid #ccc;
	background: #fff;
	width: 13.6em;
	z-index: 9;
}

.showDrop {
	display: block;
}

.initialDrop li {
	list-style: none;
}

.initialDrop li a {
	padding: 12px 10px;
	display: block;
}

.initialDrop li a:focus, .initialDrop li a:hover {
	text-decoration: none;
}

.license_mngr {
	background: coral;
	background-image: none !important;
	height: 44px;
	padding: 5px 0 0 13px !important;
}

@media only screen and (max-width : 767px) {
	.plus_bdr img {
		width: 24px;
	}
	.top_menu ul li {
		float: none;
		width: 101%;
		background-position: 98% 18px;
		position: relative;
		height: auto !important;
		z-index: 9;
	}
	/* .logout,.prof_init{display:none;} */
	.top_menu ul {
		margin: 30px 5px 0 0px;
		display: none;
	}
	.top_menu ul li {
		margin: 0;
	}
	.top_menu {
		position: absolute;
		width: 100%;
		margin: 10px 0 0 0px;
	}
	.top_submenu {
		margin-top: 0 !important;
		width: 100%;
		position: static;
		padding-left: 0;
	}
	.top_submenu li span {
		border-right: none;
	}
}

@media only screen and (max-width : 767px) {
}

@media only screen and (max-width : 767px) {
	.defaultImage {
		padding: 6px 0;
	}
	.srch_box {
		right: 165px !important;
		top: 62px !important;
		position: absolute !important;
	}
	#srchIcon {
		float: left;
		top: 55px;
		right: 170px !important;
	}
	.menuTog {
		display: block;
		float: left;
		margin-top: 50px;
		cursor: pointer;
		z-index: 9;
		position: relative;
	}
	.gearIcon {
		display: none;
		float: left;
		margin: 50px 0 0 10px;
	}

	/*.container{min-width:97.4%;}*/
	.notify {
		position: absolute;
		top: 56px;
		right: 35px;
		border: none;
	}
	.user_prof {
		border-radius: 15px;
		font-size: 15px;
		height: 30px;
		padding: 6px 0;
		width: 30px;
	}
	.user_initial {
		font-size: 11px;
	}
	.initialDrop {
		top: 33px;
	}
	/* .quick_menu{display: block;position: absolute;top:0;right:32px;} */
	.mL25 {
		margin-left: -25px;
	}

	/* .plus_bdr{display:none;} */
	/* .plus_icon{display:block;} */
}

.top_menu li a {
	color: #fff;
	padding: 10px 0;
	display: block;
}

.top_menu li li a {
	padding: 0;
}

.top_menu li a:focus, .top_menu li a:hover {
	text-decoration: none;
}

.notify img {
	border-radius: 20px
}

.report_menu a, .noLink {
	cursor: default !important;
}
</style>


<!-- mainpanel starts here-->
<div class="mainpanel TPRM_bg">
	
	<div class="header_bar">
		<!-- <img src="images/TP_logo.png" class="mL25" alt="logo" border=0 /> -->
	</div>

	<!-- headerbar ends here-->
	<!--- Menus starts here -->
	<div class="top_menu">
		<div>
			<li class="mngmnt_menu top_menu_ul"><a>Bell TV: Promotion</a></li>
		</div>

	</div>
	<!--- Menus ends here -->

<div></div>
	<script
		src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/tprmDT.js"></script>
	