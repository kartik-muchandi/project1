package com.wild_tour.servlet;

import java.io.IOException;
import com.wild_tour.dao.UserDAO;
import com.wild_tour.dao.UserDAOImpl;
import com.wild_tour.dto.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO udao=new UserDAOImpl();
		User u=udao.getUser(Long.parseLong(req.getParameter("phone")),req.getParameter("email"));
		if(u!=null) {
			if(req.getParameter("password").equals(req.getParameter("cpassword"))) {
				u.setPassword(req.getParameter("password"));
				
			if(udao.updateUser(u)) {
				req.setAttribute("success", "Password updated Successfully");
				RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
				rd.forward(req, resp);
				
			}
			else {
				req.setAttribute("error", "Fail to update Password");
				RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
				rd.forward(req, resp);
				
			}
			}
			else {
				req.setAttribute("error", "mismatch");
				RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
				rd.forward(req, resp);
			}
			}
			else {
				req.setAttribute("error", "user not found");
				RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
				rd.forward(req, resp);
				
			}
			
		}
	
	}


