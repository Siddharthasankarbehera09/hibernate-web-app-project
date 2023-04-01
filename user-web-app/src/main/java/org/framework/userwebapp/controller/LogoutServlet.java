package org.framework.userwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		PrintWriter writer= resp.getWriter();
		writer.write("<html><body><h2>You are Logged Out</h2></body></html>");
		RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
}
