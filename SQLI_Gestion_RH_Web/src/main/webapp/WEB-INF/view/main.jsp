<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8" />
<title><spring:message code="menu.home" /></title>
<link
	href="${pageContext.request.contextPath}/resources/css/main_style.css"
	rel="stylesheet" />

</head>
<body>
	<%@include file="header"%>

	<div id="bodydiv">
		<h2>
			Bienvenue :
			<sec:authentication property="principal.username" />
		</h2>
		<br />
		<sec:authorize ifAllGranted='ROLE_ADMIN'>
			<h3>Admin access !</h3>
			<br />
		</sec:authorize>
		<sec:authorize ifAllGranted='ROLE_USER'>
			<h3>Manager access !</h3>
			<br />
		</sec:authorize>
		<p>
			<a href="j_spring_security_logout">Logout</a>
		</p>
	</div>

</body>
</html>