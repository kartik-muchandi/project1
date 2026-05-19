package com.wild_tour.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;




import java.io.IOException;

import com.wild_tour.dao.UserDAO;
import com.wild_tour.dao.UserDAOImpl;
import com.wild_tour.dto.User;






@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession session=req.getSession(false);
	   User u1=(User)session.getAttribute("user");
	   u1.setUser_name(req.getParameter("name"));
	   u1.setPhone(Long.parseLong(req.getParameter("phone")));
	   u1.setEmail(req.getParameter("email"));
	   u1.setAddress(req.getParameter("address"));
	   if(req.getParameter("password").equals(req.getParameter("cpassword"))) {
		   u1.setPassword(req.getParameter("password"));
	   }
	   
	   UserDAO udao=new UserDAOImpl();
	   if(udao.updateUser(u1)) {
		   req.setAttribute("success", "updated successfully");
		   RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
		   rd.forward(req, resp);
	   }
	   else {
		   req.setAttribute("fail", "fail to update");
		   RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
		   rd.forward(req, resp);
	   }
	   
	}

}
