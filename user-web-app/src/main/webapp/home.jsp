<%@page import="org.framework.userwebapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	User u = (User) session.getAttribute("u");
	if (u != null) {
	%>
	<h2>
		Hello Mr.<%=u.getName()%>
		Welcome To MY Application
	</h2>
	<h3>
		<a href="edit.jsp">Edit Your Details</a>
	</h3>
	
	<h3>
		<a href="delete?id=<%=u.getId()%>">Delete Your Details</a>
	</h3>
	
	<h3>
		<a href="viewUser.jsp">View Your Details</a>
	</h3>
	
	<h3>
		<a href="logout">Logout</a>
	</h3>
	<%
	} else {
	response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>