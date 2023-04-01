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
		if (u != null){
	%>
	<h1>Your Details are displayed Below</h1>
	<h2>
		Id:<%=u.getId() %></h2>
	<h2>
		Name:<%=u.getName() %></h2>
	<h2>
		Age:<%=u.getAge() %></h2>
	<h2>
		Phone:<%=u.getPhone() %></h2>
	<%
		}else
			response.sendRedirect("login.jsp");
	%>
</body>
</html>