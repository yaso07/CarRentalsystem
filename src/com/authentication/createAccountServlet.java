package com.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 

/**
 * Servlet implementation class createAccountServlet
 */
@WebServlet("/createAccountServlet")
public class createAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Integer id=Integer.parseInt(req.getParameter("name"));
		 
		 res.sendRedirect("membersContent/memberspage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String username=req.getParameter("username");
		 String password=req.getParameter("password");
		 userdetails details=new userdetails();
		 details.setUsername(username);
		 details.setPassword(password);
		 HttpSession session=req.getSession();
		 session.setAttribute("username", username);
		 session.setAttribute("password",password);
	     RequestDispatcher dis=req.getRequestDispatcher("UserdetailsPage.jsp");
	     dis.forward(req, res);
		 
		 
		 
	}

}
