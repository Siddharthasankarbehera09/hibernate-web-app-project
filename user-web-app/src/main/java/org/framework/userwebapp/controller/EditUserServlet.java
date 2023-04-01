package org.framework.userwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.userwebapp.dao.UserDao;
import org.framework.userwebapp.dto.User;

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		long phone = Long.parseLong(req.getParameter("ph"));
		String password = req.getParameter("ps");
		int age = Integer.parseInt(req.getParameter("age"));
		String name = req.getParameter("nm");
		UserDao dao = new UserDao();
		User u = new User();
		u.setId(id);
		u.setAge(age);
		u.setName(name);
		u.setPassword(password);
		u.setPhone(phone);
		u = dao.updateUser(u);
		PrintWriter writer = resp.getWriter();
		writer.write("<html><body><h1>Your Details are Updated with ID: " + u.getId() + "</h1></body></html>");
	}
}
