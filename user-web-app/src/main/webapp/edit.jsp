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
	<form action="edit" method="post">
	Id<input type="number" name="id" value="<%=u.getId() %>" readonly="readonly"><br>
	Name<input type="text" name="nm" value="<%=u.getName() %>"><br>
	Age<input type="number" name="age" value="<%=u.getAge() %>"><br>
	Phone<input type="tel" name="ph" value="<%=u.getPhone() %>"><br>
	Password<input type="password" name="ps" value="<%=u.getPassword() %>"><br>
	<input type="text" value="Update">
	</form>
	<%} else
		response.sendRedirect("login.jsp");%>
</body>
</html>