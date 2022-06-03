package com.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

           String username=req.getParameter("username");
           String password=req.getParameter("password");
           res.setContentType("text/html");
           try {
			Boolean valid=adminUserValidation.uservalidation(username,password);
			 if(valid==true)
		           { 
				      
				 if(username.equals("yaso") && password.equals("yaso4456"))
		             {
		        	    HttpSession session=req.getSession();  
			            session.setAttribute("name",username); 
		        	    res.sendRedirect("adminfirstpage.jsp");
		             }
		           else if(password.equals(username+"@reset"))
		           {
		        	   HttpSession sess =req.getSession();
		        	   sess.setAttribute("username",username);
		        	   res.sendRedirect("resetPassword.jsp");
		           }
		           else
		           {
		        	  res.sendRedirect("UserFirstpage.jsp");  
		        	  HttpSession session=req.getSession();  
		              session.setAttribute("name",username);  
		           }
	           }
			 else
			 {
				 PrintWriter out=res.getWriter();
	 			  out.print("<p style=\"position: relative;top:50px;left:40%;color:red\"  >Invalid Username or Password</p>");  
	 		        RequestDispatcher rd=req.getRequestDispatcher("userlogin.jsp");  
	 		        rd.include(req, res);  
			 }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
	}

}
