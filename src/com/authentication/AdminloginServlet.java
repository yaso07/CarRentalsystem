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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class AdminloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminloginServlet() {
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
		 String type=req.getParameter("options");
		 HttpSession session1=req.getSession();
		 session1.setAttribute("username",username);
		 Boolean valid;
		 try {
			
			if(type.equals("admin"))
			 {
				 valid=adminUserValidation.validation(username,password,type);
				if(valid==true)
				{
				 res.sendRedirect("addcarpage.jsp");
				}
				else
				{
					    PrintWriter out=res.getWriter();
		 			    out.print("<p id=\"invalid\" style=\"position: relative;top:50px;left:40%;color:red\"  >Invalid Username or Password</p>");  
		 		        RequestDispatcher rd=req.getRequestDispatcher("adminlogin.jsp");  
		 		        rd.include(req, res);  
				}
			 }
			else
			{
				 valid=adminUserValidation.validation(username,password,type);
				 if(valid==true)
					{
					 res.sendRedirect("addcarpage.jsp");
					}
					else
					{
						 PrintWriter out=res.getWriter();
			 			  out.print("<p style=\"position: relative;top:50px;left:40%;color:red\"  >Invalid Username or Password</p>");  
			 		        RequestDispatcher rd=req.getRequestDispatcher("adminlogin.jsp");  
			 		        rd.include(req, res);  
					}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
