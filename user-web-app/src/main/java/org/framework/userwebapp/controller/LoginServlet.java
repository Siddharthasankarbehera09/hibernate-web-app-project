package org.framework.userwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.framework.userwebapp.dao.UserDao;
import org.framework.userwebapp.dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phone= Long.parseLong(req.getParameter("ph"));
		String password= req.getParameter("ps");
		UserDao dao= new UserDao();
		User user= dao.verifyUser(phone, password);
		RequestDispatcher dispatcher=null;
		PrintWriter writer= resp.getWriter();
		if(user!=null) {
			dispatcher= req.getRequestDispatcher("home.jsp");
			HttpSession session= req.getSession();
			session.setAttribute("u", user);
			dispatcher.forward(req, resp);
		}
		else {
			writer.write("<html><body><h1>Invalid Phone-Number or Password</h1></body></html>");
			dispatcher= req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
}
