package org.framework.userwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.userwebapp.dao.UserDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		UserDao dao = new UserDao();
		if (req.getSession().getAttribute("u") != null) {
			dao.deleteUserById(id);
			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><h1>Your Account is Deleted </h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
			req.getSession().invalidate();
		} else {
			resp.sendRedirect("login.jsp");
		}
	}
}
